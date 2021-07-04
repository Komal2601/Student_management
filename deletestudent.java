import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

class deletestudent extends JFrame
{
Container c;
JButton btndelete,btnback;
JLabel lblrno;
JTextField txtrno;

deletestudent()
{
c= getContentPane();
c.setBackground(Color.PINK);
c.setLayout(new FlowLayout());
Font f= new Font("Arial",Font.ITALIC,30);
btndelete=new JButton("Delete");
btnback=new JButton("Back");
lblrno= new JLabel("Enter Rno:");
txtrno=new JTextField(15);

btndelete.setFont(f);
btnback.setFont(f);
lblrno.setFont(f);
txtrno.setFont(f);

c.add(lblrno);
c.add(txtrno);
c.add(btndelete);
c.add(btnback);


ActionListener a1 = (ae) -> { sms a = new sms(); this.dispose(); };
btnback.addActionListener(a1);

ActionListener a2 = (ae) -> { 
	
	if(!txtrno.getText().isEmpty())
	{	try{
		int rno = Integer.parseInt(txtrno.getText());	
		if(rno<0)
			JOptionPane.showMessageDialog(c,"Roll no should not be negative");
		else
		{
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			SessionFactory sf = cfg.buildSessionFactory();
			Session s = null;
			Transaction t = null;
			try {
				s = sf.openSession();
				t = s.beginTransaction();
				Student stu = (Student)s.get(Student.class, rno);
				if(stu != null) {
					s.delete(stu);
					t.commit();
					JOptionPane.showMessageDialog(new JFrame(),"Record for roll no " + rno + " has been deleted");
					txtrno.setText("");
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(),"Record for roll no " + rno + " does not exist");
				}
			}

			catch(Exception e) {
				JOptionPane.showMessageDialog(new JFrame(),"Issue : " + e);
				t.rollback();
			}

			finally {
				s.close();
			}
		
		}
		}
		catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(c,"Roll no should contain digits only");
		}
	}
	else
	{
		JOptionPane.showMessageDialog(c,"Roll no cannot be blank");
	}
	
	
};
btndelete.addActionListener(a2);

setTitle("Deletee Student");
setSize(500,600);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);


}}