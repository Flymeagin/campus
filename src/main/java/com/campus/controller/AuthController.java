package com.campus.controller;

import com.campus.dao.UserSignDao;
import com.campus.dto.UserExcution;
import com.campus.entity.Sign;
import com.campus.entity.User;
import com.campus.entity.UserSign;
import com.campus.service.UserService;
import com.campus.utils.HttpUtils;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserSignDao userSignDao;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> login(User user) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            UserExcution userExcution = userService.userLogin(user);
            modelMap.put("status", true);
            modelMap.put("data", userExcution);
        } catch (Exception e) {
            modelMap.put("status", false);
            modelMap.put("errMsg", e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value = "/changeuser", method = RequestMethod.POST)
    public Map<String, Object> changeUser(User user,@RequestParam("s") String s) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            JavaType jt = mapper.getTypeFactory().constructParametricType(ArrayList.class, Sign.class);
            List<Sign> signs = mapper.readValue(s,jt);
            UserExcution userExcution = userService.changeUser(user,signs);
            modelMap.put("status", true);
            modelMap.put("data", userExcution);
        } catch (Exception e) {
            modelMap.put("status", false);
            modelMap.put("errMsg", e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value = "judge", method = RequestMethod.POST)
    public Map<String,Object> judge(User user){
        Map<String,Object> modelMap = new HashMap<>();
        User queryUser = userService.exist(user);
        if(queryUser == null){
            modelMap.put("status",true);
            // 1 代表未注册
            modelMap.put("code",1);
        }else{
            modelMap.put("status",true);
            // 0 代表已注册
            modelMap.put("code",0);
            modelMap.put("data",queryUser);
        }
        return modelMap;
    }

    @RequestMapping(value = "getuserid", method = RequestMethod.POST)
    public Map<String, Object> getUserId(String code) {
        Map<String, Object> modelMap = new HashMap<>();
        Map<String, String> params = new HashMap<>();
        System.out.println(code);
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        params.put("appid", "wx9c7b92daf9590b3d");
        params.put("secret", "0dc371e30e204cedd31204b6e0f23c7e");
        params.put("js_code", code);
        params.put("grant_type", "authorization_code");
        try {
            Map result = HttpUtils.getEntity(url, params);
            System.out.println(result);
            if (result.get("openid") != null) {
                modelMap.put("status", true);
                modelMap.put("userId", result.get("openid"));

            } else {
                modelMap.put("status", false);
                modelMap.put("errMsg", result.get("errmsg"));
            }
        } catch (Exception e) {
            modelMap.put("status", false);
            modelMap.put("errMsg", e.getMessage());
        }
        return modelMap;
    }
}
