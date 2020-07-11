(ns botground
  (:require [botground.unsplash :as unsplash])
  (:use [clojure.java.shell :only [sh]]))

(defn -main []
  (sh "gsettings" "set" "org.gnome.desktop.background" "picture-uri" (unsplash/download-image))
  (System/exit 0))