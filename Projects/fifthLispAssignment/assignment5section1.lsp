(defun my-index (N L)
   (let ((X (index (- N 1) (cdr L))))
      (if (eql N 1)
          (car L)
          x)))

(defun my-min-first (L)
   (let ((X (min-first (cdr L))))
      (if (> (car L) (car X))
          (append (list (car X) (car L)) (cdr X))
          L)))

(defun my-ssort (L)
   (let* ((L1 (min-first L))
          (X (ssort (cdr L1))))
          (cons (car L1) X)))

