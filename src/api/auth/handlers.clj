(ns api.auth.handlers
  (:require
   [clojure.string :as str]
   [models.user :refer [insert-user list-users]]
   [utils.to_json :refer [map-to-json]]))

(defn login
  [req] {:status 201
         :headers {"Content-Type" "application/json"}
         :body (map-to-json {:message "Successo!"})})

(defn register
  [req]
  (let [username (-> req :params :username)
        password (-> req :params :password)
        full-name (-> req :params :full-name)
        email (-> req :params :email)]

    (if (or (not username) (not password) (not full-name) (not email))
      {:status 422
       :headers {"Content-Type" "application/json"}
       :body (map-to-json {:message "Some parameters is missing!"})}

      (let [response (insert-user username password full-name email)]

        (if (str/includes? response "[SQLITE_CONSTRAINT_PRIMARYKEY]")
          {:status 409
           :headers {"Content-Type" "application/json"}
           :body (map-to-json {:message (str "email: " email " already exist!")})}

          {:status 201
           :headers {"Content-Type" "application/json"}
           :body (map-to-json {:message response})})))))

(defn get-users
  [req]
  (let [response (list-users)]
    {:status 200
     :headers {"Content-Type" "application/json"}
     :body {:items response}}))
