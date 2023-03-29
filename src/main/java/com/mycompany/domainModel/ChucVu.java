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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "ChucVu")
public class ChucVu implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id")
    private String idCV;

    @Column(name = "Ma")
    private String maCV;

    @Column(name = "Ten")
    private String tenCV;

    @OneToMany(mappedBy = "chucVu", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<NhanVien> listNV;

    public ChucVu() {
    }

    public ChucVu(String idCV, String maCV, String tenCV, List<NhanVien> listNV) {
        this.idCV = idCV;
        this.maCV = maCV;
        this.tenCV = tenCV;
        this.listNV = listNV;
    }

    public String getIdCV() {
        return idCV;
    }

    public void setIdCV(String idCV) {
        this.idCV = idCV;
    }

    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    public List<NhanVien> getListNV() {
        return listNV;
    }

    public void setListNV(List<NhanVien> listNV) {
        this.listNV = listNV;
    }

    @Override
    public String toString() {
        return "ChucVu{" + "idCV=" + idCV + ", maCV=" + maCV + ", tenCV=" + tenCV + '}';
    }

    public Object[] todataRow() {
        return new Object[]{maCV, tenCV};
    }
}
