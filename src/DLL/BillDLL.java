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
public class BillDLL {
    String id,price,final_price,discount;
    Date create_time;
    String member_id,employee_id;

    public BillDLL() {
    }

    public BillDLL(String id, String price, String final_price, String discount, Date create_time, String member_id, String employee_id) {
        this.id = id;
        this.price = price;
        this.final_price = final_price;
        this.discount = discount;
        this.create_time = create_time;
        this.member_id = member_id;
        this.employee_id = employee_id;
    }

    public BillDLL(String id, Date create_time, String member_id, String employee_id) {
        this.id = id;
        this.create_time = create_time;
        this.member_id = member_id;
        this.employee_id = employee_id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setFinal_price(String final_price) {
        this.final_price = final_price;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public String getFinal_price() {
        return final_price;
    }

    public String getDiscount() {
        return discount;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public String getMember_id() {
        return member_id;
    }

    public String getEmployee_id() {
        return employee_id;
    }
    
    
}
