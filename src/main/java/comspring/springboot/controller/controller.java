package comspring.springboot.controller;






import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import comspring.springboot.Dao.dao;

import comspring.springboot.Service.passwordhashService;







@Controller
public class controller {

    @Autowired
    dao dao;

    @Autowired
    passwordhashService passwordhashService;
   
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
    
    @GetMapping("/resetPassword")
    public String resetPassword(){
        return "resetPassword";
    } 
   
    @PostMapping(value = "/insertregister")
    public String register (@RequestBody String data)
    {
        System.out.println("Data>>>>>>"+data);
        JSONObject json = new JSONObject(data);
        String password = json.getString("password");
        String hashedPassword = passwordhashService.encodePassword(password);
        json.put("password", hashedPassword);
        System.out.println("CONTROLLER MEIN AAYA HASHE PASSWORD:::::::::::" + json.toString());
        dao.insert(json.toString());
        return "register";      
    }

    
        @PostMapping(value = "/verify_login")
        @ResponseBody
        public ResponseEntity<?> userdata(@RequestBody String data)
        {
            JSONObject json = new JSONObject(data);
            String f_password = json.getString("password");
            String username = json.getString("username");
            System.out.println("f_password>>>>>>>"+ f_password +"f_name>>>>>>>"+username );
            String passwordDao = dao.verifyLogin(username);
            System.out.println("f_password>>>>>>>"+ f_password +"f_name>>>>>>>"+username +"Dao_password>>>>>" + passwordDao);
            if( passwordhashService.verifyPassword(passwordDao, f_password))
            {
                return ResponseEntity.ok("login successfully");
            }
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("login Error");
            
        }
    
    }
        
 


