package Helpers;

import javax.swing.JFrame;

public class GUIFrame extends JFrame {
    public GUIFrame(String title) {
        super(title);
        this.setLayout(null);
    }
    public GUIFrame() {
        super();
        this.setLayout(null);
    }
    public void showWindow() {
        this.setVisible(true);
    }
    public void hideWindow() {
        this.setVisible(false);
    }
}
