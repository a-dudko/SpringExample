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
    public List<Address> listAddress() {
 
        return addressDAO.readAll();
    }
 
    @Transactional
    public void removeAddress(Address address) {
    	addressDAO.remove(address);
    }
	
}
