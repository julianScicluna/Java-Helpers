package Helpers;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class GUIHelper extends JFrame {
    public GUIFrame createWindow() {
        return new GUIFrame();
    }
    public GUIFrame createWindow(String title) {
        return new GUIFrame(title);
    }
    public GUIImage createImage() {
        return new GUIImage();
    }
    public GUIImage createImage(Color color) {
        return new GUIImage(color);
    }
    public GUIImage createImage(Color color, String caption) {
        return new GUIImage(color, caption);
    }
    public GUIImage createImage(String caption) {
        return new GUIImage(caption);
    }
    public GUILabel createText() {
        return new GUILabel();
    }
    public GUILabel createText(String text) {
        return new GUILabel(text);
    }
    public GUIButton createButton() {
        return new GUIButton();
    }
    public GUIButton createButton(String text) {
        return new GUIButton(text);
    }
}