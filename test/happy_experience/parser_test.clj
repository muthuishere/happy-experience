(ns happy-experience.parser-test
  (:require [clojure.test :refer :all])
  (:require [happy-experience.parser :refer :all ])
  (
    :import (java.time LocalDate)))



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


(deftest split-row-test

  (let [
        input "2021-10-01;6156dc9dc1f742f8e11aa14d;6156dca47fe5761a20b92b1d;4"
        expected-date (LocalDate/parse "2021-10-01")
        {:keys [date task-id person-id rating]} (split-row input)
        ]
    (is (= task-id "6156dc9dc1f742f8e11aa14d"))
    (is (= person-id "6156dca47fe5761a20b92b1d"))
    (is (= rating 4))
    (is (= 0 (compare expected-date date)))

    )
  )
(deftest split-row-by-comma-test

  (let [
        input "2021-10-01,6156dc9dc1f742f8e11aa14d,6156dca47fe5761a20b92b1d,4"
        expected-date (LocalDate/parse "2021-10-01")
        {:keys [date task-id person-id rating]} (split-row input)
        ]
    (is (= task-id "6156dc9dc1f742f8e11aa14d"))
    (is (= person-id "6156dca47fe5761a20b92b1d"))
    (is (= rating 4))
    (is (= 0 (compare expected-date date)))

    )
  )

(deftest read-contents!-test

  (let [
        res (parse-data-in "small-example.csv")
        ]

    (println (pr-str res))
    (is (= 3 (count res) ))

    )
  )

(deftest read-contents!-by-comma-test

  (let [
        res (parse-data-in "bigger-example.csv")
        ]

    (println (pr-str res))
    (is (= 100 (count res) ))

    )
  )

(deftest is-valid-row-test

  (is (is-valid-row "2021-10-01;6156dc9dc1f742f8e11aa14d;6156dca47fe5761a20b92b1d;4"))
  (is (= false (is-valid-row "2021-10-01")) )
  (is (= false (is-valid-row "")) )
  (is (= false (is-valid-row "2021-10-016156dc9dc1f742f8e11aa14d;6156dca47fe5761a20b92b1d;4")) )

  )
