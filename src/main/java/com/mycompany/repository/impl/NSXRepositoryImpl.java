/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.customModel.NSXCustomModel;
import com.mycompany.hibernateUtil.HibernateUtil;
import com.mycompany.domainModel.NSX;
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
public class NSXRepositoryImpl implements ICommon<NSX>, ICommonForView<NSXCustomModel> {

    @Override
    public List<NSX> getAll() {
        List<NSX> listNsx = new ArrayList<>();
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Query query = session.createQuery("FROM NSX");
            listNsx = query.getResultList();
        }
        return listNsx;
    }

    @Override
    public boolean add(NSX t) {
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
    public boolean update(NSX nsx, String id) {
        int check = 0;
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                Query query = session.createQuery("UPDATE NSX SET Ma = :maNSX, Ten = :tenNSX"
                        + " WHERE Id = :idNSX");
                query.setParameter("maNSX", nsx.getMaNSX());
                query.setParameter("tenNSX", nsx.getTenNSX());
                query.setParameter("idNSX", id);
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
                Query query = session.createQuery("DELETE FROM NSX WHERE Id = :idNSX");
                query.setParameter("idNSX", id);
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
    public List<NSXCustomModel> getAllCustom() {
        List<NSXCustomModel> listNSX = new ArrayList<>();
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Query query = session.createQuery("SELECT NEW com.mycompany.customModel.NSXCustomModel "
                    + "(nsx.idNSX, nsx.maNSX, nsx. tenNSX) "
                    + " FROM NSX nsx");
            listNSX = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNSX;
    }

    public static void main(String[] args) {
        List<NSXCustomModel> list = new NSXRepositoryImpl().getAllCustom();
        for (NSXCustomModel nSXCustomModel : list) {
            System.out.println(nSXCustomModel.toString());
        }
    }
}
