(ns happy-experience.core
  (:require
    [happy-experience.parser :as parser]
    )
  )

(defn score-for-rating [rating]

  (let [rules {
               :1 -2
               :2 -1
               :3 1
               :4 2
               :5 3
               }]
      (rules (keyword (str rating)))
    )

  )

(defn is-same-task [task-id-to-be-checked  {:keys [task-id]}]
  (= task-id-to-be-checked task-id)
  )
(defn experiences-on [filename task-id-to-be-checked]


  (->>
      (parser/parse-data-in filename)
      (filter #(is-same-task task-id-to-be-checked % ))

       )


  )
