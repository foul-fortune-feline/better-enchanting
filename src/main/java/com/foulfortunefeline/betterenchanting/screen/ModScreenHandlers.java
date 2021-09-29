package com.foulfortunefeline.betterenchanting.screen;

import com.foulfortunefeline.betterenchanting.BetterEnchanting;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<BookCaseScreenHandler> BOOK_CASE_SCREEN_HANDLER = ScreenHandlerRegistry
            .registerSimple(new Identifier(BetterEnchanting.MOD_ID, "book_case"), BookCaseScreenHandler::new);

    public static void registerScreenHandlers() {
        ScreenRegistry.register(ModScreenHandlers.BOOK_CASE_SCREEN_HANDLER, BookCaseScreen::new);
    }
}
