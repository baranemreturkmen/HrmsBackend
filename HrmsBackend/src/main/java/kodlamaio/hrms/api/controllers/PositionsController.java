package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.entities.concretes.Company;
import kodlamaio.hrms.entities.concretes.Position;
import kodlamaio.hrms.business.abstracts.PositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/positions")
public class PositionsController {
	
	private PositionService positionService;
	
	@Autowired
	public PositionsController(PositionService positionService) {
		
		this.positionService = positionService;
	}
	
	@GetMapping("/getAllPositions")
	public DataResult<List<Position>> getAllPositions(){
		return this.positionService.getAllPositions();
	}
	
	@PostMapping("addCompany")
	public Result addCompany(@RequestBody Position position) {
		return this.positionService.addPosition(position);
	}

}
