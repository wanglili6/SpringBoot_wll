package com.wll.itdream.wll_sping.controller;

import com.wll.itdream.wll_sping.dao.LoginRepository;
import com.wll.itdream.wll_sping.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 登陆控制器
 */
@RestController
public class LoginController {
    @Autowired
    LoginRepository loginRepository;

    @RequestMapping("/allLogin")
    public List<Login> loginList() {
        try {
            //查询所有的人员
            return loginRepository.findAll();
        } catch (Exception e) {
            System.out.print(e.toString());
        }
        return null;
    }

    /**
     * 增加一人
     *
     * @param request
     * @param response
     * @param loginMsg
     * @return
     */
    @RequestMapping("/add")
    public String addLogin(HttpServletRequest request, HttpServletResponse response, @RequestParam("loginMsg") String loginMsg) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(loginMsg);
            String loginName = jsonObject.getString("login_name");
            int age = jsonObject.getInt("age");
            String password = jsonObject.getString("password");
            Login login = new Login();
            login.setLogin_name(loginName);
            login.setAge(age);
            login.setPassword(password);
            loginRepository.save(login);
            System.out.print("200");
            return "200";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("500");
            return "500";
        }
    }
    
}
