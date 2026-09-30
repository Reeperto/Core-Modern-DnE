package su.terrafirmagreg.core.compat.ae2;

import net.minecraftforge.fml.ModList;

import appeng.api.networking.GridHelper;
import appeng.api.networking.events.GridSpatialEvent;

public class AE2Compat {
    public static void registerEvents() {
        if (ModList.get().isLoaded("ftbchunks")) {
            GridHelper.addEventHandler(GridSpatialEvent.class, AE2FTBChunksCompat::onGridSpatialEvent);
        }
    }
}
