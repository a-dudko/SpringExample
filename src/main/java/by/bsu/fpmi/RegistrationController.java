package by.bsu.fpmi;
 
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.bsu.fpmi.additionallibs.TagsParser;
import by.bsu.fpmi.domain.Profile;
 
@Controller
public class RegistrationController {
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String login() {
        return "registration";
    }
    
    @RequestMapping(value = "/registration/success", method = RequestMethod.GET)
    public String redirectToHome() {
        return "redirect:../";
    }
    
    @RequestMapping(value = "/registration/success", method = RequestMethod.POST)
    public String successfulRegistration(HttpServletRequest request) {
    	Profile profile = new Profile();
		
		String login = request.getParameter("userLogin");
		String age = request.getParameter("age");
		
		profile.setAge(Integer.parseInt(age));
		
		String tags = request.getParameter("desc");
		TagsParser tagsParser = TagsParser.getInstance();
    	return "home";
    }
}