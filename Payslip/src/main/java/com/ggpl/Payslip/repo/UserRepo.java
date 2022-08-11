package com.ggpl.Payslip.repo;

import org.springframework.data.repository.CrudRepository;

import com.ggpl.Payslip.entity.User;

public interface UserRepo  extends CrudRepository<User, Integer>{

}
