/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domainModel;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "GioHang")
public class GioHang implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id")
    private String idGioHang;

    @ManyToOne
    @JoinColumn(name = "IdKH", nullable = true)
    private KhachHang khachHang;

    @Column(name = "IdNV")
    private String idNV;

    @Column(name = "Ma", unique = true)
    private String maGioHang;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;

    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;

    @Column(name = "DiaChi")
    private String diaChiNN;

    @Column(name = "Sdt")
    private String soDienThoaiNN;

    @Column(name = "TinhTrang")
    private int tinhTrang;

    public GioHang() {
    }

    public GioHang(String idGioHang, KhachHang khachHang, String idNV, String maGioHang, Date ngayTao, Date ngayThanhToan, String tenNguoiNhan, String diaChiNN, String soDienThoaiNN, int tinhTrang) {
        this.idGioHang = idGioHang;
        this.khachHang = khachHang;
        this.idNV = idNV;
        this.maGioHang = maGioHang;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChiNN = diaChiNN;
        this.soDienThoaiNN = soDienThoaiNN;
        this.tinhTrang = tinhTrang;
    }

    public GioHang(String idGioHang) {
        this.idGioHang = idGioHang;
    }

    public String getIdGioHang() {
        return idGioHang;
    }

    public void setIdGioHang(String idGioHang) {
        this.idGioHang = idGioHang;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getMaGioHang() {
        return maGioHang;
    }

    public void setMaGioHang(String maGioHang) {
        this.maGioHang = maGioHang;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public String getDiaChiNN() {
        return diaChiNN;
    }

    public void setDiaChiNN(String diaChiNN) {
        this.diaChiNN = diaChiNN;
    }

    public String getSoDienThoaiNN() {
        return soDienThoaiNN;
    }

    public void setSoDienThoaiNN(String soDienThoaiNN) {
        this.soDienThoaiNN = soDienThoaiNN;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "GioHang{" + "idGioHang=" + idGioHang + ", khachHang=" + khachHang + ", nhanVien=" + idNV + ", maGioHang=" + maGioHang + ", ngayTao=" + ngayTao + ", ngayThanhToan=" + ngayThanhToan + ", tenNguoiNhan=" + tenNguoiNhan + ", diaChiNN=" + diaChiNN + ", soDienThoaiNN=" + soDienThoaiNN + ", tinhTrang=" + tinhTrang + '}';
    }

    public Object[] toDataRow() {
        return new Object[]{idGioHang, khachHang.getIdKH(), idNV, maGioHang, ngayTao, ngayThanhToan, tenNguoiNhan, diaChiNN, soDienThoaiNN, tinhTrang};
    }
}
