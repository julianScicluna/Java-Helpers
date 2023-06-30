package Helpers;

import javax.swing.JLabel;
import java.awt.Color;

public class GUILabel extends JLabel implements GUIComponent {
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
    public void setPosition(int x, int y) {
        this.setLocation(x, y);
    }
    public int[] getPosition() {
        return new int[] {this.getLocation().x, this.getLocation().y};
    }
}
