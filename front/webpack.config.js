var path = require('path')
var webpack = require('webpack');

function resolve (dir) {
    return path.join(__dirname, '..', dir)
}

module.exports = {
    context: __dirname,
    entry: ["babel-polyfill", "./src/main.js"],
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
            },
            {
                test: /\.css$/,
                loader: 'style-loader!css-loader'
            },
            {
                test: /\.js$/,
                loader: 'babel-loader',
                include: [resolve('src'), resolve('test')]
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