package su.terrafirmagreg.core.mixins.common.minecraft;

import net.minecraft.world.entity.animal.horse.AbstractHorse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;

/**
 * Fix for https://bugs.mojang.com/browse/MC/issues/MC-100830
 */
@Mixin(ServerGamePacketListenerImpl.class)
public abstract class ServerGamePacketListenerImplMixin {
    @Shadow
    public ServerPlayer player;

    @ModifyConstant(method = "handleMoveVehicle", constant = @Constant(doubleValue = 0.0625, ordinal = 1))
    private double tfg$onHandleMoveVehicle(double value) {
        if (player.getRootVehicle() instanceof AbstractHorse) {
            return 0.36;
        }

        return value;
    }
}
