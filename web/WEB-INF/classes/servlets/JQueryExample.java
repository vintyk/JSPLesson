package servlets;

import com.google.gson.Gson;
import entity.PersonDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/jqueryExample")
public class JQueryExample extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/jQueryExample.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(req.getReader().lines().collect(Collectors.joining("\n")));
        try {
            Gson gson = new Gson();
            String jsonStr = req.getReader().lines().collect(Collectors.joining("\n"));
            PersonDto personDto =
                    gson.fromJson(jsonStr, PersonDto.class);
            System.out.println(personDto);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
