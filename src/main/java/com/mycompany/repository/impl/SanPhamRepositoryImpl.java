/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.hibernateUtil.HibernateUtil;
import com.mycompany.domainModel.SanPham;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mycompany.repository.ICommon;

/**
 *
 * @author Duongntt
 */
public class SanPhamRepositoryImpl implements ICommon<SanPham> {

    public static final Session SESSION = HibernateUtil.getSSFactory().openSession();

    @Override
    public List<SanPham> getAll() {
        List<SanPham> listSP = new ArrayList<>();
        Query query = SESSION.createQuery("FROM SanPham");
        listSP = query.getResultList();
        return listSP;
    }

    @Override
    public boolean add(SanPham sanPham) {
        boolean themSP = false;
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.saveOrUpdate(sanPham);
                trans.commit();
                themSP = true;
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
                themSP = false;
            }
        } finally {
            return themSP;
        }
    }

    public static void main(String[] args) {
//        SanPham sanPhamNew = new SanPham();
//        sanPhamNew.setMaSP("SP6");
//        sanPhamNew.setTenSP("Sản Phẩm 6");
        SanPham sanPhamNew = new SanPham();
        sanPhamNew.setIdSP("CB66D5BD-671C-4130-867E-1EE66CF31197");
        sanPhamNew.setMaSP("SPUpdate");
        sanPhamNew.setTenSP("TenUpdate");
        System.out.println(new SanPhamRepositoryImpl().add(sanPhamNew));
        List<SanPham> listSP = new SanPhamRepositoryImpl().getAll();
        for (SanPham sanPham : listSP) {
            System.out.println(sanPham.toString());
        }
    }

    @Override
    public boolean update(SanPham t, String id) {
        int check = 0;
//        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
//            Transaction transaction = session.getTransaction();
//            transaction.begin();
//            try {
//                Query query = session.createQuery("UPDATE SanPham \n"
//                        + "SET Ma = :maSP, Ten = :tenSP\n"
//                        + "WHERE Id = :idSP");
//                query.setParameter("maSP", t.getMaSP());
//                query.setParameter("tenSP", t.getTenSP());
//                query.setParameter("idSP", id);
//                check = query.executeUpdate();
//                transaction.commit();
//            } catch (Exception e) {
//                e.printStackTrace();
//                transaction.rollback();
//            }
//        } finally {
//            return check > 0;
//        }
        Transaction transaction = SESSION.getTransaction();
        transaction.begin();
        try {
            SESSION.clear();
            Query query = SESSION.createQuery("UPDATE SanPham \n"
                    + "SET Ma = :maSP, Ten = :tenSP\n"
                    + "WHERE Id = :idSP");
            query.setParameter("maSP", t.getMaSP());
            query.setParameter("tenSP", t.getTenSP());
            query.setParameter("idSP", id);
            check = query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        SESSION.close();
        return check > 0;
    }

    @Override
    public boolean delete(String id) {
        int check = 0;
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                Query query = session.createQuery("DELETE FROM SanPham  WHERE Id = :idSP");
                query.setParameter("idSP", id);
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
}
