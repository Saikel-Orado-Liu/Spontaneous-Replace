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

import com.google.common.base.Suppliers;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import pers.saikel0rado1iu.silk.api.ropestick.armor.Armor;
import pers.saikel0rado1iu.spontaneousreplace.SpontaneousReplace;
import pers.saikel0rado1iu.spontaneousreplace.sound.SoundEvents;

import java.util.function.Supplier;

import static net.minecraft.item.ArmorMaterials.*;

/**
 * <h2 style="color:FFC800">盔甲材料类</h2>
 * 自然更替的盔甲工具材料
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
public enum ArmorMaterials implements Armor {
	/**
	 * 精铜盔甲<br>
	 * 基础属性在锁链盔甲与铁制盔甲之间，但耐久小于二者，但是拥有少量的盔甲韧性和只比金属性低地附魔等级
	 */
	REFINED_COPPER("refined_copper", 12, new int[]{2, 5, 4, 2}, GOLD.getEnchantability() - 5, SoundEvents.EQUIP_REFINED_COPPER, CHAIN.getToughness() + 0.5F, 0, () -> Ingredient.ofItems(Items.REFINED_COPPER_INGOT)),
	/**
	 * 铜铁盔甲<br>
	 * 基础属性只比铁制盔甲略高，但是拥有精铜的盔甲韧性和附魔等级
	 */
	CUFE("cufe_alloy", 20, new int[]{2, 6, 5, 2}, REFINED_COPPER.getEnchantability(), SoundEvents.EQUIP_CUFE_ALLOY, REFINED_COPPER.getToughness() * 2, 0, () -> Ingredient.ofItems(Items.CUFE_ALLOY_INGOT)),
	/**
	 * 金铜盔甲<br>
	 * 基础属性只比金制盔甲略高，但是拥有极致的附魔等级，附魔等级甚至比金高 5 点
	 */
	AUCU("aucu_alloy", 10, new int[]{2, 5, 4, 1}, GOLD.getEnchantability() + 5, SoundEvents.EQUIP_AUCU_ALLOY, GOLD.getToughness(), 0, () -> Ingredient.ofItems(Items.AUCU_ALLOY_INGOT)),
	/**
	 * 钢制盔甲<br>
	 * 基础属性只比钻石盔甲略低，但是拥有下届合金的附魔等级和少量的击退抗性
	 */
	STEEL("steel", 28, new int[]{3, 7, 6, 2}, NETHERITE.getEnchantability(), SoundEvents.EQUIP_STEEL, DIAMOND.getToughness() - 0.5F, 0.5F, () -> Ingredient.ofItems(Items.STEEL_INGOT)),
	/**
	 * 防箭装备<br>
	 * 一种特殊的投掷物防御装备
	 */
	ARROWPROOF("arrowproof", 10, new int[]{1, 3, 2, 1}, TURTLE.getEnchantability(), SoundEvents.EQUIP_ARROWPROOF, 5, 0, () -> Ingredient.ofItems(Items.COMPOSITE_FABRIC));
	
	private final String name;
	private final int durability;
	private final int[] protections;
	private final int enchantability;
	private final SoundEvent equipSound;
	private final float toughness;
	private final float knockbackResistance;
	private final Supplier<Ingredient> ingredient;
	
	ArmorMaterials(String name, int durability, int[] protections, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> ingredient) {
		this.name = name;
		this.durability = durability;
		this.protections = protections;
		this.enchantability = enchantability;
		this.equipSound = equipSound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.ingredient = Suppliers.memoize(ingredient::get);
	}
	
	/**
	 * 获取盔甲 ID
	 *
	 * @return 盔甲 ID
	 */
	@Override
	public Identifier getId() {
		return SpontaneousReplace.INSTANCE.ofId(name);
	}
	
	/**
	 * 获取耐久度
	 *
	 * @return 耐久度
	 */
	@Override
	public int getDurability() {
		return durability;
	}
	
	/**
	 * 获取护甲值
	 *
	 * @return 护甲值
	 */
	@Override
	public int[] getProtections() {
		return protections;
	}
	
	/**
	 * 获取击退抗性
	 *
	 * @return 击退抗性
	 */
	@Override
	public float getKnockBackResistance() {
		return knockbackResistance;
	}
	
	@Override
	public int getEnchantability() {
		return enchantability;
	}
	
	@Override
	public SoundEvent getEquipSound() {
		return equipSound;
	}
	
	@Override
	public Ingredient getRepairIngredient() {
		return ingredient.get();
	}
	
	@Override
	public float getToughness() {
		return toughness;
	}
}
