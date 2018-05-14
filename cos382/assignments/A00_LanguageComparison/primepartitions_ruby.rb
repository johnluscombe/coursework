def is_prime(n)
  if n < 2
    false
  else
    (2..n-1).each do |divisor|
      return false if n % divisor == 0
    end
    true
  end
end

def primes(limit)
  if limit < 2
    []
  else
    primes_list = []
    (2..limit).each do |num|
      primes_list.push(num) if is_prime(num)
    end
    primes_list
  end
end

def prime_partition_list_to_string(list)
  string = ''
  list.each do |num|
    string += num.to_s + ' + '
  end
  string[0...string.length-3]
end

def prime_partition_helper(n, k, working_list)
  if n == 0
    puts prime_partition_list_to_string(working_list)
  elsif n <= k
    return
  else
    primes(n).each do |num|
      prime_partition_helper(n-num, num, working_list + [num]) if num > k
    end
  end
end

def prime_partition
  print "Choose number to partition: "
  n = gets.to_i
  prime_numbers = primes(n)
  prime_partition_helper(n, 1, [])
end

prime_partition
