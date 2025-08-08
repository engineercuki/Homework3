package controller.patient;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.HomePage;
import dao.impl.BookSchduleDaoImpl;
import model.BookSchdule;
import model.Patient;
import service.impl.BookSchduleServiceImpl;
import service.impl.PatientServiceImpl;
import util.Tool;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class InfoUpdate extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoUpdate frame = new InfoUpdate();
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
	public InfoUpdate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1080, 760);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 1044, 146);
		contentPane.add(panel);
		
		JLabel gjun = new JLabel("");
		gjun.setIcon(new ImageIcon(Login.class.getResource("/image/gjun.jpg")));
		gjun.setBounds(0, 0, 1044, 146);
		panel.add(gjun);
		
		JTextArea info = new JTextArea();
		info.setFont(new Font("新細明體", Font.PLAIN, 24));
		info.setBounds(10, 206, 1044, 309);
		contentPane.add(info);
		
		JLabel userMsg = new JLabel("個人資料");
		userMsg.setBackground(new Color(255, 255, 255));
		userMsg.setHorizontalAlignment(SwingConstants.CENTER);
		userMsg.setFont(new Font("標楷體", Font.PLAIN, 24));
		userMsg.setBounds(10, 166, 1044, 30);
		contentPane.add(userMsg);
		
		password = new JTextField();
		password.setFont(new Font("新細明體", Font.PLAIN, 24));
		password.setColumns(10);
		password.setBounds(626, 553, 165, 44);
		contentPane.add(password);
		
		JLabel lblNewLabel_1_1 = new JLabel("密碼");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.PLAIN, 24));
		lblNewLabel_1_1.setBounds(505, 553, 111, 44);
		contentPane.add(lblNewLabel_1_1);
		
	
		
		//*************功能區************
		BookSchduleDaoImpl bdi=new BookSchduleDaoImpl();
		Patient name=(Patient)Tool.readFile("member.txt");
		String show=name.getPatientName()+" 的會員資料";
		userMsg.setText(show);
		
		JButton goTo = new JButton("返回");
		goTo.setForeground(new Color(255, 0, 0));
		goTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePage home=new HomePage();
				home.setVisible(true);
				dispose();
			}
		});
		goTo.setFont(new Font("新細明體", Font.PLAIN, 24));
		goTo.setBounds(220, 645, 165, 44);
		contentPane.add(goTo);
		
		JButton check = new JButton("查詢");
		check.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Patient pid = (Patient) Tool.readFile("member.txt"); 
				PatientServiceImpl service = new PatientServiceImpl();
				Patient p = service.findPatientInfo(pid.getPatientId()); 
				String showInfo = Tool.formatPatientInfo(p);
				info.setText(showInfo);
			}
		});
		check.setFont(new Font("新細明體", Font.PLAIN, 24));
		check.setBounds(426, 645, 165, 44);
		contentPane.add(check);
		
		JButton submit = new JButton("確認修改");
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 取得 patientId
		        Patient pid= (Patient) Tool.readFile("member.txt");
		        String patientId = pid.getPatientId();
		        // 呼叫更新方法
		        PatientServiceImpl service = new PatientServiceImpl();
		        boolean success = service.update(patientId, password.getText());
		        info.setText("密碼已更新，清點選[查詢]確認！");
		        password.setText("");
			}
		});
		submit.setForeground(new Color(0, 0, 255));
		submit.setFont(new Font("新細明體", Font.PLAIN, 24));
		submit.setBounds(626, 645, 165, 44);
		contentPane.add(submit);

	}

}
