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

package pers.saikel0rado1iu.spontaneousreplace.data;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import pers.saikel0rado1iu.silk.api.base.common.util.TickUtil;
import pers.saikel0rado1iu.silk.api.generate.data.RecipeGenUtil;
import pers.saikel0rado1iu.silk.api.generate.data.family.EquipFamily;
import pers.saikel0rado1iu.spontaneousreplace.item.Items;

import static net.minecraft.item.Items.*;

/**
 * <h2 style="color:FFC800">配方生成器</h2>
 * 自然更替的配方生成器
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
final class RecipeGenerator extends FabricRecipeProvider {
	RecipeGenerator(FabricDataOutput output) {
		super(output);
	}
	
	@Override
	public void generate(RecipeExporter exporter) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.CLEAN_COAL).group(getItemPath(Items.CLEAN_COAL)).input('#', COAL).input('X', WATER_BUCKET)
				.pattern("###")
				.pattern("#X#")
				.pattern("###")
				.criterion(hasItem(COAL), conditionsFromItem(COAL))
				.criterion(hasItem(WATER_BUCKET), conditionsFromItem(WATER_BUCKET))
				.offerTo(exporter, getItemPath(Items.CLEAN_COAL) + "_less");
		ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.CLEAN_COAL, 5).group(getItemPath(Items.CLEAN_COAL)).input('#', COAL_BLOCK).input('X', WATER_BUCKET)
				.pattern("#X")
				.pattern("X#")
				.criterion(hasItem(COAL), conditionsFromItem(COAL))
				.criterion(hasItem(WATER_BUCKET), conditionsFromItem(WATER_BUCKET))
				.offerTo(exporter, getItemPath(Items.CLEAN_COAL) + "_more");
		RecipeGenUtil.offer2x2CompactingRecipeWithRecipeGroup(exporter, RecipeCategory.MISC, COPPER_INGOT, Items.COPPER_FOR_SMELTING_INGOT);
		RecipeGenUtil.offerReversibleSmithingRecipe(exporter, RecipeCategory.MISC, Ingredient.ofItems(COPPER_INGOT), Ingredient.ofItems(COPPER_INGOT), Items.COPPER_FOR_SMELTING_INGOT);
		RecipeGenUtil.offer2x2CrossCompactingRecipe(exporter, RecipeCategory.MISC, Ingredient.ofItems(Items.REFINED_COPPER_INGOT), Ingredient.ofItems(IRON_INGOT), Items.CUFE_ALLOY);
		RecipeGenUtil.offerReversibleSmithingRecipe(exporter, RecipeCategory.MISC, Ingredient.ofItems(Items.REFINED_COPPER_INGOT), Ingredient.ofItems(IRON_INGOT), Items.CUFE_ALLOY);
		RecipeGenUtil.offer2x2CrossCompactingRecipe(exporter, RecipeCategory.MISC, Ingredient.ofItems(Items.REFINED_COPPER_INGOT), Ingredient.ofItems(GOLD_INGOT), Items.AUCU_ALLOY);
		RecipeGenUtil.offerReversibleSmithingRecipe(exporter, RecipeCategory.MISC, Ingredient.ofItems(Items.REFINED_COPPER_INGOT), Ingredient.ofItems(GOLD_INGOT), Items.AUCU_ALLOY);
		RecipeGenUtil.offer2x2CrossCompactingRecipe(exporter, RecipeCategory.MISC, Ingredient.ofItems(Items.CLEAN_COAL), Ingredient.ofItems(IRON_INGOT), Items.PIG_IRON);
		RecipeGenUtil.offerReversibleSmithingRecipe(exporter, RecipeCategory.MISC, Ingredient.ofItems(Items.CLEAN_COAL), Ingredient.ofItems(IRON_INGOT), Items.PIG_IRON);
		offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.REFINED_COPPER_NUGGET, RecipeCategory.MISC, Items.REFINED_COPPER_INGOT,
				convertBetween(Items.REFINED_COPPER_INGOT, Items.REFINED_COPPER_NUGGET), getItemPath(Items.REFINED_COPPER_INGOT), convertBetween(Items.REFINED_COPPER_NUGGET, Items.REFINED_COPPER_INGOT), getItemPath(Items.REFINED_COPPER_NUGGET));
		offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.CUFE_ALLOY_NUGGET, RecipeCategory.MISC, Items.CUFE_ALLOY_INGOT,
				convertBetween(Items.CUFE_ALLOY_INGOT, Items.CUFE_ALLOY_NUGGET), getItemPath(Items.CUFE_ALLOY_INGOT), convertBetween(Items.CUFE_ALLOY_NUGGET, Items.CUFE_ALLOY_INGOT), getItemPath(Items.CUFE_ALLOY_NUGGET));
		offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.AUCU_ALLOY_NUGGET, RecipeCategory.MISC, Items.AUCU_ALLOY_INGOT,
				convertBetween(Items.AUCU_ALLOY_INGOT, Items.AUCU_ALLOY_NUGGET), getItemPath(Items.AUCU_ALLOY_INGOT), convertBetween(Items.AUCU_ALLOY_NUGGET, Items.AUCU_ALLOY_INGOT), getItemPath(Items.AUCU_ALLOY_NUGGET));
		offerSmelting(exporter, ImmutableList.of(Items.COPPER_FOR_SMELTING_INGOT), RecipeCategory.MISC, Items.REFINED_COPPER_INGOT, 0.8F, TickUtil.getTick(20), getItemPath(Items.REFINED_COPPER_INGOT));
		offerBlasting(exporter, ImmutableList.of(Items.COPPER_FOR_SMELTING_INGOT), RecipeCategory.MISC, Items.REFINED_COPPER_INGOT, 0.8F, TickUtil.getTick(10), getItemPath(Items.REFINED_COPPER_INGOT));
		offerSmelting(exporter, ImmutableList.of(Items.CUFE_ALLOY), RecipeCategory.MISC, Items.CUFE_ALLOY_INGOT, 0.8F, TickUtil.getTick(20), getItemPath(Items.CUFE_ALLOY_INGOT));
		offerBlasting(exporter, ImmutableList.of(Items.CUFE_ALLOY), RecipeCategory.MISC, Items.CUFE_ALLOY_INGOT, 0.8F, TickUtil.getTick(10), getItemPath(Items.CUFE_ALLOY_INGOT));
		offerSmelting(exporter, ImmutableList.of(Items.AUCU_ALLOY), RecipeCategory.MISC, Items.AUCU_ALLOY_INGOT, 0.8F, TickUtil.getTick(20), getItemPath(Items.AUCU_ALLOY_INGOT));
		offerBlasting(exporter, ImmutableList.of(Items.AUCU_ALLOY), RecipeCategory.MISC, Items.AUCU_ALLOY_INGOT, 0.8F, TickUtil.getTick(10), getItemPath(Items.AUCU_ALLOY_INGOT));
		offerSmelting(exporter, ImmutableList.of(Items.PIG_IRON), RecipeCategory.MISC, Items.STEEL_INGOT, 0.8F, TickUtil.getTick(20), getItemPath(Items.STEEL_INGOT));
		offerBlasting(exporter, ImmutableList.of(Items.PIG_IRON), RecipeCategory.MISC, Items.STEEL_INGOT, 0.8F, TickUtil.getTick(10), getItemPath(Items.STEEL_INGOT));
		RecipeGenUtil.offerSmelting(exporter, ImmutableSet.of(Items.REFINED_COPPER_SHOVEL, Items.REFINED_COPPER_PICKAXE, Items.REFINED_COPPER_AXE, Items.REFINED_COPPER_HOE, Items.REFINED_COPPER_SWORD, Items.REFINED_COPPER_HELMET, Items.REFINED_COPPER_CHESTPLATE, Items.REFINED_COPPER_LEGGINGS, Items.REFINED_COPPER_BOOTS),
				Items.REFINED_COPPER_NUGGET, 0.15F, TickUtil.getTick(20), getItemPath(Items.REFINED_COPPER_NUGGET));
		RecipeGenUtil.offerBlasting(exporter, ImmutableSet.of(Items.REFINED_COPPER_SHOVEL, Items.REFINED_COPPER_PICKAXE, Items.REFINED_COPPER_AXE, Items.REFINED_COPPER_HOE, Items.REFINED_COPPER_SWORD, Items.REFINED_COPPER_HELMET, Items.REFINED_COPPER_CHESTPLATE, Items.REFINED_COPPER_LEGGINGS, Items.REFINED_COPPER_BOOTS),
				Items.REFINED_COPPER_NUGGET, 0.15F, TickUtil.getTick(10), getItemPath(Items.REFINED_COPPER_NUGGET));
		RecipeGenUtil.offerSmelting(exporter, ImmutableSet.of(Items.CUFE_ALLOY_SHOVEL, Items.CUFE_ALLOY_PICKAXE, Items.CUFE_ALLOY_AXE, Items.CUFE_ALLOY_HOE, Items.CUFE_ALLOY_SWORD, Items.CUFE_ALLOY_HELMET, Items.CUFE_ALLOY_CHESTPLATE, Items.CUFE_ALLOY_LEGGINGS, Items.CUFE_ALLOY_BOOTS),
				Items.CUFE_ALLOY_NUGGET, 0.15F, TickUtil.getTick(20), getItemPath(Items.CUFE_ALLOY_NUGGET));
		RecipeGenUtil.offerBlasting(exporter, ImmutableSet.of(Items.CUFE_ALLOY_SHOVEL, Items.CUFE_ALLOY_PICKAXE, Items.CUFE_ALLOY_AXE, Items.CUFE_ALLOY_HOE, Items.CUFE_ALLOY_SWORD, Items.CUFE_ALLOY_HELMET, Items.CUFE_ALLOY_CHESTPLATE, Items.CUFE_ALLOY_LEGGINGS, Items.CUFE_ALLOY_BOOTS),
				Items.CUFE_ALLOY_NUGGET, 0.15F, TickUtil.getTick(10), getItemPath(Items.CUFE_ALLOY_NUGGET));
		RecipeGenUtil.offerSmelting(exporter, ImmutableSet.of(Items.AUCU_ALLOY_SHOVEL, Items.AUCU_ALLOY_PICKAXE, Items.AUCU_ALLOY_AXE, Items.AUCU_ALLOY_HOE, Items.AUCU_ALLOY_SWORD, Items.AUCU_ALLOY_HELMET, Items.AUCU_ALLOY_CHESTPLATE, Items.AUCU_ALLOY_LEGGINGS, Items.AUCU_ALLOY_BOOTS),
				Items.AUCU_ALLOY_NUGGET, 0.15F, TickUtil.getTick(20), getItemPath(Items.AUCU_ALLOY_NUGGET));
		RecipeGenUtil.offerBlasting(exporter, ImmutableSet.of(Items.AUCU_ALLOY_SHOVEL, Items.AUCU_ALLOY_PICKAXE, Items.AUCU_ALLOY_AXE, Items.AUCU_ALLOY_HOE, Items.AUCU_ALLOY_SWORD, Items.AUCU_ALLOY_HELMET, Items.AUCU_ALLOY_CHESTPLATE, Items.AUCU_ALLOY_LEGGINGS, Items.AUCU_ALLOY_BOOTS),
				Items.AUCU_ALLOY_NUGGET, 0.15F, TickUtil.getTick(10), getItemPath(Items.AUCU_ALLOY_NUGGET));
		RecipeGenUtil.offerSmelting(exporter, ImmutableSet.of(Items.STEEL_SHOVEL, Items.STEEL_PICKAXE, Items.STEEL_AXE, Items.STEEL_HOE, Items.STEEL_SWORD, Items.STEEL_HELMET, Items.STEEL_CHESTPLATE, Items.STEEL_LEGGINGS, Items.STEEL_BOOTS),
				IRON_INGOT, 0.15F, TickUtil.getTick(20), getItemPath(IRON_INGOT));
		RecipeGenUtil.offerBlasting(exporter, ImmutableSet.of(Items.STEEL_SHOVEL, Items.STEEL_PICKAXE, Items.STEEL_AXE, Items.STEEL_HOE, Items.STEEL_SWORD, Items.STEEL_HELMET, Items.STEEL_CHESTPLATE, Items.STEEL_LEGGINGS, Items.STEEL_BOOTS),
				IRON_INGOT, 0.15F, TickUtil.getTick(10), getItemPath(IRON_INGOT));
		RecipeGenUtil.offerCrossCompactingRecipe(exporter, RecipeCategory.MISC, Ingredient.ofItems(STRING), Ingredient.ofItems(SPIDER_EYE), Items.COMPACT_GOSSAMER);
		RecipeGenUtil.offerCrossCompactingRecipe(exporter, RecipeCategory.MISC, Ingredient.ofItems(STRING), Ingredient.ofItems(SLIME_BALL), Items.STICKY_COMPACT_GOSSAMER);
		RecipeGenUtil.offerCrossCompactingRecipe(exporter, RecipeCategory.MISC, Ingredient.ofItems(STRING), Ingredient.ofItems(Items.COMPACT_GOSSAMER), Items.COMPACT_STRING);
		RecipeGenUtil.offerCrossCompactingRecipe(exporter, RecipeCategory.MISC, Ingredient.ofItems(Items.COMPACT_STRING), Ingredient.ofItems(Items.STICKY_COMPACT_GOSSAMER), Items.COMPOSITE_STRING);
		RecipeGenUtil.offer2x2CompactingRecipeWithRecipeGroup(exporter, RecipeCategory.MISC, Items.COMPOSITE_STRING, Items.COMPOSITE_FABRIC);
		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.COMPOSITE_STRING, 4).group(getItemPath(Items.COMPOSITE_STRING)).input(Items.COMPOSITE_FABRIC)
				.criterion(hasItem(Items.COMPOSITE_FABRIC), conditionsFromItem(Items.COMPOSITE_FABRIC))
				.offerTo(exporter, convertBetween(Items.COMPOSITE_FABRIC, Items.COMPOSITE_STRING));
		RecipeGenUtil.generateFamily(exporter, Ingredient.ofItems(Items.REFINED_COPPER_INGOT), EquipFamily.builder()
				.shovel(Items.REFINED_COPPER_SHOVEL).pickaxe(Items.REFINED_COPPER_PICKAXE).axe(Items.REFINED_COPPER_AXE).hoe(Items.REFINED_COPPER_HOE).sword(Items.REFINED_COPPER_SWORD)
				.helmet(Items.REFINED_COPPER_HELMET).chestplate(Items.REFINED_COPPER_CHESTPLATE).leggings(Items.REFINED_COPPER_LEGGINGS).boots(Items.REFINED_COPPER_BOOTS).build());
		RecipeGenUtil.generateFamily(exporter, Ingredient.ofItems(Items.CUFE_ALLOY_INGOT), EquipFamily.builder()
				.shovel(Items.CUFE_ALLOY_SHOVEL).pickaxe(Items.CUFE_ALLOY_PICKAXE).axe(Items.CUFE_ALLOY_AXE).hoe(Items.CUFE_ALLOY_HOE).sword(Items.CUFE_ALLOY_SWORD)
				.helmet(Items.CUFE_ALLOY_HELMET).chestplate(Items.CUFE_ALLOY_CHESTPLATE).leggings(Items.CUFE_ALLOY_LEGGINGS).boots(Items.CUFE_ALLOY_BOOTS).build());
		RecipeGenUtil.generateFamily(exporter, Ingredient.ofItems(Items.AUCU_ALLOY_INGOT), EquipFamily.builder()
				.shovel(Items.AUCU_ALLOY_SHOVEL).pickaxe(Items.AUCU_ALLOY_PICKAXE).axe(Items.AUCU_ALLOY_AXE).hoe(Items.AUCU_ALLOY_HOE).sword(Items.AUCU_ALLOY_SWORD)
				.helmet(Items.AUCU_ALLOY_HELMET).chestplate(Items.AUCU_ALLOY_CHESTPLATE).leggings(Items.AUCU_ALLOY_LEGGINGS).boots(Items.AUCU_ALLOY_BOOTS).build());
		RecipeGenUtil.generateFamily(exporter, Ingredient.ofItems(Items.STEEL_INGOT), EquipFamily.builder()
				.shovel(Items.STEEL_SHOVEL).pickaxe(Items.STEEL_PICKAXE).axe(Items.STEEL_AXE).hoe(Items.STEEL_HOE).sword(Items.STEEL_SWORD)
				.helmet(Items.STEEL_HELMET).chestplate(Items.STEEL_CHESTPLATE).leggings(Items.STEEL_LEGGINGS).boots(Items.STEEL_BOOTS).build());
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.ARROWPROOF_VEST).group(getItemPath(Items.ARROWPROOF_VEST)).input('#', Items.COMPOSITE_FABRIC).input('X', Items.STEEL_INGOT)
				.pattern("# #")
				.pattern("#X#")
				.pattern("#X#")
				.criterion(hasItem(Items.COMPOSITE_FABRIC), conditionsFromItem(Items.COMPOSITE_FABRIC))
				.criterion(hasItem(Items.STEEL_INGOT), conditionsFromItem(Items.STEEL_INGOT))
				.offerTo(exporter, getItemPath(Items.ARROWPROOF_VEST));
		ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.STONEBALL, 4).group(getItemPath(Items.STONEBALL)).input(COBBLESTONE)
				.criterion(hasItem(COBBLESTONE), conditionsFromItem(COBBLESTONE))
				.offerTo(exporter);
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.STEEL_ARROW).group(getItemPath(Items.STEEL_ARROW)).input('#', Items.STEEL_INGOT).input('X', IRON_INGOT)
				.pattern(" ##")
				.pattern(" X#")
				.pattern("#  ")
				.criterion(hasItem(Items.STEEL_INGOT), conditionsFromItem(Items.STEEL_INGOT))
				.criterion(hasItem(IRON_INGOT), conditionsFromItem(IRON_INGOT))
				.offerTo(exporter, getItemPath(Items.STEEL_ARROW));
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.SLINGSHOT).group(getItemPath(Items.SLINGSHOT)).input('#', STICK).input('X', Items.STICKY_COMPACT_GOSSAMER)
				.pattern("#X#")
				.pattern(" # ")
				.pattern(" # ")
				.criterion(hasItem(STICK), conditionsFromItem(STICK))
				.criterion(hasItem(Items.STICKY_COMPACT_GOSSAMER), conditionsFromItem(Items.STICKY_COMPACT_GOSSAMER))
				.offerTo(exporter, getItemPath(Items.SLINGSHOT));
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.RECURVE_BOW).group(getItemPath(Items.RECURVE_BOW)).input('#', Items.COMPACT_STRING).input('X', STRIPPED_SPRUCE_WOOD).input('@', LEATHER)
				.pattern("@X#")
				.pattern("X #")
				.pattern("@X#")
				.criterion(hasItem(Items.COMPACT_STRING), conditionsFromItem(Items.COMPACT_STRING))
				.criterion(hasItem(STRIPPED_SPRUCE_WOOD), conditionsFromItem(STRIPPED_SPRUCE_WOOD))
				.criterion(hasItem(LEATHER), conditionsFromItem(LEATHER))
				.offerTo(exporter, getItemPath(Items.RECURVE_BOW));
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.ARBALEST).group(getItemPath(Items.ARBALEST)).input('#', Items.COMPACT_STRING).input('X', Items.RECURVE_BOW).input('@', STRIPPED_ACACIA_WOOD).input('$', LEVER)
				.pattern("@X@")
				.pattern("#$#")
				.pattern(" @ ")
				.criterion(hasItem(Items.COMPACT_STRING), conditionsFromItem(Items.COMPACT_STRING))
				.criterion(hasItem(Items.RECURVE_BOW), conditionsFromItem(Items.RECURVE_BOW))
				.criterion(hasItem(STRIPPED_ACACIA_WOOD), conditionsFromItem(STRIPPED_ACACIA_WOOD))
				.offerTo(exporter, getItemPath(Items.ARBALEST));
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.COMPOUND_BOW).group(getItemPath(Items.COMPOUND_BOW)).input('#', Items.COMPOSITE_STRING).input('X', Items.STEEL_INGOT).input('@', DIAMOND).input('$', SPYGLASS)
				.pattern("$X@")
				.pattern("XX#")
				.pattern("@##")
				.criterion(hasItem(Items.COMPOSITE_STRING), conditionsFromItem(Items.COMPOSITE_STRING))
				.criterion(hasItem(Items.STEEL_INGOT), conditionsFromItem(Items.STEEL_INGOT))
				.criterion(hasItem(DIAMOND), conditionsFromItem(DIAMOND))
				.criterion(hasItem(SPYGLASS), conditionsFromItem(SPYGLASS))
				.offerTo(exporter, getItemPath(Items.COMPOUND_BOW));
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.ZHUGE_REPEATING_CROSSBOW).group(getItemPath(Items.ZHUGE_REPEATING_CROSSBOW)).input('#', Items.COMPOSITE_STRING).input('X', Items.ARBALEST).input('@', STRIPPED_CRIMSON_HYPHAE).input('$', CHEST)
				.pattern("$@#")
				.pattern("@X ")
				.pattern("# @")
				.criterion(hasItem(Items.COMPOSITE_STRING), conditionsFromItem(Items.COMPOSITE_STRING))
				.criterion(hasItem(Items.ARBALEST), conditionsFromItem(Items.ARBALEST))
				.criterion(hasItem(STRIPPED_CRIMSON_HYPHAE), conditionsFromItem(STRIPPED_CRIMSON_HYPHAE))
				.offerTo(exporter, getItemPath(Items.ZHUGE_REPEATING_CROSSBOW));
		ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.MARKS_CROSSBOW).group(getItemPath(Items.MARKS_CROSSBOW)).input('#', Items.COMPOSITE_STRING).input('X', Items.COMPOUND_BOW).input('@', STRIPPED_WARPED_HYPHAE).input('$', LEVER).input('&', NETHERITE_INGOT)
				.pattern("$@&")
				.pattern("@X#")
				.pattern("&#@")
				.criterion(hasItem(Items.COMPOSITE_STRING), conditionsFromItem(Items.COMPOSITE_STRING))
				.criterion(hasItem(Items.COMPOUND_BOW), conditionsFromItem(Items.COMPOUND_BOW))
				.criterion(hasItem(STRIPPED_WARPED_HYPHAE), conditionsFromItem(STRIPPED_WARPED_HYPHAE))
				.criterion(hasItem(NETHERITE_INGOT), conditionsFromItem(NETHERITE_INGOT))
				.offerTo(exporter, getItemPath(Items.MARKS_CROSSBOW));
		offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.COPPER_FOR_SMELTING_INGOT, RecipeCategory.BUILDING_BLOCKS, Items.COPPER_FOR_SMELTING_INGOT_BLOCK,
				convertBetween(Items.COPPER_FOR_SMELTING_INGOT_BLOCK, Items.COPPER_FOR_SMELTING_INGOT), getItemPath(Items.COPPER_FOR_SMELTING_INGOT_BLOCK), convertBetween(Items.COPPER_FOR_SMELTING_INGOT, Items.COPPER_FOR_SMELTING_INGOT_BLOCK), getItemPath(Items.COPPER_FOR_SMELTING_INGOT));
		offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.CUFE_ALLOY, RecipeCategory.BUILDING_BLOCKS, Items.CUFE_ALLOY_BLOCK,
				convertBetween(Items.CUFE_ALLOY_BLOCK, Items.CUFE_ALLOY), getItemPath(Items.CUFE_ALLOY_BLOCK), convertBetween(Items.CUFE_ALLOY, Items.CUFE_ALLOY_BLOCK), getItemPath(Items.CUFE_ALLOY));
		offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.AUCU_ALLOY, RecipeCategory.BUILDING_BLOCKS, Items.AUCU_ALLOY_BLOCK,
				convertBetween(Items.AUCU_ALLOY_BLOCK, Items.AUCU_ALLOY), getItemPath(Items.AUCU_ALLOY_BLOCK), convertBetween(Items.AUCU_ALLOY, Items.AUCU_ALLOY_BLOCK), getItemPath(Items.AUCU_ALLOY));
		offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.PIG_IRON, RecipeCategory.BUILDING_BLOCKS, Items.PIG_IRON_BLOCK,
				convertBetween(Items.PIG_IRON_BLOCK, Items.PIG_IRON), getItemPath(Items.PIG_IRON_BLOCK), convertBetween(Items.PIG_IRON, Items.PIG_IRON_BLOCK), getItemPath(Items.PIG_IRON));
		offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.REFINED_COPPER_INGOT, RecipeCategory.BUILDING_BLOCKS, Items.REFINED_COPPER_BLOCK,
				convertBetween(Items.REFINED_COPPER_BLOCK, Items.REFINED_COPPER_INGOT), getItemPath(Items.REFINED_COPPER_BLOCK), convertBetween(Items.REFINED_COPPER_INGOT, Items.REFINED_COPPER_BLOCK), getItemPath(Items.REFINED_COPPER_INGOT));
		offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.CUFE_ALLOY_INGOT, RecipeCategory.BUILDING_BLOCKS, Items.CUFE_BLOCK,
				convertBetween(Items.CUFE_BLOCK, Items.CUFE_ALLOY_INGOT), getItemPath(Items.CUFE_BLOCK), convertBetween(Items.CUFE_ALLOY_INGOT, Items.CUFE_BLOCK), getItemPath(Items.CUFE_ALLOY_INGOT));
		offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.AUCU_ALLOY_INGOT, RecipeCategory.BUILDING_BLOCKS, Items.AUCU_BLOCK,
				convertBetween(Items.AUCU_BLOCK, Items.AUCU_ALLOY_INGOT), getItemPath(Items.AUCU_BLOCK), convertBetween(Items.AUCU_ALLOY_INGOT, Items.AUCU_BLOCK), getItemPath(Items.AUCU_ALLOY_INGOT));
		offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.STEEL_INGOT, RecipeCategory.BUILDING_BLOCKS, Items.STEEL_BLOCK,
				convertBetween(Items.STEEL_BLOCK, Items.STEEL_INGOT), getItemPath(Items.STEEL_BLOCK), convertBetween(Items.STEEL_INGOT, Items.STEEL_BLOCK), getItemPath(Items.STEEL_INGOT));
	}
}
