import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class student extends JFrame implements ActionListener
{
    Date d,dateWithoutTime;
    String[] arr={"Select Election"};
    String s,s1,s2,s3,s4;
    JButton b,b1;
    JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    static JComboBox cb;
    JPanel p;
    int n1;
    ImageIcon vit;
    student() throws ParseException {

        Object[] row = new Object[4];
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/votingsystem?characterEncoding=latin1", "root", "root");
            Statement st = c.createStatement();
            String q="select * from students where Roll_No ='"+login.t.getText()+"'";
            ResultSet rs=st.executeQuery(q);

            rs.next();
            s=rs.getString("Roll_No");
            s1=rs.getString("Student_Name");
            s2=rs.getString("phone_no");
            s3=rs.getString("Email");

        }
        catch (Exception d )
        {
            System.out.println(d);
        }


        vit = new ImageIcon("vit symbol 2 (2).jpeg");

        l3= new JLabel();
        l3.setIcon(vit);
        l3.setBounds(10,10,200,80);

        l2= new JLabel("Election by VIT");
        l2.setBounds(200,35,300,60);
        l2.setForeground(Color.black);
        l2.setFont(new Font("Arial",Font.BOLD,15));

        l1 = new JLabel();
        l1.setText("Student Portal");
        l1.setBounds(200,30,300,20);
        l1.setFont(new Font("Arial",Font.BOLD,25));
        l1.setForeground(Color.black);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        dateWithoutTime = sdf.parse(sdf.format(new Date()));

        String date = sdf.format(dateWithoutTime);
        l11=new JLabel(date);
        l11.setBounds(400,270,100,20);


        l= new JLabel("Name          :");
        l.setFont(new Font("Serial",Font.BOLD,18));
        l.setForeground(Color.BLACK);
        l.setBounds(20,120,120,30);

        l7= new JLabel(s1);
        l7.setFont(new Font("Serial",Font.BOLD,15));
        l7.setForeground(Color.gray);
        l7.setBounds(150,120,200,30);

        l4= new JLabel("Roll No      :");
        l4.setFont(new Font("Serial",Font.BOLD,18));
        l4.setForeground(Color.BLACK);
        l4.setBounds(21,160,120,30);

        l8= new JLabel(s);
        l8.setFont(new Font("Serial",Font.BOLD,15));
        l8.setForeground(Color.gray);
        l8.setBounds(150,160,150,30);

        l5= new JLabel("Email ID     :");
        l5.setFont(new Font("Serial",Font.BOLD,18));
        l5.setForeground(Color.BLACK);
        l5.setBounds(21,200,120,30);

        l9= new JLabel(s3);
        l9.setFont(new Font("Serial",Font.BOLD,15));
        l9.setForeground(Color.gray);
        l9.setBounds(150,200,250,30);

        l6= new JLabel("Phone No  :");
        l6.setFont(new Font("Serial",Font.BOLD,18));
        l6.setForeground(Color.BLACK);
        l6.setBounds(20,240,120,30);

        l10= new JLabel(s2);
        l10.setFont(new Font("Serial",Font.BOLD,15));
        l10.setForeground(Color.gray);
        l10.setBounds(150,240,150,30);


        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/votingsystem?characterEncoding=latin1", "root", "root");
            Statement st = c.createStatement();
            String q="select election_name from elections";
            ResultSet rs=st.executeQuery(q);

            while(rs.next())
            {
                String s=rs.getString("election_name");
                List<String> i = new ArrayList<String>(Arrays.asList(arr));
                i.add(s);
                arr = i.toArray(arr);
            }
        }
        catch (Exception d )
        {
            System.out.println(d);
        }


        cb= new JComboBox(arr);
        cb.setForeground(Color.gray.brighter());
        cb.setBounds(60,300,350,30);

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

        this.add(l);
        this.add(l4);
        this.add(l5);
        this.add(l6);
        this.add(l7);
        this.add(l8);
        this.add(l9);
        this.add(l10);
        this.add(p);
        this.add(b);
        this.add(b1);
        this.add(cb);
        this.add(l11);
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
            login n=new login();
        }
        if (e.getSource()==b1)
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/votingsystem?characterEncoding=latin1", "root", "root");
                Statement st = c.createStatement();
                String q2="select * from students where Roll_No ='"+login.t.getText()+"'";
                ResultSet rs=st.executeQuery(q2);

                rs.next();
                s4=cb.getSelectedItem().toString();
                n1=rs.getInt(s4);

                if (n1==1)
                {
                    JOptionPane.showMessageDialog(null,"U Already voted");
                }
                else
                {
                    String q3="select end_date from elections where election_name = '"+s4+"'";
                    ResultSet rs1=st.executeQuery(q3);
                    rs1.next();
                    d=rs1.getDate(1);

                    if (dateWithoutTime.compareTo(d)<0)
                    {
                        new student_vote();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Date is over");
                    }

                }

            }
            catch (Exception d )
            {
                System.out.println(d);
            }
        }
    }
}
