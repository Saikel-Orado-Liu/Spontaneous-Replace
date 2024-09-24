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
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import pers.saikel0rado1iu.spontaneousreplace.block.Blocks;
import pers.saikel0rado1iu.spontaneousreplace.item.Items;

import java.util.concurrent.CompletableFuture;

/**
 * <h2 style="color:FFC800">标签生成器</h2>
 * 自然更替的标签生成器
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
interface TagGenerator {
	final class Item extends FabricTagProvider.ItemTagProvider {
		Item(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
			super(output, completableFuture);
		}
		
		@Override
		protected void configure(RegistryWrapper.WrapperLookup arg) {
			getOrCreateTagBuilder(ItemTags.COALS).add(Items.CLEAN_COAL);
			getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR).add(
					Items.REFINED_COPPER_HELMET, Items.REFINED_COPPER_CHESTPLATE, Items.REFINED_COPPER_LEGGINGS, Items.REFINED_COPPER_BOOTS,
					Items.CUFE_ALLOY_HELMET, Items.CUFE_ALLOY_CHESTPLATE, Items.CUFE_ALLOY_LEGGINGS, Items.CUFE_ALLOY_BOOTS,
					Items.AUCU_ALLOY_HELMET, Items.AUCU_ALLOY_CHESTPLATE, Items.AUCU_ALLOY_LEGGINGS, Items.AUCU_ALLOY_BOOTS,
					Items.STEEL_HELMET, Items.STEEL_CHESTPLATE, Items.STEEL_LEGGINGS, Items.STEEL_BOOTS);
		}
	}
	
	final class Block extends FabricTagProvider.BlockTagProvider {
		Block(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
			super(output, completableFuture);
		}
		
		@Override
		protected void configure(RegistryWrapper.WrapperLookup arg) {
			getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Blocks.COPPER_FOR_SMELTING_INGOT_BLOCK, Blocks.REFINED_COPPER_BLOCK, Blocks.CUFE_ALLOY_BLOCK, Blocks.CUFE_BLOCK, Blocks.AUCU_ALLOY_BLOCK, Blocks.AUCU_BLOCK, Blocks.PIG_IRON_BLOCK, Blocks.STEEL_BLOCK);
			getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL).add(Blocks.COPPER_FOR_SMELTING_INGOT_BLOCK, Blocks.REFINED_COPPER_BLOCK, Blocks.CUFE_ALLOY_BLOCK, Blocks.CUFE_BLOCK);
			getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL).add(Blocks.AUCU_ALLOY_BLOCK, Blocks.AUCU_BLOCK, Blocks.PIG_IRON_BLOCK, Blocks.STEEL_BLOCK);
			getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS).add(Blocks.CUFE_BLOCK, Blocks.AUCU_BLOCK, Blocks.STEEL_BLOCK);
		}
	}
}
