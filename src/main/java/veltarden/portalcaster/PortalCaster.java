package veltarden.portalcaster;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import veltarden.portalcaster.item.ModItemGroups;
import veltarden.portalcaster.item.ModItems;
import veltarden.portalcaster.sounds.ModSounds;

public class PortalCaster implements ModInitializer {
	public static final String MOD_ID = "portal-caster";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerModItemGroups();
		ModItems.registerModItems();
		ModSounds.registerSounds();

		LOGGER.info("Tamos metiendo webadas del PORTAL CASTER (como 2 items noma)");
	}
}