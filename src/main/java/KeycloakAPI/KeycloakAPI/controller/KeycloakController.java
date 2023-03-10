package KeycloakAPI.KeycloakAPI.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class KeycloakController {
	
	@Autowired
	public KeycloakController() {
		
	}
	
	
	@GetMapping("/data")
	public ResponseEntity<String> getData(){
		String data = "data";
		System.out.println(data);
		return new ResponseEntity<String>(data,HttpStatus.OK);
	}
	
	@GetMapping(path = "/customers")
	public String customers(Principal principal, Model model) {

	    model.addAttribute("username", principal.getName());
	    System.out.println(principal);
	    System.out.println(model);
	    return "customers";
	}
	
	
	

}
