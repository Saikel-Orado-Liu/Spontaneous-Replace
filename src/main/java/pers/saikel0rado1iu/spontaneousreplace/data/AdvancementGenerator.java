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

import com.google.common.base.Suppliers;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.OnKilledCriterion;
import net.minecraft.advancement.criterion.TargetHitCriterion;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.potion.Potions;
import net.minecraft.predicate.ComponentPredicate;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.entity.DistancePredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.entity.LootContextPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import pers.saikel0rado1iu.silk.api.generate.advancement.criterion.RangedKilledEntityCriterion;
import pers.saikel0rado1iu.silk.api.generate.advancement.criterion.ShotProjectileCriterion;
import pers.saikel0rado1iu.silk.api.generate.data.AdvancementGenUtil;
import pers.saikel0rado1iu.silk.api.spinningjenny.tag.EntityTypeTags;
import pers.saikel0rado1iu.spontaneousreplace.SpontaneousReplace;
import pers.saikel0rado1iu.spontaneousreplace.item.Items;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import static net.minecraft.item.Items.*;

/**
 * <h2 style="color:FFC800">进度生成器</h2>
 * 自然更替的进度生成器
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
final class AdvancementGenerator extends FabricAdvancementProvider {
	static final AdvancementEntry ROOT = AdvancementGenUtil.builder(SpontaneousReplace.INSTANCE, "root")
			.display(CRAFTING_TABLE, Identifier.of("textures/block/andesite.png"), AdvancementFrame.TASK, false, false, false)
			.criterion(RecipeProvider.hasItem(CRAFTING_TABLE), InventoryChangedCriterion.Conditions.items(CRAFTING_TABLE))
			.build();
	public static final AdvancementEntry HAVE_A_NEW_RANGED = AdvancementGenUtil.builder(SpontaneousReplace.INSTANCE, "have_a_new_ranged")
			.parent(ROOT)
			.display(Items.RECURVE_BOW, null, AdvancementFrame.TASK, true, true, false)
			.criterion(RecipeProvider.hasItem(Items.SLINGSHOT), InventoryChangedCriterion.Conditions.items(Items.SLINGSHOT))
			.criterion(RecipeProvider.hasItem(Items.RECURVE_BOW), InventoryChangedCriterion.Conditions.items(Items.RECURVE_BOW))
			.criterion(RecipeProvider.hasItem(Items.ARBALEST), InventoryChangedCriterion.Conditions.items(Items.ARBALEST))
			.criterion(RecipeProvider.hasItem(Items.COMPOUND_BOW), InventoryChangedCriterion.Conditions.items(Items.COMPOUND_BOW))
			.criterion(RecipeProvider.hasItem(Items.ZHUGE_REPEATING_CROSSBOW), InventoryChangedCriterion.Conditions.items(Items.ZHUGE_REPEATING_CROSSBOW))
			.criterion(RecipeProvider.hasItem(Items.MARKS_CROSSBOW), InventoryChangedCriterion.Conditions.items(Items.MARKS_CROSSBOW))
			.criterion(RecipeProvider.hasItem(Items.ARROWPROOF_VEST), InventoryChangedCriterion.Conditions.items(Items.ARROWPROOF_VEST))
			.requirements(AdvancementRequirements.anyOf(List.of(
					RecipeProvider.hasItem(Items.SLINGSHOT),
					RecipeProvider.hasItem(Items.RECURVE_BOW),
					RecipeProvider.hasItem(Items.ARBALEST),
					RecipeProvider.hasItem(Items.COMPOUND_BOW),
					RecipeProvider.hasItem(Items.ZHUGE_REPEATING_CROSSBOW),
					RecipeProvider.hasItem(Items.MARKS_CROSSBOW),
					RecipeProvider.hasItem(Items.ARROWPROOF_VEST))))
			.build();
	public static final AdvancementEntry HAVE_A_ARROWPROOF_VEST = AdvancementGenUtil.builder(SpontaneousReplace.INSTANCE, "have_a_arrowproof_vest")
			.parent(HAVE_A_NEW_RANGED)
			.display(Items.ARROWPROOF_VEST, null, AdvancementFrame.TASK, true, true, false)
			.criterion(RecipeProvider.hasItem(Items.ARROWPROOF_VEST), InventoryChangedCriterion.Conditions.items(Items.ARROWPROOF_VEST))
			.build();
	public static final AdvancementEntry USE_SLINGSHOT = AdvancementGenUtil.builder(SpontaneousReplace.INSTANCE, "use_slingshot")
			.parent(HAVE_A_NEW_RANGED)
			.display(Items.SLINGSHOT, null, AdvancementFrame.TASK, true, true, false)
			.criterion("use_slingshot", ShotProjectileCriterion.Conditions.ranged(Items.SLINGSHOT).build().create())
			.build();
	public static final AdvancementEntry USE_SLINGSHOT_WITH_ENDER_PEARL = AdvancementGenUtil.builder(SpontaneousReplace.INSTANCE, "use_slingshot_with_ender_pearl")
			.parent(USE_SLINGSHOT)
			.display(ENDER_PEARL, null, AdvancementFrame.TASK, true, true, false)
			.criterion("use_slingshot", ShotProjectileCriterion.Conditions.ranged(Items.SLINGSHOT).projectile(EntityPredicate.Builder.create().type(EntityType.ENDER_PEARL).build()).build().create())
			.build();
	public static final AdvancementEntry USE_SLINGSHOT_WITH_POTION = AdvancementGenUtil.builder(SpontaneousReplace.INSTANCE, "use_slingshot_with_potion")
			.parent(USE_SLINGSHOT)
			.display(PotionContentsComponent.createStack(SPLASH_POTION, Potions.HEALING), null, AdvancementFrame.TASK, true, true, false)
			.criterion("use_slingshot", ShotProjectileCriterion.Conditions.ranged(Items.SLINGSHOT).projectile(EntityPredicate.Builder.create().type(EntityType.POTION).build()).build().create())
			.build();
	public static final AdvancementEntry HAVE_A_ZHUGE_REPEATING_CROSSBOW = AdvancementGenUtil.builder(SpontaneousReplace.INSTANCE, "have_a_juger_repeating_crossbow")
			.parent(HAVE_A_NEW_RANGED)
			.display(Items.ZHUGE_REPEATING_CROSSBOW, null, AdvancementFrame.GOAL, true, true, false)
			.criterion(RecipeProvider.hasItem(Items.ZHUGE_REPEATING_CROSSBOW), InventoryChangedCriterion.Conditions.items(Items.ZHUGE_REPEATING_CROSSBOW))
			.build();
	public static final AdvancementEntry __HAVE_LEGEND_ZHUGE_REPEATING_CROSSBOW = AdvancementGenUtil.builder(SpontaneousReplace.INSTANCE, "have_legend_juger_repeating_crossbow")
			.parent(HAVE_A_ZHUGE_REPEATING_CROSSBOW)
			.display(Items.ZHUGE_REPEATING_CROSSBOW, null, AdvancementFrame.CHALLENGE, true, true, true)
			.criterion(RecipeProvider.hasItem(Items.ZHUGE_REPEATING_CROSSBOW), InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create().items(Items.ZHUGE_REPEATING_CROSSBOW)
					.component(ComponentPredicate.builder().add(DataComponentTypes.ENCHANTMENTS, Suppliers.memoize(() -> {
						ItemEnchantmentsComponent.Builder builder = new ItemEnchantmentsComponent.Builder(ItemEnchantmentsComponent.DEFAULT);
						return builder.build();
					}).get()).build()).build()))
			.rewards(AdvancementRewards.Builder.experience(100))
			.build();
	public static final AdvancementEntry USE_ZHUGE_REPEATING_CROSSBOW_SHOT_1000_ARROWS = AdvancementGenUtil.builder(SpontaneousReplace.INSTANCE, "use_juger_repeating_crossbow_shot_1000_arrows")
			.parent(HAVE_A_ZHUGE_REPEATING_CROSSBOW)
			.display(ARROW, null, AdvancementFrame.CHALLENGE, true, true, true)
			.criterion("use_juger_repeating_crossbow_shot_1000_arrows", ShotProjectileCriterion.Conditions.ranged(Items.ZHUGE_REPEATING_CROSSBOW).amount(NumberRange.IntRange.atLeast(1000)).build().create())
			.rewards(AdvancementRewards.Builder.experience(100))
			.build();
	public static final AdvancementEntry USE_ZHUGE_REPEATING_CROSSBOW_KILL_100_MONSTERS = AdvancementGenUtil.builder(SpontaneousReplace.INSTANCE, "use_juger_repeating_crossbow_kill_100_monsters")
			.parent(HAVE_A_ZHUGE_REPEATING_CROSSBOW)
			.display(SKELETON_SKULL, null, AdvancementFrame.CHALLENGE, true, true, true)
			.criterion("use_juger_repeating_crossbow_kill_100_monsters", RangedKilledEntityCriterion.Conditions.ranged(Items.ZHUGE_REPEATING_CROSSBOW)
					.target(EntityPredicate.Builder.create().type(EntityTypeTags.MONSTERS).build()).killed(NumberRange.IntRange.atLeast(100)).build().create())
			.rewards(AdvancementRewards.Builder.experience(100))
			.build();
	public static final AdvancementEntry HAVE_A_MARKS_CROSSBOW = AdvancementGenUtil.builder(SpontaneousReplace.INSTANCE, "have_a_marks_crossbow")
			.parent(HAVE_A_NEW_RANGED)
			.display(Items.MARKS_CROSSBOW, null, AdvancementFrame.GOAL, true, true, false)
			.criterion(RecipeProvider.hasItem(Items.MARKS_CROSSBOW), InventoryChangedCriterion.Conditions.items(Items.MARKS_CROSSBOW))
			.build();
	public static final AdvancementEntry MARKSMAN = AdvancementGenUtil.builder(SpontaneousReplace.INSTANCE, "marksman")
			.parent(HAVE_A_MARKS_CROSSBOW)
			.display(TARGET, null, AdvancementFrame.CHALLENGE, true, true, true)
			.criterion("bullseye", TargetHitCriterion.Conditions.create(NumberRange.IntRange.exactly(15),
					Optional.of(LootContextPredicate.create(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().distance(DistancePredicate.horizontal(NumberRange.DoubleRange.atLeast(200)))).build()))))
			.rewards(AdvancementRewards.Builder.experience(100))
			.build();
	public static final AdvancementEntry SNIPING = AdvancementGenUtil.builder(SpontaneousReplace.INSTANCE, "sniping")
			.parent(HAVE_A_MARKS_CROSSBOW)
			.display(Items.STEEL_ARROW, null, AdvancementFrame.CHALLENGE, true, true, true)
			.criterion("killed_stray", OnKilledCriterion.Conditions.createEntityKilledPlayer(Optional.of(EntityPredicate.Builder.create().type(EntityType.STRAY).distance(DistancePredicate.horizontal(NumberRange.DoubleRange.exactly(100))).build())))
			.rewards(AdvancementRewards.Builder.experience(100))
			.build();
	public static final AdvancementEntry __HAVE_LEGEND_MARKS_CROSSBOW = AdvancementGenUtil.builder(SpontaneousReplace.INSTANCE, "have_legend_marks_crossbow")
			.parent(HAVE_A_MARKS_CROSSBOW)
			.display(Items.MARKS_CROSSBOW, null, AdvancementFrame.CHALLENGE, true, true, true)
			.criterion(RecipeProvider.hasItem(Items.MARKS_CROSSBOW), InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create().items(Items.MARKS_CROSSBOW)
					.component(ComponentPredicate.builder().add(DataComponentTypes.ENCHANTMENTS, Suppliers.memoize(() -> {
						ItemEnchantmentsComponent.Builder builder = new ItemEnchantmentsComponent.Builder(ItemEnchantmentsComponent.DEFAULT);
						return builder.build();
					}).get()).build()).build()))
			.rewards(AdvancementRewards.Builder.experience(100))
			.build();
	public static final AdvancementEntry HAVE_ALL_BASIC_RANGED = AdvancementGenUtil.builder(SpontaneousReplace.INSTANCE, "have_all_basic_ranged")
			.parent(HAVE_A_NEW_RANGED)
			.display(Items.ARBALEST, null, AdvancementFrame.TASK, true, true, false)
			.criterion(RecipeProvider.hasItem(Items.SLINGSHOT), InventoryChangedCriterion.Conditions.items(Items.SLINGSHOT))
			.criterion(RecipeProvider.hasItem(Items.RECURVE_BOW), InventoryChangedCriterion.Conditions.items(Items.RECURVE_BOW))
			.criterion(RecipeProvider.hasItem(Items.ARBALEST), InventoryChangedCriterion.Conditions.items(Items.ARBALEST))
			.build();
	public static final AdvancementEntry HAVE_ALL_ENHANCED_RANGED = AdvancementGenUtil.builder(SpontaneousReplace.INSTANCE, "have_all_enhanced_ranged")
			.parent(HAVE_ALL_BASIC_RANGED)
			.display(Items.ZHUGE_REPEATING_CROSSBOW, null, AdvancementFrame.TASK, true, true, false)
			.criterion(RecipeProvider.hasItem(Items.COMPOUND_BOW), InventoryChangedCriterion.Conditions.items(Items.COMPOUND_BOW))
			.criterion(RecipeProvider.hasItem(Items.ZHUGE_REPEATING_CROSSBOW), InventoryChangedCriterion.Conditions.items(Items.ZHUGE_REPEATING_CROSSBOW))
			.criterion(RecipeProvider.hasItem(Items.MARKS_CROSSBOW), InventoryChangedCriterion.Conditions.items(Items.MARKS_CROSSBOW))
			.build();
	public static final AdvancementEntry HAVE_ALL_RANGED = AdvancementGenUtil.builder(SpontaneousReplace.INSTANCE, "have_all_ranged")
			.parent(HAVE_ALL_ENHANCED_RANGED)
			.display(Items.MARKS_CROSSBOW, null, AdvancementFrame.CHALLENGE, true, true, true)
			.criterion(RecipeProvider.hasItem(BOW), InventoryChangedCriterion.Conditions.items(BOW))
			.criterion(RecipeProvider.hasItem(CROSSBOW), InventoryChangedCriterion.Conditions.items(CROSSBOW))
			.criterion(RecipeProvider.hasItem(Items.SLINGSHOT), InventoryChangedCriterion.Conditions.items(Items.SLINGSHOT))
			.criterion(RecipeProvider.hasItem(Items.RECURVE_BOW), InventoryChangedCriterion.Conditions.items(Items.RECURVE_BOW))
			.criterion(RecipeProvider.hasItem(Items.ARBALEST), InventoryChangedCriterion.Conditions.items(Items.ARBALEST))
			.criterion(RecipeProvider.hasItem(Items.COMPOUND_BOW), InventoryChangedCriterion.Conditions.items(Items.COMPOUND_BOW))
			.criterion(RecipeProvider.hasItem(Items.ZHUGE_REPEATING_CROSSBOW), InventoryChangedCriterion.Conditions.items(Items.ZHUGE_REPEATING_CROSSBOW))
			.criterion(RecipeProvider.hasItem(Items.MARKS_CROSSBOW), InventoryChangedCriterion.Conditions.items(Items.MARKS_CROSSBOW))
			.build();
	static final AdvancementEntry HAVE_A_NEW_METAL = AdvancementGenUtil.builder(SpontaneousReplace.INSTANCE, "have_a_new_metal")
			.parent(ROOT)
			.display(Items.COPPER_FOR_SMELTING_INGOT, null, AdvancementFrame.TASK, true, true, false)
			.criterion(RecipeProvider.hasItem(Items.COPPER_FOR_SMELTING_INGOT), InventoryChangedCriterion.Conditions.items(Items.COPPER_FOR_SMELTING_INGOT))
			.criterion(RecipeProvider.hasItem(Items.CUFE_ALLOY), InventoryChangedCriterion.Conditions.items(Items.CUFE_ALLOY))
			.criterion(RecipeProvider.hasItem(Items.AUCU_ALLOY), InventoryChangedCriterion.Conditions.items(Items.AUCU_ALLOY))
			.criterion(RecipeProvider.hasItem(Items.PIG_IRON), InventoryChangedCriterion.Conditions.items(Items.PIG_IRON))
			.requirements(AdvancementRequirements.anyOf(List.of(
					RecipeProvider.hasItem(Items.COPPER_FOR_SMELTING_INGOT),
					RecipeProvider.hasItem(Items.CUFE_ALLOY),
					RecipeProvider.hasItem(Items.AUCU_ALLOY),
					RecipeProvider.hasItem(Items.PIG_IRON))))
			.build();
	static final AdvancementEntry HAVE_A_REFINED_COPPER = AdvancementGenUtil.builder(SpontaneousReplace.INSTANCE, "have_a_refined_copper")
			.parent(HAVE_A_NEW_METAL)
			.display(Items.REFINED_COPPER_INGOT, null, AdvancementFrame.TASK, true, true, false)
			.criterion(RecipeProvider.hasItem(Items.REFINED_COPPER_INGOT), InventoryChangedCriterion.Conditions.items(Items.REFINED_COPPER_INGOT))
			.build();
	static final AdvancementEntry HAVE_A_REFINED_COPPER_PRODUCT = AdvancementGenUtil.builder(SpontaneousReplace.INSTANCE, "have_a_refined_copper_product")
			.parent(HAVE_A_REFINED_COPPER)
			.display(Items.REFINED_COPPER_SWORD, null, AdvancementFrame.TASK, true, true, false)
			.criterion(RecipeProvider.hasItem(Items.REFINED_COPPER_SHOVEL), InventoryChangedCriterion.Conditions.items(Items.REFINED_COPPER_SHOVEL))
			.criterion(RecipeProvider.hasItem(Items.REFINED_COPPER_PICKAXE), InventoryChangedCriterion.Conditions.items(Items.REFINED_COPPER_PICKAXE))
			.criterion(RecipeProvider.hasItem(Items.REFINED_COPPER_AXE), InventoryChangedCriterion.Conditions.items(Items.REFINED_COPPER_AXE))
			.criterion(RecipeProvider.hasItem(Items.REFINED_COPPER_HOE), InventoryChangedCriterion.Conditions.items(Items.REFINED_COPPER_HOE))
			.criterion(RecipeProvider.hasItem(Items.REFINED_COPPER_SWORD), InventoryChangedCriterion.Conditions.items(Items.REFINED_COPPER_SWORD))
			.criterion(RecipeProvider.hasItem(Items.REFINED_COPPER_HELMET), InventoryChangedCriterion.Conditions.items(Items.REFINED_COPPER_HELMET))
			.criterion(RecipeProvider.hasItem(Items.REFINED_COPPER_CHESTPLATE), InventoryChangedCriterion.Conditions.items(Items.REFINED_COPPER_CHESTPLATE))
			.criterion(RecipeProvider.hasItem(Items.REFINED_COPPER_LEGGINGS), InventoryChangedCriterion.Conditions.items(Items.REFINED_COPPER_LEGGINGS))
			.criterion(RecipeProvider.hasItem(Items.REFINED_COPPER_BOOTS), InventoryChangedCriterion.Conditions.items(Items.REFINED_COPPER_BOOTS))
			.requirements(AdvancementRequirements.anyOf(List.of(
					RecipeProvider.hasItem(Items.REFINED_COPPER_SHOVEL),
					RecipeProvider.hasItem(Items.REFINED_COPPER_PICKAXE),
					RecipeProvider.hasItem(Items.REFINED_COPPER_AXE),
					RecipeProvider.hasItem(Items.REFINED_COPPER_HOE),
					RecipeProvider.hasItem(Items.REFINED_COPPER_SWORD),
					RecipeProvider.hasItem(Items.REFINED_COPPER_HELMET),
					RecipeProvider.hasItem(Items.REFINED_COPPER_CHESTPLATE),
					RecipeProvider.hasItem(Items.REFINED_COPPER_LEGGINGS),
					RecipeProvider.hasItem(Items.REFINED_COPPER_BOOTS))))
			.build();
	static final AdvancementEntry HAVE_A_ALLOY = AdvancementGenUtil.builder(SpontaneousReplace.INSTANCE, "have_a_alloy")
			.parent(HAVE_A_NEW_METAL)
			.display(Items.CUFE_ALLOY_INGOT, null, AdvancementFrame.TASK, true, true, false)
			.criterion(RecipeProvider.hasItem(Items.CUFE_ALLOY_INGOT), InventoryChangedCriterion.Conditions.items(Items.CUFE_ALLOY_INGOT))
			.criterion(RecipeProvider.hasItem(Items.AUCU_ALLOY_INGOT), InventoryChangedCriterion.Conditions.items(Items.AUCU_ALLOY_INGOT))
			.criterion(RecipeProvider.hasItem(Items.STEEL_INGOT), InventoryChangedCriterion.Conditions.items(Items.STEEL_INGOT))
			.requirements(AdvancementRequirements.anyOf(List.of(
					RecipeProvider.hasItem(Items.CUFE_ALLOY_INGOT),
					RecipeProvider.hasItem(Items.AUCU_ALLOY_INGOT),
					RecipeProvider.hasItem(Items.STEEL_INGOT))))
			.build();
	static final AdvancementEntry UPGRADE_IRON_PICKAXE = AdvancementGenUtil.builder(SpontaneousReplace.INSTANCE, "upgrade_iron_pickaxe")
			.parent(HAVE_A_ALLOY)
			.display(Items.CUFE_ALLOY_PICKAXE, null, AdvancementFrame.TASK, true, true, false)
			.criterion(RecipeProvider.hasItem(Items.CUFE_ALLOY_PICKAXE), InventoryChangedCriterion.Conditions.items(Items.CUFE_ALLOY_PICKAXE))
			.build();
	static final AdvancementEntry UPGRADE_IRON_ARMOR = AdvancementGenUtil.builder(SpontaneousReplace.INSTANCE, "upgrade_iron_armor")
			.parent(UPGRADE_IRON_PICKAXE)
			.display(Items.CUFE_ALLOY_CHESTPLATE, null, AdvancementFrame.TASK, true, true, false)
			.criterion(RecipeProvider.hasItem(Items.CUFE_ALLOY_HELMET), InventoryChangedCriterion.Conditions.items(Items.CUFE_ALLOY_HELMET))
			.criterion(RecipeProvider.hasItem(Items.CUFE_ALLOY_CHESTPLATE), InventoryChangedCriterion.Conditions.items(Items.CUFE_ALLOY_CHESTPLATE))
			.criterion(RecipeProvider.hasItem(Items.CUFE_ALLOY_LEGGINGS), InventoryChangedCriterion.Conditions.items(Items.CUFE_ALLOY_LEGGINGS))
			.criterion(RecipeProvider.hasItem(Items.CUFE_ALLOY_BOOTS), InventoryChangedCriterion.Conditions.items(Items.CUFE_ALLOY_BOOTS))
			.requirements(AdvancementRequirements.anyOf(List.of(
					RecipeProvider.hasItem(Items.CUFE_ALLOY_HELMET),
					RecipeProvider.hasItem(Items.CUFE_ALLOY_CHESTPLATE),
					RecipeProvider.hasItem(Items.CUFE_ALLOY_LEGGINGS),
					RecipeProvider.hasItem(Items.CUFE_ALLOY_BOOTS))))
			.build();
	static final AdvancementEntry HAVE_A_STEEL_PRODUCT = AdvancementGenUtil.builder(SpontaneousReplace.INSTANCE, "have_a_steel_product")
			.parent(HAVE_A_ALLOY)
			.display(Items.STEEL_SWORD, null, AdvancementFrame.TASK, true, true, false)
			.criterion(RecipeProvider.hasItem(Items.STEEL_SHOVEL), InventoryChangedCriterion.Conditions.items(Items.STEEL_SHOVEL))
			.criterion(RecipeProvider.hasItem(Items.STEEL_PICKAXE), InventoryChangedCriterion.Conditions.items(Items.STEEL_PICKAXE))
			.criterion(RecipeProvider.hasItem(Items.STEEL_AXE), InventoryChangedCriterion.Conditions.items(Items.STEEL_AXE))
			.criterion(RecipeProvider.hasItem(Items.STEEL_HOE), InventoryChangedCriterion.Conditions.items(Items.STEEL_HOE))
			.criterion(RecipeProvider.hasItem(Items.STEEL_SWORD), InventoryChangedCriterion.Conditions.items(Items.STEEL_SWORD))
			.criterion(RecipeProvider.hasItem(Items.STEEL_HELMET), InventoryChangedCriterion.Conditions.items(Items.STEEL_HELMET))
			.criterion(RecipeProvider.hasItem(Items.STEEL_CHESTPLATE), InventoryChangedCriterion.Conditions.items(Items.STEEL_CHESTPLATE))
			.criterion(RecipeProvider.hasItem(Items.STEEL_LEGGINGS), InventoryChangedCriterion.Conditions.items(Items.STEEL_LEGGINGS))
			.criterion(RecipeProvider.hasItem(Items.STEEL_BOOTS), InventoryChangedCriterion.Conditions.items(Items.STEEL_BOOTS))
			.requirements(AdvancementRequirements.anyOf(List.of(
					RecipeProvider.hasItem(Items.STEEL_SHOVEL),
					RecipeProvider.hasItem(Items.STEEL_PICKAXE),
					RecipeProvider.hasItem(Items.STEEL_AXE),
					RecipeProvider.hasItem(Items.STEEL_HOE),
					RecipeProvider.hasItem(Items.STEEL_SWORD),
					RecipeProvider.hasItem(Items.STEEL_HELMET),
					RecipeProvider.hasItem(Items.STEEL_CHESTPLATE),
					RecipeProvider.hasItem(Items.STEEL_LEGGINGS),
					RecipeProvider.hasItem(Items.STEEL_BOOTS))))
			.build();
	static final AdvancementEntry HAVE_ALL_STEEL_ARMORS = AdvancementGenUtil.builder(SpontaneousReplace.INSTANCE, "have_all_steel_armors")
			.parent(HAVE_A_STEEL_PRODUCT)
			.display(Items.STEEL_CHESTPLATE, null, AdvancementFrame.TASK, true, true, false)
			.criterion(RecipeProvider.hasItem(Items.STEEL_HELMET), InventoryChangedCriterion.Conditions.items(Items.STEEL_HELMET))
			.criterion(RecipeProvider.hasItem(Items.STEEL_CHESTPLATE), InventoryChangedCriterion.Conditions.items(Items.STEEL_CHESTPLATE))
			.criterion(RecipeProvider.hasItem(Items.STEEL_LEGGINGS), InventoryChangedCriterion.Conditions.items(Items.STEEL_LEGGINGS))
			.criterion(RecipeProvider.hasItem(Items.STEEL_BOOTS), InventoryChangedCriterion.Conditions.items(Items.STEEL_BOOTS))
			.build();
	static final AdvancementEntry HAVE_ALL_NEW_METALS = AdvancementGenUtil.builder(SpontaneousReplace.INSTANCE, "have_all_new_metals")
			.parent(HAVE_A_NEW_METAL)
			.display(Items.PIG_IRON, null, AdvancementFrame.TASK, true, true, false)
			.criterion(RecipeProvider.hasItem(Items.REFINED_COPPER_INGOT), InventoryChangedCriterion.Conditions.items(Items.REFINED_COPPER_INGOT))
			.criterion(RecipeProvider.hasItem(Items.CUFE_ALLOY_INGOT), InventoryChangedCriterion.Conditions.items(Items.CUFE_ALLOY_INGOT))
			.criterion(RecipeProvider.hasItem(Items.AUCU_ALLOY_INGOT), InventoryChangedCriterion.Conditions.items(Items.AUCU_ALLOY_INGOT))
			.criterion(RecipeProvider.hasItem(Items.STEEL_INGOT), InventoryChangedCriterion.Conditions.items(Items.STEEL_INGOT))
			.build();
	
	AdvancementGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(output, registryLookup);
	}
	
	@Override
	public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {
		RegistryEntryLookup<Enchantment> lookup = wrapperLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
		AdvancementEntry haveLegendJugerRepeatingCrossbow = AdvancementGenUtil.builder(SpontaneousReplace.INSTANCE, "have_legend_juger_repeating_crossbow")
				.parent(HAVE_A_ZHUGE_REPEATING_CROSSBOW)
				.display(Items.ZHUGE_REPEATING_CROSSBOW, null, AdvancementFrame.CHALLENGE, true, true, true)
				.criterion(RecipeProvider.hasItem(Items.ZHUGE_REPEATING_CROSSBOW), InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create().items(Items.ZHUGE_REPEATING_CROSSBOW)
						.component(ComponentPredicate.builder().add(DataComponentTypes.ENCHANTMENTS, Suppliers.memoize(() -> {
							ItemEnchantmentsComponent.Builder builder = new ItemEnchantmentsComponent.Builder(ItemEnchantmentsComponent.DEFAULT);
							builder.add(lookup.getOrThrow(Enchantments.MULTISHOT), 1);
							builder.add(lookup.getOrThrow(Enchantments.QUICK_CHARGE), 3);
							builder.add(lookup.getOrThrow(Enchantments.UNBREAKING), 5);
							return builder.build();
						}).get()).build()).build()))
				.rewards(AdvancementRewards.Builder.experience(100))
				.build();
		AdvancementEntry haveLegendMarksCrossbow = AdvancementGenUtil.builder(SpontaneousReplace.INSTANCE, "have_legend_marks_crossbow")
				.parent(HAVE_A_MARKS_CROSSBOW)
				.display(Items.MARKS_CROSSBOW, null, AdvancementFrame.CHALLENGE, true, true, true)
				.criterion(RecipeProvider.hasItem(Items.MARKS_CROSSBOW), InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create().items(Items.MARKS_CROSSBOW)
						.component(ComponentPredicate.builder().add(DataComponentTypes.ENCHANTMENTS, Suppliers.memoize(() -> {
							ItemEnchantmentsComponent.Builder builder = new ItemEnchantmentsComponent.Builder(ItemEnchantmentsComponent.DEFAULT);
							builder.add(lookup.getOrThrow(Enchantments.PIERCING), 4);
							builder.add(lookup.getOrThrow(Enchantments.QUICK_CHARGE), 3);
							builder.add(lookup.getOrThrow(Enchantments.UNBREAKING), 5);
							return builder.build();
						}).get()).build()).build()))
				.rewards(AdvancementRewards.Builder.experience(100))
				.build();
		consumer.accept(ROOT);
		consumer.accept(HAVE_A_NEW_METAL);
		consumer.accept(HAVE_A_REFINED_COPPER);
		consumer.accept(HAVE_A_REFINED_COPPER_PRODUCT);
		consumer.accept(HAVE_A_ALLOY);
		consumer.accept(UPGRADE_IRON_PICKAXE);
		consumer.accept(UPGRADE_IRON_ARMOR);
		consumer.accept(HAVE_A_STEEL_PRODUCT);
		consumer.accept(HAVE_ALL_STEEL_ARMORS);
		consumer.accept(HAVE_ALL_NEW_METALS);
		consumer.accept(HAVE_A_NEW_RANGED);
		consumer.accept(HAVE_A_ARROWPROOF_VEST);
		consumer.accept(USE_SLINGSHOT);
		consumer.accept(USE_SLINGSHOT_WITH_ENDER_PEARL);
		consumer.accept(USE_SLINGSHOT_WITH_POTION);
		consumer.accept(HAVE_A_ZHUGE_REPEATING_CROSSBOW);
		consumer.accept(haveLegendJugerRepeatingCrossbow);
		consumer.accept(USE_ZHUGE_REPEATING_CROSSBOW_SHOT_1000_ARROWS);
		consumer.accept(USE_ZHUGE_REPEATING_CROSSBOW_KILL_100_MONSTERS);
		consumer.accept(HAVE_A_MARKS_CROSSBOW);
		consumer.accept(haveLegendMarksCrossbow);
		consumer.accept(MARKSMAN);
		consumer.accept(SNIPING);
		consumer.accept(HAVE_ALL_BASIC_RANGED);
		consumer.accept(HAVE_ALL_ENHANCED_RANGED);
		consumer.accept(HAVE_ALL_RANGED);
	}
}
