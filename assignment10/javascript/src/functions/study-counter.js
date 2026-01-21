const { app } = require('@azure/functions');

app.http('studyCounter', {
    methods: ['POST'],
    authLevel: 'anonymous',
    handler: async (request, context) => {
        let data;
        try {
            const body = await request.json();
            data = body.data;
        } catch (error) {
            return { status: 400, body: "Invalid JSON" };
        }

        if (!data || !Array.isArray(data)) {
            return { status: 400, body: "Please pass 'data' array" };
        }

        const group = data.reduce((dict, entry) => {
            const student = entry.student;
            const study_hour = entry.study;
            if (!dict[student]) dict[student] = [];
            dict[student].push(study_hour);
            return dict;
        }, {});

        const result = {};
        for (const student in group) {
            const dictionary = group[student];
            const sum_hours = dictionary.reduce((a, b) => a + b, 0);
            result[student] = sum_hours;
        }

        return { jsonBody: { succes: true, result: result } };
    }
});