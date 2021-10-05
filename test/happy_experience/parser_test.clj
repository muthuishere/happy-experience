(ns happy-experience.parser-test
  (:require [clojure.test :refer :all])
  (:require [happy-experience.parser :refer [split-row read-file-contents-line-by-line! parse-data-in]])
  (
    :import (java.time LocalDate)))



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

(deftest read-contents!-test

  (let [
        res (parse-data-in "small-example.csv")
        ]

    (println (pr-str res))
    (is (= 2 (count res) ))

    )
  )
