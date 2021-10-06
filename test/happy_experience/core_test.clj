(ns happy-experience.core-test
  (:require [clojure.test :refer :all]
            [happy-experience.core :refer :all])
  )





(deftest experiences-on-test

  (let [
        res (happy-experiences "another-small-example.csv" "6156dc9dc1f742f8e11aa14d")

        ]

    (println (type res))
    (println (pr-str res))
    (is (= 2 (count res)))

    )
  )

(deftest formatted-happy-experiences-test

  (let [
        res (formatted-happy-experiences "another-small-example.csv" "6156dc9dc1f742f8e11aa14d")

        ]


    (println res)

    (is (= true (clojure.string/includes? res "6156dca47fe5761a20b92b1d;2")))
    (is (= true (clojure.string/includes? res "6156dcb90ba5173d292c9afe;-1")))

    )

  )
