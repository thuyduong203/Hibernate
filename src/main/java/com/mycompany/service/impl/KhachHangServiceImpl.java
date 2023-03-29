/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.customModel.KhachHangCustomModel;
import com.mycompany.domainModel.KhachHang;
import com.mycompany.repository.impl.KhachHangRepository;
import com.mycompany.util.ThongBao;
import java.util.List;
import com.mycompany.service.ICommon;
import com.mycompany.service.ICommonForCustom;

/**
 *
 * @author Duongntt
 */
public class KhachHangServiceImpl implements ICommon<KhachHang>, ICommonForCustom<KhachHangCustomModel> {

    private KhachHangRepository khachHangRep = new KhachHangRepository();
    private ThongBao thongBao = new ThongBao();

    @Override
    public List<KhachHang> getAll() {
        return khachHangRep.getAll();
    }

    @Override
    public String add(KhachHang t) {
        return thongBao.thongBaoKqThem(khachHangRep.add(t));
    }

    @Override
    public String delete(String idT) {
        return thongBao.thongBaoKqDelete(khachHangRep.delete(idT));
    }

    @Override
    public String update(KhachHang t, String id) {
        return thongBao.thongBaoKqUpdate(khachHangRep.update(t, id));
    }

    @Override
    public List<KhachHangCustomModel> getAllCustom() {
        return khachHangRep.getAllCustom();
    }

}
