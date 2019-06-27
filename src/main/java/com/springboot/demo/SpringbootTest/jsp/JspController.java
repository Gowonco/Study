package com.springboot.demo.SpringbootTest.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class JspController {

    @RequestMapping("/index")
    @ResponseBody
    public String index(Model model){
        model.addAttribute("name","hello");
        return "index";
    }
}
