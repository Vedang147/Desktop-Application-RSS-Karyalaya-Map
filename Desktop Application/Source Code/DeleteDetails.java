package rss.karyalaya.map;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class DeleteDetails extends JFrame implements ActionListener{
    JButton back;
    String username;
    DeleteDetails(String username){
        this.username = username;
        setBounds(450, 180, 870, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);
        
        JLabel labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);
        
        JLabel lblid = new JLabel("Id Type");
        lblid.setBounds(30, 110, 150, 25);
        add(lblid);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(220, 110, 150, 25);
        add(labelid);
        
        JLabel lblnumber = new JLabel("Id Number");
        lblnumber.setBounds(30, 170, 150, 25);
        add(lblnumber);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220, 170, 150, 25);
        add(labelnumber);
        
        JLabel lblname = new JLabel("Your Name");
        lblname.setBounds(30, 230, 150, 25);
        add(lblname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(220, 230, 150, 25);
        add(labelname);
        
        JLabel lblage = new JLabel("Age");
        lblage.setBounds(30, 290, 150, 25);
        add(lblage);
        
        JLabel labelage = new JLabel();
        labelage.setBounds(220, 290, 150, 25);
        add(labelage);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 350, 150, 25);
        add(lblgender);
        
        JLabel labelgender = new JLabel();
        labelgender.setBounds(220, 350, 150, 25);
        add(labelgender);
        
        JLabel lblregion = new JLabel("Region");
        lblregion.setBounds(500, 50, 150, 25);
        add(lblregion);
        
        JLabel labelregion = new JLabel();
        labelregion.setBounds(690, 50, 150, 25);
        add(labelregion);
        
        JLabel lbldistrict = new JLabel("District");
        lbldistrict.setBounds(500, 110, 150, 25);
        add(lbldistrict);
        
        JLabel labeldistrict = new JLabel();
        labeldistrict.setBounds(690, 110, 150, 25);
        add(labeldistrict);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(500, 170, 150, 25);
        add(lbladdress);
        
        JLabel labeladdress = new JLabel();
        labeladdress.setBounds(690, 170, 150, 25);
        add(labeladdress);
        
        JLabel lblphone = new JLabel("Mobile Number");
        lblphone.setBounds(500, 230, 150, 25);
        add(lblphone);
        
        JLabel labelphone = new JLabel();
        labelphone.setBounds(690, 230, 150, 25);
        add(labelphone);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(500, 290, 150, 25);
        add(lblemail);
        
        JLabel labelemail = new JLabel();
        labelemail.setBounds(690, 290, 150, 25);
        add(labelemail);
        
        back = new JButton("Delete");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350,400,100,25);
        back.addActionListener(this);
        add(back);
     
        try{
            Conn conn = new Conn();
            String query = "select * from customer4 where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelage.setText(rs.getString("age"));
                labelgender.setText(rs.getString("gender"));
                labelregion.setText(rs.getString("region"));
                labeldistrict.setText(rs.getString("district"));
                labeladdress.setText(rs.getString("address"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
  
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
           Conn c = new Conn();
           c.s.executeUpdate("delete from account1 where username = '"+username+"'");
           c.s.executeUpdate("delete from customer4 where username = '"+username+"'");
           
           JOptionPane.showMessageDialog(null, "Your Personal Details Deleted Successfully");
           System.exit(0);
        }catch(Exception e){    
           e.printStackTrace();
        }
    } 
    public static void main(String args[]){
        new DeleteDetails("Vedu2002");
    }
}
