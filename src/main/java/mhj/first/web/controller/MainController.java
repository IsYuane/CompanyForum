package mhj.first.web.controller;

import mhj.first.web.bean.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    @RequestMapping("*")
    public String notFind(){
        return "404";
    }

    @RequestMapping("/isAdmin")
    public ModelAndView isAdmin(HttpSession session){
        Employee employee = (Employee) session.getAttribute("employee");
        if(1==employee.getLevel()){
            return new ModelAndView("redirect:/emps");
        }else {
            return new ModelAndView("redirect:/topic");
        }
    }

    @RequestMapping("/logOut")
    public String logOut(HttpSession session){
        session.removeAttribute("employee");
        return "redirect:/";
    }
}
