<template>
    <v-card>
        <v-toolbar class="light-blue" dark>
            <v-toolbar-title h6>Whether in {{cityName}}, {{countryCode}}</v-toolbar-title>
        </v-toolbar>
        <v-list two-line subheader>
            <v-list-tile>
                <v-list-tile-content>
                    <v-list-tile-title v-on:click="fetchCurrentWeather">
                        <h6>Temp</h6>
                        <v-icon></v-icon>
                    </v-list-tile-title>
                </v-list-tile-content>
            </v-list-tile>
        </v-list>
        <v-divider inset></v-divider>
        <v-list>
            <v-list-tile>
                <v-list-tile-content>
                    <v-list-tile-title>Description</v-list-tile-title>
                </v-list-tile-content>
            </v-list-tile>
            <v-list-tile>
                <v-list-tile-content>
                    <v-list-tile-title>Time</v-list-tile-title>
                </v-list-tile-content>
            </v-list-tile>
        </v-list>
        <v-divider inset></v-divider>
        <v-list>
            <v-subheader inset>Parameters</v-subheader>
            <v-list-tile avatar v-for="item in items" v-bind:key="item.title">
                <v-list-tile-content>
                    <v-list-tile-title>{{ item.title }}</v-list-tile-title>
                </v-list-tile-content>
                <v-list-tile-action>{{ item.value }}</v-list-tile-action>
            </v-list-tile>
        </v-list>
    </v-card>
</template>


<script>

    import axios from "axios";
    import PROPERTIES from './properties'

    export default {
        data () {
            return {
                cityName: "Kyiv",
                countryCode: "UA",
                weatherIconName: '',
                weatherDescription: '',
                temperature: '',
                timeOfCalculation: '',
                coordLon: '',
                coordLat: '',
                pressure: '',
                humidity: '',
                visibility: '',
                windSpeed: '',
                windDirection: '',
                rainVolume: '',
                snowVolume: '',
                cloudness: '',
                sunrise: '',
                sunset: '',


                items: {
                    wind: {
                        icon: 'folder',
                        iconClass: 'grey lighten-1 white--text',
                        title: 'Wind',
                        value: this.windString,
                        subtitle: 'Jan 9, 2014'
                    }
//                    ,
//                    cloudiness: {
//                        icon: 'folder',
//                        iconClass: 'grey lighten-1 white--text',
//                        title: 'Cloudiness',
//                        value: '',
//                        subtitle: 'Jan 17, 2014'
//                    }
//                    ,
//            {
//                icon: 'folder',
//                    iconClass
//            :
//                'grey lighten-1 white--text',
//                    title
//            :
//                'Pressure',
//                    subtitle
//            :
//                'Jan 28, 2014'
//            }
//        ,
//            {
//                icon: 'folder',
//                    iconClass
//            :
//                'grey lighten-1 white--text',
//                    title
//            :
//                'Humidity',
//                    subtitle
//            :
//                'Jan 28, 2014'
//            }
//        ,
//            {
//                icon: 'folder',
//                    iconClass
//            :
//                'grey lighten-1 white--text',
//                    title
//            :
//                'Sunrise',
//                    subtitle
//            :
//                'Jan 28, 2014'
//            }
//        ,
//            {
//                icon: 'folder',
//                    iconClass
//            :
//                'grey lighten-1 white--text',
//                    title
//            :
//                'Sunset',
//                    subtitle
//            :
//                'Jan 28, 2014'
//            }
//        ,
//            {
//                icon: 'folder',
//                    iconClass
//            :
//                'grey lighten-1 white--text',
//                    title
//            :
//                'Geo coords',
//                    subtitle
//            :
//                'Jan 28, 2014'
//            }
        }
        }
        },

        computed: {
            windString : function () {
                return this.windSpeed + ' ' + this.windDirection
            }
        },
        methods: {
            fetchCurrentWeather() {

//                const headers = {
//                    'Content-Type': 'application/json',
//                };

                axios.get(PROPERTIES.HOST + PROPERTIES.CURRENT, {
                    params: {
                        city: this.cityName,
                        countryCode: this.countryCode
                    },
//                    headers
                })
                    .then((response) => {
                        this.weatherIconName = response.data.weatherIconName
                        this.weatherDescription = response.data.weatherDescription
                        this.temperature = response.data.temperature
                        this.timeOfCalculation = response.data.timeOfCalculation
                        this.coordLon = response.data.coordLon
                        this.coordLat = response.data.coordLat
                        this.pressure = response.data.pressure;
                        this.humidity = response.data.humidity;
                        this.visibility = response.data.visibility;
                        this.windSpeed = response.data.windSpeed;
                        this.windDirection = response.data.windDirection;
                        this.rainVolume = response.data.rainVolume;
                        this.snowVolume = response.data.snowVolume;
                        this.cloudness = response.data.cloudness;
                        this.sunrise = response.data.sunrise;
                        this.sunset = response.data.sunset;
                    });
            },
        }
    }
</script>
