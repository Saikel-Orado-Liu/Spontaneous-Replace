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

import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.math.Vec3d;
import pers.saikel0rado1iu.silk.api.generate.data.ModelGenUtil;
import pers.saikel0rado1iu.silk.api.generate.data.client.ExtendedBlockStateModelGenerator;
import pers.saikel0rado1iu.silk.api.generate.data.client.ExtendedItemModelGenerator;
import pers.saikel0rado1iu.silk.api.generate.data.client.TextureKeys;
import pers.saikel0rado1iu.silk.api.ropestick.component.type.RangedWeaponComponent;
import pers.saikel0rado1iu.silk.api.ropestick.component.type.ShootProjectilesComponent;
import pers.saikel0rado1iu.silk.impl.SilkApi;
import pers.saikel0rado1iu.spontaneousreplace.block.Blocks;
import pers.saikel0rado1iu.spontaneousreplace.item.ItemGroups;
import pers.saikel0rado1iu.spontaneousreplace.item.Items;
import pers.saikel0rado1iu.spontaneousreplace.item.MarksCrossbowItem;
import pers.saikel0rado1iu.spontaneousreplace.item.ZhugeRepeatingCrossbowItem;

import java.util.Map;
import java.util.Optional;

import static pers.saikel0rado1iu.silk.api.generate.data.client.Models.STEREOSCOPIC_ITEM;

/**
 * <h2 style="color:FFC800">模型生成器</h2>
 * 自然更替的模型生成器
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
final class ModelGenerator extends FabricModelProvider {
	ModelGenerator(FabricDataOutput output) {
		super(output);
	}
	
	private static TextureMap getTextureMap(Item item, String suffix) {
		Map<TextureKey, String> map = ImmutableMap.of(
				TextureKeys.LAYER7, suffix + "_lay0",
				TextureKeys.LAYER8, suffix + "_lay1",
				TextureKeys.LAYER9, suffix + "_lay1",
				TextureKeys.LAYER10, suffix + "_lay1",
				TextureKeys.LAYER11, suffix + "_lay2");
		TextureMap textureMap = new TextureMap();
		for (TextureKey textureKey : TextureKeys.STEREOSCOPIC_ITEM_TEXTURE_KEYS) {
			textureMap.put(textureKey, map.containsKey(textureKey) ? TextureMap.getSubId(item, map.get(textureKey)) : SilkApi.getInstance().ofId("item/none"));
		}
		return textureMap;
	}
	
	private static void registerJugerRepeatingCrossbowModel(ExtendedItemModelGenerator generator) {
		final ZhugeRepeatingCrossbowItem item = Items.ZHUGE_REPEATING_CROSSBOW;
		final JsonObject display = new JsonObject();
		display.add(ModelTransformationMode.THIRD_PERSON_RIGHT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(-90, 0, -60), new Vec3d(2, 0.1, -3), new Vec3d(0.9, 0.9, 0.9)));
		display.add(ModelTransformationMode.THIRD_PERSON_LEFT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(-90, 0, 30), new Vec3d(2, 0.1, -3), new Vec3d(0.9, 0.9, 0.9)));
		display.add(ModelTransformationMode.FIRST_PERSON_RIGHT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(-90, 0, -55), new Vec3d(1.13, 3.2, 1.13), new Vec3d(0.68, 0.68, 0.68)));
		display.add(ModelTransformationMode.FIRST_PERSON_LEFT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(-90, 0, 35), new Vec3d(1.13, 3.2, 1.13), new Vec3d(0.68, 0.68, 0.68)));
		final float[] pullStage = {0, 0.58F, 0.85F};
		STEREOSCOPIC_ITEM.upload(ModelIds.getItemModelId(item), getTextureMap(item, "_standby"), generator.writer, (id, textures) -> {
			JsonObject jsonObject = STEREOSCOPIC_ITEM.createJson(id, textures);
			jsonObject.add("display", display);
			JsonArray jsonArray = new JsonArray();
			for (Item projectile : item.rangedWeapon(Optional.empty()).launchableProjectiles()) {
				for (int count = 0; count < pullStage.length; count++) {
					JsonObject predicate = new JsonObject();
					JsonObject object = new JsonObject();
					float index = item.rangedWeapon(Optional.empty()).getProjectileIndex(projectile.getDefaultStack());
					if (index != 0) object.addProperty(RangedWeaponComponent.PROJECTILE_INDEX_KEY, index);
					object.addProperty(RangedWeaponComponent.PULLING_KEY, 1);
					object.addProperty(RangedWeaponComponent.PULL_KEY, pullStage[count]);
					predicate.add("predicate", object);
					predicate.addProperty("model", id.withSuffixedPath('_' + Registries.ITEM.getId(projectile).getPath() + '_' + RangedWeaponComponent.PULLING_KEY + '_' + count).toString());
					jsonArray.add(predicate);
				}
				JsonObject predicate = new JsonObject();
				JsonObject object = new JsonObject();
				object.addProperty(RangedWeaponComponent.CHARGED_KEY.toLowerCase(), 1);
				float index = item.rangedWeapon(Optional.empty()).getProjectileIndex(projectile.getDefaultStack());
				if (index != 0) object.addProperty(RangedWeaponComponent.PROJECTILE_INDEX_KEY, index);
				predicate.add("predicate", object);
				predicate.addProperty("model", id.withSuffixedPath('_' + Registries.ITEM.getId(projectile).getPath()).toString());
				jsonArray.add(predicate);
				JsonObject predicate1 = new JsonObject();
				JsonObject object1 = new JsonObject();
				object1.addProperty(ShootProjectilesComponent.SHOT_KEY, 1);
				float index1 = item.rangedWeapon(Optional.empty()).getProjectileIndex(projectile.getDefaultStack());
				if (index1 != 0) object1.addProperty(RangedWeaponComponent.PROJECTILE_INDEX_KEY, index1);
				predicate1.add("predicate", object1);
				predicate1.addProperty("model", id.withSuffixedPath('_' + Registries.ITEM.getId(projectile).getPath() + '_' + ShootProjectilesComponent.SHOT_KEY).toString());
				jsonArray.add(predicate1);
			}
			jsonObject.add("overrides", jsonArray);
			return jsonObject;
		});
		for (Item projectile : item.rangedWeapon(Optional.empty()).launchableProjectiles()) {
			for (int count = 0; count < pullStage.length; count++) {
				String suffix = '_' + Registries.ITEM.getId(projectile).getPath() + '_' + RangedWeaponComponent.PULLING_KEY + '_' + count;
				STEREOSCOPIC_ITEM.upload(ModelIds.getItemSubModelId(item, suffix), getTextureMap(item, suffix), generator.writer, (id, textures) -> {
					JsonObject jsonObject = STEREOSCOPIC_ITEM.createJson(id, textures);
					jsonObject.add("display", display);
					return jsonObject;
				});
			}
		}
		for (Item projectile : item.rangedWeapon(Optional.empty()).launchableProjectiles()) {
			String suffix = '_' + Registries.ITEM.getId(projectile).getPath();
			STEREOSCOPIC_ITEM.upload(ModelIds.getItemSubModelId(item, suffix), getTextureMap(item, suffix), generator.writer, (id, textures) -> {
				JsonObject jsonObject = STEREOSCOPIC_ITEM.createJson(id, textures);
				jsonObject.add("display", display);
				return jsonObject;
			});
		}
		for (Item projectile : item.rangedWeapon(Optional.empty()).launchableProjectiles()) {
			String suffix = '_' + Registries.ITEM.getId(projectile).getPath() + '_' + ShootProjectilesComponent.SHOT_KEY;
			STEREOSCOPIC_ITEM.upload(ModelIds.getItemSubModelId(item, suffix), getTextureMap(item, "_standby"), generator.writer, (id, textures) -> {
				JsonObject jsonObject = STEREOSCOPIC_ITEM.createJson(id, textures);
				jsonObject.add("display", display);
				return jsonObject;
			});
		}
	}
	
	public static void registerMarksCrossbowModel(ExtendedItemModelGenerator generator) {
		final MarksCrossbowItem item = Items.MARKS_CROSSBOW;
		JsonObject display = new JsonObject();
		display.add(ModelTransformationMode.THIRD_PERSON_RIGHT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(-80, 260, -40), new Vec3d(-1, 0.5, 1.5), new Vec3d(1.25, 1.25, 1.25)));
		display.add(ModelTransformationMode.THIRD_PERSON_LEFT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(-80, -280, 40), new Vec3d(-1, 0.5, 1.5), new Vec3d(1.25, 1.25, 1.25)));
		display.add(ModelTransformationMode.FIRST_PERSON_RIGHT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(0, -90, 25), new Vec3d(1.13, 2.65, 0), new Vec3d(0.68, 0.68, 0.68)));
		display.add(ModelTransformationMode.FIRST_PERSON_LEFT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(0, 90, -25), new Vec3d(1.13, 2.65, 0), new Vec3d(0.68, 0.68, 0.68)));
		final float[] pullStage = {0, 0.3F, 0.58F, 0.8F, 1};
		Models.GENERATED.upload(ModelIds.getItemModelId(item), TextureMap.layer0(TextureMap.getSubId(item, "_standby")), generator.writer, (id, textures) -> {
			JsonObject jsonObject = Models.GENERATED.createJson(id, textures);
			jsonObject.add("display", display);
			JsonArray jsonArray = new JsonArray();
			for (Item projectile : item.rangedWeapon(Optional.empty()).launchableProjectiles()) {
				for (int count = 0; count < pullStage.length; count++) {
					JsonObject predicate = new JsonObject();
					JsonObject object = new JsonObject();
					float index = item.rangedWeapon(Optional.empty()).getProjectileIndex(projectile.getDefaultStack());
					if (index != 0) object.addProperty(RangedWeaponComponent.PROJECTILE_INDEX_KEY, index);
					object.addProperty(RangedWeaponComponent.PULLING_KEY, 1);
					object.addProperty(RangedWeaponComponent.PULL_KEY, pullStage[count]);
					predicate.add("predicate", object);
					predicate.addProperty("model", id.withSuffixedPath('_' + Registries.ITEM.getId(projectile).getPath() + '_' + RangedWeaponComponent.PULLING_KEY + '_' + count).toString());
					jsonArray.add(predicate);
				}
				JsonObject predicate = new JsonObject();
				JsonObject object = new JsonObject();
				object.addProperty(RangedWeaponComponent.CHARGED_KEY.toLowerCase(), 1);
				float index = item.rangedWeapon(Optional.empty()).getProjectileIndex(projectile.getDefaultStack());
				if (index != 0) object.addProperty(RangedWeaponComponent.PROJECTILE_INDEX_KEY, index);
				predicate.add("predicate", object);
				predicate.addProperty("model", id.withSuffixedPath('_' + Registries.ITEM.getId(projectile).getPath()).toString());
				jsonArray.add(predicate);
			}
			JsonObject predicate = new JsonObject();
			JsonObject object = new JsonObject();
			object.addProperty(ShootProjectilesComponent.SHOT_KEY, 1);
			predicate.add("predicate", object);
			predicate.addProperty("model", id.withSuffixedPath('_' + ShootProjectilesComponent.SHOT_KEY).toString());
			jsonArray.add(predicate);
			jsonObject.add("overrides", jsonArray);
			return jsonObject;
		});
		JsonObject[] displays = {new JsonObject(), new JsonObject(), new JsonObject(), new JsonObject(), new JsonObject()};
		displays[0].add(ModelTransformationMode.THIRD_PERSON_RIGHT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(-80, 260, -40), new Vec3d(-1, 0.5, 1.5), new Vec3d(1.25, 1.25, 1.25)));
		displays[0].add(ModelTransformationMode.THIRD_PERSON_LEFT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(-80, -280, 40), new Vec3d(-1, 0.5, 1.5), new Vec3d(1.25, 1.25, 1.25)));
		displays[0].add(ModelTransformationMode.FIRST_PERSON_RIGHT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(0, -90, 25), new Vec3d(1.13, 4.2, 1.13), new Vec3d(0.68, 0.68, 0.68)));
		displays[0].add(ModelTransformationMode.FIRST_PERSON_LEFT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(0, 90, -25), new Vec3d(1.13, 4.2, 1.13), new Vec3d(0.68, 0.68, 0.68)));
		displays[1].add(ModelTransformationMode.THIRD_PERSON_RIGHT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(-80, 260, -40), new Vec3d(-1, 0.5, 3.25), new Vec3d(1.25, 1.25, 1.25)));
		displays[1].add(ModelTransformationMode.THIRD_PERSON_LEFT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(-80, -280, 40), new Vec3d(-1, 0.5, 3.25), new Vec3d(1.25, 1.25, 1.25)));
		displays[1].add(ModelTransformationMode.FIRST_PERSON_RIGHT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(0, -90, 25), new Vec3d(1.13, 3.9, 2), new Vec3d(0.68, 0.68, 0.68)));
		displays[1].add(ModelTransformationMode.FIRST_PERSON_LEFT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(0, 90, -25), new Vec3d(1.13, 3.9, 2), new Vec3d(0.68, 0.68, 0.68)));
		displays[2].add(ModelTransformationMode.THIRD_PERSON_RIGHT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(-80, 260, -40), new Vec3d(-1, 0.5, 5), new Vec3d(1.25, 1.25, 1.25)));
		displays[2].add(ModelTransformationMode.THIRD_PERSON_LEFT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(-80, -280, 40), new Vec3d(-1, 0.5, 5), new Vec3d(1.25, 1.25, 1.25)));
		displays[2].add(ModelTransformationMode.FIRST_PERSON_RIGHT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(0, -90, 25), new Vec3d(1.13, 3.65, 2.93), new Vec3d(0.68, 0.68, 0.68)));
		displays[2].add(ModelTransformationMode.FIRST_PERSON_LEFT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(0, 90, -25), new Vec3d(1.13, 3.65, 2.93), new Vec3d(0.68, 0.68, 0.68)));
		displays[3].add(ModelTransformationMode.THIRD_PERSON_RIGHT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(-80, 260, -40), new Vec3d(-1, 0.5, 6.75), new Vec3d(1.25, 1.25, 1.25)));
		displays[3].add(ModelTransformationMode.THIRD_PERSON_LEFT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(-80, -280, 40), new Vec3d(-1, 0.5, 6.75), new Vec3d(1.25, 1.25, 1.25)));
		displays[3].add(ModelTransformationMode.FIRST_PERSON_RIGHT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(0, -90, 25), new Vec3d(1.13, 3.4, 3.85), new Vec3d(0.68, 0.68, 0.68)));
		displays[3].add(ModelTransformationMode.FIRST_PERSON_LEFT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(0, 90, -25), new Vec3d(1.13, 3.4, 3.85), new Vec3d(0.68, 0.68, 0.68)));
		displays[4].add(ModelTransformationMode.THIRD_PERSON_RIGHT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(-80, 260, -40), new Vec3d(-1, 0.5, 8.5), new Vec3d(1.25, 1.25, 1.25)));
		displays[4].add(ModelTransformationMode.THIRD_PERSON_LEFT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(-80, -280, 40), new Vec3d(-1, 0.5, 8.5), new Vec3d(1.25, 1.25, 1.25)));
		displays[4].add(ModelTransformationMode.FIRST_PERSON_RIGHT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(0, -90, 25), new Vec3d(1.13, 3.1, 4.75), new Vec3d(0.68, 0.68, 0.68)));
		displays[4].add(ModelTransformationMode.FIRST_PERSON_LEFT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(0, 90, -25), new Vec3d(1.13, 3.1, 4.75), new Vec3d(0.68, 0.68, 0.68)));
		for (Item projectile : item.rangedWeapon(Optional.empty()).launchableProjectiles()) {
			for (int count = 0; count < pullStage.length; count++) {
				String suffix = '_' + Registries.ITEM.getId(projectile).getPath() + '_' + RangedWeaponComponent.PULLING_KEY + '_' + count;
				final int finalCount = count;
				new Model(Optional.of(ModelIds.getItemModelId(item)), Optional.empty(), TextureKey.LAYER0)
						.upload(ModelIds.getItemSubModelId(item, suffix), TextureMap.layer0(TextureMap.getSubId(item, suffix)), generator.writer, (id, textures) -> {
							JsonObject jsonObject = Models.GENERATED.createJson(id, textures);
							jsonObject.add("display", displays[finalCount]);
							return jsonObject;
						});
			}
		}
		for (Item projectile : item.rangedWeapon(Optional.empty()).launchableProjectiles()) {
			String suffix = '_' + Registries.ITEM.getId(projectile).getPath();
			new Model(Optional.of(ModelIds.getItemModelId(item)), Optional.empty(), TextureKey.LAYER0)
					.upload(ModelIds.getItemSubModelId(item, suffix), TextureMap.layer0(TextureMap.getSubId(item, suffix)), generator.writer, (id, textures) -> {
						JsonObject dis = new JsonObject();
						dis.add(ModelTransformationMode.THIRD_PERSON_RIGHT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(-80, 260, -40), new Vec3d(-1, 0.5, 10), new Vec3d(1.25, 1.25, 1.25)));
						dis.add(ModelTransformationMode.THIRD_PERSON_LEFT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(-80, -280, 40), new Vec3d(-1, 0.5, 10), new Vec3d(1.25, 1.25, 1.25)));
						dis.add(ModelTransformationMode.FIRST_PERSON_RIGHT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(0, -90, 25), new Vec3d(10, 3.1, 4.75), new Vec3d(0.68, 0.68, 0.68)));
						dis.add(ModelTransformationMode.FIRST_PERSON_LEFT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(0, 90, -25), new Vec3d(10, 3.1, 4.75), new Vec3d(0.68, 0.68, 0.68)));
						JsonObject jsonObject = Models.GENERATED.createJson(id, textures);
						jsonObject.add("display", dis);
						return jsonObject;
					});
		}
		new Model(Optional.of(ModelIds.getItemModelId(item)), Optional.empty(), TextureKey.LAYER0)
				.upload(ModelIds.getItemSubModelId(item, '_' + ShootProjectilesComponent.SHOT_KEY), TextureMap.layer0(TextureMap.getSubId(item, '_' + ShootProjectilesComponent.SHOT_KEY)), generator.writer, (id, textures) -> {
					JsonObject dis = new JsonObject();
					dis.add(ModelTransformationMode.THIRD_PERSON_RIGHT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(-80, 260, -40), new Vec3d(-1, 0.5, 8.5), new Vec3d(1.25, 1.25, 1.25)));
					dis.add(ModelTransformationMode.THIRD_PERSON_LEFT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(-80, -280, 40), new Vec3d(-1, 0.5, 8.5), new Vec3d(1.25, 1.25, 1.25)));
					dis.add(ModelTransformationMode.FIRST_PERSON_RIGHT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(0, -90, 25), new Vec3d(1.13, 3.1, 4.75), new Vec3d(0.68, 0.68, 0.68)));
					dis.add(ModelTransformationMode.FIRST_PERSON_LEFT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(0, 90, -25), new Vec3d(1.13, 3.1, 4.75), new Vec3d(0.68, 0.68, 0.68)));
					JsonObject jsonObject = Models.GENERATED.createJson(id, textures);
					jsonObject.add("display", dis);
					return jsonObject;
				});
	}
	
	@Override
	public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
		ExtendedBlockStateModelGenerator generator = new ExtendedBlockStateModelGenerator(blockStateModelGenerator);
		generator.registerSimpleCubeAll(Blocks.COPPER_FOR_SMELTING_INGOT_BLOCK);
		generator.registerSimpleCubeAll(Blocks.CUFE_ALLOY_BLOCK);
		generator.registerSimpleCubeAll(Blocks.AUCU_ALLOY_BLOCK);
		generator.registerSimpleCubeAll(Blocks.PIG_IRON_BLOCK);
		generator.registerSimpleCubeAll(Blocks.REFINED_COPPER_BLOCK);
		generator.registerSimpleCubeAll(Blocks.CUFE_BLOCK);
		generator.registerSimpleCubeAll(Blocks.AUCU_BLOCK);
		generator.registerSimpleCubeAll(Blocks.STEEL_BLOCK);
	}
	
	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		ExtendedItemModelGenerator generator = new ExtendedItemModelGenerator(itemModelGenerator);
		generator.registerItemGroup(ItemGroups.BUILDING_BLOCKS);
		generator.registerItemGroup(ItemGroups.COLORED_BLOCKS);
		generator.registerItemGroup(ItemGroups.NATURAL);
		generator.registerItemGroup(ItemGroups.FUNCTIONAL);
		generator.registerItemGroup(ItemGroups.REDSTONE);
		generator.registerItemGroup(ItemGroups.TOOLS);
		generator.registerItemGroup(ItemGroups.COMBAT);
		generator.registerItemGroup(ItemGroups.FOOD_AND_DRINK);
		generator.registerItemGroup(ItemGroups.INGREDIENTS);
		generator.registerItemGroup(ItemGroups.SPAWN_EGGS);
		generator.register(Items.CLEAN_COAL, Models.GENERATED);
		generator.register(Items.COPPER_FOR_SMELTING_INGOT, Models.GENERATED);
		generator.register(Items.CUFE_ALLOY, Models.GENERATED);
		generator.register(Items.AUCU_ALLOY, Models.GENERATED);
		generator.register(Items.PIG_IRON, Models.GENERATED);
		generator.register(Items.REFINED_COPPER_NUGGET, Models.GENERATED);
		generator.register(Items.CUFE_ALLOY_NUGGET, Models.GENERATED);
		generator.register(Items.AUCU_ALLOY_NUGGET, Models.GENERATED);
		generator.register(Items.REFINED_COPPER_INGOT, Models.GENERATED);
		generator.register(Items.CUFE_ALLOY_INGOT, Models.GENERATED);
		generator.register(Items.AUCU_ALLOY_INGOT, Models.GENERATED);
		generator.register(Items.STEEL_INGOT, Models.GENERATED);
		generator.register(Items.COMPACT_GOSSAMER, Models.GENERATED);
		generator.register(Items.STICKY_COMPACT_GOSSAMER, Models.GENERATED);
		generator.register(Items.COMPACT_STRING, Models.GENERATED);
		generator.register(Items.COMPOSITE_STRING, Models.GENERATED);
		generator.register(Items.COMPOSITE_FABRIC, Models.GENERATED);
		generator.register(Items.REFINED_COPPER_SWORD, Models.HANDHELD);
		generator.register(Items.CUFE_ALLOY_SWORD, Models.HANDHELD);
		generator.register(Items.AUCU_ALLOY_SWORD, Models.HANDHELD);
		generator.register(Items.STEEL_SWORD, Models.HANDHELD);
		generator.register(Items.REFINED_COPPER_SHOVEL, Models.HANDHELD);
		generator.register(Items.REFINED_COPPER_PICKAXE, Models.HANDHELD);
		generator.register(Items.REFINED_COPPER_AXE, Models.HANDHELD);
		generator.register(Items.REFINED_COPPER_HOE, Models.HANDHELD);
		generator.register(Items.CUFE_ALLOY_SHOVEL, Models.HANDHELD);
		generator.register(Items.CUFE_ALLOY_PICKAXE, Models.HANDHELD);
		generator.register(Items.CUFE_ALLOY_AXE, Models.HANDHELD);
		generator.register(Items.CUFE_ALLOY_HOE, Models.HANDHELD);
		generator.register(Items.AUCU_ALLOY_SHOVEL, Models.HANDHELD);
		generator.register(Items.AUCU_ALLOY_PICKAXE, Models.HANDHELD);
		generator.register(Items.AUCU_ALLOY_AXE, Models.HANDHELD);
		generator.register(Items.AUCU_ALLOY_HOE, Models.HANDHELD);
		generator.register(Items.STEEL_SHOVEL, Models.HANDHELD);
		generator.register(Items.STEEL_PICKAXE, Models.HANDHELD);
		generator.register(Items.STEEL_AXE, Models.HANDHELD);
		generator.register(Items.STEEL_HOE, Models.HANDHELD);
		generator.registerArmor(Items.REFINED_COPPER_HELMET);
		generator.registerArmor(Items.REFINED_COPPER_CHESTPLATE);
		generator.registerArmor(Items.REFINED_COPPER_LEGGINGS);
		generator.registerArmor(Items.REFINED_COPPER_BOOTS);
		generator.registerArmor(Items.CUFE_ALLOY_HELMET);
		generator.registerArmor(Items.CUFE_ALLOY_CHESTPLATE);
		generator.registerArmor(Items.CUFE_ALLOY_LEGGINGS);
		generator.registerArmor(Items.CUFE_ALLOY_BOOTS);
		generator.registerArmor(Items.AUCU_ALLOY_HELMET);
		generator.registerArmor(Items.AUCU_ALLOY_CHESTPLATE);
		generator.registerArmor(Items.AUCU_ALLOY_LEGGINGS);
		generator.registerArmor(Items.AUCU_ALLOY_BOOTS);
		generator.registerArmor(Items.STEEL_HELMET);
		generator.registerArmor(Items.STEEL_CHESTPLATE);
		generator.registerArmor(Items.STEEL_LEGGINGS);
		generator.registerArmor(Items.STEEL_BOOTS);
		generator.registerArmor(Items.ARROWPROOF_VEST);
		generator.register(Items.STONEBALL, Models.GENERATED);
		generator.register(Items.STEEL_ARROW, Models.GENERATED);
		JsonObject slingshotDisplay = new JsonObject();
		slingshotDisplay.add(ModelTransformationMode.THIRD_PERSON_RIGHT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(0, 0, -45), new Vec3d(0, 2, 1.25), new Vec3d(0.8, 0.8, 0.8)));
		slingshotDisplay.add(ModelTransformationMode.THIRD_PERSON_LEFT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(0, 0, 45), new Vec3d(0, 2, 1.25), new Vec3d(0.8, 0.8, 0.8)));
		slingshotDisplay.add(ModelTransformationMode.FIRST_PERSON_RIGHT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(0, 0, -45), new Vec3d(2, 4, -1.25), new Vec3d(0.68, 0.68, 0.68)));
		slingshotDisplay.add(ModelTransformationMode.FIRST_PERSON_LEFT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(0, 0, 45), new Vec3d(2, 4, -1.25), new Vec3d(0.68, 0.68, 0.68)));
		generator.registerBow(Items.SLINGSHOT, slingshotDisplay, new float[]{0, 0.65F, 0.9F});
		JsonObject recurveBowDisplay = new JsonObject();
		recurveBowDisplay.add(ModelTransformationMode.THIRD_PERSON_RIGHT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(170, -60, -145), new Vec3d(-1.5, -2, 2.5), new Vec3d(0.75, 0.75, 0.75)));
		recurveBowDisplay.add(ModelTransformationMode.THIRD_PERSON_LEFT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(170, 120, 145), new Vec3d(-1.5, -2, 2.5), new Vec3d(0.75, 0.75, 0.75)));
		recurveBowDisplay.add(ModelTransformationMode.FIRST_PERSON_RIGHT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(0, -90, 25), new Vec3d(1.13, 3.2, 1.13), new Vec3d(0.58, 0.58, 0.58)));
		recurveBowDisplay.add(ModelTransformationMode.FIRST_PERSON_LEFT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(0, 90, -25), new Vec3d(1.13, 3.2, 1.13), new Vec3d(0.58, 0.58, 0.58)));
		generator.registerBow(Items.RECURVE_BOW, recurveBowDisplay, new float[]{0, 0.65F, 0.9F});
		generator.registerCrossbow(Items.ARBALEST, new float[]{0, 0.58F, 1});
		JsonObject compoundBowDisplay = new JsonObject();
		compoundBowDisplay.add(ModelTransformationMode.THIRD_PERSON_RIGHT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(170, -60, -145), new Vec3d(-1.5, -1.75, 3), new Vec3d(0.9, 0.9, 0.9)));
		compoundBowDisplay.add(ModelTransformationMode.THIRD_PERSON_LEFT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(170, 120, 145), new Vec3d(-1.5, -1.75, 3), new Vec3d(0.9, 0.9, 0.9)));
		compoundBowDisplay.add(ModelTransformationMode.FIRST_PERSON_RIGHT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(0, -90, 25), new Vec3d(1.13, 3.2, 1.13), new Vec3d(0.68, 0.68, 0.68)));
		compoundBowDisplay.add(ModelTransformationMode.FIRST_PERSON_LEFT_HAND.asString(), ModelGenUtil.modelTransModeJson(new Vec3d(0, 90, -25), new Vec3d(1.13, 3.2, 1.13), new Vec3d(0.68, 0.68, 0.68)));
		generator.registerBow(Items.COMPOUND_BOW, compoundBowDisplay, new float[]{0, 0.65F, 0.9F});
		registerJugerRepeatingCrossbowModel(generator);
		registerMarksCrossbowModel(generator);
	}
}
