(ns botground.test
  (:use unsplash)
  (:use clojure.test))

(deftest test-unsplash-random-image-url
  (is (= unsplash/unsplash-random-image-url "https://source.unsplash.com/random/3840x2160?mountains,trees,cyberpunk,coding,buildings,sunset,sky,outdoors,landscape")))

(deftest test-destination-file
  (is (= unsplash/destination-file (apply str (System/getenv "HOME") "/Pictures/Wallpapers/" "current-wallpaper.jpg"))))

(test-unsplash-random-image-url)
(test-destination-file)
