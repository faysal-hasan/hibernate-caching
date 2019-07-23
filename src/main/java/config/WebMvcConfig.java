package config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan("java.*")
public class WebMvcConfig implements WebMvcConfigurer {

    // the followings are overriden method.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    /* messageSource bean is spring built-in bean name which will manipulate internationalization messages.
     * All message files is saved in src/main/resources/i18n/ folder, if the config folder do not exist, you need to create it first by hand.
     * Each message file is a properties file, the file base name is messages and suffix with the language or country ISO code, such as messages_en, messages_zh_cn etc.
     * */

    @Bean(name = "messageSource")
    public MessageSource getMessageResource() {
        ReloadableResourceBundleMessageSource messageResource = new ReloadableResourceBundleMessageSource();

        // Read i18n/messages_xxx.properties file.
        // For example: i18n/messages_en.properties

// Set the base name for the messages properties file.
        messageResource.setBasename("classpath:i18n/messages");
        messageResource.setDefaultEncoding("UTF-8");
        messageResource.setCacheSeconds(1);
        messageResource.setUseCodeAsDefaultMessage(true);
        return messageResource;
    }


    /* The localeResolver is used to resolve user locale data. The CookieLocaleResolver object is used to save user locale information in browser cookie.
     * This way user locale info can be transferred between request. If user disable cookie then you can use SessionLocaleResolver instead. */
    @Bean(name = "localeResolver")
    public CookieLocaleResolver getCookieLocaleResolver() {
        // Create a CookieLocaleResolver object.
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        // Set cookie name
        localeResolver.setCookieName("cookie-locale-info");
        // Set default locale value.
        localeResolver.setDefaultLocale(Locale.ENGLISH);
        // Set cookie max exist time.
        localeResolver.setCookieMaxAge(3600);

        return localeResolver;
    }

    //  If user disable cookie then you can use SessionLocaleResolver instead.
    @Bean(name = "localeResolver")
    public SessionLocaleResolver getSessionLocaleResolver() {
        // Create a SessionLocaleResolver object.
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        // Set default locale in session.
        localeResolver.setDefaultLocale(Locale.ENGLISH);
        return localeResolver;
    }

    /*
    *
    *
    *
    * Note-
           If you do not register any “localeResolver”, the default AcceptHeaderLocaleResolver will be used,
    which resolves the locale by checking the accept-language header in the HTTP request.
    * */


    /* The LocaleChangeInterceptor is a interceptor that will intercept user locale change by a parameter value.
     * For example, if we set the locale change parameter name is locale, then request url http://localhost:8088/index.jsp?locale=en will change
     * user locale to en and display messages in src/main/resources/config/messages_en.properties.
     *  */
    @Bean(name = "localeInterceptor")
    public LocaleChangeInterceptor getLocaleInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        return interceptor;
    }

    /* Also need to register above locale interceptor in spring then it will intercept user request url and parse out the lang query string to get user request locale.*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLocaleInterceptor());
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(getMessageResource());
        return bean;
    }

    @Override
    public Validator getValidator() {
        return validator();
    }

}