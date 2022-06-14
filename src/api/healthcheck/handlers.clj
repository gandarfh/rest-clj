(ns api.healthcheck.handlers
  (:require
   [clojure.data.json :as json]
   [status :refer [ok]]))

(defn show [req]
  {:status  ok
   :headers {"Content-Type" "application/json"}
   :body    (str (json/write-str {:message "ok!"}))})

