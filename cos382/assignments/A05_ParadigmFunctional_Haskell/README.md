# Programming in Functional Paradigm using Haskell

## Assignment Purpose

The purpose of this assignment was to get practice with using the functional
programming paradigm, specifically using Haskell. We were to create functions
to generate prime numbers, as described below.

- `prods n` generates the infinite list of products of `n` beginning with
  `n*n`. For example, `prods 3` results with the infinite list
  `[9, 12, 15, 18, 21, ...]`.

- `mix` takes two infinite lists (each assumed to be in order) and merges them
  into a single infinite list in order with no duplicates. For example,
  `mix (prods 5) (prods 7)` results with the infinite list
  `[25, 30, 35, 40, 45, 49, 50, 55, 56, 60, 63, ...]`.

- `sieve` implements the Sieve of Eratosthenes. The first parameter is a list
  of potential primes. The second parameter is the list of composites known so
  far. For example, `sieve [2 ..] []` results with the infinite list
  `[2, 3, 5, 7, 11, 13, 17, 19, 23, ...]`.

- `firstn n` returns the first `n` primes. For example, `firstn 10` results
  with the list `[2, 3, 5, 7, 11, 13, 17, 19, 23, 29]`.

- `primesto n` returns the primes up to and including `n` (inclusive). For
  example, `primesto 20` results with the list `[2, 3, 5, 7, 11, 13, 17, 19]`,
  and `primesto 7` results with the list `[2,3,5,7]`.

## Credit

- **Assignment Author**: Dr. Jonathan Denning, PhD