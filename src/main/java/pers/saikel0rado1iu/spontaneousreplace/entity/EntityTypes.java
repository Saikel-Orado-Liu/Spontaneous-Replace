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

import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ProjectileDispenserBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
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
	EntityType<StoneballEntity> STONEBALL = EntityTypeRegistry.registrar(() -> EntityType.Builder.<StoneballEntity>create((StoneballEntity::new), SpawnGroup.MISC)
					.dimensions(EntityUtil.PROJECTILE_BOX, EntityUtil.PROJECTILE_BOX)
					.maxTrackingRange(EntityUtil.PROJECTILE_MAX_TRACKING_RANGE)
					.trackingTickInterval(EntityUtil.PROJECTILE_TRACKING_TICK_INTERVAL)
					.build())
			.other(entityType -> DispenserBlock.registerBehavior(Items.STONEBALL, new ProjectileDispenserBehavior(Items.STONEBALL)))
			.register("stoneball");
	EntityType<SteelArrowEntity> STEEL_ARROW = EntityTypeRegistry.registrar(() -> EntityType.Builder.<SteelArrowEntity>create(SteelArrowEntity::new, SpawnGroup.MISC)
					.dimensions(EntityUtil.PROJECTILE_BOX * 1.25F, EntityUtil.PROJECTILE_BOX * 1.25F)
					.maxTrackingRange(EntityUtil.PROJECTILE_MAX_TRACKING_RANGE * 10)
					.trackingTickInterval(EntityUtil.PROJECTILE_TRACKING_TICK_INTERVAL)
					.build())
			.other(entityType -> DispenserBlock.registerBehavior(Items.STEEL_ARROW, new ProjectileDispenserBehavior(Items.STEEL_ARROW)))
			.register("steel_arrow");
}
