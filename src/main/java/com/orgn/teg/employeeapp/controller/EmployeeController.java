package com.orgn.teg.employeeapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orgn.teg.employeeapp.converter.EmpFormToEmpConverter;
import com.orgn.teg.employeeapp.domain.Employee;
import com.orgn.teg.employeeapp.form.EmployeeForm;

@Controller
public class EmployeeController {
    private EmpFormToEmpConverter empFormToEmpConverter;

    @Autowired
    public void EmpConverter(EmpFormToEmpConverter empFormToEmpConverter) {
        this.empFormToEmpConverter = empFormToEmpConverter;
    }

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/hello";
    }

    @RequestMapping({"/hello", "/hi"})
    public String helloEmployee(Model model){
        model.addAttribute("employeeForm", new EmployeeForm());
        return "employee/employeeform";
    }

    @RequestMapping(value = "/employeegreeting", method = RequestMethod.POST)
    public String saveEmployee(EmployeeForm employeeForm, Model model){

    	Employee savedEmployee = empFormToEmpConverter.convert(employeeForm);
    	model.addAttribute("employee", savedEmployee);

        return "employee/employeedisplay";
    }

}
