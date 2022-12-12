package com.revature.diningphilosophers.config;

import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.util.matcher.PathPatternParserServerWebExchangeMatcher;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebFluxSecurity
public class Config {

    @Bean
    SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) throws Exception {
         http
                 .securityMatcher(new PathPatternParserServerWebExchangeMatcher("/**"))
                .authorizeExchange((exchanges) -> exchanges
                        .anyExchange()
                                .permitAll()

//                        .authenticated()
                               // .permitAll()
                )
//                 .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                .httpBasic(withDefaults());



        return http.build();


//                .pathMatchers(HttpMethod.GET, "/posts/**").permitAll()
//                .pathMatchers(HttpMethod.DELETE, "/posts/**").hasRole("ADMIN")
                //.pathMatchers("/users/{user}/**").access(this::currentUserMatchesPath)

    }

    @Bean
    public MapReactiveUserDetailsService userDetailsService() {
        UserDetails user = User
//                .withDefaultPasswordEncoder()
//                .username("user")
                .withUsername("user")
                .password("user")
                .roles("USER")
                .build();
        return new MapReactiveUserDetailsService(user);
    }

//    @Bean
//    public JwtDecoder jwtDecoder() {
//        return NimbusJwtDecoder.withPublicKey(this.key).build();
//    }


//    @Bean
//    ConnectionFactoryInitializer initializer(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") ConnectionFactory connectionFactory) {
//
//        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
//        initializer.setConnectionFactory(connectionFactory);
////        initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
//
//        return initializer;
//    }

    @Bean
    public NettyReactiveWebServerFactory nettyReactiveWebServerFactory() {
    NettyReactiveWebServerFactory webServerFactory = new NettyReactiveWebServerFactory();
//        webServerFactory.getWebServer();
//        webServerFactory.addServerCustomizers(new EventLoopNettyCustomizer());
        return webServerFactory;
    }

//    @Bean
//    public ReactiveWebServerFactory nettyReactiveWebServerFactory(HttpHandler httpHandler) {
//        ReactiveWebServerFactory reactiveWebServerFactory = new ReactiveWebServerFactory();
//                reactiveWebServerFactory.getWebServer(httpHandler);
////        webServerFactory.getWebServer();
////        webServerFactory.addServerCustomizers(new EventLoopNettyCustomizer());
//        return reactiveWebServerFactory;
//    }
//
//    @Bean
//    public NettyContext nettyContext(ApplicationContext context) {
//        HttpHandler handler = WebHttpHandlerBuilder
//                .applicationContext(context).build();
//        ReactorHttpHandlerAdapter adapter
//                = new ReactorHttpHandlerAdapter(handler);
//        HttpServer httpServer = HttpServer.create("localhost", 8080);
//        return httpServer.newHandler(adapter).block();
//    }
}
