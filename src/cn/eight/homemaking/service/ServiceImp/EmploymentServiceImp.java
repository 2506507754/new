package cn.eight.homemaking.service.ServiceImp;

import cn.eight.homemaking.dao.EmploymentDao;
import cn.eight.homemaking.pojo.*;
import cn.eight.homemaking.service.EmploymentService;

import java.util.List;

public class EmploymentServiceImp implements EmploymentService {
    EmploymentDao dao = new EmploymentDao();

    @Override
    public List<Object> getNameByEmployer() {
        List<Object> nameByEmployer = dao.getNameByEmployer();
        return nameByEmployer;
    }

    @Override
    public List<Object> getNameByWorker() {
        List<Object> nameByWorker = dao.getNameByWorker();
        return nameByWorker;
    }

    @Override
    public Employer getEmployer(String name) {
       Employer employer = dao.getEmployer(name);
        return employer;
    }

    @Override
    public Worker getWorker(String name) {
        Worker worker = dao.getWorker(name);
        return worker;
    }

    @Override
    public void insertContract(Contract contract) {
        dao.insertContract(contract);
    }

    @Override
    public List<Ddgl> queryContract() {
        List<Ddgl> list = dao.getDdgl();
        return list;
    }

    @Override
    public EmployerDd queryAll(String name) {
        EmployerDd employerDd = dao.queryAllCustomer(name);
        return employerDd;
    }

    @Override
    public void updateContract(Contract contract) {
        dao.updateContract(contract);
    }
}
