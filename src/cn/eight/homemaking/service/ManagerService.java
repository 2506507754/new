package cn.eight.homemaking.service;

import cn.eight.homemaking.pojo.Contract;
import cn.eight.homemaking.pojo.ContractLsda;
import cn.eight.homemaking.pojo.Employer;

import java.util.List;
import java.util.Map;

public interface ManagerService {
    boolean addCustomer(Employer employer);

    List<Employer> queryCustomer(Map<String,String> map,int page);

    List<Employer> queryAllEmployer(int page);

    Employer check(String employer_number);

    boolean updateEmloyer(Employer employer);


    List<ContractLsda> queryContract(String employer_number, int page);
}
