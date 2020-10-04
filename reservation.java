package select_mirim;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class consulting {
	private String id;
	private String snum;
	private String pnum;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSnum() {
		return snum;
	}

	public void setSnum(String snum) {
		this.snum = snum;
	}

	public String getPnum() {
		return pnum;
	}

	public void setPnum(String pnum) {
		this.pnum = pnum;
	}

	public static boolean search(String checkid) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		String sql = "select id from consulting";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				if (rs.getString("id").equals(checkid)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/reservation?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String pwd = "Soorim1!";
		Connection conn = null;

		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, pwd);
		System.out.println("접속");

		return conn;
	}

	public void createConsulting(String id, String snum, String pnum) {
		try {
			Connection con = getConnection();
			createTable();
			PreparedStatement insert = con.prepareStatement("" + "INSERT INTO consulting" + "(id, snum, pnum) "
					+ "VALUE " + "('" + id + "','" + snum + "','" + pnum + "')");
			insert.executeUpdate();
			System.out.println("The data has been saved!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void createTable() {
		try {
			Connection con = getConnection();
			PreparedStatement createTable = con.prepareStatement("CREATE TABLE IF NOT EXISTS "
					+ "consulting(id varChar(225)," + "snum varChar(225)," + "pnum varChar(225)," + "primary key(id))");
			createTable.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Table successfully created");
		}
	}

	public static String[][] getconsulting() {
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement("Select id, snum, pnum FROM consulting");
			ResultSet results = pstmt.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while (results.next()) {
				list.add(
						new String[] { results.getString("id"), results.getString("snum"), results.getString("pnum") });
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][3];
			return list.toArray(arr);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}
}

class coworking {

	private String id;
	private String snum;
	private String pnum;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSnum() {
		return snum;
	}

	public void setSnum(String snum) {
		this.snum = snum;
	}

	public String getPnum() {
		return pnum;
	}

	public void setPnum(String pnum) {
		this.pnum = pnum;
	}

	public static boolean search(String checkid) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		String sql = "select id from coworking";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				if (rs.getString("id").equals(checkid)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/reservation?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String pwd = "Soorim1!";

		Connection conn = null;
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, pwd);
		System.out.println("접속");

		return conn;
	}

	public static void createCoworking(String id, String snum, String pnum) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement("" + "INSERT INTO coworking" + "(id, snum, pnum) " + "VALUE"
					+ "('" + id + "','" + snum + "','" + pnum + "')");
			insert.executeUpdate();
			System.out.println("The data has been saved!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static String[][] getCoworking() {
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement("Select id, snum, pnum FROM coworking");
			ResultSet results = pstmt.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while (results.next()) {
				list.add(
						new String[] { results.getString("id"), results.getString("snum"), results.getString("pnum") });
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][3];
			return list.toArray(arr);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	public void createTable() {
		try {
			Connection con = getConnection();
			PreparedStatement createTable = con.prepareStatement("CREATE TABLE IF NOT EXISTS "
					+ "coworking(id varChar(225)," + "snum varChar(225)," + "pnum varChar(225)," + "primary key(id))");
			createTable.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Table successfully created");
		}
	}

}

class muhan {

	private String id;
	private String snum;
	private String pnum;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSnum() {
		return snum;
	}

	public void setSnum(String snum) {
		this.snum = snum;
	}

	public String getPnum() {
		return pnum;
	}

	public void setPnum(String pnum) {
		this.pnum = pnum;
	}

	public static String[][] getMuhan() {
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement("Select id, snum, pnum FROM muhan");
			ResultSet results = pstmt.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while (results.next()) {
				list.add(
						new String[] { results.getString("id"), results.getString("snum"), results.getString("pnum") });
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][3];
			return list.toArray(arr);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	public static boolean search(String checkid) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		String sql = "select id from muhan";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				if (rs.getString("id").equals(checkid)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/reservation?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String pwd = "Soorim1!";
		Connection conn = null;

		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, pwd);
		System.out.println("접속");

		return conn;
	}

	public static void createMuhan(String id, String snum, String pnum) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement("" + "INSERT INTO muhan" + "(id, snum, pnum) " + "VALUE"
					+ "('" + id + "','" + snum + "','" + pnum + "')");
			insert.executeUpdate();
			System.out.println("The data has been saved!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void createTable() {
		try {
			Connection con = getConnection();
			PreparedStatement createTable = con
					.prepareStatement("CREATE TABLE IF NOT EXISTS " + "muhan(id varChar(225) NOT NULL,"
							+ "snum varChar(225) NOT NULL," + "pnum varChar(225) NOT NULL," + "primary key(id))");
			createTable.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Table successfully created");
		}
	}
}

public class Reservation {

	JFrame frame;
	muhan Muhan = new muhan();
	consulting Consulting = new consulting();
	coworking Coworking = new coworking();
	private JTextField IDTextMuhan;
	private JTextField IDtextCoworking;
	private JTextField IDTextConsulting;
	int whereisit;

	public static boolean checkInt(String snum) {
		try {
			Integer.parseInt(snum);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservation window = new Reservation();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Reservation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 1068, 654);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// 조회하기 패널
		JPanel SearchPanel = new JPanel();
		SearchPanel.setBounds(0, 0, 1065, 626);
		frame.getContentPane().add(SearchPanel);
		SearchPanel.setVisible(false);
		SearchPanel.setLayout(null);
		String[] headers = new String[] { "Time", "Student Num", "Number of people" };
		String[][] data = coworking.getCoworking();

		JTable table = new JTable(data, headers);
		table.setRowHeight(30);
		table.setFont(new Font("Sanserif", Font.BOLD, 15));
		table.setAlignmentX(0);
		table.setSize(800, 600);
		table.setPreferredScrollableViewportSize(new Dimension(800, 600));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(6, 121, 1035, 422);
		SearchPanel.add(scrollPane);

		JLabel label_checkpage = new JLabel("\uB098\uC758 \uC608\uC57D \uC870\uD68C \uCC3D");
		label_checkpage.setFont(new Font("NanumGothic", Font.PLAIN, 30));
		label_checkpage.setBounds(398, 47, 283, 62);
		SearchPanel.add(label_checkpage);

		JButton HomeButton = new JButton("HOME");
		HomeButton.setBounds(499, 555, 117, 37);
		SearchPanel.add(HomeButton);
		
		
		
		
		// 조회하기 패널
		JPanel SearchPanelmu = new JPanel();
		SearchPanelmu.setBounds(0, 0, 1065, 626);
		frame.getContentPane().add(SearchPanelmu);
		SearchPanelmu.setVisible(false);
		SearchPanelmu.setLayout(null);
		String[] headersmu = new String[] { "Time", "Student Num", "Number of people" };
		String[][] datamu = muhan.getMuhan();

		JTable tablemu = new JTable(datamu, headersmu);
		tablemu.setRowHeight(30);
		tablemu.setFont(new Font("Sanserif", Font.BOLD, 15));
		tablemu.setAlignmentX(0);
		tablemu.setSize(800, 600);
		tablemu.setPreferredScrollableViewportSize(new Dimension(800, 600));

		JScrollPane scrollPanemu = new JScrollPane(tablemu);
		scrollPanemu.setBounds(6, 121, 1035, 422);
		SearchPanelmu.add(scrollPanemu);

		JLabel label_checkpagemu = new JLabel("\uB098\uC758 \uC608\uC57D \uC870\uD68C \uCC3D");
		label_checkpagemu.setFont(new Font("NanumGothic", Font.PLAIN, 30));
		label_checkpagemu.setBounds(398, 47, 283, 62);
		SearchPanelmu.add(label_checkpagemu);

		JButton HomeButtonmu = new JButton("HOME");
		HomeButtonmu.setBounds(499, 555, 117, 37);
		SearchPanelmu.add(HomeButtonmu);
		
		
		
		
		// 조회하기 패널
				JPanel SearchPanelcon = new JPanel();
				SearchPanelcon.setBounds(0, 0, 1065, 626);
				frame.getContentPane().add(SearchPanelcon);
				SearchPanelcon.setVisible(false);
				SearchPanelcon.setLayout(null);
				String[] headerscon = new String[] { "Time", "Student Num", "Number of people" };
				String[][] datacon = consulting.getconsulting();

				JTable tablecon = new JTable(datamu, headersmu);
				tablecon.setRowHeight(30);
				tablecon.setFont(new Font("Sanserif", Font.BOLD, 15));
				tablecon.setAlignmentX(0);
				tablecon.setSize(800, 600);
				tablecon.setPreferredScrollableViewportSize(new Dimension(800, 600));

				JScrollPane scrollPanecon = new JScrollPane(tablecon);
				scrollPanecon.setBounds(6, 121, 1035, 422);
				SearchPanelcon.add(scrollPanecon);

				JLabel label_checkpagecon = new JLabel("\uB098\uC758 \uC608\uC57D \uC870\uD68C \uCC3D");
				label_checkpagecon.setFont(new Font("NanumGothic", Font.PLAIN, 30));
				label_checkpagecon.setBounds(398, 47, 283, 62);
				SearchPanelcon.add(label_checkpagecon);

				JButton HomeButtoncon = new JButton("HOME");
				HomeButtoncon.setBounds(499, 555, 117, 37);
				SearchPanelcon.add(HomeButtoncon);

// 나의 예약창
		JPanel myCheck = new JPanel();
		myCheck.setBounds(0, 0, 1047, 606);
		frame.getContentPane().add(myCheck);
		myCheck.setLayout(null);
		// 예약자수 확인 버튼을 누르기 전까지 나의 예약창을 안보이게 함.
		myCheck.setVisible(false);

		JLabel mytext = new JLabel("\uB098\uC758 \uC608\uC57D \uD655\uC778\uCC3D");
		mytext.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 26));
		mytext.setBounds(397, 52, 280, 31);
		myCheck.add(mytext);

		JLabel lblNewLabel_3 = new JLabel("\uC608\uC57D\uC7A5\uC18C : ");
		lblNewLabel_3.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(141, 210, 118, 31);
		myCheck.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\uC608\uC57D\uC2DC\uAC04 : ");
		lblNewLabel_4.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(141, 309, 146, 42);
		myCheck.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("\uC608\uC57D \uC778\uC6D0 \uC218 : ");
		lblNewLabel_5.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(113, 418, 146, 36);
		myCheck.add(lblNewLabel_5);

		JButton btnNewButton_2 = new JButton("\uB2EB\uAE30 ");
		btnNewButton_2.setFont(new Font("HY목각파임B", Font.PLAIN, 12));
		btnNewButton_2.setBounds(473, 537, 97, 23);
		myCheck.add(btnNewButton_2);

		JLabel label_inputplace = new JLabel("장소");
		label_inputplace.setHorizontalAlignment(SwingConstants.CENTER);
		label_inputplace.setBounds(397, 220, 173, 31);
		myCheck.add(label_inputplace);

		JLabel label_inputdate = new JLabel("시간");
		label_inputdate.setHorizontalAlignment(SwingConstants.CENTER);
		label_inputdate.setBounds(397, 325, 199, 48);
		myCheck.add(label_inputdate);

		JLabel label_inputpnum = new JLabel("인원 수");
		label_inputpnum.setHorizontalAlignment(SwingConstants.CENTER);
		label_inputpnum.setBounds(397, 431, 123, 23);
		myCheck.add(label_inputpnum);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

// 예약자 수 패널
		JPanel reservationmu = new JPanel();
		reservationmu.setBounds(0, 0, 1047, 606);
		frame.getContentPane().add(reservationmu);
		reservationmu.setLayout(null);
// 시간버튼을 누르기 전까지 예약자 수 창을 안보이게 함.
		reservationmu.setVisible(false);

		JLabel lblNewLabel_mu = new JLabel("\uC608\uC57D");
		lblNewLabel_mu.setFont(new Font("맑은고딕", Font.BOLD, 35));
		lblNewLabel_mu.setBounds(468, 40, 187, 73);
		reservationmu.add(lblNewLabel_mu);

		JTextField textFieldmu = new JTextField();
		textFieldmu.setBounds(299, 244, 580, 73);
		reservationmu.add(textFieldmu);
		textFieldmu.setColumns(10);

		JLabel lblNewLabel_2mu = new JLabel("\uC608\uC57D\uC790 \uC218 : ");
		lblNewLabel_2mu.setFont(new Font("맑은고딕", Font.PLAIN, 25));
		lblNewLabel_2mu.setBounds(146, 265, 141, 23);
		reservationmu.add(lblNewLabel_2mu);

		JButton reButtonmu = new JButton("\uD655\uC778");
		reButtonmu.setBackground(new Color(129, 193, 71));
		reButtonmu.setBounds(438, 433, 147, 46);
		reservationmu.add(reButtonmu);

		reButtonmu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setPnum(textFieldmu.getText());
				System.out.println("무한상상카페 인원 수 입력.");
				muhan.createMuhan(Muhan.getId(), Muhan.getSnum(), Muhan.getPnum());
				label_inputplace.setText("무한상상카페");
				label_inputdate.setText(Muhan.getId());
				label_inputpnum.setText(Muhan.getPnum());
				// 예약자수가 없어지고 나의 확인창이 뜸
				reservationmu.setVisible(false);
				myCheck.setVisible(true);

			}
		});

		JPanel reservationcon = new JPanel();
		reservationcon.setBounds(0, 0, 1047, 606);
		frame.getContentPane().add(reservationcon);
		reservationcon.setLayout(null);
// 시간버튼을 누르기 전까지 예약자 수 창을 안보이게 함.
		reservationcon.setVisible(false);

		JLabel lblNewLabel_1con = new JLabel("\uC608\uC57D");
		lblNewLabel_1con.setFont(new Font("맑은고딕", Font.BOLD, 35));
		lblNewLabel_1con.setBounds(468, 40, 187, 73);
		reservationcon.add(lblNewLabel_1con);

		JTextField textFieldcon = new JTextField();
		textFieldcon.setBounds(299, 244, 580, 73);
		reservationcon.add(textFieldcon);
		textFieldcon.setColumns(10);

		JLabel lblNewLabel_2con = new JLabel("\uC608\uC57D\uC790 \uC218 : ");
		lblNewLabel_2con.setFont(new Font("맑은고딕", Font.PLAIN, 25));
		lblNewLabel_2con.setBounds(146, 265, 141, 23);
		reservationcon.add(lblNewLabel_2con);

		JButton reButtoncon = new JButton("\uD655\uC778");
		reButtoncon.setBackground(new Color(129, 193, 71));
		reButtoncon.setBounds(438, 433, 147, 46);
		reservationcon.add(reButtoncon);

		reButtoncon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setPnum(textFieldcon.getText());
				System.out.println("컨설팅룸 인원 수 입력.");
				Consulting.createConsulting(Consulting.getId(), Consulting.getSnum(), Consulting.getPnum());
				label_inputplace.setText("컨설팅룸");
				label_inputdate.setText(Consulting.getId());
				label_inputpnum.setText(Consulting.getPnum());
// 예약자수가 없어지고 나의 확인창이 뜸
				reservationcon.setVisible(false);
				myCheck.setVisible(true);
			}
		});
		JPanel reservation = new JPanel();
		reservation.setBounds(0, 0, 1047, 606);
		frame.getContentPane().add(reservation);
		reservation.setLayout(null);
// 시간버튼을 누르기 전까지 예약자 수 창을 안보이게 함.
		reservation.setVisible(false);

		JLabel lblNewLabel_1 = new JLabel("\uC608\uC57D");
		lblNewLabel_1.setFont(new Font("맑은고딕", Font.BOLD, 35));
		lblNewLabel_1.setBounds(468, 40, 187, 73);
		reservation.add(lblNewLabel_1);

		JTextField textField = new JTextField();
		textField.setBounds(299, 244, 580, 73);
		reservation.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\uC608\uC57D\uC790 \uC218 : ");
		lblNewLabel_2.setFont(new Font("맑은고딕", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(146, 265, 141, 23);
		reservation.add(lblNewLabel_2);

		JButton reButton = new JButton("\uD655\uC778");
		reButton.setBackground(new Color(129, 193, 71));
		reButton.setBounds(438, 433, 147, 46);
		reservation.add(reButton);

		reButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setPnum(textField.getText());
				System.out.println("코워킹 스페이스 인원 수 입력.");
				coworking.createCoworking(Coworking.getId(), Coworking.getSnum(), Coworking.getPnum());
				label_inputplace.setText("코워킹 스페이스");
				label_inputdate.setText(Coworking.getId());
				label_inputpnum.setText(Coworking.getPnum());
				reservation.setVisible(false);
				myCheck.setVisible(true);
			}
		});
// 무한상상카페 시간 테이블
		JPanel TimeMuhan = new JPanel();
		TimeMuhan.setBounds(0, 0, 1047, 606);
		frame.getContentPane().add(TimeMuhan);
		TimeMuhan.setLayout(null);
		TimeMuhan.setVisible(false);

		JLabel lblNewLabel_7 = new JLabel("\uBB34\uD55C\uC0C1\uC0C1\uCE74\uD398 \uC2DC\uAC04\uD45C");
		lblNewLabel_7.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 25));
		lblNewLabel_7.setBounds(395, 10, 275, 54);
		TimeMuhan.add(lblNewLabel_7);

		JButton Lunch_1101 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		Lunch_1101.setBackground(new Color(129, 193, 71));
		Lunch_1101.setBounds(863, 49, 97, 23);
		TimeMuhan.add(Lunch_1101);
		Lunch_1101.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1101 lunch");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println("1일 점심 시간.");
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		JLabel Lavel_1101 = new JLabel("11/1");
		Lavel_1101.setBounds(863, 24, 57, 15);
		TimeMuhan.add(Lavel_1101);

		JButton Dinner_1101 = new JButton("\uC800\uB141\uC2DC\uAC04");
		Dinner_1101.setBounds(863, 84, 97, 23);
		Dinner_1101.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Dinner_1101);
		Dinner_1101.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1101 dinner");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println("1일 저녁 시간.");
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JLabel Lavel_1104 = new JLabel("4");
		Lavel_1104.setBounds(45, 145, 57, 15);
		TimeMuhan.add(Lavel_1104);

		JButton Lunch_1104 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		Lunch_1104.setBounds(45, 170, 97, 23);
		Lunch_1104.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Lunch_1104);
		Lunch_1104.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1104 lunch");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println("4일 점심 시간.");
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton Dinner_1104 = new JButton("\uC800\uB141\uC2DC\uAC04");
		Dinner_1104.setBounds(45, 203, 97, 23);
		Dinner_1104.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Dinner_1104);
		Dinner_1104.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1104 dinner");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println("4일 저녁 시간.");
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton Lunch_1111 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		Lunch_1111.setBounds(45, 270, 97, 23);
		Lunch_1111.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Lunch_1111);
		Lunch_1111.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1111 lunch");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println("11일 점심 시간.");
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JLabel Lavel_1111 = new JLabel("11");
		Lavel_1111.setBounds(45, 245, 57, 15);
		TimeMuhan.add(Lavel_1111);

		JButton Dinner_1111 = new JButton("\uC800\uB141\uC2DC\uAC04");
		Dinner_1111.setBounds(45, 303, 97, 23);
		Dinner_1111.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Dinner_1111);
		Dinner_1111.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1111 dinner");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println("11일 저녁 시간.");
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton Lunch_1118 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		Lunch_1118.setBounds(45, 373, 97, 23);
		Lunch_1118.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Lunch_1118);
		Lunch_1118.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1118 lunch");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println("18일 점심 시간.");
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JLabel Lavel_1118 = new JLabel("18");
		Lavel_1118.setBounds(45, 348, 57, 15);
		TimeMuhan.add(Lavel_1118);

		JButton Dinner_1118 = new JButton("\uC800\uB141\uC2DC\uAC04");
		Dinner_1118.setBounds(45, 406, 97, 23);
		Dinner_1118.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Dinner_1118);
		Dinner_1118.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1118 dinner");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println("18일 저녁 시간.");
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton Lunch_1125 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		Lunch_1125.setBounds(45, 473, 97, 23);
		Lunch_1125.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Lunch_1125);
		Lunch_1125.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1125 lunch");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println("25일 점심 시간.");
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JLabel Level_1125 = new JLabel("25");
		Level_1125.setBounds(45, 448, 57, 15);
		TimeMuhan.add(Level_1125);

		JButton Dinner_1125 = new JButton("\uC800\uB141\uC2DC\uAC04");
		Dinner_1125.setBounds(45, 506, 97, 23);
		Dinner_1125.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Dinner_1125);
		Dinner_1125.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1125 dinner");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println("25일 저녁 시간.");
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JLabel Lavel_1105 = new JLabel("5");
		Lavel_1105.setBounds(221, 145, 57, 15);
		TimeMuhan.add(Lavel_1105);

		JButton Lunch_1105 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		Lunch_1105.setBounds(221, 170, 97, 23);
		Lunch_1105.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Lunch_1105);
		Lunch_1105.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1105 lunch");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println("5일 점심 시간.");
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton Dinner_1105 = new JButton("\uC800\uB141\uC2DC\uAC04");
		Dinner_1105.setBounds(221, 203, 97, 23);
		Dinner_1105.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Dinner_1105);
		Dinner_1105.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1105 dinner");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println("5일 저녁 시간.");
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JLabel Lavel_1112 = new JLabel("12");
		Lavel_1112.setBounds(221, 245, 57, 15);
		TimeMuhan.add(Lavel_1112);

		JButton Lunch_1112 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		Lunch_1112.setBounds(221, 270, 97, 23);
		Lunch_1112.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Lunch_1112);
		Lunch_1112.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1112 lunch");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println("12일 lunch 시간.");
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton Dinner_1112 = new JButton("\uC800\uB141\uC2DC\uAC04");
		Dinner_1112.setBounds(221, 303, 97, 23);
		Dinner_1112.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Dinner_1112);
		Dinner_1112.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1112 dinner");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println("12일 저녁 시간.");
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		JLabel Level_1119 = new JLabel("19");
		Level_1119.setBounds(221, 348, 57, 15);
		TimeMuhan.add(Level_1119);

		JButton Lunch_1119 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		Lunch_1119.setBounds(221, 373, 97, 23);
		Lunch_1119.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Lunch_1119);
		Lunch_1119.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1119 lunch");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println("19일 lunch 시간.");
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton Dinner_1119 = new JButton("\uC800\uB141\uC2DC\uAC04");
		Dinner_1119.setBounds(221, 406, 97, 23);
		Dinner_1119.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Dinner_1119);
		Dinner_1119.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1119 dinner");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println("19일 저녁 시간.");
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JLabel Level_1126 = new JLabel("26");
		Level_1126.setBounds(221, 448, 57, 15);
		TimeMuhan.add(Level_1126);

		JButton Lunch_1126 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		Lunch_1126.setBounds(221, 473, 97, 23);
		Lunch_1126.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Lunch_1126);
		Lunch_1126.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1126 lunch");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println("26일 lunch 시간.");
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton Dinner_1126 = new JButton("\uC800\uB141\uC2DC\uAC04");
		Dinner_1126.setBounds(221, 506, 97, 23);
		Dinner_1126.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Dinner_1126);
		Dinner_1126.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1126 dinner");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println("26일 저녁 시간.");
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JLabel Level_1106 = new JLabel("6");
		Level_1106.setBounds(392, 145, 57, 15);
		TimeMuhan.add(Level_1106);

		JButton Lunch_1106 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		Lunch_1106.setBounds(395, 170, 97, 23);
		Lunch_1106.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Lunch_1106);
		Lunch_1106.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1106 lunch");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println("6일 lunch 시간.");
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton Dinner_1106 = new JButton("\uC800\uB141\uC2DC\uAC04");
		Dinner_1106.setBounds(395, 203, 97, 23);
		Dinner_1106.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Dinner_1106);
		Dinner_1106.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1106 dinner");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println("6일 dinner 시간.");
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JLabel Level_1113 = new JLabel("13");
		Level_1113.setBounds(392, 245, 57, 15);
		TimeMuhan.add(Level_1113);

		JButton Lunch_1113 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		Lunch_1113.setBounds(395, 270, 97, 23);
		Lunch_1113.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Lunch_1113);
		Lunch_1113.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1113 lunch");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println("13일 lunch 시간.");
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton Dinner_1113 = new JButton("\uC800\uB141\uC2DC\uAC04");
		Dinner_1113.setBounds(395, 303, 97, 23);
		Dinner_1113.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Dinner_1113);
		Dinner_1113.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1113 dinner");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println("13일 dinner 시간.");
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JLabel Level_1120 = new JLabel("20");
		Level_1120.setBounds(392, 348, 57, 15);
		TimeMuhan.add(Level_1120);

		JButton Lunch_1120 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		Lunch_1120.setBounds(395, 373, 97, 23);
		Lunch_1120.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Lunch_1120);
		Lunch_1120.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1120 lunch");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println("20일 lunch 시간.");
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton Dinner_1120 = new JButton("\uC800\uB141\uC2DC\uAC04");
		Dinner_1120.setBounds(395, 406, 97, 23);
		Dinner_1120.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Dinner_1120);
		Dinner_1120.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1120 dinner");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println(Muhan.getId());
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JLabel Level_1127 = new JLabel("27");
		Level_1127.setBounds(392, 448, 57, 15);
		TimeMuhan.add(Level_1127);

		JButton Lunch_1127 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		Lunch_1127.setBounds(395, 473, 97, 23);
		Lunch_1127.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Lunch_1127);
		Lunch_1127.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1127 lunch");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println(Muhan.getId());
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton Dinner_1127 = new JButton("\uC800\uB141\uC2DC\uAC04");
		Dinner_1127.setBounds(395, 506, 97, 23);
		Dinner_1127.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Dinner_1127);
		Dinner_1127.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1127 dinner");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println(Muhan.getId());
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton After_1106 = new JButton("\uBC29\uACFC\uD6C4 A");
		After_1106.setBounds(496, 170, 104, 56);
		After_1106.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(After_1106);
		After_1106.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1106 afterschool");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println(Muhan.getId());
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton After_1113 = new JButton("\uBC29\uACFC\uD6C4 A");
		After_1113.setBounds(496, 270, 104, 56);
		After_1113.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(After_1113);
		After_1113.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1113 afterschool");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println(Muhan.getId());
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton After_1120 = new JButton("\uBC29\uACFC\uD6C4 A");
		After_1120.setBounds(496, 373, 104, 56);
		After_1120.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(After_1120);
		After_1120.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1120 afterschool");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println(Muhan.getId());
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton After_1127 = new JButton("\uBC29\uACFC\uD6C4 A");
		After_1127.setBounds(496, 473, 104, 56);
		After_1127.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(After_1127);
		After_1127.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1127 afterschool");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println(Muhan.getId());
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JLabel Level_1107 = new JLabel("7");
		Level_1107.setBounds(670, 145, 57, 15);
		TimeMuhan.add(Level_1107);

		JButton Lunch_1107 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		Lunch_1107.setBounds(670, 170, 97, 23);
		Lunch_1107.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Lunch_1107);
		Lunch_1107.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1107 lunch");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println(Muhan.getId());
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton Dinner_1107 = new JButton("\uC800\uB141\uC2DC\uAC04");
		Dinner_1107.setBounds(670, 203, 97, 23);
		Dinner_1107.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Dinner_1107);
		Dinner_1107.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1107 dinner");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println(Muhan.getId());
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JLabel Level_1114 = new JLabel("14");
		Level_1114.setBounds(670, 245, 57, 15);
		TimeMuhan.add(Level_1114);

		JButton Lunch_1114 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		Lunch_1114.setBounds(670, 270, 97, 23);
		Lunch_1114.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Lunch_1114);
		Lunch_1114.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1114 lunch");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println(Muhan.getId());
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton Dinner_1114 = new JButton("\uC800\uB141\uC2DC\uAC04");
		Dinner_1114.setBounds(670, 303, 97, 23);
		Dinner_1114.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Dinner_1114);
		Dinner_1114.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1114 dinner");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println(Muhan.getId());
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JLabel label_1 = new JLabel("21");
		label_1.setBounds(670, 348, 57, 15);
		TimeMuhan.add(label_1);

		JButton Lunch_1121 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		Lunch_1121.setBounds(670, 373, 97, 23);
		Lunch_1121.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Lunch_1121);
		Lunch_1121.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1121 lunch");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println(Muhan.getId());
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton Dinner_1121 = new JButton("\uC800\uB141\uC2DC\uAC04");
		Dinner_1121.setBounds(670, 406, 97, 23);
		Dinner_1121.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Dinner_1121);
		Dinner_1121.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1121 dinner");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println(Muhan.getId());
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JLabel label_2 = new JLabel("28");
		label_2.setBounds(670, 448, 57, 15);
		TimeMuhan.add(label_2);

		JButton Lunch_1128 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		Lunch_1128.setBounds(670, 473, 97, 23);
		Lunch_1128.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Lunch_1128);
		Lunch_1128.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1128 lunch");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println(Muhan.getId());
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton Dinner_1128 = new JButton("\uC800\uB141\uC2DC\uAC04");
		Dinner_1128.setBounds(670, 506, 97, 23);
		Dinner_1128.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Dinner_1128);
		Dinner_1128.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1128 dinner");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println(Muhan.getId());
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JLabel Level_1108 = new JLabel("8");
		Level_1108.setBounds(863, 145, 57, 15);
		TimeMuhan.add(Level_1108);

		JButton Lunch_1108 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		Lunch_1108.setBounds(863, 170, 97, 23);
		Lunch_1108.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Lunch_1108);
		Lunch_1108.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1108 lunch");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println(Muhan.getId());
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton Dinner_1108 = new JButton("\uC800\uB141\uC2DC\uAC04");
		Dinner_1108.setBounds(863, 203, 97, 23);
		Dinner_1108.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Dinner_1108);
		Dinner_1108.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1108 dinner");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println(Muhan.getId());
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JLabel Level_1115 = new JLabel("15");
		Level_1115.setBounds(863, 245, 57, 15);
		TimeMuhan.add(Level_1115);

		JButton Lunch_1115 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		Lunch_1115.setBounds(863, 270, 97, 23);
		Lunch_1115.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Lunch_1115);
		Lunch_1115.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1115 lunch");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println(Muhan.getId());
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton Dinner_1115 = new JButton("\uC800\uB141\uC2DC\uAC04");
		Dinner_1115.setBounds(863, 303, 97, 23);
		Dinner_1115.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Dinner_1115);
		Dinner_1115.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1115 dinner");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println(Muhan.getId());
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JLabel Level_1122 = new JLabel("22");
		Level_1122.setBounds(863, 348, 57, 15);
		TimeMuhan.add(Level_1122);

		JButton Lunch_1122 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		Lunch_1122.setBounds(863, 373, 97, 23);
		Lunch_1122.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Lunch_1122);
		Lunch_1122.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1122 lunch");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println(Muhan.getId());
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton Dinner_1122 = new JButton("\uC800\uB141\uC2DC\uAC04");
		Dinner_1122.setBounds(863, 406, 97, 23);
		Dinner_1122.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Dinner_1122);
		Dinner_1122.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1122 dinner");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println(Muhan.getId());
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JLabel Level_1129 = new JLabel("29");
		Level_1129.setBounds(863, 448, 57, 15);
		TimeMuhan.add(Level_1129);

		JButton Lunch_1129 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		Lunch_1129.setBounds(863, 473, 97, 23);
		Lunch_1129.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Lunch_1129);
		Lunch_1129.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1129 lunch");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println(Muhan.getId());
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton Dinner_1129 = new JButton("\uC800\uB141\uC2DC\uAC04");
		Dinner_1129.setBounds(863, 506, 97, 23);
		Dinner_1129.setBackground(new Color(129, 193, 71));
		TimeMuhan.add(Dinner_1129);
		Dinner_1129.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Muhan.setId("1129 dinner");
				try {
					if (muhan.search(Muhan.getId())) {
						JOptionPane.showMessageDialog(null, "이미 예약된 시간대입니다.");

					} else {
						System.out.println(Muhan.getId());
						TimeMuhan.setVisible(false);
						reservationmu.setVisible(true);
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		// 컨설팅룸 창
		JPanel TimeConsulting = new JPanel();
		TimeConsulting.setBounds(0, 0, 1047, 606);
		frame.getContentPane().add(TimeConsulting);
		TimeConsulting.setLayout(null);
		TimeConsulting.setVisible(false);

		JLabel consultingLavel = new JLabel("\uCEE8\uC124\uD305\uB8F8 \uC2DC\uAC04\uD45C");
		consultingLavel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 25));
		consultingLavel.setBounds(440, 10, 175, 40);
		TimeConsulting.add(consultingLavel);

		JLabel conLavel_1101 = new JLabel("11/1");
		conLavel_1101.setBounds(876, 47, 57, 15);
		TimeConsulting.add(conLavel_1101);

		JButton ConL_1101 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		ConL_1101.setBounds(874, 66, 97, 23);
		ConL_1101.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConL_1101);
		ConL_1101.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1101 lunch");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton ConD_1101 = new JButton("\uC800\uB141\uC2DC\uAC04");
		ConD_1101.setBounds(876, 99, 97, 23);
		ConD_1101.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConD_1101);
		ConD_1101.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1101 dinner");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel ConLavel_1104 = new JLabel("4");
		ConLavel_1104.setBounds(47, 145, 57, 15);
		TimeConsulting.add(ConLavel_1104);

		JButton ConL_1104 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		ConL_1104.setBounds(43, 170, 97, 23);
		ConL_1104.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConL_1104);
		ConL_1104.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1104 lunch");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton ConD_1104 = new JButton("\uC800\uB141\uC2DC\uAC04");
		ConD_1104.setBounds(43, 203, 97, 23);
		ConD_1104.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConD_1104);
		ConD_1104.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1104 dinner");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});
		JLabel ConLevel_1105 = new JLabel("5");
		ConLevel_1105.setBounds(217, 145, 57, 15);
		TimeConsulting.add(ConLevel_1105);

		JButton ConL_1105 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		ConL_1105.setBounds(217, 170, 97, 23);
		ConL_1105.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConL_1105);
		ConL_1105.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1105 lunch");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton ConD_1105 = new JButton("\uC800\uB141\uC2DC\uAC04");
		ConD_1105.setBounds(217, 203, 97, 23);
		ConD_1105.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConD_1105);
		ConD_1105.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1105 dinner");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel ConLavel_1106 = new JLabel("6");
		ConLavel_1106.setBounds(398, 145, 57, 15);
		TimeConsulting.add(ConLavel_1106);

		JButton ConL_1106 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		ConL_1106.setBounds(398, 170, 97, 23);
		ConL_1106.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConL_1106);
		ConL_1106.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1106 lunch");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});
		JButton ConD_1106 = new JButton("\uC800\uB141\uC2DC\uAC04");
		ConD_1106.setBounds(398, 203, 97, 23);
		ConD_1106.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConD_1106);
		ConD_1106.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1106 dinner");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton ConA_1106 = new JButton("\uBC29\uACFC\uD6C4 A");
		ConA_1106.setBounds(499, 170, 87, 56);
		ConA_1106.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConA_1106);
		ConA_1106.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1106 afterschool");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel ConLavel_1107 = new JLabel("7");
		ConLavel_1107.setBounds(670, 145, 57, 15);
		TimeConsulting.add(ConLavel_1107);

		JButton ConL_1107 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		ConL_1107.setBounds(670, 170, 97, 23);
		ConL_1107.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConL_1107);
		ConL_1107.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1107 lunch");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton ConD_1107 = new JButton("\uC800\uB141\uC2DC\uAC04");
		ConD_1107.setBounds(670, 203, 97, 23);
		ConD_1107.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConD_1107);
		ConD_1107.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1107 dinner");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel ConLavel_1108 = new JLabel("8");
		ConLavel_1108.setBounds(876, 145, 57, 15);
		TimeConsulting.add(ConLavel_1108);

		JButton ConL_1108 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		ConL_1108.setBounds(874, 170, 97, 23);
		ConL_1108.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConL_1108);
		ConL_1108.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1108 lunch");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton ConD_1108 = new JButton("\uC800\uB141\uC2DC\uAC04");
		ConD_1108.setBounds(874, 203, 97, 23);
		ConD_1108.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConD_1108);
		ConD_1108.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1108 dinner");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel ConLavel_1111 = new JLabel("11");
		ConLavel_1111.setBounds(47, 262, 57, 15);
		TimeConsulting.add(ConLavel_1111);

		JButton ConL_1111 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		ConL_1111.setBounds(47, 287, 97, 23);
		ConL_1111.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConL_1111);
		ConL_1111.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1111 lunch");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton ConD_1111 = new JButton("\uC800\uB141\uC2DC\uAC04");
		ConD_1111.setBounds(47, 320, 97, 23);
		ConD_1111.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConD_1111);
		ConD_1111.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1111 dinner");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel ConLavel_1112 = new JLabel("12");
		ConLavel_1112.setBounds(217, 262, 57, 15);
		TimeConsulting.add(ConLavel_1112);

		JButton ConL_1112 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		ConL_1112.setBounds(217, 287, 97, 23);
		ConL_1112.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConL_1112);
		ConL_1112.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1112 lunch");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});
		JButton ConD_1112 = new JButton("\uC800\uB141\uC2DC\uAC04");
		ConD_1112.setBounds(217, 320, 97, 23);
		ConD_1112.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConD_1112);
		ConD_1112.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1112 dinner");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel ConLavel_1113 = new JLabel("13");
		ConLavel_1113.setBounds(398, 262, 57, 15);
		TimeConsulting.add(ConLavel_1113);

		JButton ConL_1113 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		ConL_1113.setBounds(398, 287, 97, 23);
		ConL_1113.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConL_1113);
		ConL_1113.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1113 lunch");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton ConD_1113 = new JButton("\uC800\uB141\uC2DC\uAC04");
		ConD_1113.setBounds(398, 320, 97, 23);
		ConD_1113.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConD_1113);
		ConD_1113.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1113 dinner");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton ConA_1113 = new JButton("\uBC29\uACFC\uD6C4 A");
		ConA_1113.setBounds(499, 287, 87, 56);
		ConA_1113.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConA_1113);
		ConA_1113.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1113 afterschool");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel ConLavel_1114 = new JLabel("14");
		ConLavel_1114.setBounds(670, 262, 57, 15);
		TimeConsulting.add(ConLavel_1114);

		JButton ConL_1114 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		ConL_1114.setBounds(670, 287, 97, 23);
		ConL_1114.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConL_1114);
		ConL_1114.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1114 lunch");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton ConD_1114 = new JButton("\uC800\uB141\uC2DC\uAC04");
		ConD_1114.setBounds(670, 320, 97, 23);
		ConD_1114.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConD_1114);
		ConD_1114.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1114 dinner");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel ConLavel_1115 = new JLabel("15");
		ConLavel_1115.setBounds(876, 262, 57, 15);
		TimeConsulting.add(ConLavel_1115);

		JButton ConL_1115 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		ConL_1115.setBounds(876, 287, 97, 23);
		ConL_1115.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConL_1115);
		ConL_1115.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1115 lunch");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton ConD_1115 = new JButton("\uC800\uB141\uC2DC\uAC04");
		ConD_1115.setBounds(876, 320, 97, 23);
		ConD_1115.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConD_1115);
		ConD_1115.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1115 dinner");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel ConLavel_1118 = new JLabel("18");
		ConLavel_1118.setBounds(47, 375, 57, 15);
		TimeConsulting.add(ConLavel_1118);

		JButton ConL_1118 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		ConL_1118.setBounds(47, 400, 97, 23);
		ConL_1118.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConL_1118);
		ConL_1118.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1118 lunch");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton ConD_1118 = new JButton("\uC800\uB141\uC2DC\uAC04");
		ConD_1118.setBounds(47, 433, 97, 23);
		ConD_1118.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConD_1118);
		ConD_1118.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1118 dinner");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel ConLavel_1119 = new JLabel("19");
		ConLavel_1119.setBounds(217, 375, 57, 15);
		TimeConsulting.add(ConLavel_1119);

		JButton ConL_1119 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		ConL_1119.setBounds(217, 400, 97, 23);
		ConL_1119.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConL_1119);
		ConL_1119.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1119 lunch");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});
		JButton ConD_1119 = new JButton("\uC800\uB141\uC2DC\uAC04");
		ConD_1119.setBounds(217, 433, 97, 23);
		ConD_1119.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConD_1119);
		ConD_1119.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1119 dinner");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel ConLavel_1120 = new JLabel("20");
		ConLavel_1120.setBounds(398, 375, 57, 15);
		TimeConsulting.add(ConLavel_1120);

		JButton ConL_1120 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		ConL_1120.setBounds(398, 400, 97, 23);
		ConL_1120.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConL_1120);
		ConL_1120.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1120 lunch");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton ConD_1120 = new JButton("\uC800\uB141\uC2DC\uAC04");
		ConD_1120.setBounds(398, 433, 97, 23);
		ConD_1120.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConD_1120);
		ConD_1120.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1120 dinner");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton ConA_1120 = new JButton("\uBC29\uACFC\uD6C4 A");
		ConA_1120.setBounds(499, 400, 87, 56);
		ConA_1120.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConA_1120);
		ConA_1120.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1120 afterschool");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel ConLavel_1121 = new JLabel("21");
		ConLavel_1121.setBounds(670, 375, 57, 15);
		TimeConsulting.add(ConLavel_1121);

		JButton ConL_1121 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		ConL_1121.setBounds(670, 400, 97, 23);
		ConL_1121.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConL_1121);
		ConL_1121.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1121 lunch");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton ConD_1121 = new JButton("\uC800\uB141\uC2DC\uAC04");
		ConD_1121.setBounds(670, 433, 97, 23);
		ConD_1121.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConD_1121);
		ConD_1121.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1121 dinner");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel ConLavel_1122 = new JLabel("22");
		ConLavel_1122.setBounds(876, 375, 57, 15);
		TimeConsulting.add(ConLavel_1122);

		JButton ConL_1122 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		ConL_1122.setBounds(876, 400, 97, 23);
		ConL_1122.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConL_1122);
		ConL_1122.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1122 lunch");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton ConD_1122 = new JButton("\uC800\uB141\uC2DC\uAC04");
		ConD_1122.setBounds(876, 433, 97, 23);
		ConD_1122.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConD_1122);
		ConD_1122.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1122 dinner");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel ConLavel_1125 = new JLabel("25");
		ConLavel_1125.setBounds(47, 486, 57, 15);
		TimeConsulting.add(ConLavel_1125);

		JButton ConL_1125 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		ConL_1125.setBounds(47, 506, 97, 23);
		ConL_1125.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConL_1125);
		ConL_1125.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1125 lunch");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton ConD_1125 = new JButton("\uC800\uB141\uC2DC\uAC04");
		ConD_1125.setBounds(47, 539, 97, 23);
		ConD_1125.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConD_1125);
		ConD_1125.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1125 dinner");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel ConLavel_1126 = new JLabel("26");
		ConLavel_1126.setBounds(217, 486, 57, 15);
		TimeConsulting.add(ConLavel_1126);

		JButton ConL_1126 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		ConL_1126.setBounds(217, 506, 97, 23);
		ConL_1126.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConL_1126);
		ConL_1126.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1126 lunch");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton ConD_1126 = new JButton("\uC800\uB141\uC2DC\uAC04");
		ConD_1126.setBounds(217, 539, 97, 23);
		ConD_1126.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConD_1126);
		ConD_1126.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1126 dinner");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel ConLavel_1127 = new JLabel("27");
		ConLavel_1127.setBounds(398, 486, 57, 15);
		TimeConsulting.add(ConLavel_1127);

		JButton ConL_1127 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		ConL_1127.setBounds(398, 506, 97, 23);
		ConL_1127.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConL_1127);
		ConL_1127.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1127 lunch");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton ConD_1127 = new JButton("\uC800\uB141\uC2DC\uAC04");
		ConD_1127.setBounds(398, 539, 97, 23);
		ConD_1127.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConD_1127);
		ConD_1127.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1127 dinner");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton ConA_1127 = new JButton("\uBC29\uACFC\uD6C4 A");
		ConA_1127.setBounds(499, 506, 87, 56);
		ConA_1127.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConA_1127);
		ConA_1127.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1127 afterschool");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel ConLavel_1128 = new JLabel("28");
		ConLavel_1128.setBounds(670, 486, 57, 15);
		TimeConsulting.add(ConLavel_1128);

		JButton ConL_1128 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		ConL_1128.setBounds(670, 506, 97, 23);
		ConL_1128.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConL_1128);
		ConL_1128.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1128 lunch");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton ConD_1128 = new JButton("\uC800\uB141\uC2DC\uAC04");
		ConD_1128.setBounds(670, 539, 97, 23);
		ConD_1128.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConD_1128);
		ConD_1128.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1128 dinner");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel ConLavel_29 = new JLabel("29");
		ConLavel_29.setBounds(876, 486, 57, 15);
		TimeConsulting.add(ConLavel_29);

		JButton ConL_1129 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		ConL_1129.setBounds(876, 506, 97, 23);
		ConL_1129.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConL_1129);
		ConL_1129.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1129 lunch");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton ConD_1129 = new JButton("\uC800\uB141\uC2DC\uAC04");
		ConD_1129.setBounds(876, 539, 97, 23);
		ConD_1129.setBackground(new Color(129, 193, 71));
		TimeConsulting.add(ConD_1129);
		ConD_1129.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.setId("1129 dinner");
				try {
					try {
						if (consulting.search(Consulting.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Consulting.getId());
							TimeConsulting.setVisible(false);
							reservationcon.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});
		// 코워킹스페이스 창
		JPanel TimeCoworking = new JPanel();
		TimeCoworking.setBounds(0, 0, 1047, 606);
		frame.getContentPane().add(TimeCoworking);
		TimeCoworking.setLayout(null);
		TimeCoworking.setVisible(false);

		JLabel CoworkingLavel = new JLabel("\uCF54\uC6CC\uD0B9\uC2A4\uD398\uC774\uC2A4 \uC2DC\uAC04\uD45C");
		CoworkingLavel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 25));
		CoworkingLavel.setBounds(365, 10, 260, 47);
		TimeCoworking.add(CoworkingLavel);

		JLabel coLavel1101 = new JLabel("11/1");
		coLavel1101.setBounds(873, 30, 57, 15);
		TimeCoworking.add(coLavel1101);

		JLabel coLavel1104 = new JLabel("4");
		coLavel1104.setBounds(49, 129, 57, 15);
		TimeCoworking.add(coLavel1104);

		JButton coL_1104 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		coL_1104.setBounds(49, 153, 97, 23);
		coL_1104.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coL_1104);
		coL_1104.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1104 lunch");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton coD_1104 = new JButton("\uC800\uB141\uC2DC\uAC04");
		coD_1104.setBounds(49, 186, 97, 23);
		coD_1104.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coD_1104);
		coD_1104.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1104 dinner");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel coLavel1105 = new JLabel("5");
		coLavel1105.setBounds(231, 129, 57, 15);
		TimeCoworking.add(coLavel1105);

		JButton coL_1105 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		coL_1105.setBounds(228, 153, 97, 23);
		coL_1105.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coL_1105);
		coL_1105.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1105 lunch");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton coD1105 = new JButton("\uC800\uB141\uC2DC\uAC04");
		coD1105.setBounds(228, 186, 97, 23);
		coD1105.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coD1105);
		coD1105.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1105 dinner");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel coLavel1106 = new JLabel("6");
		coLavel1106.setBounds(413, 129, 57, 15);
		TimeCoworking.add(coLavel1106);

		JButton coL_1106 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		coL_1106.setBounds(407, 153, 97, 23);
		coL_1106.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coL_1106);
		coL_1106.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1106 lunch");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton coD_1106 = new JButton("\uC800\uB141\uC2DC\uAC04");
		coD_1106.setBounds(407, 186, 97, 23);
		coD_1106.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coD_1106);
		coD_1106.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1106 dinner");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton coA_1106 = new JButton("\uBC29\uACFC\uD6C4 A");
		coA_1106.setBounds(507, 153, 97, 56);
		coA_1106.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coA_1106);
		coA_1106.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1106 afterschool");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel coLavel1107 = new JLabel("7");
		coLavel1107.setBounds(678, 129, 57, 15);
		TimeCoworking.add(coLavel1107);

		JButton coL_1107 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		coL_1107.setBounds(676, 153, 97, 23);
		coL_1107.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coL_1107);
		coL_1107.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1107 lunch");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton coD_1107 = new JButton("\uC800\uB141\uC2DC\uAC04");
		coD_1107.setBounds(676, 186, 97, 23);
		coD_1107.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coD_1107);
		coD_1107.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1107 dinner");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton coL_1101 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		coL_1101.setBounds(873, 55, 97, 23);
		coL_1101.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coL_1101);
		coL_1101.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1101 lunch");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton coD_1101 = new JButton("\uC800\uB141\uC2DC\uAC04");
		coD_1101.setBounds(873, 88, 97, 23);
		coD_1101.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coD_1101);
		coD_1101.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1101 dinner");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel coLavel_1108 = new JLabel("8");
		coLavel_1108.setBounds(873, 129, 57, 15);
		TimeCoworking.add(coLavel_1108);

		JButton coL_1108 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		coL_1108.setBounds(873, 153, 97, 23);
		coL_1108.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coL_1108);
		coL_1108.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1108 lunch");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton coD_1108 = new JButton("\uC800\uB141\uC2DC\uAC04");
		coD_1108.setBounds(873, 186, 97, 23);
		coD_1108.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coD_1108);
		coD_1108.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1108 dinner");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel coLavel_1111 = new JLabel("11");
		coLavel_1111.setBounds(49, 256, 57, 15);
		TimeCoworking.add(coLavel_1111);

		JButton coL_1109 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		coL_1109.setBounds(49, 281, 97, 23);
		coL_1109.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coL_1109);
		coL_1109.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1109 lunch");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton coD_1109 = new JButton("\uC800\uB141\uC2DC\uAC04");
		coD_1109.setBounds(49, 314, 97, 23);
		coD_1109.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coD_1109);
		coD_1109.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1109 dinner");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel coLavel_1112 = new JLabel("12");
		coLavel_1112.setBounds(231, 256, 57, 15);
		TimeCoworking.add(coLavel_1112);

		JButton coL_1110 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		coL_1110.setBounds(228, 281, 97, 23);
		coL_1110.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coL_1110);
		coL_1110.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1110 lunch");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton coD_1110 = new JButton("\uC800\uB141\uC2DC\uAC04");
		coD_1110.setBounds(228, 314, 97, 23);
		coD_1110.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coD_1110);
		coD_1110.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1110 dinner");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel coLavel1113 = new JLabel("13");
		coLavel1113.setBounds(413, 256, 57, 15);
		TimeCoworking.add(coLavel1113);

		JButton coL_1111 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		coL_1111.setBounds(407, 281, 97, 23);
		coL_1111.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coL_1111);
		coL_1111.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1111 lunch");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton coD_1111 = new JButton("\uC800\uB141\uC2DC\uAC04");
		coD_1111.setBounds(407, 314, 97, 23);
		coD_1111.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coD_1111);
		coD_1111.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1111 dinner");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton coA1111 = new JButton("\uBC29\uACFC\uD6C4 A");
		coA1111.setBounds(507, 281, 97, 56);
		coA1111.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coA1111);
		coA1111.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1111 afterschool");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel coLavel1114 = new JLabel("14");
		coLavel1114.setBounds(678, 256, 57, 15);
		TimeCoworking.add(coLavel1114);

		JButton coL_1112 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		coL_1112.setBounds(676, 281, 97, 23);
		coL_1112.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coL_1112);
		coL_1112.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1112 lunch");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton coD_1112 = new JButton("\uC800\uB141\uC2DC\uAC04");
		coD_1112.setBounds(678, 314, 97, 23);
		coD_1112.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coD_1112);
		coD_1112.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1112 dinner");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel coLavel1115 = new JLabel("15");
		coLavel1115.setBounds(873, 256, 57, 15);
		TimeCoworking.add(coLavel1115);

		JButton coL_1113 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		coL_1113.setBounds(873, 281, 97, 23);
		coL_1113.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coL_1113);
		coL_1113.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1113 lunch");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton coD_1113 = new JButton("\uC800\uB141\uC2DC\uAC04");
		coD_1113.setBounds(873, 314, 97, 23);
		coD_1113.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coD_1113);
		coD_1113.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1113 dinner");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel coLavel1118 = new JLabel("18");
		coLavel1118.setBounds(49, 384, 57, 15);
		TimeCoworking.add(coLavel1118);

		JButton coL_1114 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		coL_1114.setBounds(49, 400, 97, 23);
		coL_1114.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coL_1114);
		coL_1114.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1114 lunch");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton coD_1114 = new JButton("\uC800\uB141\uC2DC\uAC04");
		coD_1114.setBounds(49, 433, 97, 23);
		coD_1114.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coD_1114);
		coD_1114.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1114 dinner");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel coLavel1119 = new JLabel("19");
		coLavel1119.setBounds(231, 384, 57, 15);
		TimeCoworking.add(coLavel1119);

		JButton coL_1115 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		coL_1115.setBounds(228, 400, 97, 23);
		coL_1115.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coL_1115);
		coL_1115.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1115 lunch");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton coD_1115 = new JButton("\uC800\uB141\uC2DC\uAC04");
		coD_1115.setBounds(228, 433, 97, 23);
		coD_1115.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coD_1115);
		coD_1115.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1115 dinner");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel coLavel1120 = new JLabel("20");
		coLavel1120.setBounds(413, 384, 57, 15);
		TimeCoworking.add(coLavel1120);

		JButton coL_1120 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		coL_1120.setBounds(407, 400, 97, 23);
		coL_1120.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coL_1120);
		coL_1120.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1120 lunch");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton coD_1120 = new JButton("\uC800\uB141\uC2DC\uAC04");
		coD_1120.setBounds(407, 433, 97, 23);
		coD_1120.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coD_1120);
		coD_1120.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1120 dinner");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton coA1120 = new JButton("\uBC29\uACFC\uD6C4 A");
		coA1120.setBounds(507, 400, 97, 56);
		coA1120.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coA1120);
		coA1120.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1120 afterschool");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel coLavel1121 = new JLabel("21");
		coLavel1121.setBounds(678, 384, 57, 15);
		TimeCoworking.add(coLavel1121);

		JButton coL_1121 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		coL_1121.setBounds(678, 400, 97, 23);
		coL_1121.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coL_1121);
		coL_1121.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1121 lunch");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton coD_1121 = new JButton("\uC800\uB141\uC2DC\uAC04");
		coD_1121.setBounds(678, 433, 97, 23);
		coD_1121.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coD_1121);
		coD_1121.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1121 dinner");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel coLavel1122 = new JLabel("22");
		coLavel1122.setBounds(873, 384, 57, 15);
		TimeCoworking.add(coLavel1122);

		JButton coL_1122 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		coL_1122.setBounds(873, 400, 97, 23);
		coL_1122.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coL_1122);
		coL_1122.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1122 lunch");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton coD_1122 = new JButton("\uC800\uB141\uC2DC\uAC04");
		coD_1122.setBounds(873, 433, 97, 23);
		coD_1122.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coD_1122);
		coD_1122.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1122 dinner");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel coLavel1125 = new JLabel("25");
		coLavel1125.setBounds(49, 483, 57, 15);
		TimeCoworking.add(coLavel1125);

		JButton coL_1125 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		coL_1125.setBounds(49, 508, 97, 23);
		coL_1125.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coL_1125);
		coL_1125.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1125 lunch");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton coD_1125 = new JButton("\uC800\uB141\uC2DC\uAC04");
		coD_1125.setBounds(49, 541, 97, 23);
		coD_1125.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coD_1125);
		coD_1125.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1125 dinner");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});
		JLabel coLavel1126 = new JLabel("26");
		coLavel1126.setBounds(231, 483, 57, 15);
		TimeCoworking.add(coLavel1126);

		JButton coL1126 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		coL1126.setBounds(228, 508, 97, 23);
		coL1126.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coL1126);
		coL1126.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1126 lunch");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton coD_1126 = new JButton("\uC800\uB141\uC2DC\uAC04");
		coD_1126.setBounds(228, 541, 97, 23);
		coD_1126.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coD_1126);
		coD_1126.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1126 dinner");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel coLavel1127 = new JLabel("27");
		coLavel1127.setBounds(413, 483, 57, 15);
		TimeCoworking.add(coLavel1127);

		JButton coL_1127 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		coL_1127.setBounds(407, 508, 97, 23);
		coL_1127.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coL_1127);
		coL_1127.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1127 lunch");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton coD_1127 = new JButton("\uC800\uB141\uC2DC\uAC04");
		coD_1127.setBounds(407, 541, 97, 23);
		coD_1127.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coD_1127);
		coD_1127.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1127 dinner");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton coA_1127 = new JButton("\uBC29\uACFC\uD6C4 A");
		coA_1127.setBounds(507, 508, 97, 56);
		coA_1127.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coA_1127);
		coA_1127.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1127 afterschool");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel coLavel1128 = new JLabel("28");
		coLavel1128.setBounds(678, 483, 57, 15);
		TimeCoworking.add(coLavel1128);

		JButton coL_1128 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		coL_1128.setBounds(678, 508, 97, 23);
		coL_1128.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coL_1128);
		coL_1128.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1128 lunch");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton coD_1128 = new JButton("\uC800\uB141\uC2DC\uAC04");
		coD_1128.setBounds(678, 541, 97, 23);
		coD_1128.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coD_1128);
		coD_1128.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1128 dinner");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel coLavel1129 = new JLabel("29");
		coLavel1129.setBounds(873, 483, 57, 15);
		TimeCoworking.add(coLavel1129);

		JButton coL_1129 = new JButton("\uC810\uC2EC\uC2DC\uAC04");
		coL_1129.setBounds(873, 508, 97, 23);
		coL_1129.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coL_1129);
		coL_1129.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1129 lunch");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton coD_1129 = new JButton("\uC800\uB141\uC2DC\uAC04");
		coD_1129.setBounds(873, 541, 97, 23);
		coD_1129.setBackground(new Color(129, 193, 71));
		TimeCoworking.add(coD_1129);
		coD_1129.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Coworking.setId("1129 dinner");
				try {
					try {
						if (coworking.search(Coworking.getId())) {
							JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.");
						} else {
							System.out.println(Coworking.getId());
							TimeCoworking.setVisible(false);
							reservation.setVisible(true);
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
		});

// 로그인 창
		JPanel LoginMuhan = new JPanel();
		LoginMuhan.setBounds(0, 0, 1047, 606);
		frame.getContentPane().add(LoginMuhan);
		LoginMuhan.setLayout(null);
		LoginMuhan.setVisible(false);
// 로그인 라벨
		JLabel LoginLabelMuhan = new JLabel("무한상상카페 Login");
		LoginLabelMuhan.setFont(new Font("맑은고딕", Font.PLAIN, 35));
		LoginLabelMuhan.setBounds(360, 114, 331, 55);
		LoginMuhan.add(LoginLabelMuhan);
// 학번 라벨
		JLabel StudentNumMuhan = new JLabel("학번 : ");
		StudentNumMuhan.setFont(new Font("맑은고딕", Font.PLAIN, 30));
		StudentNumMuhan.setBounds(250, 225, 92, 29);
		LoginMuhan.add(StudentNumMuhan);
// 학번입력하는 텍스트 상자
		IDTextMuhan = new JTextField();
		IDTextMuhan.setBounds(348, 209, 331, 72);
		LoginMuhan.add(IDTextMuhan);
		IDTextMuhan.setColumns(10);
// 로그인 확인 버튼
		JButton LoginButtonMuhan = new JButton("Login");
		LoginButtonMuhan.setBounds(444, 456, 141, 35);
		LoginButtonMuhan.setBackground(new Color(129, 193, 71));
		LoginMuhan.add(LoginButtonMuhan);
// 로그인 버튼 누르면 하는 액션
		LoginButtonMuhan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (IDTextMuhan.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "학번을 입력하시오.");
				} else if (checkInt(IDTextMuhan.getText()) == false) {
					JOptionPane.showMessageDialog(null, "학번을 똑바로 입력하세요.");
				} else if (checkInt(IDTextMuhan.getText()) == true) {
					Muhan.setSnum(IDTextMuhan.getText());
					System.out.println("학번을 입력 받았습니다.");
					// 컨설팅룸창이 꺼지고
					LoginMuhan.setVisible(false);
					// 시간테이블을 보여줌.
					TimeMuhan.setVisible(true);
				}
			}

		});
// 코워킹스페이스 로그인 창
		JPanel LoginCoworking = new JPanel();
		LoginCoworking.setBounds(0, 0, 1047, 606);
		frame.getContentPane().add(LoginCoworking);
		LoginCoworking.setVisible(false);
		LoginCoworking.setLayout(null);
// 학번 라벨
		JLabel StudentNumCoworking = new JLabel("학번 : ");
		StudentNumCoworking.setBounds(262, 238, 92, 29);
		StudentNumCoworking.setFont(new Font("맑은고딕", Font.PLAIN, 30));
		LoginCoworking.add(StudentNumCoworking);
// 위에 장소 로그인 라벨
		JLabel LoginLavelCoworking = new JLabel("코워킹스페이스 Login");
		LoginLavelCoworking.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		LoginLavelCoworking.setBounds(413, 140, 235, 55);
		LoginCoworking.add(LoginLavelCoworking);
// 학번 입력하는 텍스트 상자
		IDtextCoworking = new JTextField();
		IDtextCoworking.setBounds(366, 224, 282, 68);
		LoginCoworking.add(IDtextCoworking);
		IDtextCoworking.setColumns(10);
// 코워킹스페이스 로그인 버튼
		JButton LoginButtonCoworking = new JButton("Login");
		LoginButtonCoworking.setBounds(444, 456, 141, 35);
		LoginButtonCoworking.setBackground(new Color(129, 193, 71));
		LoginCoworking.add(LoginButtonCoworking);
// 로그인 버튼 누르면
		LoginButtonCoworking.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (IDtextCoworking.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "학번을 입력하시오.");
				} else if (checkInt(IDtextCoworking.getText()) == false) {
					JOptionPane.showMessageDialog(null, "학번을 똑바로 입력하세요.");
				} else if (checkInt(IDtextCoworking.getText()) == true) {
					Coworking.setSnum(IDtextCoworking.getText());
					System.out.println("학번을 입력 받았습니다.");
					// 컨설팅룸창이 꺼지고
					LoginCoworking.setVisible(false);
					// 시간테이블을 보여줌.
					TimeCoworking.setVisible(true);
				}
			}

		});

// 컨설팅룸 로그인 창
		JPanel LoginConsulting = new JPanel();
		LoginConsulting.setBounds(0, 0, 1047, 606);
		frame.getContentPane().add(LoginConsulting);
		LoginConsulting.setVisible(false);
		LoginConsulting.setLayout(null);
// 학번 라벨
		JLabel StudentNumConsulting = new JLabel("학번 : ");
		StudentNumConsulting.setBounds(268, 226, 92, 29);
		StudentNumConsulting.setFont(new Font("맑은고딕", Font.PLAIN, 30));
		LoginConsulting.add(StudentNumConsulting);
// 컨설팅룸 로그인 라벨
		JLabel LoginLavelConsulting = new JLabel("컨설팅룸 Login");
		LoginLavelConsulting.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		LoginLavelConsulting.setBounds(440, 144, 235, 55);
		LoginConsulting.add(LoginLavelConsulting);
// 학번 입력 텍스트 상자
		IDTextConsulting = new JTextField();
		IDTextConsulting.setBounds(372, 209, 303, 73);
		LoginConsulting.add(IDTextConsulting);
		IDTextConsulting.setColumns(10);

// 컨설팅룸 로그인 버튼
		JButton LoginButtonConsulting = new JButton("Login");
		LoginButtonConsulting.setBounds(444, 456, 141, 35);
		LoginButtonConsulting.setBackground(new Color(129, 193, 71));
		LoginConsulting.add(LoginButtonConsulting);

		LoginButtonConsulting.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (IDTextConsulting.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "학번을 입력하시오.");
				} else if (checkInt(IDTextConsulting.getText()) == false) {
					JOptionPane.showMessageDialog(null, "학번을 똑바로 입력하세요.");
				} else if (checkInt(IDTextConsulting.getText()) == true) {
					Consulting.setSnum(IDTextConsulting.getText());
					System.out.println("학번을 입력 받았습니다.");
					// 컨설팅룸창이 꺼지고
					LoginConsulting.setVisible(false);
					// 시간테이블을 보여줌.
					TimeConsulting.setVisible(true);
				}
			}

		});
		// 장소 선택 창
		JPanel Placesearch = new JPanel();
		Placesearch.setBounds(0, 0, 1047, 606);
		frame.getContentPane().add(Placesearch);
		Placesearch.setLayout(null);
		Placesearch.setVisible(false);

		JButton muhansearch = new JButton("무한상상카페");
		muhansearch.setForeground(Color.BLACK);
		muhansearch.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
		muhansearch.setBounds(73, 258, 218, 209);
		muhansearch.setBackground(new Color(129, 193, 71));
		Placesearch.add(muhansearch);
		muhansearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("무한상상카페가 선택되었습니다.");
				Muhan.createTable();
				Placesearch.setVisible(false);
				SearchPanelmu.setVisible(true);
			}
		});

		JButton coworkingsearch = new JButton("코워킹스페이스");
		coworkingsearch.setForeground(Color.BLACK);
		coworkingsearch.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
		coworkingsearch.setBounds(412, 258, 218, 209);
		coworkingsearch.setBackground(new Color(129, 193, 71));
		Placesearch.add(coworkingsearch);
		coworkingsearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("코워킹스페이스가 선택되었습니다.");
				Coworking.createTable();
				whereisit = 1;
				Placesearch.setVisible(false);
				SearchPanel.setVisible(true);
			}
		});

		JButton consultingsearch = new JButton("컨설팅룸");
		consultingsearch.setForeground(Color.BLACK);
		consultingsearch.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
		consultingsearch.setBounds(761, 258, 218, 209);
		consultingsearch.setBackground(new Color(129, 193, 71));
		Placesearch.add(consultingsearch);
		consultingsearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.createTable();
				whereisit = 2;
				System.out.println("컨설팅룸이 선택되었습니다.");
				Placesearch.setVisible(false);
				SearchPanelcon.setVisible(true);
			}
		});
// 장소 선택 창
		JPanel Place = new JPanel();
		Place.setBounds(0, 0, 1047, 606);
		frame.getContentPane().add(Place);
		Place.setLayout(null);
		Place.setVisible(false);

		JButton muhan = new JButton("무한상상카페");
		muhan.setForeground(Color.BLACK);
		muhan.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
		muhan.setBounds(73, 258, 218, 209);
		muhan.setBackground(new Color(129, 193, 71));
		Place.add(muhan);
		muhan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("무한상상카페가 선택되었습니다.");
				Muhan.createTable();
				Place.setVisible(false);
				LoginMuhan.setVisible(true);
			}
		});

		JButton coworking = new JButton("코워킹스페이스");
		coworking.setForeground(Color.BLACK);
		coworking.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
		coworking.setBounds(412, 258, 218, 209);
		coworking.setBackground(new Color(129, 193, 71));
		Place.add(coworking);
		coworking.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("코워킹스페이스가 선택되었습니다.");
				Coworking.createTable();
				Place.setVisible(false);
				LoginCoworking.setVisible(true);
			}
		});

		JButton consulting = new JButton("컨설팅룸");
		consulting.setForeground(Color.BLACK);
		consulting.setFont(new Font("나눔바른고딕 Light", Font.PLAIN, 15));
		consulting.setBounds(761, 258, 218, 209);
		consulting.setBackground(new Color(129, 193, 71));
		Place.add(consulting);
		consulting.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Consulting.createTable();
				System.out.println("컨설팅룸이 선택되었습니다.");
				Place.setVisible(false);
				LoginConsulting.setVisible(true);
			}
		});

		JLabel lblNewLabel_6 = new JLabel("예약 할 장소를 선택해주세요.");
		lblNewLabel_6.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 30));
		lblNewLabel_6.setBounds(339, 86, 405, 35);
		Place.add(lblNewLabel_6);

		JPanel Home = new JPanel();
		Home.setBounds(0, 0, 1047, 606);
		frame.getContentPane().add(Home);
		Home.setLayout(null);
		
		
		HomeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SearchPanel.setVisible(false);
				Home.setVisible(true);
			}
			
		});
		HomeButtonmu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SearchPanelmu.setVisible(false);
				Home.setVisible(true);
				
			}
			
		});
		HomeButtoncon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SearchPanelcon.setVisible(false);
				Home.setVisible(true);
				
			}
			
		});

		JLabel Home_Lavel = new JLabel("SELECT MIRIM");
		Home_Lavel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 25));
		Home_Lavel.setBounds(66, 69, 181, 54);
		Home.add(Home_Lavel);

		JButton Reserve = new JButton("\uC608\uC57D");
		Reserve.setBounds(774, 398, 222, 60);
		Home.add(Reserve);

		Reserve.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("예약을 클릭하였습니다.");
				Home.setVisible(false);
				Place.setVisible(true);
			}
		});
		HomeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SearchPanel.setVisible(false);
				Home.setVisible(true);
			}

		});
		JButton Search = new JButton("\uC870\uD68C");
		Search.setBounds(774, 468, 222, 60);
		Home.add(Search);

		Search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("조회를 클릭하였습니다.");
				Home.setVisible(false);
				Placesearch.setVisible(true);
			}
		});
	}
}
