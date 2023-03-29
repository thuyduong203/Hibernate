/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.customModel.CTSPCustomThiThu;
import com.mycompany.customModel.ChiTietSPCustomModel;
import com.mycompany.hibernateUtil.HibernateUtil;
import com.mycompany.domainModel.ChiTietSP;
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
public class ChiTietSPRepositoryImpl implements ICommon<ChiTietSP>, ICommonForView<ChiTietSPCustomModel> {

    @Override
    public List<ChiTietSP> getAll() {
        List<ChiTietSP> listCTSP = new ArrayList<>();
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Query query = session.createQuery("FROM ChiTietSP");
            listCTSP = query.getResultList();
        }
        return listCTSP;
    }

    @Override
    public boolean add(ChiTietSP chiTietSP) {
        boolean isAdd = false;
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.save(chiTietSP);
                trans.commit();
                isAdd = true;
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
                isAdd = false;
            }
        } finally {
            return isAdd;
        }
    }

    @Override
    public boolean update(ChiTietSP chiTietSP, String id) {
        int check = 0;
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                Query query = session.createQuery("update ChiTietSP set IdDongSP= :idDongSP, GiaBan= :giaBan, "
                        + "GiaNhap= :giaNhap, IdMauSac= :idMS, MoTa= :moTa, "
                        + "NamBH= :namBH, IdNsx= :idNsx, IdSP= :idSP, SoLuongTon= :idSoLuong where Id= :idCTSP");
                query.setParameter("idDongSP", chiTietSP.getDongSP().getIdDongSP());
                query.setParameter("giaBan", chiTietSP.getGiaBan());
                query.setParameter("giaNhap", chiTietSP.getGiaNhap());
                query.setParameter("idMS", chiTietSP.getMauSac().getIdMauSac());
                query.setParameter("moTa", chiTietSP.getMoTa());
                query.setParameter("namBH", chiTietSP.getNamBH());
                query.setParameter("idNsx", chiTietSP.getNsx().getIdNSX());
                query.setParameter("idSP", chiTietSP.getSanPham().getIdSP());
                query.setParameter("idSoLuong", chiTietSP.getSoLuongTon());
                query.setParameter("idCTSP", id);
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
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                Query query = session.createQuery("DELETE FROM ChiTietSP WHERE Id = :idCTSP");
                query.setParameter("idCTSP", id);
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
    public List<ChiTietSPCustomModel> getAllCustom() {
        List<ChiTietSPCustomModel> listCTSP = new ArrayList<>();
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            //select new com.baeldung.hibernate.pojo.Result(m.name, m.department.name)" 
            // + " from com.baeldung.hibernate.entities.DeptEmployee m
            Query query = session.createQuery("SELECT NEW com.mycompany.customModel.ChiTietSPCustomModel"
                    + "(ctsp.idCTSP, ctsp.sanPham.tenSP, ctsp.nsx.tenNSX, ctsp.mauSac.tenMauSac, "
                    + "ctsp.dongSP.tenDongSP, ctsp.namBH, ctsp.moTa, "
                    + "ctsp.soLuongTon, ctsp.giaNhap, ctsp.giaBan ) "
                    + "FROM com.mycompany.domainModel.ChiTietSP ctsp");
            listCTSP = query.getResultList();
        }
        return listCTSP;
    }

    public static void main(String[] args) {
        List<CTSPCustomThiThu> listTest = new ChiTietSPRepositoryImpl().getByNamBH(1990);
        for (CTSPCustomThiThu chiTietSPCustomModel : listTest) {
            System.out.println(chiTietSPCustomModel.toString());
        }
    }

    public List<CTSPCustomThiThu> getAllCustomThiThu() {
        List<CTSPCustomThiThu> listCTSP = new ArrayList<>();
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Query query = session.createQuery("SELECT NEW com.mycompany.customModel.CTSPCustomThiThu"
                    + "(ctsp.idCTSP,  "
                    + " ctsp.namBH, ctsp.moTa, "
                    + "ctsp.soLuongTon, ctsp.giaNhap) "
                    + "FROM com.mycompany.domainModel.ChiTietSP ctsp");
            listCTSP = query.getResultList();
        }
        return listCTSP;
    }

    public List<CTSPCustomThiThu> getByNamBH(int namBH) {
        List<CTSPCustomThiThu> listCTSP = new ArrayList<>();
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Query query = session.createQuery("SELECT NEW com.mycompany.customModel.CTSPCustomThiThu"
                    + "(ctsp.idCTSP,  "
                    + " ctsp.namBH, ctsp.moTa, "
                    + "ctsp.soLuongTon, ctsp.giaNhap) "
                    + "FROM com.mycompany.domainModel.ChiTietSP ctsp"
                    + " WHERE ctsp.namBH = :namBHDuongntt");
            query.setParameter("namBHDuongntt", namBH);
            listCTSP = query.getResultList();
        }
        return listCTSP;
    }
    
}
