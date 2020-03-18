package cn.eight.homemaking.pojo;

public class ContractLsda {
    String worker_name;
    int worker_number;
    int fee;
    String entry_time;
    String check_in_time;
    String employement_type;
    float pay;
    String closeing_date;

    public ContractLsda(String worker_name, int worker_number, int fee, String entry_time, String check_in_time, String employement_type, float pay, String closeing_date) {
        this.worker_name = worker_name;
        this.worker_number = worker_number;
        this.fee = fee;
        this.entry_time = entry_time;
        this.check_in_time = check_in_time;
        this.employement_type = employement_type;
        this.pay = pay;
        this.closeing_date = closeing_date;
    }

    public String getWorker_name() {
        return worker_name;
    }

    public void setWorker_name(String worker_name) {
        this.worker_name = worker_name;
    }

    public int getWorker_number() {
        return worker_number;
    }

    public void setWorker_number(int worker_number) {
        this.worker_number = worker_number;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getEntry_time() {
        return entry_time;
    }

    public void setEntry_time(String entry_time) {
        this.entry_time = entry_time;
    }

    public String getCheck_in_time() {
        return check_in_time;
    }

    public void setCheck_in_time(String check_in_time) {
        this.check_in_time = check_in_time;
    }

    public String getEmployement_type() {
        return employement_type;
    }

    public void setEmployement_type(String employement_type) {
        this.employement_type = employement_type;
    }

    public float getPay() {
        return pay;
    }

    public void setPay(float pay) {
        this.pay = pay;
    }

    public String getCloseing_date() {
        return closeing_date;
    }

    public void setCloseing_date(String closeing_date) {
        this.closeing_date = closeing_date;
    }
}
