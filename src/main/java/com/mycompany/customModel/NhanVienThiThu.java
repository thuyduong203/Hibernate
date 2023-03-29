/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.customModel;

/**
 *
 * @author Duongntt
 */
public class NhanVienThiThu {

    private String maNV;
    private String tenNV;
    private String diaChi;
    private String hoNV;

    public NhanVienThiThu(String maNV, String tenNV, String diaChi, String hoNV) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.diaChi = diaChi;
        this.hoNV = hoNV;
    }

    public NhanVienThiThu() {
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHoNV() {
        return hoNV;
    }

    public void setHoNV(String hoNV) {
        this.hoNV = hoNV;
    }

    public Object[] toDataRow() {
        return new Object[]{maNV, tenNV, diaChi};
    }
}
