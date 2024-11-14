package org.example.javafxrenderingrpgflyweight;

import java.util.Random;

public class CityMap extends Map {
    public CityMap(int width, int height) {
        super(width, height);
    }

    @Override
    protected Tile createTile() {
        Random random = new Random();
        int tileType = random.nextInt(3); // 3 types: Road, Forest, Building
        switch (tileType) {
            case 0: return new RoadTile();
            case 1: return new ForestTile();
            case 2: return new BuildingTile();
            default: return null;
        }
    }
}

