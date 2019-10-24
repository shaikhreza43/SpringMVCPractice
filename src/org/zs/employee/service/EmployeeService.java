package org.zs.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zs.employee.dao.EmployeeDao;
import org.zs.employee.dto.EmployeeDto;

@Service
public class EmployeeService {
	
	
	@Autowired
	private EmployeeDao repository;
	
	public Integer saveUserDataInDb(EmployeeDto employeeData) {
	Integer response = repository.saveNewUserDataInDb(employeeData);
		return response;
	}

}
