package com.factapi.factapi.controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.factapi.factapi.dao.userDataRepo;
import com.factapi.factapi.factapiservices.ipservice;
import com.factapi.factapi.factapiservices.userDataService;
import com.factapi.factapi.factentities.usersData;




@RestController
public class factApiController {
    
    @Autowired
    private ipservice ipservice;

    
    @Autowired 
    private userDataRepo userDataRepo;

    @Autowired
    private userDataService uService;

    @GetMapping(path="/fact/{animal}", produces = "application/json")
    public String factapi(@PathVariable String animal, HttpServletRequest request){
        String factToReturn = null;
        
        if(animal.equals("dog")){

            // getting data
            String ip = ipservice.getIpAddress(request);
            Date date = new Date();
            String strDateFormat = "hh:mm:ss a";
            DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
            String formattedDate= dateFormat.format(date);

            factToReturn = "Their sense of smell is at least 40x better than ours";
            
            usersData data = new usersData(ip, factToReturn, formattedDate);
            uService.saveData(data);
            

            
            
        }
        if(animal.equals("cat")){
                // getting data
                String ip = ipservice.getIpAddress(request);
                Date date = new Date();
                String strDateFormat = "hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
                String formattedDate= dateFormat.format(date);
                factToReturn = "Cats sleep for around 13 to 16 hours a day (70% of their life)";
                
                usersData data = new usersData( ip, factToReturn, formattedDate);
                uService.saveData(data);
        }
        return factToReturn;
    }  

    @GetMapping("/info")
    public List<usersData> getAllData(){
      return uService.fetchUsersDatas();
    }

}
