/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.customModel.ChiTietSPCustomModel;
import java.util.List;

/**
 *
 * @author Duongntt
 */
public interface ICommonForCustom <T> {

    List<T> getAllCustom();
}
