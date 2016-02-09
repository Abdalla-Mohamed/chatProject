/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iti.chat.server.dao;

import com.sun.xml.internal.bind.v2.model.core.ID;
import iti.chat.annotions.Column;
import iti.chat.annotions.Id;
import iti.chat.annotions.Table;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleDriver;

/**
 *
 * @author Abdalla
 * @param <T>
 */
public class GenricDao<T> {

    enum queryKind {

        SelectAll, Select, Insert, Update, Delete
    }

//--------------------------------------------------------------------------
    //<editor-fold defaultstate="collapsed" desc="connection variables">
    private final String DBurl = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
    private final String userName = "chat";
    private final String password = "chat";
    Connection con = null;

//</editor-fold>
    PreparedStatement Stmt = null;
    ResultSet result = null;
    Class<? extends Object> classType;

//--------------------------------------------------------------------------
    StringBuilder query = new StringBuilder();
    StringBuilder colmnNames = new StringBuilder();
    StringBuilder values = new StringBuilder();

    String tableName;
//--------------------------------------------------------------------------

//<editor-fold defaultstate="collapsed" desc="generic methods">
    public GenricDao(Class classType) {

        try {
            DriverManager.registerDriver(new OracleDriver());

        } catch (SQLException ex) {
            Logger.getLogger(GenricDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.classType = classType;
    }

    public boolean insert(T o) {
        boolean createImp = false;
        String insertQuery = createQuery(o, queryKind.Insert);
        System.out.println(insertQuery);
//        try {
//            openConnection();
//
//            closeConnection();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(GenricDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return createImp;
    }

    public ArrayList<T> select(T o) {

        T readImp = null;
        String query = createQuery(o, queryKind.Select);
        System.out.println(query);
//        try {
//            openConnection();
////            readImp = readImp(id);
//            closeConnection();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(GenricDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return null;
    }

    public ArrayList<T> selectAllBy(T o) {
        ArrayList<T> convertResultSet = new ArrayList<>();

        try {
            openConnection();
            String query = createQuery(o, queryKind.SelectAll);
            System.out.println(query);
            PreparedStatement prepareStatement = con.prepareStatement(query);
            ResultSet executeQuery = prepareStatement.executeQuery();
            convertResultSet = convertResultSet(executeQuery);
            closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(GenricDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return convertResultSet;
    }

    public boolean update(T o) {

        String query = createQuery(o, queryKind.Update);
        System.out.println(query);
//     
//        try {
//            openConnection();
////            updateImp(o);
//            closeConnection();
//        } catch (SQLException ex) {
//            Logger.getLogger(GenricDao.class.getName()).log(Level.SEVERE, null, ex);
//        }

        return false;
    }

    public boolean delete(T o) {
        String query = createQuery(o, queryKind.Delete);
        System.out.println(query);

//        
//        try {
//            openConnection();
////            deleteImp(o);
//            closeConnection();
//        } catch (SQLException ex) {
//            Logger.getLogger(GenricDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return false;
    }

    public ArrayList<T> getAll() {
        ArrayList<T> allImp = null;

        String query = createQuery((T) new Object(), queryKind.SelectAll);
        System.out.println(query);

        try {
            openConnection();
//            allImp = getAllImp();
            closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(GenricDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allImp;
    }
////<editor-fold defaultstate="collapsed" desc="excute">

//    public ArrayList<T> excuteQury(String query) {
//        try {
//            openConnection();
//            result = Stmt.executeQuery(query);
//            result.next();
//            System.out.println(result.getString(1));
//            closeConnection();
//        } catch (SQLException ex) {
//            Logger.getLogger(GenricDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return new ArrayList<>();
//    }
//</editor-fold>
    public boolean check(T object) {

        boolean match = false;
        try {
            openConnection();
            String query = createQuery(object, queryKind.SelectAll);
            System.out.println(query);
            PreparedStatement prepareStatement = con.prepareStatement(query);
            ResultSet executeQuery = prepareStatement.executeQuery();
            if (executeQuery.next()) {
                match = true;
            }
            closeConnection();

        } catch (SQLException ex) {
            Logger.getLogger(GenricDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return match;
    }

    public T getById(T object) {

        return null;
    }

//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="connection methods">
    public void openConnection() throws SQLException {
        con = DriverManager.getConnection(DBurl, userName, password);

    }

    public void closeConnection() throws SQLException {
        con.close();
    }
//</editor-fold>

//--------------------------------------------------------------------------
    static public String findClassTableName(Class<?> clazz) {
        String tableName = null;
        try {
            // check if class has correspond table 
            if (clazz.getAnnotation(Table.class) != null) {
                // get table name in database
                tableName = clazz.getAnnotation(Table.class).name();
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return tableName + " ";
    }

    private void createQueryHeader(queryKind kind) {
        query = new StringBuilder();
        switch (kind) {
            case Insert:
                query.append("INSERT INTO ").append(tableName).append(" ( ").append(colmnNames).append(") VALUES ( ").append(values).append(" )");
                break;
            case Update:
                query.append("UPDATE ").append(tableName).append(" set ").append(colmnNames).append(values);
                break;
            case Delete:
                query.append("DELETE FROM ").append(tableName).append(values);
                break;
            case Select:
                query.append("Select ").append(colmnNames).append(" from ").append(tableName).append(values);
                break;
            case SelectAll:
                query.append("Select * FROM ").append(tableName).append(values);
                break;
        }
        colmnNames = new StringBuilder("");
        values = new StringBuilder("");
    }

    private void createQueryNames(queryKind kind, ArrayList<Field> fields, Object object) {
        if (!fields.isEmpty()) {
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldColmName = findFieldColmName(field);
                String fieldValue = findFieldValue(field, object);
                if (fieldValue != null && !fieldValue.equals("null")) {
                    // if not first colmn in quary
                    if (!colmnNames.toString().equals("")) {
                        colmnNames.append(" , ");
                    }
                    colmnNames.append(convertToColmnPart(kind, fieldColmName, fieldValue));

                }
            }

        }
    }

    private void createQueryValues(queryKind kind, ArrayList<Field> fields, T object) {
        if (!fields.isEmpty()) {

            for (Field field : fields) {
                String fieldValue;
                field.setAccessible(true);
                String fieldColmName = findFieldColmName(field);
                if (kind == queryKind.Insert && !field.getAnnotation(Column.class).sequnce().equals("")) {
                    fieldValue = findFieldSeq(field);
                } else {
                    fieldValue = findFieldValue(field, object);
                }

                // append on part of colmen name in quary
                if (fieldValue != null && !fieldValue.equals("null")) {
                    if (!values.toString().equals("")) {
                        values.append(getValueSprator(kind));
                    } else {
                        if (kind != queryKind.Insert) {
                            values.append(" where ");
                        }
                    }
                    values.append(convertToValuePart(kind, fieldColmName, fieldValue));

                }
            }

        }
    }

    private void checkFirstQueryName(queryKind kind, String colmnName) {
        if (colmnNames.equals("")) {

            switch (kind) {
                case Insert:
                    colmnNames.append(" ( ");
                    break;
                case Update:
                    colmnNames.append(" Set ");
                    break;
                case Delete:
                    colmnNames.append("");
                    break;
                case Select:
                    colmnNames.append("");
                    break;
                case SelectAll:
                    colmnNames.append("*");
                    break;
            }
        }

    }

    static public String findFieldColmName(Field field) {
        String ColmName = "";

        field.setAccessible(true);

        if (field != null && field.getAnnotation(Column.class) != null) {
            ColmName = field.getAnnotation(Column.class).name();
        }

        return ColmName;
    }

    static public String findFieldValue(Field field, Object realObj) {
        String ColmnValue = null;
        try {
            field.setAccessible(true);

            if (field.get(realObj) != null && field.getAnnotation(Column.class) != null) {

                if (field.getType() == String.class || field.getType() == char.class) {
                    ColmnValue = "'" + field.get(realObj) + "'";

                } else if (field.getType() == Date.class) {
                    ColmnValue = "" + field.get(realObj);

                } else {
                    ColmnValue = "" + field.get(realObj);

                }

            }
//           //<editor-fold defaultstate="collapsed" desc="old id">
            if (field != null && field.getAnnotation(Id.class) != null) {
//                if (valuesDelete.toString().isEmpty()) {
//                    valuesDelete.append("where ");
//                    valuesUpdate.append("where ");
//                    valuesSelect.append("where ");
//                } else {
//                    valuesDelete.append(" and ");
//                    valuesUpdate.append(" and ");
//                    valuesSelect.append(" and ");
//
//                }
//
//                ColmnValue = field.getAnnotation(Column.class).name();
//                valuesDelete.append(ColmnValue).append(" = ").append(field.get(realObj));
//                valuesUpdate.append(ColmnValue).append(" = ").append(field.get(realObj));
//                valuesSelect.append(ColmnValue).append(" = ").append(field.get(realObj));
//
//                System.out.println(field.getName() + " has colmn in DB called = " + ColmnValue);
//</editor-fold>
            }

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(GenricDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GenricDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ColmnValue;
    }

    static public String findFieldSeq(Field field) {
        field.setAccessible(true);
        return "" + field.getAnnotation(Column.class).sequnce();
    }

    private String convertToColmnPart(queryKind kind, String colName, String value) {
        String combine = "";
        switch (kind) {
            case Insert:
                combine = colName;
                break;
            case Update:
                combine = colName + " = " + value + " ";
                break;
            case Delete:
                break;
            case Select:
                combine = colName;
                break;
            case SelectAll:
                break;
        }
        return combine;
    }

    private String convertToValuePart(queryKind kind, String colName, String value) {
        String combine = "";
        switch (kind) {
            case Insert:
                combine = value;
                break;
            case Update:
                combine = colName + " = " + value + " ";
                break;
            case Delete:
                combine = colName + " = " + value + " ";
                break;
            case Select:
                combine = colName + " = " + value + " ";
                break;
            case SelectAll:
                combine = colName + " = " + value + " ";
                break;
        }
        return combine;
    }

    private String getValueSprator(queryKind kind) {
        String spltr = "";
        switch (kind) {
            case Insert:
                spltr = " , ";
                break;
            case Update:
            case Delete:
            case Select:
            case SelectAll:
                spltr = " and ";
        }
        return spltr;
    }

    private ArrayList<Field> findAnnotedFields(Class<?> classs, Class<? extends Annotation> annotation) {
        ArrayList<Field> annotedFields = new ArrayList<>();
        for (Field field : classs.getDeclaredFields()) {
            if (field.isAnnotationPresent(annotation)) {
                annotedFields.add(field);
            }
        }

        return annotedFields;

    }

    private String createQuery(T o, queryKind kind) {
        query = new StringBuilder("");
        colmnNames = new StringBuilder("");
        values = new StringBuilder("");

        classType = o.getClass();
        tableName = findClassTableName(classType);
        ArrayList<Field> annotedFields = findAnnotedFields(classType, Column.class);
        ArrayList<Field> idFields = findAnnotedFields(classType, Id.class);
        createQueryNames(kind, annotedFields, o);
        if (kind == queryKind.Update) {
            createQueryValues(kind, idFields, o);

        } else {
            createQueryValues(kind, annotedFields, o);

        }
        createQueryHeader(kind);
        return "" + query;
    }

    ArrayList<T> convertResultSet(ResultSet resultSet) {
        ArrayList<T> tList = new ArrayList<>();
        try {
            ArrayList<Field> findAnnotedFields = findAnnotedFields(classType, Column.class);
            while (resultSet.next()) {
                T newInstance = (T) classType.newInstance();
                for (Field field : findAnnotedFields) {
                    Object object = resultSet.getObject(findFieldColmName(field), field.getType());
                    field.set(newInstance, object);
                }
                tList.add(newInstance);

            }
        } catch (InstantiationException ex) {
            Logger.getLogger(GenricDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GenricDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GenricDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tList;
    }
}
