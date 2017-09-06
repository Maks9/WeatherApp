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
            ></v-text-field>
            <v-btn icon  @click.native.stop="searchTabShow = !searchTabShow" v-if="!searchTabShow">
                <v-icon >search</v-icon>
            </v-btn>
            <v-btn icon>
                <v-icon>more_vert</v-icon>
            </v-btn>
        </v-toolbar>

        <v-layout class="pt-5 pl-5">
            <v-flex xs12 sm3>
                <!--<v-flex xs12 sm2 offset-sm3>-->
                <current-meteo-list city="cityName"></current-meteo-list>
            </v-flex>
        </v-layout>
        <!--<div>{{options}}</div>-->
    </v-app>
</template>

<script>


    import currentMeteoList from './Current.vue'

    export default {
        name: 'app',
        components: {currentMeteoList},
        data () {
            return {
                searchTabShow: false,
                cityName: 'Kyiv'
            }
        },
        methods: {
            onEnter: function () {
                this.$refs.currentMeteoList.fetchCurrentWeather();
            }
        }
    }
</script>

<!--<style src="../vuetify.min.css" lang="css"></style>-->

<!--<style lang="stylus">-->
    <!--@import '../node_modules/vuetify/src/stylus/main.styl',-->
<!--</style>-->
<!--<style lang="css">-->
    <!--@import '../node_modules/vue2-autocomplete-js/dist/style/vue2-autocomplete.css',-->
<!--</style>-->