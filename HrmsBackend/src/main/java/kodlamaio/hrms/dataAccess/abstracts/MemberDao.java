package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Member;

public interface MemberDao extends JpaRepository<Member,Integer>{
	
	//Sadece Memberlardan JobSeekerları Cekmek istedim.
	@Query("SELECT u FROM Member u WHERE u.roleId=2")
	public List<Member> getAllJobSeekers();

}
