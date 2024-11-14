package org.example.javafxrenderingrpgflyweight;

import javafx.scene.image.Image;
import java.util.HashMap;
import java.util.Map;

public class TileGraphicFactory {
    private static final Map<String, Image> tileGraphics = new HashMap<>();

    public static Image getTileGraphic(String type) {
        if (!tileGraphics.containsKey(type)) {
            String imagePath = "/images/tile_n" + type + ".png";
            var resource = TileGraphicFactory.class.getResource(imagePath);
            if (resource == null) {
                throw new IllegalArgumentException("Image resource not found: " + imagePath);
            }
            Image image = new Image(resource.toExternalForm());
            tileGraphics.put(type, image);
        }
        return tileGraphics.get(type);
    }
}
