(ns botground.unsplash
  (:require [clj-http.client :as client]
            [botground.uuid :as uuid]))

(def unsplash-random-image-url 
  "https://source.unsplash.com/random/3840x2160?mountains,landscapes,houses,office,trees,cyberpunk,coding,art,buildings,nature,animals")

(defn download-image []
  "Downloads random wallpaper from Unsplash and save inside ~/Pictures/Wallpapers"
  (let [url unsplash-random-image-url
        destination-file (str (str (System/getenv "HOME") "/Pictures/Wallpapers/") uuid/uuid ".jpg")]
    (clojure.java.io/copy
      (:body (client/get url {:as :stream}))
      (java.io.File. destination-file))
    (str "file://" destination-file)))