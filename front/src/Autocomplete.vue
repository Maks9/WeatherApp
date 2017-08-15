<template>

    <autocomplete
            anchor="name"
            label="name"
            :options="'options'"
            :on-select="getData">
    </autocomplete>

</template>


<script>

    import Autocomplete from 'vue2-autocomplete-js';
    import citydata from '../city.list.json';

    export default {
        name: 'a-comp',
        data() {
          return {
              options: citydata
            }
        },

        components: { Autocomplete },

        methods: {
            getData(obj){
                console.log(obj);
            }
        }
    };

</script>