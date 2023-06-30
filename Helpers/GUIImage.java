package Helpers;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

public class GUIImage extends JPanel implements GUIComponent {
    private static Font defaultFont = new Font("Calibri", Font.PLAIN, 20);
    public static Color defaultColor = Color.BLACK;
    private Color color;
    private BufferedImage image;
    private boolean doCaption = false;
    private String caption;
    private Toolkit toolkit;
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(defaultFont);
        FontMetrics fm = g2d.getFontMetrics();
        g2d.setColor(color);
        if (doCaption) {
            g2d.drawImage(image, 0, 0, getWidth(), getHeight() - fm.getAscent() - 5, this);
            g2d.drawString(caption, (getWidth() - fm.stringWidth(caption))/2, getHeight() - fm.getAscent()/2);
        } else {
            g2d.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
        g2d.drawRect(0, 0, getWidth(), getHeight());
    }
    public void setImage(BufferedImage image) {
        FontMetrics fm = toolkit.getFontMetrics(defaultFont);
        this.image = image;
        if (doCaption) {
            repaint(0, 0, getWidth(), getHeight() - fm.getAscent() - 5);
        } else {
            repaint(0, 0, getWidth(), getHeight());
        }
    }
    public void setPosition(int x, int y) {
        this.setLocation(x, y);
    }
    public int[] getPosition() {
        return new int[] {this.getLocation().x, this.getLocation().y};
    }
    public void doCaption(boolean doCaption) {
        this.doCaption = doCaption;
        this.repaint();
    }
    public void setCaption(String caption) {
        FontMetrics fm = toolkit.getFontMetrics(defaultFont);
        this.caption = caption;
        this.doCaption = true;
        repaint(0, getHeight() - fm.getAscent() - 5, getWidth(), fm.getAscent() + 5);
    }
    public String getCaption() {
        return caption;
    }
    public GUIImage(Color color) {
        super();
        this.toolkit = Toolkit.getDefaultToolkit();
        this.color = color;
        repaint();
    }
    public GUIImage(Color color, String caption) {
        super();
        this.toolkit = Toolkit.getDefaultToolkit();
        this.color = color;
        this.doCaption = true;
        this.caption = caption;
        repaint();
    }
    public GUIImage(String caption) {
        super();
        this.toolkit = Toolkit.getDefaultToolkit();
        this.color = defaultColor;
        this.doCaption = true;
        this.caption = caption;
        repaint();
    }
    public GUIImage() {
        super();
        this.toolkit = Toolkit.getDefaultToolkit();
        this.color = defaultColor;
    }
    public void setColor(Color color) {
        this.color = color;
        repaint();
    }
    public Color getColor() {
        return color;
    }
    public void setImage(File file) {
        try {
            FontMetrics fm = toolkit.getFontMetrics(defaultFont);
            BufferedImage bi = ImageIO.read(file);
            this.image = bi;
            if (doCaption) {
                repaint(0, 0, getWidth(), getHeight() - fm.getAscent() - 5);
            } else {
                repaint(0, 0, getWidth(), getHeight());
            }
        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
