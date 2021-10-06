(ns happy-experience.parser
  (:require
    [clojure.string :as str]
    [clojure.string :as str]

    )
  (:import (java.time LocalDate)))



(defn score-for-rating [rating]

  (let [rules {
               :1 -2
               :2 -1
               :3 1
               :4 2
               :5 3
               }]
    (rules (keyword  (str rating) ))
    )

  )

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
     :score  (score-for-rating rating)
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


(defn has-semi-colon [input]
  (clojure.string/includes? input ";")
  )
(defn has-all-the-fields [input]
  (= 4 (count  (str/split input #";")))
  )
(defn is-valid-row [input]
  (and  (has-semi-colon input) (has-all-the-fields input) )
  )

(defn split-rows
  [items]
  (->> items
       (filter is-valid-row)
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
