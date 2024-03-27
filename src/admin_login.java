import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class admin_login extends JFrame implements ActionListener
{
    JPasswordField t1;
    JTextField t;
    JButton b,b1;
    JLabel l,l1,l2,l3,l4,l5;
    JPanel p;
    ImageIcon vit,s ;
    admin_login()
    {
        vit = new ImageIcon("vit.png");
        s = new ImageIcon("admin.png");

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

        l=new JLabel();
        l.setIcon(s);
        l.setBounds(190,100,150,150);

        l4= new JLabel("Username");
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Serial",Font.BOLD,20));
        l4.setBounds(100,270,120,50);

        t= new JTextField();
        t.setBounds(240,280,120,30);

        l5= new JLabel("Password");
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("Serial",Font.BOLD,20));
        l5.setBounds(100,320,120,50);

        t1= new JPasswordField();
        t1.setBounds(240,330,120,30);
        t1.setEchoChar('*');

        p=new JPanel();
        p.add(l1);
        p.add(l2);
        p.add(l3);
        p.setBounds(0,0,500,100);
        p.setBackground(new Color(36, 63, 150, 255));
        p.setLayout(null);
        p.setVisible(true);

        b1 = new JButton("Submit");
        b1.addActionListener(this);
        b1.setForeground(Color.white);
        b1.setBackground(new Color(36, 63, 150, 255));
        b1.setFont(new Font("Serial",Font.BOLD,25));
        b1.setFocusable(false);
        b1.setBounds(170,390,140,30);

        b= new JButton("Back");
        b.addActionListener(this);
        b.setForeground(Color.white);
        b.setBackground(new Color(36, 63, 150, 255));
        b.setFont(new Font("Serial",Font.BOLD,25));
        b.setFocusable(false);
        b.setBounds(380,110,100,33);

        this.add(l);
        this.add(l4);
        this.add(l5);
        this.add(p);
        this.add(b);
        this.add(b1);
        this.add(t);
        this.add(t1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==b)
        {
            this.dispose();
            Main n=new Main();
        }

        if (e.getSource()==b1)
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/votingsystem?characterEncoding=latin1","root","root");
                Statement st= c.createStatement();
                String sql ="Select * from admins where username='"+t.getText()+"' and pass_word='"+t1.getText().toString()+"'";
                ResultSet rs= st.executeQuery(sql);
                if (rs.next())
                {
                    JOptionPane.showMessageDialog(null,"Login Successfully...");
                    this.dispose();
                    admin n=new admin();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Incorrect Password or Username....");
                }
                c.close();
            }

            catch (Exception d )
            {
                System.out.println(d);
            }
        }
    }
}
