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
import net.minecraft.entity.DamageUtil;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.registry.tag.DamageTypeTags;
import pers.saikel0rado1iu.silk.api.ropestick.armor.CustomDyeableArmorItem;
import pers.saikel0rado1iu.silk.api.ropestick.property.CustomEntityHurt;
import pers.saikel0rado1iu.silk.api.ropestick.property.ItemProperties;
import pers.saikel0rado1iu.silk.api.ropestick.property.ItemProperty;

import java.util.Set;

/**
 * <h2 style="color:FFC800">防箭衣物品</h2>
 * 一种特殊的投掷物防御装备，拥有超高的韧性和 50% 的弹射物伤害减免
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
public class ArrowproofVestItem extends CustomDyeableArmorItem implements ItemProperties {
	public ArrowproofVestItem(Type type, Settings settings) {
		super(ArmorMaterials.ARROWPROOF, type, settings, 0xFFFFB3);
	}
	
	/**
	 * 属性方法
	 *
	 * @return 物品属性集合
	 */
	@Override
	public Set<ItemProperty> properties() {
		return ImmutableSet.of(new CustomEntityHurt((itemStack, damageSource, entity, damage) -> {
			if (!damageSource.isIn(DamageTypeTags.IS_PROJECTILE)) return damage;
			float damageLeft = DamageUtil.getDamageLeft(damage / 2, (float) entity.getArmor(), (float) entity.getAttributeValue(EntityAttributes.GENERIC_ARMOR_TOUGHNESS));
			itemStack.damage((int) damageLeft, entity, p -> p.sendEquipmentBreakStatus(((ArmorItem) itemStack.getItem()).getSlotType()));
			return damage / 2;
		}));
	}
}
