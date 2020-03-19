package cn.eight.homemaking.controller;

import cn.eight.homemaking.pojo.*;
import cn.eight.homemaking.service.EmploymentService;
import cn.eight.homemaking.service.ServiceImp.EmploymentServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/Homemaking/employmentServlet")
public class EmploymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reqType = request.getParameter("reqType");
        HttpSession session = request.getSession();
        if (reqType.equals("insert")){
            insert(request,response,session);
        }else if (reqType.equals("select")){
            select(request,response,session);
        }else if (reqType.equals("ddxz")){
            addContract(request,response);
        }else if (reqType.equals("query")){
            queryDd(request,response,session);
        }else if (reqType.equals("ddgl_ck")){
            queryAll(request,response,session);
        }else if(reqType.equals("ddgl_xg")){
            updateAll(request,response,session);
        }else if (reqType.equals("update")){
            update(request,response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String c_number = request.getParameter("c_number");
        if (c_number==""){
            c_number=null;
        }
        String company_number = request.getParameter("company_number");
        if (company_number == "") {
            company_number = null;
        }
        String employer_number = request.getParameter("employer_number");
        if (employer_number == "") {
            employer_number = null;
        }
        String worker_number = request.getParameter("worker_number");
        if (worker_number == "") {
            worker_number = null;
        }
        String manager_number = request.getParameter("manager_number");
        if (manager_number == "") {
            manager_number = null;
        }
        String yxDate = request.getParameter("textarea500");
        if (yxDate == "") {
            yxDate = null;
        }
        String status = request.getParameter("status");
        String pay = request.getParameter("pay");
        if (pay == "") {
            pay = null;
        }
        String[] e_types = request.getParameterValues("e_type");
        String claim = "";
        if (e_types != null) {
            for (String e_type : e_types) {
                claim += e_type + " ";
            }
        }
        String fee = request.getParameter("fee");
        if (fee == "") {
            fee = null;
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String check_in_time = df.format(new Date());
        Contract contract = new Contract(c_number, company_number, employer_number, worker_number, manager_number, null, yxDate, status, pay, claim, fee, check_in_time);
        EmploymentService service = new EmploymentServiceImp();
        service.updateContract(contract);
        response.sendRedirect("employmentServlet?reqType=query");
    }

    private void updateAll(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String name = request.getParameter("name");
        String workername = request.getParameter("workername");
        EmploymentService service = new EmploymentServiceImp();
        EmployerDd employerDd = service.queryAll(name);
        Worker worker_ = service.getWorker(workername);
        session.setAttribute("e_Dd",employerDd);
        session.setAttribute("worker",worker_);
        List<Object> worker = service.getNameByWorker();
        session.removeAttribute("W_name");
        session.setAttribute("w_name",worker);
        response.sendRedirect("ny/ywgl/ddgl_xg.jsp");
    }

    private void queryAll(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String name = request.getParameter("name");
        EmploymentService service = new EmploymentServiceImp();
        EmployerDd employerDd = service.queryAll(name);
        session.setAttribute("e_Dd",employerDd);
        response.sendRedirect("ny/ywgl/ddgl_ck.jsp");
    }

    private void queryDd(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        EmploymentService service = new EmploymentServiceImp();
        List<Ddgl> list= service.queryContract();
        session.setAttribute("ddgl",list);
        response.sendRedirect("ny/ywgl/ddgl.jsp");
    }

    private void addContract(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String company_number = request.getParameter("company_number");
        if (company_number == "") {
            company_number = null;
        }
        String employer_number = request.getParameter("employer_number");
        if (employer_number == "") {
            employer_number = null;
        }
        String worker_number = request.getParameter("worker_number");
        if (worker_number == "") {
            worker_number = null;
        }
        String manager_number = request.getParameter("manager_number");
        if (manager_number == "") {
            manager_number = null;
        }
        String yxDate = request.getParameter("textarea500");
        if (yxDate == "") {
            yxDate = null;
        }
        String status = request.getParameter("status");
        String pay = request.getParameter("pay");
        if (pay == "") {
            pay = null;
        }
        String[] e_types = request.getParameterValues("e_type");
        String claim = "";
        if (e_types != null) {
            for (String e_type : e_types) {
                claim += e_type + " ";
            }
        }
        String fee = request.getParameter("fee");
        if (fee == "") {
            fee = null;
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String check_in_time = df.format(new Date());
        Contract contract = new Contract(null, company_number, employer_number, worker_number, manager_number, null, yxDate, status, pay, claim, fee, check_in_time);
        EmploymentService service = new EmploymentServiceImp();
        service.insertContract(contract);
        response.sendRedirect("employmentServlet?reqType=query");
    }

    private void select(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String check = request.getParameter("check");
        String name = request.getParameter("name");
        EmploymentService service = new EmploymentServiceImp();
        Map<String,Object> map = new HashMap<String, Object>();
        if (check.equals("employer")){
            Employer employer =  service.getEmployer(name);
            map.put("E",employer);
        }else if (check.equals("worker")){
            Worker worker = service.getWorker(name);
            map.put("W",worker);
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),map);
    }

    private void insert(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        EmploymentService service = new EmploymentServiceImp();
        List<Object> employer = service.getNameByEmployer();
        List<Object> worker = service.getNameByWorker();
        session.removeAttribute("w_name");
        session.removeAttribute("e_name");
        session.setAttribute("e_name",employer);
        session.setAttribute("w_name",worker);
        response.sendRedirect("ny/ywgl/ddgl_xz.jsp");
    }
}
