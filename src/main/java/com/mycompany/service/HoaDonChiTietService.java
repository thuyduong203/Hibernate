/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.domainModel.HoaDonChiTiet;

/**
 *
 * @author Duongntt
 */
public interface HoaDonChiTietService {

    String updateHDCT(HoaDonChiTiet hoaDonChiTiet, String idHD, String idCTSP);

    String deleteHDCT(String idHD, String idCTSP);
}
