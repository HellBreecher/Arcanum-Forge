package com.hellbreecher.arcanum;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hellbreecher.arcanum.client.ClientProxy;
import com.hellbreecher.arcanum.common.CommonProxy;
import com.hellbreecher.arcanum.common.core.ArcanumItemGroup;
import com.hellbreecher.arcanum.common.handler.IRegistryHandler;
import com.hellbreecher.arcanum.common.lib.Reference;
import com.hellbreecher.arcanum.common.worldgen.OreWorldGen;

import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.VersionChecker;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Reference.MODID)
public class Arcanum {

    public static final Logger Logger = LogManager.getLogger(Reference.MODID);

    public static CommonProxy proxy;
    public static ClientProxy client;
    public static Arcanum instance;

    public static final ItemGroup arcanum = new ArcanumItemGroup();
    
    public Arcanum() {
    	MinecraftForge.EVENT_BUS.register(this);
    	instance = this;
    	
    	//register methods for mod loading
    	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    	//FMLJavaModLoadingContect.get().getModEventBus().addListener(this::enqueueIMC);
    	//FMLJavaModLoadingContect.get().getModEventBus().addListener(this::processIMC);
    	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
    	    	
        IRegistryHandler.registryInit();  
    }
    
    //pre-init
    private void setup(final FMLCommonSetupEvent event) {
    	Logger.info("Arcanum: Pre Initialization Started");

    	VersionChecker.startVersionCheck();
    	
        OreWorldGen.init();
        OreWorldGen.setupGeneralWorldGen();
        //proxy.init();
    }
    
    private void clientRegistries(final FMLClientSetupEvent event) {  
    /**
    	proxy.registerRenders();
        proxy.registerNetworkRenderers();

        ArcanumSmelting.foodSmelting();
        ArcanumSmelting.oreSmelting();

        IDictionaryRegistry.registerBlocks();
        IDictionaryRegistry.registerFood();	
        IDictionaryRegistry.registerItem();

        IConfigHandler.init();
        IConfigHandler.addMechConfig();
    */
    }
}
