
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;
import javax.swing.*;
import java.util.List;

class viewstudent extends JFrame 
{
Container c;
String column[] = {"Roll-no","Name","Subject 1","Subject 2","Subject 3"};
Object[][] data;
JTable valTable;
JButton btnBack;
Border empty,white;

viewstudent()
{
c = getContentPane();
c.setBackground(Color.BLACK);
c.setLayout(new FlowLayout());
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact = cfg.buildSessionFactory();
Session session = sfact.openSession();

try {
	List<Student> stu = new ArrayList<>();
	stu = session.createQuery("from Student order by id").list();
	data = new Object[stu.size()][];
	int i = 0;
	for(Student s: stu){
		data[i] = new Object[]{  s.getRno(), s.getName(), s.getMark1(), s.getMark2(), s.getMark3()};
		i++;
	}
}

catch(Exception e) {
	JOptionPane.showMessageDialog(new JFrame(),"Issue : " + e);
}

finally {
	session.close();
	sfact.close();
}
valTable = new JTable(data,column);
valTable.setPreferredScrollableViewportSize(new Dimension(430,150));
valTable.setFillsViewportHeight(true);
valTable.setEnabled(false); // for make table uneditable
valTable.getTableHeader().setReorderingAllowed(false); 
				
btnBack = new JButton("BACK");

Font g = new Font("Calibri",Font.BOLD,30);
btnBack.setFont(g);

c.add(new JScrollPane(valTable));
c.add(btnBack);

ActionListener a1 = (ae) -> { sms a = new sms(); this.dispose(); };
btnBack.addActionListener(a1);


setTitle("View Student");
setSize(450,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

if(data.length <= 0){
	JOptionPane.showMessageDialog(c,"No Record Found. ");
	sms ms = new sms();
}
else{
	setVisible(true);
}
}
}

