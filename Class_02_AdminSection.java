package Library;

import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;

public class Class_02_AdminSection extends JFrame implements ActionListener{
	
	JLabel l1;
	JButton bt1;
	JPanel p1, p2;
	Font f1,f2;
	
	
	public Class_02_AdminSection() {
		super("Admin Page");
		setLocation(0,0);
		setSize(1500, 800);
		
		f1 = new Font("Arial", Font.BOLD, 25);
		f2 = new Font("Arial", Font.BOLD, 20);
		
		ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Library/icon/image19.jpg"));
		Image img = ic.getImage().getScaledInstance(1500, 800, Image.SCALE_DEFAULT);
		ImageIcon ic1 = new ImageIcon(img);
		l1 = new JLabel(ic1);
		
		JMenuBar m1 = new JMenuBar();
		JMenu men1 = new JMenu("Add ");
		JMenuItem jmt1 = new JMenuItem("Add Librarian");
		
		JMenu men2 = new JMenu("View ");
		JMenuItem jmt2 = new JMenuItem("View Librarian");
		
		JMenu men3 = new JMenu("Delete ");
		JMenuItem jmt3 = new JMenuItem("Delete Librarian");
		
		JMenu men4 = new JMenu("Exit");
		JMenuItem jmt4 = new JMenuItem("Logout");
		
		men1.add(jmt1);
		men2.add(jmt2);
		men3.add(jmt3);
		men4.add(jmt4);
		
		m1.add(men1);
		m1.add(men2);
		m1.add(men3);
		m1.add(men4);
		
		men1.setFont(f1);
		men2.setFont(f1);
		men3.setFont(f1);
		men4.setFont(f1);
		
		jmt1.setFont(f1);
		jmt2.setFont(f1);
		jmt3.setFont(f1);
		jmt4.setFont(f1);
		
		jmt1.addActionListener(this);
		jmt2.addActionListener(this);
		jmt3.addActionListener(this);
		jmt4.addActionListener(this);
		
		setJMenuBar(m1);
		add(l1);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmnd = e.getActionCommand();
		if(cmnd.equals("Add Librarian")) {
			new Class_03_AddLibrarian().setVisible(true);
		}
		else if(cmnd.equals("View Librarian")) {
			new Class_04_ViewLibrarian().setVisible(true);
		}
		else if(cmnd.equals("Delete Librarian")) {
			new Class_05_DeleteLibrarian().setVisible(true);
		}
		else if(cmnd.equals("Logout")) {
			System.exit(0);
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("Testing....");
		new Class_02_AdminSection().setVisible(true);
	}



















	
	
}
