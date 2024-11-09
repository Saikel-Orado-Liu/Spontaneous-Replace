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
import net.minecraft.sound.SoundEvent;
import pers.saikel0rado1iu.silk.api.base.common.util.TickUtil;
import pers.saikel0rado1iu.silk.api.generate.advancement.criterion.Criteria;
import pers.saikel0rado1iu.silk.api.generate.advancement.criterion.RangedKilledEntityCriterion;
import pers.saikel0rado1iu.silk.api.ropestick.component.DataComponentTypes;
import pers.saikel0rado1iu.silk.api.ropestick.component.type.EnchantmentTraitsComponent;
import pers.saikel0rado1iu.silk.api.ropestick.component.type.ProjectileContainerComponent;
import pers.saikel0rado1iu.silk.api.ropestick.component.type.RangedWeaponComponent;
import pers.saikel0rado1iu.silk.api.ropestick.component.type.ShootProjectilesComponent;
import pers.saikel0rado1iu.silk.api.ropestick.ranged.BoltActionRepeatingFirearmItem;
import pers.saikel0rado1iu.spontaneousreplace.sound.SoundEvents;

import java.util.Objects;
import java.util.Optional;

import static net.minecraft.item.Items.CROSSBOW;

/**
 * <h2 style="color:FFC800">诸葛连弩物品</h2>
 * 一种强力的近战连发远程物品
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
public class ZhugeRepeatingCrossbowItem extends BoltActionRepeatingFirearmItem {
	public static final int MAX_DAMAGE = Objects.requireNonNull(CROSSBOW.getComponents().get(net.minecraft.component.DataComponentTypes.MAX_DAMAGE)) * 3;
	
	/**
	 * @param settings 物品设置
	 */
	public ZhugeRepeatingCrossbowItem(Settings settings) {
		super(settings.component(DataComponentTypes.ENCHANTMENT_TRAITS, EnchantmentTraitsComponent.of(
				Enchantments.MULTISHOT,
				Enchantments.QUICK_CHARGE,
				Enchantments.UNBREAKING,
				Enchantments.VANISHING_CURSE,
				Enchantments.MENDING)));
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
	public RangedWeaponComponent rangedWeapon(Optional<ItemStack> stack) {
		return RangedWeaponComponent.builder()
				.maxSpeed(3.5F)
				.maxDamage(RangedWeaponComponent.CROSSBOW_MAX_DAMAGE * 1.25F)
				.maxUseTicks(TickUtil.getTick(1))
				.maxPullTicks(TickUtil.getTick(1))
				.firingError(5)
				.defaultProjectile(Items.ARROW.getDefaultStack())
				.launchableProjectiles(ImmutableList.of(
						Items.ARROW,
						Items.SPECTRAL_ARROW,
						Items.TIPPED_ARROW,
						Items.FIREWORK_ROCKET))
				.build();
	}
	
	@Override
	public ProjectileContainerComponent projectileContainer(Optional<ItemStack> stack) {
		return stack.map(value -> ProjectileContainerComponent.of(EnchantmentHelper.getLevel(Enchantments.MULTISHOT, value) > 0 ? 30 : 10)).orElseGet(() -> ProjectileContainerComponent.of(10));
	}
	
	@Override
	public ShootProjectilesComponent shootProjectiles(Optional<ItemStack> stack) {
		return ShootProjectilesComponent.create(TickUtil.getTick(0.25F), ShootProjectilesComponent.State.EVERY);
	}
	
	@Override
	public int getRange() {
		return super.getRange() * 2;
	}
}
