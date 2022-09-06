package com.assignment_10.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.assignment_10.model.Retailer;
import com.assignment_10.repositries.RetailerRepositry_V2;


@Service
public class RetailerService_V2 {

    @Autowired
    RetailerRepositry_V2 retailerRepositry;

    public List<Retailer> getAllRetailers() 
    {
        List<Retailer> retailersList = new ArrayList<Retailer>();
           retailerRepositry.findAll().forEach(retailer -> retailersList.add(retailer));
        return retailersList;
    }

//@Transactional
    public Retailer addRetailer(Retailer retailer){
        return retailerRepositry.save(retailer);
   }

   


}
