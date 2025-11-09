/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anngu
 */
public class NewServlet extends HttpServlet {

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
        request.getRequestDispatcher("MyExam.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String arrayString = request.getParameter("a");
            String option = request.getParameter("option");

            String result = "", message = "";

            HttpSession session = request.getSession();

            List<Execution> execList = (List<Execution>) session.getAttribute("execList");
            if (execList == null) {
                execList = new ArrayList<>();
                session.setAttribute("execList", execList);
            }

            if (CheckExist(execList, arrayString, option)) {
                message = "Execution existed!";
                for (Execution item : execList) {
                    if (item.array.equals(arrayString) && item.option.equals(option)) {
                        result = String.valueOf(item.getResult());
                        break; 
                    }
                }
            } else {
                int count = 0;
                String[] parts = arrayString.split(",");
                for (String part : parts) {
                    try {
                        int num = Integer.parseInt(part.trim());
                        if ("Odd".equals(option) && num % 2 != 0) {
                            count++;
                        } else if ("Even".equals(option) && num % 2 == 0) {
                            count++;
                        }
                    } catch (NumberFormatException e) {
                    }
                }

                result = String.valueOf(count);

                execList.add(new Execution(arrayString, option, count));

            }

            request.setAttribute("message", message);
            request.setAttribute("result", result);
            request.setAttribute("aValue", arrayString);
            request.getRequestDispatcher("MyExam.jsp").forward(request, response);
        }
    }

    private boolean CheckExist(List<Execution> execList, String a, String b) {
        for (Execution item : execList) {
            if (item.array.equals(a) && item.option.equals(b)) {
                return true;
            }
        }
        return false;
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
