/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author ADMIN
 */
public interface Manageable {

    void add();

    void update(String ID);

    void delete(String ID);

}
