;Solution to Problem 1
(defun MIN-2 
    (a b)
    (if (and (numberp a) (numberp b))
        (if (<= a b)
            a
            b)
            'error))

;Solution to Problem 2
(defun SAFE-AVG 
    (a b)
    (if (and (numberp a) (numberp b))
        (/ (+ a b) 2)
        nil))

;Solution to Problem 3
(defun ODD-GT-MILLION 
    (a)
    (if (and (numberp a) (integerp a) (oddp a))
        (if (> a 1000000)
        T)
        nil))

;Solution to Problem 4
(defun MULTIPLE-MEMBER 
    (a b)
    (if (and (or (numberp a) (symbolp a)) (listp b))
        (member a (cdr(member a b)))
        (list 'error)))


;Solution to Problem 5
(defun MONTH->INTEGER
    (a)
    (if (eq a 'January)
      1
      (if(eq a 'February)
      2
      (if(eq a 'March)
      3
      (if(eq a 'April)
      4
      (if(eq a 'May)
      5
      (if(eq a 'June)
      6
      (if(eq a 'July)
      7
      (if(eq a 'August)
      8
      (if(eq a 'September)
      9
      (if(eq a 'October)
      10
      (if(eq a 'November)
      11
      (if(eq a 'December)
      12
    'Error)))))))))))))


;Solution to Problem 6
(defun SCORE->GRADE 
    (a)
    (if (numberp a)
        (cond 
            ((and (>= a 90)) 'A)
            ((and (< a 90) (>= a 87)) 'A-)
            ((and (< a 87) (>= a 83)) 'B+)
            ((and (< a 83) (>= a 80)) 'B)
            ((and (< a 80) (>= a 77)) 'B-)
            ((and (< a 77) (>= a 73)) 'C+)
            ((and (< a 73) (>= a 70)) 'C)
            ((and (< a 70) (>= a 60)) 'D)
            ((and (< a 60)) 'F)
            (t nil))
            nil))

;Solution to Problem 7
(defun  GT 
    (a b)
    (and (numberp a) (numberp b)
         (and (> a b) T)))

;Solution to Problem 8
(defun SAME-SIGN 
    (a b)
    (and (and (numberp a) (numberp b))
         (or (and (zerop a) (zerop b)) (and (plusp a) (plusp b)) (and (minusp a) (minusp b))) 
         T))

;Solution to Problem 9
(defun SAFE-DIV 
    (a b)
    (and (and (numberp a) (numberp b)) (and (not (zerop b)))
         (/ a b)))


    




