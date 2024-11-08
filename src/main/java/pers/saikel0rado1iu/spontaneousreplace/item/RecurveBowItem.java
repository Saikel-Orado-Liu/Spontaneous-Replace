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
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import pers.saikel0rado1iu.silk.api.generate.advancement.criterion.Criteria;
import pers.saikel0rado1iu.silk.api.generate.advancement.criterion.RangedKilledEntityCriterion;
import pers.saikel0rado1iu.silk.api.ropestick.component.DataComponentTypes;
import pers.saikel0rado1iu.silk.api.ropestick.component.type.AdjustFovData;
import pers.saikel0rado1iu.silk.api.ropestick.component.type.AdjustFovWhileUseComponent;
import pers.saikel0rado1iu.silk.api.ropestick.component.type.ModifyMoveWhileUseComponent;
import pers.saikel0rado1iu.silk.api.ropestick.component.type.RangedWeaponComponent;
import pers.saikel0rado1iu.silk.api.ropestick.ranged.BowLikeItem;

import java.util.Optional;

/**
 * <h2 style="color:FFC800">反曲弓物品</h2>
 * 一种性能更优良的基础远程武器
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
public class RecurveBowItem extends BowLikeItem {
	/**
	 * @param settings 物品设置
	 */
	public RecurveBowItem(Settings settings) {
		super(settings
				.component(DataComponentTypes.ADJUST_FOV_WHILE_USE, AdjustFovWhileUseComponent.create(false, Optional.empty(), false, AdjustFovData.BOW_FOV_SCALING * 2 - 1))
				.component(DataComponentTypes.MODIFY_MOVE_WHILE_USE, ModifyMoveWhileUseComponent.of(0.5F)));
	}
	
	@Override
	public RangedWeaponComponent rangedWeapon(Optional<ItemStack> stack) {
		int pull = stack.filter(value -> EnchantmentHelper.getLevel(Enchantments.QUICK_CHARGE, value) > 0).map(value -> (int) (RangedWeaponComponent.BOW_MAX_PULL_TICKS * 0.25)).orElseGet(() -> (int) (RangedWeaponComponent.BOW_MAX_PULL_TICKS * 0.75));
		return RangedWeaponComponent.builder()
				.maxSpeed(4)
				.maxDamage(RangedWeaponComponent.BOW_MAX_DAMAGE * 1.5F)
				.maxUseTicks(RangedWeaponComponent.BOW_MAX_USE_TICKS)
				.maxPullTicks(pull)
				.firingError(RangedWeaponComponent.DEFAULT_FIRING_ERROR)
				.defaultProjectile(Items.ARROW.getDefaultStack())
				.launchableProjectiles(ImmutableList.of(
						Items.ARROW,
						Items.SPECTRAL_ARROW,
						Items.TIPPED_ARROW))
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
}
