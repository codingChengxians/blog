package com.cloud.blog.auth.config;

import com.cloud.blog.auth.service.impl.SysAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SysAdminServiceImpl userDetailsService;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //表单申请令牌
        security.allowFormAuthenticationForClients()
                //url:/oauth/check_token allow check token 获取check token
//                .checkTokenAccess("isAuthenticated()")
                .checkTokenAccess("permitAll()")
                // 获取密钥需要身份认证，使用单点登录时必须配置  判断token 账户登录  token key
                .tokenKeyAccess("permitAll()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                /**
                 * 这个是github登陆
                 */
                .withClient("3d21b21b1c4498b465df")
                .secret("78f4d9bfeb1f75b8d7e7dc882c2176cd65945a45")
                .authorizedGrantTypes("authorization_code", "password", "refresh_token")
                //回调uri，在authorization_code与implicit授权方式时，用以接收服务器的返回信息
                .redirectUris("http://localhost:8080/oauth/redirect")
                // 允许的授权范围
                .scopes("all")
                .and()

                //--------------------------------------------------------------------两个模式分界线--------------------------------------------------------------------------------------------

                .withClient("client_password")
                //client secret
                .secret(new BCryptPasswordEncoder().encode("secret"))
                .authorizedGrantTypes("password", "refresh_token")
                .resourceIds("resource_password_id")
                .scopes("all")
                // 自动授权，无需人工手动点击 approve
//                .autoApprove(true)
                .accessTokenValiditySeconds(60 * 60 * 12)
                .refreshTokenValiditySeconds(60 * 60 * 24 * 10);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(
                Arrays.asList(tokenEnhancer(), accessTokenConverter()));

        endpoints
                //开启密码管理需要注入这个manager
                .authenticationManager(authenticationManager)
                //加载密码管理的user进去
                .userDetailsService(userDetailsService)
                .tokenStore(jwtTokenStore())
                //token增强
                .tokenEnhancer(tokenEnhancerChain)
                //token转换
                .accessTokenConverter(accessTokenConverter())
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
    }

    /**
     * 设置token 由Jwt产生，不使用默认的透明令牌
     */
    @Bean
    public JwtTokenStore jwtTokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    /**
     * 对Jwt签名时，增加一个密钥
     * JwtAccessTokenConverter：对Jwt来进行编码以及解码的类
     */
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        //对称加密
        converter.setSigningKey("oauth2-key");
        //非对称加密，jdk中有个keytool工具生成的
//        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("oauth2.jks"), "123456".toCharArray());
//        converter.setKeyPair(keyStoreKeyFactory.getKeyPair("oauth2"));
        return converter;
    }


    @Bean
    public TokenEnhancer tokenEnhancer() {
        return (accessToken, authentication) -> {
            Map<String, Object> additionalInfo = new HashMap<>(1);
            //添加id  和头像img路径
            additionalInfo.put("id", 74);
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
            return accessToken;
        };
    }


}
