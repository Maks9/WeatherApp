<template>
    <v-app>
        <v-toolbar dark class="primary">
            <v-icon>filter_drama</v-icon>
            <v-toolbar-title class="white--text">Current weather and forecasts in your city</v-toolbar-title>
            <v-spacer></v-spacer>
            <v-text-field
                    solo
                    label="Search"
                    prepend-icon="search"
                    v-if="searchTabShow"
                    v-model="cityName"
                    @keyup.enter="onEnter"
                    @blur="searchTabShow = !searchTabShow"
            ></v-text-field>
            <v-btn icon @click.native.stop="searchTabShow = !searchTabShow" v-if="!searchTabShow">
                <v-icon>search</v-icon>
            </v-btn>
            <v-btn icon>
                <v-icon>more_vert</v-icon>
            </v-btn>
        </v-toolbar>

        <v-container fluid grid-list-xs>
        <v-layout class="pt-3 pl-3">
            <v-flex xs9 sm6 md5 lg3 >
                <current-meteo-list v-bind:meteoData="currentMeteoData"></current-meteo-list>
            </v-flex>
            <v-flex xs9 class="pr-1 pl-3">
                <v-card dark class="blue-grey">
                    <v-card-text>Reserved for the forecast</v-card-text>
                </v-card>
            </v-flex>
            </v-layout>
        </v-container>

    </v-app>
</template>

<script>


    import currentMeteoList from './Current.vue'
    import axios from "axios";
    import PROPERTIES from './properties'

    export default {
        name: 'app',
        components: {currentMeteoList},
        data () {
            return {
                searchTabShow: false,
                cityName: 'Kiev',
                countryCode: "",
                currentMeteoData: {}
            }
        },
        methods: {
            onEnter: function () {
                this.fetchCurrentWeather();
            },

            fetchCurrentWeather: function () {
                axios.get(PROPERTIES.HOST + '/meteo_data/get/city_with_code', {
                    params: {
                        city: this.cityName,
                        countryCode: this.countryCode
                    },
                })
                    .then((response) => {
                        this.currentMeteoData = response.data
                    });

            },
        },
        created: function () {
            this.fetchCurrentWeather();
        }
    }
</script>

<!--<style lang="stylus">-->
<!--@import '../node_modules/vuetify/src/stylus/main.styl',-->
<!--</style>-->
