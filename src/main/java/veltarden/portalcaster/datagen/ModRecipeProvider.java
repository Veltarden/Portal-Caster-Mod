package veltarden.portalcaster.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import veltarden.portalcaster.item.ModItems;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {

    //public static List<ItemConvertible> SmeltableEjemplo = List.of(ModItems.NETHER_GEM);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        //offerSmelting(exporter, SmeltableEjemplo, RecipeCategory.MISC, ModItems.NETHER_GEM, 0.1f, 0.1f, "nethergem");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.NETHER_GEM, 2)
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .input('A', Items.DIAMOND)
                .input('B', Items.CRYING_OBSIDIAN)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(Items.CRYING_OBSIDIAN), conditionsFromItem(Items.CRYING_OBSIDIAN))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.NETHER_GEM)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PORTAL_CASTER_ITEM, 1)
                .pattern(" AB")
                .pattern(" B ")
                .pattern("BC ")
                .input('A', Items.ENDER_PEARL)
                .input('B', Items.GOLD_INGOT)
                .input('C', ModItems.NETHER_GEM)
                .criterion(hasItem(ModItems.NETHER_GEM), conditionsFromItem(ModItems.NETHER_GEM))
                .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PORTAL_CASTER_ITEM)));

    }


}
