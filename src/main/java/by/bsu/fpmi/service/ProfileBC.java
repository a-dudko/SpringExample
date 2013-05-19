package by.bsu.fpmi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.bsu.fpmi.dao.ProfileDAO;
import by.bsu.fpmi.domain.Profile;

@Service
public class ProfileBC {

	@Autowired
    private ProfileDAO profileDAO;
     
    @Transactional
    public void addProfile(Profile profile) {
        profileDAO.add(profile);
    }
 
    @Transactional
    public List<Profile> getProfiles() {
        return profileDAO.readAll();
    }
    
    @Transactional
    public int getCounts() {
    	List<Profile> profiles = getProfiles();
    	if (profiles != null) {
    		return profiles.size();
    	}
    	return 0;
    }
    
    @Transactional
    public Profile getProfile(Integer id) {
        return profileDAO.read(id);
    }   
    
    @Transactional
    public void updateProfile(Profile profile) {
        profileDAO.update(profile);
    }
 
    @Transactional
    public void removeProfile(Profile profile) {
    	profileDAO.remove(profile);
    }
	
}
