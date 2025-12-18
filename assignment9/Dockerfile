FROM node:18-alpine

WORKDIR /app

RUN npm init -y && \
    npm install express

COPY main.js .
COPY worker.js .

EXPOSE 3000

CMD ["node", "main.js"]