/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.customModel.NhanVienCustomModel;
import com.mycompany.customModel.NhanVienThiThu;
import com.mycompany.hibernateUtil.HibernateUtil;
import com.mycompany.domainModel.NhanVien;
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
public class NhanVienRepositoryImpl implements ICommon<NhanVien>, ICommonForView<NhanVienCustomModel> {

    @Override
    public List<NhanVien> getAll() {
        List<NhanVien> listNV = new ArrayList<>();
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Query query = session.createQuery("FROM NhanVien");
            listNV = query.getResultList();
        }
        return listNV;
    }
//    @Override
//    public KhachHang getOne(String ma) {
//        String hql = fromTable + "WHERE ma = :ma and trangThai = 0";
//        Query query = session.createQuery(hql);
//        KhachHang kh = (KhachHang) query.getSingleResult();
//        return kh;
//    }
    @Override
    public boolean add(NhanVien nhanVien) {
        boolean isAdd = false;
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.save(nhanVien);
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
    public boolean update(NhanVien nhanVien, String id) {
        int check = 0;
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                Query query = session.createQuery("UPDATE NhanVien\n"
                        + " SET \n"
                        + "      Ma = :maNV\n"
                        + "      ,Ten = :tenNV \n"
                        + "      ,TenDem = :tenDem \n"
                        + "      ,Ho = :hoNV \n"
                        + "      ,GioiTinh = :gioiTinh \n"
                        + "      ,NgaySinh = :ngaySinh \n"
                        + "      ,DiaChi = :diaChi \n"
                        + "      ,Sdt = :sdt \n"
                        + "      ,MatKhau = :matKhau \n"
                        + "      ,IdCH = :idCH \n"
                        + "      ,IdCV = :idCV\n"
                        + "      ,IdGuiBC = :idGuiBC\n"
                        + "      ,TrangThai = :trangThai\n"
                        + " WHERE Id = :idNV");
                query.setParameter("maNV", nhanVien.getMaNV());
                query.setParameter("tenNV", nhanVien.getTenNV());
                query.setParameter("tenDem", nhanVien.getTenDemNV());
                query.setParameter("hoNV", nhanVien.getHoNV());
                query.setParameter("gioiTinh", nhanVien.getGioiTinhNV());
                query.setParameter("ngaySinh", nhanVien.getNgaySinhNV());
                query.setParameter("diaChi", nhanVien.getDiaChiNV());
                query.setParameter("sdt", nhanVien.getSdtNV());
                query.setParameter("matKhau", nhanVien.getMatKhauNV());
                query.setParameter("idCH", nhanVien.getCuaHang().getIdCH());
                query.setParameter("idCV", nhanVien.getChucVu().getIdCV());
                query.setParameter("idGuiBC", nhanVien.getNguoiGuiBC().getIdNV());
                query.setParameter("trangThai", nhanVien.getTrangThai());
                query.setParameter("idNV", id);
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
                Query query = session.createQuery("DELETE FROM NhanVien WHERE Id = :idNV");
                query.setParameter("idNV", id);
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

    public static void main(String[] args) {
        List<NhanVienCustomModel> listNV = new NhanVienRepositoryImpl().getAllCustom();
        for (NhanVienCustomModel nhanVien : listNV) {
            System.out.println(nhanVien.toString());
        }
    }

    @Override
    public List<NhanVienCustomModel> getAllCustom() {
        List<NhanVienCustomModel> listNV = new ArrayList<>();
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            String hql = "SELECT NEW com.mycompany.customModel.NhanVienCustomModel "
                    + "(nv2.idNV, nv2.maNV, nv2.tenNV, nv2.tenDemNV, "
                    + "nv2.hoNV, nv2.gioiTinhNV,"
                    + " nv2.sdtNV, nv2.matKhauNV, nv2.cuaHang.TenCH,"
                    + " nv2.chucVu.tenCV, nv2.nguoiGuiBC.maNV, "
                    + "nv2.trangThai, nv2.ngaySinhNV, nv2.diaChiNV) "
                    + " FROM com.mycompany.domainModel.NhanVien nv2";
            Query query = session.createQuery(hql);
            listNV = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNV;
    }

    public List<NhanVienThiThu> getAllCustomThiThu() {
        List<NhanVienThiThu> listNV = new ArrayList<>();
        String hql = "SELECT NEW com.mycompany.customModel.NhanVienThiThu "
                + " (nv.maNV, nv.tenNV, nv.diaChiNV, nv.hoNV)"
                + " FROM NhanVien nv";
        try ( Session session = HibernateUtil.getSSFactory().openSession()) {
            Query query = session.createQuery(hql);
            listNV = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNV;
    }
}
