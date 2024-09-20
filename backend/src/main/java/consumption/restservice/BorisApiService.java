package consumption.restservice;

import java.util.Map;

public interface BorisApiService {
    String fetchBorisApiData(Map<String, String> requestPayload);
    // String getBorisToken(Map<String, String> requestPayload);
}