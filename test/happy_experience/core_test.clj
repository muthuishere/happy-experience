(ns happy-experience.core-test
  (:require [clojure.test :refer :all]
            [happy-experience.core :refer :all])
  )




(deftest score-for-test

  ;
  ;- Rating 1 -> Score -2
  ;- Rating 2 -> Score -1
  ;- Rating 3 -> Score 1
  ;- Rating 4 -> Score 2
  ;- Rating 5 -> Score 3

  (is ( = -2 (score-for-rating 1)))
  (is ( = -1 (score-for-rating 2)))
  (is ( = 1 (score-for-rating 3)))
  (is ( = 2 (score-for-rating 4)))
  (is ( = 3 (score-for-rating 5)))

  )

(deftest experiences-on-test

  (let [
        res (experiences-on "another-small-example.csv" "6156dc9dc1f742f8e11aa14d")
        ]

    (println (pr-str res))
    (is (= 2 (count res) ))

    )
  )
