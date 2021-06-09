package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="members")
@AllArgsConstructor
@NoArgsConstructor
public class Member {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	@NotNull
	@NotBlank
	private String name;
	
	@Column(name="surname")
	@NotNull
	@NotBlank
	private String surname;
	
	@Column(name="citizenship_number")
	@NotNull
	@NotBlank
	private String citizenshipNumber;
	
	@Column(name="birth_date")
	@NotNull
	private LocalDate birthDate;
	
	@Column(name="role_id")
	private int roleId;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="position_id")
	@NotNull
	private int positionId;
	
	//User yine onceki sayfadan adam bilgilerini girdi.
	//Aslında role id'yi onden girecek sistem girisi veya kullancı girisinden girecek ona gore role id atancak.

}
