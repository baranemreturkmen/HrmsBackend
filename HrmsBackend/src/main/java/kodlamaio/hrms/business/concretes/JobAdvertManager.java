package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.concretes.dtos.JobAdvertWithCompanyNameDto;

@Service
public class JobAdvertManager implements JobAdvertService{
	
	private JobAdvertDao jobAdvertDao;
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public Result addJobAdvert(JobAdvert jobAdvert) {
		// TODO Auto-generated method stub
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("İş ilanı eklendi.");
	}


	
	  @Override public DataResult<List<JobAdvertWithCompanyNameDto>>
	  getAllJobAdverts() { 
		  
	  return new SuccessDataResult<List<JobAdvertWithCompanyNameDto>>(this.jobAdvertDao.getAllJobAdverts(),"İş ilanları listelendi."); }

	@Override
	public DataResult<List<JobAdvertWithCompanyNameDto>> findByfirstApplyDateAsc() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertWithCompanyNameDto>>(this.jobAdvertDao.findByfirstApplyDateAsc(),"İş ilanları ilk açılan ilandan itibaren sıralandı.");
	}

	@Override
	public DataResult<List<JobAdvertWithCompanyNameDto>> findBycompanyName(String companyName) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertWithCompanyNameDto>>(this.jobAdvertDao.findBycompanyName(companyName),companyName+" firmasına ait iş ilanları bulundu.");
	}

	@Override
	public Result deleteJobAdvert(JobAdvert jobAdvert) {
		// TODO Auto-generated method stub
		this.jobAdvertDao.delete(jobAdvert);
		return new SuccessResult("İş ilanı silindi.");
	}
	 

}
