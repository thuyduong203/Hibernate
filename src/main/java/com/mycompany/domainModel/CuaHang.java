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
@Table(name = "CuaHang")
public class CuaHang implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id")
    private String idCH;

    @Column(name = "Ma")
    private String maCH;

    @Column(name = "Ten")
    private String TenCH;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "ThanhPho")
    private String ThanhPho;

    @Column(name = "QuocGia")
    private String QuocGia;

    @OneToMany(mappedBy = "cuaHang", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<NhanVien> listNV;

    public CuaHang() {
    }

    public CuaHang(String idCH, String maCH, String TenCH, String diaChi, String ThanhPho, String QuocGia, List<NhanVien> listNV) {
        this.idCH = idCH;
        this.maCH = maCH;
        this.TenCH = TenCH;
        this.diaChi = diaChi;
        this.ThanhPho = ThanhPho;
        this.QuocGia = QuocGia;
        this.listNV = listNV;
    }

    public CuaHang(String maCH, String TenCH, String diaChi, String ThanhPho, String QuocGia) {
        this.maCH = maCH;
        this.TenCH = TenCH;
        this.diaChi = diaChi;
        this.ThanhPho = ThanhPho;
        this.QuocGia = QuocGia;
    }

    public String getIdCH() {
        return idCH;
    }

    public void setIdCH(String idCH) {
        this.idCH = idCH;
    }

    public String getMaCH() {
        return maCH;
    }

    public void setMaCH(String maCH) {
        this.maCH = maCH;
    }

    public String getTenCH() {
        return TenCH;
    }

    public void setTenCH(String TenCH) {
        this.TenCH = TenCH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getThanhPho() {
        return ThanhPho;
    }

    public void setThanhPho(String ThanhPho) {
        this.ThanhPho = ThanhPho;
    }

    public String getQuocGia() {
        return QuocGia;
    }

    public void setQuocGia(String QuocGia) {
        this.QuocGia = QuocGia;
    }

    public List<NhanVien> getListNV() {
        return listNV;
    }

    public void setListNV(List<NhanVien> listNV) {
        this.listNV = listNV;
    }

    @Override
    public String toString() {
        return "CuaHang{" + "idCH=" + idCH + ", maCH=" + maCH + ", TenCH=" + TenCH + ", diaChi=" + diaChi + ", ThanhPho=" + ThanhPho + ", QuocGia=" + QuocGia + ", listNV=" + listNV + '}';
    }

}
