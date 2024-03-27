import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main extends JFrame implements ActionListener {
    JPanel p ,p1;
    JLabel l1,l2,l3,l4;
    ImageIcon vit,s;
    JButton b,b1,b2;

    Main() {
        vit = new ImageIcon("vit.png");
        s = new ImageIcon("admin.png");

        l3 = new JLabel();
        l3.setIcon(vit);
        l3.setBounds(10, 10, 200, 80);

        l2 = new JLabel("Election by VIT");
        l2.setBounds(200, 35, 300, 60);
        l2.setForeground(Color.black);
        l2.setFont(new Font("Arial", Font.BOLD, 15));

        l1 = new JLabel();
        l1.setText("Election Portal");
        l1.setBounds(200, 30, 300, 20);
        l1.setFont(new Font("Arial", Font.BOLD, 25));
        l1.setForeground(Color.black);

        l4 = new JLabel("Login :");
        l4.setBounds(30, 160, 300, 32);
        l4.setFont(new Font("Arial", Font.BOLD, 28));
        l4.setForeground(Color.black);

        p=new JPanel();
        p.add(l1);
        p.add(l2);
        p.add(l3);
        p.setBounds(0,0,500,100);
        p.setBackground(new Color(36, 63, 150, 255));
        p.setLayout(null);
        p.setVisible(true);


        b1 = new JButton("Student");
        b1.addActionListener(this);
        b1.setForeground(Color.black);
        b1.setBackground(new Color(246, 246, 248, 255));
        b1.setFont(new Font("Serial", Font.BOLD, 25));
        b1.setFocusable(false);
        b1.setBounds(115, 60, 150, 33);

        b2 = new JButton("Admin");
        b2.addActionListener(this);
        b2.setForeground(Color.black);
        b2.setBackground(new Color(246, 246, 248, 255));
        b2.setFont(new Font("Serial", Font.BOLD, 25));
        b2.setFocusable(false);
        b2.setBounds(115, 135, 150, 33);

        p1 = new JPanel();
        p1.add(b1);
        p1.add(b2);
        p1.setBounds(50, 200, 380, 230);
        p1.setBackground(new Color(36, 63, 150, 255));
        p1.setLayout(null);
        p1.setVisible(true);

        b = new JButton("Exit");
        b.addActionListener(this);
        b.setForeground(Color.white);
        b.setBackground(new Color(36, 63, 150, 255));
        b.setFont(new Font("Serial", Font.BOLD, 25));
        b.setFocusable(false);
        b.setBounds(380, 110, 100, 33);

        this.add(p);
        this.add(p1);
        this.add(b);
        this.add(l4);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
         new Main();
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==b)
        {
            this.dispose();
        }
        if (e.getSource()==b1){
            this.dispose();
            new login();
        }
        if (e.getSource()==b2){
            this.dispose();
            new admin_login();
        }
    }
}