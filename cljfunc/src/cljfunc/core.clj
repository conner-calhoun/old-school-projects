(ns cljfunc.core
  (:gen-class))

;************************************************************
; Begin Sequential

(defn addSequential 
    ;Add sequential numbers
    [x y]
    (cond 
        (> x y) (addSequential y x)
        (= x y) x
        :else (+ x (addSequential(+ 1 x) y))
    ))

;************************************************************
; Begin Palindrome

(defn palindrome
    ;Determine whether a string is a palindrome or not
    [ins]
    (loop [s ins]
        (cond
            (<= (count s) 1) true
            (and (= (count s) 2) (= (first s) (last s))) true
            (not= (first s) (last s)) false
            :else (recur (subs s 1 (- (count s) 1)))
        )
    ))

;************************************************************
; Begin Quadratic

(defn negate
    ;helper function that negates a value
    [n]
    (- n (* 2 n)))

(defn sqrt
    ;finds the square root of a number
    [n]
    (Math/sqrt n))

(defn quadratic
    ;Return the 'a', 'b', & 'c' of the quadratic equation along with other stuff
    ; (-b +OR- sqrt(b^2 - 4ac))/2a
    [a b c]
        (printf "Coefficients (%s, %s, %s):\n" a b c)
        (def x1 (/ (+ (negate b) (sqrt (- (* b b) (* 4 a c)))) (* 2 a))) ;(-b + sqrt(b^2 - 4ac)) / 2a
        (def x2 (/ (- (negate b) (sqrt (- (* b b) (* 4 a c)))) (* 2 a))) ;(-b - sqrt(b^2 - 4ac)) / 2a
        (println "  Root (+):" x1)
        (println "  Root (-):" x2)
        [x1 x2] ; Return those values if you wish to do something else with then
    )

;************************************************************
; Begin Name Grouping

(defn getNames
    ; Continually accept input names and store them in a list
    [namelist] 
    (def n (read-line))
    (cond
        (= n "end") namelist
        :else (getNames (conj namelist n))
    ))

(defn splitHalf
    ; Splits the list in half
    [namelist]
    (split-at (/ (count namelist) 2) namelist))

(defn firstLast
    ; Pairs the first and last names
    [firstNames lastNames comb]
    (loop [f firstNames l lastNames c comb]
        (cond 
            (= 0 (count f)) c
            (not= (count f) (count l)) (println "Odd number of names entered...")
            :else (recur (drop 1 f) (drop 1 l) (cons (list (nth f 0) (nth l 0)) c))
        )   
    ))

(defn groupNames
	;Groups names based on user input
	[]
    (println "  Enter an even number of names or 'end' to stop:")
    (def names (getNames []))
    (println (firstLast (get (splitHalf names) 0) (get (splitHalf names) 1) []))
)

;************************************************************
; Begin main

(defn -main
    ; Main Program
    [& args]
    (println "\n\n***************************************\nConner Calhoun\nProgramming Languages - CSCI 4200\n***************************************")
    (println "Sequential Addition Demo")
    (println "Add Sequential:   3, 5:"(addSequential 3 5))
    (println "Add Sequential:   2, 9:"(addSequential 2 9))
    (println "Add Sequential: 63, 34:"(addSequential 63 34))
    (println "***************************************")
    (println "Palindrome Demo")
    (println "Is Palindrome: 'Racecar'? " (palindrome "racecar"))
    (println "Is Palindrome: 'HelloWorld'? " (palindrome "helloworld"))
    (println "Is Palindrome: 'a'? " (palindrome "a"))
    (println "***************************************")
    (println "Quadratic Demo")
    (quadratic 2 -5 -3)
    (quadratic 2 4 -4)
    (quadratic -10 9 6)
    (println "***************************************")
    (println "Name Demo")
    (groupNames)
    (println "***************************************\n\n")    
    )