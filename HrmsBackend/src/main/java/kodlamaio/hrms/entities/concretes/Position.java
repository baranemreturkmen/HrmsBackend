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
@Table(name="positions")
@AllArgsConstructor
@NoArgsConstructor
public class Position {
	
	//Bu class postgresql tarafında oluşturulan positions tablosunu tutmaktadır.
	//Data anotasyonu ile lombok dahil edildi ve getterları setterları default constructor'ı otomatik olarak oluşturdu.
	//Anotayon bir class'ın veya bir metodun çalışma anında bilgisni toplayan yapı. C#'da karşılığı attribute
	//angular karşılığı decorator. 
	//Hibernate yerine Jpa alt yapısını kullanabilmek adına javax.persistance import edildi.
	//Entity anotasyonu ile spring framework'e bu class'ımızın Entity katmanına karşılık geldiğini söylüyoruz.	
	//Entity demek bu class'a veritabanı nesnesi olduğunu söylemek demek. Veritabanında bu class'ın hangi 
	//tabloya karşılık geleceğini söylemek adına Table anotasyonu kullanıyoruz. Class'ımın özelliklerinin 
	//veritabanında kullandığım tablonun hangi kolonuna karşılık geldiğini söylemek adına Column anotasyonu
	//kullanılır. Kolon isimleri tabloda nasılsa burada Column anotasyonu içersinde birebir şekilde girmek önemli
	//Id anotasyonu tabloda ana işlemlerin yapılacağı ve diğer tablolarla haberleşmeyi sağlayan primarykey olan
	//id kolonuna verilir. Bu kolon sayesinde diğer tablolarla bağlantı sağlanır. Github readme dosyasının içerisinde
	//bu bağlantıların ve haberleşmelerin nasıl gerçekleştiği detaylı bir şekilde açıklanmıştır. GeneratedValue 
	//anotasyonu postgresql tarafında id kolonun auto increment olduğunu yani  tablouya her bir veri eklenmesi 
	//id'nin otomatikman birer birer artacağını söylüyor.
		
	//Diğer tabloları tutan classlarım içinde yukarıdaki yorum aynen geçerlidir.
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="position_id")
	private int positionId;
	
	@Column(name="position_name")
	@NotNull
	@NotBlank
	private String positionName;
	
	@Column(name="abbreviation_name")
	private String abbreviationName;
	
	
	/*
	 * @OneToMany(mappedBy = "position") private List<JobAdvert> jobAdverts;
	 */
	 
}
