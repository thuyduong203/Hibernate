/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.customModel.HoaDonCustomModel;
import com.mycompany.hibernateUtil.HibernateUtil;
import com.mycompany.domainModel.HoaDon;
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
public class HoaDonRepository implements ICommon<HoaDon>, ICommonForView<HoaDonCustomModel> {

    @Override
    public List<HoaDon> getAll() {
        List<HoaDon> listHD = new ArrayList<>();
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Query query = session.createQuery("FROM HoaDon");
            listHD = query.getResultList();
        }
        return listHD;
    }

    @Override
    public boolean add(HoaDon t) {
        boolean isAdd = false;
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                session.save(t);
                transaction.commit();
                isAdd = true;
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
            }
        } finally {
            return isAdd;
        }
    }

    @Override
    public boolean update(HoaDon hoaDon, String id) {
        int check = 0;
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                Query query = session.createQuery(" UPDATE HoaDon SET IdKH = :idKH, IdNV = :idNV,"
                        + " Ma = :maHD, NgayTao = :ngayTao,\n"
                        + " NgayThanhToan = :ngayTT, NgayShip = :ngayShip, "
                        + " NgayNhan = :ngayNhan, TinhTrang = :tinhTrang, TenNguoiNhan = :tenNN,\n"
                        + " DiaChi = :diaChi, Sdt = :sdt\n"
                        + " WHERE Id = :idHD");
                query.setParameter("idKH", hoaDon.getKhachHang().getIdKH());
                query.setParameter("idNV", hoaDon.getNhanVien().getIdNV());
                query.setParameter("maHD", hoaDon.getMaHoaDon());
                query.setParameter("ngayTao", hoaDon.getNgayTao());
                query.setParameter("ngayTT", hoaDon.getNgayThanhToan());
                query.setParameter("ngayShip", hoaDon.getNgayShip());
                query.setParameter("ngayNhan", hoaDon.getNgayNhan());
                query.setParameter("tinhTrang", hoaDon.getTinhTrangHD());
                query.setParameter("tenNN", hoaDon.getTenNguoiNhan());
                query.setParameter("diaChi", hoaDon.getDiaChiNguoiNhan());
                query.setParameter("sdt", hoaDon.getSdtNguoiNhan());
                query.setParameter("idHD", id);
                check = query.executeUpdate();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
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
                Query query = session.createQuery("DELETE FROM HoaDon WHERE Id = :idHD");
                query.setParameter("idHD", id);
                check = query.executeUpdate();
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();;
                e.printStackTrace();
            }
        } finally {
            return check > 0;
        }
    }

    public static void main(String[] args) {
        List<HoaDonCustomModel> tesst = new HoaDonRepository().getAllCustom();
        for (HoaDonCustomModel hoaDonCustomModel : tesst) {
            System.out.println(hoaDonCustomModel);
        }
    }

//    @Override
//    public List<HoaDonCustomModel> getAllCustom() {
//        List<HoaDonCustomModel> listHD = new ArrayList<>();
//        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
//            Query query = session.createQuery("SELECT NEW com.mycompany.customModel.HoaDonCustomModel "
//                    + " (hd.idHoaDon, hd.khachHang.idKH, hd.nhanVien.idNV, hd.maHoaDon, hd.ngayTao, "
//                    + " hd.ngayThanhToan, hd.ngayShip, hd.ngayNhan, hd.tenNguoiNhan, hd.diaChiNguoiNhan "
//                    + " hd.sdtNguoiNhan, hd.tinhTrangHD) "
//                    + " FROM com.mycompany.domainModel.HoaDon hd");
//            listHD = query.getResultList();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return listHD;
//    }
//    @Override
//    public List<HoaDonCustomModel> getAllCustom() {
//        List<HoaDonCustomModel> listHD = new ArrayList<>();
//        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
//            String hql = ("SELECT NEW com.mycompany.customModel.HoaDonCustomModel "
//                    + " (hd.idHoaDon, kh.idKH, nv.idNV, hd.maHoaDon, hd.ngayTao, "
//                    + " hd.ngayThanhToan, hd.ngayShip, hd.ngayNhan, hd.tenNguoiNhan, hd.diaChiNguoiNhan "
//                    + " hd.sdtNguoiNhan, hd.tinhTrangHD) "
//                    + " FROM com.mycompany.domainModel.HoaDon hd "
//                    + " INNER JOIN KhachHang kh ON hd.khachHang = kh.idKH "
//                    + " INNER JOIN NhanVien nv ON hd.nhanVien = nv.idNV");
//            Query query = session.createQuery(hql);
//            listHD = query.getResultList();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return listHD;
//    }
    @Override
    public List<HoaDonCustomModel> getAllCustom() {
        List<HoaDonCustomModel> listHD = new ArrayList<>();
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            String hql = ("SELECT NEW com.mycompany.customModel.HoaDonCustomModel "
                    + " (hd.idHoaDon, hd.khachHang.idKH, hd.nhanVien.idNV,"
                    + " hd.maHoaDon, hd.ngayTao, "
                    + " hd.ngayThanhToan,hd.ngayShip, hd.ngayNhan,  hd.tenNguoiNhan, "
                    + "hd.diaChiNguoiNhan, hd.sdtNguoiNhan, hd.tinhTrangHD) "
                    + " FROM com.mycompany.domainModel.HoaDon hd ");
            Query query = session.createQuery(hql);
            listHD = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
    }

}
