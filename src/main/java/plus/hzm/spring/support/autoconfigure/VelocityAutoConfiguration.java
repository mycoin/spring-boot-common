package plus.hzm.spring.support.autoconfigure;

import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;

import plus.hzm.spring.support.velocity.VelocityEngineFactory;
import plus.hzm.spring.support.velocity.VelocityEngineFactoryBean;
import plus.hzm.spring.support.velocity.VelocityEscapeEventHandler;
import plus.hzm.spring.support.velocity.VelocityViewResolver;

@Configuration
@ConditionalOnClass({ VelocityEngine.class, VelocityEngineFactory.class })
@AutoConfigureAfter(name = {
        "org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration",
        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration"
})
@EnableConfigurationProperties(VelocityProperties.class)
public class VelocityAutoConfiguration {
    private final VelocityProperties properties;

    public VelocityAutoConfiguration(VelocityProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean
    public VelocityEngineFactoryBean velocityConfiguration() {
        VelocityEngineFactoryBean bean = new VelocityEngineFactoryBean();
        Map<String, Object> velocityPropertiesMap = new HashMap<String, Object>();
        velocityPropertiesMap.put(Velocity.ENCODING_DEFAULT, "UTF-8");
        velocityPropertiesMap.put(Velocity.INPUT_ENCODING, "UTF-8");
        velocityPropertiesMap.put(Velocity.VM_LIBRARY, "macros.vm");
        velocityPropertiesMap.put(Velocity.EVENTHANDLER_REFERENCEINSERTION, VelocityEscapeEventHandler.class.getName());

        bean.setResourceLoaderPath(properties.getResourceLoaderPath());
        bean.setVelocityPropertiesMap(velocityPropertiesMap);

        return bean;
    }

    @Bean
    @ConditionalOnMissingBean(name = "velocityViewResolver")
    @ConditionalOnProperty(name = "spring.velocity.enabled", matchIfMissing = true)
    public VelocityViewResolver velocityViewResolver() {
        VelocityViewResolver resolver = new VelocityViewResolver();
        resolver.setPrefix(properties.getPrefix());
        resolver.setSuffix(properties.getSuffix());
        resolver.setOrder(Ordered.HIGHEST_PRECEDENCE + 100);
        return resolver;
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnEnabledResourceChain
    public ResourceUrlEncodingFilter resourceUrlEncodingFilter() {
        return new ResourceUrlEncodingFilter();
    }
}
