package Library;
import java.sql.ResultSet;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Class_05_DeleteLibrarian extends JFrame implements ActionListener{
	
	String x[] = {"Id","Name","Password","Email","Contact","Address","City"};
	JButton bt1;
	String y[][]= new String[20][7];
	int i=0, j=0;
	JTable t;
	Font f1,f2;
	JTextField tf1;
	JPanel p1;
	JLabel l1;

	 Class_05_DeleteLibrarian() {
		super("Delete Librarian");
		setLocation(1,1);
		setSize(1000, 400);
		
		f1 = new Font("Arial", Font.BOLD, 15);
		f2 = new Font("Arial", Font.BOLD, 15);
		
		try {
			Class_0_ConnectionClass obj = new Class_0_ConnectionClass();
			String q = "Select * from tree";
			ResultSet rest = obj.stm.executeQuery(q);
			while(rest.next()) {
				y[i][j++]= rest.getString("Lid");
				y[i][j++]= rest.getString("Name");
				y[i][j++]= rest.getString("Password");
				y[i][j++]= rest.getString("Email");
				y[i][j++]= rest.getString("Contact");
				y[i][j++]= rest.getString("Address");
				y[i][j++]= rest.getString("City");
				i++;
				j=0;
			}
			t= new JTable(y, x);
			t.setFont(f1);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		JScrollPane sp = new JScrollPane(t);
		l1 = new JLabel("Delete Librarian");
		tf1 = new JTextField();
		bt1 = new JButton("Delete");
		bt1.addActionListener(this);
		l1.setFont(f1);
		tf1.setFont(f1);
		bt1.setFont(f1);
		
		p1 = new JPanel();
		p1.setLayout(new GridLayout(1, 3, 10, 10));
		p1.add(l1);
		p1.add(tf1);
		p1.add(bt1);
		
		setLayout(new BorderLayout(10, 10));
		add(sp, "Center");
		add(p1, "South");
		add(sp);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==bt1) {
			int id = Integer.parseInt(tf1.getText());
			
			try {
				Class_0_ConnectionClass obj = new Class_0_ConnectionClass();
				String q = "delete from tree where Lid ='"+id+"'";
				int res = obj.stm.executeUpdate(q);
				if(res==1) {
					JOptionPane.showMessageDialog(null, "Your data successfully Deleted");
					this.setVisible(false);
					new Class_05_DeleteLibrarian().setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Your data didn't successfully Deleted");
					this.setVisible(false);
					new Class_05_DeleteLibrarian().setVisible(true);
					
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Testing....");
		new Class_05_DeleteLibrarian().setVisible(true);

	}
	


	

}
