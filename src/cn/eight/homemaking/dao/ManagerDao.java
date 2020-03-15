package cn.eight.homemaking.dao;

import cn.eight.homemaking.pojo.Employer;
import cn.eight.homemaking.util.DbPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ManagerDao {
    public void addCustomer(Employer employer) {
        String sql="INSERT INTO employer(employer_name,gender,age,nation,hometown,education,idnumber,worker_unit,profession,contract,period,telephone,house,address,service_address,home_current_address,home_people_number,home_service,home_size,home_food,home_other,max_pay,min_pay,claim,manager,check_in_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        BasicDao dao = new BasicDao();

        try {
            pst = con.prepareStatement(sql);
            String claim = employer.getClaim();
            String name = employer.getEmployer_name();
            String gender = employer.getGender();
            int age = employer.getAge();
            String nation = employer.getNation();
            String hometown = employer.getHometown();
            String education = employer.getEducation();
            String idnumber = employer.getIdnumber();
            String worker_unit = employer.getWorker_unit();
            String profession = employer.getProfession();
            String contract = employer.getContract();
            int period = Integer.valueOf(employer.getPeriod())*60*60*24;
            String telephone = employer.getTelephone();
            String house = employer.getHouse();
            String address = employer.getAddress();
            String service_address = employer.getService_address();
            String home_current_address = employer.getHome_current_address();
            String home_people_number = employer.getHome_people_number();
            String home_service = employer.getHome_service();
            String home_size = employer.getHome_size();
            String home_food = employer.getHome_food();
            String home_other = employer.getHome_other();
            float max_pay = employer.getMax_pay();
            float min_pay = employer.getMin_pay();
            String manager = employer.getManager();
            String check_in_time = employer.getCheck_in_time();
            dao.execUpdate(pst,name,gender,age,nation,hometown,education,idnumber,worker_unit,profession,contract,period,telephone,house,address,service_address,home_current_address,home_people_number,home_service,home_size,home_food,home_other,max_pay,min_pay,claim,manager,check_in_time);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,null,pst);
        }
    }
}
