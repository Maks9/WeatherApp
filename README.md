# WeatherApp
Simple weather service to retrieve current meteorological data by matching city name.

## WeatherApp - server

_Requirments_:
* `Java 8`
* `Maven`

_How to launch_:
* `git clone https://github.com/Maks9/WeatherApp.git`
* `cd WeatherApp/server/`
* `mvn package` (ensure variable M2_HOME exists and PATH contains M2_HOME/bin)
* `cd target/`
* `java -jar Weather_Server-1.0-TEST.jar`

You could also use your IDE to set up your `project from version control` -> `Git` -> `clone repository` -> use built in maven plugin to package jar file -> launch it

WeatherApp server is now available on `http://localhost:8082`. You may configure another port by editing application.yml in src/main/recources/application.yml (server.port)

Server handles 2 type of requests:
* `http://localhost:8082/current/meteo_data/get?city=CITY_NAME`
* `http://localhost:8082/current/meteo_data/getWithCountryCode?city=CITY_NAME&countryCode=COUNTRY_CODE`

Test it by sending `GET` request in browser. Search system looks for the best match for your input parameters

City name can be any string of latin letters. 
Country name must contain 2-letters country code like UA for Ukraine, this parameter only improves match by city name.

All requests are saved to the H2 database. You can use H2 Console to check out database. It is available on `localhost:8082/console` (user: admin, password - leave blank, JDBC URL - jdbc:h2:mem:testdb).

## WeatherApp - front-end view