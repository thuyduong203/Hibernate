/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.customModel.ChucVuCustomModel;
import com.mycompany.hibernateUtil.HibernateUtil;
import com.mycompany.domainModel.ChucVu;
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
public class ChucVuRepositoryImpl implements ICommon<ChucVu>, ICommonForView<ChucVuCustomModel> {

    public static final Session SESSION = HibernateUtil.getSSFactory().openSession();

    @Override
    public List<ChucVu> getAll() {
        List<ChucVu> listCV = new ArrayList<>();
        Query query = SESSION.createQuery("FROM ChucVu");
        listCV = query.getResultList();
        return listCV;
    }

    public static void main(String[] args) {
        List<ChucVu> listCv = new ChucVuRepositoryImpl().getAll();
        for (ChucVu chucVu : listCv) {
            System.out.println(chucVu.toString());
        }
    }

    @Override
    public boolean add(ChucVu chucVu) {
        int check = 0;
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.save(chucVu);
                trans.commit();
                check = 1;
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
            }
        } finally {
            return check > 0;
        }
    }

    @Override
    public boolean update(ChucVu t, String id) {
        int check = 0;
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                Query query = session.createQuery("UPDATE ChucVu SET Ma = :maUpdate, Ten = :tenUpdate WHERE Id = :idUpdate");
                query.setParameter("maUpdate", t.getMaCV());
                query.setParameter("tenUpdate", t.getTenCV());
                query.setParameter("idUpdate", id);
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
        try ( Session sesion = HibernateUtil.getSSFactory().openSession()) {
            Transaction trans = sesion.getTransaction();
            trans.begin();
            try {
                Query query = sesion.createQuery("DELETE FROM ChucVu WHERE Id =:id");
                query.setParameter("id", id);
                check = query.executeUpdate();
                trans.commit();
            } catch (Exception e) {
                trans.rollback();
                e.printStackTrace();
            }
        } finally {
            return check > 0;
        }
    }

    @Override
    public List<ChucVuCustomModel> getAllCustom() {
        List<ChucVuCustomModel> listCV = new ArrayList<>();
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Query query = session.createQuery("SELECT NEW com.mycompany.customModel.ChucVuCustomModel"
                    + " (cv.idCV, cv.maCV, cv.tenCV) "
                    + " FROM com.mycompany.domainModel.ChucVu cv");
            listCV = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCV;
    }

}
