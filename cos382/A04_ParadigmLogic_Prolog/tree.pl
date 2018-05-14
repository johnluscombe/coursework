%%%%%%%%%%%%%%%%%%%%%%%%%%
% tree.pl
% https://gfx.cse.taylor.edu/courses/cos382/assignments/04_ParadigmLogic_Prolog/04_ParadigmLogic_Prolog.md.html
% The goal of this assignment is to write a collection of Prolog rules to represent and manipulate binary trees.
%%%%%%%%%%%%%%%%%%%%%%%%%%


%%%%%%%%%%%%%%%%%%%%%%%%%%
% Starter code

% binary_tree(Tree)
% "Tree" is a binary tree.

binary_tree(void).
binary_tree(tree(_,Left,Right)) :-  binary_tree(Left),
                                    binary_tree(Right).


% tree_member(Element,Tree)
% "Element" is an element of the binary tree "Tree".

tree_member(X,tree(X,_,_)).
tree_member(X,tree(_,Left,_)) :- tree_member(X,Left).
tree_member(X,tree(_,_,Right)) :- tree_member(X,Right).



% preorder(Tree,Pre)
% "Pre" is a list of elements of "Tree" accumulated during a
% preorder traversal.

preorder(tree(X,L,R),Xs) :- preorder(L,Ls), preorder(R,Rs),
                            append([X|Ls],Rs,Xs).
preorder(void,[]).



% append(Xs,Ys,XsYs)
% "XsYs" is the result of appending the lists "Xs" and "Ys".

append([],Ys,Ys).
append([X|Xs],Ys,[X|Zs]) :- append(Xs,Ys,Zs).


% Some sample trees
%
%    tree1       tree2         tree3             tree4
%
%      2           4             6                 6
%     / \         / \           / \               / \
%    1   5       5   6         2   7             2   7
%                            / \               / \
%                           1   5             1   5
%                              /
%                             3
%

tree1(tree(2,tree(1,void,void),tree(5,void,void))).
tree2(tree(4,tree(5,void,void),tree(6,void,void))).
tree3(
        tree(   6,
                tree(   2,
                        tree(1,void,void),
                        tree(   5,
                                tree(3,void,void),
                                void
                        )
                ),
                tree(7,void,void)
        )
).
tree4(
        tree(   6,
                tree(   2,
                        tree(1,void,void),
                        tree(   5,
                                void,
                                void
                        )
                ),
                tree(7,void,void)
        )
).



%%%%%%%%%%%%%%%%%%%%%%%%%%
% Place your code here


% Additional sample data


inorder(tree(X, L, R), Xs) :-
    inorder(L, Ls),
    inorder(R, Rs),
    append(Ls, [X|Rs], Xs).

inorder(void, [ ]).


search(tree(X, L, R), Key) :-
    search(L, Key);
    search(R, Key);
    X == Key.


binsearch(tree(X, _, _), X).

binsearch(tree(X, _, R), Key) :-
    binsearch(R, Key),
    X < Key.

binsearch(tree(X, L, _), Key) :-
    binsearch(L, Key),
    X > Key.


subtree(S, tree(_, L, R)) :-
    subtree(S, L);
    subtree(S, R).

subtree(T, T).


sumtree(tree(X, L, R), Sum) :-
    sumtree(L, LeftSum),
    sumtree(R, RightSum),
    Sum is X + LeftSum + RightSum.

sumtree(void, 0).


bigger(X, tree(Y, L, R)) :-
    bigger(X, L),
    bigger(X, R),
    X > Y.

bigger(_, void).

smaller(X, tree(Y, L, R)) :-
    smaller(X, L),
    smaller(X, R),
    X < Y.

smaller(_, void).

ordered(tree(X, L, R)) :-
    ordered(L),
    ordered(R),
    bigger(X, L),
    smaller(X, R).

ordered(void).


substitute(X, Y, tree(X, L, R), tree(Y, TreeL, TreeR)) :-
    substitute(X, Y, L, TreeL),
    substitute(X, Y, R, TreeR).

substitute(X, Y, tree(Z, L, R), tree(Z, TreeL, TreeR)) :-
    (
        substitute(X, Y, L, TreeL),
        substitute(X, Y, R, TreeR)
    ),
    \+(X == Z).

substitute(_, _, void, void).
