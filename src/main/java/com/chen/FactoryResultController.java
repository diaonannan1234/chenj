package com.chen;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/factory")
public class FactoryResultController {

    @Autowired private FactoryResultRepository factoryResultRepository;

    @GetMapping()
    public String getAll(int year,int month,Model model){

        List<FactoryResult> result = factoryResultRepository.findAll(year,month);

         model.addAttribute("result",result);
         return "factoryResult";
    }





}
