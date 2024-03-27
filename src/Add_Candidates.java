import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Add_Candidates extends JFrame implements ActionListener {

    JComboBox cb,f;
    ButtonGroup bg;
    JRadioButton r1,r2;
    JButton b,b1,b2;
    JPanel p;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    ImageIcon vit,s,candidate;
    JTextField t,t1,t2;
    FileInputStream candidate_img;
            String[] arr={"Select Election"};
    String[] fields={"Select Field","CMPN","INFT","BIO","EXTC","ETRX"};
    Add_Candidates()
    {

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

        p=new JPanel();
        p.add(l1);
        p.add(l2);
        p.add(l3);
        p.setBounds(0,0,500,100);
        p.setBackground(new Color(36, 63, 150, 255));
        p.setLayout(null);
        p.setVisible(true);


        b= new JButton("Back");
        b.addActionListener(this);
        b.setForeground(Color.white);
        b.setBackground(new Color(36, 63, 150, 255));
        b.setFont(new Font("Serial",Font.BOLD,25));
        b.setFocusable(false);
        b.setBounds(380,110,100,33);

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
        cb.setBounds(25,120,250,30);

        l4= new JLabel("Candidate Name :");
        l4.setFont(new Font("Serial",Font.BOLD,16));
        l4.setForeground(Color.BLACK);
        l4.setBounds(21,170,150,30);

        t= new JTextField();
        t.setFont(new Font("Serial",Font.PLAIN,12));
        t.setForeground(Color.BLACK);
        t.setBounds(175,175,120,25);

        l5= new JLabel("Phone Number");
        l5.setFont(new Font("Serial",Font.BOLD,16));
        l5.setForeground(Color.BLACK);
        l5.setBounds(21,210,150,30);

        t1= new JTextField();
        t1.setFont(new Font("Serial",Font.PLAIN,12));
        t1.setForeground(Color.BLACK);
        t1.setBounds(175,215,120,25);

        l7= new JLabel(":");
        l7.setFont(new Font("Serial",Font.BOLD,16));
        l7.setForeground(Color.BLACK);
        l7.setBounds(149,210,20,30);

        l6=new JLabel("Email ID ");
        l6.setFont(new Font("Serial",Font.BOLD,16));
        l6.setForeground(Color.BLACK);
        l6.setBounds(21,250,150,30);

        t2= new JTextField();
        t2.setFont(new Font("Serial",Font.PLAIN,12));
        t2.setForeground(Color.BLACK);
        t2.setBounds(175,255,120,25);

        l8= new JLabel(":");
        l8.setFont(new Font("Serial",Font.BOLD,16));
        l8.setForeground(Color.BLACK);
        l8.setBounds(149,250,20,30);

        f= new JComboBox(fields);
        f.setForeground(Color.gray.brighter());
        f.setBounds(35,300,200,30);

        l9 = new JLabel();
        l9.setBackground(Color.BLACK);
        l9.setBounds(320,165,150,150);
        l9.setLayout(null);
        l9.setOpaque(true);
        l9.setVisible(true);


        b2= new JButton("browse");
        b2.addActionListener(this);
        b2.setForeground(Color.white);
        b2.setBackground(new Color(0, 3, 12, 255));
        b2.setFont(new Font("Serial",Font.PLAIN,15));
        b2.setFocusable(false);
        b2.setBounds(335,340,120,28);

        b1= new JButton("ADD");
        b1.addActionListener(this);
        b1.setForeground(Color.white);
        b1.setBackground(new Color(36, 63, 150, 255));
        b1.setFont(new Font("Serial",Font.BOLD,25));
        b1.setFocusable(false);
        b1.setBounds(200,390,100,33);

        r1 = new JRadioButton("Male");
        r1.setBounds(50,350,100,33);
        r1.addActionListener(this);
        r1.setActionCommand("Male");

        r2 = new JRadioButton("Female");
        r2.setBounds(150,350,100,33);
        r2.addActionListener(this);
        r2.setActionCommand("Female");

        bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        this.add(cb);
        this.add(p);
        this.add(b);
        this.add(r1);
        this.add(r2);
        this.add(b1);
        this.add(l4);
        this.add(b2);
        this.add(l5);
        this.add(l6);
        this.add(l7);
        this.add(l8);
        this.add(l9);
        this.add(t);
        this.add(t1);
        this.add(t2);
        this.add(f);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == b2) {
            JFileChooser f = new JFileChooser();
            f.showOpenDialog(null);
            File file = f.getSelectedFile();
            candidate = new ImageIcon(file.toString());
            try {
                candidate_img = new FileInputStream(file);

            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            l9.setIcon(candidate);
        }
        if (e.getSource() == b1){



            String s3 = cb.getSelectedItem().toString();

            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/votingsystem?characterEncoding=latin1", "root", "root");
                String A=("INSERT INTO `votingsystem`.`"+s3+"` (`candidate_name`,`candidate_ph`,`candidate_email`,`candidate_field`,`candidate_sex`,`candidate_image`) " +
                        "VALUES ('" +t.getText()+ "' ,'"+t1.getText()+"','"+t2.getText()+"','"+f.getSelectedItem().toString()+"','"+bg.getSelection().getActionCommand()+"',?)");
                PreparedStatement st = c.prepareStatement(A);
                st.setBinaryStream(1,candidate_img);

                st.execute();
                c.close();
                JOptionPane.showMessageDialog(null,"Added Successfully","New Candidate",JOptionPane.PLAIN_MESSAGE);
                new Add_Candidates();
            }
            catch (Exception d )
            {
                System.out.println(d);
            }
        }

        if (e.getSource() == b) {
                this.dispose();
                new admin();
        }
    }
}
