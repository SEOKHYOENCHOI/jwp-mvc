package nextstep.mvc.tobe;

import nextstep.mvc.tobe.view.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public enum RequestContextKey {
    REQUEST(HttpServletRequest.class.getName(), HttpServletRequest.class),
    RESPONSE(HttpServletResponse.class.getName(), HttpServletResponse.class),
    MODEL(Model.class.getName(), Model.class);

    private String key;
    private Class<?> type;

    RequestContextKey(String key, Class<?> type) {
        this.key = key;
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public Class<?> getType() {
        return type;
    }

    public static boolean hasType(Class<?> type) {
        return Arrays.stream(values())
                .anyMatch(requestContextKey -> type.isAssignableFrom(requestContextKey.type));
    }
}