package com.wuhanbus.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.wuhanbus.control.CardManager;
import com.wuhanbus.control.Iprint;
import com.wuhanbus.entity.Card;

public class BusFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusFrame frame = new BusFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BusFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(141, 101, 139, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u6D88\u8D39\u5361\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(49, 103, 97, 15);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u6D88\u8D39");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton.setBounds(152, 178, 93, 23);
		btnNewButton.addActionListener(this);  //添加事件监听器
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("\u65E0");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(313, 103, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		//数据初始化
		CardManager.Init();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String id=this.textField.getText().trim();
		int i=0;
		for (i = 0; i < CardManager.cards.size(); i++) {
			Card tempCard=CardManager.cards.get(i);
			if(id.equals(tempCard.getId())){
				this.lblNewLabel_1.setText(tempCard.pay());
				//tempCard.pay();
				Iprint ip=(Iprint)tempCard;
				JOptionPane.showMessageDialog(this, ip.print());
				break;
			}
		}
		if(i==CardManager.cards.size())
			JOptionPane.showConfirmDialog(this, "卡号输入错误");
	}
}
