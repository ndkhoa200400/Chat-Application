import java.awt.Color;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame();// tạo thể hiện của JFrame
        int WIDTH = 800, HEIGHT = 600;
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        p1.setBounds(0, 0, 250, 600);// trục x , y , width, height
        p1.setBackground(Color.red);
        f.add(p1);

        p2.setBounds(250, 500, 550, 100);
        p2.setBackground(Color.green);
        f.add(p2);

        p3.setBounds(250, 0, 550, 70);
        p3.setBackground(Color.green);
        f.add(p3);

        f.setTitle("Messenger");

        f.setSize(WIDTH, HEIGHT);// thiết lập kích thước cho của sổ
        f.setLayout(null);// không sử dụng trình quản lý bố cục
        f.setVisible(true);// hiển thị cửa sổ
    }
}
