
package employeemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame  implements ActionListener 
{
    JTextField tusername,tuserpass2;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(40,20,100,30);
        add(lblusername);
        
         tusername=new JTextField();
        tusername.setBounds(150, 20, 150,30 );
        add(tusername);
        
        
        JLabel lbluserpass=new JLabel("Password");
        lbluserpass.setBounds(40,70,100,30);
        add(lbluserpass);
                              
        tuserpass2=new JTextField();
        tuserpass2.setBounds(150, 70, 150,30 );
        add(tuserpass2);
        
        JButton login=new JButton("Login");
        login .setBounds(150,140 ,150,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/second.jpg"));
        Image i2;
        i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);
                            
        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        try{
            String username= tusername.getText();
            String password=tuserpass2.getText();
            Conn c=new Conn();
            

            String query;
            query = "Select * from login  where username= '" + username + "' and password = '" + password + "'";
            //c.s.executeQuery(query);
            ResultSet rs=c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Home();
                
            }
            else{
                JOptionPane.showMessageDialog(null," Invalid Username or Password");
                setVisible(false);
                
               
             
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
       
    }  
        
    
   
   
    public static void main(String args[])
    {
        new Login();
    }

   
}


   

   
    

