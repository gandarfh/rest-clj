(ns api.auth.routes
  (:require
   [api.auth.handlers :as auth]
   [compojure.core :refer [context GET POST]]))

(defn auth-routes []
  (context "/auth" []
    (POST "/login" [] auth/login)
    (POST "/register" [] auth/register)))

(defn user-routes []
  (context "/users" []
    (GET "/" [] auth/get-users)))
