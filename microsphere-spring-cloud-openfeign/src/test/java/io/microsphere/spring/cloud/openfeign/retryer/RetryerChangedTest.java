package io.microsphere.spring.cloud.openfeign.retryer;

import feign.Retryer;
import io.microsphere.spring.cloud.openfeign.BaseTest;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author <a href="mailto:maimengzzz@gmail.com">韩超</a>
 * @since 1.0
 */
@SpringBootTest(classes = RetryerChangedTest.class)
@EnableAutoConfiguration
public class RetryerChangedTest extends BaseTest<Retryer> {

    @Override
    protected String afterTestComponentConfigKey() {
        return "spring.cloud.openfeign.client.config.my-client.retryer";
    }

    @Override
    protected Class<? extends Retryer> afterTestComponent() {
        return ARetry.class;
    }
}
