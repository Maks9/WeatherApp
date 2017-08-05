import Vue from 'vue'
import App from './App.vue'
import Vuetify from 'vuetify'
// import '../node_modules/vuetify/src/stylus/main.styl'

Vue.use(Vuetify)

new Vue({
    el: '#app',
    render: h => h(App)
    // template: '<app/>',
    // components: { App }
})
