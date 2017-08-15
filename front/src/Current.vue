<template>
    <v-card>
        <v-toolbar class="light-blue" dark>
            <v-toolbar-title h6>Whether in City</v-toolbar-title>
        </v-toolbar>
        <v-list two-line subheader>
            <v-list-tile>
                <v-list-tile-content>
                    <v-list-tile-title>
                        <v-icon></v-icon>
                        <h5>Temp</h5>
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
            <v-divider inset></v-divider>
        </v-list>
        <v-list>
            <v-subheader inset>Parameters</v-subheader>
            <v-list-tile avatar v-for="item in items" v-bind:key="item.title">
                <v-list-tile-content>
                    <v-list-tile-title>{{ item.title }}</v-list-tile-title>
                </v-list-tile-content>
                <v-list-tile-action>value</v-list-tile-action>
            </v-list-tile>
        </v-list>
    </v-card>
</template>


<script>

    import axios from "axios";

    export default {
        data () {
            return {
                items: [
                    {icon: 'folder', iconClass: 'grey lighten-1 white--text', title: 'Wind', subtitle: 'Jan 9, 2014'},
                    {
                        icon: 'folder',
                        iconClass: 'grey lighten-1 white--text',
                        title: 'Cloudiness',
                        subtitle: 'Jan 17, 2014'
                    },
                    {
                        icon: 'folder',
                        iconClass: 'grey lighten-1 white--text',
                        title: 'Pressure',
                        subtitle: 'Jan 28, 2014'
                    },
                    {
                        icon: 'folder',
                        iconClass: 'grey lighten-1 white--text',
                        title: 'Humidity',
                        subtitle: 'Jan 28, 2014'
                    },
                    {
                        icon: 'folder',
                        iconClass: 'grey lighten-1 white--text',
                        title: 'Sunrise',
                        subtitle: 'Jan 28, 2014'
                    },
                    {
                        icon: 'folder',
                        iconClass: 'grey lighten-1 white--text',
                        title: 'Sunset',
                        subtitle: 'Jan 28, 2014'
                    },
                    {
                        icon: 'folder',
                        iconClass: 'grey lighten-1 white--text',
                        title: 'Geo coords',
                        subtitle: 'Jan 28, 2014'
                    }
                ]
            }
        },
        methods: {
            fetchCurrentWeather() {

                const headers = {
                    'Content-Type': 'application/json',
                };

                axios.get(PROPERTIES.HOST + PROPERTIES.CURRENT + '?id=' = , {
                    params: {
                        id: this.$route.params.id
                    },
                    headers
                })
                    .then((response) => {
                    this.lesson = response.data;
                });
            },
    }
</script>
