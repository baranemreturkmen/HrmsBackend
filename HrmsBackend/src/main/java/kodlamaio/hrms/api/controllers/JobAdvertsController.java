package kodlamaio.hrms.api.controllers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.concretes.Position;

import kodlamaio.hrms.entities.concretes.dtos.JobAdvertWithCompanyNameDto;

@RestController
@RequestMapping("/api/jobAdverts")
public class JobAdvertsController {
	
	private JobAdvertService jobAdvertService;
	
	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		this.jobAdvertService = jobAdvertService;
	}

	  @GetMapping("/getAllJobAdverts") 
	  public DataResult<List<JobAdvertWithCompanyNameDto>> getAllJobAdverts(){
	  return this.jobAdvertService.getAllJobAdverts();
	  
	  }
	 
	@PostMapping("/addJobAdvert")
	public Result addJobAdvert(@Valid @RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.addJobAdvert(jobAdvert);
	}
	
	@DeleteMapping("/deleteJobAdvert")
	public Result deleteJobAdvert(@Valid @RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.deleteJobAdvert(jobAdvert);
	}
	
	@GetMapping("/getAllJobAdvertsSorted")
	public DataResult<List<JobAdvertWithCompanyNameDto>> getAllJobAdvertsSorted(){
		return this.jobAdvertService.findByfirstApplyDateAsc();
	}
	
	@GetMapping("/getJobAdvertsByCompanyName")
	public DataResult<List<JobAdvertWithCompanyNameDto>> getJobAdvertsByCompanyName(@RequestParam String companyName){
		return this.jobAdvertService.findBycompanyName(companyName);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidatonException(MethodArgumentNotValidException exceptions){
		Map<String,String> validationErrors = new HashMap<String,String>();
		for(FieldError fieldError:exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult(validationErrors,"Doğrulama Hataları");
		return errors;
	}

}
