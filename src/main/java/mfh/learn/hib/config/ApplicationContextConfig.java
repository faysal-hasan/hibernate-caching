package mfh.learn.hib.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration

@ComponentScan("mfh.learn.hib.*")
public class ApplicationContextConfig {

    /* The jsp view resolver is spring built-in view resolver, it will return jsp pages saved in webapp/WEB-INF/views folder.
     * The Controller's RequestMapping method returned string will be the jsp file name.
     * And spring will use the return string to build the jsp page file path with below format webapp/WEB-INF/views/return_string.jsp
     * */
    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        // The prefix of the Controller's RequestMapping method returned string.
        viewResolver.setPrefix("/WEB-INF/pages/");
        // The suffix of the Controller's RequestMapping method returned string.
        viewResolver.setSuffix(".jsp");
        viewResolver.setOrder(1);

        return viewResolver;
    }
}