/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.customModel;

/**
 *
 * @author Duongntt
 */
public class DongSPCustomModel {

    private String idDongSP;
    private String maDongSP;
    private String tenDongSP;

    public DongSPCustomModel() {
    }

    public DongSPCustomModel(String idDongSP, String maDongSP, String tenDongSP) {
        this.idDongSP = idDongSP;
        this.maDongSP = maDongSP;
        this.tenDongSP = tenDongSP;
    }

    public String getMaDongSP() {
        return maDongSP;
    }

    public void setMaDongSP(String maDongSP) {
        this.maDongSP = maDongSP;
    }

    public String getTenDongSP() {
        return tenDongSP;
    }

    public void setTenDongSP(String tenDongSP) {
        this.tenDongSP = tenDongSP;
    }

    public String getIdDongSP() {
        return idDongSP;
    }

    public void setIdDongSP(String idDongSP) {
        this.idDongSP = idDongSP;
    }

    public Object[] toDataRow() {
        return new Object[]{maDongSP, tenDongSP};
    }
}
