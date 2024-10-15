package veltarden.portalcaster.item;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import veltarden.portalcaster.PortalCaster;
import veltarden.portalcaster.item.custom.PortalCasterItem;


public class ModItems {
    public static final Item NETHER_GEM = registerItem("nether_gem", new Item(new FabricItemSettings()));

    public static final Item PORTAL_CASTER_ITEM = registerItem("portal_caster_item", new PortalCasterItem(new FabricItemSettings()
            .maxDamage(8)));

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(NETHER_GEM);
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(PortalCaster.MOD_ID, name), item);
    }

    public static void registerModItems () {
        PortalCaster.LOGGER.info("metiendo items para: " + PortalCaster.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
