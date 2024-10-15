package veltarden.portalcaster.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import veltarden.portalcaster.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Ejemplo);
        //blockStateModelGenerator.registerLantern(ModBlocks.FUNGUS_LAMP);
        //registerModCrop(ModBlocks.SOUL_FUNGUS_CROP, blockStateModelGenerator, SoulFungusCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7, 8);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.NETHER_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.PORTAL_CASTER_ITEM, Models.GENERATED);
    }

}
