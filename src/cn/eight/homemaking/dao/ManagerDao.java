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
    public boolean addCustomer(Employer employer) {
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
            boolean b = dao.execUpdate(pst, company_number, name, gender, age, nation, hometown, education, idnumber, worker_unit, profession, contract, period, telephone, house, address, service_address, home_current_address, home_people_number, home_service, home_size, home_food, home_other, max_pay, min_pay, claim, manager, check_in_time, status_);
            return b;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,null,pst);
        }
        return false;
    }

    public Employer queryAllCustomer(String number){
        String sql = "select * from employer where employer_number = ? ";
        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        BasicDao dao = new BasicDao();
        ResultSet rs = null;
        Employer employer = new Employer();
        try{
            pst = con.prepareStatement(sql);
            rs= dao.execQuery(pst,number);
                while (rs.next()&&rs!=null) {
                    String employer_number = Integer.valueOf(rs.getInt(1)).toString();
                    String company_number = Integer.valueOf(rs.getInt(2)).toString();
                    String employer_name = rs.getString(3);
                    String gender= rs.getString(4);
                    String age = Integer.valueOf(rs.getString(5)).toString();
                    String nation = rs.getString(6);
                    String hometown = rs.getString(7);
                    String education = rs.getString(8);
                    String idnumber = rs.getString(9);
                    String worker_unit = rs.getString(10);
                    String profession = rs.getString(11);
                    String contract = rs.getString(12);
                    String period = rs.getString(13);
                    String telephone = rs.getString(14);
                    String house = rs.getString(15);
                    String address = rs.getString(16);
                    String service_address = rs.getString(17);
                    String home_current_address = rs.getString(18);
                    String home_people_number = rs.getString(19);
                    String home_service = rs.getString(20);
                    String home_size = rs.getString(21);
                    String home_food = rs.getString(22);
                    String home_other = rs.getString(23);
                    String max_pay = Float.valueOf(rs.getFloat(24)).toString();
                    String min_pay = Float.valueOf(rs.getFloat(25)).toString();
                    String claim = rs.getString(26);
                    String manager = rs.getString(27);
                    String check_in_time = rs.getString(28);
                    employer.setEmployer_number(employer_number);
                    employer.setCompany_number(company_number);
                    employer.setEmployer_name(employer_name);
                    employer.setGender(gender);
                    employer.setAge(age);
                    employer.setNation(nation);
                    employer.setHometown(hometown);
                    employer.setEducation(education);
                    employer.setIdnumber(idnumber);
                    employer.setWorker_unit(worker_unit);
                    employer.setProfession(profession);
                    employer.setContract(contract);
                    employer.setPeriod(period);
                    employer.setTelephone(telephone);
                    employer.setHouse(house);
                    employer.setAddress(address);
                    employer.setService_address(service_address);
                    employer.setHome_current_address(home_current_address);
                    employer.setHome_people_number(home_people_number);
                    employer.setHome_service(home_service);
                    employer.setHome_size(home_size);
                    employer.setHome_food(home_food);
                    employer.setHome_other(home_other);
                    employer.setMax_pay(max_pay);
                    employer.setMin_pay(min_pay);
                    employer.setClaim(claim);
                    employer.setManager(manager);
                    employer.setCheck_in_time(check_in_time);
                }
            return employer;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,rs,pst);
        }
        return null;
    }

    public List<Employer> queryCustomerBycondition(Map<String,String> map,int page) {
        String sql="select employer_name,gender,age,claim,min_pay,max_pay,check_in_time,status_,employer_number from employer ";
        String str = "";
        Set<String> set = map.keySet();
        for (String s : set) {
            if (!(map.get(s)==""||map.get(s)==null||map.get(s).equals("请选择"))){
                str=str+s+" like"+" '%"+map.get(s)+"%'"+" and ";
            }
        }
        if (str != ""){
            int len = str.lastIndexOf("a");
            str="where "+str.substring(0,len)+"order by check_in_time desc limit ?,5";
        }else {
            str="order by check_in_time desc limit ?,5";
        }
        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        BasicDao dao = new BasicDao();
        ResultSet rs = null;
        List<Employer> list = new ArrayList<Employer>();
        try{
            pst = con.prepareStatement(sql+str);
            rs= dao.execQuery(pst,page);
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
                String employer_number = Integer.valueOf(rs.getInt(9)).toString();
                employer.setEmployer_number(employer_number);
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

    public int queryCustomerByconditionCount(Map<String,String> map) {
        String sql="select employer_name from employer ";
        String str = "";
        Set<String> set = map.keySet();
        for (String s : set) {
            if (!(map.get(s)==""||map.get(s)==null||map.get(s).equals("请选择"))){
                str=str+s+" like"+" '%"+map.get(s)+"%'"+" and ";
            }
        }
        if (str != ""){
            int len = str.lastIndexOf("a");
            str="where "+str.substring(0,len)+"";
        }
        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        BasicDao dao = new BasicDao();
        ResultSet rs = null;
        List<Employer> list = new ArrayList<Employer>();
        try{
            int c = 0;
            pst = con.prepareStatement(sql+str);
            rs= dao.execQuery(pst);
            while (rs.next()&&rs!=null){
                c++;
            }
            return c;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,rs,pst);
        }
        return 0;
    }


    public List<Employer> queryCustomer(int page) {
        String sql="select employer_name,gender,age,claim,min_pay,max_pay,check_in_time,status_,employer_number from employer order by check_in_time desc limit ?,5";
        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        BasicDao dao = new BasicDao();
        ResultSet rs = null;
        List<Employer> list = new ArrayList<Employer>();
        try{
            pst = con.prepareStatement(sql);
            rs= dao.execQuery(pst,page);
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
                String employer_number = Integer.valueOf(rs.getInt(9)).toString();
                employer.setEmployer_number(employer_number);
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

    public int queryCustomerCount() {
        String sql="select * from employer";
        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        BasicDao dao = new BasicDao();
        ResultSet rs = null;
        List<Employer> list = new ArrayList<Employer>();

        try{
            pst = con.prepareStatement(sql);
            rs= dao.execQuery(pst);
            int c = 0;
            while (rs.next()&&rs!=null){
                c++;
            }
            return c;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,rs,pst);
        }
        return 0;
    }

    public boolean updateEmloyer(Employer employer) {
        String sql="update employer set employer_name = ?,gender = ?,age = ?,nation = ?,hometown = ?,education = ?,idnumber = ?,worker_unit = ?,profession = ?,contract = ?,period = ?,telephone = ?,house = ?,address = ?,service_address = ?,home_current_address = ?,home_people_number = ?,home_service = ?,home_size = ?,home_food = ?,home_other = ?,claim = ?,manager = ?,check_in_time = ?,status_ = ? where employer_number = ?";
        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        BasicDao dao = new BasicDao();
        try {
            pst = con.prepareStatement(sql);
            String employer_number = employer.getEmployer_number();
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
            boolean b = dao.execUpdate(pst,  name, gender, age, nation, hometown, education, idnumber, worker_unit, profession, contract, period, telephone, house, address, service_address, home_current_address, home_people_number, home_service, home_size, home_food, home_other, claim, manager, check_in_time, status_,employer_number);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,null,pst);
        }
        return false;
    }


}
