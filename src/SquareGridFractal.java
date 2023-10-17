import javax.swing.*;
import java.awt.*;

public class SquareGridFractal extends JPanel {
    private int depth;
    private BasicStroke stroke;

    public SquareGridFractal(int depth) {
        this.depth = depth;
        this.stroke = new BasicStroke(2.0f); // 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(stroke); 
        drawSquare(g2d, getWidth() / 2, getHeight() / 2, 200, depth);
    }

    private void drawSquare(Graphics2D g, int x, int y, int size, int depth) {
        if (depth == 0) {
            return;
        }

        int halfSize = size / 2;
        int quarterSize = size / 4;

        g.drawRect(x - quarterSize, y - quarterSize, halfSize, halfSize);

        drawSquare(g, x - quarterSize, y - quarterSize, halfSize, depth - 1);
        drawSquare(g, x + quarterSize, y - quarterSize, halfSize, depth - 1); 
        drawSquare(g, x - quarterSize, y + quarterSize, halfSize, depth - 1); 
        drawSquare(g, x + quarterSize, y + quarterSize, halfSize, depth - 1); 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            SquareGridFractal fractal = new SquareGridFractal(4); 
            frame.add(fractal);
            frame.setSize(400, 400);
            frame.setVisible(true);
        });
    }
}
