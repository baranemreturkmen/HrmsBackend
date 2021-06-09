package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Member;


public interface MemberService {
	
	DataResult<List<Member>> getAllJobSeekers();
	Result addMember(Member member);

}
