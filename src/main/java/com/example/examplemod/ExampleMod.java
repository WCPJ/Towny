package com.example.examplemod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = ExampleMod.MODID, name = ExampleMod.NAME, version = ExampleMod.VERSION)
public class ExampleMod {
    public static final String MODID = "examplemod";
    public static final String NAME = "Example Mod";
    public static final String VERSION = "1.0";

    private static Logger logger;

    private CityManager cityManager;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        cityManager = new CityManager();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // Регистрация команд и событий
        MinecraftForge.EVENT_BUS.register(new CommandTowny(cityManager));
        MinecraftForge.EVENT_BUS.register(new CityEvents(cityManager));

        // Другие инициализации, регистрации блоков, предметов, и т.д.
    }
}