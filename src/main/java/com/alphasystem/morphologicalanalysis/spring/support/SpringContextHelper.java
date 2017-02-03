package com.alphasystem.morphologicalanalysis.spring.support;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ServiceLoader;

/**
 * @author sali
 */
public abstract class SpringContextHelper {

    private static SpringContextHelper instance;

    public static synchronized SpringContextHelper getInstance() {
        if (instance == null) {
            ServiceLoader<SpringContextHelper> serviceLoader = ServiceLoader.load(SpringContextHelper.class);
            System.out.println(serviceLoader);
            for (SpringContextHelper aServiceLoader : serviceLoader) {
                System.out.println("{{{{{{{{{{{{{{{{{{{{{{{{{{{{ " + aServiceLoader);
                instance = aServiceLoader;
                if (instance != null) {
                    break;
                }
            }
        }
        if (instance == null) {
            System.out.println("HERE");
            instance = new DefaultSpringContextHelper();
        }
        return instance;
    }

    SpringContextHelper(Class<?>[] configClasses) {
        if (ArrayUtils.isEmpty(configClasses)) {
            throw new RuntimeException("No configuration classes provided to start Spring context.");
        }
        SpringApplicationContextAwareImpl.getInstance().setApplicationContext(new AnnotationConfigApplicationContext(configClasses));
    }

}
