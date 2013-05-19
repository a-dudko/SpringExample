package by.bsu.fpmi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.bsu.fpmi.dao.CommentDAO;
import by.bsu.fpmi.domain.Comment;

@Service
public class CommentBC {

	@Autowired
    private CommentDAO commentDAO;
     
    @Transactional
    public void addComment(Comment comment) {
        commentDAO.add(comment);
    }
 
    @Transactional
    public List<Comment> getComments() {
        return commentDAO.readAll();
    }
    
    @Transactional
    public int getCounts() {
    	List<Comment> comments = getComments();
    	if (comments != null) {
    		return comments.size();
    	}
    	return 0;
    }
    
    @Transactional
    public Comment getComment(Integer id) {
        return commentDAO.read(id);
    }   
    
    @Transactional
    public void updateComment(Comment comment) {
        commentDAO.update(comment);
    }
 
    @Transactional
    public void removeComment(Comment comment) {
    	commentDAO.remove(comment);
    }
}
