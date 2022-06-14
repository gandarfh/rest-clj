(defproject rest-demo "0.1.0-SNAPSHOT"
  :plugins [[cider/cider-nrepl "0.24.0"]]
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [metosin/malli "0.8.4"]
                 [compojure "1.6.1"]
                 [clj-http "3.12.3"]
                 [http-kit "2.3.0"]
                 [ring/ring-defaults "0.3.2"]
                 [ring/ring-devel "1.6.3"]
                 [ring/ring-json "0.5.0"]
                 [org.clojure/data.json "0.2.6"]
                 [org.clojure/java.jdbc "0.7.12"]
                 [org.xerial/sqlite-jdbc "3.36.0"]]
  :main ^:skip-aot server
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
