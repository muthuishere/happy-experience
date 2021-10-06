(ns happy-experience.core-test
  (:require [clojure.test :refer :all]
            [happy-experience.core :refer :all])
  )





(deftest experiences-on-test

  (let [
        res (experiences-on "another-small-example.csv" "6156dc9dc1f742f8e11aa14d")

        ]

    (println (type res))
    (println (pr-str res))
    (is (= 2 (count res) ))

    )
  )

(deftest print-experiences-test

  (let [
        res  (print-experiences "another-small-example.csv" "6156dc9dc1f742f8e11aa14d")

        ]


    (println  res)


    )





  )
(deftest print-experiences-test-check

  (do (print-experiences "another-small-example.csv" "6156dc9dc1f742f8e11aa14d") )

  )
