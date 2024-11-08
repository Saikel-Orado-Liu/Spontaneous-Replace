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

import com.google.common.collect.ImmutableList;
import net.minecraft.component.ComponentMap;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import pers.saikel0rado1iu.silk.api.base.common.util.TickUtil;
import pers.saikel0rado1iu.silk.api.generate.advancement.criterion.Criteria;
import pers.saikel0rado1iu.silk.api.generate.advancement.criterion.RangedKilledEntityCriterion;
import pers.saikel0rado1iu.silk.api.ropestick.component.DataComponentTypes;
import pers.saikel0rado1iu.silk.api.ropestick.component.type.AdjustFovWhileHoldComponent;
import pers.saikel0rado1iu.silk.api.ropestick.component.type.RangedWeaponComponent;
import pers.saikel0rado1iu.silk.api.ropestick.ranged.CrossbowLikeItem;
import pers.saikel0rado1iu.spontaneousreplace.sound.SoundEvents;

import java.util.Optional;

/**
 * <h2 style="color:FFC800">劲弩物品</h2>
 * 一种比普通弩更强的基础远程武器
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
public class ArbalestItem extends CrossbowLikeItem {
	/**
	 * @param settings 物品设置
	 */
	public ArbalestItem(Settings settings) {
		super(settings);
	}
	
	@Override
	public ComponentMap dynamicComponents(ItemStack stack) {
		return ComponentMap.builder()
				.addAll(super.dynamicComponents(stack))
				.add(DataComponentTypes.ADJUST_FOV_WHILE_HOLD, AdjustFovWhileHoldComponent
						.create(false,
								Optional.empty(),
								false,
								1.16F)
						.setCanAdjust(CrossbowItem.isCharged(stack)))
				.build();
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
	public RangedWeaponComponent rangedWeapon(Optional<ItemStack> stack) {
		return RangedWeaponComponent.builder()
				.maxSpeed(4.5F)
				.maxDamage(RangedWeaponComponent.CROSSBOW_MAX_DAMAGE * 1.5F)
				.maxUseTicks(TickUtil.getTick(1))
				.maxPullTicks(TickUtil.getTick(1))
				.firingError(RangedWeaponComponent.DEFAULT_FIRING_ERROR)
				.defaultProjectile(Items.ARROW.getDefaultStack())
				.launchableProjectiles(ImmutableList.of(
						Items.ARROW,
						Items.SPECTRAL_ARROW,
						Items.TIPPED_ARROW,
						Items.FIREWORK_ROCKET))
				.build();
	}
}
