(ns models.user
  (:require
   [clojure.java.jdbc :as sql]
   [datebase :refer [db]]))

(defn insert-user [username  password  full-name  email]
  (try
    (sql/insert!
     db :users
     {:username username
      :password password
      :full_name full-name
      :email email})

    (catch Exception e
      (str (ex-message e)))))

(defn list-users []
  (sql/query db ["select * from users"]))


