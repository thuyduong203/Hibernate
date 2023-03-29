/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.customModel.MauSacCustomModel;
import com.mycompany.hibernateUtil.HibernateUtil;
import com.mycompany.domainModel.MauSac;
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
public class MauSacRepositoryImpl implements ICommon<MauSac>, ICommonForView<MauSacCustomModel> {

    @Override
    public List<MauSac> getAll() {
        List<MauSac> listMauSac = new ArrayList<>();
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Query query = session.createQuery("FROM MauSac");
            listMauSac = query.getResultList();
        }
        return listMauSac;
    }

    @Override
    public boolean add(MauSac mauSac) {
        int check = 0;
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                session.save(mauSac);
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
    public boolean update(MauSac mauSac, String idMS) {
        int check = 0;
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                Query query = session.createQuery("UPDATE MauSac SET Ma = :maMS, Ten = :tenMS"
                        + " WHERE Id = :idMS");
                query.setParameter("maMS", mauSac.getMaMauSac());
                query.setParameter("tenMS", mauSac.getTenMauSac());
                query.setParameter("idMS", idMS);
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
                Query query = session.createQuery("DELETE FROM MauSac WHERE Id = :idMS");
                query.setParameter("idMS", id);
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
    public List<MauSacCustomModel> getAllCustom() {
        List<MauSacCustomModel> listMS = new ArrayList<>();
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Query query = session.createQuery("SELECT NEW com.mycompany.customModel.MauSacCustomModel "
                    + "(ms.idMauSac, ms.maMauSac, ms.tenMauSac) "
                    + " FROM com.mycompany.domainModel.MauSac ms");
            listMS = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMS;
    }

}
