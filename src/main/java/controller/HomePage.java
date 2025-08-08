package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.booking.BookAfterToday;
import controller.booking.BookToday;
import controller.booking.BookedCancel;
import controller.patient.InfoUpdate;
import controller.patient.Login;
import model.Patient;
import util.Tool;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import java.awt.Color;

public class HomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		

        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 1044, 146);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel gjun = new JLabel("");
		gjun.setIcon(new ImageIcon(Login.class.getResource("/image/gjun.jpg")));
		gjun.setBounds(0, 0, 1044, 146);
		panel.add(gjun);		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBounds(10, 155, 1044, 516);
		contentPane.add(panel_1);
		panel_1.setLayout(null);		
		
		JLabel loginMsg = new JLabel("");
		loginMsg.setHorizontalAlignment(SwingConstants.CENTER);
		loginMsg.setForeground(new Color(0, 0, 255));
		loginMsg.setFont(new Font("標楷體", Font.PLAIN, 24));
		loginMsg.setBounds(221, 23, 641, 64);
		panel_1.add(loginMsg);
	
		
		//*****************功能區******************
		
		Patient p=(Patient)Tool.readFile("member.txt");
		String show=p.getPatientName()+"，歡迎您! 請選擇需要的服務";
		loginMsg.setText(show);
		
		JButton bookingNow = new JButton("現場掛號(當日)");
		bookingNow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BookToday goToday=new BookToday();
				goToday.setVisible(true);
				dispose();
			}
		});
		bookingNow.setFont(new Font("標楷體", Font.PLAIN, 24));
		bookingNow.setBounds(221, 93, 641, 81);
		panel_1.add(bookingNow);
		
		JButton bookAfterToday = new JButton("預約掛號(非當日)");
		bookAfterToday.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BookAfterToday goAT=new BookAfterToday();
				goAT.setVisible(true);
				dispose();
			}
		});
		bookAfterToday.setFont(new Font("標楷體", Font.PLAIN, 24));
		bookAfterToday.setBounds(221, 200, 641, 81);
		panel_1.add(bookAfterToday);
	
		JButton goDelect = new JButton("查詢預約或取消(非當日)");
		goDelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BookedCancel goCancel=new BookedCancel();
				goCancel.setVisible(true);
				dispose();
			}
		});
		goDelect.setFont(new Font("標楷體", Font.PLAIN, 24));
		goDelect.setBounds(221, 318, 641, 81);
		panel_1.add(goDelect);
		
		JButton updateInfo = new JButton("修改個人資料");
		updateInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InfoUpdate update=new InfoUpdate();
				update.setVisible(true);
				dispose();
			}
		});
		updateInfo.setFont(new Font("標楷體", Font.PLAIN, 24));
		updateInfo.setBounds(221, 425, 641, 81);
		panel_1.add(updateInfo);
		
		JButton exit = new JButton("離開");
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		exit.setForeground(new Color(255, 0, 0));
		exit.setFont(new Font("新細明體", Font.PLAIN, 24));
		exit.setBounds(22, 421, 134, 50);
		panel_1.add(exit);
		
		//時鐘
		JLabel dateTimeLabel = new JLabel();
		dateTimeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 466, 161, 40); 
		panel_2.add(dateTimeLabel);
		Tool.updateDateTime(dateTimeLabel); // 初始更新
		Timer timer = new Timer(1000, new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Tool.updateDateTime(dateTimeLabel);
		    }
		});
		timer.start();
		panel_1.add(panel_2);
		
	
	}
}
