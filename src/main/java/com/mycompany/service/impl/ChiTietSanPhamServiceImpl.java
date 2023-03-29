/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.customModel.CTSPCustomThiThu;
import com.mycompany.customModel.ChiTietSPCustomModel;
import com.mycompany.domainModel.ChiTietSP;
import com.mycompany.repository.impl.ChiTietSPRepositoryImpl;
import com.mycompany.util.ThongBao;
import java.util.List;
import com.mycompany.service.ICommon;
import com.mycompany.service.ICommonForCustom;
import javax.swing.JOptionPane;

/**
 *
 * @author Duongntt
 */
public class ChiTietSanPhamServiceImpl implements ICommon<ChiTietSP>, ICommonForCustom<ChiTietSPCustomModel> {

    private ChiTietSPRepositoryImpl chiTietSPrep = new ChiTietSPRepositoryImpl();
    private ThongBao thongBao = new ThongBao();

    @Override
    public List<ChiTietSP> getAll() {
        return chiTietSPrep.getAll();
    }

    @Override
    public String add(ChiTietSP chiTietSP) {
        boolean isCheck = false;
        String sluong = String.valueOf(chiTietSP.getNamBH());
        if (sluong.isEmpty() || sluong.matches("\\s+")) {
            JOptionPane.showMessageDialog(null, "?");
            //isCheck = false;
        }
        if (isCheck) {
            return thongBao.thongBaoKqThem(chiTietSPrep.add(chiTietSP));
        } else {
            return "abv";
        }

    }

    @Override
    public String delete(String idCTSP) {
        return thongBao.thongBaoKqDelete(chiTietSPrep.delete(idCTSP));
    }

    @Override
    public String update(ChiTietSP ctsp, String id) {
        return thongBao.thongBaoKqUpdate(chiTietSPrep.update(ctsp, id));
    }

    @Override
    public List<ChiTietSPCustomModel> getAllCustom() {
        return chiTietSPrep.getAllCustom();
    }

    public List<CTSPCustomThiThu> getAllCustomThiThu() {
        return chiTietSPrep.getAllCustomThiThu();
    }

    public List<CTSPCustomThiThu> getByNamBH(int namBH) {
        return chiTietSPrep.getByNamBH(namBH);
    }
//hàm này là Thành bảo code=)
//    public boolean thanhnvBaoCheck(){
//        
//    }
}
