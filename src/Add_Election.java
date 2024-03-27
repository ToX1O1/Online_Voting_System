import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.sql.*;
import java.sql.Date;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

public class Add_Election extends JFrame implements ActionListener
{
    JDateChooser t1;
    JTextField t;
    JLabel l1,l,l2,l3,l4,l5;
    JButton b,b1;
    ImageIcon vit,s;
    JPanel p;
    Add_Election()
    {
        vit = new ImageIcon("vit symbol 2 (2).jpeg");
        s = new ImageIcon("man.png");

        l4=new JLabel();
        l4.setIcon(s);
        l4.setBounds(170,110,150,120);

        l3= new JLabel();
        l3.setIcon(vit);
        l3.setBounds(10,10,200,80);

        l2= new JLabel("Election by VIT");
        l2.setBounds(200,35,300,60);
        l2.setForeground(Color.black);
        l2.setFont(new Font("Arial",Font.BOLD,15));

        l = new JLabel();
        l.setText("Admin Portal");
        l.setBounds(200,30,300,20);
        l.setFont(new Font("Arial",Font.BOLD,25));
        l.setForeground(Color.black);

        p=new JPanel();
        p.add(l);
        p.add(l2);
        p.add(l3);
        p.setBounds(0,0,500,100);
        p.setBackground(new Color(36, 63, 150, 255));
        p.setLayout(null);
        p.setVisible(true);

        l1= new JLabel("Election Name");
        l1.setFont(new Font("Arial",Font.BOLD,18));
        l1.setBounds(40,280,200,25);
        l1.setForeground(Color.BLACK);

        t= new JTextField();
        t.setBounds(240,280,120,25);

        l5= new JLabel("End Date");
        l5.setFont(new Font("Arial",Font.BOLD,18));
        l5.setBounds(40,330,200,25);
        l5.setForeground(Color.BLACK);

        t1= new JDateChooser();
        t1.setBounds(240,330,120,25);

        b1 = new JButton("Submit");
        b1.addActionListener(this);
        b1.setForeground(Color.white);
        b1.setBackground(new Color(36, 63, 150, 255));
        b1.setFont(new Font("Serial",Font.BOLD,20));
        b1.setFocusable(false);
        b1.setBounds(170,400,140,30);

        b= new JButton("Back");
        b.addActionListener(this);
        b.setForeground(Color.white);
        b.setBackground(new Color(36, 63, 150, 255));
        b.setFont(new Font("Serial",Font.BOLD,25));
        b.setFocusable(false);
        b.setBounds(380,110,100,33);

        this.add(l1);
        this.add(b);
        this.add(b1);
        this.add(p);
        this.add(l4);
        this.add(l5);
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
            admin n=new admin();
        }

        if (e.getSource()==b1)
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/votingsystem?characterEncoding=latin1","root","root");
                String s = t.getText();
                java.sql.Date date = new Date(t1.getDate().getTime());
                Statement st= c.createStatement();
                String sql = " CREATE TABLE IF NOT EXISTS "+ s
                        +" ( \n candidate_id int not null auto_increment ,"
                        +" \n candidate_name varchar(100) not null , "
                        +" \n candidate_ph varchar(20) not null , "
                        +" \n candidate_email varchar(100) not null , "
                        +" \n candidate_field varchar(20) not null , "
                        +" \n candidate_sex varchar(20) not null , "
                        +" \n candidate_image mediumblob not null , "
                        +" \n candidate_votes int , "
                        +" \n PRIMARY KEY(candidate_id) "
                        +" \n)";
                st.execute(sql);
                st.executeUpdate("INSERT INTO ELECTIONS(election_name,end_date)" + "VALUES( '" + s  + "' ,'"+date+"' )");
                st.execute("ALTER TABLE STUDENTS " +
                        "ADD COLUMN "+ s + " int ;");
                c.close();
                JOptionPane.showMessageDialog(null,"Added Successfully","New Election",JOptionPane.PLAIN_MESSAGE);
                admin n = new admin();
            }
            catch (Exception d )
            {
                System.out.println(d);
            }
        }
    }
}
