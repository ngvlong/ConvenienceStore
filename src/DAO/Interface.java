/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author NAME
 */
import java.util.ArrayList;

/**
 *
 * @author robot
 */
public interface Interface<T> {
    public int insert(T t);
    
    public int update(T t);
    
    public int delete(String t);
    
    public ArrayList<T> selectAll(String t);
    
    public T selectById(String t);
    
    int getAutoIncrement();
    
    
}

