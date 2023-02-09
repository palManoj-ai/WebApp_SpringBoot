package mavend5.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mavend5.Model.SignupModel;

@Repository
public interface SignupRepository extends JpaRepository<SignupModel, String>{
	//<entity class name, data type of primary key
	//jparepositoy has inbuilt methods for CRUD operation
	//methods such as .save(), findById, delete, see implementation on signupservice
	
	
	//can also define custom implementation without coding eg
	
//	public Optional<SignupModel> findByEmail(String email); 
//	public Optional<SignupModel> findByPhoneno(String phoneno);
	//no need to define the methods and write their code
	
	//eg List<Person> findDistinctPeopleByLastnameOrFirstname(String lastname, String firstname);
	//more on
	//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
	
	

}
