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

package pers.saikel0rado1iu.spontaneousreplace.entity.projectile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;
import pers.saikel0rado1iu.silk.api.spore.projectile.FixedDamage;
import pers.saikel0rado1iu.spontaneousreplace.entity.EntityTypes;
import pers.saikel0rado1iu.spontaneousreplace.item.Items;

/**
 * <h2 style="color:FFC800">钢箭实体</h2>
 * 钢箭实体
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
public class SteelArrowEntity extends PersistentProjectileEntity implements FixedDamage {
	private static final ItemStack DEFAULT_STACK = new ItemStack(Items.STEEL_ARROW);
	
	public SteelArrowEntity(EntityType<? extends SteelArrowEntity> entityType, World world) {
		super(entityType, world);
	}
	
	public SteelArrowEntity(World world, LivingEntity owner, ItemStack stack) {
		super(EntityTypes.STEEL_ARROW, owner, world, stack);
	}
	
	@Override
	public void tick() {
		if (getWorld().isClient && !inGround) getWorld().addParticle(ParticleTypes.INSTANT_EFFECT, getX(), getY(), getZ(), 0, 0, 0);
		super.tick();
	}
	
	@Override
	protected ItemStack getDefaultItemStack() {
		return DEFAULT_STACK;
	}
	
	/**
	 * 固定伤害
	 *
	 * @return 固定伤害值
	 */
	@Override
	public float fixedDamage() {
		return 50;
	}
}
