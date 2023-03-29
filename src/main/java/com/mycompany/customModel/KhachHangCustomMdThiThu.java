/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.customModel;

/**
 *
 * @author Duongntt
 */
public class KhachHangCustomMdThiThu {

    private String maKH;
    private String tenKH;
    private String tenDemKH;
    private String hoKH;
    private String diaChiKH;

    public KhachHangCustomMdThiThu() {
    }

    public KhachHangCustomMdThiThu(String maKH, String tenKH, String tenDemKH, String hoKH, String diaChiKH) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.tenDemKH = tenDemKH;
        this.hoKH = hoKH;
        this.diaChiKH = diaChiKH;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getTenDemKH() {
        return tenDemKH;
    }

    public void setTenDemKH(String tenDemKH) {
        this.tenDemKH = tenDemKH;
    }

    public String getHoKH() {
        return hoKH;
    }

    public void setHoKH(String hoKH) {
        this.hoKH = hoKH;
    }

    public String getDiaChiKH() {
        return diaChiKH;
    }

    public void setDiaChiKH(String diaChiKH) {
        this.diaChiKH = diaChiKH;
    }

    public Object[] toDataRow() {
        return new Object[]{maKH, tenKH, tenDemKH, hoKH, diaChiKH, (tenDemKH + " " + tenKH + " " + hoKH)};
    }
}
