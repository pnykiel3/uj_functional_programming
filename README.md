# Functional Programming Portfolio

A collection of functional programming projects in **Scala**, **Haskell**, and **JavaScript** — from core concepts like immutability and higher-order functions to advanced topics like monads and cloud deployments.

---

## Skills at a Glance

| Category | What I've Worked With |
|----------|----------------------|
| **Languages** | Scala, Haskell, JavaScript |
| **FP Concepts** | Pure Functions, Immutability, Higher-Order Functions, Currying, Pattern Matching |
| **Type Systems** | Option/Maybe, Either, Monads, Monoids, Functors |
| **Concurrency** | Promises, Worker Threads, State Machines |
| **DevOps** | Docker, Azure Functions, Azure App Services |
| **Web APIs** | REST endpoints with Cask (Scala) |

---

## Projects

### Scala — Functional Fundamentals & REST APIs

Scala blends object-oriented and functional paradigms, which makes it great for building type-safe, concurrent applications. I used the **Cask** framework (a lightweight HTTP micro-framework similar to Flask) to expose these implementations as REST APIs.

<details><summary><strong>List Operations & Higher-Order Functions</strong></summary>

The bread and butter of functional programming — functions that take other functions as arguments, enabling flexible and reusable code.

**What I implemented:**
- `isSorted` — checks if a list is sorted using a custom comparator function
- `setHead` / `append` — immutable list operations that return new lists instead of modifying existing ones
- `tail` / `drop` / `dropWhile` — list transformations using pattern matching and predicate functions
- Function currying — converting a 3-argument function into chainable single-argument functions
- Row-wise operations with `map` and anonymous functions

I also built a custom **doubly linked list** with functional operations, showing how traditionally mutable structures can be handled immutably.

**Source Code:**  
[Main.scala (Set 1)](https://github.com/pnykiel3/uj_functional_programming/blob/main/assignment1/src/main/scala/Main.scala) |
[Main.scala (Set 3)](https://github.com/pnykiel3/uj_functional_programming/blob/main/assignment3/src/main/scala/Main.scala) |
[DoubleLinkedList.scala](https://github.com/pnykiel3/uj_functional_programming/blob/main/assignment3/src/main/scala/DoubleLinkedList.scala)

**Docker:** [Set 1](https://hub.docker.com/r/pnykiel3/cask-asgn1) | [Set 3](https://hub.docker.com/r/pnykiel3/assignment3)

</details>

<details><summary><strong>Type-Safe Error Handling (Option & Either)</strong></summary>

Instead of null checks and exceptions, functional programming uses types like `Option` and `Either` to make failures explicit — the compiler won't let you forget to handle edge cases.

**What I implemented:**
- Safe list operations returning `Option[T]` — values are either `Some(result)` or `None`, never null
- Statistical calculations (variance, mean) that chain operations with `flatMap` and `map`
- List merging with `Option` — returns `None` if either input is missing
- Custom `myMap[A,B,C]` function demonstrating monadic composition
- Mean calculation with `Either` — returns `Left("error message")` or `Right(result)`

**Source Code:** [View Code](https://github.com/pnykiel3/uj_functional_programming/tree/main/assignment4)

**Docker:** [Option/Either Examples](https://hub.docker.com/r/pnykiel3/assignment4)

</details>

<details><summary><strong>MapReduce for Data Aggregation</strong></summary>

MapReduce is a two-phase pattern: transform elements independently (Map), then combine results (Reduce). It's the foundation of frameworks like Spark and Hadoop.

**What I implemented:**
- Frequency counter — counts how many times each number appears in a list
- Number cubing with MapReduce
- Student study hours aggregation using `mapreduce` + `groupBy`

**Source Code:** [View Code](https://github.com/pnykiel3/uj_functional_programming/tree/main/assignment5)

**Docker:** [MapReduce Examples](https://hub.docker.com/r/pnykiel3/assignment5)

</details>

---

### Haskell — Pure Functional Programming

Haskell enforces purity — functions can't have side effects, and all data is immutable. This means highly predictable code where the type system catches bugs at compile time.

<details><summary><strong>Core Functions & Pattern Matching</strong></summary>

**What I implemented:**
- `isSorted` — recursive function with pattern matching on list structure
- `setHead` / `append` — pure list operations using Haskell's cons operator (`:`)
- Currying — in Haskell, all functions are automatically curried, so a 3-parameter function can be partially applied at any point

**Source Code:** [View Code](https://github.com/pnykiel3/uj_functional_programming/tree/main/assignment6)

**Docker:** [Haskell Basics](https://hub.docker.com/r/pnykiel3/assignment6)

</details>

<details><summary><strong>State Machines & Random Number Generation</strong></summary>

In pure FP, functions can't maintain internal state. The solution is **state threading** — passing state explicitly through function parameters and return values.

**What I implemented:**
- Pure RNG returning integers [0, maxInt] — the function returns both the number and a new seed
- Double generator [0, 1) with function composition
- Tuple generators combining multiple stateful computations
- State transformations using `map` and `flatMap`

**Source Code:** [View Code](https://github.com/pnykiel3/uj_functional_programming/tree/main/assignment7)

**Docker:** [State Machine RNG](https://hub.docker.com/r/pnykiel3/assignment7)

</details>

<details><summary><strong>Monoids, Monads & Functors</strong></summary>

These are abstract patterns (type classes) that capture common behaviors across different types:

- **Functor** — anything you can "map over" (like lists, Maybe, etc.)
- **Monoid** — anything with an associative operation and identity (strings with concat, numbers with addition)
- **Monad** — for sequencing computations that produce wrapped values

**What I implemented:**
- Arithmetic operations using Functor's `fmap`
- List concatenation with Monoid's `mappend`
- Safe summation using Monad's bind (`>>=`)
- `combine` and `join` for monadic composition

**Source Code:** [View Code](https://github.com/pnykiel3/uj_functional_programming/tree/main/assignment8)

**Docker:** [Algebraic Abstractions](https://hub.docker.com/r/pnykiel3/assignment8)

</details>

---

### JavaScript — Async FP & Concurrency

JavaScript is single-threaded and event-driven, so async programming is essential. **Promises** bring functional composition to async code, and **Worker Threads** enable true parallelism.

<details><summary><strong>Promises & Worker Threads</strong></summary>

**What I implemented:**
- Async prime checker using Promises
- Async list sorting with Promises
- **Parallel MapReduce with Worker Threads** — distributes computation across threads, uses `postMessage` for inter-thread communication, and coordinates results with Promises

**Source Code:** [View Code](https://github.com/pnykiel3/uj_functional_programming/tree/main/assignment9)

**Docker:** [Async JS Examples](https://hub.docker.com/r/pnykiel3/assignment9)

</details>

---

### Cloud Deployments — Microsoft Azure

Taking functional code from local Docker containers to production cloud infrastructure.

<details><summary><strong>Azure Functions (Serverless JavaScript)</strong></summary>

Azure Functions runs code on-demand without managing servers — you only pay for execution time. Perfect for stateless, event-triggered functions.

3 JavaScript functions deployed as serverless endpoints.

**API Endpoint:** `https://aaaa1-gpb2hjcpbcacf3cz.spaincentral-01.azurewebsites.net/api/`

**Source Code:** [View Commit](https://github.com/pnykiel3/uj_functional_programming/commit/7cf265a8be82c7c0178313ef473c85f8f9180b94)

</details>

<details><summary><strong>Azure App Services (Containerized Haskell)</strong></summary>

Haskell apps packaged in Docker and deployed to Azure's managed platform with automatic scaling and SSL.

3 Haskell functions containerized and deployed.

**Server:** `https://pnykiel3-haskell-anc6ewb2faehftej.spaincentral-01.azurewebsites.net`

**Source Code:** [View Commit](https://github.com/pnykiel3/uj_functional_programming/commit/0bf9eeebe732d086ce43f3c931bb7369d1c2d909)

</details>

---

### Docker Infrastructure

Custom development environment based on Ubuntu LTS with Java 8, Scala + sbt, Python 3, and vim.

**Docker:** [Development Environment](https://hub.docker.com/r/pnykiel3/assignment2)

---

## Repository Structure

```
uj_functional_programming/
├── assignment1/    # Scala - List operations, currying
├── assignment2/    # Docker environment
├── assignment3/    # Scala - Doubly linked list, pattern matching
├── assignment4/    # Scala - Option/Either error handling
├── assignment5/    # Scala - MapReduce patterns
├── assignment6/    # Haskell - Core FP, recursion
├── assignment7/    # Haskell - State machines, RNG
├── assignment8/    # Haskell - Monoids, Monads, Functors
├── assignment9/    # JavaScript - Promises, Workers
└── assignment10/   # Azure cloud deployments
```

---

## Quick Start

All projects are containerized. To run any of them:

```bash
docker pull pnykiel3/<assignment-name>
docker run -p 8080:8080 pnykiel3/<assignment-name>
```

Example:
```bash
docker pull pnykiel3/assignment4
docker run -p 8080:8080 pnykiel3/assignment4
# API available at http://localhost:8080
```

---

<details><summary><h2>Wersja Polska 🇵🇱</h2></summary>

### Umiejętności

| Kategoria | Technologie |
|-----------|-------------|
| **Języki** | Scala, Haskell, JavaScript |
| **Koncepcje FP** | Czyste funkcje, Niemutowalność, Funkcje wyższego rzędu, Currying, Pattern Matching |
| **Systemy typów** | Option/Maybe, Either, Monady, Monoidy, Funktory |
| **Współbieżność** | Promises, Worker Threads, Maszyny stanów |
| **DevOps** | Docker, Azure Functions, Azure App Services |

### Projekty

**Scala:**
- Operacje na listach, funkcje wyższego rzędu, currying
- REST API z Cask
- Bezpieczna obsługa błędów (Option/Either)
- Wzorzec MapReduce

**Haskell:**
- Czyste funkcje, rekurencja, pattern matching
- Maszyny stanów, generator liczb losowych
- Monoidy, Monady, Funktory

**JavaScript:**
- Promises i programowanie asynchroniczne
- Worker Threads i równoległe obliczenia

**Chmura:**
- Azure Functions (JavaScript)
- Azure App Services (Haskell + Docker)

</details>