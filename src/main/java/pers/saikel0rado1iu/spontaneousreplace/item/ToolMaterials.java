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
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import pers.saikel0rado1iu.silk.api.ropestick.tool.Tool;

import java.util.function.Supplier;

import static net.minecraft.item.ToolMaterials.*;

/**
 * <h2 style="color:FFC800">工具材料类</h2>
 * 自然更替的所有工具材料
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
public enum ToolMaterials implements Tool {
	/**
	 * 精铜工具<br>
	 * 基础属性在石制工具与铁制工具之间，但是拥有只比金低地附魔等级
	 */
	REFINED_COPPER(STONE.getMiningLevel(), (STONE.getDurability() + IRON.getDurability()) / 2, (STONE.getMiningSpeedMultiplier() + IRON.getMiningSpeedMultiplier()) / 2, 1, GOLD.getEnchantability() - 5, () -> Ingredient.ofItems(Items.REFINED_COPPER_INGOT)),
	/**
	 * 铜铁工具<br>
	 * 基础属性只比铁制工具略高，但是拥有精铜工具的附魔等级
	 */
	CUFE(IRON.getMiningLevel(), IRON.getDurability() * 2, IRON.getMiningSpeedMultiplier(), 2, REFINED_COPPER.getEnchantability(), () -> Ingredient.ofItems(Items.CUFE_ALLOY_INGOT)),
	/**
	 * 金铜工具<br>
	 * 基础属性在石制工具左右，但是拥有极致的附魔等级，附魔等级甚至比金高
	 */
	AUCU(STONE.getMiningLevel(), STONE.getDurability(), GOLD.getMiningSpeedMultiplier(), STONE.getAttackDamage(), GOLD.getEnchantability() + 5, () -> Ingredient.ofItems(Items.AUCU_ALLOY_INGOT)),
	/**
	 * 钢制工具<br>
	 * 基础属性只比钻石工具略低，但挖掘等级还是铁，但是拥有铁质工具的附魔等级
	 */
	STEEL(IRON.getMiningLevel(), DIAMOND.getDurability() - CUFE.getDurability(), (IRON.getMiningSpeedMultiplier() + DIAMOND.getMiningSpeedMultiplier()) / 2, DIAMOND.getAttackDamage(), IRON.getEnchantability(), () -> Ingredient.ofItems(Items.STEEL_INGOT));
	
	private final int miningLevel;
	private final int durability;
	private final float miningSpeed;
	private final float materialDamage;
	private final int enchantability;
	private final Supplier<Ingredient> ingredient;
	
	ToolMaterials(int miningLevel, int durability, float miningSpeed, float materialDamage, int enchantability, Supplier<Ingredient> ingredient) {
		this.miningLevel = miningLevel;
		this.durability = durability;
		this.miningSpeed = miningSpeed;
		this.materialDamage = materialDamage;
		this.enchantability = enchantability;
		this.ingredient = Suppliers.memoize(ingredient::get);
	}
	
	/**
	 * 获取材料伤害，即为 {@link ToolMaterial} 中的 {@link ToolMaterial#getAttackDamage()}
	 *
	 * @return 材料伤害
	 */
	@Override
	public float getMaterialDamage() {
		return materialDamage;
	}
	
	@Override
	public int getDurability() {
		return durability;
	}
	
	@Override
	public float getMiningSpeedMultiplier() {
		return miningSpeed;
	}
	
	@Override
	public int getMiningLevel() {
		return miningLevel;
	}
	
	@Override
	public int getEnchantability() {
		return enchantability;
	}
	
	@Override
	public Ingredient getRepairIngredient() {
		return ingredient.get();
	}
}
