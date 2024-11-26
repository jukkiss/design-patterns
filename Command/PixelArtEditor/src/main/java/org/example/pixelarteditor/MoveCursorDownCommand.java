package org.example.pixelarteditor;

public class MoveCursorDownCommand implements Command {
    private final PixelArtEditor editor;

    public MoveCursorDownCommand(PixelArtEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.moveCursorDown();
    }
}