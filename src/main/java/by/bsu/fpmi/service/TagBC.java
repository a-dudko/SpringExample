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
    public List<Tag> listTag() {
 
        return tagDAO.readAll();
    }
 
    @Transactional
    public void removeTag(Tag tag) {
    	tagDAO.remove(tag);
    }
	
}
