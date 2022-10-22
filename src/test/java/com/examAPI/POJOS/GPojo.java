package com.examAPI.POJOS;


public class GPojo
{
    private int id;

    private String employee_name;

    private int employee_salary;

    private int employee_age;

    private String profile_image;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setEmployee_name(String employee_name){
        this.employee_name = employee_name;
    }
    public String getEmployee_name(){
        return this.employee_name;
    }
    public void setEmployee_salary(int employee_salary){
        this.employee_salary = employee_salary;
    }
    public int getEmployee_salary(){
        return this.employee_salary;
    }
    public void setEmployee_age(int employee_age){
        this.employee_age = employee_age;
    }
    public int getEmployee_age(){
        return this.employee_age;
    }
    public void setProfile_image(String profile_image){
        this.profile_image = profile_image;
    }
    public String getProfile_image(){
        return this.profile_image;
    }
}

