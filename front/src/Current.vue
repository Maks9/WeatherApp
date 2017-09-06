<template>
    <v-card>
        <v-toolbar class="light-blue" dark>
            <v-toolbar-title h6>Weather in {{cityName}}, {{countryCode}}</v-toolbar-title>
        </v-toolbar>
        <v-list two-line subheader>
            <v-list-tile>
                <img v-bind:src="weatherIconName">
                <v-list-tile-content>
                    <v-list-tile-title>
                        <h6>{{temperature}}</h6>
                    </v-list-tile-title>
                    <v-list-tile-sub-title>{{ weatherDescription }}</v-list-tile-sub-title>
                </v-list-tile-content>
            </v-list-tile>
        </v-list>
        <v-divider inset></v-divider>
        <v-list>
            <v-list-tile avatar v-for="item in items" v-bind:key="item.title" >
                <v-list-tile-content>
                    <v-list-tile-title>{{ item.title }}</v-list-tile-title>
                </v-list-tile-content>
                <v-list-tile-content align-center>
                    <v-list-tile-title >{{ item.value }}</v-list-tile-title>
                </v-list-tile-content>
            </v-list-tile>
        </v-list>
        <v-divider inset></v-divider>
        <v-list>
            <v-list-tile>
                <v-list-tile-content>
                    <v-list-tile-sub-title>{{timeOfCalculation}}</v-list-tile-sub-title>
                </v-list-tile-content>
            </v-list-tile>
        </v-list>
    </v-card>

</template>


<script>

    export default {
        name: 'current-meteo-list',
        props: [
            'meteoData'
        ],
        data () {
            return {
                cityName: '',
                countryCode: '',
                weatherIconName: '',
                weatherDescription: '',
                temperature: '',
                timeOfCalculation: '',
                items: {
                    wind: {
                        title: 'Wind',
                        value: '',
                        subtitle: ''
                    }
                    ,
                    cloudiness: {
                        title: 'Cloudiness',
                        value: '',
                        subtitle: 'Jan 17, 2014'
                    },
                    pressure: {
                        title: 'Pressure',
                        value: '',
                        subtitle: 'Jan 28, 2014'
                    },
                    humidity: {
                        title: 'Humidity',
                        value: '',
                        subtitle: 'Jan 28, 2014'
                    }
                    ,
                    visibility: {
                        title: 'Visibility',
                        value: '',
                        subtitle: 'Jan 28, 2014'
                    }
                    ,
                    rainVolume: {
                        title: 'Rain Volume',
                        value: '',
                        subtitle: 'Jan 28, 2014'
                    }
                    ,
                    snowVolume: {
                        title: 'Snow volume',
                        value: '',
                        subtitle: 'Jan 28, 2014'
                    }
                    ,
                    sunrise: {
                        title: 'Sunset',
                        value: '',
                        subtitle: 'Jan 28, 2014'
                    }
                    ,
                    sunset: {
                        title: 'Sunset',
                        value: '',
                        subtitle: 'Jan 28, 2014'
                    }
                    ,
                    coordinates: {
                        title: 'Coordinates',
                        value: '',
                        subtitle: 'Jan 28, 2014'
                    }
                }
            }
        },

        methods: {
            dateTimeConverter: function (UNIX_timestamp) {
                var a = new Date(UNIX_timestamp * 1000);
                var months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
                var year = a.getFullYear();
                var month = months[a.getMonth()];
                var date = a.getDate();
                var hour = this.twoDigits(a.getHours());
                var min = this.twoDigits(a.getMinutes());
                var sec = this.twoDigits(a.getSeconds());
                var time = date + ' ' + month + ' ' + year + ' ' + hour + ':' + min + ':' + sec;
                return time;
            },

            timeConverter: function (UNIX_timestamp) {
                var a = new Date(UNIX_timestamp * 1000);
                var hour = this.twoDigits(a.getHours());
                var min = this.twoDigits(a.getMinutes());
                var sec = this.twoDigits(a.getSeconds());
                var time = hour + ':' + min + ':' + sec;
                return time;
            },

            twoDigits: function (value) {
                if (value < 10) {
                    return '0' + value;
                }
                return value;
            },
        },
        watch: {
            meteoData: function (value) {
                this.cityName = value.cityName
                this.countryCode = value.countryCode
                this.weatherIconName = 'http://openweathermap.org/img/w/' + value.weatherIconName + '.png'
                this.weatherDescription = value.weatherDescription
                this.temperature = value.temperature + ' ℃'
                this.timeOfCalculation = 'Valid for ' + this.dateTimeConverter(value.timeOfCalculation)
                this.items.coordinates.value = 'lat - ' + value.coordLat + ', lon - ' + value.coordLon
                this.items.pressure.value = value.pressure + ' hPa';
                this.items.humidity.value = value.humidity + ' %';
                this.items.visibility.value = value.visibility + ' m';
                this.items.rainVolume.value = value.rain + ' mm last 3h';
                this.items.snowVolume.value = value.snow + ' mm last 3h';
                this.items.cloudiness.value = value.clouds + ' %';
                this.items.sunrise.value = this.timeConverter(value.sunrise);
                this.items.sunset.value = this.timeConverter(value.sunset);
                this.items.wind.value = value.windSpeed + ' m/s, ' + value.windDirection + ' deg';
            },
        },
    }
</script>
