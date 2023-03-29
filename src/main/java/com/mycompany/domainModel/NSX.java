/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domainModel;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "NSX")
public class NSX implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id")
    private String idNSX;

    @Column(name = "Ma")
    private String maNSX;

    @Column(name = "Ten")
    private String tenNSX;

    @OneToMany(mappedBy = "nsx", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ChiTietSP> listCTSP;

    public NSX() {
    }

    public NSX(String idNSX, String maNSX, String tenNSX) {
        this.idNSX = idNSX;
        this.maNSX = maNSX;
        this.tenNSX = tenNSX;
    }

    public NSX(String idNSX, String tenNSX) {
        this.idNSX = idNSX;
        this.tenNSX = tenNSX;
    }

    public NSX(String idNSX) {
        this.idNSX = idNSX;
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

    @Override
    public String toString() {
        return "NSX{" + "idNSX=" + idNSX + ", maNSX=" + maNSX + ", tenNSX=" + tenNSX + '}';
    }

}
