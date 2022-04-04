package com.zfx.community.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
//@Scope("prototype")
public class AlphaService {
    AlphaService() {
        System.out.println("实例化AlphaService");
    }

    @PostConstruct
    public void init() {
        System.out.println("AlphaService初始化");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("销毁AlphaService");
    }

}
