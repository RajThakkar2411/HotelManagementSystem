package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PickUp extends JFrame implements ActionListener {

    Choice c1;
    JButton b1, b2;
    JTable t1;

    PickUp(){

        JLabel l1 = new JLabel("PICK UP SERVICE ");
        l1.setFont(new Font("tahoma",Font.BOLD,20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(400,30,200,30);
        add(l1);

        JLabel l2 = new JLabel("Type of Car");
        l2.setFont(new Font("tahoma",Font.PLAIN,18));
        l2.setBounds(48,98,100,25);
        add(l2);

        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs= c.s.executeQuery("select * from driver");
            while (rs.next()){
                c1.add(rs.getString("brand"));

            }

        }catch (Exception e){

        }
        c1.setBounds(150,101,200,25);
        add(c1);


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

        JLabel l3 = new JLabel("Name");
        l3.setFont(new Font("tahoma",Font.PLAIN,17));
        l3.setBounds(30,160,145,20);
        add(l3);

        JLabel l4 = new JLabel("Age");
        l4.setFont(new Font("tahoma",Font.PLAIN,17));
        l4.setBounds(200,160,150,20);
        add(l4);

        JLabel l5 = new JLabel("Gender");
        l5.setFont(new Font("tahoma",Font.PLAIN,17));
        l5.setBounds(335,160,150,20);
        add(l5);

        JLabel l6 = new JLabel("Company");
        l6.setFont(new Font("tahoma",Font.PLAIN,17));
        l6.setBounds(460,160,150,20);
        add(l6);

        JLabel l7 = new JLabel("Brand");
        l7.setFont(new Font("tahoma",Font.PLAIN,17));
        l7.setBounds(615,160,150,20);
        add(l7);

        JLabel l8 = new JLabel("Availability");
        l8.setFont(new Font("tahoma",Font.PLAIN,17));
        l8.setBounds(750,160,150,20);
        add(l8);

        JLabel l9 = new JLabel("Location ");
        l9.setFont(new Font("tahoma",Font.PLAIN,17));
        l9.setBounds(890,160,150,20);
        add(l9);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(273,185,1000,610);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1){
            try{
                String brand = (String)c1.getSelectedItem();
                String str = "select * from driver where brand= '"+brand+"'";
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));



            }catch (Exception e){
                System.out.println(e);

            }

        }else if (ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }

    }


    public static void main(String[] args) {
        new PickUp().setVisible(true);
    }

}
