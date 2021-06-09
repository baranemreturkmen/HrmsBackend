package kodlamaio.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.concretes.dtos.JobAdvertWithCompanyNameDto;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{

	
	
	  @Query("Select new kodlamaio.hrms.entities.concretes.dtos.JobAdvertWithCompanyNameDto"
	  +
	  "(p.jobAdvertId,p.jobAdvertPositionId,p.numberOfPosition,p.firstApplyDate,p.lastApplyDate,c.companyName)"
	  +
	  " From Company c Inner Join c.jobAdverts p"
	  ) 
	  List<JobAdvertWithCompanyNameDto> getAllJobAdverts();
	 
		
	  @Query("Select new kodlamaio.hrms.entities.concretes.dtos.JobAdvertWithCompanyNameDto"
		  +
		  "(p.jobAdvertId,p.jobAdvertPositionId,p.numberOfPosition,p.firstApplyDate,p.lastApplyDate,c.companyName)"
		  + " From Company c Inner Join c.jobAdverts p Order By p.firstApplyDate" )
	  List<JobAdvertWithCompanyNameDto> findByfirstApplyDateAsc();
	  //Sıralama ilk açılan ilandan son açılan ilana doğru yapılmaktadır.
		  
	 @Query("Select new kodlamaio.hrms.entities.concretes.dtos.JobAdvertWithCompanyNameDto"
				  +
				  "(p.jobAdvertId,p.jobAdvertPositionId,p.numberOfPosition,p.firstApplyDate,p.lastApplyDate,c.companyName)"
				  + " From Company c Inner Join c.jobAdverts p where c.companyName=:companyName" )
	   List<JobAdvertWithCompanyNameDto> findBycompanyName(String companyName);
	
	//yukarıda ki sorguda sehir yok ama sehir uzerinden de baglanti gerceklestirmistik. Yani adam liste halinde
	//sehri de girilebilir istiyor ama JobAdvertList'De sehir bilgisi istememis.
	
	//sehir bilgisi goruntulensin istemiyor JobAdvertsListde sadece JobAdevert'da bilgi olarak bulunsun istiyor sehirler.
	//Ama sonucta bilgi olarak istiyor yanından ve coklu secim istiyor bu durumda baglanti olsun Dao tarafında query'nin 
	//icerisinde kullanılmasın. Sonucta bu bilgi coklu multiple secilebilir bicimde olacak ama listelerken gorunmeyecek!!!
	
	 //" From Position p,Company c Inner Join p.jobAdverts j Inner Join c.jobAdverts j"
	
}
