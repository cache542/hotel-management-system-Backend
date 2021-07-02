package com.hms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.models.Employee;
import com.hms.repository.IemployeeRepository;

@Service
public class EmployeeServiceImpl implements IemployeeService {

	@Autowired
	private IemployeeRepository employeeRepository;

//get all employee 
	@Override
	public List<Employee> findAll() {
		return this.employeeRepository.findAll();
	}

// create new employee
	@Override
	public Employee createEmployee(Employee employee) throws Exception {

		Employee local = this.employeeRepository.findByPan(employee.getPan());

		if (local != null) {
			throw new Exception("Employee details is already present!!");
		} else {
			System.out.println("Employee is not There!!");
			// create employee
			local = this.employeeRepository.save(employee);
		}

		return local;
	}

//delete employee
	@Override
	public boolean removeEmployee(int employeeId) throws Exception {
		if (employeeRepository.findByEmployeeId(employeeId) != null) {
			employeeRepository.deleteById(employeeId);
			return true;
		} else {
			throw new Exception("This employee does not exist!!");
		}
	}

	// update employee
	@Override
	public Employee updateEmployee(Employee updatedEmployee, int id) throws Exception {
		Optional<Employee> findEmployee = employeeRepository.findById(id);
		if (findEmployee .isPresent()) {
			
			Employee reqEmp=findEmployee.get();
			reqEmp.setEmployeeName(updatedEmployee.getEmployeeName());
			reqEmp.setAge(updatedEmployee.getAge());
			reqEmp.setEmployeeGender(updatedEmployee.getEmployeeGender());
			reqEmp.setAddress(updatedEmployee.getAddress());
			reqEmp.setSalary(updatedEmployee.getSalary());
			reqEmp.setPhone(updatedEmployee.getPhone());
			reqEmp.setEmail(updatedEmployee.getEmail());
			reqEmp.setDesignation(updatedEmployee.getDesignation());
			
			return employeeRepository.save(reqEmp);
		} else {
			throw new Exception("This employee doesnot exist!!");
		}
		
	}

	// find employee by id
	@Override
	public Employee findById(int id) {
		Employee emp=employeeRepository.findByEmployeeId(id);
		return emp;
	}

}
