package com.action;
import java.util.*;


import net.sf.json.JSONArray;
import com.service.*;
import com.service.impl.*;
import com.entity.*;
import java.io.*;
import com.alibaba.fastjson.JSON;
import javax.servlet.ServletContext;


import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Decoder;

@CrossOrigin
@Controller
public class AjaxController {

    @Autowired
    private IServiceGdv_Users ua;

    @Autowired
    private IServiceProductKind sk;

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private IServiceProductSeries ss;

    @Autowired
    private IServiceProductImg mg;

    @Autowired
    private  IServiceProductInfo pd;

    @Autowired
    private IServiceShopInfo sf;

    @Autowired
    private IServiceShopStore st;


/*-----------------------------用户-----------------------------------------*/
   @RequestMapping(value="/login",produces="application/json;charset=UTF-8")
    @ResponseBody
    public String login(String userName,String userPwd){
       Map<String,Object> mp = new HashMap();
                          mp.put("userName",userName);
                          mp.put("userPwd",userPwd);
        Gdv_Users u1 =ua.selectLogin(mp);
        Map<String,Object> mp2 = new HashMap();

        String js = "";
        if (u1 == null){
            System.out.println("-----2012");

            js = JSON.toJSONString(true);
       }else{
            if(u1.getUserVip() == 0){
                System.out.println("----0214");
                mp2.put("user",u1.getUserId());
                js = JSON.toJSONString(mp2);

            }else{
                System.out.println("----0215");
                js = JSON.toJSONString(false);

            }
       }
        return js;
    }
  /*-------------------主页登入---------------*/
  @RequestMapping(value="/selectUser",produces={"application/json;charset=UTF-8"})
  @ResponseBody

  public String selectUser(String id){

      Gdv_Users u3 = ua.selectByPrimaryKey(Integer.parseInt(id));

        System.out.println("--------u3---:="+u3);

        String js = JSON.toJSONString(u3);

        return js;
  }


/*------------------------分类-----------------------*/
    @RequestMapping(value="/showKind",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public String showKind(){
        List<ProductKind> klist = sk.selectAll();
        String js = JSON.toJSONString(klist);
        return js;
    }
    @RequestMapping(value="/showServi",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public String showServi(String id){

        int sid = Integer.parseInt(id);
        List<ProductSeries> slist = ss.selectLike(sid);
        String js = JSON.toJSONString(slist);
        return js;
    }

    @RequestMapping(value = "/addProduct",produces ={"application/json;charset=UTF-8"})
    @ResponseBody
    public String addProduct(String dataArr2,String pid,String pname,String psa, String pkouwei,String pguige,String pjiege,String pjia) throws  Exception {

        String js = "";
        boolean ckupload = true;//文件上传是否成功
        String filePath = servletContext.getInitParameter("filePath");// 文件保存的路径

        String webPath = servletContext.getInitParameter("webPath");// 网络路径

        String productId = pid;//商品编号
        String productName = pname;//商品名称
        int s2 = Integer.parseInt(psa);  //系列号
        int productNum = Integer.parseInt(pguige);//商品多少粒
        String productTaste = pkouwei;//商品口味
        int productPrice = Integer.parseInt(pjiege);//商品价格
        int isCanBuy = Integer.parseInt(pjia);//必填，0是下架，1是上架



        List<ProductImg> plist = new ArrayList();

        BASE64Decoder decoder=new BASE64Decoder();
        JSONArray jarr = JSONArray.fromObject(dataArr2);
        System.out.println( "jarr.size = "+jarr.size());
        for (int i=0;i<jarr.size();i++){
            JSONObject obj = jarr.getJSONObject(i);
            String name = obj.getString("name");
            String base = obj.getString("base64");
            String [] base2 = base.split("base64,");
            String imgstr = base2[1];
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgstr);
            for(int j=0;j<b.length;++j){
                if(b[j]<0){
                    //调整异常数据
                    b[j]+=256;
                }
            }
            String fileName =  name+".jpg";
            String wp = webPath+fileName;
            ProductImg pc = new ProductImg();
            pc.setImgsrc(wp);
            plist.add(pc);

            OutputStream out = new FileOutputStream(filePath+"/"+fileName);

            out.write(b);
         /*   //linux给权限
            Runtime runtime = Runtime.getRuntime();
            String command = "chmod 755 -R " + filePath;
            Process process = runtime.exec(command);
            process.waitFor();
            int existValue = process.exitValue();*/
            out.flush();
            out.close();
        }
        //封装数据
        ProductInfo p2 = new ProductInfo();
                    p2.setProductname(productName);
                    p2.setProductid(productId);
                    p2.setIscanbuy(isCanBuy);
                    p2.setSeriesid(s2);
                    p2.setProductprice(productPrice);
                    p2.setProductnum(productNum);
                    p2.setProducttaste(productTaste);
        int num =pd.insert(p2);
        int nums = 0;
        for (int i=0;i<plist.size();i++){
            plist.get(i).setProductId(p2.getProductid());
            plist.get(i).setImgname(p2.getProductname());
            plist.get(i).setImgbig(1);
            nums = mg.insert(plist.get(i));
        }
        if (num >0){
            js =JSON.toJSONString(true);
        }else {
            js=JSON.toJSONString(false);
        }
        return js;
    }
    //小图上传
    @RequestMapping(value="/addLoad",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public String addLoad(String dataArr2,String pid,String type) throws  Exception{
        Map<String,Object> mp = new HashMap();
        String js = "";
        boolean ckupload = true;//文件上传是否成功
        String filePath = servletContext.getInitParameter("filePath");// 文件保存的路径

        String webPath = servletContext.getInitParameter("webPath");// 网络路径


        String productId = pid;//商品编号

        mp.put("productid",productId);
        int types = Integer.parseInt(type);  //系列号

        List<ProductImg> plist = new ArrayList();

        BASE64Decoder decoder=new BASE64Decoder();
        JSONArray jarr = JSONArray.fromObject(dataArr2);
        System.out.println( "jarr.size = "+jarr.size());
        for (int i=0;i<jarr.size();i++){
            JSONObject obj = jarr.getJSONObject(i);
            String name = obj.getString("name");
            String base = obj.getString("base64");
            String [] base2 = base.split("base64,");
            String img = base2[1];
            //Base64解码
            byte[] b = decoder.decodeBuffer(img);
            for(int j=0;j<b.length;++j){
                if(b[j]<0){
                    //调整异常数据
                    b[j]+=256;
                }
            }
            String fileName =  name+".jpg";
            String wp = webPath+fileName;
            ProductImg pc = new ProductImg();
            pc.setImgsrc(wp);
            plist.add(pc);

          OutputStream out = new FileOutputStream(filePath+"/"+fileName);

            out.write(b);

            out.flush();
            out.close();
        }

        ProductInfo p2 = pd.selectOne(mp);

        int num = 0;
        for (int i=0;i<plist.size();i++){
            plist.get(i).setProductId(p2.getProductid());
            plist.get(i).setImgname(p2.getProductname());
            plist.get(i).setImgbig(types);
            num = mg.insert(plist.get(i));
        }

        if (num >0){
            js =JSON.toJSONString(true);
        }else {
            js=JSON.toJSONString(false);
        }
        return js;
    }

 /*----------------------------查询商品-------------------------------------------*/
    @RequestMapping(value="/selectLike",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectLike(String likes, String price,String jia,Integer pageNumber,Integer pageSize){

        Map<String,Object> mp1 = new HashMap();//发网页
        Map<String,Object> mp  = new HashMap();  //回底层的mp
        if(pageNumber == null){
            pageNumber=1;
        }
        if(pageSize == null){
            pageSize=2;
        }

        mp.put("start",Integer.valueOf((pageNumber-1)*pageSize));
        mp.put("pagesize",pageSize);

        List<ProductInfo> list;

        String js ="" ;
        if (price.length() > 0){
            String[] prices = price.split("-");

            mp.put("minprice",Integer.valueOf(prices[0]));
            mp.put("maxprice",Integer.valueOf(prices[1]));
        }
        if (likes.length() >0){


            mp.put("pname","%"+likes+"%");
        }
        if (jia.length() >0){

            mp.put("sbuy",Integer.parseInt(jia));
        }

        int count = pd.selectCount(mp);


        HashMap hm= pd.selectPagingMohu(pageNumber,pageSize,mp);
        list=(List<ProductInfo>)hm.get("list");
        List<Object> plist = new ArrayList();
        for(ProductInfo p :list){
            if (p.getIscanbuy() == 0){
                String buy = "下架";
                plist.add(buy);
            }else {
                String buy = "上架";
                plist.add(buy);
            }
        }
        mp1.put("plist",plist);
        mp1.put("list",list);
        mp1.put("count",count);
        js = JSON.toJSONString(mp1);

        return js;
    }

    @RequestMapping(value="/selectAll",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectAll(){

        Map<String,Object> mp=new HashMap();//传回去
        Map<String,Object> mp1=new HashMap();//发网页
          int  pageNumber=1;
          int  pageSize=2;
            mp.put("start",Integer.valueOf((pageNumber-1)*pageSize));
            mp.put("pagesize",pageSize);
        List<ProductInfo> list;
        HashMap hm = pd.selectPaging(pageNumber,pageSize ,mp);
        int count = pd.selectCount(mp);

        list=(List<ProductInfo>)hm.get("list");
        //转商品状态
        List<Object> plist = new ArrayList();
        for(ProductInfo p :list){
            if (p.getIscanbuy() == 0){
                String buy = "下架";
                plist.add(buy);
            }else {
                String buy = "上架";
                plist.add(buy);
            }
        }


        mp1.put("plist",plist);
        mp1.put("list",list);
        mp1.put("count",count);

        String js = JSON.toJSONString(mp1);

        return  js;
    }

    @RequestMapping(value="/selectAllLmint",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectAllLmint(Integer pageNumber,Integer pageSize){
        System.out.println("-------查全部---");
        Map<String,Object> mp=new HashMap();//传回去
        Map<String,Object> mp1=new HashMap();//发网页
        if (pageNumber == null){
            pageNumber=1;
        }
        if (pageSize == null){
            pageSize=2;
        }
        mp.put("start",Integer.valueOf((pageNumber-1)*pageSize));
        mp.put("pagesize",pageSize);
        List<ProductInfo> list;
        HashMap hm = pd.selectPaging(pageNumber,pageSize ,mp);
        int count = pd.selectCount(mp);

        list=(List<ProductInfo>)hm.get("list");
        List<Object> plist = new ArrayList();
        for(ProductInfo p :list){
            if (p.getIscanbuy() == 0){
                String buy = "下架";
                plist.add(buy);
            }else {
                String buy = "上架";
                plist.add(buy);
            }
        }


        mp1.put("plist",plist);
        mp1.put("list",list);
        mp1.put("count",count);

        String js = JSON.toJSONString(mp1);

        return  js;
    }


    //查商品
    @RequestMapping(value="/ProductOne",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public String ProductOne(String id){
        System.out.println("------id:="+id);
        String js = "";

        Map<String,Object> mp = new HashMap();
            mp.put("productid",id);

        ProductInfo p1 = pd.selectOne(mp);

        if (p1 !=null){
            js = JSON.toJSONString(p1);
        }
        System.out.println("------p1:="+p1);
        return js;
    }
    //查商品
    @RequestMapping(value="/updateProduct",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public String updateProduct(String id){
        System.out.println("------id:="+id);
        String js = "";

        Map<String,Object> mp = new HashMap();
             mp.put("productid",id);
        ProductInfo p1 = pd.selectOne(mp);

        int num = pd.updateByPrimaryKey(p1);



        if (p1 !=null){
            js = JSON.toJSONString(p1);
        }
        System.out.println("------p1:="+p1);
        return js;
    }



    /*-------------- 商品库存------------------------*/
    //查所有城市
    @RequestMapping(value="/selectCity",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectCity(){

        String js ="";
        List<ShopInfo> list = sf.selectAll();

        js = JSON.toJSONString(list);

        return  js;
    }
    //加库存
    @RequestMapping(value="/insertOne",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public String insertOne(String pid,String city,String jin,String chu){
        System.out.println("-------------新增---");
        System.out.println("-------------pid---：="+pid);
        System.out.println("-------------jin---：="+jin);
        String js = "";

       ShopStore s1 = new ShopStore();
                  s1.setProductid(pid);
                  s1.setShopId(Integer.parseInt(city));
                  s1.setStorenum(Integer.parseInt(jin));
            int num = st.insert(s1);

            if (num > 0){
                    js =JSON.toJSONString(true);
            }else {
                    js =JSON.toJSONString(false);
            }
        return  js;
    }
    //查库存
    @RequestMapping(value="/StockAll",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public String StockAll(){
        Map<String,Object> mp=new HashMap();//传回去
        Map<String,Object> mp2 = new HashMap();
        Map<String,Object> mp1 = new HashMap();
        int pageNumber=1;
        int pageSize=2;
        mp.put("start",Integer.valueOf((pageNumber-1)*pageSize));
        mp.put("pagesize",pageSize);
        List<ShopStore> list;

        HashMap hm = st.selectPages(pageSize,pageNumber,mp);
        int count = st.selectCount(mp);

        list=(List<ShopStore>)hm.get("list");

        List<Object> plist =new ArrayList();
        List<Object> slist =new ArrayList();
            for (ShopStore s1 :list){
               mp2.put("productid",s1.getProductid());
               ProductInfo p1 = pd.selectOne(mp2);
               plist.add(p1);
               ShopInfo s2 = sf.selectByPrimaryKey(s1.getShopId());
               slist.add(s2);
            }
        mp1.put("count",count);
        mp1.put("list",list);
        mp1.put("plist",plist);
        mp1.put("slist",slist);
        String js = JSON.toJSONString(mp1);

        return js;
    } @RequestMapping(value="/StockAllLimit",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public String StockAllLimit(Integer pageNumber,Integer pageSize){
        Map<String,Object> mp=new HashMap();//传回去
        Map<String,Object> mp2 = new HashMap();
        Map<String,Object> mp1 = new HashMap();
        if (pageNumber == null){
            pageNumber=1;
        }
        if (pageSize == null){
            pageSize=2;
        }

        mp.put("start",Integer.valueOf((pageNumber-1)*pageSize));
        mp.put("pagesize",pageSize);
        List<ShopStore> list;

        HashMap hm = st.selectPages(pageSize,pageNumber,mp);
        int count = st.selectCount(mp);

        list=(List<ShopStore>)hm.get("list");

        List<Object> plist =new ArrayList();
        List<Object> slist =new ArrayList();
        for (ShopStore s1 :list){
            mp2.put("productid",s1.getProductid());
            ProductInfo p1 = pd.selectOne(mp2);
            plist.add(p1);
            ShopInfo s2 = sf.selectByPrimaryKey(s1.getShopId());
            slist.add(s2);
        }
        mp1.put("count",count);
        mp1.put("list",list);
        mp1.put("plist",plist);
        mp1.put("slist",slist);
        String js = JSON.toJSONString(mp1);

        return js;
    }
    //模糊查询
    @RequestMapping(value="/StockLike",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public String StockLike(String id,String code){
        Map<String,Object> mp =new HashMap();
        Map<String,Object> mp1 =new HashMap();
        Map<String,Object> mp2 =new HashMap();
        if (id.length() >0){
            mp.put("shopId",Integer.parseInt(id));
        }
        if (code.length() >0){
            mp.put("productid","%"+code+"%");
        }

        List<ShopStore> list = st.selectLike(mp);

        List<Object> plist =new ArrayList();
        List<Object> slist =new ArrayList();
        for (ShopStore s1 :list){
            mp2.put("productid",s1.getProductid());
            ProductInfo p1 = pd.selectOne(mp2);
            plist.add(p1);
            ShopInfo s2 = sf.selectByPrimaryKey(s1.getShopId());
            slist.add(s2);
        }

        mp1.put("list",list);
        mp1.put("plist",plist);
        mp1.put("slist",slist);

        String js =JSON.toJSONString(mp1);

        return js;
    }
    //删除库存
    @RequestMapping(value="/StockDelect",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public String StockDelect(String id){

         int num = st.deleteByPrimaryKey(Integer.parseInt(id));
        String js ="";
        if (num >0){
             js =JSON.toJSONString(true);
         }else {
            js =JSON.toJSONString(false);
         }
        return js;
    }

}


