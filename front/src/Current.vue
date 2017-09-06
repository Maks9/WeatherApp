<template>
    <v-card>
        <v-toolbar class="light-blue" dark>
            <v-toolbar-title h6>Whether in {{cityName}}, {{countryCode}}</v-toolbar-title>
        </v-toolbar>
        <v-list two-line subheader>
            <v-list-tile>
                <img v-bind:src="weatherIconName">
                <v-list-tile-content>
                    <v-list-tile-title v-on:click="fetchCurrentWeather">
                        <h6>{{temperature}}</h6>
                    </v-list-tile-title>
                    <v-list-tile-sub-title>{{ weatherDescription }}</v-list-tile-sub-title>
                </v-list-tile-content>
            </v-list-tile>
        </v-list>
        <v-divider inset></v-divider>
        <v-list>
            <!--<v-subheader inset>Parameters</v-subheader>-->
            <v-list-tile avatar v-for="item in items" v-bind:key="item.title" v-if="item.value.charAt(0) != 0">
                <v-list-tile-content>
                    <v-list-tile-title>{{ item.title }}</v-list-tile-title>
                </v-list-tile-content>
                <v-list-tile-action>{{ item.value }}</v-list-tile-action>
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

    import axios from "axios";
    import PROPERTIES from './properties'

    var fetchCurrent

    export default {
        name: 'current-meteo-list',
        props: [
            'city'
        ],
        data () {
            return {
                cityName: "Kyiv",
                countryCode: "UA",
                weatherIconName: '',
                weatherDescription: '',
                temperature: '',
                timeOfCalculation: '',
                items: {
                    wind: {
                        icon: 'folder',
                        iconClass: 'grey lighten-1 white--text',
                        title: 'Wind',
                        value: '',
                        subtitle: ''
                    }
                    ,
                    cloudiness: {
                        icon: 'folder',
                        iconClass: 'grey lighten-1 white--text',
                        title: 'Cloudiness',
                        value: '',
                        subtitle: 'Jan 17, 2014'
                    },
                    pressure: {
                        icon: 'folder',
                        iconClass: 'grey lighten-1 white--text',
                        title: 'Pressure',
                        value: '',
                        subtitle: 'Jan 28, 2014'
                    },
                    humidity: {
                        icon: 'folder',
                        iconClass: 'grey lighten-1 white--text',
                        title: 'Humidity',
                        value: '',
                        subtitle: 'Jan 28, 2014'
                    }
                    ,
                    visibility: {
                        icon: 'folder',
                        iconClass: 'grey lighten-1 white--text',
                        title: 'Visibility',
                        value: '',
                        subtitle: 'Jan 28, 2014'
                    }
                    ,
                    rainVolume: {
                        icon: 'folder',
                        iconClass: 'grey lighten-1 white--text',
                        title: 'Rain Volume',
                        value: '',
                        subtitle: 'Jan 28, 2014'
                    }
                    ,
                    snowVolume: {
                        icon: 'folder',
                        iconClass: 'grey lighten-1 white--text',
                        title: 'Snow volume',
                        value: '',
                        subtitle: 'Jan 28, 2014'
                    }
                    ,
                    sunrise: {
                        icon: 'folder',
                        iconClass: 'grey lighten-1 white--text',
                        title: 'Sunset',
                        value: '',
                        subtitle: 'Jan 28, 2014'
                    }
                    ,
                    sunset: {
                        icon: 'folder',
                        iconClass: 'grey lighten-1 white--text',
                        title: 'Sunset',
                        value: '',
                        subtitle: 'Jan 28, 2014'
                    }
                    ,
                    coordinates: {
                        icon: 'folder',
                        iconClass: 'grey lighten-1 white--text',
                        title: 'Coordinates',
                        value: '',
                        subtitle: 'Jan 28, 2014'
                    }
                }
            }
        },

//        computed: {
//            windString : function () {
//                return this.windSpeed + ' ' + this.windDirection
//            }
//        },
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

            fetchCurrentWeather: function () {

//                const headers = {
//                    'Content-Type': 'application/json',
//                };

                axios.get(PROPERTIES.HOST + PROPERTIES.CURRENT, {
                    params: {
                        city: this.city,
                        countryCode: this.countryCode
                    },
//                    headers
                })
                    .then((response) => {
                        this.weatherIconName = 'http://openweathermap.org/img/w/' + response.data.weatherIconName + '.png'
                        this.weatherDescription = response.data.weatherDescription
                        this.temperature = response.data.temperature + ' ℃'
                        this.timeOfCalculation = 'Valid for ' + this.dateTimeConverter(response.data.timeOfCalculation)
                        this.items.coordinates.value = 'lat - ' + response.data.coordLat + ', lon - ' + response.data.coordLon
                        this.items.pressure.value = response.data.pressure + ' hPa';
                        this.items.humidity.value = response.data.humidity + ' %';
                        this.items.visibility.value = response.data.visibility + ' m';
                        this.items.rainVolume.value = response.data.rain + ' mm in last 3h';
                        this.items.snowVolume.value = response.data.snow + ' mm in last 3h';
                        this.items.cloudiness.value = response.data.clouds + ' %';
                        this.items.sunrise.value = this.timeConverter(response.data.sunrise);
                        this.items.sunset.value = this.timeConverter(response.data.sunset);
                        this.items.wind.value = 'Speed - ' + response.data.windSpeed + 'm/s, Direction - ' + response.data.windDirection + ' deg';
                    });
            },
        },
        created: function () {
            this.fetchCurrentWeather();
        }
    }
</script>
