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
public class GoRDLL {
    String id,Employ_id,Brh_id,note;
    int total;
    Date create_time;

    public GoRDLL(String id, String Employ_id, String Brh_id, String note, int total, Date create_time) {
        this.id = id;
        this.Employ_id = Employ_id;
        this.Brh_id = Brh_id;
        this.note = note;
        this.total = total;
        this.create_time = create_time;
    }

    public GoRDLL() {
    }

    public GoRDLL(String id, String Employ_id, String Brh_id, Date create_time) {
        this.id = id;
        this.Employ_id = Employ_id;
        this.Brh_id = Brh_id;
        this.create_time = create_time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmploy_id() {
        return Employ_id;
    }

    public void setEmploy_id(String Employ_id) {
        this.Employ_id = Employ_id;
    }

    public String getBrh_id() {
        return Brh_id;
    }

    public void setBrh_id(String Brh_id) {
        this.Brh_id = Brh_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
    
    
    
}
