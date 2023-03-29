/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.customModel;

/**
 *
 * @author Duongntt
 */
public class NSXCustomModel {

    private String idNSX;
    private String maNSX;
    private String tenNSX;

    public NSXCustomModel() {
    }

    public NSXCustomModel(String idNSX, String maNSX, String tenNSX) {
        this.idNSX = idNSX;
        this.maNSX = maNSX;
        this.tenNSX = tenNSX;
    }

    public String getIdNSX() {
        return idNSX;
    }

    public void setIdNSX(String idNSX) {
        this.idNSX = idNSX;
    }

    public String getMaNSX() {
        return maNSX;
    }

    public void setMaNSX(String maNSX) {
        this.maNSX = maNSX;
    }

    public String getTenNSX() {
        return tenNSX;
    }

    public void setTenNSX(String tenNSX) {
        this.tenNSX = tenNSX;
    }

    public Object[] todataRow() {
        return new Object[]{maNSX, tenNSX};
    }
}
