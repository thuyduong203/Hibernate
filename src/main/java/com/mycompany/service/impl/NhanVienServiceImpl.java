/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.customModel.NhanVienCustomModel;
import com.mycompany.customModel.NhanVienThiThu;
import com.mycompany.domainModel.NhanVien;
import com.mycompany.repository.impl.NhanVienRepositoryImpl;
import com.mycompany.util.ThongBao;
import java.util.List;
import com.mycompany.service.ICommon;
import com.mycompany.service.ICommonForCustom;

/**
 *
 * @author Duongntt
 */
public class NhanVienServiceImpl implements ICommon<NhanVien>, ICommonForCustom<NhanVienCustomModel> {

    private NhanVienRepositoryImpl nhanVienRep = new NhanVienRepositoryImpl();
    private ThongBao ThongBao = new ThongBao();

    @Override
    public List<NhanVien> getAll() {
        return nhanVienRep.getAll();
    }

    @Override
    public String add(NhanVien t) {
        return ThongBao.thongBaoKqThem(nhanVienRep.add(t));
    }

    @Override
    public String delete(String idT) {
        return ThongBao.thongBaoKqDelete(nhanVienRep.delete(idT));
    }

    @Override
    public String update(NhanVien t, String id) {
        return ThongBao.thongBaoKqUpdate(nhanVienRep.update(t, id));
    }

    @Override
    public List<NhanVienCustomModel> getAllCustom() {
        return nhanVienRep.getAllCustom();
    }

     public List<NhanVienThiThu> getAllCustomThiThu() {
        return nhanVienRep.getAllCustomThiThu();
    }

}
