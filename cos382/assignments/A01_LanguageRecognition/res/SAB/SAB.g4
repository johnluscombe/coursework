grammar SAB;

s : 'a' a
  | 'b' b;
    
a : 'b' 'c'
  | 'c' b;
    
b : 'c' 'd'
  | 'd' a;
