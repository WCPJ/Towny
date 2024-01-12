package com.example.examplemod;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CityManager {
    private ArrayList<City> cities;

    public CityManager() {
        this.cities = new ArrayList<>();
    }

    public void createCity(EntityPlayer player, String cityName) {
        // Ваша логика для создания города
        City city = new City(cityName);
        cities.add(city);

        // Получить чанк, в котором находится игрок
        CustomChunk chunk = getChunkForPlayer(player);

        // Установить флаг приватности для чанка
        if (chunk != null) {
            chunk.setPrivate(true);

            // Добавить чанк в город
            city.addChunk(chunk);

            player.sendMessage(new TextComponentString("Город " + cityName + " успешно создан!"));
        } else {
            player.sendMessage(new TextComponentString("Не удалось найти чанк для создания города."));
        }
    }

    public void claimChunk(EntityPlayer player) {
        // Ваша логика для привата чанка
        City city = getCityByPlayer(player);

        if (city != null) {
            CustomChunk chunk = getChunkForPlayer(player);

            // Установить флаг приватности для чанка
            if (chunk != null) {
                chunk.setPrivate(true);

                // Добавить чанк в город
                city.addChunk(chunk);

                player.sendMessage(new TextComponentString("Чанк успешно приватен для города " + city.getName()));
            } else {
                player.sendMessage(new TextComponentString("Не удалось найти чанк для привата."));
            }
        } else {
            player.sendMessage(new TextComponentString("Вы не состоите в каком-либо городе."));
        }
    }

    public void printCityInfo(EntityPlayer player) {
        // Ваша логика для вывода информации о городе
        City city = getCityByPlayer(player);
        if (city != null) {
            player.sendMessage(new TextComponentString("Имя города: " + city.getName()));
            player.sendMessage(new TextComponentString("Количество чанков: " + city.getChunksArray().length));
            player.sendMessage(new TextComponentString("Дата создания: " + formatDate(city.getCreationDate())));
        } else {
            player.sendMessage(new TextComponentString("Вы не состоите в каком-либо городе."));
        }
    }

    private CustomChunk getChunkForPlayer(EntityPlayer player) {
        // Ваша логика для получения чанка, в котором находится игрок
        // В данном примере, я просто возвращаю CustomChunk, созданный на текущей позиции игрока
        return new CustomChunk(player.getEntityWorld(), player.getPosition().getX() >> 4, player.getPosition().getZ() >> 4);
    }

    private City getCityByPlayer(EntityPlayer player) {
        // Ваша логика для поиска города, в котором находится игрок
        for (City city : this.cities) {
            for (CustomChunk chunk : city.getChunksArray()) {
                if (chunk.isPlayerInside(player)) {
                    return city;
                }
            }
        }
        return null;
    }

    private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return dateFormat.format(date);
    }
}
