package plus.hzm.maven.support.velocity;

import org.springframework.web.servlet.view.AbstractTemplateViewResolver;

public class VelocityViewResolver extends AbstractTemplateViewResolver {

    public VelocityViewResolver() {
        setViewClass(requiredViewClass());
    }

    @Override
    protected Class<?> requiredViewClass() {
        return VelocityView.class;
    }
}
