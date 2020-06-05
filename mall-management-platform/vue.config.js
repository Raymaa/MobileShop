module.exports = {
  devServer: {
    port: 8083,
    proxy: {
      '/MobileShop': {
        target: 'http://127.0.0.1:8080/MobileShop',
        changeOrigin: true,
        ws: true,
        pathRewrite: {
          '^/MobileShop': '/'
        }
      }
    }
  }
};