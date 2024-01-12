package com.example.examplemod;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class CityEvents {

    private final CityManager cityManager;

    public CityEvents(CityManager cityManager) {
        this.cityManager = cityManager;
    }

    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        // Ваш код обработки события входа игрока
    }

    // Другие методы для обработки других событий, если нужно
}