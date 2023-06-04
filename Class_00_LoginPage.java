package Library;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mysql.cj.jdbc.admin.MiniAdmin;

public class Class_00_LoginPage extends JFrame implements ActionListener{
	JLabel l1, l2, l3, l4;
	JButton bt1, bt2;
	JPanel p1, p2, p3;
	Font f1, f2;
	
	
	
	public Class_00_LoginPage() {
		super("LogIn Page");
		setLocation(500, 350);
		setSize(500, 200);
		
		f1 = new Font("Arial", Font.BOLD, 25);
		f2 = new Font("Arial", Font.BOLD, 20);
		
		l1 = new JLabel("Admin LogIn");
		l2 = new JLabel("Librarian LogIn");
		l3 = new JLabel("Library Management");
		
		
		
		bt1 = new JButton("Login");
		bt2 = new JButton("Login");
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Library/icon/image.png"));
		Image i = img.getImage().getScaledInstance(130, 120, Image.SCALE_DEFAULT);
		ImageIcon img2 = new ImageIcon(i);
		l4 = new JLabel(img2);
		
		
		l1.setFont(f2);
		l2.setFont(f2);
		l3.setFont(f1);
		
		bt1.setFont(f2);
		bt2.setFont(f2);
		
		l3.setHorizontalAlignment(JLabel.CENTER);
		l3.setForeground(Color.WHITE);
		
		p1 = new JPanel();
		p1.setLayout(new GridLayout(2, 2, 10, 10));
		p1.add(l1);
		p1.add(bt1);
		p1.add(l2);
		p1.add(bt2);
		
		p2 = new JPanel();
		p2.setLayout(new GridLayout(1, 1, 10, 10));
		p2.add(l4);
		
		p3 = new JPanel();
		p3.setLayout(new GridLayout(1, 1, 10, 10));
		p3.add(l3);
		p3.setBackground(Color.BLUE);
		
		setLayout(new BorderLayout(10, 10));
		add(p3,"North");
		add(p2,"West");
		add(p1,"Center");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt1) {
			System.out.println("Admin Login");
		 	new Class_01_AdminLogin().setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==bt2) {
			System.out.println("Librarian Login");
			new Class_06_Librarian().setVisible(true);
			this.setVisible(false);
		}
		
	}
	public static void main(String[] args) {
		new Class_00_LoginPage().setVisible(true);
		System.out.println("Testing.....");
	}
	

}
