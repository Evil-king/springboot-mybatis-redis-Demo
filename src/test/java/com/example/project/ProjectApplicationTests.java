//package com.example.project;
//
//import com.alibaba.fastjson.JSONObject;
//import com.example.project.dao.ProductMapper;
//import com.example.project.model.Product;
//import com.example.project.service.IProductService;
//import com.example.project.util.RedisUtil;
//import com.example.project.util.SpringContextUtil;
//import com.google.common.collect.Maps;
//import com.google.gson.Gson;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.CollectionUtils;
//import org.springframework.util.ObjectUtils;
//import tk.mybatis.mapper.entity.Condition;
//import tk.mybatis.mapper.entity.Example;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//
//@Slf4j
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ProjectApplicationTests {
//
//    @Autowired
//    private RedisUtil redisUtil;
//    @Autowired
//    private IProductService productService;
//    @Autowired
//    private ProductMapper productMapper;
//
//    @Test
//    public void setRedis() {
////        Condition condition = new Condition(Product.class);
////        Example.Criteria criteria = condition.createCriteria();
////        List<Product> products = productMapper.selectByCondition(condition);
////        log.info("products={}",products);
////        for(Product product : products){
////            Map map = Maps.newHashMap();
////            map.put("productProcie",product.getGoodsPrice());
////            map.put("customerNo",product.getCustomerNo());
////            redisUtil.setHash(product.getCustomerNo()+product.getGoodsName(),map);
////        }
//
////        String key = "手";
////        Set<String> likeData = redisUtil.getLikeData(key);
////        for(String str : likeData){
////            Object productPrice = redisUtil.hget(str, "productProcie");
////            log.info("productPrice={}",productPrice);
////        }
//
//        long timeOut = 120000L;
//
//        Condition condition1 = new Condition(Product.class);
//        Example.Criteria criteria1 = condition1.createCriteria();
//        criteria1.andEqualTo("goodsNo", "NB001");
//        List<Product> products = productMapper.selectByCondition(condition1);
//
//
//        redisUtil.setEx(products.get(0).getGoodsNo(),products.get(0).getGoodsName(),60000);
//
////        if (!CollectionUtils.isEmpty(products)) {
////            long nowTime = new Date().getTime();
////            long createTime = products.get(0).getCreateTime().getTime();
////            long d = nowTime - createTime;
////            if (d <= timeOut) { // 120秒后才能重新发送
////                log.info("验证码已下发，请查收");
////            } else {
////                log.info("正常");
////            }
////        }
//
////        String nb001 = redisUtil.get("NB001");
////        log.info("customerNo={}",nb001);
//    }
//
//    @Test
//    public void getRedis(){
//        String goodsNo = "1002";
//        Object obj =  redisUtil.hget(goodsNo,"goodsName");
//        log.info(String.valueOf(JSONObject.toJSON(obj)));
//    }
//
//    @Test
//    public void getEnterRedis(){
//        String goodsNo = "1002";
//        Gson gson = new Gson();
//        String jsonStr = gson.toJson(redisUtil.entriesHash(goodsNo));
//        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
//        log.info(String.valueOf(jsonObject));
//    }
//
//
//    @Test
//    public void useSet(){
//        String customerNum = "10003";
//        String goodsNo = "NA1002";
////        String [] goodsNo = {"NB1002","NB1001","NB1003","NB1004"};
////        redisUtil.addSet(customerNum,goodsNo);
////        redisUtil.addSet(customerNum,goodsNo);
////        Set set = redisUtil.getSet(customerNum);
////        log.info("set={}",set);
//
//        Long result= redisUtil.delSet(customerNum,goodsNo);
//        log.info("result={}",result);
//    }
//
//    @Test
//    public void Test01(){
//        String channel_withdrawal="{'47':'psyChicWithdrawProcess','37':'msAgentPayForGZProcess','18':'unionWithdrawProcess','41':'jdPayWithdrawProcess','100':'yeePayWithdrawProcess','99':'tltPayWithdrawProcess'}";
//
//        String channel = "99";
//
//        JSONObject json_withdrawal = JSONObject.parseObject(channel_withdrawal);
//        log.info("json_withdrawal{}",json_withdrawal);
//        String beanName = json_withdrawal.getString(channel);
//        Object bean = SpringContextUtil.getBean(beanName);
//        log.info("bean:{}",bean);
//    }
//}
