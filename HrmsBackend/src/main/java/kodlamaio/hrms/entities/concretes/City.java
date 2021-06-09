package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="cities")
@AllArgsConstructor
@NoArgsConstructor
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="city_name")
	@NotNull
	@NotBlank
	private String cityName;
	
	//@OneToMany(mappedBy = "city")
	//private List<JobAdvert> jobAdverts;
	//sehir bilgisi goruntulensin istemiyor JobAdvertsListde sadece JobAdevert'da bilgi olarak bulunsun istiyor sehirler.
	//Ama sonucta bilgi olarak istiyor yanından ve coklu secim istiyor bu durumda baglanti olsun Dao tarafında query'nin 
	//icerisinde kullanılmasın. Sonucta bu bilgi coklu multiple secilebilir bicimde olacak ama listelerken gorunmeyecek!!!
	
	//Ha bak bu arada bu bir kolon degil sehir eklerken swagger tarafında karsıma cıkmayacak bence.
	
	//Tum yorumları unut sehir tablosu ile ilgili.
	
	//Manuel bagla postgresql'de City ile JobAdvert'ı. Foreign key city_id JobAdvert uzerinde. Zaten City uzerinde
	//primary key kendi id'si.
	
}
