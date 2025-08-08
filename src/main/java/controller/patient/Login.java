package controller.patient;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.HomePage;
import model.Patient;
import service.impl.PatientServiceImpl;
import util.CheckCode;
import util.Tool;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pid;
	private JTextField password;
	private JTextField checkCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 1044, 146);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/image/gjun.jpg")));
		lblNewLabel_3.setBounds(0, 0, 1044, 146);
		panel.add(lblNewLabel_3);
		
		pid = new JTextField();
		pid.setFont(new Font("新細明體", Font.PLAIN, 24));
		pid.setBounds(408, 211, 220, 31);
		contentPane.add(pid);
		pid.setColumns(10);
		
		password = new JTextField();
		password.setFont(new Font("新細明體", Font.PLAIN, 24));
		password.setColumns(10);
		password.setBounds(408, 281, 220, 31);
		contentPane.add(password);
		
		checkCode = new JTextField();
		checkCode.setFont(new Font("新細明體", Font.PLAIN, 24));
		checkCode.setColumns(10);
		checkCode.setBounds(408, 351, 220, 31);
		contentPane.add(checkCode);
		
		JLabel lblNewLabel = new JLabel("身分證字號");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 24));
		lblNewLabel.setBounds(245, 211, 153, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(245, 281, 153, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("輸入驗證碼");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(245, 351, 153, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("驗證碼");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setFont(new Font("新細明體", Font.PLAIN, 24));
		lblNewLabel_2_1.setBounds(245, 410, 153, 31);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel loginMsg = new JLabel("");
		loginMsg.setForeground(new Color(255, 0, 0));
		loginMsg.setFont(new Font("新細明體", Font.PLAIN, 24));
		loginMsg.setHorizontalAlignment(SwingConstants.CENTER);
		loginMsg.setBounds(330, 497, 364, 44);
		contentPane.add(loginMsg);		
		
		//****************功能區******************
		JLabel ramdomCode= new JLabel("");
		ramdomCode.setHorizontalAlignment(SwingConstants.CENTER);
		CheckCode rc = new CheckCode();
	    ramdomCode.setText(rc.show());
		ramdomCode.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		ramdomCode.setBounds(392, 401, 182, 38);
		contentPane.add(ramdomCode);
		
		JLabel checkImage = new JLabel("");
		checkImage.setBounds(408, 403, 153, 38);
	    ImageIcon icon = new ImageIcon(getClass().getResource(rc.getCheckImage()));
		checkImage.setIcon(icon);
		checkImage.setHorizontalAlignment(SwingConstants.CENTER);
		checkImage.setFont(new Font("新細明體", Font.PLAIN, 24));
		contentPane.add(checkImage);
		
		JButton btnNewButton = new JButton("換一張");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CheckCode rc = new CheckCode();
			    ramdomCode.setText(rc.show());
			    ImageIcon icon = new ImageIcon(getClass().getResource(rc.getCheckImage()));
			    checkImage.setIcon(icon);
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 18));
		btnNewButton.setBounds(560, 405, 110, 36);
		contentPane.add(btnNewButton);
		
		JButton submit = new JButton("登入");
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
							String Pid=pid.getText();
							String Password=password.getText();
							String Check=checkCode.getText();
							String Ramdom=ramdomCode.getText();
							
							if(Check.equals(Ramdom)) {
							Patient p=new PatientServiceImpl().login(Pid,Password);
							if(p!=null){
										
										//呼叫Tool頁面的儲存資料功能，將登入資料寫入txt暫存
										Tool.saveFile(p,"member.txt");
								
										//跳轉頁面並關閉本頁面
										HomePage home=new HomePage();
										home.setVisible(true);
										dispose();
							}
							else {
										loginMsg.setText("帳號密碼錯誤，請重新輸入!");
										
							}}
							else {
										loginMsg.setText("驗證碼錯誤，請重新輸入!");
							}
				}
			});
		submit.setFont(new Font("新細明體", Font.PLAIN, 24));
		submit.setBounds(406, 575, 220, 36);
		contentPane.add(submit);
		
		JButton register = new JButton("去註冊");
		register.setForeground(new Color(0, 0, 255));
		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Rigister goRig=new Rigister();
				goRig.setVisible(true);
				dispose();
			}
		});
		register.setFont(new Font("新細明體", Font.PLAIN, 24));
		register.setBounds(760, 575, 220, 36);
		contentPane.add(register);
		
		JButton exit = new JButton("離開");
		exit.setForeground(new Color(255, 0, 0));
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		exit.setFont(new Font("新細明體", Font.PLAIN, 24));
		exit.setBounds(57, 575, 220, 36);
		contentPane.add(exit);

		
	}
}
