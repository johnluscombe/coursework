isPrimeHelper(N, Divisor) :-
    N is Divisor -> true;
    0 is N mod Divisor -> false;
    isPrimeHelper(N, Divisor+1).

isPrime(N) :-
    N < 2 -> false; isPrimeHelper(N, 2).

primesHelper(Limit, PotentialPrime, PrimesList, Primes) :-
    Limit < 2 -> Primes = [];
    PotentialPrime > Limit -> Primes = PrimesList;
    isPrime(PotentialPrime) -> append(PrimesList, [PotentialPrime], NewPrimesList),
    Sum is PotentialPrime+1,
    primesHelper(Limit, Sum, NewPrimesList, Primes);
    Sum is PotentialPrime+1,
    primesHelper(Limit, Sum, PrimesList, Primes).

primes(Limit, Primes) :-
    primesHelper(Limit, 2, [], Primes).

primePartitionHelper(N, WorkingList, PrimesList, PrimePartition) :-
    N = 0 -> atomic_list_concat(WorkingList, " + ", Partition),
    write(Partition),
    nl;
    N < 0 -> PrimePartition = [];
    PrimesList = [] -> PrimePartition = [];
    PrimesList = [CPN|PrimesListTail],
    append(WorkingList, [CPN], NewWorkingList),
    Difference is N-CPN,
    primePartitionHelper(Difference, NewWorkingList, PrimesListTail, PrimePartition),
    primePartitionHelper(N, WorkingList, PrimesListTail, PrimePartition).

primePartition(PrimePartition) :-
    write("Choose number to partition: "),
    read(N),
    primes(N, Primes),
    primePartitionHelper(N, [], Primes, PrimePartition).
