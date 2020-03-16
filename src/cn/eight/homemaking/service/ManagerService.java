package cn.eight.homemaking.service;

import cn.eight.homemaking.pojo.Employer;

import java.util.List;
import java.util.Map;

public interface ManagerService {
    void addCustomer(Employer employer);

    List<Employer> queryCustomer(Map<String,String> map);

    List<Employer> queryAllEmployer();
}
