package io.microsphere.spring.cloud.openfeign.components;

import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;
import org.springframework.cloud.context.named.NamedContextFactory;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.cloud.openfeign.FeignClientSpecification;

import java.lang.reflect.Type;

/**
 * @author <a href="mailto:maimengzzz@gmail.com">韩超</a>
 * @since 0.0.1
 */
public class DecoratedEncoder extends DecoratedFeignComponent<Encoder> implements Encoder {

    public DecoratedEncoder(String contextId, NamedContextFactory<FeignClientSpecification> contextFactory, FeignClientProperties clientProperties, Encoder delegate) {
        super(contextId, contextFactory, clientProperties, delegate);
    }

    @Override
    protected Class<Encoder> componentType() {
        Class<Encoder> encoderClass = null;
        if (getDefaultConfiguration() != null && getDefaultConfiguration().getEncoder() != null)
            encoderClass = getDefaultConfiguration().getEncoder();

        if (getCurrentConfiguration() != null && getCurrentConfiguration().getEncoder() != null)
            encoderClass = getCurrentConfiguration().getEncoder();

        if (encoderClass != null)
            return encoderClass;
        return Encoder.class;
    }

    @Override
    public void encode(Object object, Type bodyType, RequestTemplate template) throws EncodeException {
        delegate().encode(object, bodyType, template);
    }
}
