/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DLL;

/**
 *
 * @author NAME
 */
public class GoRDetailDLL {
    String GoR_id,Prd_id;
    int soluong,price;

    public GoRDetailDLL() {
    }

    public GoRDetailDLL(String GoR_id, String Prd_id, int soluong, int price) {
        this.GoR_id = GoR_id;
        this.Prd_id = Prd_id;
        this.soluong = soluong;
        this.price = price;
    }

    public String getGoR_id() {
        return GoR_id;
    }

    public String getPrd_id() {
        return Prd_id;
    }

    public int getSoluong() {
        return soluong;
    }

    public int getPrice() {
        return price;
    }

    public void setGoR_id(String GoR_id) {
        this.GoR_id = GoR_id;
    }

    public void setPrd_id(String Prd_id) {
        this.Prd_id = Prd_id;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
}
