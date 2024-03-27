import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admin extends JFrame implements ActionListener
{
    JButton b1,b2,b3,b4,b5;
    JLabel l,l1,l2,l3;
    JPanel p;
    ImageIcon vit,s;
    admin()
    {
        vit = new ImageIcon("vit symbol 2 (2).jpeg");
        s = new ImageIcon("ele.jpeg");

        l=new JLabel();
        l.setIcon(s);
        l.setBounds(200,100,150,150);

        l3= new JLabel();
        l3.setIcon(vit);
        l3.setBounds(10,10,200,80);

        l2= new JLabel("Election by VIT");
        l2.setBounds(200,35,300,60);
        l2.setForeground(Color.black);
        l2.setFont(new Font("Arial",Font.BOLD,15));

        l1 = new JLabel();
        l1.setText("Admin Portal");
        l1.setBounds(200,30,300,20);
        l1.setFont(new Font("Arial",Font.BOLD,25));
        l1.setForeground(Color.black);

        p=new JPanel();
        p.add(l1);
        p.add(l2);
        p.add(l3);
        p.setBounds(0,0,500,100);
        p.setBackground(new Color(36, 63, 150, 255));
        p.setLayout(null);
        p.setVisible(true);

        b1 = new JButton("Logout");
        b1.addActionListener(this);
        b1.setForeground(Color.white);
        b1.setBackground(Color.red);
        b1.setFont(new Font("Serial",Font.BOLD,20));
        b1.setFocusable(false);
        b1.setBounds(170,400,140,30);

        b2 = new JButton("Add Election");
        b2.addActionListener(this);
        b2.setBackground(new Color(36, 63, 150, 255));
        b2.setForeground(Color.white);
        b2.setFocusable(false);
        b2.setBounds(40,260,150,40);
        b2.setFont(new Font("Arial",Font.BOLD,15));

        b3 = new JButton("Add Candidate");
        b3.addActionListener(this);
        b3.setBackground(new Color(36, 63, 150, 255));
        b3.setForeground(Color.white);
        b3.setFocusable(false);
        b3.setBounds(280,260,150,40);
        b3.setFont(new Font("Arial",Font.BOLD,15));

        b4 = new JButton("View Candidates");
        b4.addActionListener(this);
        b4.setBackground(new Color(36, 63, 150, 255));
        b4.setForeground(Color.white);
        b4.setFocusable(false);
        b4.setBounds(40,330,150,40);
        b4.setFont(new Font("Arial",Font.BOLD,13));

        b5 = new JButton("View Voters");
        b5.addActionListener(this);
        b5.setBackground(new Color(36, 63, 150, 255));
        b5.setForeground(Color.white);
        b5.setFocusable(false);
        b5.setBounds(280,330,150,40);
        b5.setFont(new Font("Arial",Font.BOLD,15));

        this.add(b3);
        this.add(b2);
        this.add(p);
        this.add(b1);
        this.add(b4);
        this.add(b5);
        this.add(l);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==b1)
        {
            this.dispose();
            admin_login n=new admin_login();
        }
        if (e.getSource()==b2)
        {
            this.dispose();
            Add_Election n= new Add_Election();
        }
        if (e.getSource()==b3)
        {
            this.dispose();
            Add_Candidates n= new Add_Candidates();
        }
        if (e.getSource()==b4)
        {
            this.dispose();
            new Candidates();
        }
        if (e.getSource()==b5)
        {
            this.dispose();
            new voters();
        }
    }
}
