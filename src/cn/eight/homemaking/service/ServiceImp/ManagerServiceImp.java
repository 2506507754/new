package cn.eight.homemaking.service.ServiceImp;

import cn.eight.homemaking.dao.ManagerDao;
import cn.eight.homemaking.pojo.Employer;
import cn.eight.homemaking.service.ManagerService;

import java.util.List;
import java.util.Map;

public class ManagerServiceImp implements ManagerService {
    @Override
    public void addCustomer(Employer employer) {
        ManagerDao dao = new ManagerDao();
        if (employer.getAge()==""){
            employer.setAge(null);
        }
        if (employer.getMax_pay()==""){
            employer.setMax_pay(null);
        }
        if (employer.getMin_pay()==""){
            employer.setMin_pay(null);
        }
        if (employer.getPeriod()!=""){
            int month = Integer.valueOf(employer.getPeriod())*60*60*24*30;
            employer.setPeriod(month+"");
        }
        if (employer.getCheck_in_time()!="") {
            dao.addCustomer(employer);
        }
    }

    @Override
    public List<Employer> queryCustomer(Map<String,String> map) {
        ManagerDao dao = new ManagerDao();
        return dao.queryCustomerBycondition(map);
    }

    @Override
    public List<Employer> queryAllEmployer() {
        return new ManagerDao().queryCustomer();
    }

    @Override
    public Employer check(String name) {
        return new ManagerDao().queryAllCustomer(name);
    }
}
