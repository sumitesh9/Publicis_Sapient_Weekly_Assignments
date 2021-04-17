objs = [
  {a:1, b:2, c: 3},
  {a:4, b:5, c: 6},
  {a:7, b:8, c: 9},
  {a:10, b:11},
]

Test.assertSimilar(pluck(objs, 'a'), [1,4,7,10]);
Test.assertSimilar(pluck(objs, 'b'), [2,5,8,11]);
Test.assertSimilar(pluck(objs, 'c'), [3,6,9,undefined]);