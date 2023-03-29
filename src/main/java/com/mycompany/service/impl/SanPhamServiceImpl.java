/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.domainModel.SanPham;
import com.mycompany.repository.impl.SanPhamRepositoryImpl;
import com.mycompany.util.ThongBao;
import java.util.List;
import com.mycompany.service.ICommon;

/**
 *
 * @author Duongntt
 */
public class SanPhamServiceImpl implements ICommon<SanPham> {

    private SanPhamRepositoryImpl sanPhamRep = new SanPhamRepositoryImpl();
    private ThongBao thongBao = new ThongBao();

    @Override
    public List<SanPham> getAll() {
        return sanPhamRep.getAll();
    }

    @Override
    public String add(SanPham t) {
        return thongBao.thongBaoKqThem(sanPhamRep.add(t));
    }

    @Override
    public String delete(String idT) {
        return thongBao.thongBaoKqDelete(sanPhamRep.delete(idT));
    }

    @Override
    public String update(SanPham t, String id) {
        return thongBao.thongBaoKqUpdate(sanPhamRep.update(t, id));
    }

}
