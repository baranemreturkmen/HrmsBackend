package kodlamaio.hrms.entities.concretes.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertWithCompanyNameDto {
	
	private int jobAdvertId;
	private int jobAdvertPositionId;
	private int numberOfPosition;
	private LocalDate firstApplyDate;
	private LocalDate lastApplyDate;
	private String companyName;

}
