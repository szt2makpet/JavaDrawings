import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    static int WIDTH = 400;
    static int HEIGHT = 400;
    static int rectangleX = 4;  // x-coordinate of the lower-left corner
    static int rectangleY = 3;  // y-coordinate of the lower-left corner
    static int rectangleWidth = 5;  // Width of the rectangle
    static int rectangleHeight = 4; // Height of the rectangle

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Rectangle on Cartesian Plane");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        CartesianPlanePanel panel = new CartesianPlanePanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    static class CartesianPlanePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);

            int centerX = WIDTH / 2;
            int centerY = HEIGHT / 2;

            // Draw the Cartesian plane axes
            graphics.setColor(Color.black);
            graphics.drawLine(0, centerY, WIDTH, centerY);
            graphics.drawLine(centerX, 0, centerX, HEIGHT);

            // Draw the rectangle
            graphics.setColor(Color.blue);
            graphics.drawRect(rectangleX * 40 + centerX, centerY - (rectangleY + rectangleHeight) * 40, rectangleWidth * 40, rectangleHeight * 40);
        }
    }
}
