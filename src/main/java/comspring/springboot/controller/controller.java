package comspring.springboot.controller;






import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import comspring.springboot.Dao.dao;







@Controller
public class controller {

    @Autowired
    dao dao;
   
    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }     
    
    @PostMapping(value = "/insertregister")
    public String register (@RequestBody String data)
    {
        System.out.println("Data>>>>>>"+data);
        dao.insert(data);
        return "register";      
    }

        @PostMapping(value = "/verify_login")
        public String userdata(@RequestBody String data)
        {
            JSONObject json = new JSONObject(data);
            String f_password = json.getString("password");
            return null;
        }
    
    }
        
 


