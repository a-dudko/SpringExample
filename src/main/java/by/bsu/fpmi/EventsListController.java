package by.bsu.fpmi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EventsListController {
	@RequestMapping(value = "/main", method = RequestMethod.GET)
    public String getPosts(@RequestParam(value = "page", required = false) Integer page,
                           @RequestParam(value = "size", required = false) Integer size) {
        ModelMap modelMap = new ModelMap(); 
		page = page == null ? 1 : page;
        int sizeNo = size == null ? 5 : size.intValue();
        int start = page == null ? 0 : (page.intValue() - 1) * sizeNo;
        float nrOfPages = (float) 1 / sizeNo;
        int maxPages = (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages);
        
        modelMap.addAttribute("posts", 0);
        modelMap.addAttribute("maxPages", maxPages);
        modelMap.addAttribute("page", page);
        return "eventsList";
    }
}
