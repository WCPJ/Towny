package com.example.examplemod;


import java.util.Date;

public class City {
    private String name;
    private Date creationDate;
    private CustomChunk[] chunks;

    public City(String name) {
        this.name = name;
        this.creationDate = new Date();
        this.chunks = new CustomChunk[0];
    }

    public String getName() {
        return name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public CustomChunk[] getChunksArray() {
        return chunks;
    }

    public void addChunk(CustomChunk chunk) {
        CustomChunk[] newChunks = new CustomChunk[chunks.length + 1];
        System.arraycopy(chunks, 0, newChunks, 0, chunks.length);
        newChunks[chunks.length] = chunk;
        chunks = newChunks;
    }
}