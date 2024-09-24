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

package pers.saikel0rado1iu.spontaneousreplace;

import net.fabricmc.loader.api.FabricLoader;
import pers.saikel0rado1iu.silk.api.codex.OptionType;
import pers.saikel0rado1iu.silk.api.codex.SettingData;
import pers.saikel0rado1iu.silk.api.codex.SettingOption;
import pers.saikel0rado1iu.silk.api.codex.SettingType;

/**
 * <h2 style="color:FFC800">设置</h2>
 * 自然更替的所有设置
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
public final class Settings {
	public static final SettingOption<Boolean> AUTO_SHOW_SETTINGS_BUTTON = SettingOption.of(SpontaneousReplace.INSTANCE.ofId("auto_show_settings_button"), OptionType.SWITCH);
	public static final SettingOption<DisableWarningAdvice> DISABLE_WARNING_ADVICE = SettingOption.of(SpontaneousReplace.INSTANCE.ofId("disable_warning_advice"), OptionType.ofOption(DisableWarningAdvice.class, DisableWarningAdvice[].class));
	public static final SettingOption<SettingData> DEV_OPTIONS = SettingOption.of(SpontaneousReplace.INSTANCE.ofId("development"), OptionType.SETTINGS);
	public static final SettingData SETTINGS = SettingData.builder(SpontaneousReplace.INSTANCE)
			.addOption(AUTO_SHOW_SETTINGS_BUTTON, false)
			.addOption(DISABLE_WARNING_ADVICE, DisableWarningAdvice.NEED_OTHER_MOD)
			.build();
	
	static {
		SETTINGS.addOption(DEV_OPTIONS, Development.SETTINGS);
	}
	
	public static boolean cantShowButton() {
		return FabricLoader.getInstance().isModLoaded("modmenu") && SETTINGS.getValue(AUTO_SHOW_SETTINGS_BUTTON);
	}
	
	public enum DisableWarningAdvice {
		NEED_OTHER_MOD;
		
		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}
	}
	
	public interface Development {
		SettingOption<Boolean> DISABLE_MOD_BUTTON = SettingOption.of(SpontaneousReplace.INSTANCE.ofId("disable_mod_button"), OptionType.SWITCH);
		SettingData SETTINGS = SettingData.builder(SpontaneousReplace.INSTANCE).type(SettingType.DEVELOPMENT)
				.saveSettings(storage -> Settings.SETTINGS.save())
				.loadSettings(loader -> Settings.SETTINGS.load())
				.addOption(DISABLE_MOD_BUTTON, false)
				.build();
	}
}
