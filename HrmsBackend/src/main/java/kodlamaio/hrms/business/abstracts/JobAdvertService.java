package kodlamaio.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;


import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Company;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.concretes.dtos.JobAdvertWithCompanyNameDto;

public interface JobAdvertService {
	
	DataResult<List<JobAdvertWithCompanyNameDto>> getAllJobAdverts();
	Result addJobAdvert(JobAdvert jobAdvert);
	Result deleteJobAdvert(JobAdvert jobAdvert);
	DataResult<List<JobAdvertWithCompanyNameDto>> findByfirstApplyDateAsc();
	DataResult<List<JobAdvertWithCompanyNameDto>> findBycompanyName(String companyName);
}
