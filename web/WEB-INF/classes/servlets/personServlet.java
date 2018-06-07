package servlets;

import entity.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("/person")
public class personServlet extends HttpServlet {
    private AtomicInteger counter = new AtomicInteger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("person", getServletContext().getAttribute("person"));
        if (!(getServletContext().getAttribute("person") == null)) {
            req.setAttribute("message", "- МОЛОДЕЦ!");
        }
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/person.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Person person = new Person();
        person.setName((String) req.getParameter("name2Attr"));
        person.setFamily((String) req.getParameter("family2Attr"));
        System.out.println("POST заполнил Person: " + person);
        getServletContext().setAttribute("person", person);
        resp.sendRedirect("/person");
    }

    private List<Person> createPerson() {
        Person person1 = new Person("Виталий", "Ушаков");
        Person person2 = new Person("Ярик", "Зыскунов");
        Person person3 = new Person("Олег", "Гомеза");
        Person person4 = new Person("Владислав", "Береза");
        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        return personList;
    }
}
