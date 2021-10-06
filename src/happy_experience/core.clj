(ns happy-experience.core
  (:require
    [happy-experience.parser :as parser]
    )
  )


(defn is-same-task [task-id-to-be-checked {:keys [task-id]}]
  (= task-id-to-be-checked task-id)
  )

(defn aggregate-score [input]

  (->> input
       (map #(:score %))
       (reduce +)
       )

  )
(defn person-with-score [obj]

  (let [
        person-id (key obj)
        contents (val obj)
        sum (aggregate-score contents)
        ]

    {
     :person-id person-id
     :score     sum
     }
    )
  )

(defn concat-with-semicolon [ {:keys [person-id score]}]

  (str person-id ";" score)

  )

;({:person-id "6156dca47fe5761a20b92b1d", :score 2} {:person-id "6156dcb90ba5173d292c9afe", :score -1})
(defn concat-results-with-newline [ obj]

  (->> obj
      (map concat-with-semicolon)
       (clojure.string/join "\n" )
      )
  )


(defn experiences-on [filename task-id-to-be-checked]

  (->>
    (parser/parse-data-in filename)
    (filter #(is-same-task task-id-to-be-checked %))
    (group-by :person-id)
    (map person-with-score)
    (sort-by :score  #(> %1 %2))
    )
  )

(defn print-experiences [filename task-id-to-be-checked]
  (->>
    (experiences-on filename task-id-to-be-checked)
    (concat-results-with-newline)
    (println)

    )

  )





(defn -main [filename  task-id & args]

  (print-experiences filename task-id)

  )
