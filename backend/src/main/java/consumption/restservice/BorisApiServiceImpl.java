package consumption.restservice;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;


import java.util.Map;

@Service
public class BorisApiServiceImpl implements BorisApiService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${boris.token.secret}")
    private String Token;

    @Override
    public String fetchBorisApiData(Map<String, String> requestPayload) {
        try {
            String externalApiUrl = "https://conso.boris.sh/api";
            String externalToken = Token;
            HttpHeaders headers = new HttpHeaders();
                        headers.set("Authorization", "Bearer " + externalToken);
                        headers.set("User-Agent", "github.com/real-consumption-comparator");
            
            HttpEntity<Map<String, String>> entity = new HttpEntity<>(requestPayload, headers);
            
            ResponseEntity<String> response = restTemplate.exchange(externalApiUrl, HttpMethod.POST, entity, String.class);

            return response.getBody();
        } catch (Exception e) {
            return "Error fetching data from external API: " + e.getMessage();
        }
    }
    //  private String getBorisToken() {
    //     // Im lazy mofo - So right now a hardcoded token will do
    //     return Token;
    // }
}
