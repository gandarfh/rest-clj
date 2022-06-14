  (ns server
    (:require
     [datebase :refer [create-db]]
     [org.httpkit.server :as server]
     [ring.middleware.defaults :refer [api-defaults wrap-defaults]]
     [ring.middleware.json :as js]
     [ring.middleware.reload :refer [wrap-reload]]
     [routes :refer [all-routes]])
    (:gen-class))

(defn -main []
  (let [port (Integer/parseInt (or (System/getenv "PORT") "3000"))]
    (server/run-server
     (wrap-reload
      (js/wrap-json-params
       (js/wrap-json-response
        (wrap-defaults
         #'all-routes api-defaults))))
     {:port port})
    (create-db)
    (println (str "Running server at http:/localhost:" port))))

