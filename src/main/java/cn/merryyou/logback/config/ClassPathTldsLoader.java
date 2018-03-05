package cn.merryyou.logback.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 2018/3/5.
 *
 * @author zlf
 * @since 1.0
 */
public class ClassPathTldsLoader {
    private static final String SECURITY_TLD = "/META-INF/security.tld";

    final private List<String> classPathTlds;

    public ClassPathTldsLoader(String... classPathTlds) {
        super();
        if(classPathTlds.length == 0){
            this.classPathTlds = Arrays.asList(SECURITY_TLD);
        }else{
            this.classPathTlds = Arrays.asList(classPathTlds);
        }
    }

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @PostConstruct
    public void loadClassPathTlds() {
        freeMarkerConfigurer.getTaglibFactory().setClasspathTlds(classPathTlds);
    }
}
