/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.customModel;

import java.math.BigDecimal;

/**
 *
 * @author Duongntt
 */
public class CTSPCustomThiThu {

    private String id;
    private int namBH;
    private String moTa;
    private int slTon;
    private BigDecimal giaNhap;

    public CTSPCustomThiThu() {
    }

    public CTSPCustomThiThu(String id, int namBH, String moTa, int slTon, BigDecimal giaNhap) {
        this.id = id;
        this.namBH = namBH;
        this.moTa = moTa;
        this.slTon = slTon;
        this.giaNhap = giaNhap;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNamBH() {
        return namBH;
    }

    public void setNamBH(int namBH) {
        this.namBH = namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSlTon() {
        return slTon;
    }

    public void setSlTon(int slTon) {
        this.slTon = slTon;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String trangThai(int slTon) {
        if (slTon >= 900) {
            return "Nhiều sp";
        } else {
            return "Ít sp";
        }
    }

    public Object[] todataRow() {
        return new Object[]{id, namBH, moTa, slTon, giaNhap, trangThai(slTon)};
    }
}
