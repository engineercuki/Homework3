package controller.booking;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.HomePage;
import controller.patient.Login;
import dao.impl.BookSchduleDaoImpl;
import model.BookSchdule;
import model.Patient;
import util.Tool;

import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookAfterToday extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAfterToday frame = new BookAfterToday();
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
	public BookAfterToday() {
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
		
		JLabel lblNewLabel = new JLabel("門診科別");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 24));
		lblNewLabel.setBounds(151, 287, 96, 33);
		contentPane.add(lblNewLabel);	

		JLabel lblNewLabel_1 = new JLabel("醫師");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(151, 380, 96, 33);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("時段");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.PLAIN, 24));
		lblNewLabel_1_1.setBounds(539, 380, 96, 33);
		contentPane.add(lblNewLabel_1_1);
	
		JLabel lblNewLabel_1_1_1 = new JLabel("時間");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("新細明體", Font.PLAIN, 24));
		lblNewLabel_1_1_1.setBounds(539, 476, 96, 33);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("掛號日期");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2.setFont(new Font("新細明體", Font.PLAIN, 24));
		lblNewLabel_1_1_2.setBounds(539, 287, 96, 33);
		contentPane.add(lblNewLabel_1_1_2);
		
		
		JLabel loginMsg = new JLabel("");
		loginMsg.setHorizontalAlignment(SwingConstants.CENTER);
		loginMsg.setForeground(Color.BLUE);
		loginMsg.setFont(new Font("標楷體", Font.PLAIN, 24));
		loginMsg.setBounds(194, 155, 641, 64);
		contentPane.add(loginMsg);
		
		
		JLabel lblNewLabel_2 = new JLabel("僅提供14天內的預約日期(每日00:00刷新 )");
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(646, 321, 396, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel bookingMsg = new JLabel("");
		bookingMsg.setHorizontalAlignment(SwingConstants.CENTER);
		bookingMsg.setForeground(Color.RED);
		bookingMsg.setFont(new Font("新細明體", Font.PLAIN, 24));
		bookingMsg.setBounds(266, 556, 569, 49);
		contentPane.add(bookingMsg);
		
		//******************功能區*******************
		
		BookSchduleDaoImpl bdi=new BookSchduleDaoImpl();
		Patient name=(Patient)Tool.readFile("member.txt");
		String show=name.getPatientName()+"，歡迎您! 請選擇預約掛號資訊";
		loginMsg.setText(show);
		
		String[] deptOptions = {"","內診", "針灸","復健"};
		JComboBox<String> dept = new JComboBox(deptOptions);
		dept.setFont(new Font("新細明體", Font.PLAIN, 24));
		dept.setBounds(257, 287, 151, 33);
		contentPane.add(dept);
		
		String[] doctorsA = {"","鄭芳行", "吳所畏", "陳佳嘉"};
		String[] doctorsB = {"","王權一", "郝湯洲"};
		String[] doctorsC = {"","劉安", "陳訴利"};
		JComboBox doctor = new JComboBox();
		doctor.setFont(new Font("新細明體", Font.PLAIN, 24));
		// 加入監聽器，根據 department 的選擇更新 doctor 的選項
		dept.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String selectedDept = (String) dept.getSelectedItem();
		        doctor.removeAllItems(); // 清空原有選項

		        switch (selectedDept) {
		            case "內診":
		                for (String doc : doctorsA) doctor.addItem(doc);
		                break;
		            case "針灸":
		                for (String doc : doctorsB) doctor.addItem(doc);
		                break;
		            case "復健":
		                for (String doc : doctorsC) doctor.addItem(doc);
		                break;
		        }
		    }
		});
		doctor.setBounds(257, 380, 151, 33);
		contentPane.add(doctor);	
		
		
		String[] durOptions = {"","上午診", "下午診","晚診"};
		JComboBox<String> duration = new JComboBox(durOptions);
		duration.setFont(new Font("新細明體", Font.PLAIN, 24));
		duration.setBounds(646, 380, 151, 33);
		contentPane.add(duration);
		
		String[] timeA = {"","9:00", "9:10", "9:20", "9:30", "9:40", "9:50", "10:00", "10:10", "10:20", "10:30", "10:40", "10:50", "11:00", "11:10", "11:20", "11:30", "11:40", "11:50"};
		String[] timeB = {"","14:00", "14:10", "14:20", "14:30", "14:40", "14:50", "15:00", "15:10", "15:20", "15:30", "15:40", "15:50", "16:00", "16:10", "16:20", "16:30", "16:40", "16:50"};
		String[] timeC = {"","18:00", "18:10", "18:20", "18:30", "18:40", "18:50", "19:00", "19:10", "19:20", "19:30", "19:40", "19:50", "20:00", "20:10", "20:20", "20:30", "20:40", "20:50"};
		JComboBox time = new JComboBox();
		time.setFont(new Font("新細明體", Font.PLAIN, 24));
		// 加入監聽器，根據 department 的選擇更新 doctor 的選項
					duration.addActionListener(new ActionListener() {
				    @Override
				    public void actionPerformed(ActionEvent e) {
				        String selectedTime = (String) duration.getSelectedItem();
				        time.removeAllItems(); // 清空原有選項

				        switch (selectedTime) {
				            case "上午診":
				                for (String doc : timeA) time.addItem(doc);
				                break;
				            case "下午診":
				                for (String doc : timeB) time.addItem(doc);
				                break;
				            case "晚診":
				                for (String doc :timeC) time.addItem(doc);
				                break;
				        }
				    }
				});
		time.setBounds(646, 476, 151, 33);
		contentPane.add(time);
				
				// 建立日期格式器（不補零）
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/M/d");
				JComboBox<String> date = new JComboBox<>();
				// 建立陣列儲存日期字串
				date.addItem(""); // 空白選項加在最前面
				LocalDate today = LocalDate.now();
				for (int i = 0; i < 14; i++) {
					LocalDate futureDate = today.plusDays(i + 1); // 從明天開始
				    String formattedDate = futureDate.format(formatter);
				    date.addItem(formattedDate);
				}
				date.setFont(new Font("新細明體", Font.PLAIN, 24));
				date.setBounds(645, 287, 151, 33);
				contentPane.add(date);
				
		JButton submit = new JButton("確認預約");
		submit.setForeground(new Color(0, 0, 255));
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
							BookSchdule booking = new BookSchdule();
							if( (String)date.getSelectedItem() != null && !((String)date.getSelectedItem()).isEmpty() && (String) time.getSelectedItem() != null && !((String) time.getSelectedItem()).isEmpty() && (String) doctor.getSelectedItem() != null && (String) doctor.getSelectedItem() != null && !((String) doctor.getSelectedItem()).isEmpty() && !((String) dept.getSelectedItem()).isEmpty()) {
								booking.setPatientName(name.getPatientName());
								booking.setPatientId(name.getPatientId());
								booking.setBookDate((String)date.getSelectedItem());
								booking.setBookTime((String)time.getSelectedItem());
								booking.setDoctorName((String)doctor.getSelectedItem());
								booking.setDepartment((String)dept.getSelectedItem());				
								bdi.add(booking);
					
								bookingMsg.setText("預約完成!");
								date.setSelectedItem("");
								time.setSelectedItem("");
								dept.setSelectedItem("");
								doctor.setSelectedItem("");
								duration.setSelectedItem("");
							}
							else {
								bookingMsg.setText("欄位不可空白!");
							}				
					}
		});
		submit.setFont(new Font("新細明體", Font.PLAIN, 24));
		submit.setBounds(737, 615, 216, 49);
		contentPane.add(submit);
		
		JButton exit = new JButton("返回");
		exit.setForeground(new Color(255, 0, 0));
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePage back=new HomePage();
				back.setVisible(true);
				dispose();
			}
		});
		exit.setFont(new Font("新細明體", Font.PLAIN, 24));
		exit.setBounds(151, 615, 216, 49);
		contentPane.add(exit);
		
		
		JButton goToday = new JButton("當天掛號");
		goToday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookToday goToday=new BookToday();
				goToday.setVisible(true);
				dispose();
			}
		});
		goToday.setFont(new Font("新細明體", Font.PLAIN, 24));
		goToday.setBounds(443, 615, 216, 49);
		contentPane.add(goToday);

	}
}
