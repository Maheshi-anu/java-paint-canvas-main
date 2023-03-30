import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
public class Paint extends JFrame implements MouseMotionListener{
    Label pointerLocationLabel;
    JPanel colorButtonPanel, canvasPanel,clearPanel, colorContainerPanel;
    JButton blue, red, green, black, yellow, orange, pink, gray;
    JButton selectedColor;
    JButton white, clear;
    JButton[] colors = new JButton[8];
    Color[] color = new Color[8];
    Color c=Color.BLUE;
    Paint(){
        pointerLocationLabel =new Label();
        pointerLocationLabel.setPreferredSize(new Dimension(750,15));
        pointerLocationLabel.setAlignment(Label.RIGHT);

        blue = new JButton();
        red = new JButton();
        green = new JButton();
        black = new JButton();
        yellow = new JButton();
        orange = new JButton();
        pink = new JButton();
        gray = new JButton();

        colors[0] = blue;
        colors[1] = red;
        colors[2] = green;
        colors[3] = black;
        colors[4] = yellow;
        colors[5] = orange;
        colors[6] = pink;
        colors[7] = gray;

        color[0] = Color.BLUE;
        color[1] = Color.RED;
        color[2] = Color.GREEN;
        color[3] = Color.BLACK;
        color[4] = Color.YELLOW;
        color[5] = Color.ORANGE;
        color[6] = Color.PINK;
        color[7] = Color.GRAY;

        selectedColor = new JButton();
        selectedColor.setPreferredSize(new Dimension(50,50));
        selectedColor.setBorderPainted(false);
        selectedColor.setBackground(c);
        selectedColor.setOpaque(true);


        for (int i = 0; i < colors.length; i++) {
            colors[i].setBackground(color[i]);
            colors[i].setPreferredSize(new Dimension(50,50));
            colors[i].addActionListener(e -> {
                for (int j = 0; j < colors.length; j++) {
                    if(e.getSource()==colors[j]){
                        c=color[j];
                        selectedColor.setBackground(c);
                    }
                }
            });
            colors[i].setOpaque(true);
            colors[i].setBorderPainted(false);
        }


        white = new JButton();
        white.setBackground(Color.WHITE);
        white.setOpaque(true);
        white.setBorderPainted(false);
        white.setPreferredSize(new Dimension(50,50));
        white.addActionListener(e -> c = Color.WHITE);

        clear = new JButton("Clear");
        clear.setPreferredSize(new Dimension(50,50));
        clear.addActionListener(e -> {
            canvasPanel.removeAll();
            canvasPanel.repaint();
        });

        clearPanel = new JPanel(new FlowLayout());
        clearPanel.setPreferredSize(new Dimension(120,50));
        clearPanel.add(white);
        clearPanel.add(clear);


        canvasPanel = new JPanel();
        canvasPanel.setPreferredSize(new Dimension(800,680));
        canvasPanel.setBackground(Color.WHITE);
        canvasPanel.addMouseMotionListener(this);

        colorButtonPanel = new JPanel(new FlowLayout());
        colorButtonPanel.add(blue);
        colorButtonPanel.add(red);
        colorButtonPanel.add(green);
        colorButtonPanel.add(black);
        colorButtonPanel.add(yellow);
        colorButtonPanel.add(orange);
        colorButtonPanel.add(pink);
        colorButtonPanel.add(gray);
        colorButtonPanel.setPreferredSize(new Dimension(600,100));


        colorContainerPanel = new JPanel(new BorderLayout());
        colorContainerPanel.add(selectedColor, BorderLayout.WEST);
        colorContainerPanel.add(colorButtonPanel, BorderLayout.CENTER);
        colorContainerPanel.add(clearPanel, BorderLayout.EAST);
        colorContainerPanel.setPreferredSize(new Dimension(800,100));


        add(canvasPanel);
        add(pointerLocationLabel);
        add(colorContainerPanel);
    }

    public void mouseDragged(MouseEvent e) {
        pointerLocationLabel.setText("X="+e.getX()+", Y="+e.getY());
        Graphics g=getGraphics();
        g.setColor(c);
        g.fillOval(e.getX(),e.getY()+25,20,20);
    }

    public void mouseMoved(MouseEvent e) {
        pointerLocationLabel.setText("Pointer Location: "+"X="+e.getX()+", Y="+e.getY());
    }
}  