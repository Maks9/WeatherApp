var path = require('path')
var vueLoaderConfig = require('./vue-loader.conf')
var webpack = require('webpack');

module.exports = {
    context: __dirname,
    entry: './src/main.js',
    plugins: [
        new webpack.LoaderOptionsPlugin({
            debug: true
        })
    ],
    output: {
        path: path.resolve(__dirname, './build'),
        filename: 'bundle.js'
    },
    module: {
        rules: [
            {
                test: /\.vue$/,
                loader: 'vue-loader',
                // options: vueLoaderConfig
            },
            // {
            //     test: /\.json$/,
            //     loader: 'json-loader'
            // },
            {
                test: /\.css$/,
                loader: 'style-loader!css-loader'
            },
            // {
            //     test: /\.styl$/,
            //     loader: ['style-loader', 'css-loader', 'stylus-loader']
            // },
        ]
    },
    // resolve: {
    //     alias: {
    //         vue$: 'vue/dist/vue.esm.js'
    //     }
    // }
    //todo minification
};