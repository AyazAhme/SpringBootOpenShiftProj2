package com.orgn.teg.employeeapp.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.orgn.teg.employeeapp.domain.Employee;
import com.orgn.teg.employeeapp.form.EmployeeForm;

@Component
public class EmpFormToEmpConverter implements Converter<EmployeeForm, Employee> {

    @Override
    public Employee convert(EmployeeForm employeeForm) {
    	Employee employee = new Employee();

        employee.setEmpName(employeeForm.getEmpName());

        return employee;
    }
}
