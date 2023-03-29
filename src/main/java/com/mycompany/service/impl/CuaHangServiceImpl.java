/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.customModel.CuaHangCustomModel;
import com.mycompany.domainModel.CuaHang;
import com.mycompany.repository.impl.CuaHangRepositoryImpl;
import com.mycompany.util.ThongBao;
import java.util.List;
import com.mycompany.service.ICommon;
import com.mycompany.service.ICommonForCustom;

/**
 *
 * @author Duongntt
 */
public class CuaHangServiceImpl implements ICommon<CuaHang>, ICommonForCustom<CuaHangCustomModel> {

    private CuaHangRepositoryImpl cuaHangrep = new CuaHangRepositoryImpl();
    private ThongBao thongBao = new ThongBao();

    @Override
    public List<CuaHang> getAll() {
        return cuaHangrep.getAll();
    }

    @Override
    public String add(CuaHang t) {
        return thongBao.thongBaoKqThem(cuaHangrep.add(t));
    }

    @Override
    public String delete(String idT) {
        return thongBao.thongBaoKqDelete(cuaHangrep.delete(idT));
    }

    @Override
    public String update(CuaHang t, String id) {
        return thongBao.thongBaoKqUpdate(cuaHangrep.update(t, id));
    }

    @Override
    public List<CuaHangCustomModel> getAllCustom() {
        return cuaHangrep.getAllCustom();
    }

}
