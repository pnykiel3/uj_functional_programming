const { app } = require('@azure/functions');

app.http('mySort', {
    methods: ['POST'],
    authLevel: 'anonymous',
    handler: async (request, context) => {
        let list;
        try {
            const body = await request.json();
            list = body.list;
        } catch (error) {
            return { status: 400, body: "Invalid JSON" };
        }

        if (!list || !Array.isArray(list)) {
            return { status: 400, body: "Please pass a 'list' array" };
        }

        const sorted = [...list].sort((a, b) => a - b);

        return { jsonBody: { succes: true, result: sorted } };
    }
});