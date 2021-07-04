import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.exception.ConstraintViolationException;


class addstudent extends JFrame 
{
Container c;
JButton btnsave,btnback;
JLabel lblrno,lblname,lblmark1,lblmark2,lblmark3;
JTextField txtrno,txtname,txtmark1,txtmark2,txtmark3;

addstudent()
{
c = getContentPane();
c.setBackground(Color.CYAN);
c.setLayout(new FlowLayout());
Font f = new Font("Arial",Font.ITALIC,30);
btnsave=new JButton("Save");
btnback=new JButton("Back");
lblrno=new JLabel("Enter Rno:");
lblname=new JLabel("Enter Name:");
lblmark1=new JLabel("Enter sub marks 1:");
lblmark2=new JLabel("Enter sub marks 2:");
lblmark3=new JLabel("Enter sub marks 3:");
txtrno=new JTextField(15);
txtname=new JTextField(15);
txtmark1=new JTextField(15);
txtmark2=new JTextField(15);
txtmark3=new JTextField(15);

btnsave.setFont(f);
btnback.setFont(f);
lblrno.setFont(f);
lblname.setFont(f);
lblmark1.setFont(f);
lblmark2.setFont(f);
lblmark3.setFont(f);
txtrno.setFont(f);
txtname.setFont(f);
txtmark1.setFont(f);
txtmark2.setFont(f);
txtmark3.setFont(f);


c.add(lblrno);
c.add(txtrno);
c.add(lblname);
c.add(txtname);
c.add(lblmark1);
c.add(txtmark1);
c.add(lblmark2);
c.add(txtmark2);
c.add(lblmark3);
c.add(txtmark3);
c.add(btnsave);
c.add(btnback);



ActionListener a1 = (ae) -> { sms a = new sms(); dispose(); };
btnback.addActionListener(a1);

ActionListener a2 = (ae) -> { 
		
if(!txtrno.getText().isEmpty())
	{
		try
		{
		int rno = Integer.parseInt(txtrno.getText());	
		if(rno<0)
			JOptionPane.showMessageDialog(c,"Roll no cannot be negative");
		else
		{
			int studentrno = Integer.parseInt(txtrno.getText());
			if(!txtname.getText().isEmpty())
			{
				if(!txtname.getText().matches("^[a-zA-Z]*$"))
					JOptionPane.showMessageDialog(c,"Name can contain alphabets only");
				else if(txtname.getText().length() < 2)
					JOptionPane.showMessageDialog(c,"Invalid name");
				else
				{	
					String studentname = txtname.getText();			
					if(!txtmark1.getText().isEmpty())					
					{
						try{
						int mark1 = Integer.parseInt(txtmark1.getText());
						
						if(mark1<0 || mark1>100)
							JOptionPane.showMessageDialog(c,"Invalid marks for subject1");
						else
						{		
							if(!txtmark2.getText().isEmpty())					
							{
								try {
								int mark2 = Integer.parseInt(txtmark2.getText());
								if(mark2<0 || mark2>100)
									JOptionPane.showMessageDialog(c,"Invalid marks for subject2");
								else
								{	
									if(!txtmark3.getText().isEmpty())					
									{
										try {
										int mark3 = Integer.parseInt(txtmark3.getText());
										if(mark3<0 || mark3>100)
											JOptionPane.showMessageDialog(c,"Invalid marks for subject3");
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
												Student stu = new Student(studentrno, studentname, mark1, mark2, mark3);
												s.save(stu);
												t.commit();
												JOptionPane.showMessageDialog(c, "Record added successfully.");
												txtrno.setText("");
												txtname.setText("");
												txtmark1.setText("");
												txtmark2.setText("");
												txtmark3.setText("");
											}
											catch(ConstraintViolationException e){
												JOptionPane.showMessageDialog(c,"Enter unique roll number");
											}
											catch(Exception e) {
												JOptionPane.showMessageDialog(c, "Invalid input" + e);
												t.rollback();
											}
											finally {
												s.close();
											}
										}
									}
									
									catch(NumberFormatException nfe) {
										JOptionPane.showMessageDialog(c,"Subject3 marks should contain digits only");
									}
									}
									else
									{
										JOptionPane.showMessageDialog(c," enter subject3  marks");
									}
								}
								}
								catch(NumberFormatException nfe) {
									JOptionPane.showMessageDialog(c,"Subject2 marks should contain digits only");
								}
							}
							else
							{
								JOptionPane.showMessageDialog(c," enter subject2 marks");
							}
						}
						}
						catch(NumberFormatException nfe) {
							JOptionPane.showMessageDialog(c,"Subject1 marks should contain digits only");
						}
					}
					
					else
					{
						JOptionPane.showMessageDialog(c," enter subject1 marks");
					}					
							
					}
					}
					else
					{
						JOptionPane.showMessageDialog(c,"Name cannot be blank");
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
btnsave.addActionListener(a2);































setTitle("Add Student");
setSize(500,600);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setVisible(true);

















}}
