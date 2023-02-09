package mavend5.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import mavend5.Model.SignupModel;
import mavend5.dao.SignupRepository;
import mavend5.dto.UserDTO;

@Service
public class SignupService {
	//Service layer 

	
//	@Autowired
//	private SignUpDAO signUpDAO;
	
	@Autowired
	private SignupRepository signupRepository;

	public void save(UserDTO signupDTO) {
		SignupModel signupModel=new SignupModel();
		BeanUtils.copyProperties(signupDTO, signupModel);
		signupRepository.save(signupModel);
		
		
	}

	public UserDTO viewUserData(String uemail) {
		UserDTO signupDTO=new UserDTO();
//		SignupModel signupModel=signUpDAO.viewUserData(uemail);
		SignupModel signupModel=signupRepository.getOne(uemail);
		BeanUtils.copyProperties(signupModel,signupDTO);
		return signupDTO;
	}

	public List<UserDTO> viewAllData() {
//		List<SignupModel> signupModelList =signUpDAO.viewAllData();
		List<SignupModel> signupModelList =signupRepository.findAll();
		List<UserDTO> signupList=new ArrayList<UserDTO>();
		for(SignupModel signupModel:signupModelList) {
			UserDTO signupDTO=new UserDTO();
			BeanUtils.copyProperties(signupModel,signupDTO);
			signupList.add(signupDTO);
		}
		return signupList;		
	}

	public void deleteUserFromTable(String keydel) {
//		signUpDAO.deleteUserFromTable(keydel);
		signupRepository.deleteById(keydel);
	}

	public List<UserDTO> sort(String order) {
//		List<SignupModel> signupModelList =signUpDAO.sort(order);
		List<SignupModel> signupModelList=new ArrayList<SignupModel>();
		List<UserDTO> signupList=new ArrayList<UserDTO>();
		if(order.equalsIgnoreCase("asc")) {
			signupModelList =signupRepository.findAll(Sort.by("email").ascending());
		}else if (order.equalsIgnoreCase("desc")){
			signupModelList =signupRepository.findAll(Sort.by("email").descending());
		}else {		
		}
		for(SignupModel signupModel:signupModelList) {
			UserDTO signupDTO=new UserDTO();
			BeanUtils.copyProperties(signupModel,signupDTO);
			signupList.add(signupDTO);	
		}
		return signupList;		
		
//		List<UserDTO> sortedSignupList=new ArrayList<UserDTO>();
//		for(SignupModel signupModel:signupModelList) {
//			UserDTO signupDTO=new UserDTO();
//			BeanUtils.copyProperties(signupModel,signupDTO);
//			sortedSignupList.add(signupDTO);
//		}
//		return sortedSignupList;
	}

	public void update(String email, String paswd, String phoneno) {
//		signUpDAO.update(email, paswd, phone);
		SignupModel signupModel=signupRepository.getOne(email);
		signupModel.setPassword(paswd);
		signupModel.setPhoneno(phoneno);
		signupRepository.save(signupModel);
		
	}
}
