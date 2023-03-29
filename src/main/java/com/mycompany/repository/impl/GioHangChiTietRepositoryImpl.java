/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.hibernateUtil.HibernateUtil;
import com.mycompany.domainModel.GioHangChiTiet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import com.mycompany.repository.ICommon;

/**
 *
 * @author Duongntt
 */
public class GioHangChiTietRepositoryImpl implements ICommon<GioHangChiTiet> {

    public static final Session SESSION = HibernateUtil.getSSFactory().openSession();

    @Override
    public List<GioHangChiTiet> getAll() {
        List<GioHangChiTiet> lisstGHCT = new ArrayList<>();
        Query query = SESSION.createQuery("FROM GioHangChiTiet");
        lisstGHCT = query.getResultList();
        return lisstGHCT;
    }

    @Override
    public boolean add(GioHangChiTiet t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(GioHangChiTiet t, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        List<GioHangChiTiet> listGHCT = new GioHangChiTietRepositoryImpl().getAll();
        for (GioHangChiTiet gioHangChiTiet : listGHCT) {
            System.out.println(gioHangChiTiet.toString());
        }
    }
}
