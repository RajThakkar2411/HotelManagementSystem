package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class  Dashboard extends JFrame implements ActionListener {

    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;

    Dashboard(){   // All frame coding inside constructor
        mb = new JMenuBar();
        add(mb);
        mb.setBounds(0,0,1950,35);

        m1 = new JMenu("Hotel Management");
        mb.add(m1);
        m1.setForeground(Color.RED);

        m2 = new JMenu("Admin");
        mb.add(m2);
        m2.setForeground(Color.BLUE);

        i1 = new JMenuItem("Reception");
        i1.addActionListener(this);
        m1.add(i1);

        i2 = new JMenuItem("Add Employee");
        i2.addActionListener(this);
        m2.add(i2);

        i3 = new JMenuItem("Add Rooms");
        i3.addActionListener(this);
        m2.add(i3);

        i4 = new JMenuItem("Add Drivers");
        i4.addActionListener(this);
        m2.add(i4);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Management/System/icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1= new JLabel(i3);
        l1.setBounds(0,0,1950,1000);
        add(l1);

        JLabel l2 = new JLabel("THE TAJ GROUP WELCOMES YOU!");
        l2.setBounds(400, 80,1000,50);
        l2.setForeground(Color.white);
        l2.setFont(new Font("Tahoma", Font.PLAIN,46));
        l1.add(l2);

        setLayout(null);
        setBounds(0 ,0,1950,1000);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getActionCommand().equals("Reception")){
            new Reception().setVisible(true);

        }else if (ae.getActionCommand().equals("Add Employee")){
            new AddEmployee().setVisible(true);
        }else if (ae.getActionCommand().equals("Add Rooms")){
            new AddRooms().setVisible(true);
        }else if (ae.getActionCommand().equals("Add Drivers")){
            new AddDriver().setVisible(true);
        }
    }

    public static void main(String[] args){
        new Dashboard().setVisible(true);
    }
}
