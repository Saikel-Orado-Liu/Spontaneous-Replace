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

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import pers.saikel0rado1iu.silk.api.codex.OptionTexts;
import pers.saikel0rado1iu.silk.api.generate.data.LinkedLanguageProvider;
import pers.saikel0rado1iu.silk.api.modpass.pack.DataPack;
import pers.saikel0rado1iu.silk.api.modpass.pack.ResourcePack;
import pers.saikel0rado1iu.silk.api.pattern.widget.WidgetTexts;
import pers.saikel0rado1iu.spontaneousreplace.Settings;
import pers.saikel0rado1iu.spontaneousreplace.SpontaneousReplace;
import pers.saikel0rado1iu.spontaneousreplace.block.Blocks;
import pers.saikel0rado1iu.spontaneousreplace.item.ItemGroups;
import pers.saikel0rado1iu.spontaneousreplace.item.Items;
import pers.saikel0rado1iu.spontaneousreplace.sound.SoundEvents;

/**
 * <h2 style="color:FFC800">语言生成器</h2>
 * 自然更替的全球化语言生成器
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
interface LanguageGenerator {
	final class EnUs extends LinkedLanguageProvider {
		EnUs(FabricDataOutput dataOutput) {
			super(dataOutput, "en_us");
		}
		
		@Override
		public void generateTranslations(TranslationBuilder translationBuilder) {
			translationBuilder.add(comment("note"), "Origin Language is Simplified Chinese(zh_cn)");
			translationBuilder.add(i18nName(SpontaneousReplace.INSTANCE), "§6Spontaneous-Replace");
			translationBuilder.add(i18nSummary(SpontaneousReplace.INSTANCE), "Provide players with enhanced vanilla adventures with new content");
			translationBuilder.add(i18nDesc(SpontaneousReplace.INSTANCE), """
					§lMod introduction:§r
					     This mod will refine and expand certain aspects of Minecraft, while also providing a platform for mods with more interesting gameplay and features.
					§lMod Vision:§r
					     I hope to make a gameplay mod that is based on the core of the vanilla game and does not destroy the vanilla gameplay. It is very difficult to develop on this basis. Whether an item is added, how to design data so as not to destroy the balance of the game, These are all points that developers need to consider.
					     If you think the mod is doing a good job, you are welcome to sponsor my project, or translate this mod, thank your very much!""");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "placeholder"), "This function has NOT been added YET, Please continue to pay ATTENTION to the homepage of this Mod to get UPDATES in time.");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "home"), "Spontaneous-Replace");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "tab.mod"), "Mod");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "homepage"), "Homepage");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "support"), "Support");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "community"), "Discord");
			translationBuilder.add(WidgetTexts.titleKey(SpontaneousReplace.INSTANCE, "changelog"), "Changelog");
			translationBuilder.add(WidgetTexts.titleKey(SpontaneousReplace.INSTANCE, "target"), "1.0.0 > Target");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "target"), "    Fix mod bugs and attempt to add a crafting recipe for the fletching table.");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "tab.synopsis"), "Synopsis");
			translationBuilder.add(WidgetTexts.titleKey(SpontaneousReplace.INSTANCE, "tab.synopsis.intro"), "§f§lMod introduction:");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "tab.synopsis.intro"), """
					§r   This mod will refine and expand certain aspects of Minecraft, while also providing a platform for mods with more interesting gameplay and features.""");
			translationBuilder.add(WidgetTexts.titleKey(SpontaneousReplace.INSTANCE, "tab.synopsis.vision"), "§f§lMod Vision:");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "tab.synopsis.vision"), """
					§r   I hope to make a gameplay mod that is based on the core of the vanilla game and does not destroy the vanilla gameplay. It is very difficult to develop on this basis. Whether an item is added, how to design data so as not to destroy the balance of the game, These are all points that developers need to consider.
					§r   If you think the mod is doing a good job, you are welcome to sponsor my project, or translate this mod, thank your very much!""");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "tab.settings"), "Settings");
			translationBuilder.add(OptionTexts.rootKey(Settings.SETTINGS), "Setting Spontaneous-Replace...");
			translationBuilder.add(OptionTexts.textKey(Settings.AUTO_SHOW_SETTINGS_BUTTON), "Auto Show Setting Button");
			translationBuilder.add(OptionTexts.tipKey(Settings.AUTO_SHOW_SETTINGS_BUTTON, "on"), "Automatically close the option screen button if the Mod Menu is installed");
			translationBuilder.add(OptionTexts.tipKey(Settings.AUTO_SHOW_SETTINGS_BUTTON, "off"), "Always show the setting button in the options screen");
			translationBuilder.add(OptionTexts.textKey(Settings.DISABLE_WARNING_ADVICE), "Disable Warning Advice");
			translationBuilder.add(OptionTexts.textKey(Settings.DISABLE_WARNING_ADVICE, Settings.DisableWarningAdvice.NEED_OTHER_MOD.toString()), "Need Other Mod");
			translationBuilder.add(OptionTexts.tipKey(Settings.DISABLE_WARNING_ADVICE, Settings.DisableWarningAdvice.NEED_OTHER_MOD.toString()), "Go to https://modrinth.com/mod/dcwa Install this Mod enable feature");
			translationBuilder.add(DataPack.getNameKey(SpontaneousReplace.INSTANCE), "SR Data Pack");
			translationBuilder.add(DataPack.getDescKey(SpontaneousReplace.INSTANCE), "The default data for Spontaneous-Replace");
			translationBuilder.add(ResourcePack.getNameKey(SpontaneousReplace.INSTANCE), "SR Resource Pack");
			translationBuilder.add(ResourcePack.getDescKey(SpontaneousReplace.INSTANCE), "The default look and feel of Spontaneous-Replace");
			translationBuilder.add(ItemGroups.BUILDING_BLOCKS, "SR Building Blocks");
			translationBuilder.add(ItemGroups.COLORED_BLOCKS, "SR Colored Blocks");
			translationBuilder.add(ItemGroups.NATURAL, "SR Natural Blocks");
			translationBuilder.add(ItemGroups.FUNCTIONAL, "SR Functional Blocks");
			translationBuilder.add(ItemGroups.REDSTONE, "SR Redstone Blocks");
			translationBuilder.add(ItemGroups.TOOLS, "SR Tool & Utilities");
			translationBuilder.add(ItemGroups.COMBAT, "SR Combat");
			translationBuilder.add(ItemGroups.FOOD_AND_DRINK, "SR Food & Drinks");
			translationBuilder.add(ItemGroups.INGREDIENTS, "SR Ingredients");
			translationBuilder.add(ItemGroups.SPAWN_EGGS, "SR Spawn Eggs");
			translationBuilder.add(Items.CLEAN_COAL, "Clean Coal");
			translationBuilder.add(Items.COPPER_FOR_SMELTING_INGOT, "Copper For Smelting Ingot");
			translationBuilder.add(Items.CUFE_ALLOY, "CuFe Alloy");
			translationBuilder.add(Items.AUCU_ALLOY, "AuCu Alloy");
			translationBuilder.add(Items.PIG_IRON, "Pig Iron");
			translationBuilder.add(Items.REFINED_COPPER_NUGGET, "Refined Copper Nugget");
			translationBuilder.add(Items.CUFE_ALLOY_NUGGET, "CuFe Alloy Nugget");
			translationBuilder.add(Items.AUCU_ALLOY_NUGGET, "AuCu Alloy Nugget");
			translationBuilder.add(Items.REFINED_COPPER_INGOT, "Refined Copper Ingot");
			translationBuilder.add(Items.CUFE_ALLOY_INGOT, "CuFe Alloy Ingot");
			translationBuilder.add(Items.AUCU_ALLOY_INGOT, "AuCu Alloy Ingot");
			translationBuilder.add(Items.STEEL_INGOT, "Steel Ingot");
			translationBuilder.add(Items.COMPACT_GOSSAMER, "Compact Gossamer");
			translationBuilder.add(Items.STICKY_COMPACT_GOSSAMER, "Sticky Compact Gossamer");
			translationBuilder.add(Items.COMPACT_STRING, "Compact String");
			translationBuilder.add(Items.COMPOSITE_STRING, "Composite String");
			translationBuilder.add(Items.COMPOSITE_FABRIC, "Composite Fabric");
			translationBuilder.add(Items.REFINED_COPPER_SWORD, "Refined Copper Sword");
			translationBuilder.add(Items.CUFE_ALLOY_SWORD, "CuFe Alloy Sword");
			translationBuilder.add(Items.AUCU_ALLOY_SWORD, "AuCu Alloy Sword");
			translationBuilder.add(Items.STEEL_SWORD, "Steel Sword");
			translationBuilder.add(Items.REFINED_COPPER_SHOVEL, "Refined Copper Shovel");
			translationBuilder.add(Items.REFINED_COPPER_PICKAXE, "Refined Copper Pickaxe");
			translationBuilder.add(Items.REFINED_COPPER_AXE, "Refined Copper Axe");
			translationBuilder.add(Items.REFINED_COPPER_HOE, "Refined Copper Hoe");
			translationBuilder.add(Items.CUFE_ALLOY_SHOVEL, "CuFe Alloy Shovel");
			translationBuilder.add(Items.CUFE_ALLOY_PICKAXE, "CuFe Alloy Pickaxe");
			translationBuilder.add(Items.CUFE_ALLOY_AXE, "CuFe Alloy Axe");
			translationBuilder.add(Items.CUFE_ALLOY_HOE, "CuFe Alloy Hoe");
			translationBuilder.add(Items.AUCU_ALLOY_SHOVEL, "AuCu Alloy Shovel");
			translationBuilder.add(Items.AUCU_ALLOY_PICKAXE, "AuCu Alloy Pickaxe");
			translationBuilder.add(Items.AUCU_ALLOY_AXE, "AuCu Alloy Axe");
			translationBuilder.add(Items.AUCU_ALLOY_HOE, "AuCu Alloy Hoe");
			translationBuilder.add(Items.STEEL_SHOVEL, "Steel Shovel");
			translationBuilder.add(Items.STEEL_PICKAXE, "Steel Pickaxe");
			translationBuilder.add(Items.STEEL_AXE, "Steel Axe");
			translationBuilder.add(Items.STEEL_HOE, "Steel Hoe");
			translationBuilder.add(Items.REFINED_COPPER_HELMET, "Refined Copper Helmet");
			translationBuilder.add(Items.REFINED_COPPER_CHESTPLATE, "Refined Copper Chestplate");
			translationBuilder.add(Items.REFINED_COPPER_LEGGINGS, "Refined Copper Leggings");
			translationBuilder.add(Items.REFINED_COPPER_BOOTS, "Refined Copper Boots");
			translationBuilder.add(Items.CUFE_ALLOY_HELMET, "CuFe Alloy Helmet");
			translationBuilder.add(Items.CUFE_ALLOY_CHESTPLATE, "CuFe Alloy Chestplate");
			translationBuilder.add(Items.CUFE_ALLOY_LEGGINGS, "CuFe Alloy Leggings");
			translationBuilder.add(Items.CUFE_ALLOY_BOOTS, "CuFe Alloy Boots");
			translationBuilder.add(Items.AUCU_ALLOY_HELMET, "AuCu Alloy Helmet");
			translationBuilder.add(Items.AUCU_ALLOY_CHESTPLATE, "AuCu Alloy Chestplate");
			translationBuilder.add(Items.AUCU_ALLOY_LEGGINGS, "AuCu Alloy Leggings");
			translationBuilder.add(Items.AUCU_ALLOY_BOOTS, "AuCu Alloy Boots");
			translationBuilder.add(Items.STEEL_HELMET, "Steel Helmet");
			translationBuilder.add(Items.STEEL_CHESTPLATE, "Steel Chestplate");
			translationBuilder.add(Items.STEEL_LEGGINGS, "Steel Leggings");
			translationBuilder.add(Items.STEEL_BOOTS, "Steel Boots");
			translationBuilder.add(Items.ARROWPROOF_VEST, "Arrowproof Vest");
			translationBuilder.add(Items.STONEBALL, "Stoneball");
			translationBuilder.add(Items.STEEL_ARROW, "Steel Arrow");
			translationBuilder.add(Items.SLINGSHOT, "Slingshot");
			translationBuilder.add(Items.RECURVE_BOW, "Recurve Bow");
			translationBuilder.add(Items.ARBALEST, "Arbalest");
			translationBuilder.add(Items.COMPOUND_BOW, "Compound Bow");
			translationBuilder.add(Items.ZHUGE_REPEATING_CROSSBOW, "Zhuge Repeating Crossbow");
			translationBuilder.add(Items.MARKS_CROSSBOW, "Marks-Crossbow");
			translationBuilder.add(Blocks.COPPER_FOR_SMELTING_INGOT_BLOCK, "Block of Copper For Smelting Ingot");
			translationBuilder.add(Blocks.CUFE_ALLOY_BLOCK, "Block of CuFe Alloy");
			translationBuilder.add(Blocks.AUCU_ALLOY_BLOCK, "Block of AuCu Alloy");
			translationBuilder.add(Blocks.PIG_IRON_BLOCK, "Block of Pig Iron");
			translationBuilder.add(Blocks.REFINED_COPPER_BLOCK, "Block of Refined Copper");
			translationBuilder.add(Blocks.CUFE_BLOCK, "Block of CuFe");
			translationBuilder.add(Blocks.AUCU_BLOCK, "Block of AuCu");
			translationBuilder.add(Blocks.STEEL_BLOCK, "Block of Steel");
			translationBuilder.add(soundSub(SoundEvents.EQUIP_REFINED_COPPER), "Refined copper armor clanks");
			translationBuilder.add(soundSub(SoundEvents.EQUIP_CUFE_ALLOY), "CuFe alloy armor clangs");
			translationBuilder.add(soundSub(SoundEvents.EQUIP_AUCU_ALLOY), "AuCu alloy armor clinks");
			translationBuilder.add(soundSub(SoundEvents.EQUIP_STEEL), "Steel armor cling");
			translationBuilder.add(soundSub(SoundEvents.STONEBALL_THROW), "Stoneball flies");
			translationBuilder.add(soundSub(SoundEvents.SLINGSHOT_THROW), "Pellet fired");
			translationBuilder.add(soundSub(SoundEvents.ARBALEST_LOADING_START), "Arbalest charges up");
			translationBuilder.add(soundSub(SoundEvents.ARBALEST_LOADING_END), "Arbalest loads");
			translationBuilder.add(soundSub(SoundEvents.ARBALEST_SHOOT), "Arbalest fires");
			translationBuilder.add(soundSub(SoundEvents.JUGER_REPEATING_CROSSBOW_LOADING_START), "Zhuge repeating crossbow loads");
			translationBuilder.add(soundSub(SoundEvents.JUGER_REPEATING_CROSSBOW_LOADING_END), "Zhuge repeating crossbow charges up");
			translationBuilder.add(soundSub(SoundEvents.JUGER_REPEATING_CROSSBOW_SHOOT), "Zhuge repeating crossbow fires");
			translationBuilder.add(soundSub(SoundEvents.MARKS_CROSSBOW_LOADING_START), "Marks-Crossbow charges up");
			translationBuilder.add(soundSub(SoundEvents.MARKS_CROSSBOW_LOADING_END), "Marks-Crossbow loads");
			translationBuilder.add(soundSub(SoundEvents.MARKS_CROSSBOW_SHOOT), "Marks-Crossbow fires");
			translationBuilder.add(soundSub(SoundEvents.EQUIP_ARROWPROOF), "Arrowproof vest rustles");
			translationBuilder.add(advancementTitle(AdvancementGenerator.ROOT), "SR Vanilla Extension");
			translationBuilder.add(advancementDesc(AdvancementGenerator.ROOT), "Play the vanilla extension content provided to you by Natural Replacement");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_NEW_METAL), "Bold Attempt");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_NEW_METAL), "Try to crafting a new metal");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_REFINED_COPPER), "USEFUL Copper, At LAST!");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_REFINED_COPPER), "Smelting a refined copper ingot");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_REFINED_COPPER_PRODUCT), "'Refined Copper' Age");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_REFINED_COPPER_PRODUCT), "Use a refined copper product");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_ALLOY), "Alloycraft");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_ALLOY), "Smelt an alloy ingot");
			translationBuilder.add(advancementTitle(AdvancementGenerator.UPGRADE_IRON_PICKAXE), "Upgrade Again");
			translationBuilder.add(advancementDesc(AdvancementGenerator.UPGRADE_IRON_PICKAXE), "Upgrade your iron pickaxe to CuFe alloy");
			translationBuilder.add(advancementTitle(AdvancementGenerator.UPGRADE_IRON_ARMOR), "Alloy Gear");
			translationBuilder.add(advancementDesc(AdvancementGenerator.UPGRADE_IRON_ARMOR), "Create CuFe alloy equipment to replace your old armor");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_STEEL_PRODUCT), "Industrial Age");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_STEEL_PRODUCT), "Use a steel product");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_ALL_STEEL_ARMORS), "Hearts Of Steel");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_ALL_STEEL_ARMORS), "Have a full set of steel armor");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_ALL_NEW_METALS), "Alchemist");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_ALL_NEW_METALS), "Crafting all new metals");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_NEW_RANGED), "Era-Replace");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_NEW_RANGED), "Try to crafting a new ranged equipment");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_ARROWPROOF_VEST), "Bulletproof Vest?");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_ARROWPROOF_VEST), "Crafting a projectile defense equipment");
			translationBuilder.add(advancementTitle(AdvancementGenerator.USE_SLINGSHOT), "Can I Shoot Birds?");
			translationBuilder.add(advancementDesc(AdvancementGenerator.USE_SLINGSHOT), "Use a slingshot");
			translationBuilder.add(advancementTitle(AdvancementGenerator.USE_SLINGSHOT_WITH_ENDER_PEARL), "Portal 3");
			translationBuilder.add(advancementDesc(AdvancementGenerator.USE_SLINGSHOT_WITH_ENDER_PEARL), "Use slingshot to launch a ender pearl");
			translationBuilder.add(advancementTitle(AdvancementGenerator.USE_SLINGSHOT_WITH_POTION), "Avada Kedavra");
			translationBuilder.add(advancementDesc(AdvancementGenerator.USE_SLINGSHOT_WITH_POTION), "Use slingshot to launch a potion");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_JUGER_REPEATING_CROSSBOW), "Magical Chinese Repeating Crossbow");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_JUGER_REPEATING_CROSSBOW), "Have a unique Chinese repeating crossbow");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_LEGEND_JUGER_REPEATING_CROSSBOW), "Empty The Magazine");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_LEGEND_JUGER_REPEATING_CROSSBOW), "Find the legend Zhuge repeating crossbow");
			translationBuilder.add(advancementTitle(AdvancementGenerator.USE_JUGER_REPEATING_CROSSBOW_SHOT_1000_ARROWS), "Arrow Rain");
			translationBuilder.add(advancementDesc(AdvancementGenerator.USE_JUGER_REPEATING_CROSSBOW_SHOT_1000_ARROWS), "Shoot at least 1000 arrows with a Zhuge repeating crossbow");
			translationBuilder.add(advancementTitle(AdvancementGenerator.USE_JUGER_REPEATING_CROSSBOW_KILL_100_MONSTERS), "Rifleman");
			translationBuilder.add(advancementDesc(AdvancementGenerator.USE_JUGER_REPEATING_CROSSBOW_KILL_100_MONSTERS), "Kill at least 100 monsters with a Zhuge repeating crossbow");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_MARKS_CROSSBOW), "Magical Chinese Powerful Crossbow");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_MARKS_CROSSBOW), "Have a powerful Chinese ultra-long-range crossbow");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_LEGEND_MARKS_CROSSBOW), "Lock The Target");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_LEGEND_MARKS_CROSSBOW), "Find the legend marks-crossbow");
			translationBuilder.add(advancementTitle(AdvancementGenerator.MARKSMAN), "Marksman");
			translationBuilder.add(advancementDesc(AdvancementGenerator.MARKSMAN), "Hit the bullseye of a Target block from at least 200 meters away");
			translationBuilder.add(advancementTitle(AdvancementGenerator.SNIPING), "Sniping");
			translationBuilder.add(advancementDesc(AdvancementGenerator.SNIPING), "Kill a stray from at least 100 meters away");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_ALL_BASIC_RANGED), "Basic Ranged Weapon");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_ALL_BASIC_RANGED), "Have all basic ranged weapons");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_ALL_ENHANCED_RANGED), "Enhanced Ranged Weapon");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_ALL_ENHANCED_RANGED), "have all enhanced ranged weapons");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_ALL_RANGED), "Bow& Crossbow Collector");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_ALL_RANGED), "Have all ranged weapons");
		}
	}
	
	final class ZhCn extends LinkedLanguageProvider {
		ZhCn(FabricDataOutput dataOutput) {
			super(dataOutput, "zh_cn");
		}
		
		@Override
		public void generateTranslations(TranslationBuilder translationBuilder) {
			translationBuilder.add(comment("note"), "原生语言");
			translationBuilder.add(i18nName(SpontaneousReplace.INSTANCE), "§6自然更替");
			translationBuilder.add(i18nSummary(SpontaneousReplace.INSTANCE), "通过新内容为玩家提供加强的原版冒险");
			translationBuilder.add(i18nDesc(SpontaneousReplace.INSTANCE), """
					§l模组简介：§r
					　　此模组将完善部分·Minecraft·中部分内容并且进行拓展，也同时对更加有趣的玩法与功能的模组提供一个平台。
					§l模组愿景：§r
					　　我希望做一个基于原版游戏内核，不破坏原版游戏玩法的玩法类模组。在这基础上进行开发十分困难，一件物品是否加入，怎样设计数据才不会破坏游戏平衡性，这些都是开发者需要考虑的点。
					　　如果你觉得模组做的不错，欢迎对我的项目进行赞助，或者对此模组进行翻译，十分感谢你们!""");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "placeholder"), "此功能尚未添加，请继续关注本模组首页以及时获取更新。");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "home"), "自然更替");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "tab.mod"), "模组");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "homepage"), "模组官网");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "support"), "支持我们");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "community"), "官方社群");
			translationBuilder.add(WidgetTexts.titleKey(SpontaneousReplace.INSTANCE, "changelog"), "更新日志");
			translationBuilder.add(WidgetTexts.titleKey(SpontaneousReplace.INSTANCE, "target"), "1.0.0 > 目标");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "target"), "　　修复模组漏洞，并尝试为制箭台添加可合成配方。");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "tab.synopsis"), "简介");
			translationBuilder.add(WidgetTexts.titleKey(SpontaneousReplace.INSTANCE, "tab.synopsis.intro"), "§f§l模组简介：");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "tab.synopsis.intro"), """
					§r　　此模组将完善部分·Minecraft·中部分内容并且进行拓展，也同时对更加有趣的玩法与功能的模组提供一个平台。""");
			translationBuilder.add(WidgetTexts.titleKey(SpontaneousReplace.INSTANCE, "tab.synopsis.vision"), "§f§l模组愿景：");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "tab.synopsis.vision"), """
					§r　　我希望做一个基于原版游戏内核，不破坏原版游戏玩法的玩法类模组。在这基础上进行开发十分困难，一件物品是否加入，怎样设计数据才不会破坏游戏平衡性，这些都是开发者需要考虑的点。
					§r　　如果你觉得模组做的不错，欢迎对我的项目进行赞助，或者对此模组进行翻译，十分感谢你们!""");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "tab.settings"), "设置");
			translationBuilder.add(OptionTexts.rootKey(Settings.SETTINGS), "自然更替设置…");
			translationBuilder.add(OptionTexts.textKey(Settings.AUTO_SHOW_SETTINGS_BUTTON), "自动显示设置按钮");
			translationBuilder.add(OptionTexts.tipKey(Settings.AUTO_SHOW_SETTINGS_BUTTON, "on"), "如果安装模组菜单则自动关闭选项界面按钮");
			translationBuilder.add(OptionTexts.tipKey(Settings.AUTO_SHOW_SETTINGS_BUTTON, "off"), "始终在选项界面显示设置按钮");
			translationBuilder.add(OptionTexts.textKey(Settings.DISABLE_WARNING_ADVICE), "禁用“实验性设置”警告");
			translationBuilder.add(OptionTexts.textKey(Settings.DISABLE_WARNING_ADVICE, Settings.DisableWarningAdvice.NEED_OTHER_MOD.toString()), "需要其他模组");
			translationBuilder.add(OptionTexts.tipKey(Settings.DISABLE_WARNING_ADVICE, Settings.DisableWarningAdvice.NEED_OTHER_MOD.toString()), "前往 https://modrinth.com/mod/dcwa 安装此模组开启功能");
			translationBuilder.add(DataPack.getNameKey(SpontaneousReplace.INSTANCE), "「自然更替」数据包");
			translationBuilder.add(DataPack.getDescKey(SpontaneousReplace.INSTANCE), "「自然更替」的默认数据包");
			translationBuilder.add(ResourcePack.getNameKey(SpontaneousReplace.INSTANCE), "「自然更替」资源包");
			translationBuilder.add(ResourcePack.getDescKey(SpontaneousReplace.INSTANCE), "「自然更替」的默认观感");
			translationBuilder.add(ItemGroups.BUILDING_BLOCKS, "「自然更替」建筑方块");
			translationBuilder.add(ItemGroups.COLORED_BLOCKS, "「自然更替」染色方块");
			translationBuilder.add(ItemGroups.NATURAL, "「自然更替」自然方块");
			translationBuilder.add(ItemGroups.FUNCTIONAL, "「自然更替」功能方块");
			translationBuilder.add(ItemGroups.REDSTONE, "「自然更替」红石方块");
			translationBuilder.add(ItemGroups.TOOLS, "「自然更替」工具与实用物品");
			translationBuilder.add(ItemGroups.COMBAT, "「自然更替」战斗用品");
			translationBuilder.add(ItemGroups.FOOD_AND_DRINK, "「自然更替」食物与饮品");
			translationBuilder.add(ItemGroups.INGREDIENTS, "「自然更替」原材料");
			translationBuilder.add(ItemGroups.SPAWN_EGGS, "「自然更替」刷怪蛋");
			translationBuilder.add(Items.CLEAN_COAL, "精煤");
			translationBuilder.add(Items.COPPER_FOR_SMELTING_INGOT, "炼锭铜");
			translationBuilder.add(Items.CUFE_ALLOY, "铜铁合金");
			translationBuilder.add(Items.AUCU_ALLOY, "金铜合金");
			translationBuilder.add(Items.PIG_IRON, "生铁");
			translationBuilder.add(Items.REFINED_COPPER_NUGGET, "精铜粒");
			translationBuilder.add(Items.CUFE_ALLOY_NUGGET, "铜铁粒");
			translationBuilder.add(Items.AUCU_ALLOY_NUGGET, "金铜粒");
			translationBuilder.add(Items.REFINED_COPPER_INGOT, "精铜锭");
			translationBuilder.add(Items.CUFE_ALLOY_INGOT, "铜铁锭");
			translationBuilder.add(Items.AUCU_ALLOY_INGOT, "金铜锭");
			translationBuilder.add(Items.STEEL_INGOT, "钢锭");
			translationBuilder.add(Items.COMPACT_GOSSAMER, "致密蛛丝");
			translationBuilder.add(Items.STICKY_COMPACT_GOSSAMER, "黏密蛛丝");
			translationBuilder.add(Items.COMPACT_STRING, "致密丝线");
			translationBuilder.add(Items.COMPOSITE_STRING, "复合丝线");
			translationBuilder.add(Items.COMPOSITE_FABRIC, "复合面料");
			translationBuilder.add(Items.REFINED_COPPER_SWORD, "精铜剑");
			translationBuilder.add(Items.CUFE_ALLOY_SWORD, "铜铁剑");
			translationBuilder.add(Items.AUCU_ALLOY_SWORD, "金铜剑");
			translationBuilder.add(Items.STEEL_SWORD, "钢剑");
			translationBuilder.add(Items.REFINED_COPPER_SHOVEL, "精铜锹");
			translationBuilder.add(Items.REFINED_COPPER_PICKAXE, "精铜镐");
			translationBuilder.add(Items.REFINED_COPPER_AXE, "精铜斧");
			translationBuilder.add(Items.REFINED_COPPER_HOE, "精铜锄");
			translationBuilder.add(Items.CUFE_ALLOY_SHOVEL, "铜铁锹");
			translationBuilder.add(Items.CUFE_ALLOY_PICKAXE, "铜铁镐");
			translationBuilder.add(Items.CUFE_ALLOY_AXE, "铜铁斧");
			translationBuilder.add(Items.CUFE_ALLOY_HOE, "铜铁锄");
			translationBuilder.add(Items.AUCU_ALLOY_SHOVEL, "金铜锹");
			translationBuilder.add(Items.AUCU_ALLOY_PICKAXE, "金铜镐");
			translationBuilder.add(Items.AUCU_ALLOY_AXE, "金铜斧");
			translationBuilder.add(Items.AUCU_ALLOY_HOE, "金铜锄");
			translationBuilder.add(Items.STEEL_SHOVEL, "钢锹");
			translationBuilder.add(Items.STEEL_PICKAXE, "钢镐");
			translationBuilder.add(Items.STEEL_AXE, "钢斧");
			translationBuilder.add(Items.STEEL_HOE, "钢锄");
			translationBuilder.add(Items.REFINED_COPPER_HELMET, "精铜头盔");
			translationBuilder.add(Items.REFINED_COPPER_CHESTPLATE, "精铜胸甲");
			translationBuilder.add(Items.REFINED_COPPER_LEGGINGS, "精铜护腿");
			translationBuilder.add(Items.REFINED_COPPER_BOOTS, "精铜靴子");
			translationBuilder.add(Items.CUFE_ALLOY_HELMET, "铜铁头盔");
			translationBuilder.add(Items.CUFE_ALLOY_CHESTPLATE, "铜铁胸甲");
			translationBuilder.add(Items.CUFE_ALLOY_LEGGINGS, "铜铁护腿");
			translationBuilder.add(Items.CUFE_ALLOY_BOOTS, "铜铁靴子");
			translationBuilder.add(Items.AUCU_ALLOY_HELMET, "金铜头盔");
			translationBuilder.add(Items.AUCU_ALLOY_CHESTPLATE, "金铜胸甲");
			translationBuilder.add(Items.AUCU_ALLOY_LEGGINGS, "金铜护腿");
			translationBuilder.add(Items.AUCU_ALLOY_BOOTS, "金铜靴子");
			translationBuilder.add(Items.STEEL_HELMET, "钢头盔");
			translationBuilder.add(Items.STEEL_CHESTPLATE, "钢胸甲");
			translationBuilder.add(Items.STEEL_LEGGINGS, "钢护腿");
			translationBuilder.add(Items.STEEL_BOOTS, "钢靴子");
			translationBuilder.add(Items.ARROWPROOF_VEST, "防箭衣");
			translationBuilder.add(Items.STONEBALL, "石弹");
			translationBuilder.add(Items.STEEL_ARROW, "钢箭");
			translationBuilder.add(Items.SLINGSHOT, "丫弹弓");
			translationBuilder.add(Items.RECURVE_BOW, "反曲弓");
			translationBuilder.add(Items.ARBALEST, "劲弩");
			translationBuilder.add(Items.COMPOUND_BOW, "复合弓");
			translationBuilder.add(Items.ZHUGE_REPEATING_CROSSBOW, "诸葛连弩");
			translationBuilder.add(Items.MARKS_CROSSBOW, "神臂弩");
			translationBuilder.add(Blocks.COPPER_FOR_SMELTING_INGOT_BLOCK, "炼锭铜块");
			translationBuilder.add(Blocks.CUFE_ALLOY_BLOCK, "铜铁合金块");
			translationBuilder.add(Blocks.AUCU_ALLOY_BLOCK, "金铜合金块");
			translationBuilder.add(Blocks.PIG_IRON_BLOCK, "生铁块");
			translationBuilder.add(Blocks.REFINED_COPPER_BLOCK, "精铜块");
			translationBuilder.add(Blocks.CUFE_BLOCK, "铜铁块");
			translationBuilder.add(Blocks.AUCU_BLOCK, "金铜块");
			translationBuilder.add(Blocks.STEEL_BLOCK, "钢块");
			translationBuilder.add(soundSub(SoundEvents.EQUIP_REFINED_COPPER), "精铜盔甲：嗙嘡");
			translationBuilder.add(soundSub(SoundEvents.EQUIP_CUFE_ALLOY), "铜铁盔甲：钪锵");
			translationBuilder.add(soundSub(SoundEvents.EQUIP_AUCU_ALLOY), "金铜盔甲：铤镗");
			translationBuilder.add(soundSub(SoundEvents.EQUIP_STEEL), "钢盔甲：叮嘡");
			translationBuilder.add(soundSub(SoundEvents.STONEBALL_THROW), "石弹：飞出");
			translationBuilder.add(soundSub(SoundEvents.SLINGSHOT_THROW), "丫弹弓：投掷");
			translationBuilder.add(soundSub(SoundEvents.ARBALEST_LOADING_START), "劲弩：蓄力");
			translationBuilder.add(soundSub(SoundEvents.ARBALEST_LOADING_END), "劲弩：装填");
			translationBuilder.add(soundSub(SoundEvents.ARBALEST_SHOOT), "劲弩：发射");
			translationBuilder.add(soundSub(SoundEvents.JUGER_REPEATING_CROSSBOW_LOADING_START), "诸葛连弩：装填");
			translationBuilder.add(soundSub(SoundEvents.JUGER_REPEATING_CROSSBOW_LOADING_END), "诸葛连弩：张弩");
			translationBuilder.add(soundSub(SoundEvents.JUGER_REPEATING_CROSSBOW_SHOOT), "诸葛连弩：发射");
			translationBuilder.add(soundSub(SoundEvents.MARKS_CROSSBOW_LOADING_START), "神臂弩：蓄力");
			translationBuilder.add(soundSub(SoundEvents.MARKS_CROSSBOW_LOADING_END), "神臂弩：装填");
			translationBuilder.add(soundSub(SoundEvents.MARKS_CROSSBOW_SHOOT), "神臂弩：发射");
			translationBuilder.add(soundSub(SoundEvents.EQUIP_ARROWPROOF), "防箭衣：摩擦");
			translationBuilder.add(advancementTitle(AdvancementGenerator.ROOT), "「自然更替」原版拓展");
			translationBuilder.add(advancementDesc(AdvancementGenerator.ROOT), "游玩来自「自然更替」为您提供的原版拓展");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_NEW_METAL), "大胆的尝试");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_NEW_METAL), "尝试制作一种新的金属");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_REFINED_COPPER), "有用的铜，终于！");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_REFINED_COPPER), "冶炼出一块精铜锭");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_REFINED_COPPER_PRODUCT), "“精铜”时代");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_REFINED_COPPER_PRODUCT), "使用精铜制品");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_ALLOY), "合金工艺");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_ALLOY), "冶炼出一块合金锭");
			translationBuilder.add(advancementTitle(AdvancementGenerator.UPGRADE_IRON_PICKAXE), "再次升级");
			translationBuilder.add(advancementDesc(AdvancementGenerator.UPGRADE_IRON_PICKAXE), "把你的铁镐升级成铜铁合金");
			translationBuilder.add(advancementTitle(AdvancementGenerator.UPGRADE_IRON_ARMOR), "合金装备");
			translationBuilder.add(advancementDesc(AdvancementGenerator.UPGRADE_IRON_ARMOR), "打造铜铁合金装备来替换你的老旧装甲");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_STEEL_PRODUCT), "工业时代");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_STEEL_PRODUCT), "使用钢铁制品");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_ALL_STEEL_ARMORS), "钢铁雄心");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_ALL_STEEL_ARMORS), "获得一整套钢铁盔甲");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_ALL_NEW_METALS), "炼金术师");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_ALL_NEW_METALS), "制作出所有新金属");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_NEW_RANGED), "时代更替");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_NEW_RANGED), "尝试制作一种新型的远程装备");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_ARROWPROOF_VEST), "防弹衣？");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_ARROWPROOF_VEST), "制作一种弹射物防御装备");
			translationBuilder.add(advancementTitle(AdvancementGenerator.USE_SLINGSHOT), "能打鸟吗？");
			translationBuilder.add(advancementDesc(AdvancementGenerator.USE_SLINGSHOT), "使用一次丫弹弓");
			translationBuilder.add(advancementTitle(AdvancementGenerator.USE_SLINGSHOT_WITH_ENDER_PEARL), "传送门 3");
			translationBuilder.add(advancementDesc(AdvancementGenerator.USE_SLINGSHOT_WITH_ENDER_PEARL), "使用丫弹弓发射末影珍珠");
			translationBuilder.add(advancementTitle(AdvancementGenerator.USE_SLINGSHOT_WITH_POTION), "阿瓦达索命");
			translationBuilder.add(advancementDesc(AdvancementGenerator.USE_SLINGSHOT_WITH_POTION), "使用丫弹弓发射药水瓶");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_JUGER_REPEATING_CROSSBOW), "神奇的中国连弩");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_JUGER_REPEATING_CROSSBOW), "拥有一种独特的中国连发弩");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_LEGEND_JUGER_REPEATING_CROSSBOW), "清空弹仓");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_LEGEND_JUGER_REPEATING_CROSSBOW), "找到传说中的诸葛连弩");
			translationBuilder.add(advancementTitle(AdvancementGenerator.USE_JUGER_REPEATING_CROSSBOW_SHOT_1000_ARROWS), "箭雨");
			translationBuilder.add(advancementDesc(AdvancementGenerator.USE_JUGER_REPEATING_CROSSBOW_SHOT_1000_ARROWS), "使用诸葛连弩发射至少1000支箭");
			translationBuilder.add(advancementTitle(AdvancementGenerator.USE_JUGER_REPEATING_CROSSBOW_KILL_100_MONSTERS), "突击手");
			translationBuilder.add(advancementDesc(AdvancementGenerator.USE_JUGER_REPEATING_CROSSBOW_KILL_100_MONSTERS), "使用诸葛连弩击杀至少100只怪物");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_MARKS_CROSSBOW), "神奇的中国劲弩");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_MARKS_CROSSBOW), "使用一种强力的中国超远程弩");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_LEGEND_MARKS_CROSSBOW), "目标锁定");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_LEGEND_MARKS_CROSSBOW), "找到传说中的神臂弩");
			translationBuilder.add(advancementTitle(AdvancementGenerator.MARKSMAN), "神射手");
			translationBuilder.add(advancementDesc(AdvancementGenerator.MARKSMAN), "从至少200米外射中标靶的靶心");
			translationBuilder.add(advancementTitle(AdvancementGenerator.SNIPING), "狙击");
			translationBuilder.add(advancementDesc(AdvancementGenerator.SNIPING), "从100米开外击杀一只流浪者");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_ALL_BASIC_RANGED), "基础远程武器");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_ALL_BASIC_RANGED), "拥有所有的基础型远程武器");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_ALL_ENHANCED_RANGED), "增强远程武器");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_ALL_ENHANCED_RANGED), "拥有所有的增强型远程武器");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_ALL_RANGED), "弓弩收藏家");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_ALL_RANGED), "拥有所有的远程武器");
		}
	}
	
	final class ZhHk extends LinkedLanguageProvider {
		ZhHk(FabricDataOutput dataOutput) {
			super(dataOutput, "zh_hk");
		}
		
		@Override
		public void generateTranslations(TranslationBuilder translationBuilder) {
			translationBuilder.add(comment("note"), "原生語言為簡體中文(zh_cn)");
			translationBuilder.add(i18nName(SpontaneousReplace.INSTANCE), "§6自然更替");
			translationBuilder.add(i18nSummary(SpontaneousReplace.INSTANCE), "通過新內容為玩家提供加強嘅原版冒險");
			translationBuilder.add(i18nDesc(SpontaneousReplace.INSTANCE), """
					§l模組簡介:§r
					　　此模組將完善Minecraft中部分內容並且進行擴展，同時也為更加有趣嘅玩法與功能嘅模組提供一個平台。
					§l模組願景:§r
					　　我希望做一個基於原版遊戲內核，不破壞原版遊戲玩法嘅玩法類模組。在這基礎上進行開發十分困難，一件物品是否加入，怎樣設計數據才不會破壞遊戲平衡性，這些都是開發者需要考慮嘅點。
					　　如果你覺得模組做嘅不錯，歡迎對我嘅項目進行贊助，或者對此模組進行翻譯，十分感謝你們!""");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "placeholder"), "此功能尚未添加, 請繼續關注本模組首頁以及時獲取更新。");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "home"), "自然更替");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "tab.mod"), "模組");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "homepage"), "模組官網");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "support"), "支持我們");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "community"), "官方社羣");
			translationBuilder.add(WidgetTexts.titleKey(SpontaneousReplace.INSTANCE, "changelog"), "更新日誌");
			translationBuilder.add(WidgetTexts.titleKey(SpontaneousReplace.INSTANCE, "target"), "1.0.0 > 目標");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "target"), "　　修復模組漏洞，並嘗試為制箭台添加可合成配方。");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "tab.synopsis"), "簡介");
			translationBuilder.add(WidgetTexts.titleKey(SpontaneousReplace.INSTANCE, "tab.synopsis.intro"), "§f§l模組簡介：");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "tab.synopsis.intro"), """
					§r　　此模組將完善·Minecraft·中部分內容並且進行擴展，同時也為更加有趣嘅玩法與功能嘅模組提供一個平台。""");
			translationBuilder.add(WidgetTexts.titleKey(SpontaneousReplace.INSTANCE, "tab.synopsis.vision"), "§f§l模組願景：");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "tab.synopsis.vision"), """
					§r　　我希望做一個基於原版遊戲內核，不破壞原版遊戲玩法嘅玩法類模組。在這基礎上進行開發十分困難，一件物品是否加入，怎樣設計數據才不會破壞遊戲平衡性，這些都是開發者需要考慮嘅點。
					§r　　如果你覺得模組做嘅不錯，歡迎對我嘅項目進行贊助，或者對此模組進行翻譯，十分感謝你們!""");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "tab.settings"), "設定");
			translationBuilder.add(OptionTexts.rootKey(Settings.SETTINGS), "自然更替設定⋯⋯");
			translationBuilder.add(OptionTexts.textKey(Settings.AUTO_SHOW_SETTINGS_BUTTON), "自動顯示設定按鈕");
			translationBuilder.add(OptionTexts.tipKey(Settings.AUTO_SHOW_SETTINGS_BUTTON, "on"), "如果安裝模組菜單則自動關閉選項界面按鈕");
			translationBuilder.add(OptionTexts.tipKey(Settings.AUTO_SHOW_SETTINGS_BUTTON, "off"), "始終在選項界面顯示設定按鈕");
			translationBuilder.add(OptionTexts.textKey(Settings.DISABLE_WARNING_ADVICE), "禁用“實驗性質設定”警告");
			translationBuilder.add(OptionTexts.textKey(Settings.DISABLE_WARNING_ADVICE, Settings.DisableWarningAdvice.NEED_OTHER_MOD.toString()), "需要其他模組");
			translationBuilder.add(OptionTexts.tipKey(Settings.DISABLE_WARNING_ADVICE, Settings.DisableWarningAdvice.NEED_OTHER_MOD.toString()), "前往 https://modrinth.com/mod/dcwa 安裝此模組開啓功能");
			translationBuilder.add(DataPack.getNameKey(SpontaneousReplace.INSTANCE), "「自然更替」數據包");
			translationBuilder.add(DataPack.getDescKey(SpontaneousReplace.INSTANCE), "「自然更替」預設數據包");
			translationBuilder.add(ResourcePack.getNameKey(SpontaneousReplace.INSTANCE), "「自然更替」資源包");
			translationBuilder.add(ResourcePack.getDescKey(SpontaneousReplace.INSTANCE), "「自然更替」預設嘅外觀與環境效果");
			translationBuilder.add(ItemGroups.BUILDING_BLOCKS, "「自然更替」建築方塊");
			translationBuilder.add(ItemGroups.COLORED_BLOCKS, "「自然更替」染色方塊");
			translationBuilder.add(ItemGroups.NATURAL, "「自然更替」自然方塊");
			translationBuilder.add(ItemGroups.FUNCTIONAL, "「自然更替」功能方塊");
			translationBuilder.add(ItemGroups.REDSTONE, "「自然更替」紅石方塊");
			translationBuilder.add(ItemGroups.TOOLS, "「自然更替」工具與實用物品");
			translationBuilder.add(ItemGroups.COMBAT, "「自然更替」戰鬥");
			translationBuilder.add(ItemGroups.FOOD_AND_DRINK, "「自然更替」食物與飲品");
			translationBuilder.add(ItemGroups.INGREDIENTS, "「自然更替」原材料");
			translationBuilder.add(ItemGroups.SPAWN_EGGS, "「自然更替」生成蛋");
			translationBuilder.add(Items.CLEAN_COAL, "精煤");
			translationBuilder.add(Items.COPPER_FOR_SMELTING_INGOT, "煉錠銅");
			translationBuilder.add(Items.CUFE_ALLOY, "銅鐵合金");
			translationBuilder.add(Items.AUCU_ALLOY, "金銅合金");
			translationBuilder.add(Items.PIG_IRON, "生鐵");
			translationBuilder.add(Items.REFINED_COPPER_NUGGET, "精銅粒");
			translationBuilder.add(Items.CUFE_ALLOY_NUGGET, "銅鐵粒");
			translationBuilder.add(Items.AUCU_ALLOY_NUGGET, "金銅粒");
			translationBuilder.add(Items.REFINED_COPPER_INGOT, "精銅錠");
			translationBuilder.add(Items.CUFE_ALLOY_INGOT, "銅鐵錠");
			translationBuilder.add(Items.AUCU_ALLOY_INGOT, "金銅錠");
			translationBuilder.add(Items.STEEL_INGOT, "鋼錠");
			translationBuilder.add(Items.COMPACT_GOSSAMER, "緻密蛛絲");
			translationBuilder.add(Items.STICKY_COMPACT_GOSSAMER, "黏密蛛絲");
			translationBuilder.add(Items.COMPACT_STRING, "緻密絲線");
			translationBuilder.add(Items.COMPOSITE_STRING, "複合絲線");
			translationBuilder.add(Items.COMPOSITE_FABRIC, "複合面料");
			translationBuilder.add(Items.REFINED_COPPER_SWORD, "精銅劍");
			translationBuilder.add(Items.CUFE_ALLOY_SWORD, "銅鐵劍");
			translationBuilder.add(Items.AUCU_ALLOY_SWORD, "金銅劍");
			translationBuilder.add(Items.STEEL_SWORD, "鋼劍");
			translationBuilder.add(Items.REFINED_COPPER_SHOVEL, "精銅鏟");
			translationBuilder.add(Items.REFINED_COPPER_PICKAXE, "精銅鎬");
			translationBuilder.add(Items.REFINED_COPPER_AXE, "精銅斧頭");
			translationBuilder.add(Items.REFINED_COPPER_HOE, "精銅鋤頭");
			translationBuilder.add(Items.CUFE_ALLOY_SHOVEL, "銅鐵鏟");
			translationBuilder.add(Items.CUFE_ALLOY_PICKAXE, "銅鐵鎬");
			translationBuilder.add(Items.CUFE_ALLOY_AXE, "銅鐵斧頭");
			translationBuilder.add(Items.CUFE_ALLOY_HOE, "銅鐵鋤頭");
			translationBuilder.add(Items.AUCU_ALLOY_SHOVEL, "金銅鏟");
			translationBuilder.add(Items.AUCU_ALLOY_PICKAXE, "金銅鎬");
			translationBuilder.add(Items.AUCU_ALLOY_AXE, "金銅斧頭");
			translationBuilder.add(Items.AUCU_ALLOY_HOE, "金銅鋤頭");
			translationBuilder.add(Items.STEEL_SHOVEL, "鋼鏟");
			translationBuilder.add(Items.STEEL_PICKAXE, "鋼鎬");
			translationBuilder.add(Items.STEEL_AXE, "鋼斧頭");
			translationBuilder.add(Items.STEEL_HOE, "鋼鋤頭");
			translationBuilder.add(Items.REFINED_COPPER_HELMET, "精銅頭盔");
			translationBuilder.add(Items.REFINED_COPPER_CHESTPLATE, "精銅胸甲");
			translationBuilder.add(Items.REFINED_COPPER_LEGGINGS, "精銅護腳");
			translationBuilder.add(Items.REFINED_COPPER_BOOTS, "精銅靴");
			translationBuilder.add(Items.CUFE_ALLOY_HELMET, "銅鐵頭盔");
			translationBuilder.add(Items.CUFE_ALLOY_CHESTPLATE, "銅鐵胸甲");
			translationBuilder.add(Items.CUFE_ALLOY_LEGGINGS, "銅鐵護腳");
			translationBuilder.add(Items.CUFE_ALLOY_BOOTS, "銅鐵靴");
			translationBuilder.add(Items.AUCU_ALLOY_HELMET, "金銅頭盔");
			translationBuilder.add(Items.AUCU_ALLOY_CHESTPLATE, "金銅胸甲");
			translationBuilder.add(Items.AUCU_ALLOY_LEGGINGS, "金銅護腳");
			translationBuilder.add(Items.AUCU_ALLOY_BOOTS, "金銅靴");
			translationBuilder.add(Items.STEEL_HELMET, "鋼頭盔");
			translationBuilder.add(Items.STEEL_CHESTPLATE, "鋼胸甲");
			translationBuilder.add(Items.STEEL_LEGGINGS, "鋼護腳");
			translationBuilder.add(Items.STEEL_BOOTS, "鋼靴");
			translationBuilder.add(Items.ARROWPROOF_VEST, "防箭背心");
			translationBuilder.add(Items.STONEBALL, "石彈丸");
			translationBuilder.add(Items.STEEL_ARROW, "鋼箭矢");
			translationBuilder.add(Items.SLINGSHOT, "丫彈弓");
			translationBuilder.add(Items.RECURVE_BOW, "反曲弓");
			translationBuilder.add(Items.ARBALEST, "勁弩");
			translationBuilder.add(Items.COMPOUND_BOW, "複合弓");
			translationBuilder.add(Items.ZHUGE_REPEATING_CROSSBOW, "諸葛連弩");
			translationBuilder.add(Items.MARKS_CROSSBOW, "神臂弩");
			translationBuilder.add(Blocks.COPPER_FOR_SMELTING_INGOT_BLOCK, "煉錠銅磚");
			translationBuilder.add(Blocks.CUFE_ALLOY_BLOCK, "銅鐵合金磚");
			translationBuilder.add(Blocks.AUCU_ALLOY_BLOCK, "金銅合金磚");
			translationBuilder.add(Blocks.PIG_IRON_BLOCK, "生鐵磚");
			translationBuilder.add(Blocks.REFINED_COPPER_BLOCK, "精銅磚");
			translationBuilder.add(Blocks.CUFE_BLOCK, "銅鐵磚");
			translationBuilder.add(Blocks.AUCU_BLOCK, "金銅磚");
			translationBuilder.add(Blocks.STEEL_BLOCK, "鋼磚");
			translationBuilder.add(soundSub(SoundEvents.EQUIP_REFINED_COPPER), "裝備精铜盔甲");
			translationBuilder.add(soundSub(SoundEvents.EQUIP_CUFE_ALLOY), "裝備銅鐵盔甲");
			translationBuilder.add(soundSub(SoundEvents.EQUIP_AUCU_ALLOY), "裝備金銅盔甲");
			translationBuilder.add(soundSub(SoundEvents.EQUIP_STEEL), "裝備鋼盔甲");
			translationBuilder.add(soundSub(SoundEvents.STONEBALL_THROW), "石彈丸被掟出");
			translationBuilder.add(soundSub(SoundEvents.SLINGSHOT_THROW), "掟出聲");
			translationBuilder.add(soundSub(SoundEvents.ARBALEST_LOADING_START), "勁弩搭箭");
			translationBuilder.add(soundSub(SoundEvents.ARBALEST_LOADING_END), "勁弩裝填");
			translationBuilder.add(soundSub(SoundEvents.ARBALEST_SHOOT), "勁弩發射");
			translationBuilder.add(soundSub(SoundEvents.JUGER_REPEATING_CROSSBOW_LOADING_START), "諸葛連弩裝填");
			translationBuilder.add(soundSub(SoundEvents.JUGER_REPEATING_CROSSBOW_LOADING_END), "諸葛連弩搭箭");
			translationBuilder.add(soundSub(SoundEvents.JUGER_REPEATING_CROSSBOW_SHOOT), "諸葛連弩發射");
			translationBuilder.add(soundSub(SoundEvents.MARKS_CROSSBOW_LOADING_START), "神臂弩搭箭");
			translationBuilder.add(soundSub(SoundEvents.MARKS_CROSSBOW_LOADING_END), "神臂弩裝填");
			translationBuilder.add(soundSub(SoundEvents.MARKS_CROSSBOW_SHOOT), "神臂弩發射");
			translationBuilder.add(soundSub(SoundEvents.EQUIP_ARROWPROOF), "裝備防箭衣");
			translationBuilder.add(advancementTitle(AdvancementGenerator.ROOT), "「自然更替」原版拓展");
			translationBuilder.add(advancementDesc(AdvancementGenerator.ROOT), "遊玩來自「自然更替」為您提供嘅原版拓展");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_NEW_METAL), "大膽嘅嘗試");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_NEW_METAL), "嘗試製作一種新嘅金屬");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_REFINED_COPPER), "有用嘅銅，終於！");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_REFINED_COPPER), "冶煉出一塊精銅錠");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_REFINED_COPPER_PRODUCT), "“精銅”時代");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_REFINED_COPPER_PRODUCT), "使用精銅製品");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_ALLOY), "合金工藝");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_ALLOY), "冶煉出一塊合金錠");
			translationBuilder.add(advancementTitle(AdvancementGenerator.UPGRADE_IRON_PICKAXE), "再上一層樓");
			translationBuilder.add(advancementDesc(AdvancementGenerator.UPGRADE_IRON_PICKAXE), "把你嘅鐵鎬升級成銅鐵合金");
			translationBuilder.add(advancementTitle(AdvancementGenerator.UPGRADE_IRON_ARMOR), "Alloy Gear");
			translationBuilder.add(advancementDesc(AdvancementGenerator.UPGRADE_IRON_ARMOR), "打造銅鐵合金裝備來替換你嘅老舊裝甲");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_STEEL_PRODUCT), "工業時代");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_STEEL_PRODUCT), "使用鋼鐵製品");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_ALL_STEEL_ARMORS), "鋼鐵雄心");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_ALL_STEEL_ARMORS), "獲得一整套鋼鐵盔甲");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_ALL_NEW_METALS), "鍊金術師");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_ALL_NEW_METALS), "製作出所有新金屬");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_NEW_RANGED), "時代更替");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_NEW_RANGED), "嘗試製作一種新型嘅遠程裝備");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_ARROWPROOF_VEST), "防彈衣？");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_ARROWPROOF_VEST), "製作一種彈射物防禦裝備");
			translationBuilder.add(advancementTitle(AdvancementGenerator.USE_SLINGSHOT), "能打鳥嗎？");
			translationBuilder.add(advancementDesc(AdvancementGenerator.USE_SLINGSHOT), "使用一次丫彈弓");
			translationBuilder.add(advancementTitle(AdvancementGenerator.USE_SLINGSHOT_WITH_ENDER_PEARL), "傳送門 3");
			translationBuilder.add(advancementDesc(AdvancementGenerator.USE_SLINGSHOT_WITH_ENDER_PEARL), "使用丫彈弓發射末影珍珠");
			translationBuilder.add(advancementTitle(AdvancementGenerator.USE_SLINGSHOT_WITH_POTION), "阿瓦達索命");
			translationBuilder.add(advancementDesc(AdvancementGenerator.USE_SLINGSHOT_WITH_POTION), "使用丫彈弓發射藥水瓶");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_JUGER_REPEATING_CROSSBOW), "神奇嘅中國連弩");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_JUGER_REPEATING_CROSSBOW), "擁有一種獨特嘅中國連發弩");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_LEGEND_JUGER_REPEATING_CROSSBOW), "清空彈倉");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_LEGEND_JUGER_REPEATING_CROSSBOW), "找到傳説中嘅諸葛連弩");
			translationBuilder.add(advancementTitle(AdvancementGenerator.USE_JUGER_REPEATING_CROSSBOW_SHOT_1000_ARROWS), "箭雨");
			translationBuilder.add(advancementDesc(AdvancementGenerator.USE_JUGER_REPEATING_CROSSBOW_SHOT_1000_ARROWS), "使用諸葛連弩發射至少1000支箭");
			translationBuilder.add(advancementTitle(AdvancementGenerator.USE_JUGER_REPEATING_CROSSBOW_KILL_100_MONSTERS), "突擊手");
			translationBuilder.add(advancementDesc(AdvancementGenerator.USE_JUGER_REPEATING_CROSSBOW_KILL_100_MONSTERS), "使用諸葛連弩擊殺至少100只怪物");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_MARKS_CROSSBOW), "神奇嘅中國勁弩");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_MARKS_CROSSBOW), "使用一種強力嘅中國超遠程弩");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_LEGEND_MARKS_CROSSBOW), "目標鎖定");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_LEGEND_MARKS_CROSSBOW), "找到傳説中嘅神臂弩");
			translationBuilder.add(advancementTitle(AdvancementGenerator.MARKSMAN), "神射手");
			translationBuilder.add(advancementDesc(AdvancementGenerator.MARKSMAN), "喺至少 200 米外擊中標靶嘅靶心");
			translationBuilder.add(advancementTitle(AdvancementGenerator.SNIPING), "狙擊");
			translationBuilder.add(advancementDesc(AdvancementGenerator.SNIPING), "從至少 100 米之外射殺一個流浪者");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_ALL_BASIC_RANGED), "基礎遠程武器");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_ALL_BASIC_RANGED), "擁有所有嘅基礎型遠程武器");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_ALL_ENHANCED_RANGED), "增強遠程武器");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_ALL_ENHANCED_RANGED), "擁有所有嘅增強型遠程武器");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_ALL_RANGED), "弓弩收藏家");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_ALL_RANGED), "擁有所有嘅遠程武器");
		}
	}
	
	final class ZhTw extends LinkedLanguageProvider {
		ZhTw(FabricDataOutput dataOutput) {
			super(dataOutput, "zh_tw");
		}
		
		@Override
		public void generateTranslations(TranslationBuilder translationBuilder) {
			translationBuilder.add(comment("note"), "原生語言為簡體中文(zh_cn)");
			translationBuilder.add(i18nName(SpontaneousReplace.INSTANCE), "§6自然更替");
			translationBuilder.add(i18nSummary(SpontaneousReplace.INSTANCE), "透過新內容為玩家提供加強的原版冒險");
			translationBuilder.add(i18nDesc(SpontaneousReplace.INSTANCE), """
					§l模組簡介:§r
					　　此模組將完善·Minecraft·中部分內容並且進行擴展，也同時為更加有趣的玩法與功能的模組提供一個平台。
					§l模組願景:§r
					　　我希望做一個基於原版遊戲核心，不破壞原版遊戲玩法的玩法類模組。在這基礎上進行開發十分困難，一件物品是否加入，怎樣設計資料才不會破壞遊戲平衡性，這些都是開發者需要考慮的點。
					　　如果你覺得模組做的不錯，歡迎對我的專案進行贊助，或者對此模組進行翻譯，十分感謝你們!""");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "placeholder"), "此功能尚未新增, 請繼續關注本模組首頁以及時獲取更新。");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "home"), "自然更替");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "tab.mod"), "模組");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "homepage"), "模組官網");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "support"), "支援我們");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "community"), "官方社群");
			translationBuilder.add(WidgetTexts.titleKey(SpontaneousReplace.INSTANCE, "changelog"), "更新日誌");
			translationBuilder.add(WidgetTexts.titleKey(SpontaneousReplace.INSTANCE, "target"), "1.0.0 > 目標");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "target"), "　　修復模組漏洞，並嘗試為製箭台添加可合成配方。");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "tab.synopsis"), "簡介");
			translationBuilder.add(WidgetTexts.titleKey(SpontaneousReplace.INSTANCE, "tab.synopsis.intro"), "§f§l模組簡介：");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "tab.synopsis.intro"), """
					§r　　此模組將完善Minecraft中部分內容並且進行擴展，也同時為更加有趣的玩法與功能的模組提供一個平台。""");
			translationBuilder.add(WidgetTexts.titleKey(SpontaneousReplace.INSTANCE, "tab.synopsis.vision"), "§f§l模組願景：");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "tab.synopsis.vision"), """
					§r　　我希望做一個基於原版遊戲核心，不破壞原版遊戲玩法的玩法類模組。在這基礎上進行開發十分困難，一件物品是否加入，怎樣設計資料才不會破壞遊戲平衡性，這些都是開發者需要考慮的點。
					§r　　如果你覺得模組做的不錯，歡迎對我的專案進行贊助，或者對此模組進行翻譯，十分感謝你們!""");
			translationBuilder.add(WidgetTexts.textKey(SpontaneousReplace.INSTANCE, "tab.settings"), "設定");
			translationBuilder.add(OptionTexts.rootKey(Settings.SETTINGS), "自然更替設定...");
			translationBuilder.add(OptionTexts.textKey(Settings.AUTO_SHOW_SETTINGS_BUTTON), "自動顯示設定按鈕");
			translationBuilder.add(OptionTexts.tipKey(Settings.AUTO_SHOW_SETTINGS_BUTTON, "on"), "如果安裝模組選單則自動關閉選項介面按鈕");
			translationBuilder.add(OptionTexts.tipKey(Settings.AUTO_SHOW_SETTINGS_BUTTON, "off"), "始終在選項介面顯示設定按鈕");
			translationBuilder.add(OptionTexts.textKey(Settings.DISABLE_WARNING_ADVICE), "禁用“實驗性設定”警告");
			translationBuilder.add(OptionTexts.textKey(Settings.DISABLE_WARNING_ADVICE, Settings.DisableWarningAdvice.NEED_OTHER_MOD.toString()), "需要其他模組");
			translationBuilder.add(OptionTexts.tipKey(Settings.DISABLE_WARNING_ADVICE, Settings.DisableWarningAdvice.NEED_OTHER_MOD.toString()), "前往 https://modrinth.com/mod/dcwa 安裝此模組開啟功能");
			translationBuilder.add(DataPack.getNameKey(SpontaneousReplace.INSTANCE), "「自然更替」資料包");
			translationBuilder.add(DataPack.getDescKey(SpontaneousReplace.INSTANCE), "「自然更替」預設的資料包");
			translationBuilder.add(ResourcePack.getNameKey(SpontaneousReplace.INSTANCE), "「自然更替」資源包");
			translationBuilder.add(ResourcePack.getDescKey(SpontaneousReplace.INSTANCE), "「自然更替」預設的視覺與環境效果");
			translationBuilder.add(ItemGroups.BUILDING_BLOCKS, "「自然更替」建築方塊");
			translationBuilder.add(ItemGroups.COLORED_BLOCKS, "「自然更替」染色方塊");
			translationBuilder.add(ItemGroups.NATURAL, "「自然更替」自然方塊");
			translationBuilder.add(ItemGroups.FUNCTIONAL, "「自然更替」功能方塊");
			translationBuilder.add(ItemGroups.REDSTONE, "「自然更替」紅石方塊");
			translationBuilder.add(ItemGroups.TOOLS, "「自然更替」工具與實用物品");
			translationBuilder.add(ItemGroups.COMBAT, "「自然更替」戰鬥");
			translationBuilder.add(ItemGroups.FOOD_AND_DRINK, "「自然更替」食物與飲品");
			translationBuilder.add(ItemGroups.INGREDIENTS, "「自然更替」原材料");
			translationBuilder.add(ItemGroups.SPAWN_EGGS, "「自然更替」生怪蛋");
			translationBuilder.add(Items.CLEAN_COAL, "精煤");
			translationBuilder.add(Items.COPPER_FOR_SMELTING_INGOT, "煉錠銅");
			translationBuilder.add(Items.CUFE_ALLOY, "銅鐵合金");
			translationBuilder.add(Items.AUCU_ALLOY, "金銅合金");
			translationBuilder.add(Items.PIG_IRON, "生鐵");
			translationBuilder.add(Items.REFINED_COPPER_NUGGET, "精銅粒");
			translationBuilder.add(Items.CUFE_ALLOY_NUGGET, "銅鐵粒");
			translationBuilder.add(Items.AUCU_ALLOY_NUGGET, "金銅粒");
			translationBuilder.add(Items.REFINED_COPPER_INGOT, "精銅錠");
			translationBuilder.add(Items.CUFE_ALLOY_INGOT, "銅鐵錠");
			translationBuilder.add(Items.AUCU_ALLOY_INGOT, "金銅錠");
			translationBuilder.add(Items.STEEL_INGOT, "鋼錠");
			translationBuilder.add(Items.COMPACT_GOSSAMER, "緻密蛛絲");
			translationBuilder.add(Items.STICKY_COMPACT_GOSSAMER, "黏密蛛絲");
			translationBuilder.add(Items.COMPACT_STRING, "緻密絲線");
			translationBuilder.add(Items.COMPOSITE_STRING, "複合絲線");
			translationBuilder.add(Items.COMPOSITE_FABRIC, "複合面料");
			translationBuilder.add(Items.REFINED_COPPER_SWORD, "精銅劍");
			translationBuilder.add(Items.CUFE_ALLOY_SWORD, "銅鐵劍");
			translationBuilder.add(Items.AUCU_ALLOY_SWORD, "金銅劍");
			translationBuilder.add(Items.STEEL_SWORD, "鋼劍");
			translationBuilder.add(Items.REFINED_COPPER_SHOVEL, "精銅鏟");
			translationBuilder.add(Items.REFINED_COPPER_PICKAXE, "精銅鎬");
			translationBuilder.add(Items.REFINED_COPPER_AXE, "精銅斧");
			translationBuilder.add(Items.REFINED_COPPER_HOE, "精銅鋤");
			translationBuilder.add(Items.CUFE_ALLOY_SHOVEL, "銅鐵鏟");
			translationBuilder.add(Items.CUFE_ALLOY_PICKAXE, "銅鐵鎬");
			translationBuilder.add(Items.CUFE_ALLOY_AXE, "銅鐵斧");
			translationBuilder.add(Items.CUFE_ALLOY_HOE, "銅鐵鋤");
			translationBuilder.add(Items.AUCU_ALLOY_SHOVEL, "金銅鏟");
			translationBuilder.add(Items.AUCU_ALLOY_PICKAXE, "金銅鎬");
			translationBuilder.add(Items.AUCU_ALLOY_AXE, "金銅斧");
			translationBuilder.add(Items.AUCU_ALLOY_HOE, "金銅鋤");
			translationBuilder.add(Items.STEEL_SHOVEL, "鋼鏟");
			translationBuilder.add(Items.STEEL_PICKAXE, "鋼鎬");
			translationBuilder.add(Items.STEEL_AXE, "鋼斧");
			translationBuilder.add(Items.STEEL_HOE, "鋼鋤");
			translationBuilder.add(Items.REFINED_COPPER_HELMET, "精銅頭盔");
			translationBuilder.add(Items.REFINED_COPPER_CHESTPLATE, "精銅胸甲");
			translationBuilder.add(Items.REFINED_COPPER_LEGGINGS, "精銅護腿");
			translationBuilder.add(Items.REFINED_COPPER_BOOTS, "精銅靴子");
			translationBuilder.add(Items.CUFE_ALLOY_HELMET, "銅鐵頭盔");
			translationBuilder.add(Items.CUFE_ALLOY_CHESTPLATE, "銅鐵胸甲");
			translationBuilder.add(Items.CUFE_ALLOY_LEGGINGS, "銅鐵護腿");
			translationBuilder.add(Items.CUFE_ALLOY_BOOTS, "銅鐵靴子");
			translationBuilder.add(Items.AUCU_ALLOY_HELMET, "金銅頭盔");
			translationBuilder.add(Items.AUCU_ALLOY_CHESTPLATE, "金銅胸甲");
			translationBuilder.add(Items.AUCU_ALLOY_LEGGINGS, "金銅護腿");
			translationBuilder.add(Items.AUCU_ALLOY_BOOTS, "金銅靴子");
			translationBuilder.add(Items.STEEL_HELMET, "鋼製頭盔");
			translationBuilder.add(Items.STEEL_CHESTPLATE, "鋼製胸甲");
			translationBuilder.add(Items.STEEL_LEGGINGS, "鋼製護腿");
			translationBuilder.add(Items.STEEL_BOOTS, "鋼製靴子");
			translationBuilder.add(Items.ARROWPROOF_VEST, "防箭背心");
			translationBuilder.add(Items.STONEBALL, "石彈");
			translationBuilder.add(Items.STEEL_ARROW, "鋼箭矢");
			translationBuilder.add(Items.SLINGSHOT, "丫彈弓");
			translationBuilder.add(Items.RECURVE_BOW, "反曲弓");
			translationBuilder.add(Items.ARBALEST, "勁弩");
			translationBuilder.add(Items.COMPOUND_BOW, "複合弓");
			translationBuilder.add(Items.ZHUGE_REPEATING_CROSSBOW, "諸葛連弩");
			translationBuilder.add(Items.MARKS_CROSSBOW, "神臂弩");
			translationBuilder.add(Blocks.COPPER_FOR_SMELTING_INGOT_BLOCK, "煉錠銅方塊");
			translationBuilder.add(Blocks.CUFE_ALLOY_BLOCK, "銅鐵合金方塊");
			translationBuilder.add(Blocks.AUCU_ALLOY_BLOCK, "金銅合金方塊");
			translationBuilder.add(Blocks.PIG_IRON_BLOCK, "生鐵方塊");
			translationBuilder.add(Blocks.REFINED_COPPER_BLOCK, "精銅方塊");
			translationBuilder.add(Blocks.CUFE_BLOCK, "銅鐵方塊");
			translationBuilder.add(Blocks.AUCU_BLOCK, "金銅方塊");
			translationBuilder.add(Blocks.STEEL_BLOCK, "鋼方塊");
			translationBuilder.add(soundSub(SoundEvents.EQUIP_REFINED_COPPER), "精铜盔甲裝備聲");
			translationBuilder.add(soundSub(SoundEvents.EQUIP_CUFE_ALLOY), "銅鐵盔甲裝備聲");
			translationBuilder.add(soundSub(SoundEvents.EQUIP_AUCU_ALLOY), "金銅盔甲裝備聲");
			translationBuilder.add(soundSub(SoundEvents.EQUIP_STEEL), "鋼製盔甲裝備聲");
			translationBuilder.add(soundSub(SoundEvents.STONEBALL_THROW), "投擲石彈聲");
			translationBuilder.add(soundSub(SoundEvents.SLINGSHOT_THROW), "投擲彈丸");
			translationBuilder.add(soundSub(SoundEvents.ARBALEST_LOADING_START), "勁弩上弦");
			translationBuilder.add(soundSub(SoundEvents.ARBALEST_LOADING_END), "勁弩裝填");
			translationBuilder.add(soundSub(SoundEvents.ARBALEST_SHOOT), "勁弩發射");
			translationBuilder.add(soundSub(SoundEvents.JUGER_REPEATING_CROSSBOW_LOADING_START), "諸葛連弩裝填");
			translationBuilder.add(soundSub(SoundEvents.JUGER_REPEATING_CROSSBOW_LOADING_END), "諸葛連弩上弦");
			translationBuilder.add(soundSub(SoundEvents.JUGER_REPEATING_CROSSBOW_SHOOT), "諸葛連弩發射");
			translationBuilder.add(soundSub(SoundEvents.MARKS_CROSSBOW_LOADING_START), "神臂弩上弦");
			translationBuilder.add(soundSub(SoundEvents.MARKS_CROSSBOW_LOADING_END), "神臂弩裝填");
			translationBuilder.add(soundSub(SoundEvents.MARKS_CROSSBOW_SHOOT), "神臂弩發射");
			translationBuilder.add(soundSub(SoundEvents.EQUIP_ARROWPROOF), "防箭衣裝備聲");
			translationBuilder.add(advancementTitle(AdvancementGenerator.ROOT), "「自然更替」原版拓展");
			translationBuilder.add(advancementDesc(AdvancementGenerator.ROOT), "遊玩來自「自然更替」為您提供的原版拓展");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_NEW_METAL), "大膽的嘗試");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_NEW_METAL), "嘗試製作一種新的金屬");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_REFINED_COPPER), "有用的銅，終於！");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_REFINED_COPPER), "冶煉出精銅錠");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_REFINED_COPPER_PRODUCT), "“精銅”時代");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_REFINED_COPPER_PRODUCT), "使用精銅製品");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_ALLOY), "合金工藝");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_ALLOY), "冶煉出合金錠");
			translationBuilder.add(advancementTitle(AdvancementGenerator.UPGRADE_IRON_PICKAXE), "再次升級");
			translationBuilder.add(advancementDesc(AdvancementGenerator.UPGRADE_IRON_PICKAXE), "把你的鐵鎬升級成銅鐵合金");
			translationBuilder.add(advancementTitle(AdvancementGenerator.UPGRADE_IRON_ARMOR), "潜龍谍影");
			translationBuilder.add(advancementDesc(AdvancementGenerator.UPGRADE_IRON_ARMOR), "打造銅鐵合金裝備來替換你的老舊裝甲");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_STEEL_PRODUCT), "工業時代");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_STEEL_PRODUCT), "使用鋼鐵製品");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_ALL_STEEL_ARMORS), "鋼鐵雄心");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_ALL_STEEL_ARMORS), "獲得一整套鋼鐵盔甲");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_ALL_NEW_METALS), "鍊金術師");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_ALL_NEW_METALS), "製作出所有新金屬");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_NEW_RANGED), "時代更替");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_NEW_RANGED), "嘗試製作一種新型的遠端裝備");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_ARROWPROOF_VEST), "防彈衣？");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_ARROWPROOF_VEST), "製作一種彈射物防禦裝備");
			translationBuilder.add(advancementTitle(AdvancementGenerator.USE_SLINGSHOT), "能打鳥嗎？");
			translationBuilder.add(advancementDesc(AdvancementGenerator.USE_SLINGSHOT), "使用一次丫彈弓");
			translationBuilder.add(advancementTitle(AdvancementGenerator.USE_SLINGSHOT_WITH_ENDER_PEARL), "傳送門 3");
			translationBuilder.add(advancementDesc(AdvancementGenerator.USE_SLINGSHOT_WITH_ENDER_PEARL), "使用丫彈弓發射末影珍珠");
			translationBuilder.add(advancementTitle(AdvancementGenerator.USE_SLINGSHOT_WITH_POTION), "阿瓦達索命");
			translationBuilder.add(advancementDesc(AdvancementGenerator.USE_SLINGSHOT_WITH_POTION), "使用丫彈弓發射藥水瓶");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_JUGER_REPEATING_CROSSBOW), "神奇的中國連弩");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_JUGER_REPEATING_CROSSBOW), "擁有一種獨特的中國連發弩");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_LEGEND_JUGER_REPEATING_CROSSBOW), "清空彈倉");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_LEGEND_JUGER_REPEATING_CROSSBOW), "找到傳說中的諸葛連弩");
			translationBuilder.add(advancementTitle(AdvancementGenerator.USE_JUGER_REPEATING_CROSSBOW_SHOT_1000_ARROWS), "箭雨");
			translationBuilder.add(advancementDesc(AdvancementGenerator.USE_JUGER_REPEATING_CROSSBOW_SHOT_1000_ARROWS), "使用諸葛連弩發射至少1000支箭");
			translationBuilder.add(advancementTitle(AdvancementGenerator.USE_JUGER_REPEATING_CROSSBOW_KILL_100_MONSTERS), "突擊手");
			translationBuilder.add(advancementDesc(AdvancementGenerator.USE_JUGER_REPEATING_CROSSBOW_KILL_100_MONSTERS), "使用諸葛連弩擊殺至少100只怪物");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_A_MARKS_CROSSBOW), "神奇的中國勁弩");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_A_MARKS_CROSSBOW), "使用一種強力的中國超遠端弩");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_LEGEND_MARKS_CROSSBOW), "目標鎖定");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_LEGEND_MARKS_CROSSBOW), "找到傳說中的神臂弩");
			translationBuilder.add(advancementTitle(AdvancementGenerator.MARKSMAN), "神射手");
			translationBuilder.add(advancementDesc(AdvancementGenerator.MARKSMAN), "從至少200公尺外擊中標靶的靶心");
			translationBuilder.add(advancementTitle(AdvancementGenerator.SNIPING), "狙擊");
			translationBuilder.add(advancementDesc(AdvancementGenerator.SNIPING), "在距100公尺遠外的地方射殺一隻流髑");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_ALL_BASIC_RANGED), "基礎遠端武器");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_ALL_BASIC_RANGED), "擁有所有的基礎型遠端武器");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_ALL_ENHANCED_RANGED), "增強遠端武器");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_ALL_ENHANCED_RANGED), "擁有所有的增強型遠端武器");
			translationBuilder.add(advancementTitle(AdvancementGenerator.HAVE_ALL_RANGED), "弓弩收藏家");
			translationBuilder.add(advancementDesc(AdvancementGenerator.HAVE_ALL_RANGED), "擁有所有的遠端武器");
		}
	}
}
