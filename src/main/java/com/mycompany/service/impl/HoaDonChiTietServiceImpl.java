/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.customModel.HoaDonChiTietCustomModel;
import com.mycompany.domainModel.HoaDonChiTiet;
import com.mycompany.repository.impl.HoaDonChiTietRepository;
import com.mycompany.service.HoaDonChiTietService;
import com.mycompany.util.ThongBao;
import java.util.List;
import com.mycompany.service.ICommon;
import com.mycompany.service.ICommonForCustom;

/**
 *
 * @author Duongntt
 */
public class HoaDonChiTietServiceImpl implements ICommon<HoaDonChiTiet>, HoaDonChiTietService, ICommonForCustom<HoaDonChiTietCustomModel> {

    private HoaDonChiTietRepository hoaDonChiTietRep = new HoaDonChiTietRepository();
    private ThongBao thongBao = new ThongBao();

    @Override
    public List<HoaDonChiTiet> getAll() {
        return hoaDonChiTietRep.getAll();
    }

    @Override
    public String add(HoaDonChiTiet t) {
        return thongBao.thongBaoKqThem(hoaDonChiTietRep.add(t));
    }

    @Override
    public String delete(String idT) {
        //hàm này ko dùng
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String update(HoaDonChiTiet t, String id) {
        //hàm này ko dùng
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String updateHDCT(HoaDonChiTiet hoaDonChiTiet, String idHD, String idCTSP) {
        return thongBao.thongBaoKqUpdate(hoaDonChiTietRep.updateHDCT(hoaDonChiTiet, idHD, idCTSP));
    }

    @Override
    public String deleteHDCT(String idHD, String idCTSP) {
        return thongBao.thongBaoKqDelete(hoaDonChiTietRep.deleteHDCT(idHD, idCTSP));
    }

    @Override
    public List<HoaDonChiTietCustomModel> getAllCustom() {
        return hoaDonChiTietRep.getAllCustom();
    }

}
