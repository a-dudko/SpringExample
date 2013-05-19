package by.bsu.fpmi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.bsu.fpmi.service.EventBC;

@Controller
public class EventsListController {
	@Autowired
    private EventBC eventBC;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
    public String getPosts(@RequestParam(value = "page", required = false) Integer page,
                           @RequestParam(value = "size", required = false) Integer size,
                           ModelMap modelMap) {
        page = page == null ? 1 : page;
        int sizeNo = size == null ? 5 : size.intValue();
        int start = page == null ? 0 : (page.intValue() - 1) * sizeNo;
        float nrOfPages = (float) eventBC.listEvent().size() / sizeNo;
        int maxPages = (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages);
        
        modelMap.addAttribute("posts", eventBC.getRange(start, sizeNo));
        modelMap.addAttribute("maxPages", maxPages);
        modelMap.addAttribute("page", page);
        return "eventsList";
    }
}
