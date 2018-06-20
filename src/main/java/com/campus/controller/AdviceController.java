package com.campus.controller;

import com.campus.entity.Advice;
import com.campus.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class AdviceController {

    @Autowired
    private AdviceService adviceService;


    /**
     * 添加建议
     */
    @RequestMapping(value = "/addadvice", method = RequestMethod.POST)
    public Map<String, Object> addAdvice(Advice advice) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            if(adviceService.addAdvice(advice)){
                modelMap.put("status", true);
                modelMap.put("errMsg","感谢你的反馈");
            }else{
                modelMap.put("status", false);
                modelMap.put("errMsg","反馈失败,可能网络出小差了");
            }
        } catch (Exception e) {
            modelMap.put("status", false);
            modelMap.put("errMsg", e.getMessage());
        }
        return modelMap;
    }
    @RequestMapping(value = "getadvicecount",method = RequestMethod.POST)
    public Map<String,Object> getAdviceCount(String userId){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("count",adviceService.count(userId));
        return modelMap;
    }

}
