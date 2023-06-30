package Helpers;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class GUIHelper extends JFrame {
    public JFrame createWindow() {
        return new GUIFrame();
    }
    public JFrame createWindow(String title) {
        return new GUIFrame(title);
    }
}
class GUIFrame extends JFrame {
    public GUIFrame(String title) {
        super(title);
    }
    public GUIFrame() {
        super();
    }
    public void show() {
        this.setVisible(true);
    }
    public void hide() {
        this.setVisible(false);
    }
}
class GUIImage extends JPanel implements GUIComponent {
    public static Color defaultColor = Color.BLACK;
    private Color color;
    private BufferedImage image;
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        g2d.setColor(color);
        g2d.drawRect(0, 0, getWidth(), getHeight());
    }
    public void setImage(BufferedImage image) {
        this.image = image;
        this.repaint();
    }
    public GUIImage(Color color) {
        super();
        this.color = color;
    }
    public GUIImage() {
        super();
        this.color = defaultColor;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public Color getColor() {
        return color;
    }
    public void setImage(File file) {
        try {
            BufferedImage bi = ImageIO.read(file);
            this.image = bi;
            this.repaint();
        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
class GUILabel extends JLabel implements GUIComponent {
    public GUILabel(String text) {
        super(text);
    }
    public GUILabel() {
        super();
    }
    public void setColor(Color c) {
        setForeground(c);
    }
    public Color getColor() {
        return getForeground();
    }
}
class GUIButton extends JButton implements GUIComponent {
    public GUIButton(String text) {
        super(text);
    }
    public GUIButton() {
        super();
    }
    public void setColor(Color c) {
        setForeground(c);
    }
    public Color getColor() {
        return getForeground();
    }
}
interface GUIComponent {
    public void setColor(Color c);
    public Color getColor();
}