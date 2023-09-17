package rss.karyalaya.map;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCustomer extends JFrame implements ActionListener{
    
    JLabel labelusername, labelname;
    JComboBox comboid;
    JTextField tfnumber, tfage, tfregion, tfdistrict, tfaddress, tfphone, tfemail, tfid, tfgender;
    JRadioButton rmale, rfemale; 
    JButton add, back;
    
    UpdateCustomer(String username){
        setBounds(450, 150, 850, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("UPDATE PERSONAL DETAILS");
        text.setBounds(50, 0, 300, 25);
        text.setFont(new Font("Times New Roman",Font.BOLD, 20));
        add(text);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);
        
        JLabel lblid = new JLabel("Choose Id Type");
        lblid.setBounds(30, 90, 150, 25);
        add(lblid);
        
        tfid = new JTextField();
        tfid.setBounds(220, 90, 150, 25);
        add(tfid);
        
        JLabel lblnumber = new JLabel("Id Number");
        lblnumber.setBounds(30, 130, 150, 25);
        add(lblnumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(220, 130, 150, 25);
        add(tfnumber);
        
        JLabel lblname = new JLabel("Your-Name");
        lblname.setBounds(30, 170, 150, 25);
        add(lblname);
        
        labelname = new JLabel();
        labelname.setBounds(220, 170, 150, 25);
        add(labelname);
        add(labelname);
        
        JLabel lblage = new JLabel("Age");
        lblage.setBounds(30, 210, 150, 25);
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(220, 210, 150, 25);
        add(tfage);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 250, 150, 25);
        add(lblgender);
        
        tfgender = new JTextField();
        tfgender.setBounds(220, 250, 150, 25);
        add(tfgender);
        
        JLabel lblregion = new JLabel("Region");
        lblregion.setBounds(30, 290, 150, 25);
        add(lblregion);
        
        tfregion = new JTextField();
        tfregion.setBounds(220, 290, 150, 25);
        add(tfregion);
        
        JLabel lbldistrict = new JLabel("District");
        lbldistrict.setBounds(30, 330, 150, 25);
        add(lbldistrict);
        
        tfdistrict = new JTextField();
        tfdistrict.setBounds(220, 330, 150, 25);
        add(tfdistrict);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30, 370, 150, 25);
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220, 370, 150, 25);
        add(tfaddress);
        
        JLabel lblphone = new JLabel("Mobile Number");
        lblphone.setBounds(30, 410, 150, 25);
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220, 410, 150, 25);
        add(tfphone);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(30, 450, 150, 25);
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(220, 450, 150, 25);
        add(tfemail);
        
        add = new JButton("Update");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(30, 490, 200, 25);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270, 490, 100, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Updatepersonaldetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 450, 500);
        add(image);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer4 where username = '"+username+"'");
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfage.setText(rs.getString("age"));
                tfgender.setText(rs.getString("gender"));
                tfregion.setText(rs.getString("region"));
                tfdistrict.setText(rs.getString("district"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String username = labelusername.getText();
            String id = tfid.getText();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String age = tfage.getText();
            String gender = tfgender.getText();
            String region = tfregion.getText();
            String district = tfdistrict.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            
            try{
                Conn c = new Conn();
                String query = "update customer4 set username = '"+username+"',id = '"+id+"',number = '"+number+"',name = '"+name+"',age = '"+age+"',gender = '"+gender+"',region = '"+region+"',district = '"+district+"',address = '"+address+"',phone = '"+phone+"',email = '"+email+"'";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Your Details Updated Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
                    
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String args []){
        new UpdateCustomer("Vedu2002");
    }
}
