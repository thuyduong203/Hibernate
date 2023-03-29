/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.customModel.HoaDonCustomModel;
import com.mycompany.domainModel.HoaDon;
import com.mycompany.repository.impl.HoaDonRepository;
import com.mycompany.util.ThongBao;
import java.util.List;
import com.mycompany.service.ICommon;
import com.mycompany.service.ICommonForCustom;

/**
 *
 * @author Duongntt
 */
public class HoaDonServiceImpl implements ICommon<HoaDon>, ICommonForCustom<HoaDonCustomModel> {

    private HoaDonRepository hoaDonRep = new HoaDonRepository();
    private ThongBao thongBao = new ThongBao();

    @Override
    public List<HoaDon> getAll() {
        return hoaDonRep.getAll();
    }

    @Override
    public String add(HoaDon t) {
        return thongBao.thongBaoKqThem(hoaDonRep.add(t));
    }

    @Override
    public String delete(String idT) {
        return thongBao.thongBaoKqDelete(hoaDonRep.delete(idT));
    }

    @Override
    public String update(HoaDon t, String id) {
        return thongBao.thongBaoKqUpdate(hoaDonRep.update(t, id));
    }

    @Override
    public List<HoaDonCustomModel> getAllCustom() {
        return hoaDonRep.getAllCustom();
    }

}
