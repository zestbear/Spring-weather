async function getWeather() {
    const latitude = document.getElementById('latitude').value;
    const longitude = document.getElementById('longitude').value;
    const endPoint = "/end-point";

    const response = await fetch(endPoint, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            latitude: latitude,
            longitude: longitude
        })
    });

    const data = await response.json();
    const weatherOutput = `
    <p>${data["name"]}의 날씨입니다.</p>
    <p>날씨는 ${data["weather"][0]["description"]}입니다.</p>
    <p>현재 온도는 ${data["main"]["temp"]}입니다.</p>
    <p>하지만 체감 온도는 ${data["main"]["feels_like"]}입니다.</p>
    <p>최저 기온은 ${data["main"]["temp_min"]}입니다.</p>
    <p>최고 기온은 ${data["main"]["temp_max"]}입니다.</p>
    <p>습도는 ${data["main"]["humidity"]}입니다.</p>
    <p>기압은 ${data["main"]["pressure"]}입니다.</p>
    <p>풍향은 ${data["wind"]["deg"]}입니다.</p>
    <p>풍속은 ${data["wind"]["speed"]}입니다.</p>
  `;

    createWeatherPopup(weatherOutput);
}


function createWeatherPopup(weather) {
    const popup = window.open('', 'weather_popup', 'width=400,height=400,resizable=yes,scrollbars=yes');
    const popupContent = `
    <html>
      <head>
        <title>날씨 정보</title>
        <script>
          function closePopupAndSave() {
            window.opener.document.getElementById("weather").value = '${weather.replace(/'/g, "\\'")}';
            window.opener.main.save();
            window.close();
          }
        </script>
      </head>
      <body>
        ${weather}
        <button onclick="closePopupAndSave()">확인</button>
      </body>
    </html>`;
    popup.document.write(popupContent);
    popup.document.close();
}



var main = {
    init: function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            getWeather();
        });
    },
    save: function () {
        var data = {
            title: $('#email').val(),
            author: $('#location').val(),
            content: $('#weather').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
}

main.init();
