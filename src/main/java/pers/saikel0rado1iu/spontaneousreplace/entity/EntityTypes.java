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

package pers.saikel0rado1iu.spontaneousreplace.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ProjectileDispenserBehavior;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import pers.saikel0rado1iu.silk.api.spinningjenny.EntityTypeRegistry;
import pers.saikel0rado1iu.silk.api.spore.EntityUtil;
import pers.saikel0rado1iu.spontaneousreplace.entity.projectile.SteelArrowEntity;
import pers.saikel0rado1iu.spontaneousreplace.entity.projectile.StoneballEntity;
import pers.saikel0rado1iu.spontaneousreplace.item.Items;


/**
 * <h2 style="color:FFC800">实体类型集</h2>
 * 自然更替的所有实体类型
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
public interface EntityTypes extends EntityTypeRegistry {
	EntityType<StoneballEntity> STONEBALL = EntityTypeRegistry.registrar(() -> FabricEntityTypeBuilder.<StoneballEntity>create(SpawnGroup.MISC, StoneballEntity::new)
					.dimensions(EntityDimensions.fixed(EntityUtil.PROJECTILE_BOX, EntityUtil.PROJECTILE_BOX)).trackRangeBlocks(EntityUtil.PROJECTILE_RANGE).trackedUpdateRate(EntityUtil.PROJECTILE_UPDATE_RATE).build())
			.other(entityType -> DispenserBlock.registerBehavior(Items.STONEBALL, new ProjectileDispenserBehavior() {
				@Override
				protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
					return new StoneballEntity(world, position.getX(), position.getY(), position.getZ());
				}
			})).register("stoneball");
	EntityType<SteelArrowEntity> STEEL_ARROW = EntityTypeRegistry.registrar(() -> FabricEntityTypeBuilder.<SteelArrowEntity>create(SpawnGroup.MISC, SteelArrowEntity::new)
					.dimensions(EntityDimensions.fixed(EntityUtil.PROJECTILE_BOX * 1.25F, EntityUtil.PROJECTILE_BOX * 1.25F)).trackRangeBlocks(EntityUtil.PROJECTILE_RANGE * 10).trackedUpdateRate(EntityUtil.PROJECTILE_UPDATE_RATE).build())
			.other(entityType -> DispenserBlock.registerBehavior(Items.STEEL_ARROW, new ProjectileDispenserBehavior() {
				@Override
				protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
					SteelArrowEntity arrowEntity = new SteelArrowEntity(world, position.getX(), position.getY(), position.getZ(), stack);
					arrowEntity.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
					return arrowEntity;
				}
			})).register("steel_arrow");
}
