(ns routes
  (:require
   [api.auth.routes :refer [auth-routes user-routes]]
   [api.healthcheck.routes :refer [healthcheck-routes]]
   [clojure.data.json :as json]
   [compojure.core :refer [context defroutes]]
   [compojure.route :as route]))

(defroutes all-routes
  (context "/api" []
    (healthcheck-routes)
    (auth-routes)
    (user-routes))

  (route/not-found (str (json/write-str {:message "Route not found!"}))))

