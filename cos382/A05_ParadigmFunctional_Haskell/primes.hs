prods :: Int -> [Int]
prods n = [n*n, n*(n+1) ..]


mix :: [Int] -> [Int] -> [Int]
mix lst1 lst2
    | lst1 == [] && lst2 == [] = []
    | lst1 == [] = [head lst2] ++ (mix lst1 (tail lst2))
    | lst2 == [] = [head lst1] ++ (mix (tail lst1) lst2)
    | (head lst1) > (head lst2) = [head lst2] ++ (mix lst1 (tail lst2))
    | (head lst1) < (head lst2) = [head lst1] ++ (mix (tail lst1) lst2)
    | otherwise = [head lst1] ++ (mix (tail lst1) (tail lst2))


inList :: Int -> [Int] -> Bool
inList num numList
    | num < (head numList) = False
    | num == (head numList) = True
    | otherwise = inList num (tail numList)

sieve :: [Int] -> [Int] -> [Int]
sieve potentialPrimes composites
    | potentialPrimes == [] = []
    | (head potentialPrimes) < 2 = sieve (tail potentialPrimes) composites
    | composites == [] = [head potentialPrimes] ++ sieve (tail potentialPrimes) (mix composites (prods (head potentialPrimes)))
    | (head potentialPrimes) > (head composites) = sieve potentialPrimes (tail composites)
    | (head potentialPrimes) == (head composites) = sieve (tail potentialPrimes) composites
    | inList (head potentialPrimes) composites = sieve (tail potentialPrimes) composites
    | otherwise = [head potentialPrimes] ++ sieve (tail potentialPrimes) (mix composites (prods (head potentialPrimes)))


firstnHelper :: Int -> Int -> [Int]
firstnHelper n acc
    | (length (primesto acc)) == n = primesto acc
    | otherwise = firstnHelper n (acc+1)

firstn :: Int -> [Int]
firstn n = firstnHelper n 2


primesto :: Int -> [Int]
primesto n = sieve [2 .. n] []
