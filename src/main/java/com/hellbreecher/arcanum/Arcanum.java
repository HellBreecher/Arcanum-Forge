package com.hellbreecher.arcanum;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hellbreecher.arcanum.client.ClientSetup;
import com.hellbreecher.arcanum.client.handler.IClientRegistryHandler;
import com.hellbreecher.arcanum.common.core.ArcanumItemGroup;
import com.hellbreecher.arcanum.common.handler.IRegistryHandler;
import com.hellbreecher.arcanum.common.lib.Reference;
import com.hellbreecher.arcanum.common.worldgen.OreWorldGen;

import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.VersionChecker;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Reference.MODID)
public class Arcanum {

    public static final Logger Logger = LogManager.getLogger(Reference.MODID);

    public static Arcanum instance;

    public static final ItemGroup arcanum = new ArcanumItemGroup();
    
    public Arcanum() {
        IEventBus event = FMLJavaModLoadingContext.get().getModEventBus();
    	MinecraftForge.EVENT_BUS.register(this);
    	instance = this;
    	
    	//register methods for mod loading    	
    	event.addListener(this::setup);
    	event.addListener(this::clientSetup);
    	
        //IClientRegistryHandler.registryInit();
        IRegistryHandler.registryInit();  
    }
    
    //common setup
    private void setup(final FMLCommonSetupEvent event) {
    	Logger.info("Arcanum: Common Initialization Started");

    	VersionChecker.startVersionCheck();
    	
        OreWorldGen.init();
        OreWorldGen.setupGeneralWorldGen();
    }
    
    //client setup
    private void clientSetup(final FMLClientSetupEvent event) {
    	Logger.info("Arcanum: Client Initialization Started");
    	
    	ClientSetup.setup();    	
    }
    
    /**
    private void clientRegistries(final FMLClientSetupEvent event) {  
    	proxy.registerRenders();
        proxy.registerNetworkRenderers();

        ArcanumSmelting.foodSmelting();
        ArcanumSmelting.oreSmelting();

        IDictionaryRegistry.registerBlocks();
        IDictionaryRegistry.registerFood();	
        IDictionaryRegistry.registerItem();

        IConfigHandler.init();
        IConfigHandler.addMechConfig();
    }*/
}
