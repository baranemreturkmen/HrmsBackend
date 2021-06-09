package kodlamaio.hrms.business.concretes;




import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CompanyDao;
import kodlamaio.hrms.entities.concretes.Company;


@Service
public class CompanyManager implements CompanyService{
	
	private CompanyDao companyDao;
	
	public CompanyManager(CompanyDao companyDao) {
		this.companyDao=companyDao;
	}
	
	@Override
	public DataResult<List<Company>> getAllCompanys() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Company>>(companyDao.findAll(),"Sistemdeki tüm şirketler listelendi.");
	}

	@Override
	public Result addCompany(Company company) {
		// TODO Auto-generated method stub
		this.companyDao.save(company);
		return new SuccessResult("Şirket eklendi.");
	}
	
	

}
