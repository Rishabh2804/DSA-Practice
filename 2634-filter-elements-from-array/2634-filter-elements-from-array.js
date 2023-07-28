/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    let res = []
    arr.forEach((x, idx) => {
        if(fn(x, idx)) res.push(x)
    })
    
    return res;
};