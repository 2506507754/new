package cn.eight.homemaking.service;

import cn.eight.homemaking.pojo.Employer;

import java.util.List;
import java.util.Map;

public interface ManagerService {
    boolean addCustomer(Employer employer);

    List<Employer> queryCustomer(Map<String,String> map);

    List<Employer> queryAllEmployer();

    Employer check(String employer_number);

    boolean updateEmloyer(Employer employer);

}
