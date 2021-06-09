package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.MemberService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.MemberDao;
import kodlamaio.hrms.entities.concretes.Member;

@Service
public class MemberManager implements MemberService{
	
	private MemberDao memberDao;
	
	public MemberManager(MemberDao memberDao) {
		this.memberDao=memberDao;
	}
	//super eksik sıkıntı varsa ondan dolayı olabilir.
	
	@Override
	public DataResult<List<Member>> getAllJobSeekers() {
		// TODO Auto-generated method stub
		
		return new SuccessDataResult<List<Member>>(memberDao.getAllJobSeekers(),"İş arayan üyeler listelendi.");
		
	}

	@Override
	public Result addMember(Member member) {
		// TODO Auto-generated method stub
		this.memberDao.save(member);
		return new SuccessResult("Üye eklendi.");
	}

}
