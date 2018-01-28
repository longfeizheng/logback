package cn.merryyou.logback.session;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * session过期
 * Created on 2018/1/13 0013.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Slf4j
public class MerryyouExpiredSessionStrategy extends AbstractSessionStrategy implements SessionInformationExpiredStrategy {
    /**
     * @param invalidSessionUrl
     */
    public MerryyouExpiredSessionStrategy(String invalidSessionUrl) {
        super(invalidSessionUrl);
    }

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {

        onSessionInvalid(event.getRequest(), event.getResponse());
    }

    @Override
    protected boolean isConcurrency() {
        return true;
    }
}
