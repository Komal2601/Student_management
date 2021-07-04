import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import java.io.*;
import org.jfree.chart.renderer.category.BarRenderer;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.awt.Color;
import java.util.*;
import java.sql.*;

class charts extends JFrame{
Container c;
JButton btnback;
charts()
{
c=getContentPane();
c.setLayout(new FlowLayout());
Font f=new Font("Arial",Font.ITALIC,30);
btnback=new JButton("Back");
btnback.setFont(f);
c.add(btnback);

DefaultCategoryDataset ds=new DefaultCategoryDataset();
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sf=cfg.buildSessionFactory();
Session s=null;
Transaction t=null;
try{
s=sf.openSession();
t=s.beginTransaction();
java.util.List<Student> stu=new ArrayList<>();
stu=s.createQuery("from Student").list();
for(Student b:stu)
{
ds.addValue(b.getMark1(),b.getName(),"Mark1");
ds.addValue(b.getMark2(),b.getName(),"Mark2");
ds.addValue(b.getMark3(),b.getName(),"Mark3");






}}
catch(Exception e){
	JOptionPane.showMessageDialog(new JDialog(),e);
	t.rollback();
}
finally{
	s.close();
}



JFreeChart chart=ChartFactory.createBarChart("student's perf","Subject","Marks",ds,PlotOrientation.VERTICAL,true,true,true);








ChartPanel panel =new ChartPanel(chart);
setContentPane(panel);


setSize(500,400);
setLocationRelativeTo(null);
setTitle("Mark sheet");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}}

class chartTest
{
public static void main(String args[])
{
charts p=new charts();
}}


