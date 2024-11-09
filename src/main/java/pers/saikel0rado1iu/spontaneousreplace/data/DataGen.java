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

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import pers.saikel0rado1iu.silk.api.generate.DataGenerator;
import pers.saikel0rado1iu.silk.api.generate.DynamicDataEntry;
import pers.saikel0rado1iu.silk.api.modpass.ModData;
import pers.saikel0rado1iu.spontaneousreplace.SpontaneousReplace;

import java.util.Optional;
import java.util.Set;

/**
 * <h2 style="color:FFC800">数据生成器</h2>
 * 自然更替的数据生成器
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
public final class DataGen implements DataGenerator {
	/**
	 * 数据生成方法
	 *
	 * @param builtinPack  Fabric 模组的内置包
	 * @param dataPack     模组的数据包
	 * @param resourcePack 模组的资源包
	 */
	@Override
	public void generate(FabricDataGenerator.Pack builtinPack, Optional<FabricDataGenerator.Pack> dataPack, Optional<FabricDataGenerator.Pack> resourcePack) {
		if (dataPack.isEmpty() || resourcePack.isEmpty()) return;
		FabricDataGenerator.Pack data = dataPack.get();
		data.addProvider(RecipeGenerator::new);
		data.addProvider(AdvancementGenerator::new);
		data.addProvider(LootTableGenerator.Block::new);
		data.addProvider(TagGenerator.Item::new);
		data.addProvider(TagGenerator.Block::new);
		data.addProvider(TagGenerator.DamageType::new);
		FabricDataGenerator.Pack resource = resourcePack.get();
		resource.addProvider(LanguageGenerator.EnUs::new);
		resource.addProvider(LanguageGenerator.ZhCn::new);
		resource.addProvider(LanguageGenerator.ZhHk::new);
		resource.addProvider(LanguageGenerator.ZhTw::new);
		resource.addProvider(ModelGenerator::new);
	}
	
	/**
	 * 动态数据条目表
	 *
	 * @return 列表动态数据集合
	 */
	@Override
	public Set<DynamicDataEntry<?>> dynamicDataEntries() {
		return ImmutableSet.of();
	}
	
	/**
	 * 用于提供模组数据以基于模组数据实现功能
	 *
	 * @return 模组数据
	 */
	@Override
	public ModData modData() {
		return SpontaneousReplace.INSTANCE;
	}
}
