package org.jeff.hello;

import org.jeff.common.ServerResponse;
import org.jeff.enums.ResponseCodeEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jeff
 * @since 1.0.0
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/hi")
    public String hello() {
        return "hello micro service: what's your name " ;
    }

    @GetMapping("/success")
    public ServerResponse success() {
        return ServerResponse.success("hello micro service");
    }

    @GetMapping("/failure")
    public ServerResponse failure() {
        return ServerResponse.failure(ResponseCodeEnum.SYSTEM_ERROR.getStatus(), ResponseCodeEnum.SYSTEM_ERROR.getMessage());
    }


}
