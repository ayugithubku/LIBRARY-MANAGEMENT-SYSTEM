package Library;
import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;


public class Class_03_AddLibrarian extends JFrame implements ActionListener{
	JLabel l1, l2, l3, l4, l5, l6, l7;
	JButton bt1, bt2;
	JPanel p1, p2;
	JTextField tf1, tf2, tf3, tf4, tf5;
	JPasswordField pf1;
	Font f1, f2;
	
	public Class_03_AddLibrarian() {
		super("Add Librarian");
		setLocation(450	, 400);
		setSize(650, 350);
		
		f1 = new Font("Arial", Font.BOLD, 25);
		f2 = new Font("Arial", Font.BOLD, 20);
		
		l1 = new JLabel("Add Librarian");
		l2 = new JLabel("Name");
		l3 = new JLabel("Password");
		l4 = new JLabel("Email");
		l5 = new JLabel("Contact");
		l6 = new JLabel("Address");
		l7 = new JLabel("City");
		
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf4 = new JTextField();
		tf5 = new JTextField();
		
		pf1 = new JPasswordField();
		
		l1.setFont(f1);
		l2.setFont(f2);
		l3.setFont(f2);
		l4.setFont(f2);
		l5.setFont(f2);
		l6.setFont(f2);
		l7.setFont(f2);
		
		l1.setForeground(Color.WHITE);
		l1.setHorizontalAlignment(JLabel.CENTER);
		
		tf1.setFont(f2);
		tf2.setFont(f2);
		tf3.setFont(f2);
		tf4.setFont(f2);
		tf5.setFont(f2);
		
		pf1.setFont(f2);
		
		bt1 = new JButton("Add Librarian");
		bt2 = new JButton("Cancel");
		
		bt1.setFont(f2);
		bt2.setFont(f2);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		
		p1 = new JPanel();
		p1.setLayout(new GridLayout(1, 1, 10, 10));
		p1.add(l1);
		p1.setBackground(Color.BLUE);
		
		p2 = new JPanel();
		p2.setLayout(new GridLayout(7, 2, 10, 10));
		p2.add(l2);
		p2.add(tf1);
		p2.add(l3);
		p2.add(pf1);
		p2.add(l4);
		p2.add(tf2);
		p2.add(l5);
		p2.add(tf3);
		p2.add(l6);
		p2.add(tf4);
		p2.add(l7);
		p2.add(tf5);
		p2.add(bt1);
		p2.add(bt2);
		
		setLayout(new BorderLayout(10, 10));
		add(p1, "North");
		add(p2, "Center");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = tf1.getText();
		String pass = pf1.getText();
		String email = tf2.getText();
		String contact = tf3.getText();
		String address = tf4.getText();
		String city = tf5.getText();
		
		if(e.getSource()==bt1) {
			try {
				Class_0_ConnectionClass obj = new Class_0_ConnectionClass();
				String q = "Insert into tree(name, password, email,contact, address, city) values('"+name+"', '"+pass+"', '"+email+"', '"+contact+"','"+address+"','"+city+"')";
				int aa = obj.stm.executeUpdate(q);
				
				if(aa==1) {
					JOptionPane.showMessageDialog(null, "Your data successfully inserted");
					this.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Please!, Fill all details carefully");
					this.setVisible(true);
				}
				
				}catch(Exception ee) {
				ee.printStackTrace();
			}
		}
		if(e.getSource()==bt2) {
			this.setVisible(false);
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("Testing...");
		new Class_03_AddLibrarian().setVisible(true);
		
	}




























	
}
