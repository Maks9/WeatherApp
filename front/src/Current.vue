<template>
    <v-layout row-sm1>
        <v-flex xs12 offset-sm3>
            <v-card>
                <v-toolbar class="light-blue" dark>
                    <v-toolbar-title h6>Whether in  </v-toolbar-title>
                </v-toolbar>
                <v-list-tile-content>
                    <v-card-title>
                        <h5>Folders</h5>
                    </v-card-title>
                    <v-subheader>Folders</v-subheader>
                </v-list-tile-content>
                <v-divider inset></v-divider>
                <v-list two-line subheader>
                    <v-subheader inset>Folders</v-subheader>
                    <v-list-tile avatar v-for="item in items" v-bind:key="item.title">
                        <v-list-tile-avatar>
                            <v-icon v-bind:class="[item.iconClass]">{{ item.icon }}</v-icon>
                        </v-list-tile-avatar>
                        <v-list-tile-content>
                            <v-list-tile-title>{{ item.title }}</v-list-tile-title>
                            <v-list-tile-sub-title>{{ item.subtitle }}</v-list-tile-sub-title>
                        </v-list-tile-content>
                        <v-list-tile-action>
                            <v-btn icon ripple>
                                <v-icon class="grey--text text--lighten-1">info</v-icon>
                            </v-btn>
                        </v-list-tile-action>
                    </v-list-tile>
                    <v-divider inset></v-divider>
                    <v-subheader inset>Files</v-subheader>
                    <v-list-tile v-for="item in items2" v-bind:key="item.title">
                        <v-list-tile-avatar>
                            <v-icon v-bind:class="[item.iconClass]">{{ item.icon }}</v-icon>
                        </v-list-tile-avatar>
                        <v-list-tile-content>
                            <v-list-tile-title>{{ item.title }}</v-list-tile-title>
                            <v-list-tile-sub-title>{{ item.subtitle }}</v-list-tile-sub-title>
                        </v-list-tile-content>
                        <v-list-tile-action>
                            <v-btn icon ripple>
                                <v-icon class="grey--text text--lighten-1">info</v-icon>
                            </v-btn>
                        </v-list-tile-action>
                    </v-list-tile>
                </v-list>
            </v-card>
        </v-flex>
    </v-layout>
</template>


<script>
    export default {
        data () {
            return {
                items: [
                    { icon: 'folder', iconClass: 'grey lighten-1 white--text', title: 'Photos', subtitle: 'Jan 9, 2014' },
                    { icon: 'folder', iconClass: 'grey lighten-1 white--text', title: 'Recipes', subtitle: 'Jan 17, 2014' },
                    { icon: 'folder', iconClass: 'grey lighten-1 white--text', title: 'Work', subtitle: 'Jan 28, 2014' }
                ],
                items2: [
                    { icon: 'assignment', iconClass: 'blue white--text', title: 'Vacation itinerary', subtitle: 'Jan 20, 2014' },
                    { icon: 'call_to_action', iconClass: 'amber white--text', title: 'Kitchen remodel', subtitle: 'Jan 10, 2014' },
                ]
            }
        }
    }
</script>
