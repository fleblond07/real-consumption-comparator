package consumption.restservice;

import consumption.restservice.BorisApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/get_consumption")
public class BorisApiController {

    private final BorisApiService borisApiService;

    @Autowired
    public BorisApiController(BorisApiService borisApiService) {
        this.borisApiService = borisApiService;
    }

    @PostMapping("/fetch-data")
    public ResponseEntity<String> fetchBorisApiData(@RequestBody Map<String, String> requestPayload) {
        // Delegate the external API request logic to the service layer
        String response = borisApiService.fetchBorisApiData(requestPayload);

        // Return the response from the external API
        return ResponseEntity.ok(response);
    }
}
