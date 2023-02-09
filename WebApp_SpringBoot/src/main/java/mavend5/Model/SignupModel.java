package mavend5.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//Entities in JPA are nothing but POJOs representing data that can be persisted to the database. 
//An entity represents a table stored in a database. Every instance of an entity represents a row in the table.
//more: https://www.baeldung.com/jpa-entities
@Table(name="tableday5")
//entity relates to this table, schema and connection defined in the properties file
public class SignupModel {
	
	//ID means primary key in database
	@Id
	String email;
	@Column(length = 45)
	String password;
	@Column(length = 60)
	String phoneno;
	public SignupModel() {}
	public SignupModel(String email, String password, String phoneno) {
		
		super();
		this.email = email;
		this.password = password;
		this.phoneno = phoneno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
	
	

}
