package id.rnd.websocket.socketapi;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class RestTemplateSkipSLL {

    @Autowired
    private RestTemplate restTemplate;

    private String clientId = "94208089503393615312";
    private String clientSecret = "7A073A938A049395D6AEBDDD6E18A66D";
    private String grantType = "client_credentials";
    private String url = "https://10.243.128.18:443/prweb/PRRestService/oauth2/v1/token";

    @SneakyThrows
    @PostConstruct
    public void execute(){
        log.info("execute api los pega");
        String payload =
                "client_id=" + clientId +
                "&client_secret=" + clientSecret +
                "&grant_type=" + grantType;

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        SLLUtil.turnOffCertificate();
        HttpEntity<MultiValueMap<String, Object>> request = new
                HttpEntity(payload, httpHeaders);

        ResponseEntity<String> responseData = restTemplate
                .exchange(url,
                        HttpMethod.POST,
                        request,
                        String.class);

        log.info("response data = {} ",responseData.getBody());
    }
}
