package com.praveen.service;

import com.praveen.model.Employee;
//import com.praveen.repo.EmployeeRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

import static com.praveen.repo.EmployeeRepoImp.addTempEmps;
import static com.praveen.repo.EmployeeRepoImp.*;


@Service
public class EmployeeServiceImp implements EmployeeService {


    @Override
    public boolean saveRecord(Employee employee) {
        addTempEmps(maps);

        boolean flag = false;
        try {
            if (!maps.containsKey(employee.getId())) {
                maps.put(employee.getId(), employee);
                flag = true;
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        return flag;
    }

    @Override
    public Employee getOneRecord(int id) {
        addTempEmps(maps);
        return maps.get(id);
    }

    @Override
    public List<Employee> getAllRecord() {
        addTempEmps(maps);
        return maps.values().stream().toList();
    }


    @Override
    public boolean deleteEmployeeByName(String name) {
        addTempEmps(maps); // Not sure what this method does, assuming it's fine

        // Create a list to store IDs of employees with matching names
        List<Integer> idsToRemove = new ArrayList<>();

        // Iterate over the map to find employees with matching names
        for (Employee employee : maps.values()) {
            if (employee.getName().equalsIgnoreCase(name)) {
                idsToRemove.add(employee.getId());
            }
        }

        // Remove employees with matching names
        for (Integer id : idsToRemove) {
            maps.remove(id);
        }

        // If any employees were removed, return true
        return !idsToRemove.isEmpty();
    }

        @Override
        public Employee updateEmployee(Employee employee) {
            // Check if the employee exists in the database
            if (maps.containsKey(employee.getId())) {
                // If exists, update the employee
                return maps.put(employee.getId(),employee);
            } else {
                // If not exists, throw an exception or handle accordingly
                throw new IllegalArgumentException("Employee with ID " + employee.getId() + " does not exist.");
            }
        }
    }





