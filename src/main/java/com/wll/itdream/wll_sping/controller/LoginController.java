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
import java.io.PrintWriter;
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
     * @param request   :请求头
     * @param response: 返回结果
     * @param loginMsg  :请求参数
     * @return
     */
    @RequestMapping("/add")
    public void addLogin(HttpServletRequest request, HttpServletResponse response, @RequestParam("loginMsg") String loginMsg) {
        JSONObject jsonObject = null;
        int result = 500;
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
            JSONObject obj = new JSONObject();
            obj.put("result", result);
            PrintWriter writer = response.getWriter();
            writer.print(obj.toString());
            writer.flush();
            writer.close();
            System.out.print("200");
        } catch (Exception e) {
            e.printStackTrace();
            result = 500;
            System.out.print("500");
        }
    }

    /**
     * 根据名字和密码确定唯一
     *
     * @param request
     * @param response
     * @param name
     * @param password
     */
    @RequestMapping("/selectLogin")
    public void selectLogin(HttpServletRequest request, HttpServletResponse response, String name, String password) {
        try {
            String result = "200";
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("result", request);
            PrintWriter writer = response.getWriter();
//            List<Login> byNameAAndPassword = loginRepository.findByNameAndPassword(name, password);
//            if (byNameAAndPassword != null) {
//                if (byNameAAndPassword.size() != 0) {
//                    jsonObject.put("data", byNameAAndPassword);
//                    writer.print(jsonObject.toString());
//                } else {
//                    result = "没有查询到结果";
//                    jsonObject.put("result", result);
//                    writer.print(jsonObject.toString());
//                }
//            } else {
//                result = "没有查询到结果";
//                jsonObject.put("result", result);
//                writer.print(jsonObject.toString());
//            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
