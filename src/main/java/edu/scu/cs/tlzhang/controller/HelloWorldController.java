package edu.scu.cs.tlzhang.controller;

import com.alibaba.fastjson.JSONObject;
import edu.scu.cs.tlzhang.service.KRoomCommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tlzhang on 16-11-11.
 */

@Controller
@RequestMapping("/SpringMVC")
public class HelloWorldController {

    @Resource
    private KRoomCommentService kRoomCommentService;
    @ResponseBody
    @RequestMapping("/helloWorld")
    public String helloWorld(String str){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", str);
//        throw new RuntimeException("In vain");
        return jsonObject.toString();
    }

}
