package in.reqres.api.convert.json.string.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "request-rest-config")
public class RequestResConfigData {

    private String urlRequest;

    public RequestResConfigData() {
    }

    public String getUrlRequest() {
        return urlRequest;
    }

    public void setUrlRequest(String urlRequest) {
        this.urlRequest = urlRequest;
    }
}
