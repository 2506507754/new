package cn.eight.homemaking.dao;

import cn.eight.homemaking.pojo.Employer;
import cn.eight.homemaking.util.DbPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class ManagerDao {
    public void addCustomer(Employer employer) {
        String sql="INSERT INTO employer(company_number,employer_name,gender,age,nation,hometown,education,idnumber,worker_unit,profession,contract,period,telephone,house,address,service_address,home_current_address,home_people_number,home_service,home_size,home_food,home_other,max_pay,min_pay,claim,manager,check_in_time,status_) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        BasicDao dao = new BasicDao();

        try {
            pst = con.prepareStatement(sql);
            String company_number = employer.getCompany_number();
            String claim = employer.getClaim();
            String name = employer.getEmployer_name();
            String gender = employer.getGender();
            String age = employer.getAge();
            String nation = employer.getNation();
            String hometown = employer.getHometown();
            String education = employer.getEducation();
            String idnumber = employer.getIdnumber();
            String worker_unit = employer.getWorker_unit();
            String profession = employer.getProfession();
            String contract = employer.getContract();
            String status_ = null;
            if (contract==""){
                status_ = "未雇佣";
            }else {
                status_="已雇佣";
            }
            String period = employer.getPeriod();
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
            String max_pay = employer.getMax_pay();
            String min_pay = employer.getMin_pay();
            String manager = employer.getManager();
            String check_in_time = employer.getCheck_in_time();
            dao.execUpdate(pst,company_number,name,gender,age,nation,hometown,education,idnumber,worker_unit,profession,contract,period,telephone,house,address,service_address,home_current_address,home_people_number,home_service,home_size,home_food,home_other,max_pay,min_pay,claim,manager,check_in_time,status_);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,null,pst);
        }
    }

    public List<Employer> queryCustomerBycondition(Map<String,String> map) {
        String sql="select employer_name,gender,age,claim,min_pay,max_pay,check_in_time,status_ from employer ";
        String str = "";
        Set<String> set = map.keySet();

        for (String s : set) {
            if (!(map.get(s)==""||map.get(s)==null||map.get(s).equals("请选择"))){
                str=str+s+" like"+" '%"+map.get(s)+"%'"+" and ";
            }
        }
        if (str != ""){
            int len = str.lastIndexOf("a");
            str="where "+str.substring(0,len)+"order by check_in_time desc limit 0,5";
        }else {
            str="order by check_in_time desc limit 0,5";
        }
        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        BasicDao dao = new BasicDao();
        ResultSet rs = null;

        List<Employer> list = new ArrayList<Employer>();
        try{
            pst = con.prepareStatement(sql+str);
            rs= dao.execQuery(pst);
            while (rs.next()&&rs!=null){
                Employer employer = new Employer();
                String name = rs.getString(1);
                String gender = rs.getString(2);
                Integer age = rs.getInt(3);
                String claim = rs.getString(4);
                Float min_pay = rs.getFloat(5);
                Float max_pay = rs.getFloat(6);
                String check_in_time = rs.getString(7);
                String status_ = rs.getString(8);
                employer.setStatus_(status_);
                employer.setEmployer_name(name);
                employer.setGender(gender);
                employer.setAge(age.toString());
                employer.setClaim(claim);
                employer.setMin_pay(min_pay.toString());
                employer.setMax_pay(max_pay.toString());
                employer.setCheck_in_time(check_in_time);
                list.add(employer);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,rs,pst);
        }
        return null;
    }

    public List<Employer> queryCustomer() {
        String sql="select employer_name,gender,age,claim,min_pay,max_pay,check_in_time,status_ from employer order by check_in_time desc limit 0,5";
        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        BasicDao dao = new BasicDao();
        ResultSet rs = null;

        List<Employer> list = new ArrayList<Employer>();
        try{
            pst = con.prepareStatement(sql);
            rs= dao.execQuery(pst);
            while (rs.next()&&rs!=null){
                Employer employer = new Employer();
                String name = rs.getString(1);
                String gender = rs.getString(2);
                Integer age = rs.getInt(3);
                String claim = rs.getString(4);
                Float min_pay = rs.getFloat(5);
                Float max_pay = rs.getFloat(6);
                String check_in_time = rs.getString(7);
                String status_ = rs.getString(8);
                employer.setStatus_(status_);
                employer.setEmployer_name(name);
                employer.setGender(gender);
                employer.setAge(age.toString());
                employer.setClaim(claim);
                employer.setMin_pay(min_pay.toString());
                employer.setMax_pay(max_pay.toString());
                employer.setCheck_in_time(check_in_time);
                list.add(employer);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,rs,pst);
        }
        return null;
    }
}
