(ns api.interceptor.auth)

(defn with-authentication [handler]
  (fn [req]
    (handler req)))

