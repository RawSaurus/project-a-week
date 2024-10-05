package com.rawsaurus.currency.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="CurrencyConverterServlet", urlPatterns = "/converter")
public class CurrencyConverterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){

        try {
            request.getRequestDispatcher("WEB-INF/jsp/currency-converter.jsp").forward(request,response);
        } catch (ServletException e) {
            System.out.println(e.getClass()+ "\n" + e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getClass()+ "\n" + e.getMessage());
        }
    }

}
