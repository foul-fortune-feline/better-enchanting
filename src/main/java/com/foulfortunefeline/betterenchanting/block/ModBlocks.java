package com.foulfortunefeline.betterenchanting.block;

import com.foulfortunefeline.betterenchanting.BetterEnchanting;
import com.foulfortunefeline.betterenchanting.block.book_case.BookCase;
import com.foulfortunefeline.betterenchanting.block.book_case.BookCaseEntity;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModBlocks {
    public static final Block BOOK_CASE_BLOCK = registerBlock("book_case", new BookCase(
            FabricBlockSettings.of(Material.WOOD).strength(2.5f, 2.5f)
                    .breakByTool(FabricToolTags.AXES).nonOpaque()), ItemGroup.DECORATIONS);
    public static final BlockEntityType<BookCaseEntity> BOOK_CASE_ENTITY = registerBlockEntity("book_case",
            BookCaseEntity::new, BOOK_CASE_BLOCK);


    /**
     * Registers a block and optionally generates and registers a block items for it with the given ItemGroup
     */
    private static Block registerBlock(String name, Block block, ItemGroup group, boolean genBlockItem) {
        if (genBlockItem) { registerBlockItem(name, block, group); }
        return Registry.register(Registry.BLOCK, new Identifier(BetterEnchanting.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block, ItemGroup group){
        return registerBlock(name, block, group, true);
    }

    private static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(String name, FabricBlockEntityTypeBuilder.Factory<T> factory, Block block) {
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(BetterEnchanting.MOD_ID, name),
                FabricBlockEntityTypeBuilder.create(factory, block).build());
    }

    private static Item registerBlockItem(String name, Block block, FabricItemSettings settings) {
        return Registry.register(Registry.ITEM, new Identifier(BetterEnchanting.MOD_ID, name),
                new BlockItem(block, settings));
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return registerBlockItem(name, block, new FabricItemSettings().group(group));
    }

    public static void registerModBlocks() {
        BetterEnchanting.BETTER_ENCHANTING.info("Registering Mod Blocks for " + BetterEnchanting.MOD_ID);
    }
}
