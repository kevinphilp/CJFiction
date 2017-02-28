;; A comment

(ns cjzork.core
  (:gen-class))

(use '[clojure.string :only (join split blank?)])

(ns cjzork.items
       (:require [cjzork.core]))

(declare Lantern Key Matches)

(defrecord Item [Name Weight Desc])

(def Lantern (map->Item
              {:Name "A brass lantern" :Weight 12 :Desc "An old brass lantern. I could light it to see in the dark"}))

(def Key (map->Item
              {:Name "A brass key" :Weight 1 :Desc "An old brass key. I could open things"}))


(def Matches (map->Item
              {:Name "Matches" :Weight 1 :Desc "An old matchbox. I could light things"}))

(ns cjzork.core)

(declare Porch Kitchen Drive Shed Nowhere)

(defrecord Room [Name ShortDesc LongDesc Nodes Contains])

(def Shed (map->Room
           {:Name "Sheddy" :ShortDesc "Wodden" :LongDesc "Very Wooden"
            :Nodes {:East Drive}
            :Contains [Lantern Key Matches]}))

(def Porch (map->Room
            {:Name  "Porch" :ShortDesc "Smelly" :LongDesc "Very smelly" :Nodes {:South Drive :North Kitchen}}))

(def Kitchen (map->Room
              {:Name "Kitchen" :ShortDesc "Milky" :LongDesc "Very milky"
               :Nodes {:South Porch}
               :Contains [Matches]}))

(def Drive (map->Room
            {:Name "Drive" :ShortDesc "Gritty" :LongDesc "Very gritty" :Nodes {:North Porch :West Shed}}))

(defn get-input [prompt]
  (print prompt)
  (flush)
  (read-line))

(defn help []
  (println "The help file"))

(defn run []
  (println "Not the help file"))

(defn gameloop [input]
  (println "yippee\t" input)
  (cond
    (= input "help") (help)
    (= input "run") (run)
    :else (println "Sorry?")))

(defn get-input-loop []
  (loop [input (get-input "Welcome to CJZork >? ")]
    (if (= input "quit")
      (println "Bye for now")
      (do (gameloop input) (recur (get-input "? ")) )
      )))

(get-in Kitchen [:Nodes :South :ShortDesc]) 

(map first (get-in Porch [:Nodes]))

(map name (map first (get-in Porch [:Nodes])))


(defn LookAround [Room]
  (let
      [str1 (join ", " (butlast (map :Name (get-in Room [:Contains]))))
       str2 (last (map :Name (get-in Room [:Contains])))]
    (if (empty? (get-in Room [:Contains]) )
      (println "Nothing much here")
      (if (empty? str2)
        (println str1)
        (println str1 "&" str2)
        )
      )
      )
)
