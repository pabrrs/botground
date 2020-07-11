(ns botground
  (:require [unsplash])
  (:use [clojure.java.shell :only [sh]]))

(defn -main []
  (println "Starting to download awesome wallpaper ...")
  (sh "gsettings" "set" "org.gnome.desktop.background" "picture-uri" (unsplash/download-image))
  (println "Finished! Enjoy your new wallpaper.")
  (System/exit 0))