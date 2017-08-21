package com.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by wb.zhengcheng on 2017/8/17.
 */
@Controller
public class WebController {

    @RequestMapping("/")
    public String home(Map<String,Object> map) {
        map.put("hello","from TemplateController.helloHtml");
        return "login";
    }
}
