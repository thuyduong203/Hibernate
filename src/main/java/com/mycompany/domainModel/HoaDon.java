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
@Table(name = "HoaDon")
public class HoaDon implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id")
    private String idHoaDon;

    @ManyToOne
    @JoinColumn(name = "IdKH", nullable = true)
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "IdNV", nullable = false)
    private NhanVien nhanVien;

    @Column(name = "Ma", unique = true)
    private String maHoaDon;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;

    @Column(name = "NgayShip")
    private Date ngayShip;

    @Column(name = "NgayNhan")
    private Date ngayNhan;

    @Column(name = "TinhTrang")
    private int tinhTrangHD;

    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;

    @Column(name = "DiaChi")
    private String diaChiNguoiNhan;

    @Column(name = "Sdt")
    private String sdtNguoiNhan;

    @OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> listHDCT;

    public HoaDon() {
    }

    public HoaDon(String idHoaDon, KhachHang khachHang, NhanVien nhanVien, String maHoaDon, Date ngayTao, Date ngayThanhToan, Date ngayShip, Date ngayNhan, int tinhTrangHD, String tenNguoiNhan, String diaChiNguoiNhan, String sdtNguoiNhan, List<HoaDonChiTiet> listHDCT) {
        this.idHoaDon = idHoaDon;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.ngayShip = ngayShip;
        this.ngayNhan = ngayNhan;
        this.tinhTrangHD = tinhTrangHD;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChiNguoiNhan = diaChiNguoiNhan;
        this.sdtNguoiNhan = sdtNguoiNhan;
        this.listHDCT = listHDCT;
    }

    public HoaDon(KhachHang khachHang, NhanVien nhanVien, String maHoaDon, Date ngayTao, Date ngayThanhToan, Date ngayShip, Date ngayNhan, int tinhTrangHD, String tenNguoiNhan, String diaChiNguoiNhan, String sdtNguoiNhan) {
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.ngayShip = ngayShip;
        this.ngayNhan = ngayNhan;
        this.tinhTrangHD = tinhTrangHD;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChiNguoiNhan = diaChiNguoiNhan;
        this.sdtNguoiNhan = sdtNguoiNhan;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
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

    public Date getNgayShip() {
        return ngayShip;
    }

    public void setNgayShip(Date ngayShip) {
        this.ngayShip = ngayShip;
    }

    public Date getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(Date ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public int getTinhTrangHD() {
        return tinhTrangHD;
    }

    public void setTinhTrangHD(int tinhTrangHD) {
        this.tinhTrangHD = tinhTrangHD;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public String getDiaChiNguoiNhan() {
        return diaChiNguoiNhan;
    }

    public void setDiaChiNguoiNhan(String diaChiNguoiNhan) {
        this.diaChiNguoiNhan = diaChiNguoiNhan;
    }

    public String getSdtNguoiNhan() {
        return sdtNguoiNhan;
    }

    public void setSdtNguoiNhan(String sdtNguoiNhan) {
        this.sdtNguoiNhan = sdtNguoiNhan;
    }

    public List<HoaDonChiTiet> getListHDCT() {
        return listHDCT;
    }

    public void setListHDCT(List<HoaDonChiTiet> listHDCT) {
        this.listHDCT = listHDCT;
    }

//    @Override
//    public String toString() {
//        return "HoaDon{" + "idHoaDon=" + idHoaDon + ", khachHang=" + khachHang + ", nhanVien=" + nhanVien + ", maHoaDon=" + maHoaDon + ", ngayTao=" + ngayTao + ", ngayThanhToan=" + ngayThanhToan + ", ngayShip=" + ngayShip + ", ngayNhan=" + ngayNhan + ", tinhTrangHD=" + tinhTrangHD + ", tenNguoiNhan=" + tenNguoiNhan + ", diaChiNguoiNhan=" + diaChiNguoiNhan + ", sdtNguoiNhan=" + sdtNguoiNhan + '}';
//    }
    public String trangThaoHD(int trangThai) {
        if (trangThai == 1) {
            return "Đã thanh toán";
        } else if (trangThai == 2) {
            return "Chờ thanh toán";
        } else if (trangThai == 0) {
            return "Đã huỷ";
        } else {
            return "??";
        }
    }

//    public Object[] todataRow() {
//        return new Object[]{idHoaDon, (khachHang != null ? khachHang.getIdKH() : null), (nhanVien != null ? nhanVien.getIdNV() : null), maHoaDon, ngayTao, ngayThanhToan, ngayNhan, ngayShip, tenNguoiNhan, diaChiNguoiNhan, sdtNguoiNhan, trangThaoHD(tinhTrangHD)};
//    }
    public Object[] toDataRowBanHang(int stt) {
        return new Object[]{stt, maHoaDon, ngayTao, nhanVien.getMaNV(), trangThaoHD(tinhTrangHD)};
    }
}
