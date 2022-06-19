package com.factapi.factapi.factapiservices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.factapi.factapi.factentities.usersData;

@Service
public interface userDataService {
    
    // save data
    usersData saveData(usersData uData);
    
    // read data
    List<usersData> fetchUsersDatas();
}
