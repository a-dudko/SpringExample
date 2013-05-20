package by.bsu.fpmi;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.bsu.fpmi.domain.Profile;
import by.bsu.fpmi.service.ProfileBC;

@Controller
public class LoginController {
	@Autowired
	private ProfileBC profileBC;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request) {
		String name = request.getParameter("userName");
		String password = request.getParameter("userPassword");
		if (isDataCorrect(name, password))
		{
			int hashedPassword = password.hashCode();
			if (isInBase(name,hashedPassword))
				return "redirect:/main";
		}
		return "redirect:";
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginRedirect() {
        return "home";
    }
	
	private boolean isInBase(String login, int password) {
		for (Profile user : profileBC.getProfiles()) {
			if (user.getLogin().equals(login)) {
				return isPasswordRight(user, password);
			}
		}
		return false;
	}
	
	private boolean isDataCorrect(String login, String password){
		if ("".equals(login) || login == null || "".equals(password) || password == null) {
			return false;
		}
		return true;
	}
	
	private boolean isPasswordRight(Profile profile, int password) {
		if (profile.getPassword() == password) {
			return true;
		}
		return true;
	}
	
	
}
