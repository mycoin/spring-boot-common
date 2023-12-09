package plus.hzm.spring.support.velocity;

import org.apache.velocity.app.event.ReferenceInsertionEventHandler;
import org.apache.velocity.context.Context;
import org.springframework.web.util.HtmlUtils;

public class VelocityEscapeEventHandler implements ReferenceInsertionEventHandler {
    public static final String UNSAFE_REF_NAME = "literalUnsafe";

    @Override
    public Object referenceInsert(Context context, String reference, Object value) {
        if (value == null || !(value instanceof String)) {
            return value;
        }
        if (reference.contains(UNSAFE_REF_NAME)) {
            return value;
        }
        return HtmlUtils.htmlEscape(value.toString());
    }
}