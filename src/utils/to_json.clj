(ns utils.to_json
  (:require
   [clojure.data.json :as json]))

(defn map-to-json [response]
  (str (json/write-str response)))
