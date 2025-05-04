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
public class PromotionEventDLL {
    int id;
    String name;
    Date start_time,end_time;

    public PromotionEventDLL() {
    }

    public PromotionEventDLL(int id, String name, Date start_time, Date end_time) {
        this.id = id;
        this.name = name;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getStart_time() {
        return start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }
    
    
}
