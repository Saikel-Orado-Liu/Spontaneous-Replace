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

package pers.saikel0rado1iu.spontaneousreplace.client;

import com.google.common.collect.ImmutableSet;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.Selectable;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import pers.saikel0rado1iu.silk.api.client.event.pattern.AddButtonInGameMenuCallback;
import pers.saikel0rado1iu.silk.api.client.event.pattern.AddButtonInTitleScreenCallback;
import pers.saikel0rado1iu.silk.api.codex.OptionTexts;
import pers.saikel0rado1iu.silk.api.modpass.ModClient;
import pers.saikel0rado1iu.silk.api.modpass.ModData;
import pers.saikel0rado1iu.silk.api.modpass.ModPass;
import pers.saikel0rado1iu.silk.api.modpass.registry.ClientRegistrationProvider;
import pers.saikel0rado1iu.silk.api.pattern.widget.WidgetTexts;
import pers.saikel0rado1iu.spontaneousreplace.Settings;
import pers.saikel0rado1iu.spontaneousreplace.SpontaneousReplace;
import pers.saikel0rado1iu.spontaneousreplace.client.entity.EntityTypes;
import pers.saikel0rado1iu.spontaneousreplace.client.item.Items;
import pers.saikel0rado1iu.spontaneousreplace.client.manager.UpdateManagers;
import pers.saikel0rado1iu.spontaneousreplace.client.screen.HomeScreen;
import pers.saikel0rado1iu.spontaneousreplace.client.screen.SettingsScreen;

import java.util.Set;
import java.util.function.Function;

/**
 * <h2 style="color:FFC800">客户端主类</h2>
 * 自然更替的客户端主类
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
public final class Client implements ModClient {
	/**
	 * 模组主函数
	 *
	 * @param mod 提供的模组通
	 */
	@Override
	public void main(ModPass mod) {
		AddButtonInTitleScreenCallback.EVENT.register(new AddButtonInTitleScreenCallback() {
			@Override
			public <T extends Element & Drawable & Selectable> boolean add(MinecraftClient client, Screen parent, Function<T, T> addFunction, int y, int spacingY, boolean hasMainButton) {
				if (hasMainButton) return false;
				if (Settings.cantShowButton()) return false;
				//noinspection unchecked
				addFunction.apply((T) ButtonWidget.builder(WidgetTexts.text(SpontaneousReplace.INSTANCE, "home"), button ->
						MinecraftClient.getInstance().setScreen(new HomeScreen(parent))).dimensions(parent.width / 2 - 100, y - spacingY, 200, 20).build());
				return true;
			}
		});
		AddButtonInGameMenuCallback.EVENT.register((client, parent, adder) -> {
			if (Settings.cantShowButton()) return;
			adder.add(ButtonWidget.builder(OptionTexts.root(Settings.SETTINGS), button -> client.setScreen(new SettingsScreen(parent))).width(204).build(), 2);
		});
	}
	
	/**
	 * 注册表方法，提供注册表以供注册
	 *
	 * @return 注册表的类型集合
	 */
	@Override
	public Set<Class<? extends ClientRegistrationProvider<?>>> registry() {
		return ImmutableSet.of(UpdateManagers.class, Items.class, EntityTypes.class);
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

