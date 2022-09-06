package com.assignment_10.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.assignment_10.model.Retailer;
import com.assignment_10.service.RetailerService_V2;

@Controller
@RequestMapping("jpa/retailerC")
public class RetailerController_V2
{

        @Autowired
        RetailerService_V2 retailerService;

        @GetMapping("/retailers/list")
        @ResponseBody
        public List<Retailer> allRetailers()
        {
            return retailerService.getAllRetailers();
        }



    @PostMapping("/retailers/addR")
    @ResponseBody
    public RedirectView addRetailer(@Valid Retailer retailer)
    {   
        // Save the retailer in the DB
        
        retailerService.addRetailer(retailer);
        RedirectView redirectView = new RedirectView("/jpa/retailerC/retailers/list"); 
        return redirectView;
    }



}