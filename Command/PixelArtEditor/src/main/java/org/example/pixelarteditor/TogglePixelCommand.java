package org.example.pixelarteditor;

public class TogglePixelCommand implements Command {
    private final PixelArtEditor editor;

    public TogglePixelCommand(PixelArtEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.togglePixel();
    }
}
