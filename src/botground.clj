(ns botground
  (:require [unsplash])
  (:use [clojure.java.shell :only [sh]]))

(defn -main []
  (println "Downloading awesome wallpaper 🤖")
  (sh "gsettings" "set" "org.gnome.desktop.background" "picture-uri" (unsplash/download-image))
  (println "Enjoy your new wallpaper!")
  (System/exit 0))