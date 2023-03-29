/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.customModel.HoaDonChiTietCustomModel;
import com.mycompany.hibernateUtil.HibernateUtil;
import com.mycompany.domainModel.HoaDonChiTiet;
import com.mycompany.repository.IHoaDonChiTietRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mycompany.repository.ICommon;
import com.mycompany.repository.ICommonForView;

/**
 *
 * @author Duongntt
 */
public class HoaDonChiTietRepository implements ICommon<HoaDonChiTiet>, IHoaDonChiTietRepository, ICommonForView<HoaDonChiTietCustomModel> {

    @Override
    public List<HoaDonChiTiet> getAll() {
        List<HoaDonChiTiet> listHDCT = new ArrayList<>();
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Query query = session.createQuery("FROM HoaDonChiTiet");
            listHDCT = query.getResultList();
        }
        return listHDCT;
    }

    @Override
    public boolean add(HoaDonChiTiet hoaDonChiTiet) {
        int check = 0;
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                session.save(hoaDonChiTiet);
                transaction.commit();
                check = 1;
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
            }
        } finally {
            return check > 0;
        }
    }

    @Override
    public boolean update(HoaDonChiTiet t, String id) {
        JOptionPane.showMessageDialog(null, "Nhầm hàm rồi má");
        return false;
    }

    @Override
    public boolean delete(String id) {
        JOptionPane.showMessageDialog(null, "nhaamf ham roi");
        return false;
    }

    @Override
    public boolean updateHDCT(HoaDonChiTiet hoaDonChiTiet, String idHoaDon, String idCTSP) {
        int check = 0;
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                Query query = session.createQuery("UPDATE HoaDonChiTiet SET SoLuong = :soLuong, DonGia = :donGia\n"
                        + " WHERE IdHoaDon = :idHD\n"
                        + " AND IdChiTietSP = :idCTSP");
                query.setParameter("soLuong", hoaDonChiTiet.getSoLuong());
                query.setParameter("donGia", hoaDonChiTiet.getDonGia());
                query.setParameter("idHD", idHoaDon);
                query.setParameter("idCTSP", idCTSP);
                check = query.executeUpdate();
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
            }
        } finally {
            return check > 0;
        }
    }

    @Override
    public boolean deleteHDCT(String idHoaDon, String idCTSP) {
        int check = 0;
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                Query query = session.createQuery("DELETE FROM HoaDonChiTiet "
                        + "WHERE IdHoaDon = :idHD AND IdChiTietSP = : idCTSP");
                query.setParameter("idHD", idHoaDon);
                query.setParameter("idCTSP", idCTSP);
                check = query.executeUpdate();
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
            }
        } finally {
            return check > 0;

        }
    }

    @Override
    public List<HoaDonChiTietCustomModel> getAllCustom() {
        List<HoaDonChiTietCustomModel> listHDCT = new ArrayList<>();
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Query query = session.createQuery("SELECT NEW com.mycompany.customModel.HoaDonChiTietCustomModel "
                    + " (hdct.hoaDon.idHoaDon, hdct.chiTietSP.idCTSP, hdct.soLuong, hdct.donGia) "
                    + " FROM com.mycompany.domainModel.HoaDonChiTiet hdct");
            listHDCT = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHDCT;
    }

    public static void main(String[] args) {
        List<HoaDonChiTietCustomModel> list = new HoaDonChiTietRepository().getAllCustom();
        for (HoaDonChiTietCustomModel hoaDonChiTietCustomModel : list) {
            System.out.println(hoaDonChiTietCustomModel.toDataRow());
        }
    }
}
