package servlets;

import entity.Hero;
import entity.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("/person")
public class personServlet extends HttpServlet {
    private AtomicInteger counter = new AtomicInteger();

    @Override
    protected void doGet(HttpServletRequest myReq, HttpServletResponse myResp) throws IOException, ServletException {
        myReq.setAttribute("persons", createPersons());
        myReq.setAttribute("person", getServletContext().getAttribute("person"));
        myReq.setAttribute("mega", "это переменная мега");
        if (!(getServletContext().getAttribute("person") == null)) {
            myReq.setAttribute("message", "- МОЛОДЕЦ!");
        }
        myReq.setAttribute("myBestHeros", getHeroes());

        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/person.jsp")
                .forward(myReq, myResp);
    }

    private List<Hero> getHeroes() {
        Hero hero = new Hero("Aragorn", 33);
        Hero hero1 = new Hero("Aragory", 35);
        Hero hero2 = new Hero("Aragoryyyn", 37);
        Hero hero3 = new Hero("AragorUuiin", 93);
        Hero hero4 = new Hero("Aragorn4", 36);
        Hero hero5 = new Hero("Aragorng", 38);
        Hero hero6 = new Hero("Aragorn444", 39);
        Hero hero7 = new Hero("Aragorn777", 12);
        Hero hero8 = new Hero("Aragorn8899", 32);
        List<Hero> heroes = new ArrayList<>();
        heroes.add(hero);
        heroes.add(hero1);
        heroes.add(hero2);
        heroes.add(hero3);
        heroes.add(hero4);
        heroes.add(hero5);
        heroes.add(hero6);
        heroes.add(hero7);
        heroes.add(hero8);
        return heroes;
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

    private List<Person> createPersons() {
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
