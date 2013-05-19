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
    public List<Comment> listComment() {
 
        return commentDAO.readAll();
    }
 
    @Transactional
    public void removeComment(Comment comment) {
    	commentDAO.remove(comment);
    }
}
