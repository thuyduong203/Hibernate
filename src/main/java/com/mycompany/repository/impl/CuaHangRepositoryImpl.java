/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.customModel.CuaHangCustomModel;
import com.mycompany.hibernateUtil.HibernateUtil;
import com.mycompany.domainModel.CuaHang;
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
public class CuaHangRepositoryImpl implements ICommon<CuaHang>, ICommonForView<CuaHangCustomModel> {

    @Override
    public List<CuaHang> getAll() {
        List<CuaHang> listCH = new ArrayList<>();
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Query query = session.createQuery("FROM CuaHang");
            listCH = query.getResultList();
        }
        return listCH;
    }

    @Override
    public boolean add(CuaHang cuaHang) {
        boolean isAdd = false;
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.save(cuaHang);
                trans.commit();
                isAdd = true;
            } catch (Exception e) {
                trans.rollback();
                e.printStackTrace();
            }
        } finally {
            return isAdd;
        }
    }

    @Override
    public boolean update(CuaHang cuaHang, String id) {
        int check = 0;
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                Query query = session.createQuery("UPDATE CuaHang\n"
                        + "   SET \n"
                        + "      Ma = :maCH \n"
                        + "      ,Ten = :tenCH \n"
                        + "      ,DiaChi = :diaChiCH \n"
                        + "      ,ThanhPho = :thanhPhoCH\n"
                        + "      ,QuocGia = :quocGiaCH\n"
                        + " WHERE Id = :id");
                query.setParameter("maCH", cuaHang.getMaCH());
                query.setParameter("tenCH", cuaHang.getTenCH());
                query.setParameter("diaChiCH", cuaHang.getDiaChi());
                query.setParameter("thanhPhoCH", cuaHang.getThanhPho());
                query.setParameter("quocGiaCH", cuaHang.getQuocGia());
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
    public boolean delete(String idCH) {
        int check = 0;
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                Query query = session.createQuery("DELETE FROM CuaHang WHERE Id = :idCH");
                query.setParameter("idCH", idCH);
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
    public List<CuaHangCustomModel> getAllCustom() {
        List<CuaHangCustomModel> listCH = new ArrayList<>();
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Query query = session.createQuery("SELECT NEW com.mycompany.customModel.CuaHangCustomModel"
                    + " (ch.idCH, ch.maCH, ch.TenCH, ch.diaChi, ch.ThanhPho, ch.QuocGia) "
                    + " FROM com.mycompany.domainModel.CuaHang ch");
            listCH = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCH;
    }

}
