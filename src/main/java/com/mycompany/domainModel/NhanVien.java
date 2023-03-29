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
@Table(name = "NhanVien")
public class NhanVien implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id")
    private String idNV;

    @Column(name = "Ma", unique = true)
    private String maNV;

    @Column(name = "Ten")
    private String tenNV;

    @Column(name = "TenDem")
    private String tenDemNV;

    @Column(name = "Ho")
    private String hoNV;

    @Column(name = "GioiTinh")
    private String gioiTinhNV;

    @Column(name = "NgaySinh")
    private Date ngaySinhNV;

    @Column(name = "DiaChi")
    private String diaChiNV;

    @Column(name = "Sdt")
    private String sdtNV;

    @Column(name = "MatKhau")
    private String matKhauNV;

    @ManyToOne
    @JoinColumn(name = "IdCH", nullable = true)
    private CuaHang cuaHang;

    @ManyToOne
    @JoinColumn(name = "IdCV", nullable = true)
    private ChucVu chucVu;

    @ManyToOne()
    @JoinColumn(name = "idGuiBC", nullable = true)
    private NhanVien nguoiGuiBC;

    @Column(name = "TrangThai")
    private int trangThai;

    public NhanVien() {
    }
    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HoaDon> listHD;

    public NhanVien(String idNV, String maNV, String tenNV, String tenDemNV, String hoNV, String gioiTinhNV, Date ngaySinhNV, String diaChiNV, String sdtNV, String matKhauNV, CuaHang cuaHang, ChucVu chucVu, NhanVien nguoiGuiBC, int trangThai, List<HoaDon> listHD) {
        this.idNV = idNV;
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.tenDemNV = tenDemNV;
        this.hoNV = hoNV;
        this.gioiTinhNV = gioiTinhNV;
        this.ngaySinhNV = ngaySinhNV;
        this.diaChiNV = diaChiNV;
        this.sdtNV = sdtNV;
        this.matKhauNV = matKhauNV;
        this.cuaHang = cuaHang;
        this.chucVu = chucVu;
        this.nguoiGuiBC = nguoiGuiBC;
        this.trangThai = trangThai;
        this.listHD = listHD;
    }

    public NhanVien(String idNV, String maNV, String tenNV, String tenDemNV, String hoNV, String gioiTinhNV, Date ngaySinhNV, String diaChiNV, String sdtNV, String matKhauNV, CuaHang cuaHang, ChucVu chucVu, NhanVien nguoiGuiBC, int trangThai) {
        this.idNV = idNV;
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.tenDemNV = tenDemNV;
        this.hoNV = hoNV;
        this.gioiTinhNV = gioiTinhNV;
        this.ngaySinhNV = ngaySinhNV;
        this.diaChiNV = diaChiNV;
        this.sdtNV = sdtNV;
        this.matKhauNV = matKhauNV;
        this.cuaHang = cuaHang;
        this.chucVu = chucVu;
        this.nguoiGuiBC = nguoiGuiBC;
        this.trangThai = trangThai;
    }

    public List<HoaDon> getListHD() {
        return listHD;
    }

    public void setListHD(List<HoaDon> listHD) {
        this.listHD = listHD;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getTenDemNV() {
        return tenDemNV;
    }

    public void setTenDemNV(String tenDemNV) {
        this.tenDemNV = tenDemNV;
    }

    public String getHoNV() {
        return hoNV;
    }

    public void setHoNV(String hoNV) {
        this.hoNV = hoNV;
    }

    public String getGioiTinhNV() {
        return gioiTinhNV;
    }

    public void setGioiTinhNV(String gioiTinhNV) {
        this.gioiTinhNV = gioiTinhNV;
    }

    public Date getNgaySinhNV() {
        return ngaySinhNV;
    }

    public void setNgaySinhNV(Date ngaySinhNV) {
        this.ngaySinhNV = ngaySinhNV;
    }

    public String getDiaChiNV() {
        return diaChiNV;
    }

    public void setDiaChiNV(String diaChiNV) {
        this.diaChiNV = diaChiNV;
    }

    public String getSdtNV() {
        return sdtNV;
    }

    public void setSdtNV(String sdtNV) {
        this.sdtNV = sdtNV;
    }

    public String getMatKhauNV() {
        return matKhauNV;
    }

    public void setMatKhauNV(String matKhauNV) {
        this.matKhauNV = matKhauNV;
    }

    public CuaHang getCuaHang() {
        return cuaHang;
    }

    public void setCuaHang(CuaHang cuaHang) {
        this.cuaHang = cuaHang;
    }

    public ChucVu getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }

    public NhanVien getNguoiGuiBC() {
        return nguoiGuiBC;
    }

    public void setNguoiGuiBC(NhanVien nguoiGuiBC) {
        this.nguoiGuiBC = nguoiGuiBC;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

//    @Override
//    public String toString() {
//        return "NhanVien{" + "idNV=" + idNV + ", maNV=" + maNV + ", tenNV=" + tenNV + ", tenDemNV=" + tenDemNV + ", hoNV=" + hoNV + ", gioiTinhNV=" + gioiTinhNV + ", ngaySinhNV=" + ngaySinhNV + ", diaChiNV=" + diaChiNV + ", sdtNV=" + sdtNV + ", matKhauNV=" + matKhauNV + ", cuaHang=" + cuaHang + ", chucVu=" + chucVu + ", nguoiGuiBC=" + nguoiGuiBC + ", trangThai=" + trangThai + '}';
//    }

}
