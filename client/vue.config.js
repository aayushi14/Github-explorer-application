module.exports = {
  devServer: {
    port: 8081,
    proxy: {
      "/api/repositories": {
        target: "http://localhost:9000/api/repositories",
        secure: false
      },
      "/api/bookmark": {
        target: "http://localhost:9000",
        secure: false,
        pathRewrite: { '^/api/bookmark': '' },
        changeOrigin: true,
      },
      "/api/unBookmark": {
        target: "http://localhost:9000",
        secure: false,
        pathRewrite: { '^/api/unBookmark': '' },
        changeOrigin: true,
      },
      "/api/bookmarks": {
        target: "http://localhost:9000",
        secure: false,
        pathRewrite: { '^/api/bookmarks': '' },
        changeOrigin: true,
      },
    }
  }
};
