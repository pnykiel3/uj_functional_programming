const { parentPort, workerData } = require('worker_threads');
const { task, data } = workerData;

function isPrime(num) {
    let n = parseInt(num);
    if (isNaN(n)) throw new Error("This is not a number");
    if (n < 2) return false;
    for (let i = 2; i <= Math.sqrt(n); i++) {
        if (n % i === 0) return false;
        }
    return true;
}

function mySort(arr) {
    if (!Array.isArray(arr)) throw new Error("Input is not an array");
    return arr.sort((a, b) => a - b);
}

try {
    let result;

    switch (task) {
        case 'isPrime':
            result = isPrime(data);
            break;
        case 'sort':
            result = mySort(data);
            break;
        default:
            throw new Error("Unknown task");
    }

    parentPort.postMessage(result);
} catch (error) {
    parentPort.postMessage({ error: error.message });
}