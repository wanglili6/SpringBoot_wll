package com.wll.itdream.wll_sping.controller;

import com.wll.itdream.wll_sping.dao.TestRepository;
import com.wll.itdream.wll_sping.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    TestRepository testRepository;

    @RequestMapping("/wll_text")
    public String index() {
        return "经费公开的结果";
    }

    @RequestMapping("/test")
    public List<Test> testList() {
        return testRepository.findAll();
    }
}
