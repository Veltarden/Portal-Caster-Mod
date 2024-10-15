package veltarden.portalcaster.mixin;


import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.dimension.NetherPortal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;


import java.util.Optional;

@Mixin(AbstractFireBlock.class)
public class ModNetherPortalCondition{
    @WrapOperation(method = "onBlockAdded", at = @At(value = "INVOKE",
            target = "net/minecraft/world/dimension/NetherPortal.getNewPortal " +
                    "(Lnet/minecraft/world/WorldAccess;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/Direction$Axis;)Ljava/util/Optional;"))
    private Optional<NetherPortal> InjectToFire(WorldAccess world, BlockPos pos, Direction.Axis axis, Operation<Optional<NetherPortal>> original) {

        return Optional.empty();
    }
}
