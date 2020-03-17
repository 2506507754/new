package cn.eight.homemaking.pojo;

public class Contract {
    private String contract_number;
    private String company_number;
    private String employer_number;
    private String worker_number;
    private String manager_number;
    private String check_in_time;
    private String period;
    private String status_;
    private String pay;
    private String employment_type;
    private String referral_fee;
    private String colsing_date;

    public Contract(String contract_number, String company_number, String employer_number, String worker_number, String manager_number, String check_in_time, String period, String status_, String pay, String employment_type, String referral_fee, String colsing_date) {
        this.contract_number = contract_number;
        this.company_number = company_number;
        this.employer_number = employer_number;
        this.worker_number = worker_number;
        this.manager_number = manager_number;
        this.check_in_time = check_in_time;
        this.period = period;
        this.status_ = status_;
        this.pay = pay;
        this.employment_type = employment_type;
        this.referral_fee = referral_fee;
        this.colsing_date = colsing_date;
    }

    public String getContract_number() {
        return contract_number;
    }

    public void setContract_number(String contract_number) {
        this.contract_number = contract_number;
    }

    public String getCompany_number() {
        return company_number;
    }

    public void setCompany_number(String company_number) {
        this.company_number = company_number;
    }

    public String getEmployer_number() {
        return employer_number;
    }

    public void setEmployer_number(String employer_number) {
        this.employer_number = employer_number;
    }

    public String getWorker_number() {
        return worker_number;
    }

    public void setWorker_number(String worker_number) {
        this.worker_number = worker_number;
    }

    public String getManager_number() {
        return manager_number;
    }

    public void setManager_number(String manager_number) {
        this.manager_number = manager_number;
    }

    public String getCheck_in_time() {
        return check_in_time;
    }

    public void setCheck_in_time(String check_in_time) {
        this.check_in_time = check_in_time;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getStatus_() {
        return status_;
    }

    public void setStatus_(String status_) {
        this.status_ = status_;
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

    public String getReferral_fee() {
        return referral_fee;
    }

    public void setReferral_fee(String referral_fee) {
        this.referral_fee = referral_fee;
    }

    public String getColsing_date() {
        return colsing_date;
    }

    public void setColsing_date(String colsing_date) {
        this.colsing_date = colsing_date;
    }
}
