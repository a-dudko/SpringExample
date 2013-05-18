package by.bsu.fpmi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import by.bsu.fpmi.domain.Comment;

@Repository
public class CommentDAO implements ICRUDRepository<Comment>{

	@Override
	public void add(Comment item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Comment> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Comment item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Comment item) {
		// TODO Auto-generated method stub
		
	}

}
