/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.customModel.MauSacCustomModel;
import com.mycompany.domainModel.MauSac;
import com.mycompany.repository.impl.MauSacRepositoryImpl;
import com.mycompany.service.ConvertObject;
import com.mycompany.util.ThongBao;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.mycompany.service.ICommon;
import com.mycompany.service.ICommonForCustom;

/**
 *
 * @author Duongntt
 */
public class MauSacServiceImpl implements ICommon<MauSac>, ICommonForCustom<MauSacCustomModel> {

    private MauSacRepositoryImpl mauSacRep = new MauSacRepositoryImpl();
    private ThongBao thongBao = new ThongBao();

    @Override
    public List<MauSac> getAll() {
        return mauSacRep.getAll();
    }

    @Override
    public String add(MauSac t) {
        return thongBao.thongBaoKqThem(mauSacRep.add(t));
    }

    @Override
    public String delete(String idT) {
        return thongBao.thongBaoKqDelete(mauSacRep.delete(idT));
    }

    @Override
    public String update(MauSac t, String id) {
        return thongBao.thongBaoKqUpdate(mauSacRep.update(t, id));
    }

    @Override
    public List<MauSacCustomModel> getAllCustom() {
        return mauSacRep.getAllCustom();
    }

}
