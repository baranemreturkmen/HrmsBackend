package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="companys")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdverts"})
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="company_id")
	private int companyId;
	
	@Column(name="company_name")
	@NotNull
	@NotBlank
	private String companyName;
	
	@Column(name="web_site")
	@NotNull
	@NotBlank
	private String webSite;
	
	@Column(name="phone_number")
	@NotNull
	@NotBlank
	private String phoneNumber;
	
	@NotNull
	@Column(name="user_id")
	private int userId;
	
	@NotNull
	@Column(name="position_id_fk")
	private int positionIdFk;
	
	@OneToMany(mappedBy = "company")
	private List<JobAdvert> jobAdverts;
	
	//Adam önden girer user'ını pozisyonu da bir tane coklu butondan alır. Frontend tarafında
	//User otomatik atanır. Ama illaki bir tane pozisyon lazım. User Onceki sayfada girdigi bilgiler 
	//Otomatik eklenecek adama. companys ile users left join. companys'deki bilgiler tutulacak hepsi
	//karsiligi yoksa users'da users'da o taraf tutulmasın. Yine members ile users yine left join. Sıfırdan
	//kodla olusacak bu tablolar. Ama join islemi nerenin uzerinden olacak ??? user'ın id'si ile company ve
	//member id leri üzerinden olacak zaten primarykey foreign key bu yuzden var.
	//SIFRE TEKRARI ???
	//TELEFON NUMARASI TC VALİSDASYONLARI NEREDE MESELA USERS'DA EMAIL ICIN VAR.

}
