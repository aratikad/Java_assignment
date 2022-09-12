package com.miniProject2.Bestfarm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindContext;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.miniProject2.Bestfarm.model.Farmer;
import com.miniProject2.Bestfarm.repositries.FarmerRepositry_V2;
import com.miniProject2.Bestfarm.services.FarmerService_V2;

@RestController
@RequestMapping("api")
public class FarmerRestController {



    @Autowired
    FarmerService_V2 farmerService;
  

    @GetMapping("/farmers/list")
    @ResponseBody
    public List<Farmer> allFarmers()
    {
        return farmerService.getAllFarmers();
    }


    

/*

BindingResult =holds the result of a validation and binding and contains errors that may have occurred.

 */

    @PostMapping("/farmers/addnewfarmer")
    public String addNewFarmer_V3(@RequestBody @Valid Farmer farmer, BindingResult br) {
        if (br.hasErrors()) {
            return "{\"message\":\"Failed to added farmer\"}";
        } 
        else {
            farmerService.addFarmer(farmer);
            return "{\"message\":\"Farmer added successfully\"}";  //return json string
        }
    }


}

    








//,consumes = {  MediaType.APPLICATION_FORM_URLENCODED_VALUE } 
 /* for get//

    @GetMapping( value={"/farmers/addnewfarmer"} )
    public String addFarmer(@Valid Farmer farmer,BindingResult br)
    {   
        System.out.println("form data: "+farmer.getFname());
        // Save the farmer in the DB
    
if(br.hasErrors())
  return "{\"message\":\"farmer not  added successfully validation Error\"}";

       farmerService.addFarmer(farmer);
       // RedirectView redirectView = new RedirectView("/farmers/addnewfarmer"); 
        return "{\"message\":\"farmer added successfully\"}";
    }
*/
   
