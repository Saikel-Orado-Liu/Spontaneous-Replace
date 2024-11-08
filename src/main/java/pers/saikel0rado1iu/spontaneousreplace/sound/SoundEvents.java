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

package pers.saikel0rado1iu.spontaneousreplace.sound;

import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import pers.saikel0rado1iu.silk.api.spinningjenny.SoundEventRegistry;
import pers.saikel0rado1iu.spontaneousreplace.SpontaneousReplace;

/**
 * <h2 style="color:FFC800">声音事件集</h2>
 * 自然更替的所有声音事件
 *
 * @author <a href="https://github.com/Saikel-Orado-Liu"><img alt="author" src="https://avatars.githubusercontent.com/u/88531138?s=64&v=4"></a>
 * @since 1.0.0
 */
public interface SoundEvents extends SoundEventRegistry {
	RegistryEntry<SoundEvent> EQUIP_REFINED_COPPER = RegistryEntry.of(SoundEventRegistry.registrar(() -> SoundEvent.of(SpontaneousReplace.INSTANCE.ofId("copper.equip"))).register());
	RegistryEntry<SoundEvent> EQUIP_CUFE_ALLOY = RegistryEntry.of(SoundEventRegistry.registrar(() -> SoundEvent.of(SpontaneousReplace.INSTANCE.ofId("cufe.equip"))).register());
	RegistryEntry<SoundEvent> EQUIP_AUCU_ALLOY = RegistryEntry.of(SoundEventRegistry.registrar(() -> SoundEvent.of(SpontaneousReplace.INSTANCE.ofId("aucu.equip"))).register());
	RegistryEntry<SoundEvent> EQUIP_STEEL = RegistryEntry.of(SoundEventRegistry.registrar(() -> SoundEvent.of(SpontaneousReplace.INSTANCE.ofId("steel.equip"))).register());
	SoundEvent STONEBALL_THROW = SoundEventRegistry.registrar(() -> SoundEvent.of(SpontaneousReplace.INSTANCE.ofId("stoneball.throw"))).register();
	SoundEvent SLINGSHOT_THROW = SoundEventRegistry.registrar(() -> SoundEvent.of(SpontaneousReplace.INSTANCE.ofId("slingshot.throw"))).register();
	RegistryEntry<SoundEvent> EQUIP_ARROWPROOF = RegistryEntry.of(SoundEventRegistry.registrar(() -> SoundEvent.of(SpontaneousReplace.INSTANCE.ofId("arrowproof.equip"))).register());
	SoundEvent ARBALEST_LOADING_START = SoundEventRegistry.registrar(() -> SoundEvent.of(SpontaneousReplace.INSTANCE.ofId("arbalest.loading.start"))).register();
	SoundEvent ARBALEST_LOADING_MIDDLE = SoundEventRegistry.registrar(() -> SoundEvent.of(SpontaneousReplace.INSTANCE.ofId("arbalest.loading.middle"))).register();
	SoundEvent ARBALEST_LOADING_END = SoundEventRegistry.registrar(() -> SoundEvent.of(SpontaneousReplace.INSTANCE.ofId("arbalest.loading.end"))).register();
	SoundEvent ARBALEST_QUICK_CHARGE_1 = SoundEventRegistry.registrar(() -> SoundEvent.of(SpontaneousReplace.INSTANCE.ofId("arbalest.quick_charge.1"))).register();
	SoundEvent ARBALEST_QUICK_CHARGE_2 = SoundEventRegistry.registrar(() -> SoundEvent.of(SpontaneousReplace.INSTANCE.ofId("arbalest.quick_charge.2"))).register();
	SoundEvent ARBALEST_QUICK_CHARGE_3 = SoundEventRegistry.registrar(() -> SoundEvent.of(SpontaneousReplace.INSTANCE.ofId("arbalest.quick_charge.3"))).register();
	SoundEvent ARBALEST_SHOOT = SoundEventRegistry.registrar(() -> SoundEvent.of(SpontaneousReplace.INSTANCE.ofId("arbalest.shoot"))).register();
	SoundEvent JUGER_REPEATING_CROSSBOW_LOADING_START = SoundEventRegistry.registrar(() -> SoundEvent.of(SpontaneousReplace.INSTANCE.ofId("juger_repeating_crossbow.loading.start"))).register();
	SoundEvent JUGER_REPEATING_CROSSBOW_LOADING_MIDDLE = SoundEventRegistry.registrar(() -> SoundEvent.of(SpontaneousReplace.INSTANCE.ofId("juger_repeating_crossbow.loading.middle"))).register();
	SoundEvent JUGER_REPEATING_CROSSBOW_LOADING_END = SoundEventRegistry.registrar(() -> SoundEvent.of(SpontaneousReplace.INSTANCE.ofId("juger_repeating_crossbow.loading.end"))).register();
	SoundEvent JUGER_REPEATING_CROSSBOW_SHOOT = SoundEventRegistry.registrar(() -> SoundEvent.of(SpontaneousReplace.INSTANCE.ofId("juger_repeating_crossbow.shoot"))).register();
	SoundEvent MARKS_CROSSBOW_LOADING_START = SoundEventRegistry.registrar(() -> SoundEvent.of(SpontaneousReplace.INSTANCE.ofId("marks_crossbow.loading.start"))).register();
	SoundEvent MARKS_CROSSBOW_LOADING_MIDDLE = SoundEventRegistry.registrar(() -> SoundEvent.of(SpontaneousReplace.INSTANCE.ofId("marks_crossbow.loading.middle"))).register();
	SoundEvent MARKS_CROSSBOW_LOADING_END = SoundEventRegistry.registrar(() -> SoundEvent.of(SpontaneousReplace.INSTANCE.ofId("marks_crossbow.loading.end"))).register();
	SoundEvent MARKS_CROSSBOW_QUICK_CHARGE_1 = SoundEventRegistry.registrar(() -> SoundEvent.of(SpontaneousReplace.INSTANCE.ofId("marks_crossbow.quick_charge.1"))).register();
	SoundEvent MARKS_CROSSBOW_QUICK_CHARGE_2 = SoundEventRegistry.registrar(() -> SoundEvent.of(SpontaneousReplace.INSTANCE.ofId("marks_crossbow.quick_charge.2"))).register();
	SoundEvent MARKS_CROSSBOW_QUICK_CHARGE_3 = SoundEventRegistry.registrar(() -> SoundEvent.of(SpontaneousReplace.INSTANCE.ofId("marks_crossbow.quick_charge.3"))).register();
	SoundEvent MARKS_CROSSBOW_SHOOT = SoundEventRegistry.registrar(() -> SoundEvent.of(SpontaneousReplace.INSTANCE.ofId("marks_crossbow.shoot"))).register();
}
