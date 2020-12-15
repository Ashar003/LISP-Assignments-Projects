; Question A
(defun my-sum (L)
   (let ((x (sum (cdr L))))
      (+ x (car L))))

; Question B
(defun my-neg-nums (L)
   (let ((X (neg-nums (cdr L))))
      (cond ((minusp (car L)) (cons (car L) X))
            (t (X)))))

; Question C
(defun my-inc-list-2 (L N)
   (let ((X (inc-list-2 (cdr L) N)))
      (cons (+ (car L) N) X)))

; Question D
(defun my-insert (N L)
   (let ((X (insert N (cdr L))))
      (cond ((< (car L) N) (cons (car L) X))
            (t (cons (cons (N) (car L)) X)))))

; Question E
(defun my-isort (L)
   (let ((X (isort (cdr L))))
      (insert (car L) X)))

; Question F
(defun my-split-list (L)
   (let ((X (split-list (cdr L))))
      (list (cons (car L) (car (cdr X))) (car X))))

; Question G
(defun my-partition (L P)
   (let ((X (partition (cdr L) P)))
      (cond ((< (car L) P) (list (cons(car L)(car X)) (cadr X)))
            (t (list (car x)(cons (car L)(cadr X)))))))
