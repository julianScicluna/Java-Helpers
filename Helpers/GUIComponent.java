package Helpers;

import java.awt.Color;

interface GUIComponent {
    public void setColor(Color c);
    public Color getColor();
    public void setPosition(int x, int y);
    public int[] getPosition();
}
