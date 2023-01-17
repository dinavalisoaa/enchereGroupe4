/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointdo;

import pointdo.ClassMap;
import pointdo.Fonction;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author dina
 */
public class Utilitaire {

    public static String retrieveUrlFromRawUrl(HttpServletRequest request) throws Exception {
         String urlMapper="";
        try{StringBuffer name = request.getRequestURL();
        String projectName = request.getContextPath();
        String url = name.toString().split(projectName)[1];
        String method = url.split("-")[0];
      urlMapper  = url.split(".do")[0];}
        catch(Exception e){
            throw  new Exception("Retrieve URL Error");
        }
        return urlMapper;

    }

    public static HashMap<String, ClassMap> getInClassPath(String CLASSES_DIRECTOR) throws Exception {
        HashMap<String, ClassMap> HASHMAP = new HashMap<String, ClassMap>();
try{
        Class[] lesClasses = getClasses(CLASSES_DIRECTOR);
        for (Class classs : lesClasses) {
            if (classs.isAnnotation() == false) {
                Object obj;
                try {
                    obj = classs.getConstructor().newInstance();
                } catch (Exception xe) {
                    throw new Exception("Need Constructor of Classes "+classs.getName()+" "+classs.getSimpleName()+"()");
                }
                Method[] fonctions = classs.getMethods();
                for (Method fonction : fonctions) {
                    Fonction methodMap = fonction.getAnnotation(Fonction.class);
                    if (fonction.getAnnotation(Fonction.class) != null) {
                        ClassMap value = new ClassMap();
//                        System.out.println("util.Utilitaire.getInClassPath()" + classs);
                        value.setClasse(classs);
                        value.setObject(obj);
                        value.setMethod(fonction);
                        HASHMAP.put(methodMap.url(), value);
                    }
                }
//
            }

        }
}
catch(Exception err){
//   throw  new Exception("Getting from CLASSPATH give error");
}
    
    return HASHMAP ;
}

public static Class[] getClasses(String d) throws Exception {
        ArrayList<Class<?>> lis = new ArrayList();
        File dir = new File(d);
        File[] liste = dir.listFiles();
        for (File item : liste) {
            if (item.isDirectory()) {
                {
                    File[] listes = item.listFiles();
                    for (File items : listes) //                    {
                    {
                        if (items.isFile() && items.getName().endsWith(".class")) {
                            String classes = items.getName().split(".class")[0];
                            String ot = item.getName() + "." + classes;
                            lis.add(Class.forName(ot));
//                        lis.add(ot);

                        }
                    }
//                    }
                }
            }

        }
        Class[] cl = new Class[lis.size()];
//               String[]cl=new String[lis.size()];

        for (int i = 0; i < lis.size(); i++) {
            Class<? extends Object> get = lis.get(i);
//            String get = (String)lis.get(i);

            cl[i] = get;
        }
        return cl;

    }
}
