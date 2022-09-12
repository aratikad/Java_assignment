package com.miniProject2.Bestfarm.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.miniProject2.Bestfarm.model.Farmer;
import com.miniProject2.Bestfarm.services.FarmerService_V2;

@Controller
public class HomeController {
    
    @Autowired
    FarmerService_V2 farmerService;


  @GetMapping("/searchAndEdit1")
  public String IndexPage(Model model)
  {
      return "resultSearchFarmerDetails.html";
  }


  @RequestMapping(value="/farmers/SearchfarmersByName",method ={RequestMethod.GET,RequestMethod.POST} )
	public String searchFarmerByName(@RequestParam String fname,HttpServletRequest httpServletRequest,Model model) 
    {
        System.out.println("inside search method ");

              {
                List<Farmer> ListOfFarmers= farmerService.searchFarmerByName(fname);
                model.addAttribute("farmerList",ListOfFarmers);
                model.addAttribute("farmer_name",fname);
                
                System.out.println("size of list ="+ListOfFarmers.size());

              }

              return "resultSearchFarmerDetails.html";
    }

} 














/* 
    @RequestMapping(value="/farmers/delete/{farmerId}",method ={RequestMethod.GET} )
    public RedirectView deleteFarmerByName(@PathVariable int farmerId) 
{

 System.out.println(""+farmerId);

     farmerService.deleteFarmerById(farmerId);
 
     RedirectView redirectView = new RedirectView("/");
     return redirectView;

}

}
*/