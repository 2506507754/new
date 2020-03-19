package cn.eight.homemaking.pojo;

public class Ddgl {
    private String employer_name;
    private String e_telephone;
    private String worker_name;
    private String mobile_phone;
    private String pay;
    private String employment_type;
    private String status_;
    private String dd_number;

    public Ddgl(String employer_name, String e_telephone, String worker_name, String mobile_phone, String pay, String employment_type, String status_, String dd_number) {
        this.employer_name = employer_name;
        this.e_telephone = e_telephone;
        this.worker_name = worker_name;
        this.mobile_phone = mobile_phone;
        this.pay = pay;
        this.employment_type = employment_type;
        this.status_ = status_;
        this.dd_number = dd_number;
    }

    public String getDd_number() {
        return dd_number;
    }

    public void setDd_number(String dd_number) {
        this.dd_number = dd_number;
    }

    public String getEmployer_name() {
        return employer_name;
    }

    public void setEmployer_name(String employer_name) {
        this.employer_name = employer_name;
    }

    public String getE_telephone() {
        return e_telephone;
    }

    public void setE_telephone(String e_telephone) {
        this.e_telephone = e_telephone;
    }

    public String getWorker_name() {
        return worker_name;
    }

    public void setWorker_name(String worker_name) {
        this.worker_name = worker_name;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getEmployment_type() {
        return employment_type;
    }

    public void setEmployment_type(String employment_type) {
        this.employment_type = employment_type;
    }

    public String getStatus_() {
        return status_;
    }

    public void setStatus_(String status_) {
        this.status_ = status_;
    }
}
