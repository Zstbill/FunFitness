package org.uml.funfitness.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uml.funfitness.mapper.EmployeeMapper;
import org.uml.funfitness.pojo.Employee;
import org.uml.funfitness.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> findAll() {
        return employeeMapper.findAll();
    }

    @Override
    public Boolean deleteByEmployeeAccount(Integer employeeAccount) {
        return employeeMapper.deleteByEmployeeAccount(employeeAccount);
    }

    @Override
    public Boolean insertEmployee(Employee employee) {
        return employeeMapper.insertEmployee(employee);
    }

    @Override
    public Boolean updateMemberByEmployeeAccount(Employee employee) {
        return employeeMapper.updateMemberByEmployeeAccount(employee);
    }

    @Override
    public List<Employee> selectByEmployeeAccount(Integer employeeAccount) {
        return employeeMapper.selectByEmployeeAccount(employeeAccount);
    }

    @Override
    public Integer selectTotalCount() {
        return employeeMapper.selectTotalCount();
    }

}
