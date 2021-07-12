package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame implements  ActionListener{


    Choice c1;
    JTextField t1, t2, t3;
    JButton b1, b2, b3;

   UpdateRoom()  {

       JLabel l1 = new JLabel("Update Room Status");
       l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
       l1.setForeground(Color.BLUE);
       l1.setBounds(80, 13, 206, 34);
       add(l1);

       JLabel l2 = new JLabel("Guest ID:");
       l2.setBounds(27, 87, 90, 14);
       add(l2);

       c1 = new Choice();
       try {
           conn c = new conn();
           ResultSet rs = c.s.executeQuery("select * from customer");
           while (rs.next()) {
               c1.add(rs.getString("number"));
           }
       } catch (Exception e) {
       }
       c1.setBounds(160, 84, 175, 30);
       c1.setBackground(Color.WHITE);
       add(c1);

       JLabel l3 = new JLabel("Room Number:");
       l3.setBounds(27, 133, 100, 14);
       add(l3);

       t1 = new JTextField();
       t1.setBounds(160, 130, 140, 20);
       add(t1);

       JLabel l4 = new JLabel("Availability:");
       l4.setBounds(27, 187, 90, 14);
       add(l4);

       t2 = new JTextField();
       t2.setBounds(160, 184, 140, 20);
       add(t2);

       JLabel l5 = new JLabel("Clean Status:");
       l5.setBounds(27, 240, 90, 14);
       add(l5);

       t3 = new JTextField();
       t3.setBounds(160, 237, 140, 20);
       add(t3);

       b1 = new JButton("Check");
       b1.setForeground(Color.WHITE);
       b1.setBackground(Color.BLACK);
       b1.addActionListener(this);
       b1.setBounds(120, 315, 89, 23);
       add(b1);

       b2 = new JButton("Update");
       b2.setForeground(Color.WHITE);
       b2.setBackground(Color.BLACK);
       b2.addActionListener(this);
       b2.setBounds(60, 355, 89, 23);
       add(b2);

       b3 = new JButton("Back");
       b3.setForeground(Color.WHITE);
       b3.setBackground(Color.BLACK);
       b3.addActionListener(this);
       b3.setBounds(180, 355, 89, 23);
       add(b3);

       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/seventh.jpg"));
       Image i3 = i1.getImage().getScaledInstance(550, 250, Image.SCALE_DEFAULT);
       ImageIcon i2 = new ImageIcon(i3);
       JLabel l6 = new JLabel(i2);
       l6.setBounds(300, 20, 600, 400);
       add(l6);

       getContentPane().setBackground(Color.WHITE);

       setLayout(null);
       setBounds(305,190,930,450);
       setVisible(true);
   }

            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == b1){

                    try {
                        String room = null;
                        String s1 = c1.getSelectedItem();
                        conn c = new conn();
                        ResultSet rs1 = c.s.executeQuery("select * from customer where number =" + s1);
                        while (rs1.next()){
                            t1.setText(rs1.getString("room"));
                            room =rs1.getString("room");
                        }
                        ResultSet rs2 = c.s.executeQuery("select * from room where room_number = " + room);
                        while (rs2.next()){
                            t2.setText(rs2.getString("available"));
                            t3.setText(rs2.getString("status"));
                        }


                    }catch (Exception e){

                    }

                }else if (ae.getSource() == b2){
                    try{
                        conn c = new conn();
                        String room = t1.getText();
                        String available = t2.getText();
                        String status =  t3.getText();

                       // String room_number = null;
                        String str = "update room set available ='"+available+"', status ='"+status+"' where room_number ='"+room+"'";
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null,"Room Updated Successfully");
                        new Reception().setVisible(true);
                        this.setVisible(false);
                    }catch (Exception e){


                    }


                }else if (ae.getSource() == b3){
                    new Reception().setVisible(true);
                     this.setVisible(false);
                }

            }

    public static void main(String[] args)  {
        new UpdateRoom().setVisible(true);
    }
}
