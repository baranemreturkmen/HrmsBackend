package kodlamaio.hrms.api.controllers;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Company;

@RestController
@RequestMapping("/api/companys")
public class CompanysController {
	
	private CompanyService companyService;
	
	@Autowired
	public CompanysController(CompanyService companyService) {
		this.companyService=companyService;
	}
	
	@GetMapping("/getAllCompanys")
	public DataResult<List<Company>> getAllCompanys(){
		return this.companyService.getAllCompanys();
	}
	
	@PostMapping("/addCompany")
	public Result addCompany(@Valid @RequestBody Company company) {
		return companyService.addCompany(company);	
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidatonException(MethodArgumentNotValidException exceptions){
		Map<String,String> validationErrors = new HashMap<String,String>();
		for(FieldError fieldError:exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult(validationErrors,"Do??rulama Hatalar??");
		return errors;
	}
}
