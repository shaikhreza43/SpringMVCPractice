package org.zs.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.zs.employee.dto.EmployeeDto;
import org.zs.employee.service.EmployeeService;

@Controller
//@RequestMapping(value="*")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.POST, value = "/signup")
	public ModelAndView saveUserDataInDb(EmployeeDto employeeData) {
		
		System.out.println(employeeData);

		if (employeeData == null) {
			return new ModelAndView("error.html");
		} else {
			Integer result = employeeService.saveUserDataInDb(employeeData);
			if (result == null || result == 0) {  
				return new ModelAndView("save-error.html");
			} else
				return new ModelAndView("save-success.html");
		}

	}

	
	
	

}
