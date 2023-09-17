package rss.karyalaya.map;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JLabel labelusername, labelname;
    JComboBox comboid;
    JTextField tfnumber, tfage, tfregion, tfdistrict, tfaddress, tfphone, tfemail;
    JRadioButton rmale, rfemale; 
    JButton add, back;
    
    AddCustomer(String username){
        setBounds(450, 150, 850, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);
        
        JLabel lblid = new JLabel("Choose Id Type");
        lblid.setBounds(30, 90, 150, 25);
        add(lblid);
        
        comboid = new JComboBox(new String [] {"Adhar Card", "Pan Card","Driving Licence","Passport"});
        comboid.setBounds(220, 90, 150, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
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
        
        rmale = new JRadioButton("Male");
        rmale.setBounds(220, 250, 70, 25);
        rmale.setBackground(Color.WHITE);
        add(rmale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300, 250, 70, 25);
        rfemale.setBackground(Color.WHITE);
        add(rfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        
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
        
        add = new JButton("Add & Goto Karyalaya Map");
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
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Addpersonaldetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 450, 500);
        add(image);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from account1 where username = '"+username+"'");
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String username = labelusername.getText();
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String age = tfage.getText();
            String gender = null;
            if(rmale.isSelected()){
               gender = "Male"; 
            }else{
                gender = "Female";
            }
            String region = tfregion.getText();
            String district = tfdistrict.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            
            try{
                Conn c = new Conn();
                String query = "insert into customer4 values('"+username+"','"+id+"','"+number+"','"+name+"','"+age+"','"+gender+"','"+region+"','"+district+"','"+address+"','"+phone+"','"+email+"')";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Your Details Added Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
                    
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String args []){
        new AddCustomer("Vedu2002");
    }
}
