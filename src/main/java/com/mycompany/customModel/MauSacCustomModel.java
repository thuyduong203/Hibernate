/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.customModel;

/**
 *
 * @author Duongntt
 */
public class MauSacCustomModel {

    private String idMau;
    private String maMau;
    private String tenMau;

    public MauSacCustomModel() {
    }

    public MauSacCustomModel(String idMau, String maMau, String tenMau) {
        this.idMau = idMau;
        this.maMau = maMau;
        this.tenMau = tenMau;
    }

    public String getIdMau() {
        return idMau;
    }

    public void setIdMau(String idMau) {
        this.idMau = idMau;
    }

    public String getMaMau() {
        return maMau;
    }

    public void setMaMau(String maMau) {
        this.maMau = maMau;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    public Object[] toDataRow() {
        return new Object[]{maMau, tenMau};
    }
}
