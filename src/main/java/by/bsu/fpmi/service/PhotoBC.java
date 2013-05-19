package by.bsu.fpmi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.bsu.fpmi.dao.PhotoDAO;
import by.bsu.fpmi.domain.Photo;

@Service
public class PhotoBC {

	@Autowired
    private PhotoDAO photoDAO;
     
    @Transactional
    public void addPhoto(Photo photo) {
        photoDAO.add(photo);
    }
 
    @Transactional
    public List<Photo> getPhotos() {
        return photoDAO.readAll();
    }
    
    @Transactional
    public int getCounts() {
    	List<Photo> photos = getPhotos();
    	if (photos != null) {
    		return photos.size();
    	}
    	return 0;
    }
    
    @Transactional
    public Photo getPhoto(Integer id) {
        return photoDAO.read(id);
    }   
    
    @Transactional
    public void updatePhoto(Photo photo) {
        photoDAO.update(photo);
    }
    
    @Transactional
    public void removePhoto(Photo photo) {
    	photoDAO.remove(photo);
    }
}
