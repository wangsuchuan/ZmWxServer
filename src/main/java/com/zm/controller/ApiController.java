package com.zm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zm.model.User;
import com.zm.servic.UserExService;
import com.zm.util.BuildPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

@RestController
public class ApiController {

    @Autowired
    private UserExService userExService;

    @RequestMapping(value = "api/v1", method = RequestMethod.GET)
    public String v1() {
        Long id  = userExService.insertUserExInfo();
        User userEx = new User();
        userEx.setName("差多少分");
        userEx.setId(132L);
        String json2 = JSONObject.toJSONString(userEx);
        String json3 = JSON.toJSONString(userEx);
        System.out.print(json2);
        System.out.print(json3);
        return String.valueOf(json2.toString());

//        String shareFileName="";
//        try {
//            InputStream is = null;
////            is = new ClassPathResource("resources/static/images/miaomiao.png").getInputStream();
////            is = new FileInputStream("images/miaomiao.png");
//
//            //File file = ResourceUtils.getFile("classpath:templates/b_dfd.txt");
//            File file = ResourceUtils.getFile("classpath:static/images/miaomiao1.JPEG");
//            is = new FileInputStream(file);
//
//            try{
//                InputStream inputStream  = getClass().getClassLoader().getResourceAsStream("images/miaomiao.jpeg");//此方法返回读取文件字节的方式在linux系统中无异。
//            }catch (Exception e) {
//                e.printStackTrace();
//            }
//            try{
//                InputStream inputStream  = getClass().getClassLoader().getResourceAsStream("static/images/miaomiao.jpeg");//此方法返回读取文件字节的方式在linux系统中无异。
//            }catch (Exception e) {
//                e.printStackTrace();
//            }
//            try{
//                InputStream inputStream  = getClass().getClassLoader().getResourceAsStream("classpath:static/images/miaomiao.jpeg");//此方法返回读取文件字节的方式在linux系统中无异。
//            }catch (Exception e) {
//                e.printStackTrace();
//            }
//            try{
//                InputStream inputStream  = getClass().getClassLoader().getResourceAsStream("classpath:images/miaomiao.jpeg");//此方法返回读取文件字节的方式在linux系统中无异。
//            }catch (Exception e) {
//                e.printStackTrace();
//            }
//
//
//            //通过JPEG图象流创建JPEG数据流解码器
//            JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
//            //解码当前JPEG数据流，返回BufferedImage对象
//            BufferedImage buffImg = null;
//            try {
//                buffImg = jpegDecoder.decodeAsBufferedImage();
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
//            //得到画笔对象
//            Graphics g = buffImg.getGraphics();
//
//            //创建你要附加的图象。
//            //小图片的路径
//            ImageIcon imgIcon = new ImageIcon("喵");
//
//            //得到Image对象。
//            Image img = imgIcon.getImage();
//
//            //将小图片绘到大图片上。
//            //5,300 .表示你的小图片在大图片上的位置。
//            g.drawImage(img, 400, 15, null);
//
//            //设置颜色。
//            g.setColor(Color.BLACK);
//
//
//            //最后一个参数用来设置字体的大小
//            Font f = new Font("宋体", Font.PLAIN, 25);
//            Color mycolor = Color.red;//new Color(0, 0, 255);
//            g.setColor(mycolor);
//            g.setFont(f);
//
//            //10,20 表示这段文字在图片上的位置(x,y) .第一个是你设置的内容。
//            g.drawString("喵", 100, 135);
//
//            g.dispose();
//
//
//            OutputStream os;
//
//            //os = new FileOutputStream("d:/union.jpg");
//            //String shareFileName = "\\upload\\" + System.currentTimeMillis() + ".jpg";
//
//            shareFileName = "images/" + System.currentTimeMillis() + ".jpg";
//            os = new FileOutputStream(ResourceUtils.getFile("classpath:static/"+shareFileName+""));
//            //创键编码器，用于编码内存中的图象数据。
//            JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
//            is.close();
//            os.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return shareFileName;
    }


    @RequestMapping(value = "v2/tupian", method = RequestMethod.GET)
    public String testTupian() {

        Font font = new Font("微软雅黑", Font.PLAIN, 150);
        String inPath = "classpath:static/images/miaomiaonew.png";
        String outPath = "classpath:static/images/miaomiaonew.png";
//        String outPath = "resources/static/images/miaomiao1.png";
//        String inPath = "D:/TestGenerateImage/DynamicImage/testImage.png";
//        String outPath = "D:/TestGenerateImage/DynamicImage/testImage1.png";
		/*String inPath = "D:/TestGenerateImage/DynamicImage/Test.jpg";
		String outPath = "D:/TestGenerateImage/DynamicImage/Test1.jpg";*/
        String[][] textConent = {
                { "血压(非空腹) : 6.0mmol/L", "时间: 2017年9月16日 10:52", "正常" },
                { "血压(非空腹) : 13.0mmol/L", "时间: 2017年9月16日 15:47", "过高" },
                { "血压(非空腹) : 6.3mmol/L", "时间: 2017年9月16日 16:13", "正常" } ,
                { "血压(非空腹) : 6.6mmol/L", "时间: 2017年9月17日 10:24", "正常" },
                { "血压(非空腹) : 15.1mmol/L", "时间: 2017年9月17日 11:10", "过高" } };
        int x = 150;
        int y = 540;
        try {
            BuildPicture.generateImage(inPath, outPath, textConent, ImageIO.read(ResourceUtils.getFile("classpath:static/images/miaomiaonew.png")), font, x, y);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "ok";
    }



}
