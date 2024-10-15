package veltarden.portalcaster.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import veltarden.portalcaster.PortalCaster;

public class ModItemGroups {

    public static final ItemGroup PORTAL_CASTER_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(PortalCaster.MOD_ID, "nether_gem"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.portal_caster"))
                    .icon(() -> new ItemStack(ModItems.NETHER_GEM)).entries((displayContext, entries) -> {
                        entries.add(ModItems.NETHER_GEM);
                        entries.add(ModItems.PORTAL_CASTER_ITEM);
                    }).build());
    public static void registerModItemGroups () {
        PortalCaster.LOGGER.info("metiendo grupos de items para: " + PortalCaster.MOD_ID);
    }
}
