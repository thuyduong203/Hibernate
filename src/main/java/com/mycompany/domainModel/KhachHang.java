/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domainModel;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name = "KhachHang")
public class KhachHang implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id")
    private String idKH;

    @Column(name = "Ma", unique = true)
    private String maKH;

    @Column(name = "Ten")
    private String tenKH;

    @Column(name = "TenDem")
    private String tenDemKH;

    @Column(name = "Ho")
    private String hoKH;

    @Column(name = "NgaySinh")
    private Date ngaySinhKH;

    @Column(name = "Sdt")
    private String sdtKH;

    @Column(name = "DiaChi")
    private String diaChiKH;

    @Column(name = "ThanhPho")
    private String thanhPhoKH;

    @Column(name = "QuocGia")
    private String quocGiaKH;

    @Column(name = "MatKhau")
    private String matKhau;

    @OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<HoaDon> listHD;

//    @OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<GioHang> listGH;
    public KhachHang() {
    }

    public KhachHang(String idKH, String maKH, String tenKH, String tenDemKH, String hoKH, Date ngaySinhKH, String sdtKH, String diaChiKH, String thanhPhoKH, String quocGiaKH, String matKhau, List<HoaDon> listHD) {
        this.idKH = idKH;
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.tenDemKH = tenDemKH;
        this.hoKH = hoKH;
        this.ngaySinhKH = ngaySinhKH;
        this.sdtKH = sdtKH;
        this.diaChiKH = diaChiKH;
        this.thanhPhoKH = thanhPhoKH;
        this.quocGiaKH = quocGiaKH;
        this.matKhau = matKhau;
        this.listHD = listHD;
    }

    public KhachHang(String maKH, String tenKH, String tenDemKH, String hoKH, Date ngaySinhKH, String sdtKH, String diaChiKH, String thanhPhoKH, String quocGiaKH, String matKhau) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.tenDemKH = tenDemKH;
        this.hoKH = hoKH;
        this.ngaySinhKH = ngaySinhKH;
        this.sdtKH = sdtKH;
        this.diaChiKH = diaChiKH;
        this.thanhPhoKH = thanhPhoKH;
        this.quocGiaKH = quocGiaKH;
        this.matKhau = matKhau;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getTenDemKH() {
        return tenDemKH;
    }

    public void setTenDemKH(String tenDemKH) {
        this.tenDemKH = tenDemKH;
    }

    public String getHoKH() {
        return hoKH;
    }

    public void setHoKH(String hoKH) {
        this.hoKH = hoKH;
    }

    public Date getNgaySinhKH() {
        return ngaySinhKH;
    }

    public void setNgaySinhKH(Date ngaySinhKH) {
        this.ngaySinhKH = ngaySinhKH;
    }

    public String getSdtKH() {
        return sdtKH;
    }

    public void setSdtKH(String sdtKH) {
        this.sdtKH = sdtKH;
    }

    public String getDiaChiKH() {
        return diaChiKH;
    }

    public void setDiaChiKH(String diaChiKH) {
        this.diaChiKH = diaChiKH;
    }

    public String getThanhPhoKH() {
        return thanhPhoKH;
    }

    public void setThanhPhoKH(String thanhPhoKH) {
        this.thanhPhoKH = thanhPhoKH;
    }

    public String getQuocGiaKH() {
        return quocGiaKH;
    }

    public void setQuocGiaKH(String quocGiaKH) {
        this.quocGiaKH = quocGiaKH;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public List<HoaDon> getListHD() {
        return listHD;
    }

    public void setListHD(List<HoaDon> listHD) {
        this.listHD = listHD;
    }



    @Override
    public String toString() {
        return "KhachHang{" + "idKH=" + idKH + ", maKH=" + maKH + ", tenKH=" + tenKH + ", tenDemKH=" + tenDemKH + ", hoKH=" + hoKH + ", ngaySinhKH=" + ngaySinhKH + ", sdtKH=" + sdtKH + ", diaChiKH=" + diaChiKH + ", thanhPhoKH=" + thanhPhoKH + ", quocGiaKH=" + quocGiaKH + ", matKhau=" + matKhau + '}';
    }

}
