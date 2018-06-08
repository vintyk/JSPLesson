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
        myReq.setAttribute("IdFromSelect", getServletContext().getAttribute("IdFromSelect"));
        myReq.setAttribute("myChkBoxRadioMsg", getServletContext().getAttribute("myChkBoxRadioMsg"));
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/person.jsp")
                .forward(myReq, myResp);
    }

    @Override
    protected void doPost(HttpServletRequest myReq, HttpServletResponse resp) throws ServletException, IOException {
        String mySelect1 = myReq.getParameter("mySelect1");
        String chkBoxRadioArmor = myReq.getParameter("chkBoxRadioArmor");
        String chkBoxMessage = "";
        switch (chkBoxRadioArmor) {
            case "1":
                chkBoxMessage = "В радио чекбоксе выбрано значение " + chkBoxRadioArmor;
                break;
            case "2":
                chkBoxMessage = "В радио чекбоксе выбрано значение " + chkBoxRadioArmor;
                break;
            case "3":
                chkBoxMessage = "В радио чекбоксе выбрано значение " + chkBoxRadioArmor;
                break;
            default:
                chkBoxMessage = "В радио чекбоксе ARMOR - ничего не выбрано";
                break;
        }
        System.out.println(chkBoxMessage);
        getServletContext().setAttribute("myChkBoxRadioMsg", chkBoxMessage);

        getServletContext().setAttribute("IdFromSelect", mySelect1);
        System.out.println("В ниспадающем списке мы выбрали " + mySelect1 +
                " - Его VALUE - это не то что на странице. " +
                "Как правило ставят ID - что бы его потом отправить " +
                "в базу и по этому ID найти строку.");
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Person person = new Person();
        person.setName((String) myReq.getParameter("name2Attr"));
        person.setFamily((String) myReq.getParameter("family2Attr"));
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

    private List<Hero> getHeroes() {
        Hero hero = new Hero(1L, "Aragorn", 33);
        Hero hero1 = new Hero(2L, "Aragory", 35);
        Hero hero2 = new Hero(3L, "Aragoryyyn", 37);
        Hero hero3 = new Hero(4L, "AragorUuiin", 93);
        Hero hero4 = new Hero(5L, "Aragorn4", 36);
        Hero hero5 = new Hero(6L, "Aragorng", 38);
        Hero hero6 = new Hero(7L, "Aragorn444", 39);
        Hero hero7 = new Hero(8L, "Aragorn777", 12);
        Hero hero8 = new Hero(9L, "Aragorn8899", 32);
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
}
