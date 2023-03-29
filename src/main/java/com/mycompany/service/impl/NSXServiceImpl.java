/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.customModel.NSXCustomModel;
import com.mycompany.domainModel.NSX;
import com.mycompany.repository.impl.NSXRepositoryImpl;
import com.mycompany.util.ThongBao;
import java.util.List;
import com.mycompany.service.ICommon;
import com.mycompany.service.ICommonForCustom;

/**
 *
 * @author Duongntt
 */
public class NSXServiceImpl implements ICommon<NSX>, ICommonForCustom<NSXCustomModel> {

    private NSXRepositoryImpl nsxRep = new NSXRepositoryImpl();
    private ThongBao thongBao = new ThongBao();

    @Override
    public List<NSX> getAll() {
        return nsxRep.getAll();
    }

    @Override
    public String add(NSX t) {
        return thongBao.thongBaoKqThem(nsxRep.add(t));
    }

    @Override
    public String delete(String idT) {
        return thongBao.thongBaoKqDelete(nsxRep.delete(idT));
    }

    @Override
    public String update(NSX t, String id) {
        return thongBao.thongBaoKqUpdate(nsxRep.update(t, id));
    }

    @Override
    public List<NSXCustomModel> getAllCustom() {
        return nsxRep.getAllCustom();
    }

}
