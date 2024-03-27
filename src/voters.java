
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class voters extends JFrame implements ActionListener
{
    String[] arr ={"Select Election"};
    int i;
    JTable t;
    JButton b,b2;
    JLabel l;
    JScrollPane s;
    JComboBox cb;
    voters()
    {

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
                java.util.List<String> i = new ArrayList<String>(Arrays.asList(arr));
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
        cb.setBounds(20,60,250,25);




        l= new JLabel(" Voters");
        l.setBounds(10,20,200,30);
        l.setForeground(Color.black);
        l.setVisible(true);
        l.setFont(new Font("Arial",Font.BOLD,25));

        b= new JButton("Back");
        b.addActionListener(this);
        b.setForeground(Color.white);
        b.setBackground(new Color(36, 63, 150, 255));
        b.setFont(new Font("Serial",Font.BOLD,25));
        b.setFocusable(false);
        b.setBounds(380,5,100,30);

        b2= new JButton("View");
        b2.addActionListener(this);
        b2.setForeground(Color.white);
        b2.setBackground(new Color(36, 63, 150, 255));
        b2.setFont(new Font("Serial",Font.BOLD,15));
        b2.setFocusable(false);
        b2.setBounds(380,60,100,20);

        this.add(b2);
        this.add(b);
        this.add(l);
        this.add(cb);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b2)
        {
            t = new JTable();
            t.setRowHeight( t.getRowHeight()+5);
            Object[] columns ={"SR.NO","Name","Roll NO","voted"};
            DefaultTableModel m = new DefaultTableModel(){

                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };
            m.setColumnIdentifiers(columns);
            t.setModel(m);

            String s3 = cb.getSelectedItem().toString();

            Object[] row = new Object[4];
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/votingsystem?characterEncoding=latin1", "root", "root");
                Statement st = c.createStatement();
                String q="select * from students";
                ResultSet rs=st.executeQuery(q);

                i=1;
                while(rs.next())
                {
                    String s=rs.getString("Roll_No");
                    String s1=rs.getString("Student_Name");
                    int s2=rs.getInt(s3);

                    System.out.println(s2);
                    row[0] = i;
                    i++;
                    row[1]=s1;
                    row[2]=s;
                    if (0==s2)
                    {
                        row[3]="No";
                    }
                    else
                    {
                        row[3]="Yes";
                    }
                    m.addRow(row);
                }
            }
            catch (Exception d )
            {
                System.out.println(d);
            }

            s= new JScrollPane(t);
            s.setBounds(20,100,440,320);
            this.add(s);
        }

        if (e.getSource()==b)
        {
            this.dispose();
            new admin();
        }
    }
}
