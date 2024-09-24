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
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import pers.saikel0rado1iu.spontaneousreplace.block.Blocks;

/**
 * <h2 style="color:FFC800">战利品表生成器</h2>
 * 自然更替的战利品表生成器
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
interface LootTableGenerator {
	final class Block extends FabricBlockLootTableProvider {
		Block(FabricDataOutput dataOutput) {
			super(dataOutput);
		}
		
		@Override
		public void generate() {
			addDrop(Blocks.COPPER_FOR_SMELTING_INGOT_BLOCK);
			addDrop(Blocks.REFINED_COPPER_BLOCK);
			addDrop(Blocks.CUFE_ALLOY_BLOCK);
			addDrop(Blocks.CUFE_BLOCK);
			addDrop(Blocks.AUCU_ALLOY_BLOCK);
			addDrop(Blocks.AUCU_BLOCK);
			addDrop(Blocks.PIG_IRON_BLOCK);
			addDrop(Blocks.STEEL_BLOCK);
		}
	}
}
