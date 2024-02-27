package com.praveen.controller;

import com.praveen.model.Employee;
import com.praveen.service.EmployeeService;
import com.praveen.service.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.praveen.repo.EmployeeRepoImp.maps;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @RequestMapping(value="/",method= RequestMethod.GET)
    public String homePage()
    {
        return "home";
    }


    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public String empForm()
    {
        return "employee";
    }


    @RequestMapping (value="/register",method=RequestMethod.POST)
    public String saveData(@ModelAttribute Employee employee, ModelMap model) {

        boolean flag = service.saveRecord(employee);
        String msg=null;
        if (!flag) {
            msg = "Error employee already exist...";
        } else {
            msg = "Employee record saved successfully...";
        }
        model.put("msg",msg);
        return "result";
    }


    @RequestMapping ("/viewEmployees")
    public String getAll(ModelMap model) {
        List<Employee> employees = service.getAllRecord();
        model.put("employees",employees);
        return "viewEmployee";
    }

    @RequestMapping("/fill")
    public String fillDetailsofId()
    {
        return "input";
    }


    @RequestMapping("/get")
    public String getOne(@RequestParam int id,ModelMap model) {
        Employee employee = service.getOneRecord(id);
        model.put("employee",employee);
        return "viewEmployee1";
    }

    @RequestMapping("/fillName")
    public String fillDetailsofName()
    {
        return "inputName";
    }

    @RequestMapping("/updateId")
    public String idForm()
    {
        return "beforeUpdateForm";
    }


    @RequestMapping("/update/{id}")
    public String showUpdateEmployeeForm(@RequestParam int id,Model model) {
       // You may fetch the employee from the database based on ID

        if(maps.containsKey(id))
        model.addAttribute("employee", maps.get(id));
        return "updateEmployeeForm";
    }

    @RequestMapping ("/update")
    public String updateEmployee(@ModelAttribute("employee") Employee employee) {
        // Call service to update the employee
        service.updateEmployee(employee);
        return "redirect:/viewEmployees"; // Redirect to employee list page after update
    }


    @RequestMapping ("/delete")
    public String deleteEmployeeByName(@RequestParam String name,ModelMap model) {
        boolean flag = service.deleteEmployeeByName(name);
        String msg = null;
        if (!flag) {
            msg = "Error Employee does not exist ";
        } else {
            msg = "Employee deleted successfully....";
        }
        model.put("msg", msg);
        return "status";
    }
}
