/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DLL;

/**
 *
 * @author NAME
 */
public class BillDetailDLL {
    String id,Prd_id;
    int price,soluong,total;

    public BillDetailDLL() {
    }

    public BillDetailDLL(String id, String prd_id, int price, int soluong, int total) {
        this.id = id;
        this.Prd_id = prd_id;
        this.price = price;
        this.soluong = soluong;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public String getPrd_id() {
        return Prd_id;
    }

    public int getPrice() {
        return price;
    }

    public int getSoluong() {
        return soluong;
    }

    public int getTotal() {
        return total;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrd_id(String prd_id) {
        this.Prd_id = prd_id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
}
