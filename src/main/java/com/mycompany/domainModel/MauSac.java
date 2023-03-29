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
@Table(name = "MauSac")
public class MauSac implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id")
    private String idMauSac;

    @Column(name = "Ma")
    private String maMauSac;

    @Column(name = "Ten")
    private String tenMauSac;

    @OneToMany(mappedBy = "mauSac", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ChiTietSP> listCTSP;

    public MauSac() {
    }

    public MauSac(String idMauSac, String maMauSac, String tenMauSac) {
        this.idMauSac = idMauSac;
        this.maMauSac = maMauSac;
        this.tenMauSac = tenMauSac;
    }

    public MauSac(String idMauSac, String tenMauSac) {
        this.idMauSac = idMauSac;
        this.tenMauSac = tenMauSac;
    }

    public MauSac(String idMauSac) {
        this.idMauSac = idMauSac;
    }

    public String getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(String idMauSac) {
        this.idMauSac = idMauSac;
    }

    public String getMaMauSac() {
        return maMauSac;
    }

    public void setMaMauSac(String maMauSac) {
        this.maMauSac = maMauSac;
    }

    public String getTenMauSac() {
        return tenMauSac;
    }

    public void setTenMauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }

    @Override
    public String toString() {
        return "MauSac{" + "idMauSac=" + idMauSac + ", maMauSac=" + maMauSac + ", tenMauSac=" + tenMauSac + '}';
    }

}
