import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class sms extends JFrame
{
JButton btnview,btnadd,btndelete,btnupdate,btncharts;
Container c;
sms()
{
c=getContentPane();
c.setLayout(new FlowLayout(FlowLayout.CENTER,70,50));
c.setBackground(Color.CYAN);
Font f=new Font("Arial",Font.BOLD,25);
btnview=new JButton("View");
btnadd=new JButton("Add");
btndelete=new JButton("Delete");
btnupdate=new JButton("Update");
btncharts=new JButton("Charts");

c.add(btnadd);
c.add(btnview);
c.add(btnupdate);
c.add(btndelete);
c.add(btncharts);

btnadd.setFont(f);
btnview.setFont(f);
btnupdate.setFont(f);
btndelete.setFont(f);
btncharts.setFont(f);

ActionListener a1=(ae)->{addstudent a = new addstudent(); dispose();};
btnadd.addActionListener(a1);

ActionListener a2=(ae)->{viewstudent a = new viewstudent(); dispose();};
btnview.addActionListener(a2);

ActionListener a3=(ae)->{deletestudent a = new deletestudent(); dispose();};
btndelete.addActionListener(a3);

ActionListener a4=(ae)->{updatestudent a = new updatestudent(); dispose();};
btnupdate.addActionListener(a4);

ActionListener a5=(ae)->{charts a = new charts(); dispose();};
btncharts.addActionListener(a5);



setTitle("S.M.S");
setSize(400,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);






}
public static void main(String args[]){
		sms as = new sms();
	}
}
