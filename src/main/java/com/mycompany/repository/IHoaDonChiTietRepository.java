/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.domainModel.HoaDonChiTiet;

/**
 *
 * @author Duongntt
 */
public interface IHoaDonChiTietRepository {

    boolean updateHDCT(HoaDonChiTiet hoaDonChiTiet, String idHoaDon, String idCTSP);

    boolean deleteHDCT(String idHoaDon, String idCTSP);
}
