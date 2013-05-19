package by.bsu.fpmi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.bsu.fpmi.dao.MusicDAO;
import by.bsu.fpmi.domain.Music;

@Service
public class MusicBC {

	@Autowired
    private MusicDAO musicDAO;
     
    @Transactional
    public void addMusic(Music music) {
        musicDAO.add(music);
    }
 
    @Transactional
    public List<Music> getMusics() {
        return musicDAO.readAll();
    }
    
    @Transactional
    public int getCounts() {
    	List<Music> musics = getMusics();
    	if (musics != null) {
    		return musics.size();
    	}
    	return 0;
    }
    
    @Transactional
    public Music getMusic(Integer id) {
        return musicDAO.read(id);
    }   
    
    @Transactional
    public void updateMusic(Music music) {
        musicDAO.update(music);
    }
 
    @Transactional
    public void removeMusic(Music music) {
    	musicDAO.remove(music);
    }
}
