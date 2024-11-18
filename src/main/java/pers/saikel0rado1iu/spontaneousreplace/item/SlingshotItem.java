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
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.thrown.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import pers.saikel0rado1iu.silk.api.base.common.util.TickUtil;
import pers.saikel0rado1iu.silk.api.generate.advancement.criterion.Criteria;
import pers.saikel0rado1iu.silk.api.generate.advancement.criterion.RangedKilledEntityCriterion;
import pers.saikel0rado1iu.silk.api.ropestick.component.ComponentTypes;
import pers.saikel0rado1iu.silk.api.ropestick.component.type.EnchantmentTraitsComponent;
import pers.saikel0rado1iu.silk.api.ropestick.component.type.ModifyMoveWhileUseComponent;
import pers.saikel0rado1iu.silk.api.ropestick.component.type.RangedWeaponComponent;
import pers.saikel0rado1iu.silk.api.ropestick.ranged.BowLikeItem;
import pers.saikel0rado1iu.spontaneousreplace.entity.projectile.StoneballEntity;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static net.minecraft.item.Items.*;

/**
 * <h2 style="color:FFC800">丫弹弓物品</h2>
 * 添加一种娱乐性质的远程武器
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
public class SlingshotItem extends BowLikeItem {
	public static final int MAX_DAMAGE = Objects.requireNonNull(BOW.getComponents().get(net.minecraft.component.DataComponentTypes.MAX_DAMAGE)) / 2;
	
	/**
	 * @param settings 物品设置
	 */
	public SlingshotItem(Item.Settings settings) {
		super(settings
				.component(ComponentTypes.MODIFY_MOVE_WHILE_USE, ModifyMoveWhileUseComponent.of(1))
				.component(ComponentTypes.ENCHANTMENT_TRAITS, EnchantmentTraitsComponent.of(
						Enchantments.INFINITY,
						Enchantments.POWER,
						Enchantments.PUNCH,
						Enchantments.UNBREAKING,
						Enchantments.VANISHING_CURSE,
						Enchantments.MENDING)));
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
	protected void shootAll(ServerWorld world, LivingEntity shooter, Hand hand, ItemStack stack, List<ItemStack> projectiles, float speed, float divergence, boolean critical, @Nullable LivingEntity target) {
		tempStack = stack;
		float baseYaw = projectiles.size() == 1 ? 0.0F : 20.0F / (projectiles.size() - 1);
		float halfBaseYaw = (projectiles.size() - 1) % 2 * baseYaw / 2.0F;
		float directionFactor = 1.0F;
		
		for (int index = 0; index < projectiles.size(); index++) {
			ItemStack itemStack = projectiles.get(index);
			if (itemStack.isEmpty()) continue;
			float YawAdjustment = halfBaseYaw + directionFactor * (index + 1) / 2 * baseYaw;
			directionFactor = -directionFactor;
			stack.damage(getWeaponStackDamage(itemStack), shooter, LivingEntity.getSlotForHand(hand));
			
			ThrownItemEntity thrownItemEntity = getThrownItemEntity(world, shooter, projectiles.get(index));
			shoot(shooter, thrownItemEntity, index, speed, divergence, YawAdjustment, target);
			world.spawnEntity(thrownItemEntity);
		}
	}
	
	@Override
	public RangedWeaponComponent rangedWeapon(Optional<ItemStack> stack) {
		return RangedWeaponComponent.builder()
				.maxSpeed(2)
				.maxDamage(RangedWeaponComponent.BOW_MAX_DAMAGE)
				.maxUseTicks(RangedWeaponComponent.BOW_MAX_USE_TICKS)
				.maxPullTicks(TickUtil.getTick(0.5F))
				.firingError(RangedWeaponComponent.DEFAULT_FIRING_ERROR)
				.defaultProjectile(Items.STONEBALL.getDefaultStack())
				.launchableProjectiles(ImmutableList.of(
						Items.STONEBALL,
						EGG,
						SNOWBALL,
						ENDER_PEARL,
						LINGERING_POTION,
						SPLASH_POTION))
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
