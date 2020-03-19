package cn.eight.homemaking.service;

import cn.eight.homemaking.pojo.*;

import java.util.List;

public interface EmploymentService {
    List<Object> getNameByEmployer();

    List<Object> getNameByWorker();

    Employer getEmployer(String name);

    Worker getWorker(String name);

    void insertContract(Contract contract);

    List<Ddgl> queryContract();

    EmployerDd queryAll(String name);

    void updateContract(Contract contract);
}
