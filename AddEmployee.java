package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class AddEmployee extends JFrame implements ActionListener{


    JTextField t1,t2,t3,t4,t5,t6;
    JComboBox c1;
    JRadioButton r1,r2;
    JButton b1;


     AddEmployee() {
         //getContentPane().setForeground(Color.BLUE);
         //getContentPane().setBackground(Color.WHITE);
         //setTitle("ADD EMPLOYEE DETAILS");

         // setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
         //setSize(778, 486);
         //getContentPane().setLayout(null);

         JLabel name = new JLabel("NAME");
         name.setFont(new Font("Tahoma", Font.BOLD, 17));
         name.setBounds(60, 30, 120, 30);
         add(name);

         t1 = new JTextField();
         t1.setBounds(200, 30, 150, 30);
         add(t1);


         JLabel age = new JLabel("AGE");
         age.setFont(new Font("Tahoma", Font.BOLD, 17));
         age.setBounds(60, 80, 120, 30);
         add(age);

         t2 = new JTextField();
         t2.setBounds(200, 80, 150, 30);
         add(t2);

         JLabel gender = new JLabel("GENDER");
         gender.setFont(new Font("Tahoma", Font.BOLD, 17));
         gender.setBounds(60, 130, 150, 27);
         add(gender);

         r1 = new JRadioButton("MALE");
         r1.setBackground(Color.WHITE);
         r1.setFont(new Font("Tahoma", Font.BOLD, 14));
         r1.setBounds(200, 130, 70, 30);
         add(r1);

         r2 = new JRadioButton("FEMALE");
         r2.setBackground(Color.WHITE);
         r2.setFont(new Font("Tahoma", Font.BOLD, 14));
         r2.setBounds(271, 130, 85, 30);
         add(r2);


         JLabel job = new JLabel("JOB");
         job.setFont(new Font("Tahoma", Font.BOLD, 17));
         job.setBounds(60, 180, 150, 27);
         add(job);

         String[] str = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Waiter/Waitress", "Manager", "Accountant", "Chef"};
         c1 = new JComboBox(str);
         c1.setBackground(Color.WHITE);
         c1.setBounds(200, 180, 150, 30);
         add(c1);

         JLabel salary = new JLabel("SALARY");
         salary.setFont(new Font("Tahoma", Font.BOLD, 17));
         salary.setBounds(60, 230, 120, 30);
         add(salary);

         t3 = new JTextField();
         t3.setBounds(200, 230, 150, 30);
         add(t3);

         JLabel phone = new JLabel("PHONE");
         phone.setFont(new Font("Tahoma", Font.BOLD, 17));
         phone.setBounds(60, 280, 120, 30);
         add(phone);

         t4 = new JTextField();
         t4.setBounds(200, 280, 150, 30);
         add(t4);

         JLabel aadhar = new JLabel("AADHAR");
         aadhar.setFont(new Font("Tahoma", Font.BOLD, 17));
         aadhar.setBounds(60, 330, 120, 40);
         add(aadhar);

         t5 = new JTextField();
         t5.setBounds(200, 330, 150, 30);
         add(t5);


         JLabel email = new JLabel("EMAIL");
         email.setFont(new Font("Tahoma", Font.BOLD, 17));
         email.setBounds(60, 380, 150, 30);
         add(email);

         t6 = new JTextField();
         t6.setBounds(200, 380, 150, 30);
         add(t6);


         b1 = new JButton("SAVE");
         b1.setBounds(200, 420, 150, 30);
         b1.setBackground(Color.BLACK);
         b1.setForeground(Color.WHITE);
         b1.addActionListener(this);
         add(b1);



         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tenth.jpg"));
         Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(370, 80, 480, 410);
         add(image);

         JLabel l2 = new JLabel("ADD EMPLOYEE DETAILS");
         l2.setForeground(Color.RED);
         l2.setFont(new Font("Tahoma", Font.BOLD, 31));
         l2.setBounds(400, 30, 400, 30);
         add(l2);

         getContentPane().setBackground(Color.WHITE);


         setLayout(null);
         setBounds(345, 200, 850, 540);
         setVisible(true);


     }

             public void actionPerformed(ActionEvent ae) {

                 String name = t1.getText();
                 String age = t2.getText();
                 String salary = t3.getText();
                 String phone = t4.getText();
                 String aadhar = t5.getText();
                 String email = t6.getText();

                 String gender = null;

                 if (r1.isSelected()) {
                     gender = "male";

                 } else if (r2.isSelected()) {
                     gender = "female";
                 }


                 String job = (String) c1.getSelectedItem();

                 conn c = new conn();
                 String str = "INSERT INTO employee values( '" + name + "', '" + age + "', '" + gender + "','" + job + "', '" + salary + "', '" + phone + "','" + aadhar + "', '" + email + "')";

                 try {


                     c.s.executeUpdate(str);
                     JOptionPane.showMessageDialog(null, "Employee Added");
                     setVisible(false);

                 } catch (Exception e) {
                     e.printStackTrace();
                 }


             }

    public static void main(String[] args){
        new AddEmployee();
    }

}