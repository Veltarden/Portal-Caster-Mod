package veltarden.portalcaster.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;


public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        //addDrop(ModBlocks.Ejemplo);
        /*
        // addDrop(ModBlocks.Ejemplo, copperLikeOreDrops(ModBlocks.Ejemplo, ModItems.NETHER_GEM));

        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.SOUL_FUNGUS_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(SoulFungusCropBlock.AGE, 8));

        addDrop(ModBlocks.SOUL_FUNGUS_CROP, cropDrops(ModBlocks.SOUL_FUNGUS_CROP, ModItems.SOULFUL_CAP, ModItems.SOUL_FUNGUS_SPORES, builder));

        addDrop(ModBlocks.FUNGUS_LAMP, ModItems.FUNGUS_LAMP);
    }

    public LootTable.Builder copperLikeOreDrops(Block drop) {
        return dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ItemEntry.builder(Items.RAW_COPPER)
                        .apply(SetCountLootFunction
                                .builder(UniformLootNumberProvider
                                        .create(2.0F, 5.0F)))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));

         */
    }


}
