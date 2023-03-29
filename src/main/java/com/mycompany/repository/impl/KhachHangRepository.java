/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.customModel.KhachHangCustomModel;
import com.mycompany.hibernateUtil.HibernateUtil;
import com.mycompany.domainModel.KhachHang;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mycompany.repository.ICommon;
import com.mycompany.repository.ICommonForView;

/**
 *
 * @author Duongntt
 */
public class KhachHangRepository implements ICommon<KhachHang>, ICommonForView<KhachHangCustomModel> {

    @Override
    public List<KhachHang> getAll() {
        List<KhachHang> listKH = new ArrayList<>();
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Query query = session.createQuery("FROM KhachHang");
            listKH = query.getResultList();
        }
        return listKH;
    }

    @Override
    public boolean add(KhachHang t) {
        int check = 0;
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                session.save(t);
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
    public boolean update(KhachHang t, String id) {
        int check = 0;
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                Query query = session.createQuery("UPDATE KhachHang\n"
                        + " SET Ma = :maKH, Ten = :tenKH, TenDem = :tenDem, Ho = :hoKH, \n"
                        + " NgaySinh = :ngaySinh, Sdt = :sdt, DiaChi = :diaChi,\n"
                        + " ThanhPho = :thanhPho, QuocGia = :quocGia, MatKhau = :matKhau\n"
                        + " WHERE Id = :idKH");
                query.setParameter("maKH", t.getMaKH());
                query.setParameter("tenKH", t.getTenKH());
                query.setParameter("tenDem", t.getTenDemKH());
                query.setParameter("hoKH", t.getHoKH());
                query.setParameter("ngaySinh", t.getNgaySinhKH());
                query.setParameter("sdt", t.getSdtKH());
                query.setParameter("diaChi", t.getDiaChiKH());
                query.setParameter("thanhPho", t.getThanhPhoKH());
                query.setParameter("quocGia", t.getQuocGiaKH());
                query.setParameter("matKhau", t.getMatKhau());
                query.setParameter("idKH", id);
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
    public boolean delete(String id) {
        int check = 0;
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                Query query = session.createQuery("DELETE FROM KhachHang WHERE Id = :idKH");
                query.setParameter("idKH", id);
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
    public List<KhachHangCustomModel> getAllCustom() {
        List<KhachHangCustomModel> listKH = new ArrayList<>();
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Query query = session.createQuery("SELECT NEW com.mycompany.customModel.KhachHangCustomModel "
                    + " (kh.idKH, kh.maKH, kh.tenKH, kh.tenDemKH, kh.hoKH, kh.ngaySinhKH,"
                    + " kh.sdtKH, kh.diaChiKH) "
                    + " FROM com.mycompany.domainModel.KhachHang kh");
            listKH = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }

    public static void main(String[] args) {
        List<KhachHangCustomModel> list = new KhachHangRepository().getAllCustom();
        for (KhachHangCustomModel khachHangCustomModel : list) {
            System.out.println(khachHangCustomModel.toString());
        }
    }
}
