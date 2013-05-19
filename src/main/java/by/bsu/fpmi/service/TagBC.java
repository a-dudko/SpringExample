package by.bsu.fpmi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.bsu.fpmi.dao.TagDAO;
import by.bsu.fpmi.domain.Tag;

@Service
public class TagBC {

	@Autowired
    private TagDAO tagDAO;
     
    @Transactional
    public void addTag(Tag tag) {
        tagDAO.add(tag);
    }
 
    @Transactional
    public List<Tag> getTags() {
        return tagDAO.readAll();
    }
    
    @Transactional
    public int getCounts() {
    	List<Tag> tags = getTags();
    	if (tags != null) {
    		return tags.size();
    	}
    	return 0;
    }
    
    @Transactional
    public Tag getTag(Integer id) {
        return tagDAO.read(id);
    }   
    
    @Transactional
    public void updateTag(Tag tag) {
        tagDAO.update(tag);
    }
 
    @Transactional
    public void removeTag(Tag tag) {
    	tagDAO.remove(tag);
    }
	
}
