(ns uuid)

(def uuid
  "Create a UUID"
  (str (java.util.UUID/randomUUID)))