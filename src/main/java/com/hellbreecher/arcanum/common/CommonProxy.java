package com.hellbreecher.arcanum.common;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.blocks.tile.TileArcFurnace;
import com.hellbreecher.arcanum.common.blocks.tile.TileFermenter;
import com.hellbreecher.arcanum.common.blocks.tile.TileMCUFurnace;
import com.hellbreecher.arcanum.common.handler.IGuiHandler;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {
    public void registerNetworkRenderers() {
        NetworkRegistry.INSTANCE.registerGuiHandler(Arcanum.instance, new IGuiHandler());
    }

    public void registerRenders() {
    }

    public void registerTileEntities() {
        TileEntity.register("arc_furnace", TileArcFurnace.class);
        TileEntity.register("mcufurnace", TileMCUFurnace.class);
        TileEntity.register("fermenter", TileFermenter.class);
    }
}
