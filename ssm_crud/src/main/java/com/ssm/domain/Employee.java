package com.ssm.domain;

public class Employee {
    private Integer eid;

    private String email;

    private String ename;

    private String gender;

    private Integer dId;


    private  Department department;

    public Employee() {
    }

    public Employee(Integer eid, String email, String ename, String gender, Integer dId) {
        this.eid = eid;
        this.email = email;
        this.ename = ename;
        this.gender = gender;
        this.dId = dId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", email='" + email + '\'' +
                ", ename='" + ename + '\'' +
                ", gender='" + gender + '\'' +
                ", dId=" + dId +
                ", department=" + department +
                '}';
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }
}