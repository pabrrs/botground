(ns unsplash
  (:require [clj-http.client :as client]
            [uuid]))

(def unsplash-random-image-url 
  "https://source.unsplash.com/random/3840x2160?mountains,landscapes,houses,office,trees,cyberpunk,coding,art,buildings,nature,animals,sunset")

(def destination-file
  (str (str (System/getenv "HOME") "/Pictures/Wallpapers/") uuid/uuid ".jpg"))

(defn download-image []
  "Downloads random wallpaper from Unsplash and save inside ~/Pictures/Wallpapers"
  (clojure.java.io/copy
    (:body (client/get unsplash-random-image-url {:as :stream
                                                  :cookie-policy :standard 
                                                  :decode-cookies false}))
    (java.io.File. destination-file))
  (str "file://" destination-file))