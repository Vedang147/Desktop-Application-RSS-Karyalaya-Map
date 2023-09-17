package rss.karyalaya.map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    
    String username;
    JButton addPersonalDetails, viewPersonalDetails, updatePersonalDetails, deletePersonalDetails, mapDetails;
    Dashboard(String username){
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(255, 165, 0, 255));
        p1.setBounds(0, 0, 1600, 65);
        add(p1);
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/rss_logo.png"));
         Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel icon = new JLabel(i3);
         icon.setBounds(3, 0, 65, 65);
         p1.add(icon);
         
         JLabel heading = new JLabel("Welcome To RSS Karyalaya Map Dashboard");
         heading.setBounds(80, 10, 1000, 40);
         heading.setForeground(Color.WHITE);
         heading.setFont(new Font("Times New Roman", Font.BOLD, 40));
         p1.add(heading);
         
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(255, 165, 0, 255));
        p2.setBounds(0, 65, 300, 900);
        add(p2);


        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0, 30, 300, 50);
        addPersonalDetails.setBackground(new Color(255, 165, 0, 255));
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
        addPersonalDetails.setMargin(new Insets(0, 0, 0, 60));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);
        
        mapDetails = new JButton("Karyalaya Map Details");
        mapDetails.setBounds(0, 90, 300, 50);
        mapDetails.setBackground(new Color(255, 165, 0, 255));
        mapDetails.setForeground(Color.WHITE);
        mapDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
        mapDetails.setMargin(new Insets(0, 0, 0, 45));
        mapDetails.addActionListener(this);
        p2.add(mapDetails);
        
        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0, 150, 300, 50);
        updatePersonalDetails.setBackground(new Color(255, 165, 0, 255));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
        updatePersonalDetails.setMargin(new Insets(0, 0, 0, 35));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);
        
        viewPersonalDetails = new JButton("View Personal Details");
        viewPersonalDetails.setBounds(0, 210, 300, 50);
        viewPersonalDetails.setBackground(new Color(255, 165, 0, 255));
        viewPersonalDetails.setForeground(Color.WHITE);
        viewPersonalDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
        viewPersonalDetails.setMargin(new Insets(0, 0, 0, 60));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);
        
        deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0, 270, 300, 50);
        deletePersonalDetails.setBackground(new Color(255, 165, 0, 255));
        deletePersonalDetails.setForeground(Color.WHITE);
        deletePersonalDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
        deletePersonalDetails.setMargin(new Insets(0, 0, 0, 35));
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/Dashboard_rss.png"));
        Image i5 = i4.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0, 0, 1800, 900);
        add(image);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addPersonalDetails){
            new AddCustomer(username);
        }else if(ae.getSource() == mapDetails){
            new Karyalayamap();
        }else if(ae.getSource() == viewPersonalDetails){
            new ViewCustomer(username);
        }else if(ae.getSource() == updatePersonalDetails){
            new UpdateCustomer(username);
        }else if(ae.getSource() == deletePersonalDetails){
            new DeleteDetails(username);
        }
    } 
    public static void main(String[] args){
        new Dashboard("");
    }
}

