package com.spring.weather.web;

import com.nimbusds.jose.shaded.json.JSONObject;
import com.nimbusds.jose.shaded.json.parser.JSONParser;
import com.nimbusds.jose.shaded.json.parser.ParseException;
import com.spring.weather.sevice.ListsService;
import com.spring.weather.web.dto.ListsSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Map;

@RestController
public class LatLngController {

    @Autowired
    ListsService listsService;

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
    public ResponseEntity<String> handleRequest(@RequestBody LatLng latLng) throws ParseException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        String apiUrl = String.format(API_URL, latLng.getLatitude(), latLng.getLongitude(), API_KEY);

        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);

        // JSON 문자열을 파싱합니다.
        JSONParser parser = new JSONParser();
        JSONObject jsonObj = (JSONObject) parser.parse(response.getBody());

        // 지역 이름을 추출합니다.
        String cityName = (String) jsonObj.get("name");

        // 온도 정보를 추출합니다.
        JSONObject main = (JSONObject) jsonObj.get("main");
        double temperature = (double) main.get("temp");

        // 로그인된 사용자의 이메일을 가져옵니다.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        String email="";
        if (principal instanceof OAuth2User) {
            OAuth2User oauth2User = (OAuth2User) principal;
            Map<String, Object> userAttributes = oauth2User.getAttributes();

            if (authentication instanceof OAuth2AuthenticationToken) {
                OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
                String registrationId = oauthToken.getAuthorizedClientRegistrationId();

                if ("kakao".equalsIgnoreCase(registrationId)) {
                    Map<String, Object> kakaoAccount = (Map<String, Object>) userAttributes.get("kakao_account");
                    email = (String) kakaoAccount.get("email");
                } else if ("naver".equalsIgnoreCase(registrationId)) {
                    email = (String) userAttributes.get("email");
                } else if ("google".equalsIgnoreCase(registrationId)) {
                    email = (String) userAttributes.get("email");
                }
            }
        } else {
            email = principal.toString(); // 또는 이 경우에 대한 적절한 처리가 필요합니다.
        }

        // 가져온 지역 이름과 날씨 정보를 저장합니다.
        ListsSaveRequestDto requestDto = new ListsSaveRequestDto(email, cityName, Double.toString(temperature));
        listsService.save(requestDto);

        // 모든 날씨 정보를 웹 페이지에 반환합니다.
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(jsonObj.toJSONString());
    }
}
