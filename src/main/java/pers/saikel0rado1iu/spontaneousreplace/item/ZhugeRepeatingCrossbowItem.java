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
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import pers.saikel0rado1iu.silk.api.base.common.util.TickUtil;
import pers.saikel0rado1iu.silk.api.generate.advancement.criterion.Criteria;
import pers.saikel0rado1iu.silk.api.generate.advancement.criterion.RangedKilledEntityCriterion;
import pers.saikel0rado1iu.silk.api.ropestick.property.CustomEnchantment;
import pers.saikel0rado1iu.silk.api.ropestick.property.ItemProperties;
import pers.saikel0rado1iu.silk.api.ropestick.property.ItemProperty;
import pers.saikel0rado1iu.silk.api.ropestick.ranged.BoltActionRepeatingFirearm;
import pers.saikel0rado1iu.silk.api.ropestick.ranged.ProjectileContainer;
import pers.saikel0rado1iu.silk.api.ropestick.ranged.ShootExpansion;
import pers.saikel0rado1iu.spontaneousreplace.sound.SoundEvents;

import java.util.Set;

/**
 * <h2 style="color:FFC800">诸葛连弩物品</h2>
 * 一种强力的近战连发远程物品
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
public class ZhugeRepeatingCrossbowItem extends BoltActionRepeatingFirearm implements ItemProperties {
	/**
	 * @param settings 物品设置
	 */
	public ZhugeRepeatingCrossbowItem(Settings settings) {
		super(settings);
	}
	
	@Override
	public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
		if (world.isClient()) return;
		if (ProjectileContainer.getChargedAmount(stack) > 0) ShootExpansion.resetShot(stack);
		if (!isCharged(stack) && maxUseTicks == Math.round((float) maxUseTicks() * loadableAmount)) {
			int level = EnchantmentHelper.getLevel(Enchantments.QUICK_CHARGE, stack);
			int useTicks = getMaxUseTime(stack) - remainingUseTicks;
			double pullProgress = getUsingProgress(useTicks, stack);
			if (useTicks != 0 && (pullProgress == 0 || pullProgress == 1)) load(user, stack);
			if (pullProgress < 0.2) {
				charged = false;
				loaded = false;
			} else if (pullProgress > 0.3 && !charged) {
				charged = true;
				world.playSound(null, user.getX(), user.getY(), user.getZ(), getQuickChargeSound(level), SoundCategory.PLAYERS, 1, 1);
			} else if (pullProgress > 0.9 && level == 0 && !loaded) {
				loaded = true;
				world.playSound(null, user.getX(), user.getY(), user.getZ(), loadingSound(), SoundCategory.PLAYERS, 1, 1);
			}
		} else {
			double useTicks = getMaxUseTime(stack) - remainingUseTicks;
			if (useTicks >= getMaxUseTime(stack) || useTicks % shootingInterval() != 0) return;
			shoot(world, user, user.getActiveHand(), stack, getMaxProjectileSpeed(stack), firingError());
		}
	}
	
	/**
	 * 属性方法
	 *
	 * @return 物品属性集合
	 */
	@Override
	public Set<ItemProperty> properties() {
		// 诸葛连弩可用附魔：
		// 多重射击、快速装填、耐久、消失诅咒、经验修补
		return ImmutableSet.of(new CustomEnchantment(
				Enchantments.MULTISHOT,
				Enchantments.QUICK_CHARGE,
				Enchantments.UNBREAKING,
				Enchantments.VANISHING_CURSE,
				Enchantments.MENDING));
	}
	
	/**
	 * 最大发射物容量
	 *
	 * @param stack 需获取的物品堆栈
	 * @return 最大发射物容量
	 */
	@Override
	public int maxCapacity(ItemStack stack) {
		return EnchantmentHelper.getLevel(Enchantments.MULTISHOT, stack) > 0 ? 30 : 10;
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
		if (useProjectile.isOf(Items.ARROW)) nbtCompound.putFloat(PROJECTILE_INDEX_KEY, 0);
		else if (useProjectile.isOf(Items.TIPPED_ARROW)) nbtCompound.putFloat(PROJECTILE_INDEX_KEY, 0.1F);
		else if (useProjectile.isOf(Items.SPECTRAL_ARROW)) nbtCompound.putFloat(PROJECTILE_INDEX_KEY, 0.2F);
		else if (useProjectile.isOf(Items.FIREWORK_ROCKET)) nbtCompound.putFloat(PROJECTILE_INDEX_KEY, 0.3F);
	}
	
	/**
	 * 获取发射物索引以供 JSON 渲染使用
	 *
	 * @param stack 物品堆栈
	 * @return 索引
	 */
	@Override
	public float getProjectileIndex(ItemStack stack) {
		if (!getProjectiles(stack).isEmpty()) {
			ItemStack useProjectile = getProjectiles(stack).get(0);
			if (useProjectile.isOf(Items.ARROW)) return 0;
			else if (useProjectile.isOf(Items.TIPPED_ARROW)) return 0.1F;
			else if (useProjectile.isOf(Items.SPECTRAL_ARROW)) return 0.2F;
			else if (useProjectile.isOf(Items.FIREWORK_ROCKET)) return 0.3F;
		}
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
		if (projectile == Items.ARROW) return 0;
		else if (projectile == Items.TIPPED_ARROW) return 0.1F;
		else if (projectile == Items.SPECTRAL_ARROW) return 0.2F;
		else if (projectile == Items.FIREWORK_ROCKET) return 0.3F;
		return 0;
	}
	
	/**
	 * 默认的发射物
	 *
	 * @return 发射物物品堆栈
	 */
	@Override
	public Item defaultProjectile() {
		return Items.ARROW;
	}
	
	/**
	 * 获取远程武器能发射的所有的发射物
	 *
	 * @return 发射物集合
	 */
	@Override
	public Set<Item> launchableProjectiles() {
		return ImmutableSet.of(Items.ARROW, Items.TIPPED_ARROW, Items.SPECTRAL_ARROW, Items.FIREWORK_ROCKET);
	}
	
	/**
	 * 设置已射击状态
	 *
	 * @return 如果为 {@code true} 则每个发射物发射后都会设置已发射状态<br>
	 * 如果为 {@code false} 则只有当所有发射物都发射后才会设置已发射状态
	 */
	@Override
	public boolean shotState() {
		return true;
	}
	
	/**
	 * 设置射击间隔
	 *
	 * @return 射击间隔，单位为游戏刻
	 */
	@Override
	public int shootingInterval() {
		return TickUtil.getTick(0.25F);
	}
	
	/**
	 * 渲染射击时的粒子效果
	 *
	 * @param world   存档世界
	 * @param shooter 射击者
	 */
	@Override
	public void renderShootingParticle(World world, LivingEntity shooter) {
	}
	
	@Override
	protected SoundEvent getQuickChargeSound(int stage) {
		return SoundEvents.JUGER_REPEATING_CROSSBOW_LOADING_START;
	}
	
	@Override
	public SoundEvent loadingSound() {
		return SoundEvents.JUGER_REPEATING_CROSSBOW_LOADING_MIDDLE;
	}
	
	@Override
	public SoundEvent loadedSound() {
		return SoundEvents.JUGER_REPEATING_CROSSBOW_LOADING_END;
	}
	
	@Override
	public SoundEvent shootSound() {
		return SoundEvents.JUGER_REPEATING_CROSSBOW_SHOOT;
	}
	
	@Override
	public float firingError() {
		return 5;
	}
	
	@Override
	public float maxProjectileSpeed() {
		return 3.5F;
	}
	
	@Override
	public float maxDamage() {
		return super.maxDamage() * 1.25F;
	}
	
	@Override
	public int maxUseTicks() {
		return TickUtil.getTick(1);
	}
	
	@Override
	public int getMaxUseTime(ItemStack stack) {
		if (isCharged(stack) || loadableAmount == 0) return super.getMaxUseTime(stack);
		int aProjectileTime = super.getMaxUseTime(stack) / loadableAmount;
		int level = EnchantmentHelper.getLevel(Enchantments.QUICK_CHARGE, stack);
		int aQuickTime = aProjectileTime / 5;
		return (aProjectileTime - aQuickTime * level) * loadableAmount;
	}
	
	@Override
	public int getRange() {
		return super.getRange() * 2;
	}
}
