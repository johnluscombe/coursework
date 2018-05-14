isPrimeHelper :: Integer -> Integer -> Bool
isPrimeHelper n divisor
    | divisor >= (n-1) = True
    | mod n divisor == 0 = False
    | otherwise = isPrimeHelper n (divisor+1)

isPrime :: Integer -> Bool
isPrime n
    | n < 2 = False
    | otherwise = isPrimeHelper n 2

primes :: Integer -> [Integer]
primes limit
    | limit < 2 = []
    | otherwise = filter (isPrime) [2..limit]

primePartitionListToString :: [Integer] -> [Char] -> [Char]
primePartitionListToString list workingList
    | list == [] = take (length(workingList)-3) $ workingList
    | otherwise = primePartitionListToString (tail list) (workingList ++ show(head list) ++ " + ")

primePartitionHelper :: Integer -> [Integer] -> [Integer] -> IO()
primePartitionHelper n workingList primesList =
    let cpn = head primesList
        primesListTail = tail primesList in
    if n == 0 then putStrLn(primePartitionListToString workingList "")
    else if n < 0 then return ()
    else if primesList == [] then return ()
    else
        primePartitionHelper (n-cpn) (workingList ++ [cpn]) (primesListTail) >>
        primePartitionHelper n workingList (primesListTail)

primePartition :: IO()
primePartition = do
    putStrLn "Choose number to partition"
    n <- getLine
    let intN = read n
    primePartitionHelper intN [] (primes intN)

main = primePartition
