package com.factapi.factapi.factapiservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factapi.factapi.dao.userDataRepo;
import com.factapi.factapi.factentities.usersData;

@Service
public class userDataServiceImp implements userDataService{
     
    @Autowired
    private userDataRepo uDataRepo;

    @Override
    public usersData saveData(usersData uData) {
        return uDataRepo.save(uData);
    }

    @Override
    public List<usersData> fetchUsersDatas() {
        return (List<usersData>) uDataRepo.findAll();
    }
    
}
