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

package pers.saikel0rado1iu.spontaneousreplace.client.screen;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.Identifier;
import pers.saikel0rado1iu.silk.api.client.codex.tab.SettingTab;
import pers.saikel0rado1iu.silk.api.client.modup.screen.UpdatableModScreen;
import pers.saikel0rado1iu.silk.api.client.pattern.tab.ModTab;
import pers.saikel0rado1iu.silk.api.client.pattern.tab.SynopsisTab;
import pers.saikel0rado1iu.spontaneousreplace.Settings;
import pers.saikel0rado1iu.spontaneousreplace.SpontaneousReplace;
import pers.saikel0rado1iu.spontaneousreplace.client.manager.UpdateManagers;

/**
 * <h2 style="color:FFC800">主屏幕</h2>
 * 自然更替的主屏幕
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
public final class HomeScreen extends UpdatableModScreen {
	private static final Identifier BACKGROUND = SpontaneousReplace.INSTANCE.ofId("textures/gui/background.png");
	
	/**
	 * @param parent 父屏幕
	 */
	public HomeScreen(Screen parent) {
		super(parent, UpdateManagers.CLIENT_UPDATE_MANAGER, BACKGROUND, 1, new ModTab(SpontaneousReplace.INSTANCE) {
			@Override
			public boolean linkTrusted() {
				return true;
			}
		}, new SynopsisTab(SpontaneousReplace.INSTANCE) {
			@Override
			public boolean linkTrusted() {
				return true;
			}
		}, new SettingTab(SpontaneousReplace.INSTANCE, Settings.SETTINGS) {
			@Override
			public boolean linkTrusted() {
				return true;
			}
		});
	}
}
