package org.example.javafxrenderingrpgflyweight;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Tile {
    public abstract char getCharacter();
    public abstract String getType();

    public void render(GraphicsContext gc, double x, double y) {
        // Use the Flyweight factory to get the graphic
        Image tileGraphic = TileGraphicFactory.getTileGraphic(getType());
        gc.drawImage(tileGraphic, x, y, 32, 32); // Adjust dimensions as needed
    }
}
