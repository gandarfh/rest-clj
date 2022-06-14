(ns api.healthcheck.routes
  (:require
   [api.healthcheck.handlers :as healthcheck]
   [compojure.core :refer [context GET]]))

(defn healthcheck-routes []
  (context "/healthcheck" []
    (GET "/" [] healthcheck/show)))
