/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.customModel.DongSPCustomModel;
import com.mycompany.hibernateUtil.HibernateUtil;
import com.mycompany.domainModel.DongSP;
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
public class DongSPRepositoryImpl implements ICommon<DongSP>, ICommonForView<DongSPCustomModel> {

    @Override
    public List<DongSP> getAll() {
        List<DongSP> listDongSP = new ArrayList<>();
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Query query = session.createQuery("FROM DongSP");
            listDongSP = query.getResultList();
        }
        return listDongSP;
    }

    @Override
    public boolean add(DongSP t) {
        boolean isAdd = false;
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.save(t);
                trans.commit();
                isAdd = true;
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
            }
        } finally {
            return isAdd;
        }
    }

    @Override
    public boolean update(DongSP t, String id) {
        int check = 0;
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                Query query = session.createQuery("UPDATE DongSP SET Ma = :maDongSP, Ten = :tenDongSP WHERE Id = :id");
                query.setParameter("maDongSP", t.getMaDongSP());
                query.setParameter("tenDongSP", t.getTenDongSP());
                query.setParameter("id", id);
                check = query.executeUpdate();
                trans.commit();
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
            }
        } finally {
            return check > 0;
        }
    }

    @Override
    public boolean delete(String id) {
        int check = 0;
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                Query query = session.createQuery("DELETE FROM DongSP WHERE Id = :id");
                query.setParameter("id", id);
                check = query.executeUpdate();
                trans.commit();
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
            }
        } finally {
            return check > 0;
        }
    }

    @Override
    public List<DongSPCustomModel> getAllCustom() {
        List<DongSPCustomModel> listDongSP = new ArrayList<>();
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Query query = session.createQuery("SELECT NEW com.mycompany.customModel.DongSPCustomModel "
                    + " (d.IdDongSP, d.maDongSP, d.tenDongSP) "
                    + " FROM com.mycompany.domainModel.DongSP d");
            listDongSP = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDongSP;
    }

}
