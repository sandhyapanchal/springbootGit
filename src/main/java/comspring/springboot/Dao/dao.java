package comspring.springboot.Dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class dao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    HttpSession httpSession;

    public int insertMethod(String data) {

        JSONObject json = new JSONObject(data);
        String fname = json.getString("fname");
        String lname = json.getString("lname");
        String password = json.getString("password");
        String email = json.getString("email");
        String mobile = json.getString("mobile");

        String sql = "insert into users(fname,lname,password,email,mobile) values (?,?,?,?,?)";
        System.out.println("jdbc>>>>>>>>>>>>" + jdbcTemplate);
        // System.out.println("Count" + json);
        return jdbcTemplate.update(sql, fname, lname, password, email, mobile);

    }

    public List<Map<String, Object>> details(String email) {
        System.out.println("email>>" + email);
        String sql = "select * from users where email =?";
        List<Map<String, Object>> details = jdbcTemplate.queryForList(sql, email);
        return details;
    }

    public String verifyLogin(String email) {

        String sql = "select password from users where email =?";
        String password = jdbcTemplate.queryForObject(sql, String.class, email);
        return password;

    }

    public String getCount() {
        String sql = "select count(*) from users";
        String count = jdbcTemplate.queryForObject(sql, String.class);
        return count;
    }

    public List<Map<String, Object>> allDetails() {

        String sql = "select * from users";
        List<Map<String, Object>> allDetails = jdbcTemplate.queryForList(sql);
        return allDetails;
    }

    // Active & Deactive
    public int setDeactive(String email) {
        String sql = "update users set enable ='N' where email=?";
        int setDeactive = jdbcTemplate.update(sql, email);
        return setDeactive;
    }

    public int setActive(String email) {
        String sql = "update users set enable ='Y' where email=?";
        int setActive = jdbcTemplate.update(sql, email);
        return setActive;
    }
}
