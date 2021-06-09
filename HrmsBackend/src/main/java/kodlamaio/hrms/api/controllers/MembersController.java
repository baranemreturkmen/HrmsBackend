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
import kodlamaio.hrms.business.abstracts.MemberService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Member;
import kodlamaio.hrms.entities.concretes.Position;


@RestController
@RequestMapping("/api/members")
public class MembersController {
	
	private MemberService memberService;
	
	@Autowired
	public MembersController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	//Tüm memberları değil sadece iş arayanları listeleyecek bir metod oluşturdum.
	@GetMapping("/getAllJobSeekers")
	public DataResult<List<Member>> getAllJobSeekers(){
		return this.memberService.getAllJobSeekers();
	}
	
	@PostMapping("addMember")
	public Result addMember(@Valid @RequestBody Member member) {
		return this.memberService.addMember(member);
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
