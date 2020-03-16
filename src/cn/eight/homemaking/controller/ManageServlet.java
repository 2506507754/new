package cn.eight.homemaking.controller;

import cn.eight.homemaking.pojo.Employer;
import cn.eight.homemaking.service.ManagerService;
import cn.eight.homemaking.service.ServiceImp.ManagerServiceImp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/Homemaking/manageSvl")
public class ManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reqType = request.getParameter("reqType");
        HttpSession session = request.getSession();
        if (reqType.equals("openMain")){
            session.setAttribute("company_number","1");
            response.sendRedirect("ny/index.htm");
        }else if (reqType.equals("addCustomer")){
            addCustomer(request,response,session);
        }else if (reqType.equals("queryCustomer")){
            queryCustomer(request,response,session);
        }else if (reqType.equals("queryAllEmployer")){
            queryAllEmployer(request,response,session);
        }else if(reqType.equals("check")){
            check(request,response,session);
        }else if(reqType.equals("checkin")){
            checkin(request,response,session);
        }
    }

    private void checkin(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        ManagerService service = new ManagerServiceImp();
        String name = request.getParameter("name");
        Employer list = service.check(name);
        session.setAttribute("queryCustomer",list);
        response.sendRedirect("ny/ywgl/gzxx_xg.jsp");
    }

    private void check(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        ManagerService service = new ManagerServiceImp();
        String name = request.getParameter("name");
        Employer list = service.check(name);
        session.setAttribute("queryCustomer",list);
        response.sendRedirect("ny/ywgl/gzxx_ck.jsp");
    }

    private void queryAllEmployer(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        ManagerService service = new ManagerServiceImp();
        List<Employer> list = service.queryAllEmployer();
        session.setAttribute("queryCustomer",list);
        response.sendRedirect("ny/ywgl/gzxx.jsp");
    }

    private void queryCustomer(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String name = request.getParameter("searchName");
        String gender = request.getParameter("radio");
        String status = request.getParameter("select");
        String employmentPosition = request.getParameter("select2");
        Map<String,String> map= new HashMap<String, String>();
        map.put("employer_name",name);
        map.put("gender",gender);
        map.put("claim",employmentPosition);
        map.put("status_",status);
        ManagerService service = new ManagerServiceImp();
        List<Employer> list = service.queryCustomer(map);
        session.setAttribute("queryCustomer",list);
        response.sendRedirect("ny/ywgl/gzxx.jsp");
    }


    private void addCustomer(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String name = request.getParameter("textarea40");
        String gender = request.getParameter("radio");
        String age = request.getParameter("textarea");
        String nation = request.getParameter("textarea2");
        String hometown = request.getParameter("textarea5");
        String education = request.getParameter("textarea4");
        String idnumber = request.getParameter("textarea3");
        String worker_unit = request.getParameter("textarea6");
        String profession = request.getParameter("textarea7");
        String contract = request.getParameter("textarea8");
        String period = request.getParameter("textarea9");
        String telephone = request.getParameter("textarea10");
        String house = request.getParameter("textarea11");
        String address = request.getParameter("textarea12");
        String service_address = request.getParameter("textarea13");
        String home_current_address = request.getParameter("textarea14");
        String home_people_number = request.getParameter("textarea15");
        String home_service = request.getParameter("textarea16");
        String home_size = request.getParameter("textarea17");
        String home_food = request.getParameter("textarea18");
        String home_other = request.getParameter("textarea19");
        String min_pay = request.getParameter("textarea20");
        String max_pay = request.getParameter("textarea23");
        String[] claim = request.getParameterValues("checkbox4");
        String claims = request.getParameter("textarea24");
        StringBuilder stringBuilder = new StringBuilder();
        if (claim != null) {
            for (int i = 0; i < claim.length; i++) {
                if ((claim[i] != null || claim[i] != "")) {
                    switch (Integer.valueOf(claim[i])) {
                        case 1:
                            stringBuilder = stringBuilder.append("月嫂").append(" ");
                            break;
                        case 2:
                            stringBuilder = stringBuilder.append("保姆").append(" ");
                            break;
                        case 3:
                            stringBuilder = stringBuilder.append("钟点").append(" ");
                            break;
                        case 4:
                            stringBuilder = stringBuilder.append("厨嫂").append(" ");
                            break;
                        case 5:
                            stringBuilder = stringBuilder.append("清洁工").append(" ");
                            break;
                        case 6:
                            stringBuilder = stringBuilder.append("护工").append(" ");
                            break;
                        case 7:
                            stringBuilder = stringBuilder.append("早教").append(" ");
                            break;
                        case 8:
                            stringBuilder = stringBuilder.append("家教").append(" ");
                            break;
                        case 9:
                            stringBuilder = stringBuilder.append("高级管家").append(" ");
                            break;
                    }
                }
            }

        }
        String claStr=stringBuilder.toString()+claims;
        String manager = request.getParameter("textarea21");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String check_in_time = request.getParameter("textarea22");
        String company_number = (String)session.getAttribute("company_number");
        Employer employer = new Employer(company_number,name,gender,age,nation,hometown,education,idnumber,worker_unit,profession,contract,period,telephone,house,address,service_address,home_current_address,home_people_number,home_service,home_size,home_food,home_other,max_pay,min_pay,claStr,manager,check_in_time);
        ManagerService service = new ManagerServiceImp();
        service.addCustomer(employer);
        response.sendRedirect("manageSvl?reqType=queryAllEmployer");
    }
}
