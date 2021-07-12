package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CheckOut extends JFrame implements ActionListener {

    Choice c1;
    JTextField t1;
    JButton b1, b2, b3;

    CheckOut(){

        JLabel l1 = new JLabel("Check out");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(100,20,100,30);
        add(l1);

        JLabel l2 = new JLabel("Customer Id");
        l2.setBounds(30,80,100,30);
        add(l2);

        c1 = new Choice();
        c1.setBounds(145,85,185,35);
        add(c1);
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()){
                c1.add(rs.getString("number"));
            }

        }catch (Exception e){

        }

        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30,130,100,30);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(145,135,150,25);
        add(t1);

        b1 = new JButton("Checkout");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        b1.setBounds(30,200,120,30);
        add(b1);

        b2 = new JButton("Back");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        b2.setBounds(170,200,120,30);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(15,15,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b3 = new JButton(i3);
        b3.addActionListener(this);
        b3.setBounds(300,85,20,20);
        add(b3);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l4 = new JLabel(i6);
        l4.setBounds(350,10,400,250);
        add(l4);

        getContentPane().setBackground(Color.WHITE);


        setLayout(null);
        setBounds(372,218,780,320);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1){

            String id = c1.getSelectedItem();
            String room = t1.getText();
            String str = "delete from customer where number ="+id;
            String str1 = "update room set available = 'Available' where room_number = "+ room;
            conn c =new conn();
            try{
                c.s.executeUpdate(str);
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null,"Check-Out Done");
                new Reception().setVisible(true);
                this.setVisible(false);
            }catch (Exception e){
                System.out.println(e);
            }

        }else if (ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);

        }else if (ae.getSource() == b3){
            conn  c = new conn();
            String id = c1.getSelectedItem();
            try{
                ResultSet rs1 = c.s.executeQuery("select * from customer where number =" + id);
                while(rs1.next()){
                    t1.setText(rs1.getString("room"));
                }

            }catch (Exception e){

            }
        }

    }


    public static void main(String[] args) {
        new CheckOut().setVisible(true);
    }


}
