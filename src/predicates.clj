(ns predicates)


(defn sum-f [f g x]
 (+ (f x) (g x))
  )


(defn less-than [n]
  (fn [x] (< x n))
  )



(defn equal-to [n]
  (fn [x] (== x n))
  )


(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)
  ))


(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x)))
  )


(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x)))
  )

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string)
  )



(defn has-award? [book award]
  (not
   (empty?
    (filter (fn [x] (contains? (book :awards) award)) book)))
  )

(defn HAS-ALL-THE-AWARDS? [book awards]
   (every? (fn[award] (has-award? book award)) awards)
   )


(defn my-some [pred a-seq]
  (let [mapped (map pred a-seq)
        filtered (filter (fn [value] value) mapped)]
  (cond
   (empty? filtered) false
   :else             (first filtered)
    )))



(defn my-every? [pred a-seq]
  (let [mapped (map pred a-seq)
        filtered (filter (complement (fn [value] value)) mapped)]
    (empty? filtered)
    ))


(defn prime? [n]
  (let [pred (fn [x] (== (mod n x) 0))]
  (not (some pred (range 2 n)))
    ))


;^^
