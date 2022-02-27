package org.jeff.controller;

import org.jeff.common.ServerResponse;
import org.jeff.pojo.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jeff
 * @since 1.0.0
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public ServerResponse testMethod(String name,Example example){
        return ServerResponse.success();
    }
}
