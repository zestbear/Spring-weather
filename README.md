# Spring-weather

📍사용자의 위치를 바탕으로 날씨 정보를 제공하는 서비스 구현 :
1. 카카오 지도 API 사용하기
2. Openweathermap API 사용하기
3. 네이버, 카카오, 구글 로그인 API 사용하기
4. DB 선정 —> Mongodb
5. AWS로 배포

<메인 화면>
- 날씨 컨셉에 맞게 배경색을 하늘색으로 설정
- 로그인 버튼 생성
<img width="1552" alt="스크린샷 2023-07-27 오후 3 12 14" src="https://github.com/zestbear/Spring-weather/assets/49549887/4510052d-b750-4980-8aab-a35ed5f32665">

<로그인 화면>
- 자체 로그인은 구현 X
- OAuth2을 사용하여 카카오, 네이버, 구글 연동 로그인 구현
<img width="1552" alt="스크린샷 2023-07-27 오후 3 12 20" src="https://github.com/zestbear/Spring-weather/assets/49549887/787d76cf-58e7-49b1-b59d-5ef647596448">

<로그인 후 메인 화면>
- OK 버튼을 누르면 날씨 확인 화면으로 이동
- Logout 버튼을 누르면 로그아웃 후 메인 화면으로 이동
<img width="1552" alt="스크린샷 2023-07-27 오후 3 12 28" src="https://github.com/zestbear/Spring-weather/assets/49549887/bda97b9b-c4e5-48c4-b33a-c3ea1dbabc3f">

<로그인 정보>
- MongoDB에 로그인 정보를 insert
<p align="center"><img width="816" alt="스크린샷 2023-07-31 오후 8 20 56" src="https://github.com/zestbear/Spring-weather/assets/49549887/86413b9b-5960-47fd-9ed4-2d85658fc842"></p>


<날씨 확인 화면>
- 지도를 클릭하면 위도와 경도의 값이 칸으로 넘어감
- Get Weather을 클릭하면 날씨 정보가 팝업 화면으로 뜸
<img width="1552" alt="스크린샷 2023-07-27 오후 3 12 45" src="https://github.com/zestbear/Spring-weather/assets/49549887/582f1490-33c4-4656-8e04-71491aa32d51">
<img width="1552" alt="스크린샷 2023-07-27 오후 3 13 28" src="https://github.com/zestbear/Spring-weather/assets/49549887/b5c208cd-35c4-4687-8f7e-085f1fa796d2">
<p align="center"><img width="512" alt="스크린샷 2023-07-27 오후 3 13 40" src="https://github.com/zestbear/Spring-weather/assets/49549887/a5cbebed-8214-475e-9259-74cfda36c3d4"></p>

<날씨 정보>
- MongoDB에 날씨 정보를 insert
<p align="center"><img width="816" alt="스크린샷 2023-07-31 오후 8 22 34" src="https://github.com/zestbear/Spring-weather/assets/49549887/731298c6-8285-4a31-82b5-86e104ab3ffe"></p>


<메인 화면에 검색 로그>
<img width="1552" alt="스크린샷 2023-07-31 오후 8 22 02" src="https://github.com/zestbear/Spring-weather/assets/49549887/fe527717-59f5-42b1-8626-dc25cc1d1bf0">
























