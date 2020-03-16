package com.cloud.blog.gateway.filter;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * @author luok
 * @date 2020年02月26日15:58:38
 */
@Slf4j
@Component
public class AuthGatewayFilter implements GatewayFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        String path = request.getURI().getPath().toString();
        HttpMethod method = request.getMethod();
        log.info("请求类型: {} , 路径: {}",method.name(),path);
        String jwt = request.getHeaders().getFirst("Authorization");
        if (jwt == null ) {
            if (path.startsWith("/blog")){
                return chain.filter(exchange);
            }
            DataBuffer dataBuffer = apiResult(response, -1, "非法请求！");
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
            log.info("权限验证未通过！");
            return response.writeWith(Mono.just(dataBuffer));
        }
        return chain.filter(exchange);
    }

    private DataBuffer apiResult(ServerHttpResponse response, int code, String message) {
        HashMap<String, String> result = new HashMap<>();
        result.put("code", String.valueOf(code));
        result.put("message", message);
        byte[] datas = JSON.toJSONString(result).getBytes(StandardCharsets.UTF_8);
        return response.bufferFactory().wrap(datas);
    }

    @Override
    public int getOrder() {
        return -1;
    }

}
