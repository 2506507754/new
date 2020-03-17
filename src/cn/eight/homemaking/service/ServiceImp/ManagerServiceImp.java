package cn.eight.homemaking.service.ServiceImp;

import cn.eight.homemaking.dao.ManagerDao;
import cn.eight.homemaking.pojo.Employer;
import cn.eight.homemaking.service.ManagerService;

import java.util.List;
import java.util.Map;

public class ManagerServiceImp implements ManagerService {
    int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public boolean addCustomer(Employer employer) {
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
        if (employer.getCheck_in_time()!="") {
            return dao.addCustomer(employer);
        }
        return false;
    }

    @Override
    public List<Employer> queryCustomer(Map<String,String> map,int page) {
        ManagerDao dao = new ManagerDao();
        List<Employer> list = dao.queryCustomerBycondition(map, page);
        int count1 = dao.queryCustomerByconditionCount(map);
        setCount(count1);
        return list;
    }

    @Override
    public List<Employer> queryAllEmployer(int page) {
        ManagerDao dao = new ManagerDao();
        List<Employer> list = dao.queryCustomer(page);
        int count1 = dao.queryCustomerCount();
        setCount(count1);
        return list;
    }

    @Override
    public Employer check(String employer_number) {
        return new ManagerDao().queryAllCustomer(employer_number);
    }

    @Override
    public boolean updateEmloyer(Employer employer) {
        ManagerDao dao = new ManagerDao();
        return dao.updateEmloyer(employer);
    }




}
