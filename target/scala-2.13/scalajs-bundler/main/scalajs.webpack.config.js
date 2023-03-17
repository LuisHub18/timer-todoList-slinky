module.exports = {
  "entry": {
    "tutorial-fastopt": ["C:\\coding\\tutorial\\target\\scala-2.13\\scalajs-bundler\\main\\tutorial-fastopt-entrypoint.js"]
  },
  "output": {
    "path": "C:\\coding\\tutorial\\target\\scala-2.13\\scalajs-bundler\\main",
    "filename": "[name]-library.js",
    "library": "ScalaJSBundlerLibrary",
    "libraryTarget": "var"
  },
  "mode": "development",
  "devtool": "source-map",
  "module": {
    "rules": [{
      "test": new RegExp("\\.js$"),
      "enforce": "pre",
      "use": ["source-map-loader"]
    }]
  }
}