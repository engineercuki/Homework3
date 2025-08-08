package service.impl;

import java.util.List;

import dao.impl.BookSchduleDaoImpl;
import model.BookSchdule;
import service.BookSchduleService;

public class BookSchduleServiceImpl implements BookSchduleService{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//匯入JDBC
	public static BookSchduleDaoImpl bdi=new BookSchduleDaoImpl();

	@Override
	public void addBooking(BookSchdule bookschdule) {
					bdi.add(bookschdule);
		
	}

	@Override
	public List<BookSchdule> FindAllSchdule() {
					
		return bdi.selectAll();
	}

	@Override
	public List<BookSchdule> FindMyAllSchdule(String patientId) {
	    return bdi.SelectMyAllByPatientid(patientId); 
	}


	@Override
	public boolean UpdateMySchdule(BookSchdule bookschdule) {
						BookSchdule booked=bdi.SelectById(bookschdule.getId());
						boolean x=false;
						if(booked!=null) {
								x=true;
								bdi.update(bookschdule);
						}
			return x;
	}

	@Override
	public boolean DeleteMySchdule(int id) {
						BookSchdule delete=bdi.SelectById(id);
						boolean x=false;
						if(delete!=null) {
							x=true;
							bdi.delete(id);
						}
			return x;
	}

	@Override
	public BookSchdule FindMySchdule(String patientId) {
		// TODO Auto-generated method stub
		return bdi.SelectByPatientid(patientId) ;
	}

}
