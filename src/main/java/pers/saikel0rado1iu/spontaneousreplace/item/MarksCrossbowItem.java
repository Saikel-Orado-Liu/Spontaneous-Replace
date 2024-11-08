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
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.UseAction;
import pers.saikel0rado1iu.silk.api.base.common.util.TickUtil;
import pers.saikel0rado1iu.silk.api.generate.advancement.criterion.Criteria;
import pers.saikel0rado1iu.silk.api.generate.advancement.criterion.RangedKilledEntityCriterion;
import pers.saikel0rado1iu.silk.api.ropestick.component.DataComponentTypes;
import pers.saikel0rado1iu.silk.api.ropestick.component.type.*;
import pers.saikel0rado1iu.silk.api.ropestick.ranged.BoltActionFirearmItem;
import pers.saikel0rado1iu.spontaneousreplace.sound.SoundEvents;

import java.util.Optional;

/**
 * <h2 style="color:FFC800">神臂弩</h2>
 * 一种极大威力的超远程攻击武器
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
public class MarksCrossbowItem extends BoltActionFirearmItem {
	/**
	 * @param settings 物品设置
	 */
	public MarksCrossbowItem(Settings settings) {
		super(settings.component(DataComponentTypes.ENCHANTMENT_TRAITS, EnchantmentTraitsComponent.of(
				Enchantments.PIERCING,
				Enchantments.QUICK_CHARGE,
				Enchantments.UNBREAKING,
				Enchantments.VANISHING_CURSE,
				Enchantments.MENDING)));
	}
	
	@Override
	public ComponentMap dynamicComponents(ItemStack stack) {
		return ComponentMap.builder()
				.addAll(super.dynamicComponents(stack))
				.add(DataComponentTypes.ADJUST_FOV_WHILE_HOLD, AdjustFovWhileHoldComponent
						.create(true,
								Optional.of(AdjustFovData.SPYGLASS_SCOPE),
								false,
								1.9F)
						.setCanAdjust(CrossbowItem.isCharged(stack)))
				.add(DataComponentTypes.MODIFY_MOVE_WHILE_USE, ModifyMoveWhileUseComponent.of(0))
				.add(DataComponentTypes.MODIFY_MOVE_WHILE_HOLD, ModifyMoveWhileHoldComponent
						.of(0)
						.setModify(CrossbowItem.isCharged(stack)))
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
		Criteria.SHOT_PROJECTILE_CRITERION.trigger(serverPlayer, ranged, projectile, 1);
	}
	
	@Override
	protected SoundEvent getQuickChargeSound(int stage) {
		if (stage == 1) return SoundEvents.MARKS_CROSSBOW_QUICK_CHARGE_1;
		else if (stage == 2) return SoundEvents.MARKS_CROSSBOW_QUICK_CHARGE_2;
		else if (stage >= 3) return SoundEvents.MARKS_CROSSBOW_QUICK_CHARGE_3;
		else return SoundEvents.MARKS_CROSSBOW_LOADING_START;
	}
	
	@Override
	public SoundEvent loadingSound() {
		return SoundEvents.MARKS_CROSSBOW_LOADING_MIDDLE;
	}
	
	@Override
	public SoundEvent loadedSound() {
		return SoundEvents.MARKS_CROSSBOW_LOADING_END;
	}
	
	@Override
	public SoundEvent shootSound() {
		return SoundEvents.MARKS_CROSSBOW_SHOOT;
	}
	
	@Override
	public RangedWeaponComponent rangedWeapon(Optional<ItemStack> stack) {
		return RangedWeaponComponent.builder()
				.maxSpeed(15)
				.maxDamage(RangedWeaponComponent.CROSSBOW_MAX_DAMAGE)
				.maxUseTicks(TickUtil.getTick(10))
				.maxPullTicks(TickUtil.getTick(10))
				.firingError(0.05F)
				.defaultProjectile(Items.STEEL_ARROW.getDefaultStack())
				.launchableProjectiles(ImmutableList.of(Items.STEEL_ARROW))
				.build();
	}
	
	@Override
	public ProjectileContainerComponent projectileContainer(Optional<ItemStack> stack) {
		return ProjectileContainerComponent.of(1);
	}
	
	@Override
	public ShootProjectilesComponent shootProjectiles(Optional<ItemStack> stack) {
		return ShootProjectilesComponent.create(0, ShootProjectilesComponent.State.ALL);
	}
	
	@Override
	public int getRange() {
		return super.getRange() * 5;
	}
	
	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.BOW;
	}
}
