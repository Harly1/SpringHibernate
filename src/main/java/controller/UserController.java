package controller;


import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.Service;

import javax.servlet.RequestDispatcher;

@Controller
public class UserController {
    private Service service;

    @Autowired(required=true)
    @Qualifier(value="service")
    public void setService(Service service){
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.service.getListOfAllUsers());
        return "person";
    }

    //For add and update person both
    @RequestMapping(value= "/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("user") User user){

        if(user.getId() == 0){
            //new person, add it
            this.service.insertUser(user);
        }else{
            //existing person, call update
            this.service.updateUser(user);
        }

        return "redirect:/users";

    }

    @RequestMapping("/remove/{user}")
    public String removePerson(@ModelAttribute("user") User user){

        this.service.deleteUser(user);
        return "redirect:/persons";
    }

    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.service.getUser(id));
        model.addAttribute("listUsers", this.service.getListOfAllUsers());
        return "user";
    }

}

