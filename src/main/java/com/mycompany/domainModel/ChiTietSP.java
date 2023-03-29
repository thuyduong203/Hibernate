/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domainModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "ChiTietSP")
public class ChiTietSP implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id")
    private String idCTSP;

    @ManyToOne
    @JoinColumn(name = "IdDongSP")
    private DongSP dongSP;

    @Column(name = "GiaBan")
    private BigDecimal giaBan;

    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @ManyToOne
    @JoinColumn(name = "IdMauSac")
    private MauSac mauSac;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "NamBH")
    private int namBH;

    @ManyToOne
    @JoinColumn(name = "IdNsx")
    private NSX nsx;

    @ManyToOne
    @JoinColumn(name = "IdSP", nullable = true)
    private SanPham sanPham;

    @Column(name = "SoLuongTon")
    private int soLuongTon;

    @OneToMany(mappedBy = "chiTietSP", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> listHDCT;

    @OneToMany(mappedBy = "chiTietSP", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GioHangChiTiet> listGHCT;

    public ChiTietSP() {
    }

    public ChiTietSP(String idCTSP, DongSP dongSP, BigDecimal giaBan, BigDecimal giaNhap, MauSac mauSac, String moTa, int namBH, NSX nsx, SanPham sanPham, int soLuongTon, List<HoaDonChiTiet> listHDCT, List<GioHangChiTiet> listGHCT) {
        this.idCTSP = idCTSP;
        this.dongSP = dongSP;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.mauSac = mauSac;
        this.moTa = moTa;
        this.namBH = namBH;
        this.nsx = nsx;
        this.sanPham = sanPham;
        this.soLuongTon = soLuongTon;
        this.listHDCT = listHDCT;
        this.listGHCT = listGHCT;
    }

    public ChiTietSP(DongSP dongSP, BigDecimal giaBan, BigDecimal giaNhap, MauSac mauSac, String moTa, int namBH, NSX nsx, SanPham sanPham, int soLuongTon) {
        this.dongSP = dongSP;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.mauSac = mauSac;
        this.moTa = moTa;
        this.namBH = namBH;
        this.nsx = nsx;
        this.sanPham = sanPham;
        this.soLuongTon = soLuongTon;
    }

    public String getIdCTSP() {
        return idCTSP;
    }

    public void setIdCTSP(String idCTSP) {
        this.idCTSP = idCTSP;
    }

    public DongSP getDongSP() {
        return dongSP;
    }

    public void setDongSP(DongSP dongSP) {
        this.dongSP = dongSP;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getNamBH() {
        return namBH;
    }

    public void setNamBH(int namBH) {
        this.namBH = namBH;
    }

    public NSX getNsx() {
        return nsx;
    }

    public void setNsx(NSX nsx) {
        this.nsx = nsx;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public List<HoaDonChiTiet> getListHDCT() {
        return listHDCT;
    }

    public void setListHDCT(List<HoaDonChiTiet> listHDCT) {
        this.listHDCT = listHDCT;
    }

    public List<GioHangChiTiet> getListGHCT() {
        return listGHCT;
    }

    public void setListGHCT(List<GioHangChiTiet> listGHCT) {
        this.listGHCT = listGHCT;
    }

    @Override
    public String toString() {
        return "ChiTietSP{" + "idCTSP=" + idCTSP + ", sanPham=" + sanPham + ", nsx=" + nsx + ", mauSac=" + mauSac + ", dongSP=" + dongSP + ", namBH=" + namBH + ", moTa=" + moTa + ", soLuongTon=" + soLuongTon + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + '}';
    }
    
    public Object[] toDataRowBanHang(int stt) {
        return new Object[]{stt, sanPham.getMaSP(), sanPham.getTenSP(), namBH, moTa, soLuongTon, giaNhap, giaBan};
    }
}
