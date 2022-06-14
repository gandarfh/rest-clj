(ns datebase
  (:require [clojure.java.jdbc :as sql])
  (:gen-class))

(def db
  {:classname   "org.sqlite.JDBC"
   :subprotocol "sqlite"
   :subname     "db/database.db"})

(defn create-table [table]
  (try
    (sql/db-do-commands db table)
    (catch Exception e
      (println (.getMessage e)))))

(def users-table
  (sql/create-table-ddl
   :users [[:timestamp :datetime :default :current_timestamp]
           [:email :text :primary :key]
           [:username :text]
           [:full_name :text]
           [:password :text]]))

(defn create-db []
  (create-table users-table))


