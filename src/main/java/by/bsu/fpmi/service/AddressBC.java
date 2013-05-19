package by.bsu.fpmi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.bsu.fpmi.dao.AddressDAO;
import by.bsu.fpmi.domain.Address;

@Service
public class AddressBC {

	@Autowired
    private AddressDAO addressDAO;
     
    @Transactional
    public void addAddress(Address address) {
        addressDAO.add(address);
    }
 
    @Transactional
    public List<Address> getAddresses() {
        return addressDAO.readAll();
    }
    
    @Transactional
    public int getCounts() {
    	List<Address> addresses = getAddresses();
    	if (addresses != null) {
    		return addresses.size();
    	}
    	return 0;
    }
    
    @Transactional
    public Address getAddress(Integer id) {
        return addressDAO.read(id);
    }   
    
    @Transactional
    public void updateAddress(Address address) {
        addressDAO.update(address);
    }
 
    @Transactional
    public void removeAddress(Address address) {
    	addressDAO.remove(address);
    }
	
}
