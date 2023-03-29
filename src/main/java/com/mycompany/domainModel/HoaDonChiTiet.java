/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domainModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet implements Serializable {

    @Id
//    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
//    @GeneratedValue(generator = "generator")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdHoaDon", nullable = false)
    private HoaDon hoaDon;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdChiTietSP")
    private ChiTietSP chiTietSP;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "DonGia")
    private BigDecimal donGia;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(HoaDon hoaDon, ChiTietSP chiTietSP, int soLuong, BigDecimal donGia, List<ChiTietSP> listCTSP) {
        this.hoaDon = hoaDon;
        this.chiTietSP = chiTietSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        // this.listCTSP = listCTSP;
    }

    public HoaDonChiTiet(HoaDon hoaDon, ChiTietSP chiTietSP, int soLuong, BigDecimal donGia) {
        this.hoaDon = hoaDon;
        this.chiTietSP = chiTietSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
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

//    public List<ChiTietSP> getListCTSP() {
//        return listCTSP;
//    }
//
//    public void setListCTSP(List<ChiTietSP> listCTSP) {
//        this.listCTSP = listCTSP;
//    }
    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "hoaDon=" + hoaDon + ", chiTietSP=" + chiTietSP + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }

    public Object[] toDataRowBanHang(int stt) {
        return new Object[]{stt, chiTietSP.getSanPham().getMaSP(), chiTietSP.getSanPham().getTenSP(), soLuong, donGia, (donGia.doubleValue() * soLuong)};
    }
}
