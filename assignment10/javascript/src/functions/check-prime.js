const { app } = require('@azure/functions');

app.http('check-prime', {
    methods: ['GET', 'POST'],
    authLevel: 'anonymous',
    handler: async (request, context) => {
        let n;
        try {
            const body = await request.json();
            n = parseInt(body.number);
        } catch (e) {
            n = parseInt(request.query.get('number'));
        }

        if (isNaN(n)) {
            return { status: 400, body: "Please pass a number" };
        }

        let isPrime = true;
        if (n < 2) isPrime = false;
        else {
            for (let i = 2; i <= Math.sqrt(n); i++) {
                if (n % i === 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        return { jsonBody: { number: n, isPrime: isPrime ? 1 : 0 } };
    }
});