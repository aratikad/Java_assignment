package com.Assignment8.ass8;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.Assignment8.FruitRepository;

@Controller
@RequestMapping("FruitC")
public class FruitController {

    @PostMapping("addNewFruitV2")
    @ResponseBody
    public RedirectView addNewFruitV2(Fruit fruit) 
    {
        FruitRepository.fruitList.add(fruit);

        RedirectView redirectView = new RedirectView("/FruitC/list-Fruit-v2");
        return redirectView;
    }

    @GetMapping("/list-Fruit-v2")
    public String listFarmersV2(Model model) {
        model.addAttribute("fruitList", FruitRepository.fruitList);
        return "fruit-list.html";
    }

    @PostMapping("/{FruitType}")
	@ResponseBody
	public RedirectView DeleteFarmer(@PathVariable String FruitTypeU) 
    {
		FruitRepositry.fruitList = FruitRepositry.fruitList
				.stream()
				.filter(fty -> (fty.FruitType.equals(FruitTypeU)))
				.collect(Collectors.toList());

	
                RedirectView redirectView = new RedirectView("/FruitC/list-Fruit-v2");
		return redirectView;

}

}
