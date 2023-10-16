import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Triangle with Small Triangles");
            frame.setSize(300, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    drawTriangleWithSmallTriangles(g);
                }

                private void drawTriangleWithSmallTriangles(Graphics g) {
                    int x1 = 150; 
                    int y1 = 50;  
                    int size = 200;

                    int[] xPoints = {x1, x1 - size / 2, x1 + size / 2};
                    int[] yPoints = {y1, y1 + size, y1 + size};

                    g.setColor(Color.black);
                    g.drawPolygon(xPoints, yPoints, 3);

                    int smallTriangleSize = 11; 
                    int numberOfSmallTriangles = size / smallTriangleSize;

                    for (int i = 0; i < numberOfSmallTriangles; i++) {
                        int xSmall = x1 - size / 2 + i * smallTriangleSize - smallTriangleSize / 2 + 1;
                        int ySmall = y1 + size - smallTriangleSize;
                        int[] xSmallPoints = {xSmall, xSmall - smallTriangleSize / 2, xSmall + smallTriangleSize / 2};
                        int[] ySmallPoints = {ySmall, ySmall + smallTriangleSize, ySmall + smallTriangleSize};

                        g.drawPolygon(xSmallPoints, ySmallPoints, 3);
                    }
                }
            };

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
