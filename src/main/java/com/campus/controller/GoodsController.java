package com.campus.controller;

import com.campus.dao.GoodsCarDao;
import com.campus.dto.GoodsExcution;
import com.campus.entity.Goods;
import com.campus.entity.GoodsCar;
import com.campus.service.GoodsCarService;
import com.campus.service.GoodsService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsCarService goodsCarService;

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

    @RequestMapping(value = "/changegoods", method = RequestMethod.POST)
    public Map<String, Object> changeGoods(Goods goods) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            GoodsExcution goodsExcution = goodsService.changeGoods(goods);
            modelMap.put("status", true);
            modelMap.put("data", goodsExcution);
        } catch (Exception e) {
            modelMap.put("status", false);
            modelMap.put("errMsg", e.getMessage());
        }
        return modelMap;
    }

    //处理传递过来的图片数据，并返回图片地址
    @RequestMapping(value = "/addgoodsimage", method = RequestMethod.POST)
    public String addImageUrl(MultipartFile image, HttpServletRequest request) {

        if (image.getSize() <= 0) {
            return "上传图片失败";
        }
        //获取图片上传的路径
        String realUrl = request.getSession().getServletContext().getRealPath("/goodsimages");

        String fileName = image.getOriginalFilename();
        //获取当前的时间戳 保证文件名的唯一性
        long mills = System.currentTimeMillis();
        String realFileName = mills + fileName.substring(fileName.lastIndexOf("."));
        File file = new File(realUrl);
        try {
            if (!file.exists()) {
                file.mkdir();
            }
            file = new File(realUrl, realFileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            image.transferTo(file);
            return realFileName;
        } catch (IOException e) {
            e.printStackTrace();
            return "上传图片失败";
        }
    }

    //返回人气商品和最新商品
    @RequestMapping(value = "/indexgoods", method = RequestMethod.POST)
    public Map<String, Object> indexGoods() {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            modelMap.put("status", true);
            modelMap.put("data", goodsService.indexGoods());
        } catch (Exception e) {
            modelMap.put("status", false);
            modelMap.put("errMsg", e.getMessage());
        }

        return modelMap;

    }

    //根据分类返回商品
    @RequestMapping(value = "/categorygoods", method = RequestMethod.POST)
    public Map<String, Object> cateGoryGoods(String category) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            modelMap.put("status", true);
            System.out.println(category);
            modelMap.put("data", goodsService.findByCategory(category));
        } catch (Exception e) {
            modelMap.put("status", false);
            modelMap.put("errMsg", e.getMessage());
        }
        return modelMap;
    }

    //模糊查询返货结果
    @RequestMapping(value = "/searchgoods", method = RequestMethod.POST)
    public Map<String, Object> searchGoods(String key) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            modelMap.put("status", true);
            modelMap.put("data", goodsService.serachGoods(key));
        } catch (Exception e) {
            modelMap.put("status", false);
            modelMap.put("errMsg", e.getMessage());
        }

        return modelMap;
    }

    //返回商品详情
    @RequestMapping(value = "/goodsdetail", method = RequestMethod.POST)
    public Map<String, Object> goodsDetail(int goodsId, String userId) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            modelMap.put("status", true);
            modelMap.put("data", goodsService.getGoodsById(goodsId));
            if (goodsCarService.isExist(userId, goodsId)) {
                modelMap.put("isSC", true);
            } else {
                modelMap.put("isSC", false);
            }
        } catch (Exception e) {
            modelMap.put("status", false);
            modelMap.put("errMsg", e.getMessage());
        }
        return modelMap;
    }


    //返回用户的商品列表
    @RequestMapping(value = "/usergoods", method = RequestMethod.POST)
    public Map<String, Object> userGoods(String userId) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            modelMap.put("status", true);
            modelMap.put("data", goodsService.getGoodsByUser(userId));
        } catch (Exception e) {
            modelMap.put("status", false);
            modelMap.put("errMsg", e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value = "/setbuyflag", method = RequestMethod.POST)
    public Map<String, Object> setBuyFlag(int goodsId, String userId) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            System.out.println(goodsId);
            if (goodsService.setBuyFlag(goodsId, userId)) {
                modelMap.put("status", true);
                modelMap.put("data", "设置成功");
            } else {
                modelMap.put("status", false);
                modelMap.put("data", "设置失败");
            }

        } catch (Exception e) {
            modelMap.put("status", false);
            modelMap.put("errMsg", e.getMessage());
            e.printStackTrace();
        }
        return modelMap;
    }

    @RequestMapping(value = "/delgoods", method = RequestMethod.POST)
    public Map<String, Object> delGoods(int goodsId, String userId) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            if (goodsService.delGoods(goodsId, userId)) {
                modelMap.put("status", true);
                modelMap.put("data", "删除成功");
            } else {
                modelMap.put("status", false);
                modelMap.put("data", "删除失败");
            }

        } catch (Exception e) {
            modelMap.put("status", false);
            modelMap.put("errMsg", e.getMessage());
        }
        return modelMap;
    }

    //


    //添加物品到收藏夹
    @RequestMapping(value = "/addgoodscar", method = RequestMethod.POST)
    public Map<String, Object> addGoodsCar(GoodsCar goodsCar) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            if (goodsCarService.addGoodsCar(goodsCar)) {
                modelMap.put("status", true);
                modelMap.put("data", "添加成功");
            }
        } catch (Exception e) {
            modelMap.put("status", false);
            modelMap.put("errMsg", e.getMessage());
        }
        return modelMap;
    }

    //添加物品到收藏夹
    @RequestMapping(value = "/removegoodscar", method = RequestMethod.POST)
    public Map<String, Object> removeGoodsCar(GoodsCar goodsCar) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            if (goodsCarService.removeGoodsCar(goodsCar)) {
                modelMap.put("status", true);
                modelMap.put("data", "移出成功");
            }
        } catch (Exception e) {
            modelMap.put("status", false);
            modelMap.put("errMsg", e.getMessage());
        }
        return modelMap;
    }

    //返回用户的收藏列表
    @RequestMapping(value = "/collectiongoods", method = RequestMethod.POST)
    public Map<String, Object> removeGoodsCar(String userId) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            modelMap.put("status", true);
            modelMap.put("data", goodsCarService.getGoodsCarById(userId));
        } catch (Exception e) {
            modelMap.put("status", false);
            modelMap.put("errMsg", e.getMessage());
        }
        return modelMap;
    }
    //返回所有商品
    @RequestMapping(value = "/querygoods", method = RequestMethod.POST)
    public Map<String, Object> queryGoods(int pageNum) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            modelMap.put("status", true);
            modelMap.put("data", goodsService.queryGoods(pageNum));
        } catch (Exception e) {
            modelMap.put("status", false);
            modelMap.put("errMsg", e.getMessage());
        }
        return modelMap;
    }
}
