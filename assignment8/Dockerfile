FROM haskell:latest

WORKDIR /app

RUN cabal update && \
    cabal install --lib scotty aeson text

COPY Main.hs .

RUN ghc -O2 -threaded Main.hs -o main

EXPOSE 8080

CMD ["./main"]