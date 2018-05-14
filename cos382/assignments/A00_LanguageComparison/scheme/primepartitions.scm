#lang racket

(define (isPrimeHelper n divisor)
  (cond ((>= divisor (- n 1)) #t)
        ((= (modulo n divisor) 0) #f)
        (else (isPrimeHelper n (+ divisor 1)))))

(define (isPrime n)
  (cond ((< n 2) #f)
        (else (isPrimeHelper n 2))))

(define (primes limit)
  (cond ((< limit 2) '())
        (else (filter isPrime (range 2 (+ limit 1))))))

(define (primePartitionListToString primesList workingString)
  (cond ((equal? primesList '()) (substring workingString 0 (- (string-length workingString) 3)))
        (else (primePartitionListToString (cdr primesList)
          (string-append workingString (number->string (car primesList)) " + ")))))

(define (primePartitionHelper n workingList primesList)
  (begin
    (cond ((= n 0) (display (primePartitionListToString workingList "")) (newline))
          ((< n 0) (void))
          ((equal? primesList '()) (void))
          (else
            (let ([cpn (car primesList)] [primesListTail (cdr primesList)])
              (primePartitionHelper (- n cpn) (append workingList (list cpn)) primesListTail)
              (primePartitionHelper n workingList primesListTail))))))

(define (primePartition)
  (begin
    (display "Choose number to partition: ")
    (let ([n (read)])
      (primePartitionHelper n '() (primes n)))))

(primePartition)
