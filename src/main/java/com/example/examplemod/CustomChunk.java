package com.example.examplemod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class CustomChunk extends Chunk {
    private boolean isPrivate;

    public CustomChunk(World worldIn, int x, int z) {
        super(worldIn, x, z);
        this.isPrivate = false;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public boolean isPlayerInside(EntityPlayer player) {
        // Ваша логика для проверки, находится ли игрок внутри чанка
        // В данном примере, я просто возвращаю false
        return false;
    }
}
