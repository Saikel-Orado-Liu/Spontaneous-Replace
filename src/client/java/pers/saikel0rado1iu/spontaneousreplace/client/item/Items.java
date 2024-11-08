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

package pers.saikel0rado1iu.spontaneousreplace.client.item;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.component.type.DyedColorComponent;
import pers.saikel0rado1iu.silk.api.client.ropestick.ranged.BowModelPredicateProvider;
import pers.saikel0rado1iu.silk.api.client.ropestick.ranged.CrossbowModelPredicateProvider;
import pers.saikel0rado1iu.silk.api.client.ropestick.ranged.FirearmModelPredicateProvider;
import pers.saikel0rado1iu.silk.api.spinningjenny.ItemRegistry;
import pers.saikel0rado1iu.spontaneousreplace.item.ArmorMaterials;

import static pers.saikel0rado1iu.spontaneousreplace.item.Items.*;

/**
 * <h2 style="color:FFC800">物品集</h2>
 * 自然更替的物品的客户端注册
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
public abstract class Items implements ItemRegistry {
	static {
		ItemRegistry.registrar(() -> BowModelPredicateProvider.register(SLINGSHOT)).register(SLINGSHOT);
		ItemRegistry.registrar(() -> BowModelPredicateProvider.register(RECURVE_BOW)).register(RECURVE_BOW);
		ItemRegistry.registrar(() -> CrossbowModelPredicateProvider.register(ARBALEST)).register(ARBALEST);
		ItemRegistry.registrar(() -> BowModelPredicateProvider.register(COMPOUND_BOW)).register(COMPOUND_BOW);
		ItemRegistry.registrar(() -> FirearmModelPredicateProvider.register(ZHUGE_REPEATING_CROSSBOW)).register(ZHUGE_REPEATING_CROSSBOW);
		ItemRegistry.registrar(() -> FirearmModelPredicateProvider.register(MARKS_CROSSBOW)).register(MARKS_CROSSBOW);
		ItemRegistry.registrar(() -> ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> tintIndex > 0 ? -1 : DyedColorComponent.getColor(stack, ArmorMaterials.ARROWPROOF_COLOR)), ARROWPROOF_VEST)).register(ARROWPROOF_VEST);
	}
}
