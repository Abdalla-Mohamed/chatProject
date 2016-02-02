/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.server.dao;

import java.util.ArrayList;

/**
 *
 * @author Abdalla
 * @param <T>
 */
abstract public class GenricDao<T> {

    private Class<T> type;

    public GenricDao(Class<T> type) {
        this.type = type;
    }

    public int create(T o) {
        return createImp(o);
    }

    public T read(int id) {
        return readImp(id);
    }

    public void update(T o) {
        updateImp(o);
    }

    public void delete(T o) {
        deleteImp(o);
    }

    public ArrayList<T> getAll() {
        return getAllImp();
    }

    public ArrayList<T> excuteQury(String query) {
        return null;
    }

    abstract public int createImp(T o);

    abstract public T readImp(int id);

    abstract public void updateImp(T o);

    abstract public void deleteImp(T o);

    abstract public ArrayList<T> getAllImp();

}
