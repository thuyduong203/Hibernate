/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.customModel.ChucVuCustomModel;
import com.mycompany.domainModel.ChucVu;
import com.mycompany.repository.impl.ChucVuRepositoryImpl;
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
public class ChucVuServiceImpl implements ICommon<ChucVu>, ICommonForCustom<ChucVuCustomModel> {

    private ChucVuRepositoryImpl chucVuRep = new ChucVuRepositoryImpl();
    private ThongBao thongBao = new ThongBao();

    @Override
    public List<ChucVu> getAll() {
        return chucVuRep.getAll();
    }

    @Override
    public String add(ChucVu chucVu) {
        return thongBao.thongBaoKqThem(chucVuRep.add(chucVu));
    }

    @Override
    public String delete(String idCV) {
        return thongBao.thongBaoKqDelete(chucVuRep.delete(idCV));
    }

    @Override
    public String update(ChucVu chucVu, String id) {
        return thongBao.thongBaoKqUpdate(chucVuRep.update(chucVu, id));
    }

    @Override
    public List<ChucVuCustomModel> getAllCustom() {
        return chucVuRep.getAllCustom();
    }

}
