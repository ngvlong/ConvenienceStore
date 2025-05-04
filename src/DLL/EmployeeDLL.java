/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DLL;

import java.util.Date;

/**
 *
 * @author NAME
 */
public class EmployeeDLL {
    
    String id,name,cmnd,chinhanh,email,phone_number,address;
    Date joinindate,birthday;
    int status,gender;

    public EmployeeDLL(String id, String name, String chinhanh, Date joinindate,int status) {
        this.id = id;
        this.name = name;
        this.chinhanh = chinhanh;
        this.joinindate = joinindate;
        this.status = status;
    }

    public EmployeeDLL(String id, String name, String cmnd, String email, String phone_number, String address, Date birthday,int status) {
        this.id = id;
        this.name = name;
        this.cmnd = cmnd;
        this.email = email;
        this.phone_number = phone_number;
        this.address = address;
        this.birthday = birthday;
        this.status = status;
    }

    
    public EmployeeDLL() {
    }

    public EmployeeDLL(String id, String name, String chinhanh, Date joinindate, Date birthday, int gender) {
        this.id = id;
        this.name = name;
        this.chinhanh = chinhanh;
        this.joinindate = joinindate;
        this.birthday = birthday;
        this.gender = gender;
    }

    public EmployeeDLL(String id, String name, String cmnd, String chinhanh, String email, String phone_number, String address, Date joinindate, Date birthday, int status, int gender) {
        this.id = id;
        this.name = name;
        this.cmnd = cmnd;
        this.chinhanh = chinhanh;
        this.email = email;
        this.phone_number = phone_number;
        this.address = address;
        this.joinindate = joinindate;
        this.birthday = birthday;
        this.status = status;
        this.gender = gender;
    }

    

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public void setChinhanh(String chinhanh) {
        this.chinhanh = chinhanh;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSdt(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setJoinindate(Date joinindate) {
        this.joinindate = joinindate;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCmnd() {
        return cmnd;
    }

    public String getChinhanh() {
        return chinhanh;
    }

    public String getEmail() {
        return email;
    }

    public String getSdt() {
        return phone_number;
    }

    public String getAddress() {
        return address;
    }

    public Date getJoinindate() {
        return joinindate;
    }

    public Date getBirthday() {
        return birthday;
    }
    
    
    
}
