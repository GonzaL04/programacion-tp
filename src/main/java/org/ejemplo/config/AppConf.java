package org.ejemplo.config;

import org.ejemplo.repository.*;
import org.ejemplo.validations.ClienteValidations;
import org.ejemplo.validations.ProductoValidations;
import org.ejemplo.validations.UserValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConf implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Bean
    public UserValidations userValidations() {
        return new UserValidations(usuarioRepository);
    }

    @Bean
    public ProductoValidations productoValidations() {
        return new ProductoValidations(productoRepository);
    }

    @Bean
    public ClienteValidations clienteValidations() {return new ClienteValidations(clienteRepository);}
}