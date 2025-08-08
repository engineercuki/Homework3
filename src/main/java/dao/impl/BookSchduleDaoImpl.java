package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BookSchduleDao;
import model.BookSchdule;
import model.Patient;
import util.DbConnection;

public class BookSchduleDaoImpl implements BookSchduleDao{
	
					//功能測試區
					public static void main(String[] args) {
					//新增預約
					/*
					BookSchdule booking=new BookSchdule("歐都麥","C120661478","2025/8/8","19:00","吳所畏","內診");
					new BookSchduleDaoImpl().add(booking);
					System.out.println("預約成功");
					*/
		
					//查詢預約-SELECT ALL
					/*
					List<BookSchdule> booked=new BookSchduleDaoImpl().selectAll();
					for(BookSchdule bs:booked) {
					System.out.println("姓名"+bs.getPatientName()+"("+bs.getPatientId()+")"+"\t預約日期:"+bs.getBookDate()+"  "+bs.getBookTime()+"\t醫師:"+bs.getDoctorName()+"\t"+bs.getDepartment()+"門診");
					}
					*/
						
					//查詢預約-byPID
					/*
					BookSchduleDaoImpl bdi=new BookSchduleDaoImpl();
					BookSchdule booked=bdi.SelectByPatientid("J126854711");
					if(booked!=null) {
								System.out.println("姓名:"+booked.getPatientName()+"("+booked.getPatientId()+")"+"\t預約日期:"+booked.getBookDate()+"  "+booked.getBookTime()+"\t醫師:"+booked.getDoctorName()+"\t"+booked.getDepartment()+"門診");
					}
					else {
								System.out.println("查無預約紀錄");
					}
					*/					
		
					//修改預約日期時間
					/*
					BookSchdule change=new BookSchdule("E122666341","2025/8/9","14:00");
					new BookSchduleDaoImpl().update(change);
					System.out.println("資料已更新");
					 */
						
					//刪除預約
					BookSchdule cancel=new BookSchduleDaoImpl().SelectById(7);
					if (cancel != null) {
					    new BookSchduleDaoImpl().delete(cancel.getId());
					    System.out.println("已刪除預約");
					} else {
					    System.out.println("查無預約紀錄");
					}

	}

					//執行SQL連線
					public static Connection conn=DbConnection.getDb();

					//CREATE
					@Override
					public void add(BookSchdule bookschdule) {
						
									String sql="INSERT INTO bookschdule (patientName,patientId,bookDate,bookTime,doctorName,department) VALUE (?,?,?,?,?,?)";
									
									try {
										PreparedStatement ps=conn.prepareStatement(sql);
										ps.setString(1,bookschdule.getPatientName());
										ps.setString(2,bookschdule.getPatientId());
										ps.setString(3,bookschdule.getBookDate());
										ps.setString(4,bookschdule.getBookTime());
										ps.setString(5,bookschdule.getDoctorName());
										ps.setString(6,bookschdule.getDepartment());
										ps.executeUpdate();
										
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
		
					}
					
					//READ-ALL
					@Override
					public List<BookSchdule> selectAll() {
									
									String sql="SELECT * FROM bookschdule ";
									List<BookSchdule> booked=new ArrayList();
									
									try {
										PreparedStatement ps=conn.prepareStatement(sql);
										ResultSet rs=ps.executeQuery();
										while(rs.next()) {
													BookSchdule bs=new BookSchdule();
													bs.setPatientName(rs.getString("PatientName"));
													bs.setPatientId(rs.getString("PatientId"));
													bs.setBookDate(rs.getString("bookDate"));
													bs.setBookTime(rs.getString("bookTime"));
													bs.setDoctorName(rs.getString("doctorName"));
													bs.setDepartment(rs.getString("department"));
													booked.add(bs);
										}
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									return booked;
						}

					
					//READ-byPID
					@Override
					public BookSchdule SelectByPatientid(String patientid) {
									
									BookSchdule booked=null;
									String sql="SELECT * FROM bookschdule WHERE patientId=?";
									
									try {
										PreparedStatement ps=conn.prepareStatement(sql);
										ps.setString(1, patientid);
										ResultSet rs=ps.executeQuery();
										
										if(rs.next()) {
												booked=new BookSchdule();
												booked.setPatientName(rs.getString("PatientName"));
												booked.setPatientId(rs.getString("PatientId"));
												booked.setBookDate(rs.getString("bookDate"));
												booked.setBookTime(rs.getString("bookTime"));
												booked.setDoctorName(rs.getString("doctorName"));
												booked.setDepartment(rs.getString("department"));

										}
										rs.close();
										ps.close();
										
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									return booked;
					}

					//READ-byID
					@Override
					public BookSchdule SelectById(int id) {
									
									BookSchdule bs = null;
									String sql="SELECT * FROM bookschdule WHERE id=?";							
									
									try {
										PreparedStatement ps=conn.prepareStatement(sql);
										ps.setInt(1,id);
										ResultSet rs=ps.executeQuery();
										if(rs.next()) {
													bs = new BookSchdule();
													bs.setId(rs.getInt("Id"));
													bs.setPatientName(rs.getString("PatientName"));
													bs.setPatientId(rs.getString("PatientId"));
													bs.setBookDate(rs.getString("bookDate"));
													bs.setBookTime(rs.getString("bookTime"));
													bs.setDoctorName(rs.getString("doctorName"));
													bs.setDepartment(rs.getString("department"));
													
										}
										rs.close();
										ps.close();
										
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									return bs;
						}
					
					
					//UPDATE
					@Override
					public void update(BookSchdule bookschdule) {
						
									String sql="UPDATE bookschdule set bookDate=?,bookTime=? WHERE patientId=? ";		
									try {
										PreparedStatement ps=conn.prepareStatement(sql);
										ps.setString(1, bookschdule.getBookDate());
										ps.setString(2, bookschdule.getBookTime());
										ps.setString(3, bookschdule.getPatientId());
										ps.executeUpdate();
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
					}


					//DELETE
					@Override
					public void delete(int id) {
						
									String sql="DELETE FROM bookschdule WHERE id=?";
									
									try {
												PreparedStatement ps=conn.prepareStatement(sql);
												ps.setInt(1,id);
												ps.executeUpdate();
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
		
					}

					@Override
					public List<BookSchdule> SelectMyAllByPatientid(String patientid) {
						List<BookSchdule> bookedList = new ArrayList<>();
					    String sql = "SELECT * FROM bookschdule WHERE patientId = ?";

					    try {
					        PreparedStatement ps = conn.prepareStatement(sql);
					        ps.setString(1, patientid);
					        ResultSet rs = ps.executeQuery();

					        while (rs.next()) {
					            BookSchdule booked = new BookSchdule();
					            booked.setId(rs.getInt("id"));
					            booked.setPatientName(rs.getString("PatientName"));
					            booked.setPatientId(rs.getString("PatientId"));
					            booked.setBookDate(rs.getString("bookDate"));
					            booked.setBookTime(rs.getString("bookTime"));
					            booked.setDoctorName(rs.getString("doctorName"));
					            booked.setDepartment(rs.getString("department"));

					            bookedList.add(booked);
					        }

					        rs.close();
					        ps.close();
					    } catch (Exception e) {
					        e.printStackTrace();
					    }

					    return bookedList;
					}


}
