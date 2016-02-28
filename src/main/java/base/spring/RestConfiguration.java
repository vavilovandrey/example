package base.spring;

import base.controller.AssetController;
import base.controller.impl.AssetControllerImpl;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ext.RuntimeDelegate;
import java.util.Arrays;

@Configuration
public class RestConfiguration {

    @Bean( destroyMethod = "shutdown" )
    public SpringBus cxf() {
        return new SpringBus();
    }

    @Bean
    public Server jaxRsServer() {
        JAXRSServerFactoryBean factory = RuntimeDelegate.getInstance().createEndpoint( jaxRsApiApplication(), JAXRSServerFactoryBean.class );
        factory.setServiceBeans( Arrays.< Object >asList(assetController()));
        factory.setAddress( "/" + factory.getAddress() );
        factory.setProviders( Arrays.< Object >asList(jsonProvider()));
        return factory.create();
    }

    @Bean
    public JaxRsApplication jaxRsApiApplication() {
        return new JaxRsApplication();
    }

    @Bean
    public AssetController assetController() {
        return new AssetControllerImpl();
    }

    @Bean
    public JacksonJsonProvider jsonProvider() {
        return new JacksonJsonProvider();
    }

}
