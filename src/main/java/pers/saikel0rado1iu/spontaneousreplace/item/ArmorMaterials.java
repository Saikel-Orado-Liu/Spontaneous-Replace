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
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import pers.saikel0rado1iu.silk.api.ropestick.armor.ArmorHelper;
import pers.saikel0rado1iu.spontaneousreplace.SpontaneousReplace;
import pers.saikel0rado1iu.spontaneousreplace.sound.SoundEvents;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

import static net.minecraft.item.ArmorMaterials.*;

/**
 * <h2 style="color:FFC800">盔甲材料类</h2>
 * 自然更替的盔甲工具材料
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
public enum ArmorMaterials implements ArmorHelper {
	/**
	 * 精铜盔甲<br>
	 * 基础属性在锁链盔甲与铁制盔甲之间，但耐久小于二者，但是拥有少量的盔甲韧性和只比金属性低地附魔等级
	 */
	REFINED_COPPER("refined_copper", 12, Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.HELMET, 2);
		map.put(ArmorItem.Type.CHESTPLATE, 5);
		map.put(ArmorItem.Type.LEGGINGS, 4);
		map.put(ArmorItem.Type.BOOTS, 2);
		map.put(ArmorItem.Type.BODY, 5);
	}), GOLD.value().enchantability() - 5, SoundEvents.EQUIP_REFINED_COPPER, CHAIN.value().toughness() + 0.5F, 0, () -> Ingredient.ofItems(Items.REFINED_COPPER_INGOT)),
	/**
	 * 铜铁盔甲<br>
	 * 基础属性只比铁制盔甲略高，但是拥有精铜的盔甲韧性和附魔等级
	 */
	CUFE("cufe_alloy", 20, Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.HELMET, 2);
		map.put(ArmorItem.Type.CHESTPLATE, 6);
		map.put(ArmorItem.Type.LEGGINGS, 5);
		map.put(ArmorItem.Type.BOOTS, 2);
		map.put(ArmorItem.Type.BODY, 6);
	}), REFINED_COPPER.enchantability(), SoundEvents.EQUIP_CUFE_ALLOY, REFINED_COPPER.toughness() * 2, 0, () -> Ingredient.ofItems(Items.CUFE_ALLOY_INGOT)),
	/**
	 * 金铜盔甲<br>
	 * 基础属性只比金制盔甲略高，但是拥有极致的附魔等级，附魔等级甚至比金高 5 点
	 */
	AUCU("aucu_alloy", 10, Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.HELMET, 2);
		map.put(ArmorItem.Type.CHESTPLATE, 5);
		map.put(ArmorItem.Type.LEGGINGS, 4);
		map.put(ArmorItem.Type.BOOTS, 1);
		map.put(ArmorItem.Type.BODY, 5);
	}), GOLD.value().enchantability() + 5, SoundEvents.EQUIP_AUCU_ALLOY, GOLD.value().toughness(), 0, () -> Ingredient.ofItems(Items.AUCU_ALLOY_INGOT)),
	/**
	 * 钢制盔甲<br>
	 * 基础属性只比钻石盔甲略低，但是拥有下届合金的附魔等级和少量的击退抗性
	 */
	STEEL("steel", 28, Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.HELMET, 3);
		map.put(ArmorItem.Type.CHESTPLATE, 7);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.BOOTS, 2);
		map.put(ArmorItem.Type.BODY, 7);
	}), NETHERITE.value().enchantability(), SoundEvents.EQUIP_STEEL, DIAMOND.value().toughness() - 0.5F, 0.5F, () -> Ingredient.ofItems(Items.STEEL_INGOT)),
	/**
	 * 防箭装备<br>
	 * 一种特殊的投掷物防御装备
	 */
	ARROWPROOF("arrowproof", 10, Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.HELMET, 1);
		map.put(ArmorItem.Type.CHESTPLATE, 3);
		map.put(ArmorItem.Type.LEGGINGS, 2);
		map.put(ArmorItem.Type.BOOTS, 1);
		map.put(ArmorItem.Type.BODY, 3);
	}), TURTLE.value().enchantability(), SoundEvents.EQUIP_ARROWPROOF, 5, 0, () -> Ingredient.ofItems(Items.COMPOSITE_FABRIC), id ->
			List.of(new ArmorMaterial.Layer(id, "", true), new ArmorMaterial.Layer(id, "_overlay", false)));
	
	public static final int ARROWPROOF_COLOR = 0xFFFFB3;
	private final String name;
	private final int durability;
	private final Map<ArmorItem.Type, Integer> defense;
	private final int enchantability;
	private final RegistryEntry<SoundEvent> equipSound;
	private final float toughness;
	private final float knockbackResistance;
	private final Supplier<Ingredient> ingredient;
	private final Function<Identifier, List<ArmorMaterial.Layer>> layers;
	private final Supplier<RegistryEntry<ArmorMaterial>> material;
	
	ArmorMaterials(String name, int durability, Map<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> ingredient) {
		this(name, durability, defense, enchantability, equipSound, toughness, knockbackResistance, ingredient, id -> List.of(new ArmorMaterial.Layer(id)));
	}
	
	ArmorMaterials(String name, int durability, Map<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> ingredient, Function<Identifier, List<ArmorMaterial.Layer>> layers) {
		this.name = name;
		this.durability = durability;
		this.defense = defense;
		this.enchantability = enchantability;
		this.equipSound = equipSound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.ingredient = Suppliers.memoize(ingredient::get);
		this.layers = layers;
		this.material = Suppliers.memoize(() -> ArmorHelper.registerMaterial(this));
	}
	
	@Override
	public Identifier id() {
		return SpontaneousReplace.INSTANCE.ofId(name);
	}
	
	@Override
	public int durability() {
		return durability;
	}
	
	@Override
	public Map<ArmorItem.Type, Integer> defense() {
		return defense;
	}
	
	@Override
	public int enchantability() {
		return enchantability;
	}
	
	@Override
	public RegistryEntry<SoundEvent> equipSound() {
		return equipSound;
	}
	
	@Override
	public Supplier<Ingredient> repairIngredient() {
		return ingredient;
	}
	
	@Override
	public float toughness() {
		return toughness;
	}
	
	@Override
	public float knockbackResistance() {
		return knockbackResistance;
	}
	
	@Override
	public List<ArmorMaterial.Layer> layers() {
		return layers.apply(id());
	}
	
	@Override
	public Supplier<RegistryEntry<ArmorMaterial>> material() {
		return material;
	}
}
