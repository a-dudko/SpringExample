package by.bsu.fpmi;
 
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.bsu.fpmi.additionallibs.TagsParser;
import by.bsu.fpmi.domain.Profile;
import by.bsu.fpmi.domain.Sex;
import by.bsu.fpmi.domain.Tag;
import by.bsu.fpmi.service.ProfileBC;
 
@Controller
public class RegistrationController {
    @Autowired
    private ProfileBC profileBC;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String login() {
        return "registration";
    }
    
    @RequestMapping(value = "/registration/success", method = RequestMethod.GET)
    public String redirectToHome() {
        return "redirect:/registration";
    }
    
    @RequestMapping(value = "/registration/success", method = RequestMethod.POST)
    public String successfulRegistration(HttpServletRequest request) {
    	if (! checkParameters(request.getParameterMap())) {
			redirectToHome();
		}
		profileBC.addProfile(makeProfile(request));    	
    	return "home";
    }
    
    private boolean checkParameters(Map<String,String[]> params) {
    	
    	for (Entry<String,String[]> param: params.entrySet()) {
    		String paramValue = param.getValue()[0];
    		if ("".equals(paramValue) || paramValue == null) {
    			return false;
    		}
    	}
    	String password = params.get("passid")[0];
    	String repeatPassword = params.get("reppassid")[0];
    	if (! repeatPassword.equals(password)) {
    		return false;
    	}
    	return isInBase(params.get("userName")[0]);
    }
    
    private boolean isInBase(String login) {
		for (Profile user : profileBC.getProfiles()) {
			if (user.getLogin().equals(login)) {
				return true;
			}
		}
		return false;
	}
    
    private Profile makeProfile(HttpServletRequest request) {
    	Profile profile = new Profile();
		profile.setLogin(request.getParameter("userLogin"));
		profile.setPassword(request.getParameter("passid").hashCode());
		profile.setAge(Integer.parseInt(request.getParameter("age")));
		profile.setEmail(request.getParameter("email"));
		profile.setSex(Sex.valueOf(request.getParameter("sex")));
		String tagsFromRequest = request.getParameter("desc");
		profile.setTags(makeTags(tagsFromRequest, profile, request));
		return profile;
    }
    
    private Set<Tag> makeTags(String tagsFromRequest, Profile profile, HttpServletRequest request) {
    	TagsParser tagsParser = TagsParser.getInstance();
		Set<Tag> tags = tagsParser.parse(tagsFromRequest);
		for (Tag tag: tags) {
			tag.getUserProfiles().add(profile);
		}
		addCheckboxAttributes(tags, request);
		return tags;
    }

	private void addCheckboxAttributes(Set<Tag> tags, HttpServletRequest request) {
		
		
	}
}