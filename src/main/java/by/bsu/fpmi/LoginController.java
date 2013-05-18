package by.bsu.fpmi;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request) {
		String name = request.getParameter("userName");
		String password = request.getParameter("userPassword");
		
		if (name.equals("Artur") && password.equals("1234"))
			return "login";
		else 
			return "redirect:";
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginRedirect() {
        return "home";
    }
}
