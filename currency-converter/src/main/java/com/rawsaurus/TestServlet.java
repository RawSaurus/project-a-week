package com.rawsaurus;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="TestServlet", urlPatterns="/test")
public class TestServlet extends HttpServlet{


    @Override
    protected  void doGet(HttpServletRequest request, HttpServletResponse response){

        try {
            request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String height = request.getParameter("height");
        String weight = request.getParameter("weight");

        try {
            double bmi = calculateBMI(
                    Double.parseDouble(weight),
                    Double.parseDouble(height)
            );

            request.setAttribute("bmi", bmi);
            response.setHeader("Test", "Success");
            response.setHeader("bmi", String.valueOf(bmi));

            request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
        }
    }

    private Double calculateBMI(Double weight, Double height){
        return weight/(height*height);
    }

}
