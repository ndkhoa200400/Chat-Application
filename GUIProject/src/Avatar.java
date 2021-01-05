
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

class Avatar extends JPanel {

    private static final long serialVersionUID = -1785500234010387682L;
    private Image image = null;

    public Avatar(String url, int width, int height) {
        loadAvatar(url, width, height);
    }

    public void loadAvatar(String url, int width, int height) {
        image = Toolkit.getDefaultToolkit().getImage(url);
        this.setPreferredSize(new Dimension(width, height));
        revalidate();
        updateUI();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}