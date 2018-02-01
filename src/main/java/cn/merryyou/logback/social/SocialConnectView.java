package cn.merryyou.logback.social;

import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created on 2018/1/11 0011.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class SocialConnectView extends AbstractView {
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String msg = "";
        response.setContentType("text/html;charset=UTF-8");
        if (model.get("connections") == null) {
            msg = "unBindingSuccess";
//            response.getWriter().write("<h3>解绑成功</h3>");
        } else {
            msg = "bindingSuccess";
//            response.getWriter().write("<h3>绑定成功</h3>");
        }

        response.sendRedirect("/message/" + msg);
    }
}
