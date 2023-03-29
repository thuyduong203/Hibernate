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
@Table(name = "DongSP")
public class DongSP implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id")
    private String IdDongSP;

    @Column(name = "Ma")
    private String maDongSP;

    @Column(name = "Ten")
    private String tenDongSP;

    @OneToMany(mappedBy = "dongSP", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ChiTietSP> listCTSP;

    public DongSP() {
    }

    public DongSP(String IdDongSP, String maDongSP, String tenDongSP, List<ChiTietSP> listCTSP) {
        this.IdDongSP = IdDongSP;
        this.maDongSP = maDongSP;
        this.tenDongSP = tenDongSP;
        this.listCTSP = listCTSP;
    }

    public DongSP(String IdDongSP, String maDongSP, String tenDongSP) {
        this.IdDongSP = IdDongSP;
        this.maDongSP = maDongSP;
        this.tenDongSP = tenDongSP;
    }

    public DongSP(String IdDongSP, String tenDongSP) {
        this.IdDongSP = IdDongSP;
        this.tenDongSP = tenDongSP;
    }

    public DongSP(String IdDongSP) {
        this.IdDongSP = IdDongSP;
    }

    public String getIdDongSP() {
        return IdDongSP;
    }

    public void setIdDongSP(String IdDongSP) {
        this.IdDongSP = IdDongSP;
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

    public List<ChiTietSP> getListCTSP() {
        return listCTSP;
    }

    public void setListCTSP(List<ChiTietSP> listCTSP) {
        this.listCTSP = listCTSP;
    }

    @Override
    public String toString() {
        return "DongSP{" + "IdDongSP=" + IdDongSP + ", maDongSP=" + maDongSP + ", tenDongSP=" + tenDongSP + '}';
    }
}
