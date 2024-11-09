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
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.item.*;
import pers.saikel0rado1iu.silk.api.ropestick.component.type.CustomEntityHurtComponent;
import pers.saikel0rado1iu.silk.api.spinningjenny.ItemRegistry;
import pers.saikel0rado1iu.spontaneousreplace.block.Blocks;

import static net.minecraft.component.DataComponentTypes.DYED_COLOR;
import static net.minecraft.item.Items.COAL;
import static net.minecraft.item.Items.SNOWBALL;
import static pers.saikel0rado1iu.silk.api.ropestick.component.DataComponentTypes.CUSTOM_ENTITY_HURT;

/**
 * <h2 style="color:FFC800">物品集</h2>
 * 自然更替的所有物品
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
public interface Items extends ItemRegistry {
	Item CLEAN_COAL = ItemRegistry.registrar(() -> new Item(new Item.Settings())).other(item -> FuelRegistry.INSTANCE.add(item, FuelRegistry.INSTANCE.get(COAL) * 4)).group(ItemGroups.INGREDIENTS).register("clean_coal");
	Item COPPER_FOR_SMELTING_INGOT = ItemRegistry.registrar(() -> new Item(new Item.Settings())).group(ItemGroups.INGREDIENTS).register("copper_for_smelting_ingot");
	Item CUFE_ALLOY = ItemRegistry.registrar(() -> new Item(new Item.Settings())).group(ItemGroups.INGREDIENTS).register("cufe_alloy");
	Item AUCU_ALLOY = ItemRegistry.registrar(() -> new Item(new Item.Settings())).group(ItemGroups.INGREDIENTS).register("aucu_alloy");
	Item PIG_IRON = ItemRegistry.registrar(() -> new Item(new Item.Settings())).group(ItemGroups.INGREDIENTS).register("pig_iron");
	Item REFINED_COPPER_NUGGET = ItemRegistry.registrar(() -> new Item(new Item.Settings())).group(ItemGroups.INGREDIENTS).register("refined_copper_nugget");
	Item CUFE_ALLOY_NUGGET = ItemRegistry.registrar(() -> new Item(new Item.Settings())).group(ItemGroups.INGREDIENTS).register("cufe_alloy_nugget");
	Item AUCU_ALLOY_NUGGET = ItemRegistry.registrar(() -> new Item(new Item.Settings())).group(ItemGroups.INGREDIENTS).register("aucu_alloy_nugget");
	Item REFINED_COPPER_INGOT = ItemRegistry.registrar(() -> new Item(new Item.Settings())).group(ItemGroups.INGREDIENTS).register("refined_copper_ingot");
	Item CUFE_ALLOY_INGOT = ItemRegistry.registrar(() -> new Item(new Item.Settings())).group(ItemGroups.INGREDIENTS).register("cufe_alloy_ingot");
	Item AUCU_ALLOY_INGOT = ItemRegistry.registrar(() -> new Item(new Item.Settings())).group(ItemGroups.INGREDIENTS).register("aucu_alloy_ingot");
	Item STEEL_INGOT = ItemRegistry.registrar(() -> new Item(new Item.Settings())).group(ItemGroups.INGREDIENTS).register("steel_ingot");
	Item COMPACT_GOSSAMER = ItemRegistry.registrar(() -> new Item(new Item.Settings())).group(ItemGroups.INGREDIENTS).register("compact_gossamer");
	Item STICKY_COMPACT_GOSSAMER = ItemRegistry.registrar(() -> new Item(new Item.Settings())).group(ItemGroups.INGREDIENTS).register("sticky_compact_gossamer");
	Item COMPACT_STRING = ItemRegistry.registrar(() -> new Item(new Item.Settings())).group(ItemGroups.INGREDIENTS).register("compact_string");
	Item COMPOSITE_STRING = ItemRegistry.registrar(() -> new Item(new Item.Settings())).group(ItemGroups.INGREDIENTS).register("composite_string");
	Item COMPOSITE_FABRIC = ItemRegistry.registrar(() -> new Item(new Item.Settings())).group(ItemGroups.INGREDIENTS).register("composite_fabric");
	SwordItem REFINED_COPPER_SWORD = ItemRegistry.registrar(() -> ToolMaterials.REFINED_COPPER.createSword(6, new Item.Settings())).group(ItemGroups.COMBAT).register("refined_copper_sword");
	SwordItem CUFE_ALLOY_SWORD = ItemRegistry.registrar(() -> ToolMaterials.CUFE.createSword(6, new Item.Settings())).group(ItemGroups.COMBAT).register("cufe_alloy_sword");
	SwordItem AUCU_ALLOY_SWORD = ItemRegistry.registrar(() -> ToolMaterials.AUCU.createSword(5, new Item.Settings())).group(ItemGroups.COMBAT).register("aucu_alloy_sword");
	SwordItem STEEL_SWORD = ItemRegistry.registrar(() -> ToolMaterials.STEEL.createSword(7, new Item.Settings())).group(ItemGroups.COMBAT).register("steel_sword");
	ShovelItem REFINED_COPPER_SHOVEL = ItemRegistry.registrar(() -> ToolMaterials.REFINED_COPPER.createShovel(3.5F, new Item.Settings())).group(ItemGroups.TOOLS).register("refined_copper_shovel");
	PickaxeItem REFINED_COPPER_PICKAXE = ItemRegistry.registrar(() -> ToolMaterials.REFINED_COPPER.createPickaxe(3, new Item.Settings())).group(ItemGroups.TOOLS).register("refined_copper_pickaxe");
	AxeItem REFINED_COPPER_AXE = ItemRegistry.registrar(() -> ToolMaterials.REFINED_COPPER.createAxe(9, 0.9F, new Item.Settings())).group(ItemGroups.TOOLS, ItemGroups.COMBAT).register("refined_copper_axe");
	HoeItem REFINED_COPPER_HOE = ItemRegistry.registrar(() -> ToolMaterials.REFINED_COPPER.createHoe(2, new Item.Settings())).group(ItemGroups.TOOLS).register("refined_copper_hoe");
	ShovelItem CUFE_ALLOY_SHOVEL = ItemRegistry.registrar(() -> ToolMaterials.CUFE.createShovel(4.5F, new Item.Settings())).group(ItemGroups.TOOLS).register("cufe_alloy_shovel");
	PickaxeItem CUFE_ALLOY_PICKAXE = ItemRegistry.registrar(() -> ToolMaterials.CUFE.createPickaxe(4, new Item.Settings())).group(ItemGroups.TOOLS).register("cufe_alloy_pickaxe");
	AxeItem CUFE_ALLOY_AXE = ItemRegistry.registrar(() -> ToolMaterials.CUFE.createAxe(9, 0.9F, new Item.Settings())).group(ItemGroups.TOOLS, ItemGroups.COMBAT).register("cufe_alloy_axe");
	HoeItem CUFE_ALLOY_HOE = ItemRegistry.registrar(() -> ToolMaterials.CUFE.createHoe(3, new Item.Settings())).group(ItemGroups.TOOLS).register("cufe_alloy_hoe");
	ShovelItem AUCU_ALLOY_SHOVEL = ItemRegistry.registrar(() -> ToolMaterials.AUCU.createShovel(3.5F, new Item.Settings())).group(ItemGroups.TOOLS).register("aucu_alloy_shovel");
	PickaxeItem AUCU_ALLOY_PICKAXE = ItemRegistry.registrar(() -> ToolMaterials.AUCU.createPickaxe(2, new Item.Settings())).group(ItemGroups.TOOLS).register("aucu_alloy_pickaxe");
	AxeItem AUCU_ALLOY_AXE = ItemRegistry.registrar(() -> ToolMaterials.AUCU.createAxe(9, 0.8F, new Item.Settings())).group(ItemGroups.TOOLS, ItemGroups.COMBAT).register("aucu_alloy_axe");
	HoeItem AUCU_ALLOY_HOE = ItemRegistry.registrar(() -> ToolMaterials.AUCU.createHoe(2, new Item.Settings())).group(ItemGroups.TOOLS).register("aucu_alloy_hoe");
	ShovelItem STEEL_SHOVEL = ItemRegistry.registrar(() -> ToolMaterials.STEEL.createShovel(5.5F, new Item.Settings())).group(ItemGroups.TOOLS).register("steel_shovel");
	PickaxeItem STEEL_PICKAXE = ItemRegistry.registrar(() -> ToolMaterials.STEEL.createPickaxe(5, new Item.Settings())).group(ItemGroups.TOOLS).register("steel_pickaxe");
	AxeItem STEEL_AXE = ItemRegistry.registrar(() -> ToolMaterials.STEEL.createAxe(9, 0.9F, new Item.Settings())).group(ItemGroups.TOOLS, ItemGroups.COMBAT).register("steel_axe");
	HoeItem STEEL_HOE = ItemRegistry.registrar(() -> ToolMaterials.STEEL.createHoe(4, new Item.Settings())).group(ItemGroups.TOOLS).register("steel_hoe");
	ArmorItem REFINED_COPPER_HELMET = ItemRegistry.registrar(() -> ArmorMaterials.REFINED_COPPER.createHelmet(new Item.Settings())).group(ItemGroups.COMBAT).register("refined_copper_helmet");
	ArmorItem REFINED_COPPER_CHESTPLATE = ItemRegistry.registrar(() -> ArmorMaterials.REFINED_COPPER.createChestplate(new Item.Settings())).group(ItemGroups.COMBAT).register("refined_copper_chestplate");
	ArmorItem REFINED_COPPER_LEGGINGS = ItemRegistry.registrar(() -> ArmorMaterials.REFINED_COPPER.createLeggings(new Item.Settings())).group(ItemGroups.COMBAT).register("refined_copper_leggings");
	ArmorItem REFINED_COPPER_BOOTS = ItemRegistry.registrar(() -> ArmorMaterials.REFINED_COPPER.createBoots(new Item.Settings())).group(ItemGroups.COMBAT).register("refined_copper_boots");
	ArmorItem CUFE_ALLOY_HELMET = ItemRegistry.registrar(() -> ArmorMaterials.CUFE.createHelmet(new Item.Settings())).group(ItemGroups.COMBAT).register("cufe_alloy_helmet");
	ArmorItem CUFE_ALLOY_CHESTPLATE = ItemRegistry.registrar(() -> ArmorMaterials.CUFE.createChestplate(new Item.Settings())).group(ItemGroups.COMBAT).register("cufe_alloy_chestplate");
	ArmorItem CUFE_ALLOY_LEGGINGS = ItemRegistry.registrar(() -> ArmorMaterials.CUFE.createLeggings(new Item.Settings())).group(ItemGroups.COMBAT).register("cufe_alloy_leggings");
	ArmorItem CUFE_ALLOY_BOOTS = ItemRegistry.registrar(() -> ArmorMaterials.CUFE.createBoots(new Item.Settings())).group(ItemGroups.COMBAT).register("cufe_alloy_boots");
	ArmorItem AUCU_ALLOY_HELMET = ItemRegistry.registrar(() -> ArmorMaterials.AUCU.createHelmet(new Item.Settings())).group(ItemGroups.COMBAT).register("aucu_alloy_helmet");
	ArmorItem AUCU_ALLOY_CHESTPLATE = ItemRegistry.registrar(() -> ArmorMaterials.AUCU.createChestplate(new Item.Settings())).group(ItemGroups.COMBAT).register("aucu_alloy_chestplate");
	ArmorItem AUCU_ALLOY_LEGGINGS = ItemRegistry.registrar(() -> ArmorMaterials.AUCU.createLeggings(new Item.Settings())).group(ItemGroups.COMBAT).register("aucu_alloy_leggings");
	ArmorItem AUCU_ALLOY_BOOTS = ItemRegistry.registrar(() -> ArmorMaterials.AUCU.createBoots(new Item.Settings())).group(ItemGroups.COMBAT).register("aucu_alloy_boots");
	ArmorItem STEEL_HELMET = ItemRegistry.registrar(() -> ArmorMaterials.STEEL.createHelmet(new Item.Settings())).group(ItemGroups.COMBAT).register("steel_helmet");
	ArmorItem STEEL_CHESTPLATE = ItemRegistry.registrar(() -> ArmorMaterials.STEEL.createChestplate(new Item.Settings())).group(ItemGroups.COMBAT).register("steel_chestplate");
	ArmorItem STEEL_LEGGINGS = ItemRegistry.registrar(() -> ArmorMaterials.STEEL.createLeggings(new Item.Settings())).group(ItemGroups.COMBAT).register("steel_leggings");
	ArmorItem STEEL_BOOTS = ItemRegistry.registrar(() -> ArmorMaterials.STEEL.createBoots(new Item.Settings())).group(ItemGroups.COMBAT).register("steel_boots");
	ArmorItem ARROWPROOF_VEST = ItemRegistry.registrar(() -> ArmorMaterials.ARROWPROOF.createChestplate(new Item.Settings()
			.component(DYED_COLOR, new DyedColorComponent(ArmorMaterials.ARROWPROOF_COLOR, true))
			.component(CUSTOM_ENTITY_HURT, new CustomEntityHurtComponent(ImmutableList.of(DamageTypes.MOB_PROJECTILE), "amount / 2")))).group(ItemGroups.COMBAT).register("arrowproof_vest");
	StoneballItem STONEBALL = ItemRegistry.registrar(() -> new StoneballItem(new Item.Settings().maxCount(SNOWBALL.getMaxCount()))).group(ItemGroups.COMBAT).register("stoneball");
	SteelArrowItem STEEL_ARROW = ItemRegistry.registrar(() -> new SteelArrowItem(new Item.Settings().maxCount(4))).group(ItemGroups.COMBAT).register("steel_arrow");
	SlingshotItem SLINGSHOT = ItemRegistry.registrar(() -> new SlingshotItem(new Item.Settings().maxDamage(SlingshotItem.MAX_DAMAGE))).group(ItemGroups.COMBAT).register("slingshot");
	RecurveBowItem RECURVE_BOW = ItemRegistry.registrar(() -> new RecurveBowItem(new Item.Settings().maxDamage(RecurveBowItem.MAX_DAMAGE))).group(ItemGroups.COMBAT).register("recurve_bow");
	ArbalestItem ARBALEST = ItemRegistry.registrar(() -> new ArbalestItem(new Item.Settings().maxDamage(ArbalestItem.MAX_DAMAGE))).group(ItemGroups.COMBAT).register("arbalest");
	CompoundBowItem COMPOUND_BOW = ItemRegistry.registrar(() -> new CompoundBowItem(new Item.Settings().maxDamage(CompoundBowItem.MAX_DAMAGE))).group(ItemGroups.COMBAT).register("compound_bow");
	ZhugeRepeatingCrossbowItem ZHUGE_REPEATING_CROSSBOW = ItemRegistry.registrar(() -> new ZhugeRepeatingCrossbowItem(new Item.Settings().maxDamage(ZhugeRepeatingCrossbowItem.MAX_DAMAGE).fireproof())).group(ItemGroups.COMBAT).register("zhuge_repeating_crossbow");
	MarksCrossbowItem MARKS_CROSSBOW = ItemRegistry.registrar(() -> new MarksCrossbowItem(new Item.Settings().maxDamage(MarksCrossbowItem.MAX_DAMAGE).fireproof())).group(ItemGroups.COMBAT).register("marks_crossbow");
	BlockItem COPPER_FOR_SMELTING_INGOT_BLOCK = ItemRegistry.registrar(() -> new BlockItem(Blocks.COPPER_FOR_SMELTING_INGOT_BLOCK, new Item.Settings())).group(ItemGroups.BUILDING_BLOCKS).register("copper_for_smelting_ingot_block");
	BlockItem CUFE_ALLOY_BLOCK = ItemRegistry.registrar(() -> new BlockItem(Blocks.CUFE_ALLOY_BLOCK, new Item.Settings())).group(ItemGroups.BUILDING_BLOCKS).register("cufe_alloy_block");
	BlockItem AUCU_ALLOY_BLOCK = ItemRegistry.registrar(() -> new BlockItem(Blocks.AUCU_ALLOY_BLOCK, new Item.Settings())).group(ItemGroups.BUILDING_BLOCKS).register("aucu_alloy_block");
	BlockItem PIG_IRON_BLOCK = ItemRegistry.registrar(() -> new BlockItem(Blocks.PIG_IRON_BLOCK, new Item.Settings())).group(ItemGroups.BUILDING_BLOCKS).register("pig_alloy_block");
	BlockItem REFINED_COPPER_BLOCK = ItemRegistry.registrar(() -> new BlockItem(Blocks.REFINED_COPPER_BLOCK, new Item.Settings())).group(ItemGroups.BUILDING_BLOCKS).register("refined_copper_block");
	BlockItem CUFE_BLOCK = ItemRegistry.registrar(() -> new BlockItem(Blocks.CUFE_BLOCK, new Item.Settings())).group(ItemGroups.BUILDING_BLOCKS).register("cufe_block");
	BlockItem AUCU_BLOCK = ItemRegistry.registrar(() -> new BlockItem(Blocks.AUCU_BLOCK, new Item.Settings())).group(ItemGroups.BUILDING_BLOCKS).register("aucu_block");
	BlockItem STEEL_BLOCK = ItemRegistry.registrar(() -> new BlockItem(Blocks.STEEL_BLOCK, new Item.Settings())).group(ItemGroups.BUILDING_BLOCKS).register("steel_block");
}
