(ns unsplash
  (:require [clj-http.client :as client]))

(def unsplash-random-image-url
  "https://source.unsplash.com/random/3840x2160?mountains,trees,cyberpunk,coding,buildings,sunset,sky,outdoors")

(def destination-file
  (apply str (System/getenv "HOME") "/Pictures/Wallpapers/" "current-wallpaper.jpg"))

(defn download-image []
  "Downloads random wallpaper from Unsplash and save inside ~/Pictures/Wallpapers"
  (clojure.java.io/copy
    (:body (client/get unsplash-random-image-url {:as :stream
                                                  :cookie-policy :standard 
                                                  :decode-cookies false}))
    (java.io.File. destination-file))
  (str "file://" destination-file))
