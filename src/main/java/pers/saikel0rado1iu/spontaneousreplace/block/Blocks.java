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

package pers.saikel0rado1iu.spontaneousreplace.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;
import pers.saikel0rado1iu.silk.api.spinningjenny.BlockRegistry;

/**
 * <h2 style="color:FFC800">方块集</h2>
 * 自然更替的所有方块
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
public interface Blocks extends BlockRegistry {
	Block COPPER_FOR_SMELTING_INGOT_BLOCK = BlockRegistry.registrar(() -> new Block(FabricBlockSettings.copyOf(net.minecraft.block.Blocks.RAW_COPPER_BLOCK))).register("copper_for_smelting_ingot_block");
	Block REFINED_COPPER_BLOCK = BlockRegistry.registrar(() -> new Block(FabricBlockSettings.copyOf(net.minecraft.block.Blocks.COPPER_BLOCK))).register("refined_copper_block");
	Block CUFE_ALLOY_BLOCK = BlockRegistry.registrar(() -> new Block(FabricBlockSettings.copyOf(net.minecraft.block.Blocks.RAW_IRON_BLOCK))).register("cufe_alloy_block");
	Block CUFE_BLOCK = BlockRegistry.registrar(() -> new Block(FabricBlockSettings.copyOf(net.minecraft.block.Blocks.IRON_BLOCK))).register("cufe_block");
	Block AUCU_ALLOY_BLOCK = BlockRegistry.registrar(() -> new Block(FabricBlockSettings.copyOf(net.minecraft.block.Blocks.RAW_GOLD_BLOCK))).register("aucu_alloy_block");
	Block AUCU_BLOCK = BlockRegistry.registrar(() -> new Block(FabricBlockSettings.copyOf(net.minecraft.block.Blocks.GOLD_BLOCK))).register("aucu_block");
	Block PIG_IRON_BLOCK = BlockRegistry.registrar(() -> new Block(FabricBlockSettings.copyOf(net.minecraft.block.Blocks.IRON_BLOCK))).register("pig_iron_block");
	Block STEEL_BLOCK = BlockRegistry.registrar(() -> new Block(FabricBlockSettings.copyOf(net.minecraft.block.Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.METAL))).register("steel_block");
}
