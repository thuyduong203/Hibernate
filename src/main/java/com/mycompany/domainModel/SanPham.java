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
@Table(name = "SanPham")
public class SanPham implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id")
    private String idSP;

    @Column(name = "Ma")
    private String maSP;

    @Column(name = "Ten")
    private String tenSP;
    /*
    @OneToMany(mappedBy="category", 
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;
     */
    @OneToMany(mappedBy = "sanPham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ChiTietSP> listCTSP;

    public SanPham() {
    }

    public SanPham(String idSP, String maSP, String tenSP, List<ChiTietSP> listCTSP) {
        this.idSP = idSP;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.listCTSP = listCTSP;
    }

    public SanPham(String maSP, String tenSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public List<ChiTietSP> getListCTSP() {
        return listCTSP;
    }

    public void setListCTSP(List<ChiTietSP> listCTSP) {
        this.listCTSP = listCTSP;
    }

    @Override
    public String toString() {
        return "SanPham{" + "idSP=" + idSP + ", maSP=" + maSP + ", tenSP=" + tenSP + '}';
    }

}
