package com.Assignment8.ass8;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;



@Controller
@RequestMapping("FruitC")
public class FruitController {



    @GetMapping("/list-Fruit-v2")
    public String listFarmersV2(Model model) {
        model.addAttribute("fruitList", FruitRepositry.fruitList);
        return "fruit-list.html";
    }


    @PostMapping("addNewFruitV2")
    @ResponseBody
    public RedirectView addNewFruitV2(@Valid Fruit fruit) 
    {
        FruitRepositry.fruitList.add(fruit);

        RedirectView redirectView = new RedirectView("/FruitC/list-Fruit-v2");
       
        return redirectView;
    }

    
    @GetMapping("/{FruitType}")
	@ResponseBody
	public RedirectView FruitListByType(@PathVariable String FruitTypeU) 
    {
		FruitRepositry.fruitList = FruitRepositry.fruitList
				.stream()
				.filter(fty -> (fty.FruitType.equals(FruitTypeU)))
				.collect(Collectors.toList());

                RedirectView redirectView = new RedirectView("/FruitC/list-Fruit-v2");
		return redirectView;

}









///////////////////////


@GetMapping("/list")
@ResponseBody
public List<Fruit> abc2() {

    return FruitRepositry.fruitList;

}

@PostMapping("/TypeFruitListM")
@ResponseBody
public RedirectView TypeFruitListM(String FruitTypeU) 
{
    FruitRepositry.fruitList = FruitRepositry.fruitList
            .stream()
            .filter(fty -> (fty.FruitType.equals(FruitTypeU)))
            .collect(Collectors.toList());


            RedirectView redirectView = new RedirectView("/FruitC/list-Fruit-v2");
    return redirectView;

}





}
