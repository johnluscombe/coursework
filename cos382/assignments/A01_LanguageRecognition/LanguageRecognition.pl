#!/usr/bin/perl

# S = B\s*R\s*T
# B = O\s*N
# R = (X(\s*;\s*X)*)?
# X = C(\s*:\s*V)?
# C = D
# V = L(\s*,\s*L)?
# L = D(\s*-\s*D)?
# T = (\(N\))?
# O = [0-9]?
# D = [0-9]+
# N = [a-zA-Z]+

# S = [0-9]?\s*[a-zA-Z]+\s*([0-9]+(\s*:\s*[0-9]+(\s*-\s*[0-9]+)?(\s*,\s*[0-9]+(\s*-\s*[0-9]+)?)?)?(\s*;\s*[0-9]+(\s*:\s*[0-9]+(\s*-\s*[0-9]+)?(\s*,\s*[0-9]+(\s*-\s*[0-9]+)?)?)?)*)?\s*(\([a-zA-Z]+\))?
# B = [0-9]?\s*[a-zA-Z]+
# R = ([0-9]+(\s*:\s*[0-9]+(\s*-\s*[0-9]+)?(\s*,\s*[0-9]+(\s*-\s*[0-9]+)?)?)?(\s*;\s*[0-9]+(\s*:\s*[0-9]+(\s*-\s*[0-9]+)?(\s*,\s*[0-9]+(\s*-\s*[0-9]+)?)?)?)*)?
# X = [0-9]+(\s*:\s*[0-9]+(\s*-\s*[0-9]+)?(\s*,\s*[0-9]+(\s*-\s*[0-9]+)?)?)?
# C = [0-9]+
# V = [0-9]+(\s*-\s*[0-9]+)?(\s*,\s*[0-9]+(\s*-\s*[0-9]+)?)?
# L = [0-9]+(\s*-\s*[0-9]+)?
# T = (\([a-zA-Z]+\))?
# O = [0-9]?
# D = [0-9]+
# N = [a-zA-Z]+
# digit = [0-9]
# letter = [a-zA-Z]

print "Enter Bible reference to check: ";
my $ref = <STDIN>;
chomp $ref;

if ($ref =~ /^[0-9]?\s*[a-zA-Z ]+\s*([0-9]+(\s*:\s*[0-9]+(\s*-\s*[0-9]+)?(\s*,\s*[0-9]+(\s*-\s*[0-9]+)?)?)?(\s*;\s*[0-9]+(\s*:\s*[0-9]+(\s*-\s*[0-9]+)?(\s*,\s*[0-9]+(\s*-\s*[0-9]+)?)?)?)*)?\s*(\([a-zA-Z]+\))?$/) {
    print "Valid Bible reference!\n"
} else {
    print "Invalid Bible reference.\n"
}
