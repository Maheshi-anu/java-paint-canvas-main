import javax.swing.*;
import java.awt.*;

public class PaintRunner extends JFrame {
    public static void main(String[] args) {
        Paint p = new Paint();
        p.setTitle("CanvasPro");
        p.setSize(800,800);
        p.setLayout(new FlowLayout());
        p.setVisible(true);
        p.setResizable(false);
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
