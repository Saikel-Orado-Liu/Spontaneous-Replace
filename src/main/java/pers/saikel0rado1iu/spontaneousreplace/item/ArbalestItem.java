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
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import pers.saikel0rado1iu.silk.api.base.common.util.TickUtil;
import pers.saikel0rado1iu.silk.api.generate.advancement.criterion.Criteria;
import pers.saikel0rado1iu.silk.api.generate.advancement.criterion.RangedKilledEntityCriterion;
import pers.saikel0rado1iu.silk.api.ropestick.ranged.Crossbow;
import pers.saikel0rado1iu.spontaneousreplace.sound.SoundEvents;

import java.util.Set;

/**
 * <h2 style="color:FFC800">劲弩物品</h2>
 * 一种比普通弩更强的基础远程武器
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
public class ArbalestItem extends Crossbow {
	/**
	 * @param settings 物品设置
	 */
	public ArbalestItem(Settings settings) {
		super(settings);
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
		Criteria.SHOT_PROJECTILE_CRITERION.trigger(serverPlayer, ranged, projectile, EnchantmentHelper.getLevel(Enchantments.MULTISHOT, ranged) > 0 ? 3 : 1);
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
	
	@Override
	protected SoundEvent getQuickChargeSound(int stage) {
		return switch (stage) {
			case 1 -> SoundEvents.ARBALEST_QUICK_CHARGE_1;
			case 2 -> SoundEvents.ARBALEST_QUICK_CHARGE_2;
			case 3 -> SoundEvents.ARBALEST_QUICK_CHARGE_3;
			default -> SoundEvents.ARBALEST_LOADING_START;
		};
	}
	
	@Override
	public SoundEvent loadingSound() {
		return SoundEvents.ARBALEST_LOADING_MIDDLE;
	}
	
	@Override
	public SoundEvent loadedSound() {
		return SoundEvents.ARBALEST_LOADING_END;
	}
	
	@Override
	public SoundEvent shootSound() {
		return SoundEvents.ARBALEST_SHOOT;
	}
	
	@Override
	public float maxDamage() {
		return super.maxDamage() * 1.5F;
	}
	
	@Override
	public float maxProjectileSpeed() {
		return 4.5F;
	}
	
	@Override
	public float fovScaling() {
		return 1.16F;
	}
	
	@Override
	public int maxUseTicks() {
		return TickUtil.getTick(1);
	}
}
