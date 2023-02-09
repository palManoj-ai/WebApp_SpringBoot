package mavend5.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mavend5.Service.SignupService;
import mavend5.dto.UserDTO;


@Controller
public class AuthSignupController {
	
	@Autowired
	private SignupService signupService;
	

	@GetMapping("/firstpage")
	public String showSignup() {
		return "signuppage";
	}
	
	@PostMapping("/SignUp")      
	public String fetchFromSignup(@ModelAttribute UserDTO signupDTO, Model model) {
		signupService.save(signupDTO);
		model.addAttribute("message1", "Registration successfull!!");
		return "promptPage";
	}
	
	
	@PostMapping("/prompt")
	public String viewData(HttpServletRequest req, Model model) {
		String uemail=req.getParameter("email");
		UserDTO userDTO=signupService.viewUserData(uemail);
		model.addAttribute("user",userDTO);
		return "landingPage2";
	}
				
	
	@GetMapping("/allData")
	public String viewAllUsers(@RequestParam("key") String key,HttpServletRequest req, Model model) {
		List<UserDTO> signupList=signupService.viewAllData();
		String uemail=key;
		UserDTO selectedUserDTO=signupService.viewUserData(uemail);

		model.addAttribute("user",selectedUserDTO);
		model.addAttribute("listofuser",signupList);
		return "landingPage2";		
	}
	
	@GetMapping("/deleteRow")
	public String deleteUser(@RequestParam("key") String key,@RequestParam("keydel") String keydel, Model model){
		String uemail=key;
		UserDTO userDTO=signupService.viewUserData(uemail);
		model.addAttribute("user",userDTO);
		signupService.deleteUserFromTable(keydel);
		List<UserDTO> signupListAfterDeletion=signupService.viewAllData();
		model.addAttribute("listofuser",signupListAfterDeletion);
		return "landingPage2";
	}
	
	@GetMapping("/sortAsc")
	public String sortbyAsc(@RequestParam("sort") String orderAsc,@RequestParam("key") String key, Model model){
		String uemail=key;
		UserDTO userDTO=signupService.viewUserData(uemail);
		model.addAttribute("user",userDTO);
		List<UserDTO> sortedListAsc=signupService.sort(orderAsc);
		model.addAttribute("listofuser",sortedListAsc);
		return "landingPage2";
	}
	
	@GetMapping("/sortDsc")
	public String sortbyDsc(@RequestParam("sort") String orderDsc,@RequestParam("key") String key, Model model){
		String uemail=key;
		UserDTO userDTO=signupService.viewUserData(uemail);
		model.addAttribute("user",userDTO);
		List<UserDTO> sortedListDsc=signupService.sort(orderDsc);
		model.addAttribute("listofuser",sortedListDsc);
		return "landingPage2";
	}
	
	@GetMapping("/editRow")
	public String editRow(@RequestParam("key") String uemail,@RequestParam("keyedit") String editEntry, Model model) {
		UserDTO userDTO=signupService.viewUserData(uemail);
		model.addAttribute("user",userDTO);
		UserDTO userEdit=signupService.viewUserData(editEntry);
		model.addAttribute("editUser",userEdit);
		model.addAttribute("key",uemail);
		return "editPage";
	}
	
	@PostMapping("/editUser")
	public String editUser(@RequestParam("key") String uemail, HttpServletRequest req, Model model) {
		String email=req.getParameter("email"); 
		String paswd=req.getParameter("password"); 
		String phone=req.getParameter("phoneno");
		signupService.update(email,paswd,phone);
		
		List<UserDTO> signupListAfterUpdate=signupService.viewAllData();
		model.addAttribute("listofuser",signupListAfterUpdate);
		
		UserDTO userDTO=signupService.viewUserData(uemail);
		model.addAttribute("user",userDTO);
		return "landingPage2";	
	}
	
	
				
}
