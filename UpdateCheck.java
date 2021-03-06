package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener {

    JButton b1, b2, b3;
    Choice c1;
    JTextField t1, t2, t3, t4, t5;


    UpdateCheck(){

        JLabel l1 = new JLabel("Check-in Details");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 23));
        l1.setForeground(Color.BLUE);
        l1.setBounds(50,30,200,30);
        add(l1);

        JLabel l2 = new JLabel("Customer-Id");
        l2.setBounds(30,80,100,20);
        add(l2);

        c1 = new Choice();
        c1.setBounds(200,80,185,35);
        add(c1);

        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()){
                c1.add(rs.getString("number"));
            }

        }catch (Exception e){
            System.out.println(e);

        }

        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30,120,100,20);
        add(l3);

        t1 =  new JTextField();
        t1.setBounds(200, 120, 150, 25);
        add(t1);

        JLabel l4 = new JLabel("Name");
        l4.setBounds(30,160,100,20);
        add(l4);

        t2 =  new JTextField();
        t2.setBounds(200, 160, 150, 25);
        add(t2);

        JLabel l5 = new JLabel("Check-In");
        l5.setBounds(30,200,100,20);
        add(l5);

        t3 =  new JTextField();
        t3.setBounds(200, 200, 150, 25);
        add(t3);

        JLabel l6 = new JLabel("Amount Paid");
        l6.setBounds(30,240,100,20);
        add(l6);

        t4 =  new JTextField();
        t4.setBounds(200, 240, 150, 25);
        add(t4);

        JLabel l7 = new JLabel("Pending Amount");
        l7.setBounds(30,280,100,20);
        add(l7);

        t5 =  new JTextField();
        t5.setBounds(200, 280, 150, 25);
        add(t5);

        b1 = new JButton("Check");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(30,340,100,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Update");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(150,340,100,30);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Back");
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);
        b3.setBounds(270,340,100,30);
        b3.addActionListener(this);
        add(b3);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/nine.jpg"));
        JLabel l8 = new JLabel(i1);
        l8.setBounds(400, 50, 500, 300);
        add(l8);

        getContentPane().setBackground(Color.WHITE);


        setLayout(null);
        setBounds(280,185,950,470);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == b1){

            try {
                String room = null;
                String deposit = null;
                String price = null;
                conn c = new conn();
                String id = c1.getSelectedItem();
                String str = "select * from customer where number ="+ id;
                ResultSet rs1 = c.s.executeQuery(str);
                while(rs1.next()){
                    t1.setText(rs1.getString("room"));
                    t2.setText(rs1.getString("name"));
                    t3.setText(rs1.getString("status"));
                    t4.setText(rs1.getString("deposit"));
                    room = rs1.getString("room");
                    deposit = rs1.getString("deposit");
                }
                ResultSet rs2 = c.s.executeQuery("select * from room where room_number =" + room);
                while (rs2.next()){
                    price = rs2.getString("price");
                    int amountPending = Integer.parseInt(price) - Integer.parseInt(deposit);
                    t5.setText(Integer.toString(amountPending));
                    
                }

            }catch (Exception e){
                System.out.println(e);

            }

        }else if (ae.getSource() == b2){

            try{
                conn c = new conn();

                String room = t1.getText();
                String name = t2.getText();
                //String checkIn =  t3.getText();
                String amountPaid =  t4.getText();
                String pendingAmount =  t5.getText();

                // String room_number = null;
                String str = "update customer set name ='"+name+"',deposit ='"+amountPaid+"' where room ='"+room+"'";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Check-In Status Updated Successfully");
                new Reception().setVisible(true);
                this.setVisible(false);
            }catch (Exception e){
                System.out.println(e);
            }

        }else if (ae.getSource() == b3){
            new Reception().setVisible(true);
            this.setVisible(false);

        }

    }



    public static void main(String[] args) {
        new UpdateCheck().setVisible(true);
    }



}
