package adbook;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class LookUp extends JFrame  implements ActionListener {
	JTextField name1,phone1,email1,qq1,remark1;	
	private JLabel name,phone,email,qq,remark;
	private JButton lookup,del,updata;
	private Box b1,b2,b3,b4,b5,b6,b7;
	private Link l1;
	
	public LookUp(){
		super("查找或删除");
		name = new JLabel("姓名");
		phone = new JLabel("手机");
		email = new JLabel("Email");
		qq = new JLabel("QQ");
		remark = new JLabel("备注");
		name1 = new JTextField(25);
		phone1 = new JTextField(25);
		email1 = new JTextField(25);
		qq1 = new JTextField(25);
		remark1 = new JTextField(25);
		lookup = new JButton("查找");
		del = new JButton("删除");
		updata = new JButton("修改");
		setLayout(new FlowLayout());
		b1 = Box.createHorizontalBox();
		b2 = Box.createHorizontalBox();
		b3 = Box.createHorizontalBox();
		b4 = Box.createHorizontalBox();
		b5 = Box.createHorizontalBox();
		b6 = Box.createHorizontalBox();
		b7 = Box.createVerticalBox();
		b1.add(name);
		b1.add(Box.createHorizontalStrut(30));
		b1.add(name1);
		b2.add(phone);
		b2.add(Box.createHorizontalStrut(30));
		b2.add(phone1);
		b3.add(email);
		b3.add(Box.createHorizontalStrut(25));
		b3.add(email1);
		b4.add(qq);
		b4.add(Box.createHorizontalStrut(38));
		b4.add(qq1);
		b5.add(remark);
		b5.add(Box.createHorizontalStrut(30));
		b5.add(remark1);
		b6.add(lookup);
		b6.add(Box.createHorizontalStrut(60));
		b6.add(del);
		b6.add(Box.createHorizontalStrut(60));
		b6.add(updata);
		b7.add(b1);
		b7.add(Box.createVerticalStrut(20));
		b7.add(b2);
		b7.add(Box.createVerticalStrut(20));
		b7.add(b3);
		b7.add(Box.createVerticalStrut(20));
		b7.add(b4);
		b7.add(Box.createVerticalStrut(20));
		b7.add(b5);
		b7.add(Box.createVerticalStrut(20));
		b7.add(b6);
		add(b7);
		lookup.addActionListener(this);
		del.addActionListener(this);
		updata.addActionListener(this);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.pack();
		this.setSize(520,320);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		String na = name1.getText();
		// TODO 自动生成的方法存根
		l1 = new Link();
		if(e.getSource().equals(lookup)){
			try {
				l1.Link();
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		try {
			phone1.setText(l1.showphone(na));
			email1.setText(l1.showemail(na));
			qq1.setText(l1.showeqq(na));
			remark1.setText(l1.showeremark(na));
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		}else if(e.getSource().equals(del)){
			try {
				l1.del(name1.getText());
				name1.setText(null);
				phone1.setText(null);
				email1.setText(null);
				qq1.setText(null);
				remark1.setText(null);
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(this, "恭喜！删除成功！","添加联系人",JOptionPane.INFORMATION_MESSAGE, null);
			
		}if(e.getSource().equals(updata)) {
			try {
				l1.updata(name1.getText(),phone1.getText(),email1.getText(),qq1.getText(),remark1.getText());
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(this, "恭喜！修改成功！","添加联系人",JOptionPane.INFORMATION_MESSAGE, null);
		}
		
	}
}
