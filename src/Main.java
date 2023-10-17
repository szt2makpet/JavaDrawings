import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int size = 300;
        int levels = 10; // A háromszög szintjeinek száma

        drawTriangle(g, 0, 0, size, levels);
    }

    private void drawTriangle(Graphics g, int x, int y, int size, int level) {
        if (level == 0) {
            int[] xPoints = {x, x + size / 2, x + size};
            int[] yPoints = {y + size, y, y + size};
            g.drawPolygon(xPoints, yPoints, 3);
        } else {
            int halfSize = size / 2;

            drawTriangle(g, x, y, halfSize, level - 1); // Bal alsó háromszög
            drawTriangle(g, x + halfSize, y, halfSize, level - 1); // Jobb alsó háromszög
            drawTriangle(g, x + halfSize / 2, y + size / 2, halfSize, level - 1); // Felső háromszög
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Triangle Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Main());
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
