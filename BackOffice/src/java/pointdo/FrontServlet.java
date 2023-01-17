/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pointdo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dina
 */
@WebServlet(name = "FrontServlet", urlPatterns = {"*.do"})
public class FrontServlet extends HttpServlet {

    public ModelView load = new ModelView();

    public void init() {
        try {
//            setHASHMAP();
        } catch (Exception ex) {
            Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setHASHMAP(PrintWriter s) throws Exception {

        try {
            ServletContext con = this.getServletContext();
            HashMap<String, ClassMap> HASHMAP = new HashMap<String, ClassMap>();
            String CLASSES_DIRECTORY = this.getServletContext().getRealPath("") + File.separator + "WEB-INF" + File.separator + "classes";
            HASHMAP = Utilitaire.getInClassPath(CLASSES_DIRECTORY);
            con.setAttribute("MAPPING", HASHMAP);
        } catch (Exception ex) {
            ex.printStackTrace(s);
//           s.flush();
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String boots = "\n"
                    + "<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "    <head>\n"
                    + "        <meta charset=\"UTF-8\">\n"
                    + "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "        <link rel=\"stylesheet\" href=\"assets/css/bootstrap.min.css\">\n"
                    + "        <link rel=\"stylesheet\" href=\"assets/css/styles.min.css\">\n"
                    + "        <link rel=\"stylesheet\" href=\"assets/css/style.css\">\n"
                    + "        <title>Insert Demande</title>\n"
                    + "\n"
                    + "\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "        <div class=\"container\"><div class=\"row\">";
            out.println(boots);
            out.println("<h1 style='color:red'><u>Error</u></h1>");

            /* TODO output your page here. You may use following sample code. */
            ServletContext con = this.getServletContext();
            setHASHMAP(out);
            HashMap<String, ClassMap> HASHMAPS = (HashMap<String, ClassMap>) con.getAttribute("MAPPING");
            String url = "";
            try {
                url = Utilitaire.retrieveUrlFromRawUrl(request);
                if (HASHMAPS.containsKey(url) == true) {
                    Method fonction = HASHMAPS.get(url).getMethod();
                    Object obj = HASHMAPS.get(url).getObject();
//                                        Object obj = HASHMAPS.get(url).getObject();

                    Field[] att = obj.getClass().getDeclaredFields();
                    HttpSession session = request.getSession();
                    Method[] setters = new Method[att.length];
                    Parameter[] args = fonction.getParameters();
                    Object[] parametreDuFonction = new Object[args.length];
                    int indice = 0;
                    for (Parameter p : args) {
                        RequestParams req = p.getAnnotation(RequestParams.class);

                        SessionArgs session_s = p.getAnnotation(SessionArgs.class);

//                      out.println(">>>||"+names+"||<<<");
                        Object o = null;
                        Class parametreType = p.getType();
                        String hisName = parametreType.getSimpleName();
                        Object argument = new Object();
                        if (req != null) {
                            String names = req.value();
                            if ((names != null) == true) {
                                if ((request.getParameter(names) != null)) {

                                    if (parametreType.isArray() == true) {
                                        argument = request.getParameterValues(names);
                                    } else if (hisName.equals(Boolean.class.getSimpleName()) || hisName.equals("boolean")) {
                                        if (request.getParameterValues(names).equals("true")) {
                                            argument = true;
                                        } else {
                                            argument = false;
                                        }
                                    } else if (hisName.equals("String")) {

                                        argument = request.getParameter(names);
                                    } else if (hisName.equals("int") || hisName.equals("Integer")) {
                                        argument = Integer.valueOf(request.getParameter(names));
                                    } else if (hisName.equals("double") || hisName.equals("Double")) {
                                        argument = Double.parseDouble(request.getParameter(names));
                                    } else if (hisName.equals("Date")) {
                                        argument = Date.valueOf(request.getParameter(names));
                                    } else if (hisName.equals(Timestamp.class.getSimpleName())) {
                                        out.println(request.getParameter(names));
                                        argument = Timestamp.valueOf(request.getParameter(names));
                                    } else if (hisName.equals(Time.class.getSimpleName())) {
                                        argument = Time.valueOf(request.getParameter(names) + ":00");
                                    }
                                    parametreDuFonction[indice] = argument;
                                    indice++;
                                } else {
                                    throw new Exception("Parameter name " + names + " must be  declare in function");
                                }

                            }
                        } else if (session_s.value() != null) {
                            String name_session = session_s.value();
                            argument = session.getAttribute(name_session);
                            if (argument != null) {
                                parametreDuFonction[indice] = argument.toString();
                                indice++;
                            }

                        } else {
                            throw new Exception("Parameter name " + " must be  declare in function");
                        }

                    }
                    try {
                        if (request.getParameterMap().isEmpty() == false) {

                            for (int i = 0; i < att.length; i++) {
                                String nomAttribut = att[i].getName();
                                String str = nomAttribut.substring(0, 1).toUpperCase() + nomAttribut.substring(1);
                                setters[i] = obj.getClass().getMethod("set" + str, att[i].getType());
                                if (request.getParameter(nomAttribut) != null) {
                                    Object ret = null;
                                    String hisName = att[i].getType().getSimpleName();
                                    if (hisName.equals("int")) {
                                        ret = Integer.valueOf((request.getParameter(nomAttribut).trim()));
                                    } else if (hisName.equals(String.class.getSimpleName())) {
                                        ret = request.getParameter(nomAttribut);
                                    } else if (hisName.equals("Date")) {
                                        ret = Date.valueOf(request.getParameter(nomAttribut));
                                    } else if (hisName.equals("double")) {
                                        ret = Double.valueOf(request.getParameter(nomAttribut));
                                    } else if (hisName.equals(Timestamp.class.getSimpleName())) {
                                        out.println(request.getParameter(nomAttribut));
                                        ret = Timestamp.valueOf(request.getParameter(nomAttribut));
                                    } else if (hisName.equals(Time.class.getSimpleName())) {
                                        ret = Time.valueOf(request.getParameter(nomAttribut) + ":00");
                                    }
                                    setters[i].invoke(obj, ret);
                                }
                            }
                        }
                        if (parametreDuFonction.length == 0) {
                            load = (ModelView) fonction.invoke(obj);
                        } else {
                            load = (ModelView) fonction.invoke(obj, parametreDuFonction);
                        }
                        HashMap<String, Object> map = null;
                        String pageRedirect = null;
                        String page = null;
                        try {
                            map = load.getAttribute();
                            page = load.getPage();
                            String test = "";
                            if (page != null) {
                                test = page.split(" ")[0];
                            }
                            pageRedirect = load.getRedirect();
                        } catch (NullPointerException ex) {
                            Fonction fonc = fonction.getAnnotation(Fonction.class);
                            throw new Exception(ex.getCause() + "<u><i>Probably ModelView in Class:" + obj.getClass().getName() + ",URL Methods <b>" + fonction.getName() + "." + fonc.url() + "</b> is no data or page of view</i></u>");
                        }
                        if (!load.session.isEmpty()) {
                            if (load.session.isDestroy() == true) {
                                out.println("----");
                                session.removeAttribute(load.session.toDestroy());
                            } else {
                                HashMap<String, Object> vals = load.session.getAttributes();
                                for (Map.Entry<String, Object> entry : vals.entrySet()) {
                                    Object key = entry.getKey();
                                    Object val = entry.getValue();
                                    session.setAttribute(key.toString(), val);
                                }
                            }
                        }
                        try //                        if (page != null || pageRedirect != null || map != null)
                        {
                            if (load.isReDirection() == true) {
                                out.println("" + "==");
                                response.sendRedirect(pageRedirect);
                            } else {
                                RequestDispatcher dispatcher = request.getRequestDispatcher("" + page);
                                for (Map.Entry<String, Object> entry : map.entrySet()) {
                                    Object key = entry.getKey();
                                    Object val = entry.getValue();
                                    out.println(key);
                                    request.setAttribute(key.toString(), val);
                                }
                                dispatcher.forward(request, response);
                            }
                        } catch (Exception s) {
                            out.println(boots);
//                            out.println(response.);
                            out.println("<h1 style='color:red'><u>Error</u></h1>");
                            if (page != null) {
                                out.println("<h3><u><b>May be null in: " + page + "</b></u></h3>");
                            }
                            if (pageRedirect != null) {
                                out.println("<h3><u><b>May be null in: " + pageRedirect + "</b></u></h3>");

                            }
                            s.printStackTrace(out);

                        }
                    } catch (Exception s) {
//                            new Exception(s)
                        StringBuffer name = request.getRequestURL();
                        String projectName = request.getContextPath();
                        String urls = name.toString().split(projectName)[1];
//out.print(urls);
//r
//response.sendRedirect("error.jsp?error="+s.getCause().getMessage());
//out.print("<script><");
//vas.getCause()lt
                        s.printStackTrace(out);

//                        out.println(s.fillInStackTrace());
//                         out.print(" May be null in"+page+".jsp");
                    }
                } else {
                    throw new UrlNotSupportedException(url);
                }
            } catch (Exception ex) {
                out.println(boots);
                ex.printStackTrace(out);
//                out.println(ex.);
//                out.println(ex.notify());
            }
            out.println("</div></body>");
            out.println("</html>");
        } catch (Exception ex) {

//            Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
