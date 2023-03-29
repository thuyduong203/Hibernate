/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.customModel.DongSPCustomModel;
import com.mycompany.domainModel.DongSP;
import com.mycompany.repository.impl.DongSPRepositoryImpl;
import com.mycompany.service.ConvertObject;
import com.mycompany.util.ThongBao;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.mycompany.service.ICommon;
import com.mycompany.service.ICommonForCustom;
import org.hibernate.Session;

/**
 *
 * @author Duongntt
 */
public class DongSPServiceImpl implements ICommon<DongSP>, ICommonForCustom<DongSPCustomModel> {

    private DongSPRepositoryImpl dongSPRep = new DongSPRepositoryImpl();
    private ThongBao thongBao = new ThongBao();

    @Override
    public List<DongSP> getAll() {
        return dongSPRep.getAll();
    }

    @Override
    public String add(DongSP t) {
        return thongBao.thongBaoKqThem(dongSPRep.add(t));
    }

    @Override
    public String delete(String idT) {
        return thongBao.thongBaoKqDelete(dongSPRep.delete(idT));
    }

    @Override
    public String update(DongSP t, String id) {
        return thongBao.thongBaoKqUpdate(dongSPRep.update(t, id));
    }

    @Override
    public List<DongSPCustomModel> getAllCustom() {
        return dongSPRep.getAllCustom();
    }

}
