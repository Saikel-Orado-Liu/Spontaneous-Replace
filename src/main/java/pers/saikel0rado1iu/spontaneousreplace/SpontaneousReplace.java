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

import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.minecraft.text.Text;
import pers.saikel0rado1iu.silk.api.modpass.ModDataExpansion;
import pers.saikel0rado1iu.silk.api.modpass.pack.DataPack;
import pers.saikel0rado1iu.silk.api.modpass.pack.ResourcePack;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.Optional;

/**
 * <h2 style="color:FFC800">自然更替模组通</h2>
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
public interface SpontaneousReplace extends ModDataExpansion {
	/**
	 * 实例
	 */
	SpontaneousReplace INSTANCE = new SpontaneousReplace() {
	};
	
	@Override
	default String id() {
		return "spontaneous-replace";
	}
	
	@Override
	default int themeColor() {
		return 0xFFC800;
	}
	
	@Override
	default Text i18nName() {
		return Text.translatable(String.format("modmenu.nameTranslation.%s", id()));
	}
	
	@Override
	default Text i18nSummary() {
		return Text.translatable(String.format("modmenu.summaryTranslation.%s", id()));
	}
	
	@Override
	default Text i18nDescription() {
		return Text.translatable(String.format("modmenu.descriptionTranslation.%s", id()));
	}
	
	@Override
	default Optional<URL> community() throws MalformedURLException {
		String url = mod().getMetadata().getCustomValue("modmenu").getAsObject().get("links").getAsObject().get("modmenu.discord").getAsString();
		return Optional.of(new URL(url));
	}
	
	@Override
	default Optional<URL> support() throws MalformedURLException {
		String url = mod().getMetadata().getCustomValue("modmenu").getAsObject().get("links").getAsObject().get("modmenu.support.patreon").getAsString();
		if ("zh".equals(Locale.getDefault().getLanguage()) && "CN".equals(Locale.getDefault().getCountry()))
			url = mod().getMetadata().getCustomValue("modmenu").getAsObject().get("links").getAsObject().get("modmenu.support.afdian").getAsString();
		return Optional.of(new URL(url));
	}
	
	@Override
	default Optional<DataPack> dataPack() {
		return Optional.of(DataPack.createGroup("data", ResourcePackActivationType.ALWAYS_ENABLED, modData()));
	}
	
	@Override
	default Optional<ResourcePack> resourcePack() {
		return Optional.of(ResourcePack.createGroup("resource", ResourcePackActivationType.ALWAYS_ENABLED, modData()));
	}
}
