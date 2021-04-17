var alphabet = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';

var solution = function (word) {
  return word.split('').reduce(function (result, char, index) {
    var code = char.charCodeAt(0);
    if (code >= 65 && code <= 90) {
      result.push(index);
    }
    
    return result;
  }, []);
};

for (var i = 0; i < 20; i++) {
  var shuffled = alphabet.split('').sort(function () { return Math.random() - .5; });
  var word = shuffled.slice(0, 10).join('');
  
  Test.assertSimilar(capitals(word), solution(word));
}