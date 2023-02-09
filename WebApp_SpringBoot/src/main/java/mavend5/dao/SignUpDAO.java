package mavend5.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mavend5.Model.SignupModel;


@Repository
public class SignUpDAO {
	
	//this function is replaced by SignupModel java file which uses Hibernate entity alongwith JPARepository feature 
	//provided by Hibernate with interface of spring data JPA.
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void save(SignupModel signupModel) {
		String sqlCommand="insert into tableday8 values(?,?,?)";
		Object[] obj={signupModel.getEmail(),signupModel.getPassword(),signupModel.getPhoneno()};
		jdbcTemplate.update(sqlCommand, obj);
	}
	
	public SignupModel viewUserData(String email){
		String sqlCommand="select email,password,phone as phoneno from tableday8 where email=?";
		Object[] obj= {email};
//		UserDTO signupUser=(UserDTO)jdbcTemplate.queryForObject(sqlCommand, obj,new BeanPropertyRowMapper<>(UserDTO.class));
		List<SignupModel> signupUser=jdbcTemplate.query(sqlCommand, obj,new BeanPropertyRowMapper<>(SignupModel.class));
		return signupUser.get(0);
		}

	public List<SignupModel> viewAllData(){
		String sqlCommand="select email,password,phone as phoneno from tableday8";
		List<SignupModel> signupList=jdbcTemplate.query(sqlCommand, new BeanPropertyRowMapper<>(SignupModel.class));
		return signupList;
		}

	public void deleteUserFromTable(String demail) {
		String sqlCommand="delete from tableday8 where email=?";
		Object[] obj= {demail};
		jdbcTemplate.update(sqlCommand, obj);
		
	}

	public List<SignupModel> sort(String order) {
			String sqlCommand=("select email,password,phone as phoneno from tableday8 order by email "+order);
			List<SignupModel> signupList=jdbcTemplate.query(sqlCommand, new BeanPropertyRowMapper<>(SignupModel.class));
			return signupList;
		}


	public void update(String email, String paswd, String phone) {
		String sqlCommand=("update tableday8 set password=?,phone=? where email=?");
		Object[] obj= {paswd,phone,email};
		jdbcTemplate.update(sqlCommand, obj);
		
		
	}

	}
		
