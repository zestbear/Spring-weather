package com.spring.weather.domain;


public class GpsTracker {

    public static void main(String[] args) {
        // GPS 인스턴스 생성
        GPS gps = GPSFactory.getPlatform().createGPS();

        // GPS 시작
        gps.start();

        // GPS 정보 수신 대기
        while (!gps.hasFix()) {
            try {
                Thread.sleep(1000); // 1초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 현재 위치 정보 출력
        double latitude = gps.getLatitude();
        double longitude = gps.getLongitude();
        System.out.println("현재 위치 정보:");
        System.out.println("위도: " + latitude);
        System.out.println("경도: " + longitude);

        // GPS 종료
        gps.stop();
    }

}
