ourzip :: [a] -> [b] -> [(a, b)]
ourzip [] _ = []
ourzip _ [] = []
ourzip (x:xs) (y:ys) = (x, y):(ourzip xs ys)

mult :: Int -> [Int] -> [Int]
mult factor alist
    | alist == [] = []
    | otherwise = [factor * (head alist)] ++ (mult factor (tail alist))

mult2 :: Int -> [Int] -> [Int]
mult2 factor alist = map (factor*) alist

mult3 :: Int -> [Int] -> [Int]
mult3 factor alist
    | alist == [] = []
    | otherwise = [recMult factor (head alist)] ++ (mult factor (tail alist))

recMult :: Int -> Int -> Int
recMult a b
    | b == 0 = 0
    | otherwise = a + (recMult a (b-1))
