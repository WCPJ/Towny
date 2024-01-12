package com.example.examplemod;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class CommandTowny extends CommandBase {
    private final CityManager cityManager;

    public CommandTowny(CityManager cityManager) {
        this.cityManager = cityManager;
    }

    @Override
    public String getName() {
        return "towny";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/towny new <название> | /towny claim | /towny info";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length == 0) {
            sender.sendMessage(new TextComponentString("Используйте /towny new <название> | /towny claim | /towny info"));
            return;
        }

        EntityPlayer player = (EntityPlayer) sender;

        switch (args[0]) {
            case "new":
                if (args.length > 1) {
                    cityManager.createCity(player, args[1]);
                } else {
                    sender.sendMessage(new TextComponentString("Используйте /towny new <название> для создания города"));
                }
                break;
            case "claim":
                cityManager.claimChunk(player);
                break;
            case "info":
                cityManager.printCityInfo(player);
                break;
            default:
                sender.sendMessage(new TextComponentString("Неизвестная команда. Используйте /towny new <название> | /towny claim | /towny info"));
        }
    }
}
