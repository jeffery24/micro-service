package org.jeff.wx.controller;

import org.jeff.wx.domain.dto.WxParameterDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jeff
 * @since 1.0.0
 */
@RestController
public class HellosController {

    @PostMapping("test")
    public String get(@RequestBody WxParameterDTO wxParameterDTO) {

        return "hello";
    }
}
