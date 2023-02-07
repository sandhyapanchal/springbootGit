package comspring.springboot.controller;

import java.util.List;
import java.util.Map;

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

@Controller
public class controller {

    @Autowired
    dao dao;

    @Autowired
    HttpSession httpSession;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @ResponseBody
    @GetMapping(value = "/details")
    public List<Map<String, Object>> details() {
        String email = (String) httpSession.getAttribute("email");
        System.out.println("emailcontroller>>" + email);
        List<Map<String, Object>> details = dao.details(email);
        System.out.println("data>>" + details);
        return details;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/first")
    public String first() {
        return "first";
    }

    @GetMapping("/login")

    public String login() {
        return "login";
    }

    @PostMapping(value = "/insertregister")
    public ResponseEntity<String> register(@RequestBody String data) {
        JSONObject json = new JSONObject(data);

        String fname = json.getString("fname");
        // if (fname.length() < 2) {
        // return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("First name
        // error....");
        // }

        String password = json.getString("password");
        // if (password.length() < 2) {
        // return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("First name
        // error....");
        // }

        dao.insertMethod(data);
        return ResponseEntity.ok("login successfully");
    }

    @PostMapping(value = "/verify_login")
    @ResponseBody
    public ResponseEntity<?> userdata(@RequestBody String data) {

        JSONObject json = new JSONObject(data);
        System.out.println("json>>" + json);
        String f_password = json.getString("password");
        String email = json.getString("email");
        System.out.println("emailCOntroller" + email);
        httpSession.setAttribute("email", email);
        System.out.println("f_password>>>>>>>" + f_password + "f_name>>>>>>>" + email);
        String passwordDao = dao.verifyLogin(email);
        System.out.println("passwordDao" + passwordDao);

        if (f_password.equals(passwordDao)) {

            return ResponseEntity.ok("login successfully");
        }

        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("login Error");

    }

    @GetMapping(value = "/userdetails")
    public String userdetails() {
        return "/userdetails";
    }

    @ResponseBody
    @GetMapping(value = "/allDetails")
    public List<Map<String, Object>> Alldetails() {

        List<Map<String, Object>> allDetails = dao.allDetails();
        System.out.println("Alldata>>" + allDetails);
        return allDetails;
    }

    @ResponseBody
    @GetMapping(value = "/getCount")
    public String getCount() {
        String count = dao.getCount();
        return count;
    }

    // Active & Deactive
    @ResponseBody
    @PostMapping(value = "/setDeactive")
    public String setDeactive(@RequestBody String email) {
        System.out.println("Email : " + email);
        dao.setDeactive(email);
        return "Success";
    }

    @ResponseBody
    @PostMapping(value = "/setActive")
    public String setActive(@RequestBody String email) {

        dao.setActive(email);
        return "Success";
    }
}
