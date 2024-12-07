package org.example.pixelarteditor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PixelArtEditor extends Application {
    private static final int GRID_SIZE = 8;
    private static final int CELL_SIZE = 40;
    private Rectangle[][] grid = new Rectangle[GRID_SIZE][GRID_SIZE];
    private int cursorX = 0;
    private int cursorY = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();

        // Initialize grid
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                Rectangle rect = new Rectangle(CELL_SIZE, CELL_SIZE);
                rect.setStroke(Color.BLACK);
                rect.setFill(Color.WHITE);
                grid[i][j] = rect;
                gridPane.add(rect, j, i);
            }
        }

        Scene scene = new Scene(gridPane, GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE);

        Command moveUp = new MoveCursorUpCommand(this);
        Command moveDown = new MoveCursorDownCommand(this);
        Command moveLeft = new MoveCursorLeftCommand(this);
        Command moveRight = new MoveCursorRightCommand(this);
        Command togglePixel = new TogglePixelCommand(this);
        Command generateCode = new GenerateCodeCommand(this);

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP -> moveUp.execute();
                case DOWN -> moveDown.execute();
                case LEFT -> moveLeft.execute();
                case RIGHT -> moveRight.execute();
                case SPACE -> togglePixel.execute();
            }
        });

        Button generateButton = new Button("Generate Code");
        generateButton.setOnAction(e -> {
            generateCode.execute();
            gridPane.requestFocus(); // Return focus to the gridPane
        });
        gridPane.add(generateButton, 0, GRID_SIZE);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Pixel Art Editor");
        primaryStage.show();

        gridPane.requestFocus();

        updateCursor();
    }

    public void moveCursorUp() {
        if (cursorY > 0) cursorY--;
        updateCursor();
    }

    public void moveCursorDown() {
        if (cursorY < GRID_SIZE - 1) cursorY++;
        updateCursor();
    }

    public void moveCursorLeft() {
        if (cursorX > 0) cursorX--;
        updateCursor();
    }

    public void moveCursorRight() {
        if (cursorX < GRID_SIZE - 1) cursorX++;
        updateCursor();
    }

    public void togglePixel() {
        Rectangle current = grid[cursorY][cursorX];
        if (current.getFill() == Color.BLACK) {
            current.setFill(Color.WHITE);
        } else {
            current.setFill(Color.BLACK);
        }
    }

    public void generateCode() {
        StringBuilder sb = new StringBuilder("int[][] pixelArt = {\n");
        for (int i = 0; i < GRID_SIZE; i++) {
            sb.append("    {");
            for (int j = 0; j < GRID_SIZE; j++) {
                sb.append(grid[i][j].getFill() == Color.BLACK ? "1" : "0");
                if (j < GRID_SIZE - 1) sb.append(", ");
            }
            sb.append("}");
            if (i < GRID_SIZE - 1) sb.append(",");
            sb.append("\n");
        }
        sb.append("};");
        System.out.println(sb.toString());
    }

    private void updateCursor() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (i == cursorY && j == cursorX) {
                    grid[i][j].setStroke(Color.RED);
                } else {
                    grid[i][j].setStroke(Color.BLACK);
                }
            }
        }
    }
}
