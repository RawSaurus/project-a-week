package com.rawsaurus.currency.controller;

import com.rawsaurus.currency.service.CurrencyService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name="CurrencyConverterServlet", urlPatterns = "/converter")
public class CurrencyConverterServlet extends HttpServlet {

    private final CurrencyService currencyService = new CurrencyService();

//    CurrencyConverterServlet(CurrencyService currencyService) throws ServletException {
//        this.currencyService = currencyService;
//
//        init();
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

            request.getRequestDispatcher("WEB-INF/jsp/currency-converter.jsp").forward(request,response);
        System.out.println("heno");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        HttpSession session = request.getSession();

        String currencyFrom = "USD";
        String currencyTo = "EUR";
        String value = (String)request.getAttribute("value1");
        System.out.println(value);
        request.setAttribute("value2", currencyService.convertValue(currencyFrom,currencyTo,value));

//        session.setAttribute("value1", "s");
//        String s = (String)session.getAttribute("name");

        request.getRequestDispatcher("WEB-INF/jsp/currency-converter.jsp").forward(request,response);
    }
//
//    private void processRequest(HttpServletRequest request, HttpServletResponse response){
//
//    }

}
