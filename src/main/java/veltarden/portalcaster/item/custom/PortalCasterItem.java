package veltarden.portalcaster.item.custom;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.dimension.NetherPortal;
import veltarden.portalcaster.sounds.ModSounds;

import java.util.Optional;

public class PortalCasterItem extends Item {

    public PortalCasterItem(Settings settings) {
        super(settings);
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        Optional<NetherPortal> optional;
        BlockPos blockPos;
        PlayerEntity playerEntity = context.getPlayer();
        World world = context.getWorld();
        BlockState blockState = context.getWorld().getBlockState(blockPos = context.getBlockPos());
        BlockPos blockPos2 = blockPos.offset(context.getSide());

        if (AbstractFireBlock.canPlaceAt(world,blockPos2,context.getHorizontalPlayerFacing())) {
            world.playSound(playerEntity, blockPos2, ModSounds.PORTAL_CASTER_FAILS, SoundCategory.BLOCKS, 1.0f, world.getRandom().nextFloat()* 0.4f + 0.6f);
            if (thisIsOverworldOrNether(world) && (optional = NetherPortal.getNewPortal(world, blockPos2, Direction.Axis.X)).isPresent()) {
                world.playSound(playerEntity, blockPos2, ModSounds.PORTAL_CASTER_CASTS_PORTAL, SoundCategory.BLOCKS, 1.0f, world.getRandom().nextFloat()* 0.4f + 0.6f);
                ItemStack itemStack = context.getStack();
                if (playerEntity instanceof ServerPlayerEntity){
                    Criteria.PLACED_BLOCK.trigger((ServerPlayerEntity)playerEntity, blockPos2, itemStack);
                    itemStack.damage(1, playerEntity,p -> p.sendToolBreakStatus(context.getHand()));
                }
                optional.get().createPortal();
            }


            return ActionResult.success(world.isClient());
        }
        return ActionResult.FAIL;
    }

    private static boolean thisIsOverworldOrNether(World world) {
        return world.getRegistryKey() == World.OVERWORLD || world.getRegistryKey() == World.NETHER;
    }
}
