package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener {

    JComboBox c1;
    JCheckBox c2;
    JButton b1, b2;
    JTable t1;

    SearchRoom(){

        JLabel l1 = new JLabel("SEARCH FOR ROOM");
        l1.setFont(new Font("tahoma",Font.BOLD,20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(400,30,200,30);
        add(l1);

        JLabel l2 = new JLabel("Room Bed Type");
        l2.setFont(new Font("tahoma",Font.PLAIN,18));
        l2.setBounds(50,100,150,25);
        add(l2);

        c1 = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        c1.setBounds(185,100,150,25);
        c1.setBackground(Color.WHITE);
        add(c1);

        c2 = new JCheckBox("Display-Available Only");
        c2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        c2.setBounds(650,100,230,28);
        c2.setBackground(Color.WHITE);
        add(c2);

        t1 = new JTable();
        t1.setBounds(0,200,1000,300);
        add(t1);

        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(300,520,120,30);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(500,520,120,30);
        add(b2);

        JLabel l3 = new JLabel("Room Number");
        l3.setFont(new Font("tahoma",Font.PLAIN,18));
        l3.setBounds(50,160,150,20);
        add(l3);

        JLabel l4 = new JLabel("Availability");
        l4.setFont(new Font("tahoma",Font.PLAIN,18));
        l4.setBounds(267,160,150,20);
        add(l4);

        JLabel l5 = new JLabel("Cleaning Status");
        l5.setFont(new Font("tahoma",Font.PLAIN,18));
        l5.setBounds(445,160,150,20);
        add(l5);

        JLabel l6 = new JLabel("Price");
        l6.setFont(new Font("tahoma",Font.PLAIN,18));
        l6.setBounds(677,160,150,20);
        add(l6);

        JLabel l7 = new JLabel("Bed Type");
        l7.setFont(new Font("tahoma",Font.PLAIN,18));
        l7.setBounds(860,160,150,20);
        add(l7);


        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(270,185,1000,610);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1){
            try{
                String type = (String)c1.getSelectedItem();
                String str = "select * from room where bed_type= '"+type+"'";
                String str1 =  "select * from room where  available ='Available' AND bed_type ='"+type+"'";
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));

                if (c2.isSelected()){
                    ResultSet rs2 = c.s.executeQuery(str1);
                    t1.setModel(DbUtils.resultSetToTableModel(rs2));
                }


            }catch (Exception e){
                System.out.println(e);

            }

        }else if (ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }

    }


    public static void main(String[] args) {
        new SearchRoom().setVisible(true);
    }

}
