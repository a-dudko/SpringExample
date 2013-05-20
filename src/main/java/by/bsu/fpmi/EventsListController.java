package by.bsu.fpmi;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.bsu.fpmi.domain.Event;
import by.bsu.fpmi.domain.Profile;
import by.bsu.fpmi.service.EventBC;

@Controller
public class EventsListController {
	@Autowired
    private EventBC eventBC;
		
	private String currentUser;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
    public String getPosts(@RequestParam(value = "page", required = false) Integer page,
                           @RequestParam(value = "size", required = false) Integer size,
                           @RequestParam(value = "user", required = true) String user,
                           ModelMap modelMap) {
		currentUser = user;
		page = page == null ? 1 : page;
        int sizeNo = size == null ? 5 : size.intValue();
        int start = page == null ? 0 : (page.intValue() - 1) * sizeNo;
        float nrOfPages = (float) eventBC.getCounts() / sizeNo;
        int maxPages = (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages);
        
        modelMap.addAttribute("events", eventBC.getRange(start, sizeNo));
        modelMap.addAttribute("maxPages", maxPages);
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("user", currentUser);
        return "eventsList";
    }
	
	@RequestMapping(value = "/main/newevent", method = RequestMethod.POST) 
	public String createEvent (HttpServletRequest request){
		if (! checkParameters(request.getParameterMap())) {
			return "redirect:/main/create";
		}
    	Event event = makeEvent(request);
		eventBC.addEvent(event);
		return "redirect:/main?user="+currentUser;
	}
	
	@RequestMapping(value = "/main/create", method = RequestMethod.GET) 
	public String createEvent (){
		return "createEvent";
	}
	
	private boolean checkParameters(Map<String,String[]> params) {
    	String title = params.get("eventTitle")[0];
    	if ("".equals(title)) {
    		return false;
    	}
    	return !isInBase(title);
    }
    
    private boolean isInBase(String title) {
		for (Event event : eventBC.getEvents()) {
			if (event.getName().equals(title)) {
				return true;
			}
		}
		return false;
	}
	
	private Event makeEvent(HttpServletRequest request) {
		Event event = new Event();
		event.setName(request.getParameter("eventTitle"));
		event.setDescription(request.getParameter("description"));
		
		return event;
	}
}
