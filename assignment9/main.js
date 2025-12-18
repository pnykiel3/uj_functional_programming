const express = require('express');
const { Worker } = require('worker_threads');
const app = express();

app.use(express.json());

function wakeWorkerUp (task, data) {
    return new Promise((resolve, reject) => {
        const worker = new Worker('./worker.js', {
            workerData: { task, data }
        });
        worker.on('message', resolve);
        worker.on('error', reject);
        worker.on('exit', (code) => {
            if (code !== 0)
                reject(new Error(`Worker stopped with exit code ${code}`));
        });
    });
}

app.get('/check-prime/:number', async (req, res) => {
    try {
        const result = await wakeWorkerUp('isPrime', req.params.number);
        res.json({ number: req.params.number, isPrime: result ? 1 : 0 });
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

app.listen(3000, () => {
    console.log(`Server runs on port 3000`);
});