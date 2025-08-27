package com.artemy.minestation13.screen;

import com.artemy.minestation13.MineStation13;
import com.artemy.minestation13.screen.custom.PedestalScreen;
import com.artemy.minestation13.screen.custom.PedestalScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<PedestalScreenHandler> PEDESTAL_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, MineStation13.id("pedestal_screen_handler"),
                    new ExtendedScreenHandlerType<>(PedestalScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void registerScreenHandlers() {
        MineStation13.LOGGER.info("Registering ScreenHandlers for " + MineStation13.MOD_ID);

    }
}
