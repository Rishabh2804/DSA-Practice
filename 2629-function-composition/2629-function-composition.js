/**
 * @param {Function[]} functions
 * @return {Function}
 */
var compose = function(functions) {
    return functions.reduce((rest, end) => y => rest(end(y)), x => x);
};

/**
 * const fn = compose([x => x + 1, x => 2 * x])
 * fn(4) // 9
 */