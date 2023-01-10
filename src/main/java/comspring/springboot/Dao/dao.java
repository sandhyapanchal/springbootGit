package comspring.springboot.Dao;


import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class dao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int insert (String data){
        JSONObject json = new JSONObject(data);
        String username = json.getString("username");
        String email = json.getString("email");
        String password = json.getString("password");
        System.out.println(username+email+password);
        String sql ="insert into users(username,email,password) values (?,?,?)";
        System.out.println("jdbc>>>>>>>>>>>>"+jdbcTemplate);
        return jdbcTemplate.update(sql,username,email,password);
    }

    // @Override
    // public List<model> userdata(String data) {

    //     String sql = "select password from users where username=?";
    //     return jdbcTemplate.query((sql),(rs, rownum)->{
    //         return new model(rs.getString("username"),rs.getString("email"),rs.getString("password"))
    //     });
    // }
    // @Override
    // public List<UserSkillsFromDB> getAllSkills() {

    //     String sql = "select * from skill";

    //     return jdbcTemplate.query(sql, (rs, rownum) -> {
    //         return new UserSkillsFromDB(rs.getInt("id"), rs.getInt("skill_type_lid"), rs.getString("skill_name"));
    //     });
    // }
}
