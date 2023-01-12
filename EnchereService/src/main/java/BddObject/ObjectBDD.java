/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change object license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit object template
 */
package BddObject;

//import javax.persistence.Table;
//import Model.Connexion;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
/**
 *
 * @author dina
 */
public class ObjectBDD {

    public void save(Object object,Connection connect) throws Exception {
        try {
            this.insertion(object,connect);
        } catch (Exception cx) {
            throw cx;
        }
    }

    public void insert(Connection connect) throws Exception {
        try {
            save(this,connect);
            System.out.println("MSG:" + "insert OK!!");
        } catch (Exception s) {
            throw s;
        }

    }

    public void delete(String where,Connection connect) throws Exception {
        try {
            delete(this, where,connect);
            System.out.println("MSG:" + "delete OK!!");

        } catch (Exception s) {
            throw s;
        }
    }

    public List select(String sql,Connection connect) throws Exception {
        Object[] retour = new Object[1];
        List lis;
        try {
            lis = findAllBySql(sql, this,connect);

        } catch (Exception s) {
            throw s;
        }
        System.err.println(lis);

        return lis;
    }

    public List select(Connection connect) throws Exception {
        List lis;
        try {
            lis = find(this,connect);
        } catch (Exception s) {
            throw s;
        }
        System.err.println(lis);
        return lis;
    }

    public void update(String where,Connection connect) throws Exception {
        try {
            update(this, where,connect);
            System.out.println("MSG:" + "update OK!!");

        } catch (Exception s) {
            throw s;
        }
    }

    public void update(Object object, String where,Connection connect) {
        try {
            Object objet = object;
            Class c = objet.getClass();
            Table annontation = (Table) c.getAnnotation(Table.class
            );
            String columns = "";
            String values = "";
            String after_where = "";
            HashMap<String, Object> maps = _get_object(object);
            for (Map.Entry<String, Object> entry : maps.entrySet()) {
                String key = entry.getKey();
                Object val = entry.getValue();
                if (!key.toLowerCase().equals(where.toLowerCase())) {
                    columns += "" + key + "= '" + val + "',";
                } else {
                    after_where += " " + key + "= '" + val + "' and";
                }
            }

            String h1 = "update " + annontation.name() + " set " + dropLast(columns) + " where " + dropLastAnd(after_where);
//            Connection connect = new Connexion().getConnection();
            PreparedStatement stmt = connect.prepareStatement(h1);
//            System.err.println(stmt);
            System.out.println("SQL:" + h1);

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public void delete(Object object, String where,Connection connect) {
        try {
            Object objet = object;
            Class c = objet.getClass();
            Table annontation = (Table) c.getAnnotation(Table.class
            );
            String columns = "";
            String values = "";
            String after_where = "";
            HashMap<String, Object> maps = _get_object(object);
            for (Map.Entry<String, Object> entry : maps.entrySet()) {
                String key = entry.getKey();
                Object val = entry.getValue();
//                Field get_fi = object.getClass().getField(key);
//                Id id_an = (Id) c.getAnnotation(Table.class
//                );
                if (key.toLowerCase().equals(where.toLowerCase())) {
                    after_where += "" + key + "= '" + val + "' and";
                }
            }
            String h1 = "delete from " + annontation.name() + " where " + dropLastAnd(after_where);
//            Connection connect = new Connexion().getConnection();
            PreparedStatement stmt = connect.prepareStatement(h1);
            System.out.println("SQL:" + h1);

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public List findAll(Object object,Connection connect) throws Exception {
        Object objet = object;
        List _retour_ = new ArrayList();
//        Connection connect = new Connexion().getConnection();
        try {
            Class c = objet.getClass();
            Table annontation = (Table) c.getAnnotation(Table.class
            );
            String h1 = "select  * from " + annontation.name();//+ " where " + dropLastAnd(after_where);
            System.out.println(h1);
            Field[] fiel = objet.getClass().getDeclaredFields();
            Method[] methody = objet.getClass().getDeclaredMethods();
            Statement stmt = connect.createStatement();
            ResultSet res = stmt.executeQuery(h1);
            ResultSetMetaData resultMeta = res.getMetaData();
            String tokens = "";
            Object nouveau = new Object();
            while (res.next()) {
                nouveau = objet.getClass().newInstance();
                for (int u = 0; u < fiel.length; u++) {
                    tokens = upperFirst(fiel[u].getName());
//                    System.err.println(tokens);
                    Object obs = res.getObject(fiel[u].getName());
                    Method misets = objet.getClass().getMethod("set" + tokens, fiel[u].getType());
                    misets.invoke(nouveau, obs);

                }
                _retour_.add(nouveau);
            }
        } catch (Exception d) {
            d.printStackTrace();
        }
        System.err.println(_retour_.size());
        return _retour_;
    }

    public List findAllBySql(String sql, Object object,Connection connect) throws Exception {
        Object objet = object;
        List _retour_ = new ArrayList();
//        Connection connect = new Connexion().getConnection();
        try {
            Class c = objet.getClass();
            Table annontation = (Table) c.getAnnotation(Table.class
            );
            String h1 = sql;//"select  * from " + annontation.name();//+ " where " + dropLastAnd(after_where);
            System.out.println("SQL:" + h1);
            Field[] fiel = objet.getClass().getDeclaredFields();
            Method[] methody = objet.getClass().getDeclaredMethods();
            Statement stmt = connect.createStatement();
            ResultSet res = stmt.executeQuery(h1);
            ResultSetMetaData resultMeta = res.getMetaData();
            String tokens = "";
            Object nouveau = new Object();
            while (res.next()) {
                nouveau = objet.getClass().newInstance();
                for (int u = 0; u < fiel.length; u++) {
                    tokens = upperFirst(fiel[u].getName());
//                    System.err.println(tokens);
//                    Object obs = res.getObject(fiel[u].getName());
//                    Method misets = objet.getClass().getMethod("set" + tokens, fiel[u].getType());
//                    misets.invoke(nouveau, obs);
                      Ignore ign = fiel[u].getAnnotation(Ignore.class);
                    UnColumn un = fiel[u].getAnnotation(UnColumn.class);

                    if (ign == null && un == null) {
                        if (fiel[u].getType().getSimpleName().equals("String")) {
                            Object ob = res.getString(fiel[u].getName());
                            Method miset = objet.getClass().getMethod("set" + tokens, fiel[u].getType());
                            miset.invoke(nouveau, ob);
                        } else if (fiel[u].getType().getSimpleName().equals("int")) {
                            Object ob = res.getInt(fiel[u].getName());
                            Method miset = objet.getClass().getMethod("set" + tokens, fiel[u].getType());

                            miset.invoke(nouveau, ob);
                        } else if (fiel[u].getType().getSimpleName().equals("Integer")) {
                            Object ob = res.getInt(fiel[u].getName());//objet.getClass().getMethod(attri[u]));
                            Method miset = objet.getClass().getMethod("set" + tokens, fiel[u].getType());
                            miset.invoke(nouveau, ob);
                        } else if (fiel[u].getType().getSimpleName().equals("double")) {
                            Object ob = res.getDouble(fiel[u].getName());//objet.getClass().getMethod(attri[u]));
                            Method miset = objet.getClass().getMethod("set" + tokens, fiel[u].getType());
                            miset.invoke(nouveau, ob);
                        }
                        if (fiel[u].getType().getSimpleName().equals("Double")) {
                            Object ob = res.getDouble(fiel[u].getName());//objet.getClass().getMethod(attri[u]));
                            Method miset = objet.getClass().getMethod("set" + tokens, fiel[u].getType());
                            miset.invoke(nouveau, ob);
                        }

                    }
                }
                _retour_.add(nouveau);
//                b++;
            }
        } catch (Exception d) {
            d.printStackTrace();
        }
        System.err.println(_retour_.size());
        return _retour_;
    }

    public List find(Object object,Connection connect) throws Exception {
        Object objet = object;
        List _retour_ = new ArrayList();
//        Connection connect = new Connexion().getConnection();
        try {
            Class c = objet.getClass();
            Table annontation = (Table) c.getAnnotation(Table.class
            );
            String columns = "";
            String values = "";
            String after_where = "";
            int cpt = 0;
            HashMap<String, Object> maps = _get_object(object);
            for (Map.Entry<String, Object> entry : maps.entrySet()) {
                String key = entry.getKey();
                Object val = entry.getValue();
                if (val.toString().contains("%")) {
                    after_where += " " + key + " like '" + val + "' and";
                } else {
                    after_where += " " + key + "= '" + val + "' and";
                }
                cpt++;
            }
            System.out.println("[[[" + maps.size());
            String h1 = "";
            if (maps.size() > 0) {
                h1 = "select  * from " + annontation.name() + " where " + dropLastAnd(after_where);
            } else {
                h1 = "select  * from " + annontation.name();//+ " where " + dropLastAnd(after_where);}else{

            }
            System.out.println("SQL:" + h1);

//            System.err.println(h1);
            Field[] fiel = objet.getClass().getDeclaredFields();
            Method[] methody = objet.getClass().getDeclaredMethods();
            Statement stmt = connect.createStatement();
            ResultSet res = stmt.executeQuery(h1);
            ResultSetMetaData resultMeta = res.getMetaData();
            int b = 0;
            String tokens = "";
            Object nouveau = new Object();
            while (res.next()) {
                nouveau = objet.getClass().newInstance();
                for (int u = 0; u < fiel.length; u++) {
                    tokens = upperFirst(fiel[u].getName());
//                    System.err.println(tokens);
//                    Object obs = res.getObject(fiel[u].getName());
//                    Method misets = objet.getClass().getMethod("set" + tokens, fiel[u].getType());
//                    misets.invoke(nouveau, obs);
                    Ignore ign = fiel[u].getAnnotation(Ignore.class);
                    UnColumn un = fiel[u].getAnnotation(UnColumn.class);

                    if (ign == null && un == null) {
                        if (fiel[u].getType().getSimpleName().equals("String")) {
                            Object ob = res.getString(fiel[u].getName());
                            Method miset = objet.getClass().getMethod("set" + tokens, fiel[u].getType());
                            miset.invoke(nouveau, ob);
                        } else if (fiel[u].getType().getSimpleName().equals("int")) {
                            Object ob = res.getInt(fiel[u].getName());
                            Method miset = objet.getClass().getMethod("set" + tokens, fiel[u].getType());

                            miset.invoke(nouveau, ob);
                        } else if (fiel[u].getType().getSimpleName().equals("Integer")) {
                            Object ob = res.getInt(fiel[u].getName());//objet.getClass().getMethod(attri[u]));
                            Method miset = objet.getClass().getMethod("set" + tokens, fiel[u].getType());
                            miset.invoke(nouveau, ob);
                        } else if (fiel[u].getType().getSimpleName().equals("double")) {
                            Object ob = res.getDouble(fiel[u].getName());//objet.getClass().getMethod(attri[u]));
                            Method miset = objet.getClass().getMethod("set" + tokens, fiel[u].getType());
                            miset.invoke(nouveau, ob);
                        }
                        if (fiel[u].getType().getSimpleName().equals("Double")) {
                            Object ob = res.getDouble(fiel[u].getName());//objet.getClass().getMethod(attri[u]));
                            Method miset = objet.getClass().getMethod("set" + tokens, fiel[u].getType());
                            miset.invoke(nouveau, ob);
                        }

                    }
                }
                _retour_.add(nouveau);
                b++;
            }
        } catch (Exception d) {
            d.printStackTrace();
        }
//        System.err.println(_retour_);
        return _retour_;
    }

    public String getNameTable(Object object) {
        Class c = object.getClass();
        Table annontation = (Table) c.getAnnotation(Table.class
        );
        return annontation.name();
    }

    public Method[] getMethodByName(Object vaovao, String n) throws Exception {
        String[] attr = getAllFields(vaovao);
        Object object = vaovao.getClass().newInstance();
        Method[] met = new Method[attr.length];
        HashMap<String, Object> hash = new HashMap<>();
        Method[] methodses = object.getClass().getMethods();
        for (int i = 0; i < attr.length; i++) {
            String str = attr[i];
            System.out.println("" + attr[i]);
            String[] vol = str.split(Character.toString(str.toCharArray()[0]));
            String prime = Character.toString(str.toCharArray()[0]).toUpperCase();
            String h = prime.toLowerCase() + str.substring(1, str.toCharArray().length);
            Field atts = object.getClass().getDeclaredField(h);
//            Column col = (Column) atts.getAnnotation(Column.class
//            );
            {
                String get = n + upperFirst(str);
                String set = "set" + upperFirst(str);
                Method methode_set = object.getClass().getMethod(set, atts.getType());
                Method methode_get = object.getClass().getMethod(get);
//                System.out.println(":" + atts.getType().getSimpleName());
                if (methode_get.invoke(object) != null) {
                    hash.put(str, methode_get.invoke(object));
                }
//                System.out.println("_"+methode_get.invoke(object));
            }
        }
        return met;
    }
//    
//public  HashMap<HashMap<String, Object>,Boolean> _get_hap(String where,Object object) throws Exception {
//        String[] attr = getAllFields(object);
//        Method[] met = new Method[attr.length];
//       HashMap<HashMap<String, Object>,Boolean>retour=new HashMap<>();
//        Method[] methodses = object.getClass().getMethods();
//        for (int i = 0; i < attr.length; i++) {
//            String str = attr[i];
//              HashMap<String, Object>hash=new HashMap<>();
////            System.out.println("" + attr[i]);
//            String[] vol = str.split(Character.toString(str.toCharArray()[0]));
//            String prime = Character.toString(str.toCharArray()[0]).toUpperCase();
//            String h = prime.toLowerCase() + str.substring(1, str.toCharArray().length);
//            Field atts = object.getClass().getDeclaredField(h);
//            Column col = (Column) atts.getAnnotation(Column.class
//            );
//            {
//                String get = "get" + upperFirst(col.name());
////                System.out.println("DAObject.GenericDao._get()"+col.name());
//                String set = "set" + upperFirst(col.name());
//                Method methode_set = object.getClass().getMethod(set, atts.getType());
//                Method methode_get = object.getClass().getMethod(get);
////                System.out.println(":" + atts.getType().getSimpleName());
//                if(methode_get.invoke(object)!=null){
//                    hash.put(col.name(),methode_get.invoke(object));
//                    retour.put(hash, false);
//                }
//                System.out.println(col.name()+","+methode_get.invoke(object));
////                System.out.println("_"+methode_get.invoke(object));
//            }
//        }
//        return re;
//    }

    public Field _get_field_best(String str, Object object) throws Exception {
        String[] vol = str.split(Character.toString(str.toCharArray()[0]));
        String prime = Character.toString(str.toCharArray()[0]).toUpperCase();
        String h = prime.toLowerCase() + str.substring(1, str.toCharArray().length);
        Field atts = object.getClass().getDeclaredField(h);
        return atts;
    }

    public HashMap<String, Object> _get_object(Object object) throws Exception {
        String[] attr = getAllFields(object);
//        Object object=vaovao.getClass().new/Instance();
        Method[] met = new Method[attr.length];
        HashMap<String, Object> hash = new HashMap<>();
        Method[] methodses = object.getClass().getMethods();
        for (int i = 0; i < attr.length; i++) {
            String str = attr[i];
            Field atts = _get_field_best(str, object);
//            Column col = (Column) atts.getAnnotation(Column.class);
            Ignore att_f = (Ignore) atts.getAnnotation(Ignore.class);
            UnColumn ats = (UnColumn) atts.getAnnotation(UnColumn.class);
            if (att_f == null && ats == null) {
                {
                    String get = "get" + upperFirst(str);
                    Method methode_get = object.getClass().getMethod(get);
//                System.out.println("DAObject.GenericDao._get()"+col.name());
                    String set = "set" + upperFirst(str);
                    Method methode_set = object.getClass().getMethod(set, atts.getType());
                    if (methode_get.invoke(object) != null && !methode_get.invoke(object).equals(-1) && !methode_get.invoke(object).equals(-1.0)) {
                        hash.put(str, methode_get.invoke(object));
                    }
//                    System.out.println("<>" + str + "," + methode_get.invoke(object));
                }
            }
        }
        return hash;
    }

    public String[] getAllFields(Object object) {
        Field[] fd = object.getClass().getDeclaredFields();
        String[] str = new String[fd.length];
        String[] str2 = new String[fd.length];
        int ii = 0;
        for (int i = 0; i < fd.length; i++) {
            {

                str[ii] = fd[i].getName();

                String[] vol = str[ii].split(Character.toString(str[ii].toCharArray()[0]));
                String prime = Character.toString(str[ii].toCharArray()[0]).toUpperCase();
                str2[ii] = prime + str[ii].substring(1, str[ii].toCharArray().length);
//                 System.err.println(""+str2[ii]);
                ii++;
            }
        }
        return str2;
    }

    public static String upperFirst(String str) {
        String[] vol = str.split(Character.toString(str.toCharArray()[0]));
        String prime = Character.toString(str.toCharArray()[0]).toUpperCase();
//        System.out.println("__" + prime);
        String h = prime + str.substring(1, str.toCharArray().length);
        return h;
    }

    public static String lowerFirst(String str) {
        String[] vol = str.split(Character.toString(str.toCharArray()[0]));
        String prime = Character.toString(str.toCharArray()[0]).toLowerCase();
//        System.out.println("__" + prime);
        String h = prime + str.substring(1, str.toCharArray().length);
        return h;
    }

    public HashMap<Method, HashMap<String, Object>> invokes(Object object) {

        return null;
    }

    public Class getType(String key, Object iza) throws Exception {
        String get = "get" + upperFirst(key);
        Method methode_get = iza.getClass().getMethod(get);

        return methode_get.getReturnType();
    }

    public String dropLast(String taken) {
        char[] che = taken.toCharArray();

        String ret = (String) taken.subSequence(0, che.length - 1);
        return ret;
    }

    public String dropLastAnd(String taken) {
        char[] che = taken.toCharArray();

        String ret = (String) taken.subSequence(0, che.length - 3);
        return ret;
    }

    public void insertion(Object object,Connection connect) {
        try {
            Object objet = object;
            Class c = objet.getClass();
            Table annontation = (Table) c.getAnnotation(Table.class
            );
            String columns = "";
            String values = "";
            HashMap<String, Object> maps = _get_object(object);
            for (Map.Entry<String, Object> entry : maps.entrySet()) {
                String key = entry.getKey();
                columns += "" + key + ",";
                Object val = entry.getValue();
                values += "'" + val + "',";
//                System.err.println(key + " !! " + val);
            }
            if (maps.size() == 0) {
                throw new Exception("Not field are setted");
            }
            String h1 = "insert into " + annontation.name() + "(" + dropLast(columns) + ")" + "values(" + dropLast(values) + ")";
//            Connection connect = new Connexion().getConnection();
//            Statement stmt = connect.prepareStatement(h1);
            Statement stmt = connect.createStatement();
//            stmt.executeUpdate("SET DATEFORMAT ymd ");
            stmt.executeUpdate(h1);
            System.out.println("SQL:"+h1);
//            for (Map.Entry<String, Object> entry : maps.entrySet()) {
//                String key = entry.getKey();
//                Object val = entry.getValue();
//                String get = "get" + upperFirst(key);
//                Method methode_get = object.getClass().getMethod(get);
//                stmt.setObject(index, val);
//                index++;
//            }
//            System.err.println(stmt);
//            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
//
//    public static void run(String st) throws Exception {
//        int c = 0;
//        System.out.println("SQL:=>" + st);
//        Connection connect = null;
//        Statement stmt = null;
//        try {
////            connect = new Connexion().getConnection();
//            stmt = connect.createStatement();
////            stmt.executeUpdate("SET DATEFORMAT ymd ");
//            stmt.executeUpdate(st);
//        } catch (Exception ex) {
//            throw ex;
//        } finally {
//            stmt.close();
//            connect.close();
//        }
//
//    }
}
