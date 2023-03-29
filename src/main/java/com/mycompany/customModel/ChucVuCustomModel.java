/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.customModel;

/**
 *
 * @author Duongntt
 */
public class ChucVuCustomModel {

    private String idCV;
    private String maCV;
    private String tenCV;

    public ChucVuCustomModel() {
    }

    public ChucVuCustomModel(String idCV, String maCV, String tenCV) {
        this.idCV = idCV;
        this.maCV = maCV;
        this.tenCV = tenCV;
    }

    public String getIdCV() {
        return idCV;
    }

    public void setIdCV(String idCV) {
        this.idCV = idCV;
    }

    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    public Object[] toDataRow() {
        return new Object[]{maCV, tenCV, maCV + tenCV};
    }
}
