/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.service;

import java.util.List;

/**
 *
 * @author Duongntt
 */
public interface ICommon<T> {

    List<T> getAll();

    String add(T t);

    String delete(String idT);

    String update(T t, String id);

    //List<T> getAllCustom();
}
