/*
 * Copyright (c) 2016-2017, Guangshan (guangshan1992@qq.com) and the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mxixm.fastboot.weixin.annotation.*;
import com.mxixm.fastboot.weixin.module.event.WxEvent;
import com.mxixm.fastboot.weixin.module.message.*;
import com.mxixm.fastboot.weixin.module.user.WxUser;
import com.mxixm.fastboot.weixin.module.web.WxRequest;
import com.mxixm.fastboot.weixin.module.web.WxRequestBody;
import com.mxixm.fastboot.weixin.module.web.session.WxSession;
import com.zm.model.User;
import com.zm.servic.UserExService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * FastBootWeixin WxApp
 *
 * @author Guangshan
 * @date 2017/09/21 23:47
 * @since 0.1.2
 */
@WxApplication(menuAutoCreate = false)
@WxController
public class WxApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(WxApp.class);

    @Autowired
    private UserExService userExService;

//    public static void main(String[] args) throws Exception {
//        SpringApplication.run(WxApp.class, args);
//    }

    /**
     * 接受微信事件
     *
     * @param wxRequest
     * @param wxUser
     */
    @WxEventMapping(type = WxEvent.Type.SUBSCRIBE)
    public String subscribe(WxRequest wxRequest, WxUser wxUser) {
        return "欢迎您关注本公众号，本公众号使用FastBootWeixin框架开发，简单极速开发微信公众号，你值得拥有";
    }

    @WxMessageMapping(type = WxMessage.Type.IMAGE)
    public WxMessage news22(WxRequest wxRequest, WxSession wxSession) {
//        return WxMessage.News.builder()
//                .addItem("测试图文消息2", "测试", "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/logo_white.png", "http://mxixm.com")
//                .build();

        try {
            Iterator<String> i = wxSession.getAttributeNames();
            while (i.hasNext()) {
                System.out.println("属性:" + wxSession.getAttribute(i.next()));
            }

            Enumeration<String> i2 = wxRequest.getAttributeNames();
            while (i2.hasMoreElements()) {
                System.out.println("属性2" + wxSession.getAttribute(i2.nextElement()));
            }

//            LOGGER.info("wxRequest请求: {}", JSONObject.toJSONString(wxRequest));
//            LOGGER.info("wxSession响应: {}", JSONObject.toJSONString(wxSession));
//            System.out.print(JSONObject.toJSONString(wxRequest));
//            System.out.print(JSONObject.toJSONString(wxSession));
        } catch (Exception e) {
            LOGGER.error("转换出错!");
            LOGGER.error(e.getMessage(), e);
            try {
                User userEx = new User();
                userEx.setName("差多少分");
                userEx.setId(132L);
                String json2 = JSONObject.toJSONString(userEx);
                String json3 = JSON.toJSONString(userEx);
                userExService.insertWeiXin(json2);
                userExService.insertWeiXin(json3);
                LOGGER.info("json2: {}", json2);
                LOGGER.info("json3: {}", json3);
                System.out.print(json2);
                System.out.print(json3);
            } catch (Exception e2) {
                LOGGER.error("转换出错2!");
                LOGGER.error(e2.getMessage(), e2);
            }
        }



        return WxMessage.imageBuilder()
//                .mediaUrl("http://www.uimaker.com/uploads/allimg/130216/1_130216120816_1.png")
                .mediaUrl("images/miaomiao.png")
                .build();

//        String shareFileName="";
//         try {
//             InputStream is = null;
//             is = new FileInputStream("images/miaomiao.png");
//
//             //通过JPEG图象流创建JPEG数据流解码器
//             JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
//             //解码当前JPEG数据流，返回BufferedImage对象
//             BufferedImage buffImg = null;
//             try {
//                 buffImg = jpegDecoder.decodeAsBufferedImage();
//             } catch (IOException e1) {
//                 e1.printStackTrace();
//             }
//             //得到画笔对象
//             Graphics g = buffImg.getGraphics();
//
//             //创建你要附加的图象。
//             //小图片的路径
//             ImageIcon imgIcon = new ImageIcon("喵");
//
//             //得到Image对象。
//             Image img = imgIcon.getImage();
//
//             //将小图片绘到大图片上。
//             //5,300 .表示你的小图片在大图片上的位置。
//             g.drawImage(img, 400, 15, null);
//
//             //设置颜色。
//             g.setColor(Color.BLACK);
//
//
//             //最后一个参数用来设置字体的大小
//             Font f = new Font("宋体", Font.PLAIN, 25);
//             Color mycolor = Color.red;//new Color(0, 0, 255);
//             g.setColor(mycolor);
//             g.setFont(f);
//
//             //10,20 表示这段文字在图片上的位置(x,y) .第一个是你设置的内容。
//             g.drawString("喵", 100, 135);
//
//             g.dispose();
//
//
//             OutputStream os;
//
//             //os = new FileOutputStream("d:/union.jpg");
////             String shareFileName = "\\upload\\" + System.currentTimeMillis() + ".jpg";
//             shareFileName = "images/" + System.currentTimeMillis() + ".jpg";
//             os = new FileOutputStream(shareFileName);
//             //创键编码器，用于编码内存中的图象数据。
//             JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
//             is.close();
//             os.close();
//         } catch (Exception e) {
//             return WxMessage.imageBuilder().mediaUrl("images/miaomiao.jpg").build();
//         }
//        return WxMessage.imageBuilder().mediaUrl(shareFileName).build();

    }





    /**
     * 接受用户文本消息，异步返回文本消息
     *
     * @param content
     * @return dummy
     */
    @WxMessageMapping(type = WxMessage.Type.TEXT)
    @WxAsyncMessage
    public String text(WxRequest wxRequest, String content) {
        LOGGER.info("wxRequest: {}", wxRequest);
        System.out.print(wxRequest);
        WxSession wxSession = wxRequest.getWxSession();
        System.out.print(wxSession);
        LOGGER.info("wxSession: {}", wxSession);
        if (wxSession != null && wxSession.getAttribute("last") != null) {
            return "上次收到消息内容为" + wxSession.getAttribute("last");
        }
        return "收到消息内容为" + content;
    }

    /**
     * 接受用户文本消息，同步返回图文消息
     *
     * @param content
     * @return dummy
     */
    @WxMessageMapping(type = WxMessage.Type.TEXT, wildcard = "1*")
    public String message(WxSession wxSession, String content) {
        wxSession.setAttribute("last", content);
        return "收到文本内容为" + content;
    }

    /**
     * 接受用户文本消息，异步返回文本消息
     *
     * @param content
     * @return dummy
     */
    @WxMessageMapping(type = WxMessage.Type.TEXT, wildcard = "2*")
    @WxAsyncMessage
    public String text2(WxRequestBody.Text text, String content) {
        boolean match = text.getContent().equals(content);
        return "收到消息内容为" + content + "!结果匹配！" + match;
    }

//    /**
//     * 接受用户文本消息，异步返回文本消息
//     *
//     * @param content
//     * @return dummy
//     */
//    @WxMessageMapping(type = WxMessage.Type.TEXT)
//    public String text(WxRequest wxRequest, String content) {
////        WxMessage.imageBuilder();
//        WxSession wxSession = wxRequest.getWxSession();
//        return "收到消息内容为" + content;
//    }




    /**
     * 定义微信菜单
     */
    @WxButton(group = WxButton.Group.LEFT, main = true, name = "左")
    public void left() {
    }

    /**
     * 定义微信菜单
     */
    @WxButton(group = WxButton.Group.RIGHT, main = true, name = "右")
    @WxAsyncMessage
    public String right(WxUser wxUser) {
        return wxUser.getNickName() + "haha";
    }

    /**
     * 定义微信菜单，并接受事件
     */
    @WxButton(type = WxButton.Type.CLICK,
            group = WxButton.Group.LEFT,
            order = WxButton.Order.FIRST,
            name = "文本消息")
    public WxMessage leftFirst(WxRequest wxRequest, WxUser wxUser) {
        return WxMessage.Text.builder().content("测试文本消息").build();
    }

    /**
     * 定义微信菜单，并接受事件
     */
    @WxButton(type = WxButton.Type.VIEW,
            group = WxButton.Group.LEFT,
            order = WxButton.Order.SECOND,
            url = "http://vxyufx.natappfree.cc/wx/test",
            name = "点击链接")
    @WxAsyncMessage
    public WxMessage link(WxRequest wxRequest) {
        return WxMessage.Text.builder().content("点击了菜单链接").build();
    }

    /**
     * 定义微信菜单，并接受事件
     */
    @WxButton(type = WxButton.Type.CLICK,
            group = WxButton.Group.LEFT,
            order = WxButton.Order.THIRD,
            name = "图文消息")
    public WxMessage news() {
        return WxMessage.News.builder()
                .addItem("测试图文消息", "测试", "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/logo_white.png", "http://mxixm.com")
                .addItem("测试图文消息", "测试", "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/logo_white.png", "http://smc24f.natappfree.cc/vendor/82")
                .addItem("测试图文消息", "测试", "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/logo_white.png", "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx2a0e54054e2fb7c0&redirect_uri=http://smc24f.natappfree.cc/vendor/82&response_type=code&scope=snsapi_base&state#wechat_redirect")
                .build();
    }

    /**
     * 定义微信菜单，并接受事件
     */
    @WxButton(type = WxButton.Type.CLICK,
            group = WxButton.Group.LEFT,
            order = WxButton.Order.FORTH,
            name = "图片消息")
    public WxMessage imgae() {
        return WxMessage.imageBuilder()
                .mediaUrl("http://www.uimaker.com/uploads/allimg/130216/1_130216120816_1.png")
                .build();
    }

    /**
     * 接受微信事件
     *
     * @param wxRequest
     * @param wxUser
     */
    @WxEventMapping(type = WxEvent.Type.UNSUBSCRIBE)
    public void unsubscribe(WxRequest wxRequest, WxUser wxUser) {
        System.out.println(wxUser.getNickName() + "退订了公众号");
    }

    /**
     * 接受微信事件
     *
     */
    @WxEventMapping(type = WxEvent.Type.LOCATION)
    public WxMessage location(WxRequestBody.LocationReport location) {
        return WxMessage.News.builder()
                .addItem("接受到您的地理位置", "测试", "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/logo_white.png", "http://mxixm.com")
                .addItem("纬度" + location.getLatitude(), "测试", "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/logo_white.png", "http://smc24f.natappfree.cc/vendor/82")
                .addItem("经度" + location.getLongitude(), "测试", "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/logo_white.png", "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx2a0e54054e2fb7c0&redirect_uri=http://smc24f.natappfree.cc/vendor/82&response_type=code&scope=snsapi_base&state#wechat_redirect")
                .build();
    }


    /**
     * 接受微信事件
     *
     * @param wxUser
     */
    @WxEventMapping(type = WxEvent.Type.TEMPLATESENDJOBFINISH)
    public void template(WxRequestBody.Template template, WxUser wxUser) {
        // 模板消息发送完成的回调
        System.out.println(template.toString());
    }


    @WxMessageMapping(type = WxMessage.Type.TEXT, wildcard = "群发*")
    @WxAsyncMessage
    public WxMessage groupMessage(String content) {
        String tagId = content.substring("群发".length());
        return WxMessage.Text.builder().content("pKS9_xJ6hvk4uLPOsHNPmnVRw0vE").toGroup(Integer.parseInt(tagId)).build();
    }


}