/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domainModel;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "GioHangChiTiet")
public class GioHangChiTiet implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "IdGioHang", nullable = true)
    private GioHang gioHang;

    @Id
    @ManyToOne
    @JoinColumn(name = "IdChiTietSP", nullable = true)
    private ChiTietSP chiTietSP;
    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "DonGia")
    private BigDecimal donGia;

    @Column(name = "DonGiaKhiGiam")
    private BigDecimal donGiaKhiGiam;

    public GioHangChiTiet() {
    }

    public GioHangChiTiet(GioHang gioHang, ChiTietSP chiTietSP, int soLuong, BigDecimal donGia, BigDecimal donGiaKhiGiam) {
        this.gioHang = gioHang;
        this.chiTietSP = chiTietSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    public GioHang getGioHang() {
        return gioHang;
    }

    public void setGioHang(GioHang gioHang) {
        this.gioHang = gioHang;
    }

    public ChiTietSP getChiTietSP() {
        return chiTietSP;
    }

    public void setChiTietSP(ChiTietSP chiTietSP) {
        this.chiTietSP = chiTietSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public BigDecimal getDonGiaKhiGiam() {
        return donGiaKhiGiam;
    }

    public void setDonGiaKhiGiam(BigDecimal donGiaKhiGiam) {
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    @Override
    public String toString() {
        return "GioHangChiTiet{" + "gioHang=" + gioHang + ", chiTietSP=" + chiTietSP + ", soLuong=" + soLuong + ", donGia=" + donGia + ", donGiaKhiGiam=" + donGiaKhiGiam + '}';
    }

    public Object[] todataRow() {
        return new Object[]{gioHang.getIdGioHang(), chiTietSP.getIdCTSP(), soLuong, donGia, donGiaKhiGiam};
    }
}
