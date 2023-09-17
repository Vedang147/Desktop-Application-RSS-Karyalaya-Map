package rss.karyalaya.map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login, signup, password;
    JTextField tfpassword, tfusername;
    
    Login() {
        setSize(900,400);
        setLocation(350,200);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(220, 220, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
        p1.add(image);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);
        
        JLabel uname = new JLabel("Username");
        uname.setBounds(60, 20, 100, 25);
        uname.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(uname);
        
        tfusername = new JTextField();
        tfusername.setBounds(60, 60, 300, 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);
        
        JLabel upassword = new JLabel("Password");
        upassword.setBounds(60, 110, 100, 25);
        upassword.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(upassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(60, 150, 300, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);
        
        login = new JButton("Login");
        login.setBounds(60, 200, 130, 30);
        login.setBackground(new Color(133, 193, 233));
        login.setForeground(Color.BLACK);
        login.addActionListener(this);
        //login.setBorder(new LineBorder(new Color(133, 193, 233)));
        p2.add(login);
        
        signup = new JButton("Signup");
        signup.setBounds(230, 200, 130, 30);
        signup.setBackground(new Color(133, 193, 233));
        signup.setForeground(Color.BLACK);
        signup.addActionListener(this);
        //login.setBorder(new LineBorder(new Color(133, 193, 233)));
        p2.add(signup);
        
        password = new JButton("Forget Password");
        password.setBounds(130, 250, 130, 30);
        password.setBackground(new Color(133, 193, 233));
        password.setForeground(Color.BLACK);
        password.addActionListener(this);
        //login.setBorder(new LineBorder(new Color(133, 193, 233)));
        p2.add(password);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            
                String username = tfusername.getText();
                String pass = tfpassword.getText();
                
                if(username.isEmpty() || pass.isEmpty()){
            JOptionPane.showMessageDialog(null, "Both username and password are mandatory. Please fill in both fields.");
        } else {
                try{
                String query = "select * from account1 where username = '"+username+"' AND password = '"+pass+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Loading(username);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
                }
                
            }catch(Exception e){
                e.printStackTrace();
                }
                }
        }if(ae.getSource() == signup){
            setVisible(false);
            new Signup();
        }else{
            setVisible(false);
            new ForgetPassword();
        }
    }
    
    public static void main(String[] args){
        new Login();
        
    }
}
