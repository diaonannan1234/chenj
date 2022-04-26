package com.example.jpa.web;

import com.example.jpa.Util.UserUtils;
import com.example.jpa.domain.Department;
import com.example.jpa.domain.Employee;
import com.example.jpa.domain.Message;
import com.example.jpa.domain.PowerStation;
import com.example.jpa.repository.EmployeeRepository;
import com.example.jpa.repository.MessageRepository;
import com.example.jpa.repository.PowerStationRepository;
import com.example.jpa.rsql.CustompRsqlVisitor;
import com.example.jpa.rsql.UserRsqlOperators;
import com.example.jpa.service.FindRepositorys;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.RepositoryQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired private EmployeeRepository employeeRepository;

    @Autowired private MessageRepository messageRepository;

    @Autowired private FindRepositorys findRepositorys;


    @PostMapping("/all")
    public String getUserAll(Model model, Pageable pageable){
        if(pageable == null) pageable = PageRequest.of(0,10);
        model.addAttribute("currentUser",UserUtils.getCurrentUsername().get());
         model.addAttribute("users",employeeRepository.findAll(pageable));
        Employee employee =  employeeRepository.findAllByPrincipal();
         return "user";
    }

    @GetMapping("/all/search")
    public String getAll(String search,Model model, Pageable pageable){
        if(pageable == null) pageable = PageRequest.of(0,10);
        Map<String,Object> maps = findRepositorys.getRepositoryMaps();

        Node node = new RSQLParser(UserRsqlOperators.defaultOperators()).parse(search);
        Specification<Employee> spec = node.accept(new CustompRsqlVisitor<Employee>());
        Page<Employee> users = employeeRepository.findAll(spec,pageable);
         model.addAttribute("users",users);
         return "user::article_type";
    }

   @GetMapping("/message")
   @ResponseBody
    public Page<Message> getMessage( Pageable pageable){
       if(pageable == null) pageable = PageRequest.of(0,10);
        Page<Message> m =  messageRepository.findAll(pageable);
        return m;
   }



}
