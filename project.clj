(defproject cjzork "0.1.0-SNAPSHOT"
  :description "Interactive fiction project"
  :url "http://www.clipowolf.com"
  :license {:name "KP Public License"
            :url "http://www.clipwolf.com"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot cjzork.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev {:plugins [[cider/cider-nrepl "0.15.0-SNAPSHOT"]]}})

  
