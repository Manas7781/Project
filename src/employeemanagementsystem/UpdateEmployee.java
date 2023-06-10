

package employeemanagementsystem;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.sql.*;



public class UpdateEmployee extends JFrame implements ActionListener {
    
    
    
    
    JTextField tfeducation,tname,tfname,tadd,tsal,taadhar,tphone,tdesg,temail;
  
    JButton back,add;
    
    JLabel leid;
    String empId;
    
    public UpdateEmployee(String empId){
        this.empId= empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Update Employee Details");
        heading.setBounds(320,30,500 ,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        JLabel lname=new JLabel("Name");
        lname.setBounds(50,150,150,30);
        lname.setFont(new Font("serif",Font.PLAIN,20));
        add(lname);
        
        JLabel lblname=new JLabel();
        lblname.setBounds(200,150,150,30);
        add(lblname);
        
        JLabel lfname=new JLabel("Fathers Name");
        lfname.setBounds(400,150,150,30);
        lfname.setFont(new Font("serif",Font.PLAIN,20));
        add(lfname);
        
         tfname=new JTextField();
        tfname.setBounds(600,150,150,30);
        add(tfname);
        
        JLabel ldob=new JLabel("Date of Birth");
        ldob.setBounds(50,200,150,30);
        ldob.setFont(new Font("serif",Font.PLAIN,20));
        add(ldob);
        
        
         JLabel lbldob=new JLabel();
        lbldob.setBounds(200,200,150,30);
        add(lbldob);
        
        
        JLabel lsal=new JLabel("Salary");
        lsal.setBounds(400,200,150,30);
        lsal.setFont(new Font("serif",Font.PLAIN,20));
        add(lsal);
        
         tsal=new JTextField();
        tsal.setBounds(600,200,150,30);
        add(tsal);
        
        JLabel ladd=new JLabel("Address");
        ladd.setBounds(50,250,150,30);
        ladd.setFont(new Font("serif",Font.PLAIN,20));
        add(ladd);
        
         tadd=new JTextField();
        tadd.setBounds(200,250,150,30);
        add(tadd);
        
        JLabel lphone=new JLabel("Phone");
        lphone.setBounds(400,250,150,30);
        lphone.setFont(new Font("serif",Font.PLAIN,20));
        add(lphone);
        
        tphone=new JTextField();
        tphone.setBounds(600,250,150,30);
        add(tphone);
        
        JLabel lemail=new JLabel("Email");
        lemail.setBounds(50,300,150,30);
        lemail.setFont(new Font("serif",Font.PLAIN,20));
        add(lemail);
        
         temail=new JTextField();
        temail.setBounds(200,300,150,30);
        add(temail);
        
        JLabel ledu=new JLabel("Highest Education");
        ledu.setBounds(400,300,150,30);
        ledu.setFont(new Font("serif",Font.PLAIN,20));
        add(ledu);
        
        
        
        tfeducation=new JTextField();
        tfeducation.setBackground(Color.WHITE);
        tfeducation.setBounds(600,300,150,30);
        add(tfeducation);
        
        
        
        JLabel ldesg=new JLabel("Designation");
        ldesg.setBounds(50,350,150,30);
        ldesg.setFont(new Font("serif",Font.PLAIN,20));
        add(ldesg);
        
         tdesg=new JTextField();
        tdesg.setBounds(200,350,150,30);
        add(tdesg);
        
        JLabel ladhar=new JLabel("Aadhar No");
        ladhar.setBounds(400,350,150,30);
        ladhar.setFont(new Font("serif",Font.PLAIN,20));
        add(ladhar);
        
         JLabel lblaadhar =new JLabel();
        lblaadhar.setBounds(600,350,150,30);
        add(lblaadhar);
        
        JLabel eid=new JLabel("Employee ID");
        eid.setBounds(50,400,150,30);
        eid.setFont(new Font("serif",Font.PLAIN,20));
        add(eid);
        
       leid=new JLabel();
        leid.setBounds(200,400,150,30);
        leid.setFont(new Font("serif",Font.PLAIN,20));
        add(leid);
        
        try{
            Conn c=new Conn();
            String query="select * from employee where empId ='"+empId+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                tfname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tadd.setText(rs.getString("address"));
                tsal.setText(rs.getString("salary"));
                tphone.setText(rs.getString("phone"));
                temail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                lblaadhar.setText(rs.getString("aadhar"));
                leid.setText(rs.getString("empId"));
                tdesg.setText(rs.getString("designation"));
                 
                
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
         add=new JButton("Update Details");
        add.setBounds(250,500,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
         back=new JButton("Back");
        back.setBounds(450,500,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
    
        
    
        setSize(900,600);
        setLocation(300,50);
        setVisible(true);
        
      
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String fname=tfname.getText();
            String salary=tsal.getText();
            String address=tadd.getText();
           
            String phone=tphone.getText();
             
            String email=temail.getText();
            String education=(String)tfeducation.getText();
            String designation=tdesg.getText();
          
            
           
           try{
               Conn conn=new Conn();

                String query;  
                query = "update  employee set fname='"+fname+"',salary='"+salary+"',address='"+address+"',phone='"+phone+"',email='"+email+"',education='"+education+"',designation='"+designation+"' where empid='"+empId+"'";
                conn.s.executeUpdate(query);    
               JOptionPane.showMessageDialog(null,"Details Updated Successsfully");
               setVisible(false);
               new Home();
           
           
           }
           
           
           catch(Exception e){
               e.printStackTrace();
               
           }
            
        }else{
            setVisible(false);
            new Home();
            
        }
        
    }
    public static void main(String args[])
    {
        new UpdateEmployee("");
        
    }

    
}
