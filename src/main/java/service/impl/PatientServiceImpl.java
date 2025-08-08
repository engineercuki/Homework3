package service.impl;

import dao.impl.PatientDaoImpl;
import model.Patient;
import service.PatientService;

public class PatientServiceImpl implements PatientService{

	public static void main(String[] args) {
					// 測試新增帳號
					Patient p=new Patient("白臨","L220220220","女","2006/8/8","0917854325","LL123");
					boolean result=new PatientServiceImpl().addCheck(p);
					if (result) {
				        System.out.println("註冊成功！");
				    } else {
				        System.out.println("帳號已存在，請返回[登入]");
				    }

	}

	public static PatientDaoImpl pdi=new PatientDaoImpl();
	
	@Override
	public boolean addCheck(Patient patient) {
		/*
		 * 1. 判斷帳號是否重複
		 * 2. null -> 註冊 -> true -> 顯示成功訊息
		 * 3. !=null -> 重複 -> false -> 顯示'帳號重複訊息
		 */
		boolean patientIdCheck=false;
		Patient p=pdi.selectByPatientId(patient.getPatientId());
		if(p==null) {
					pdi.add(patient);
					patientIdCheck=true;
		}
		return patientIdCheck;
	}


	@Override
	public Patient login(String patientId, String password) {
		// TODO Auto-generated method stub
		return pdi.Select(patientId, password);
	}


	@Override
	public Patient findPatientInfo(String patientId) {
		    return pdi.selectByPatientId(patientId); 
		}


	public Patient findPatientInfo(Patient pid) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean update(String patientId,String password) {
		// TODO Auto-generated method stub
	    Patient patient = pdi.selectByPatientId(patientId); // 先查詢
	    if (patient == null) return false;

	    patient.setPassword(password);
	    pdi.update(patient); // 執行更新（不回傳）
	    return true;
	}
	



}
