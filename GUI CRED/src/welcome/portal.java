package welcome;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import mvc.portalfunctions;
import mvc.user;

public class portal implements ActionListener, MouseListener {

	JButton back;
	frame one;
	JTable j;
	static JLabel instructions;
	static JLabel name;
	static JLabel branch;
	static JLabel id;
	static JLabel gender;
	static JLabel number;
	static JButton edit;
	static JButton delete;
	JScrollPane pane;
	JPanel panel ;
	 static int userid=-1;
	 Vector<Vector<String>> cache ;
	portal()
	{
		 one=new frame("Welcome to student portal");
		
		 back=new JButton("Back");
		one.add(back);
		back.setBounds(435, 500, 130, 70);	
		
		back.addActionListener(this);
		
	
		
		getdata();
		setLabel();
		setdata();
		createLabel();
	
		
		
		
		
		
	}
	private void setdata() {
		one.add(instructions);
		one.add(name);
		one.add(branch);
		one.add(gender);
		one.add(id);
		one.add(number);
		one.add(edit);
		one.add(delete);
		
	}
	private void createLabel() {
		instructions.setBounds(10, 30, 450, 100);
		name.setBounds(155,70 ,500, 100);
		branch.setBounds(550, 70, 500, 100);
		id.setBounds(23,70 ,500, 100);
		gender.setBounds(285, 70, 500,100);
		number.setBounds(415, 70, 500, 100);
		edit.setBounds(100,500,130,70);
		delete.setBounds(270,500,130,70);
		
		edit.addActionListener(this);
		delete.addActionListener(this);
		
		
		
	}
	private void setLabel() {
		 instructions=new JLabel("Select student data to perform any kind of operation");
		 name=new JLabel("NAME");
		 branch=new JLabel("BRANCH");
		 id=new JLabel("STUDENT ID");
		 gender=new JLabel("GENDER");
		 number=new JLabel("PH. NUMBER");
		 edit=new JButton("UPDATE");
		 delete=new JButton("DELETE");
		
	}
	void getdata()
	{
		portalfunctions p=new portalfunctions();
       ResultSet rs=p.getdata();
       try {
		putdata(rs);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	private void putdata(ResultSet rs) throws SQLException {
		java.sql.ResultSetMetaData meta = rs.getMetaData();
		System.out.println();
		int col=meta.getColumnCount();
		
		 cache =new Vector<>();
		
		
		Vector<String> heading=new Vector<>();
		
		for(int i=1;i<=col;i++)
			heading.add(meta.getColumnName(i));
		
		
		
		while(rs.next())
		{
			Vector<String> temp=new Vector<>();
			temp.add(rs.getInt(1)+"");
			temp.add(rs.getString(2));
			temp.add(rs.getString(3));
			temp.add(rs.getString(4));
			temp.add(rs.getString(5));
			cache.add(temp);
		}
		
		j=new JTable(cache,heading);
		
		//j.setBounds(20,140,950,300);
		   JScrollPane scrollPane = new JScrollPane(j,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	        scrollPane.setVisible(true);
	        j.setPreferredScrollableViewportSize(new Dimension(630,315));
	        panel = new JPanel();
	        j.setFocusable(false);

	        j.addMouseListener(this);
	        j.setCellSelectionEnabled(false);
	        j.setRowSelectionAllowed(true);
	      

	        panel.add(scrollPane);
	        panel.setBounds(10,140,650,350);
	        panel.setBackground(Color.red);
	        panel.setVisible(true);
	        one.add(panel);
		//one.add(j);

	    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==back)
		{
			index two=new index();
			one.dispose();
		}
		if(e.getSource()==edit)
		{
			if(this.userid!=-1)
			{
			edit two=new edit(one,userid);			
				           
		
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Select a row First");
			}
			
			
		}

		if(e.getSource()==delete)
		{
			if(this.userid!=-1)
			{
			portalfunctions p=new portalfunctions();
			p.delete(userid);
			one.dispose();
			portal port=new portal();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Select a row First");
			}
			
			
		}
		
	
}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		JTable target = (JTable)e.getSource();
		System.out.println(target.getSelectedRow());
		int row=target.getSelectedRow();
		String a=cache.get(row).get(0);
		userid=Integer.parseInt(a);
		}
		
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}

