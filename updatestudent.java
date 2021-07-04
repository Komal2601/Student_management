import javax.swing.*;
import java.awt.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.awt.event.*;
class updatestudent extends JFrame
{
Container c;
JButton btnsave,btnback;
JLabel lblrno,lblname,lblmark1,lblmark2,lblmark3;
JTextField txtrno,txtname,txtmark1,txtmark2,txtmark3;

updatestudent()
{
c = getContentPane();
c.setBackground(Color.PINK);
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



ActionListener a1=(ae)->{
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sf=cfg.buildSessionFactory();
Session s=null;
Transaction t=null;

try{
	s=sf.openSession();
	t=s.beginTransaction();
	int rno=Integer.parseInt(txtrno.getText());
	Student stu=(Student)s.get(Student.class,rno);
	if(stu!=null){
		String name=txtname.getText();
		stu.setName(name);
		int mark1=Integer.parseInt(txtmark1.getText());
		stu.setMark1(mark1);
		
		int mark2=Integer.parseInt(txtmark2.getText());
		stu.setMark2(mark2);

		
		int mark3=Integer.parseInt(txtmark3.getText());
		stu.setMark3(mark3);
		s.save(stu);
		t.commit();
		JOptionPane.showMessageDialog(new JDialog(),"Record updated");
}
else{
		JOptionPane.showMessageDialog(new JDialog(),"Record does not exist");
}}
	
catch(Exception e){
	System.out.println("issue"+e);
	t.rollback();
}
finally{
	s.close();
	System.out.println("close");
}};
btnsave.addActionListener(a1);



ActionListener a2 = (ae) -> { sms a = new sms(); dispose(); };
btnback.addActionListener(a2);





















setTitle("Update Student");
setSize(500,600);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setVisible(true);














}


}
