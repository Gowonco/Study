package com.springboot.demo.SpringbootTest.jdbc.controller;

import com.springboot.demo.SpringbootTest.base.pojo.User;
import com.springboot.demo.SpringbootTest.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

@RestController
public class JdbcController {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserService userService;
    private Connection conn=null;
    private Statement stmt=null;
    private ResultSet rs= null;


    @RequestMapping("/user/get")
    public Map<String,Object> getUser(){
        Map<String,Object> data =new HashMap<String, Object>();
        String sql="select * from user";
        try {
            conn=dataSource.getConnection();
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                data.put("id",rs.getString("id"));
                data.put("name",rs.getString("name"));
                data.put("age",rs.getString("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
                stmt.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    @RequestMapping(value="/user/add",method = RequestMethod.POST)
    public Map<String,Object> addUser(@RequestBody User user){
        Map<String,Object> data =new HashMap<String, Object>();

        data.put("success",userService.saveUser(user));
        return data;
    }

    @RequestMapping(value="/users")
    public List<Map<String,Object>> addUser(){



        return jdbcTemplate.execute(new StatementCallback<List<Map<String,Object>>>() {
            @Override
            public List<Map<String,Object>> doInStatement(Statement stmt) throws SQLException, DataAccessException {
                rs=stmt.executeQuery("select * from user");
                ResultSetMetaData rsd=rs.getMetaData();
                int colums=rsd.getColumnCount();
                List<String> columNames=new ArrayList<>();
                for(int i=1;i<=colums;i++){
                    String columName=rsd.getColumnName(i);
                    columNames.add(columName);
                }
                List<Map<String,Object>> data=new LinkedList<>();
                while(rs.next()){
                    Map<String,Object> d1=new LinkedHashMap<>();
                    for(String c:columNames){
                        Object value=rs.getObject(c);
                        d1.put(c,value);
                    }
                    data.add(d1);
                }
                return data;
            }
        });
    }

}
