package pres.jeremy.alnilam.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import pres.jeremy.alnilam.constant.BaseConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class RequestUtil {

    public static HttpServletRequest getCurrentRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            return attributes.getRequest();
        }
        return null;
    }

    public static HttpServletResponse getCurrentResponse() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            return attributes.getResponse();
        }
        return null;
    }

    public static String getHeadValue(String key) {
        return Objects.requireNonNull(getCurrentRequest()).getHeader(key);
    }

    public static String getCurrentLanguage() {
        HttpServletRequest request = getCurrentRequest();
        if (request == null) {
            return BaseConstant.DEFAULT_LANGUAGE;
        }
        String language = request.getHeader("language");
        if (StringUtils.isEmpty(language)) {
            language = BaseConstant.DEFAULT_LANGUAGE;
        }
        return language;
    }
}
