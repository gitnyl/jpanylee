package com.jpanylee.common.filter;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CorsFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        /*
            Access-Control-Allow-Orgin     요청을 보내는 페이지의 출처 [ *, 도메인 ]
            Access-Control-Allow-Methods   요청을 허용하는 메소드. Default : GET, POST, HEAD
            Access-Control-Max-Age         클라이언트에서 preflight의 요청 결과를 저장할 시간 지정. 해당 시간 동안은 pre-flight를 다시 요청하지 않는다.
            Access-Control-Allow-Headers   요청을 허용하는 헤더
        */
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;


        String origin = req.getHeader("Origin");
        res.setHeader("Access-Control-Allow-Origin", "*");
        // res.setHeader("Access-Control-Allow-Origin", StringUtils.isBlank(origin) ? "" : origin);
        res.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        res.setHeader("Access-Control-Max-Age", "3600");
        res.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, Origin, X-Requested-With, Authorization");
        res.setHeader("Access-Control-Expose-Headers", "X-Auth-Token, Authorization, expire_token");
        res.setHeader("Access-Control-Allow-Credentials", "true");

        if (req.getMethod().equals("OPTIONS")) {
            res.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        chain.doFilter(request, response);
    }

}
