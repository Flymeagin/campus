package com.campus.controller;
import com.campus.dto.GoodsExcution;
import com.campus.entity.Goods;
import com.campus.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/addgoods", method = RequestMethod.POST)
    public Map<String, Object> addGoods(Goods goods) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            GoodsExcution goodsExcution = goodsService.addGoods(goods);
            modelMap.put("status", true);
            modelMap.put("data", goodsExcution);
        } catch (Exception e) {
            modelMap.put("status", false);
            modelMap.put("errMsg", e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping("hello")
    public String hello(){
        return "hello world";
    }


    //处理传递过来的图片数据，并返回图片地址
    @RequestMapping(value = "/addgoodsimage",method = RequestMethod.POST)
    public String addImageUrl(MultipartFile image, HttpServletRequest request){

        //获取图片上传的路径
        String realUrl = request.getSession().getServletContext().getRealPath("/goodsimages");
        System.out.println(realUrl);
        String fileName = image.getOriginalFilename();
        return fileName;
    }
}
