package net.moriaritys.timeout.server.spring;

import net.customware.gwt.dispatch.server.*;
import net.customware.gwt.dispatch.server.appengine.AppEngineSecureSessionValidator;
import net.customware.gwt.dispatch.server.secure.SecureSessionValidator;
import net.customware.gwt.dispatch.server.spring.SpringDispatch;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 *
 */
@Configuration
public class TimeoutSpringConfig implements ApplicationContextAware {
    private ApplicationContext context;

    @Bean
    public SecureSessionValidator sessionValidator() {
        return new AppEngineSecureSessionValidator();
    }

    @Bean
    public ActionHandlerRegistry actionHandlerRegistry() {
        InstanceActionHandlerRegistry registry = new DefaultActionHandlerRegistry();

        Map<String, ActionHandler> handlers = context.getBeansOfType(ActionHandler.class);
        for (final ActionHandler handler : handlers.values()) {
            registry.addHandler(handler);
        }

        return registry;
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
