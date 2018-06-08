package mspring4.S_5_1;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * AbstractAnnotationConfigDispatcherServletInitializer需要添加spring-webmvc-4.3.16.RELEASE.jar这个包
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //此方发导致tomcat服务器无法启动
    //当返回null,或者new Class[0]时,tomcat服务器正常启动
    //返回 new Class[]{RootConfig.class};是则无法启动
    @Override
    protected Class<?>[] getRootConfigClasses() {
//        return new Class[]{null};
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
