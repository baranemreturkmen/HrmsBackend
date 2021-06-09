package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="jobadverts")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvert {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_advert_id")
	private int jobAdvertId;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="position_id") private Position position;
	 */
	
	//OneToMany(mappedBy = "position")
	//private list<Position> positions
	//Position entity'nin altında olacak bu
	
	//@ManyToOne
	//@JoinColumn(name="id")
	@Column(name="city_id")
	private int cityId;
	
	@Column(name="position_id")
	private int jobAdvertPositionId;
	
	//OneToMany(mappedBy = "city")
	//private list<City> cities
	//City entity'nin altında olacak bu
	
	@Column(name = "job_description")
	@NotNull
	@NotBlank
	private String jobDescription;
	
	@Column(name = "minimum_salary")
	@NotNull
	private double minSalary;
	
	@Column(name = "maximum_salary")
	private double maxSalary;
	
	@Column(name = "number_of_position")
	private int numberOfPosition;
	
	@Column(name = "last_apply_date")
	@NotNull
	private LocalDate lastApplyDate;
	
	@Column(name = "first_apply_date")
	@NotNull
	private LocalDate firstApplyDate;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="company_id")
	private Company company;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="position_id") private Position position;
	 */
	
	//Code first tablo daha sonra olusacak...
}
