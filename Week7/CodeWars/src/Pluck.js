function pluck(objs, name) {
  // Map the objects to name using functional programming
  return objs.map(property => property[name]);
}