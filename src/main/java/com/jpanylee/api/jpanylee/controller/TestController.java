package com.jpanylee.api.jpanylee.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/get")
    public String test() {
        return "TEST~";
    }

    @ApiOperation(value = "sample", notes = "테스트")
    @GetMapping(value = "/test")
    public Map<String, String> SwaggerTest(@ApiParam(value = "번호", required = true, example = "1") @RequestParam String no) {
        Map<String, String> result = new HashMap<>();
        result.put("name", "ny");
        return result;
    }


}
