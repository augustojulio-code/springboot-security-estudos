package dio.diospringsecurity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping
	public String welcome() {
		return "Wecome to my Spring boot web API";
	}
	
	@GetMapping("/users")
	@PreAuthorize("hasAnyRole('MANAGERS','USERS')")
	public String user() {
		return "Authorized user";
	}
	
	@GetMapping("/managers")
	@PreAuthorize("hasRole('MANAGERS')")
	public String managers() {
		return "Authorized managers";
	}
}
