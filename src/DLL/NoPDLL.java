/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DLL;

/**
 *
 * @author NAME
 */
public class NoPDLL {
    String Brh_id,Prd_id;
    int value;

    public NoPDLL(String Brh_id, String Prd_id, int value) {
        this.Brh_id = Brh_id;
        this.Prd_id = Prd_id;
        this.value = value;
    }

    public NoPDLL() {
    }

    public String getBrh_id() {
        return Brh_id;
    }

    public void setBrh_id(String Brh_id) {
        this.Brh_id = Brh_id;
    }

    public String getPrd_id() {
        return Prd_id;
    }

    public void setPrd_id(String Prd_id) {
        this.Prd_id = Prd_id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    
}
