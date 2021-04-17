var capitals = function (word) {
  let ans = [];
  
  for (let i = 0; i < word.length; ++i) {
    // Check if ith character is uppercase
    if (word[i] == word[i].toUpperCase()) ans.push(i);
  }
  
  // Return array of indexes where uppercase occurs
  return ans;
};