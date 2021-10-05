(ns happy-experience.parser
  (:require
    [clojure.string :as str]
    [clojure.string :as str]

    )
  (:import (java.time LocalDate)))


(defn split-row
  [input]


  (let [
        [date task-id person-id rating] (str/split input #";")
        ]
    {
     :date      (LocalDate/parse date)
     :task-id   task-id
     :person-id person-id
     :rating    (Integer/parseInt rating)
     }
    )
  )

(defn read-file-contents-line-by-line!
  [filename]

  (with-open [rdr (clojure.java.io/reader filename)]
    (doall (line-seq rdr)
           )
    )
  )
;Just to use Threading macro
(defn drop-first
  [items]
  (drop 1 items)
  )
(defn split-rows
  [items]

  (->> items
       (map split-row)
       )
  )

(defn parse-data-in
  [filename]

  (->
    (read-file-contents-line-by-line! filename)
    (drop-first)
    (split-rows)
    )
  )
