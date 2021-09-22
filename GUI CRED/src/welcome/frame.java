package welcome;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class frame extends JFrame {

	frame(String title)
	{
		super(title);
		//this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setSize(700,700);
		this.setLocationRelativeTo(null); //To center the code
		this.setResizable(false);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon=new ImageIcon("pushkar_apple.png");
		this.setIconImage(icon.getImage());
		this.getContentPane().setBackground(new Color(233, 242, 234));
		JLabel enter=new JLabel();	
		this.setLayout(null);
		enter.setBounds(20,20,650,700);
		this.add(enter);
		enter.setText("Welcome to the Student Management System");		
		enter.setHorizontalAlignment(JLabel.CENTER);
		enter.setVerticalAlignment(JLabel.TOP);
		enter.setFont(new Font("BebasNeue-Bold",Font.BOLD,28));
		
	}
}
