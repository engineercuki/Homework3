package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dao.PatientDao;
import model.Patient;
import util.DbConnection;

public class PatientDaoImpl implements PatientDao{
	
	
	//功能測試區
	public static void main(String[] args) {
					//新增帳號
					/*
					Patient p=new Patient("喬穎珍","k229119453","女","2006/10/10","0919119453","kk123");
					new PatientDaoImpl().add(p);
					*/
		
					//查詢帳號
					/*
					PatientDaoImpl pdi=new PatientDaoImpl();
					Patient patient=pdi.selectByPatientId("A122586412");
					System.out.println("姓名"+patient.getPatientName()+"\tPID:"+patient.getPatientId()+"\t電話:"+patient.getPhone());
					*/
		
					//修改密碼
					/*
					String patientId="B220365991";
					String password="bb1234";
					new PatientDaoImpl().update(patientId,password);
					System.out.println("密碼已更新");
					*/
		
					//修改個資
					Patient patient=new Patient("F222614905","林嬌","0934120616");
					new PatientDaoImpl().update(patient);
					System.out.println("資料已更新");
					 

	}
	
	//執行DB連線
	public static Connection conn=DbConnection.getDb();
	
	//CREATE
	@Override
	public void add(Patient patient) {
					String sql="insert into patient(patientName,patientId,sex,birthday,phone,password)"+"Value(?,?,?,?,?,?)";
					try {
						PreparedStatement ps=conn.prepareStatement(sql);
						ps.setString(1, patient.getPatientName());
						ps.setString(2, patient.getPatientId());
						ps.setString(3, patient.getSex());
						ps.setString(4, patient.getBirthday().format(DateTimeFormatter.ofPattern("yyyy/M/d")));
						ps.setString(5, patient.getPhone());
						ps.setString(6, patient.getPassword());
						ps.executeUpdate();
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	}

	
	//READ
	//
	@Override
	public Patient Select(String patientId, String password) {
					Patient patient = null;
					String sql = "SELECT * FROM patient WHERE patientId = ? AND password = ?";
										
	    try {
	    	PreparedStatement ps=conn.prepareStatement(sql);
	        ps.setString(1, patientId);
	        ps.setString(2, password);
	        ResultSet rs=ps.executeQuery();

	        if (rs.next()) {
	            patient = new Patient();
	            patient.setId(rs.getInt("id"));
	            patient.setPatientName(rs.getString("patientName"));
	            patient.setPatientId(rs.getString("patientId"));
	            patient.setSex(rs.getString("sex"));

	            String birthdayStr = rs.getString("birthday");
	            if (birthdayStr != null && !birthdayStr.isEmpty()) {
	                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/M/d");
	                patient.setBirthday(LocalDate.parse(birthdayStr, formatter));
	            }
	            
	            patient.setPhone(rs.getString("phone"));
	            patient.setPassword(rs.getString("password"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 

	    return patient;
	}
	
	//byPID
	@Override
	public Patient selectByPatientId(String patientId) {
						Patient patient=null;
						String sql="SELECT * FROM patient WHERE patientId=? ";
		
						try{
							PreparedStatement ps=conn.prepareStatement(sql);
							ps.setString(1,patientId);
							ResultSet rs=ps.executeQuery();
							if(rs.next()){
											patient=new Patient();
											patient.setId(rs.getInt("id"));
											patient.setPatientName(rs.getString("patientName"));
											patient.setPatientId(rs.getString("patientId"));
											patient.setSex(rs.getString("sex"));
											patient.setBirthday(LocalDate.parse(rs.getString("birthday"), DateTimeFormatter.ofPattern("yyyy/M/d")));
											patient.setPhone(rs.getString("phone"));
											patient.setPassword(rs.getString("password"));
											
							}
						}
						catch(Exception e){
			
						}
		
						return patient;
	}

	
	//UPDATE
	//修改密碼
	@Override
	public Patient update(String patientId,String password) {
					String sql="UPDATE patient SET password=? WHERE patientId=? ";
					
					try {
						PreparedStatement ps=conn.prepareStatement(sql);
						ps.setString(1, password);
						ps.setString(2, patientId);
						ps.executeUpdate();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					}
					return update(patientId, password);
					
	}
	
	//修改個資-姓名電話
	@Override
	public void update(Patient password) {
					String sql="UPDATE patient SET password=?  WHERE patientId=? ";
					
					try {
						PreparedStatement ps=conn.prepareStatement(sql);
						ps.setString(1, password.getPassword());
						ps.setString(2, password.getPatientId());
						ps.executeUpdate();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	}



	
	
	//DELETE


}
