/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DLL;

/**
 *
 * @author NAME
 */
public class DetailPromotionEventDLL {
    int PrEvt_id;
    String Prd_id,Value;

    public DetailPromotionEventDLL() {
    }

    public DetailPromotionEventDLL(int PrEvt_id, String Prd_id, String Value) {
        this.PrEvt_id = PrEvt_id;
        this.Prd_id = Prd_id;
        this.Value = Value;
    }

    public int getPrEvt_id() {
        return PrEvt_id;
    }

    public String getPrd_id() {
        return Prd_id;
    }

    public String getValue() {
        return Value;
    }

    public void setPrEvt_id(int PrEvt_id) {
        this.PrEvt_id = PrEvt_id;
    }

    public void setPrd_id(String Prd_id) {
        this.Prd_id = Prd_id;
    }

    public void setValue(String Value) {
        this.Value = Value;
    }
    
    
}
