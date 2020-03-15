package cn.eight.homemaking.service.ServiceImp;

import cn.eight.homemaking.dao.ManagerDao;
import cn.eight.homemaking.pojo.Employer;
import cn.eight.homemaking.service.ManagerService;

public class ManagerServiceImp implements ManagerService {
    @Override
    public void addCustomer(Employer employer) {
        ManagerDao dao = new ManagerDao();
        dao.addCustomer(employer);
    }
}
