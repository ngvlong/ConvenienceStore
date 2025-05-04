/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DLL;

/**
 *
 * @author NAME
 */
public class ModelDataCurveLineChart {
    String month;
    int doanhthu,loinhuan,sodon;

    public String getMonth() {
        return month;
    }

    public int getDoanhthu() {
        return doanhthu;
    }

    public int getLoinhuan() {
        return loinhuan;
    }

    public int getSodon() {
        return sodon;
    }

    public void setSodon(int sodon) {
        this.sodon = sodon;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setDoanhthu (int doanhthu) {
        this.doanhthu = doanhthu;
    }

    public void setLoinhuan (int loinhuan) {
        this.loinhuan = loinhuan;
    }

    public ModelDataCurveLineChart(String month, int doanhthu, int loinhuan ,int sodon) {
        this.month = month;
        this.doanhthu = doanhthu;
        this.loinhuan = loinhuan;
        this.sodon = sodon;
    }

    public ModelDataCurveLineChart() {
    }
    
    
}
