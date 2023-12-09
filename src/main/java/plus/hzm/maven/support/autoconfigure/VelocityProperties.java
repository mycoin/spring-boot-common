package plus.hzm.maven.support.autoconfigure;

import org.springframework.boot.autoconfigure.template.AbstractTemplateViewResolverProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@ConfigurationProperties(prefix = "spring.velocity")
@Data
@EqualsAndHashCode(callSuper = false)
public class VelocityProperties extends AbstractTemplateViewResolverProperties {
    public static final String DEFAULT_LAYOUT = "layout.vm";
    public static final String DEFAULT_RESOURCE_LOADER_PATH = "classpath:/templates/";
    public static final String DEFAULT_PREFIX = "";
    public static final String DEFAULT_SUFFIX = ".vm";

    public VelocityProperties() {
        super(DEFAULT_PREFIX, DEFAULT_SUFFIX);
    }

    private String resourceLoaderPath = DEFAULT_RESOURCE_LOADER_PATH;
    private String layoutUrl = DEFAULT_LAYOUT;
}
