package welcome;

import mvc.Register;
import mvc.user;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class index implements ActionListener{
	 frame main;
	 static String[] genderlist= {"Male","Female","Dont prefer to say"};
	 static String[] branchlist= {"Mechanical","Electrical","Computer Science","Electronics"};
    String[] gender={"Male","Female"};
    JLabel regist=new JLabel("Register");
    JLabel nameLabel=new JLabel("Name");
    JLabel genderLabel=new JLabel("Gender"); 
    JLabel number=new JLabel("Mobile Number"); 
    JLabel branch=new JLabel("Branch");  
    JTextField nameTextField=new JTextField();
    JTextField numberfield=new JTextField();
    JComboBox genderopt=new JComboBox(genderlist);
    JComboBox bracnhopt=new JComboBox(branchlist); 
    JButton registerButton=new JButton("REGISTER");
    JButton portalButton=new JButton("View Portal");
    
	public static void main(String[] args) {
		index e=new index();
	}
	
	index()
	{
		createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        misc();
	}
	public void createWindow()
    {
        main=new frame("GUI CRED APP");
    }
	
	
	public void misc()
	{
		
		regist.setFont(new Font("MV Boli",Font.BOLD,23));
		
		
	}
	public void setLocationAndSize()
    {
        regist.setBounds(270,80,100,100);
        
        nameLabel.setBounds(200,170,70,70);
        nameTextField.setBounds(260,190,160,30);
        
        genderLabel.setBounds(185,230,80,70);
        genderopt.setBounds(260,240,170,40);
        
        number.setBounds(160, 315, 150,20);
        numberfield.setBounds(260,310,160,30);
        
        branch.setBounds(200, 370, 50,20);
        bracnhopt.setBounds(260,360,160,40);
        
       
        
       
        registerButton.setBounds(190,480,100,45);
        portalButton.setBounds(390,480,100,45);
        
        
        
        registerButton.addActionListener(this);
        portalButton.addActionListener(this);
        
    }
	public void addComponentsToFrame()
    {
        //Adding components to Frame
		main.add(regist);
        main.add(nameLabel);
        main.add(genderLabel);
        main.add(numberfield);
        main.add(number);
        main.add(nameTextField);
        main.add(genderopt);
        main.add(bracnhopt);
        main.add(branch);
        main.add(registerButton);
        main.add(portalButton);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==registerButton)
		{ 
			if(nameTextField.getText().length()<2  )
		{
            JOptionPane.showMessageDialog(null,"Fill all the data coorectly ");
            System.out.println(nameTextField.getText());

		}
			else if( numberfield.getText().length()< 10)
			{
				JOptionPane.showMessageDialog(null,"Fill all the data coorectly ");
				 System.out.println(numberfield.getText());

			}
		else
		{
			user u=new user(nameTextField.getText(),bracnhopt.getSelectedItem().toString(),numberfield.getText(),genderopt.getSelectedItem().toString());
			Register u1=new Register(u);
            JOptionPane.showMessageDialog(null,"Data Registered Successfully");
		}
		}
		if(e.getSource()==portalButton)
		{
			main.dispose();
			portal p=new portal();
			
		}
		
	}
	
	

}
