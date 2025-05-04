/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DLL;

/**
 *
 * @author NAME
 */
public class MemberDLL {
    String id,name,address,email,phone_number;
    int discount_point,status;

    public MemberDLL(String id, String name, String address, String email, String phone_number, int discount_point, int status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone_number = phone_number;
        this.discount_point = discount_point;
        this.status = status;
    }

    public MemberDLL() {
    }

    public MemberDLL(String id, int discount_point, int status) {
        this.id = id;
        this.discount_point = discount_point;
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSdt(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setDiscount_point(int discount_point) {
        this.discount_point = discount_point;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getSdt() {
        return phone_number;
    }

    public int getDiscount_point() {
        return discount_point;
    }

    public int getStatus() {
        return status;
    }
    
    
}
