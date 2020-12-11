package com.hellbreecher.arcanum.client;

import com.hellbreecher.arcanum.common.core.ArcanumContainerTypes;
import com.hellbreecher.arcanum.common.handler.IProxy;
import com.hellbreecher.arcanum.common.lib.Reference;
import com.hellbreecher.arcanum.common.screen.inventory.ArcFurnaceScreen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientProxy implements IProxy {

	@SubscribeEvent
	public void init() {
		ScreenManager.registerFactory(ArcanumContainerTypes.arcfurnace.get(), ArcFurnaceScreen::new);
	}

	@Override
	public World getClientWorld() {
		return Minecraft.getInstance().world;
	}

	@Override
	public PlayerEntity getClientPlayer() {
		return Minecraft.getInstance().player;
	}

}
