package com.hellbreecher.arcanum.common.handler;

import com.hellbreecher.arcanum.Arcanum;
import com.hellbreecher.arcanum.common.blocks.container.containerArcFurnace;
import com.hellbreecher.arcanum.common.blocks.container.containerFermenter;
import com.hellbreecher.arcanum.common.blocks.container.containerMCUFurnace;
import com.hellbreecher.arcanum.common.blocks.tile.TileArcFurnace;
import com.hellbreecher.arcanum.common.blocks.tile.TileFermenter;
import com.hellbreecher.arcanum.common.blocks.tile.TileMCUFurnace;
import com.hellbreecher.arcanum.common.gui.GuiArcFurnace;
import com.hellbreecher.arcanum.common.gui.GuiFermenter;
import com.hellbreecher.arcanum.common.gui.GuiMCUFurnace;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class IGuiHandler implements net.minecraftforge.fml.common.network.IGuiHandler {
    public static final int ArcFurnaceID = 1;
    public static final int MCUFurnaceID = 2;
    public static final int FermenterID = 3;

    public IGuiHandler() {
        NetworkRegistry.INSTANCE.registerGuiHandler(Arcanum.instance, this);
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        switch (ID) {
            case 1:
                TileArcFurnace tileArcFurnace = (TileArcFurnace) world.getTileEntity(pos);
                return new GuiArcFurnace(player.inventory, tileArcFurnace);
            case 2:
                TileMCUFurnace tileMCUFurnace = (TileMCUFurnace) world.getTileEntity(pos);
                return new GuiMCUFurnace(player.inventory, tileMCUFurnace);
            case 3:
                TileFermenter tileFermenter = (TileFermenter) world.getTileEntity(pos);
                return new GuiFermenter(player.inventory, tileFermenter);
        }
        return null;
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        switch (ID) {
            case 1:
                TileArcFurnace tileArcFurnace = (TileArcFurnace) world.getTileEntity(pos);
                return new containerArcFurnace(player.inventory, tileArcFurnace);
            case 2:
                TileMCUFurnace tileMCUFurnace = (TileMCUFurnace) world.getTileEntity(pos);
                return new containerMCUFurnace(player.inventory, tileMCUFurnace);
            case 3:
                TileFermenter tileFermenter = (TileFermenter) world.getTileEntity(pos);
                return new containerFermenter(player.inventory, tileFermenter);
        }
        return null;
    }
}