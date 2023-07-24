package com.spring.weather.web;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LatLngController {

    private static final String API_KEY = "32593d19320cc716add753919db4f411";
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather?lat=%.6f&lon=%.6f&appid=%s&units=metric";

    static class LatLng {
        private double latitude;
        private double longitude;

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }
    }

    @PostMapping("/end-point")
    public ResponseEntity<String> handleRequest(@RequestBody LatLng latLng) {
        System.out.println("Latitude: " + latLng.getLatitude() + ", Longitude: " + latLng.getLongitude());

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        String apiUrl = String.format(API_URL, latLng.getLatitude(), latLng.getLongitude(), API_KEY);
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);

        // 가져온 날씨 정보를 콘솔에 출력합니다.
        System.out.println(response.getBody());

        // 날씨 정보를 MediaType.APPLICATION_JSON 타입으로 반환합니다.
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response.getBody());
    }
}
