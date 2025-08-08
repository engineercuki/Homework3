package dao;

import java.util.List;

import model.BookSchdule;

public interface BookSchduleDao {
	
				//CREATE
				void add(BookSchdule bookschdule);
	
	
				//READ
				List<BookSchdule> selectAll();
				BookSchdule SelectByPatientid(String patientid);
				BookSchdule SelectById(int id);
				List<BookSchdule> SelectMyAllByPatientid(String patientid);
	
	
				//UPDATE
				void update(BookSchdule bookschdule);
	
				
				//DELETE
				void delete(int id);
				

}
