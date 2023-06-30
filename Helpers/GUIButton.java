package Helpers;

import javax.swing.JButton;
import java.awt.Color;

public class GUIButton extends JButton implements GUIComponent {
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
    public void setPosition(int x, int y) {
        this.setLocation(x, y);
    }
    public int[] getPosition() {
        return new int[] {this.getLocation().x, this.getLocation().y};
    }
}
