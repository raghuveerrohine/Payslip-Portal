package com.ggpl.Payslip.repo;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import com.ggpl.Payslip.entity.PayslipEntity;

public interface PayslipRepo extends CrudRepository<PayslipEntity, Integer> {

}
