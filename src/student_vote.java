import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public  class student_vote extends JFrame implements ActionListener {
    ImageIcon icon;
    Image image;
    int i = 1;
    String a;
    String s1, s2,s3;
    JTable t;
    JButton b, b1;
    JLabel l, l1;
    JScrollPane s;

    student_vote() {


        l = new JLabel(" CANDIDATES");
        l.setBounds(10, 20, 200, 30);
        l.setForeground(Color.black);
        l.setVisible(true);
        l.setFont(new Font("Arial", Font.BOLD, 25));

        b1 = new JButton("Submit");
        b1.addActionListener(this);
        b1.setForeground(Color.white);
        b1.setBackground(new Color(36, 63, 150, 255));
        b1.setFont(new Font("Serial", Font.BOLD, 20));
        b1.setFocusable(false);
        b1.setBounds(170, 400, 140, 30);

        b = new JButton("Back");
        b.addActionListener(this);
        b.setForeground(Color.white);
        b.setBackground(new Color(36, 63, 150, 255));
        b.setFont(new Font("Serial", Font.BOLD, 25));
        b.setFocusable(false);
        b.setBounds(380, 5, 100, 30);

        t = new JTable();
        t.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent evt)
            {
                tMouseClicked(evt);
            }
        });
        t.setRowHeight(t.getRowHeight() + 120);
        Object[] columns = {"SR.NO", "Name", "Image", "Field"};
        DefaultTableModel m = new DefaultTableModel(){

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        m.setColumnIdentifiers(columns);
        t.setModel(m);
        t.getColumn("Image").setCellRenderer(new LabelRenderer());


        Object[] row = new Object[4];

        a = student.cb.getSelectedItem().toString();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/votingsystem?characterEncoding=latin1", "root", "root");
            Statement st = c.createStatement();
            String q = "select * from "+ a;
            ResultSet rs = st.executeQuery(q);

            while (rs.next()) {
                s1 = rs.getString("candidate_name");
                s2 = rs.getString("candidate_field");

                InputStream binaryStream = rs.getBinaryStream(7);
                BufferedImage someImage = ImageIO.read(binaryStream);
                icon = new ImageIcon(someImage);
                image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

                row[0] = i;
                row[1] = s1;
                l1 = new JLabel();
                l1.setIcon(new ImageIcon(image));
                row[2] = l1;
                row[3] = s2;
                m.addRow(row);
                i++;
            }
        } catch (Exception d) {
            System.out.println(d);
        }


        s = new JScrollPane(t);
        s.setBounds(20, 90, 440, 300);


        this.add(s);
        this.add(b);
        this.add(b1);
        this.add(l);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    class LabelRenderer implements TableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return (Component) value;
        }
    }

    private void tMouseClicked(MouseEvent evt) {
        try {

            final int row = t.getSelectedRow();
            final String valueInCell = (String) t.getValueAt(row, 1);
            s3 = valueInCell;

        }
        catch (Exception f)
        {
            System.out.println(f);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == b) {
            this.dispose();
        }
        if (e.getSource() == b1)
        {
            if(t.getSelectionModel().isSelectionEmpty())
            {
                JOptionPane.showMessageDialog(null,"plzz select");
            }
            else
            {
                try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/votingsystem?characterEncoding=latin1", "root", "root");
                    Statement st = c.createStatement();
                    String q = " UPDATE `votingsystem`.`students` SET "+ a +"=1 WHERE (`Roll_No` = '" + login.t.getText() + "');";
                    st.executeUpdate(q);

                    JOptionPane.showMessageDialog(null,"your vote recorded");

                    String q1="UPDATE "+ a +"  SET candidate_votes = candidate_votes + 1 WHERE candidate_name = '" + s3 +"'";
                    st.executeUpdate(q1);

                    JOptionPane.showMessageDialog(null,"u voted "+s3);
                }
                catch (Exception d )
                {
                    System.out.println(d);
                }
            }
            this.dispose();
        }
    }
}

