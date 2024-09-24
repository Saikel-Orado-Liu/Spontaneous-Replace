/*
 * MIT License
 *
 * Copyright (c) 2023 GameGeek-Saikel
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package pers.saikel0rado1iu.spontaneousreplace.item;

import com.google.common.collect.ImmutableSet;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.thrown.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;
import pers.saikel0rado1iu.silk.api.base.common.util.TickUtil;
import pers.saikel0rado1iu.silk.api.generate.advancement.criterion.Criteria;
import pers.saikel0rado1iu.silk.api.generate.advancement.criterion.RangedKilledEntityCriterion;
import pers.saikel0rado1iu.silk.api.ropestick.property.CustomEnchantment;
import pers.saikel0rado1iu.silk.api.ropestick.property.ItemProperties;
import pers.saikel0rado1iu.silk.api.ropestick.property.ItemProperty;
import pers.saikel0rado1iu.silk.api.ropestick.ranged.Bow;
import pers.saikel0rado1iu.spontaneousreplace.entity.projectile.StoneballEntity;
import pers.saikel0rado1iu.spontaneousreplace.sound.SoundEvents;

import java.util.Set;

import static net.minecraft.item.Items.*;

/**
 * <h2 style="color:FFC800">丫弹弓物品</h2>
 * 添加一种娱乐性质的远程武器
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
public class SlingshotItem extends Bow implements ItemProperties {
	/**
	 * @param settings 物品设置
	 */
	public SlingshotItem(Settings settings) {
		super(settings);
	}
	
	private static ThrownItemEntity getThrownItemEntity(World world, LivingEntity user, ItemStack useProjectile) {
		ThrownItemEntity thrownItemEntity;
		// 获取弹丸实体
		if (useProjectile.isOf(EGG)) thrownItemEntity = new EggEntity(world, user);
		else if (useProjectile.isOf(SNOWBALL)) thrownItemEntity = new SnowballEntity(world, user);
		else if (useProjectile.isOf(ENDER_PEARL)) thrownItemEntity = new EnderPearlEntity(world, user);
		else if (useProjectile.isOf(LINGERING_POTION)) {
			thrownItemEntity = new PotionEntity(world, user);
			thrownItemEntity.setItem(useProjectile);
		} else if (useProjectile.isOf(SPLASH_POTION)) {
			thrownItemEntity = new PotionEntity(world, user);
			thrownItemEntity.setItem(useProjectile);
		} else thrownItemEntity = new StoneballEntity(world, user);
		return thrownItemEntity;
	}
	
	@Override
	public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
		// 检查用户使用者是否为玩家
		if (!(user instanceof PlayerEntity player)) return;
		
		// 检查是否在创造模式或者拥有“无限”附魔
		boolean inCreateOrInfinity = player.getAbilities().creativeMode || EnchantmentHelper.getLevel(Enchantments.INFINITY, stack) > 0;
		// 获取弹丸
		ItemStack useProjectile = getProjectileType(user, stack);
		// 检查玩家是否有箭，如果没有箭但在创造模式或者拥有“无限”附魔则使用默认弹丸
		if (!useProjectile.isEmpty() || inCreateOrInfinity) if (useProjectile.isEmpty()) useProjectile = new ItemStack(defaultProjectile());
		if (useProjectile.isEmpty() && !inCreateOrInfinity) return;
		
		// 获取弓已使用游戏刻
		int usedTicks = getMaxUseTime(stack) - remainingUseTicks;
		// 获取弓拉弓进度
		float pullProgress = getUsingProgress(usedTicks, stack);
		// 如果拉弓进度小于 0.1
		if (pullProgress < 0.1) return;
		
		// 如果在创造模式或者拥有“无限”附魔以及弹丸是默认弹丸
		boolean andDefaultProjectile = inCreateOrInfinity && useProjectile.isOf(defaultProjectile());
		if (!world.isClient) {
			ThrownItemEntity thrownItemEntity = getThrownItemEntity(world, user, useProjectile);
			// 设置弹丸速度
			thrownItemEntity.setVelocity(player, player.getPitch(), player.getYaw(), 0, pullProgress * maxProjectileSpeed(), 1);
			
			// 设置“力量”效果
			int powerLevel = EnchantmentHelper.getLevel(Enchantments.POWER, stack);
			if (powerLevel > 0) {
				float addSpeed = (float) (powerLevel * 0.2 + 1);
				thrownItemEntity.setVelocity(player, player.getPitch(), player.getYaw(), 0, pullProgress * maxProjectileSpeed() * addSpeed, 1);
			}
			
			// 设置“冲击”效果
			int punchLevel = EnchantmentHelper.getLevel(Enchantments.PUNCH, stack);
			if (punchLevel > 0 && thrownItemEntity instanceof StoneballEntity stoneball) stoneball.setPunchLevel(punchLevel, thrownItemEntity.getVelocity());
			
			// 设置工具损伤
			stack.damage(1, player, p -> p.sendToolBreakStatus(player.getActiveHand()));
			
			// 生成弹丸实体
			world.spawnEntity(thrownItemEntity);
			if (player instanceof ServerPlayerEntity serverPlayer) triggerCriteria(serverPlayer, stack, thrownItemEntity);
		}
		
		// 播放音效
		world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.SLINGSHOT_THROW, SoundCategory.PLAYERS, 1, 1 / (world.getRandom().nextFloat() * 0.4F + 1.2F) + pullProgress * 0.3F);
		if (!andDefaultProjectile && !player.getAbilities().creativeMode) {
			useProjectile.decrement(1);
			if (useProjectile.isEmpty()) player.getInventory().removeOne(useProjectile);
		}
		
		player.incrementStat(Stats.USED.getOrCreateStat(this));
	}
	
	/**
	 * 属性方法
	 *
	 * @return 物品属性集合
	 */
	@Override
	public Set<ItemProperty> properties() {
		// 丫弹弓可用附魔：
		// 无限、力量(提升 100%+等级*20% 的弹丸速度)、击退(只对石弹有效)、耐久、消失诅咒、经验修补
		return ImmutableSet.of(new CustomEnchantment(
				Enchantments.INFINITY,
				Enchantments.POWER,
				Enchantments.PUNCH,
				Enchantments.UNBREAKING,
				Enchantments.VANISHING_CURSE,
				Enchantments.MENDING));
	}
	
	/**
	 * 触发进度条件
	 *
	 * @param serverPlayer 服务端玩家
	 * @param ranged       远程武器物品堆栈
	 * @param projectile   发射物
	 */
	@Override
	public void triggerCriteria(ServerPlayerEntity serverPlayer, ItemStack ranged, ProjectileEntity projectile) {
		RangedKilledEntityCriterion.setRangedWeapon(projectile, ranged);
		Criteria.SHOT_PROJECTILE_CRITERION.trigger(serverPlayer, ranged, projectile, 1);
	}
	
	/**
	 * 设置发射物索引以供 JSON 渲染使用
	 *
	 * @param stack         物品堆栈
	 * @param useProjectile 使用的发射物
	 */
	@Override
	public void setProjectileIndex(ItemStack stack, ItemStack useProjectile) {
		NbtCompound nbtCompound = stack.getOrCreateNbt();
		nbtCompound.putFloat(PROJECTILE_INDEX_KEY, 0);
		if (useProjectile == null) return;
		if (useProjectile.isOf(Items.STONEBALL)) nbtCompound.putFloat(PROJECTILE_INDEX_KEY, 0);
		else if (useProjectile.isOf(EGG)) nbtCompound.putFloat(PROJECTILE_INDEX_KEY, 0.1F);
		else if (useProjectile.isOf(SNOWBALL)) nbtCompound.putFloat(PROJECTILE_INDEX_KEY, 0.2F);
		else if (useProjectile.isOf(ENDER_PEARL)) nbtCompound.putFloat(PROJECTILE_INDEX_KEY, 0.3F);
		else if (useProjectile.isOf(SPLASH_POTION)) nbtCompound.putFloat(PROJECTILE_INDEX_KEY, 0.4F);
		else if (useProjectile.isOf(LINGERING_POTION)) nbtCompound.putFloat(PROJECTILE_INDEX_KEY, 0.5F);
	}
	
	/**
	 * 获取发射物索引以供 JSON 渲染使用
	 *
	 * @param stack 物品堆栈
	 * @return 索引
	 */
	@Override
	public float getProjectileIndex(ItemStack stack) {
		NbtCompound nbtCompound = stack.getNbt();
		return nbtCompound != null ? nbtCompound.getFloat(PROJECTILE_INDEX_KEY) : 0;
	}
	
	/**
	 * 获取发射物索引以供 JSON 渲染使用
	 *
	 * @param projectile 发射物
	 * @return 索引
	 */
	@Override
	public float getProjectileIndex(Item projectile) {
		if (projectile == Items.STONEBALL) return 0;
		else if (projectile == EGG) return 0.1F;
		else if (projectile == SNOWBALL) return 0.2F;
		else if (projectile == ENDER_PEARL) return 0.3F;
		else if (projectile == SPLASH_POTION) return 0.4F;
		else if (projectile == LINGERING_POTION) return 0.5F;
		return 0;
	}
	
	/**
	 * 默认的发射物
	 *
	 * @return 发射物物品堆栈
	 */
	@Override
	public Item defaultProjectile() {
		return Items.STONEBALL;
	}
	
	/**
	 * 获取远程武器能发射的所有的发射物
	 *
	 * @return 发射物集合
	 */
	@Override
	public Set<Item> launchableProjectiles() {
		return ImmutableSet.of(Items.STONEBALL, EGG, SNOWBALL, ENDER_PEARL, LINGERING_POTION, SPLASH_POTION);
	}
	
	@Override
	public int maxPullTicks() {
		return TickUtil.getTick(0.5F);
	}
	
	@Override
	public float maxProjectileSpeed() {
		return 2;
	}
	
	@Override
	public float moveSpeedMultiple() {
		return 1;
	}
}
