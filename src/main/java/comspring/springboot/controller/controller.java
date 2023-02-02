package comspring.springboot.controller;

import javax.servlet.http.HttpSession;

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
import comspring.springboot.Service.Userservice;







@Controller
public class controller {

    @Autowired
    dao dao;

    @Autowired
    Userservice userservice;

    @Autowired
    passwordhashService passwordhashService;

    @Autowired
    HttpSession httpSession;
   
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
        dao.insert(data);
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
            if(f_password.equals(passwordDao))
            {
                return ResponseEntity.ok("login successfully");
            }
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("login Error");
            
        }


        //     @PostMapping(value = "/verify_login")
    //     @ResponseBody
    //     public ResponseEntity<?> userdata(@RequestBody String data)
    //     {
    //         JSONObject json = new JSONObject(data);
    //         String f_password = json.getString("password");
    //         String username = json.getString("username");
    //         System.out.println("f_password>>>>>>>"+ f_password +"f_name>>>>>>>"+username );
    //         String passwordDao = dao.verifyLogin(username);
    //         System.out.println("f_password>>>>>>>"+ f_password +"f_name>>>>>>>"+username +"Dao_password>>>>>" + passwordDao);
    //         if( passwordhashService.verifyPassword(passwordDao, f_password))
    //         {
    //             return ResponseEntity.ok("login successfully");
    //         }
    //             return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("login Error");
            
    //     }

    // @PostMapping(value = "/insertregister")
    // public String register (@RequestBody String data)
    // {
    //     System.out.println("Data>>>>>>"+data);
    //     JSONObject json = new JSONObject(data);
    //     String password = json.getString("password");
    //     String hashedPassword = passwordhashService.encodePassword(password);
    //     json.put("password", hashedPassword);
    //     System.out.println("CONTROLLER MEIN AAYA HASHE PASSWORD:::::::::::" + json.toString());
    //     dao.insert(json.toString());
    //     return "register";      
    // }

    
    //     @PostMapping(value = "/verify_login")
    //     @ResponseBody
    //     public ResponseEntity<?> userdata(@RequestBody String data)
    //     {
    //         JSONObject json = new JSONObject(data);
    //         String f_password = json.getString("password");
    //         String username = json.getString("username");
    //         System.out.println("f_password>>>>>>>"+ f_password +"f_name>>>>>>>"+username );
    //         String passwordDao = dao.verifyLogin(username);
    //         System.out.println("f_password>>>>>>>"+ f_password +"f_name>>>>>>>"+username +"Dao_password>>>>>" + passwordDao);
    //         if( passwordhashService.verifyPassword(passwordDao, f_password))
    //         {
    //             return ResponseEntity.ok("login successfully");
    //         }
    //             return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("login Error");
            
    //     }


    //     @PostMapping("/send-otp")
    //     @ResponseBody
    //     public String  verifyEmail(@RequestBody String data){

    //         System.out.println("INSIDE ::::::::::::::");
    //         System.out.println("Email ::::::::::::::" + data);
            
    //     JSONObject json = new JSONObject(data);
    //     String emailValue = json.getString("email");
    //     System.out.println("Json>>>>>"+emailValue);
    //     int id = dao.resetPassword(data);
    //     if(id != 0)
    //     { 
    //         System.out.println("id>>"+id);     
    //     int otp = (int) Math.floor(100000 + Math.random() * 900000);
    //     System.out.println("otp>>>"+otp);
    //     httpSession.setAttribute("otp", otp);
    //     int otpFromSession = (int)httpSession.getAttribute("otp");  
    //     System.out.println("otpsession>>"+otpFromSession);
    //      userservice.sendEmail("Your Otp for Email Verification is: " + otp, emailValue, 3);
    //      return "success";
    //     }
    //     System.out.println("null>>");
    //      return "/login";
    //     }
    }
        
 


