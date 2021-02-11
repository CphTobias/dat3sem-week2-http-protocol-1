/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.insession;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "outputheader", value = "/outputheader")
public class OutputHeader extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Enumeration header = request.getHeaderNames();
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table>"
                + "<thead>"
                + "<tr>"
                + "<th>Header</th>"
                + "<th>Value</th>"
                + "</tr>"
                + "</thead"
                + "<tbody>");
            while(header.hasMoreElements()) {
                out.println("<tr>");
                out.println("<td>" + header.nextElement() + "</td>");
                out.println("<td>" + request.getHeader((String) header.nextElement()) + "</td>");
                out.println("</tr>");
            }
            out.println("</tbody>"
                + "</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
