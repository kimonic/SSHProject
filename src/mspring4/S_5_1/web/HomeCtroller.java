package mspring4.S_5_1.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class HomeCtroller {

    @RequestMapping(value = "/",method = POST)
    public String home(){
        return "home";
    }
}
