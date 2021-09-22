package welcome;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import mvc.user;
import mvc.update;

public class edit extends JFrame implements ActionListener {
	    static String[] genderlist= {"Male","Female","Dont prefer to say"};
	    static String[] branchlist= {"Mechnanical","electrical","computer science","electronics"};
	    JLabel nameLabel=new JLabel("Name");
	    JLabel genderLabel=new JLabel("Gender"); 
	    JLabel number=new JLabel("Mobile Number"); 
	    JLabel branch=new JLabel("Branch");  
	    JTextField nameTextField=new JTextField();
	    JTextField numberfield=new JTextField();
	    JComboBox genderopt=new JComboBox(genderlist);
	    JComboBox bracnhopt=new JComboBox(branchlist); 
	JButton done=new JButton("UPDATE");
	int userid;
	frame one;
	edit(frame one,int id)
	{
		
		super("Edit Details");
		this.one=one;
		userid=id;
	createWindow();
    setLocationAndSize();
    addComponentsToFrame();
	}

	private void addComponentsToFrame() {
		    this.add(nameLabel);
		    this.add(genderLabel);
		    this.add(numberfield);
		    this.add(number);
	        this.add(nameTextField);
	        this.add(genderopt);
	        this.add(bracnhopt);
	        this.add(branch);
	        this.add(done);
	}

	private void setLocationAndSize() {
		nameLabel.setBounds(100,10,70,70);
        nameTextField.setBounds(160,30,140,30);
        
        genderLabel.setBounds(90,70,80,70);
        genderopt.setBounds(150,80,150,50);
        
        number.setBounds(50, 150, 140,20);
        numberfield.setBounds(150,150,150,30);
        
        branch.setBounds(90, 210, 50,20);
        bracnhopt.setBounds(150,200,130,53);
        
        done.setBounds(150, 300, 100, 30);
		done.addActionListener(this);
	}

	private void createWindow() {
		// TODO Auto-generated method stub
		
		this.setVisible(true);
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon=new ImageIcon("pushkar_apple.png");
		this.setIconImage(icon.getImage());
		this.getContentPane().setBackground(new Color(233, 242, 234));
		JLabel enter=new JLabel();	
		this.setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==done)
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
				update u1=new update(u,this.userid);
	            JOptionPane.showMessageDialog(null,"Data Updated Successfully");
	            this.dispose();
	            one.dispose();
	            portal p1=new portal();
	           
			}
			}
		}
		
	}

