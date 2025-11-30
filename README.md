# Programowanie funkcyjne

<details><summary><strong>Zestaw 1 - Scala, Docker, Cask</strong></summary>
    
✅ 3.0 Zaimplementuj funkcję isSorted, która sprawdza czy dana funkcja jest posortowana zgodnie z podaną funkcją porównawczą
    
✅ 3.5 Zaimplementuj funkcję, która zsumuje liczby po wierszach z trzech list na wejściu; wykorzystaj funkcję sprowadzi funkcję z trzema argumentami, do funkcji z dwoma
    
✅ 4.0 Zaimplementuj funkcję setHead, która doda element na początku listy
    
✅ 4.5 Zaimplementuj funkcję append, która doda element we wskazanym miejscu w liście
    
✅ 5.0 Zaimplementuj funkcję, która policzy kwadrat liczb z dwóch list (po wierszach) za pomocą funkcji map oraz funkcji anonimowej
    
Plik Main.scala [Link](https://github.com/pnykiel3/uj_functional_programming/blob/main/assignment1/src/main/scala/Main.scala)
    
Kod: [Link do zadania 1](https://hub.docker.com/r/pnykiel3/cask-asgn1)
    
https://github.com/user-attachments/assets/d5c64052-4e22-4151-ba8e-2190b5357a74
</details>

<details><summary><strong>Zestaw 2 - Docker</strong></summary>

✅   Stwórz obraz dockerowy, który bazuje na najnowszej wersji Ubuntu LTS oraz który zawiera paczki:
- Java 8
- Python 3
- Scala (dowolna wersja)
- sbt
- vim  

[Link do commit](https://github.com/pnykiel3/uj_functional_programming/commit/e02d12608662d73ad3e80f0503e572f76baab362)  
Kod: [Link do zadania 2](https://hub.docker.com/r/pnykiel3/assignment2)
</details>

<details><summary><strong>Zestaw 3  - Scala, Docker, Cask</strong></summary>

✅ 3.0 Zaimplementuj endpoint, który zwróci wynik funkcji tail, która usuwa pierwszy element z listy

https://github.com/user-attachments/assets/0d2daa1a-5487-4397-b676-a7f119b42731

✅ 3.5 Zaimplementuj endpoint, zwróci wynik funkcji drop, która usuwa n elementów z listy dwukierunkowej

https://github.com/user-attachments/assets/041822b6-0839-4025-ac30-51e243b4297a

✅ 4.0 Zaimplementuj endpoint, zwróci wynik funkcji dropWhile, która usuwa n elementów z listy dwukierunkowej, które spełniają warunek funkcji (parametr); należy wykorzystać podejście pattern match

https://github.com/user-attachments/assets/dbd38adf-60f8-4d0e-8aea-a4e607ee88d2

Plik Main.scala [Link](https://github.com/pnykiel3/uj_functional_programming/blob/main/assignment3/src/main/scala/Main.scala)
Plik DoubleLinkedList.scala [Link](https://github.com/pnykiel3/uj_functional_programming/blob/main/assignment3/src/main/scala/DoubleLinkedList.scala)
Kod: [Link do zadania 3](https://hub.docker.com/r/pnykiel3/assignment3)
</details>

<details><summary><strong>Zestaw 4  - Either, Option, Docker, Cask</strong></summary>

✅ 3.0 Zaimplementuj endpoint, który zwróci taki sam wynik jak zad.1 4.5 (append) ale wykorzysta typ opcjonalny
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/28fd9a19f9fc033350f5ac4be6c8a08c60c801c8)

https://github.com/user-attachments/assets/c3afb0b3-d4e5-448d-9243-68c589fe212c

✅ 3.5 Zaimplementuj endpoint, który zwróci wariancję z listy; do implementacji wykorzystać należy typ opcjonalny
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/c8ae0a7d83abab5d4ae75024fb8a92773dde2c21)

https://github.com/user-attachments/assets/ae837f62-f012-4fbd-b2ed-f6542f8ebbb7

✅ 4.0 Zaimplementuj endpoint, który zwróci listę (option), która jest wynikiem połączenia dwóch list (option); w przypadku gdy jedna z list jest None, funkcja powinna zwrócić None
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/dc10acbeec684aa4d248db5f27b721ca24b2814e)

https://github.com/user-attachments/assets/16805a30-6df8-425f-b2f7-c0812e2d9007

✅ 4.5 Zaimplementuj endpoint, który zwróci listę za pomocą metody mojeMap[A,B,C](a: Option[A], b:] Option[B])(f:(A,B)=>C):Option[C]; należy wykorzystać metodę flatMap oraz map
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/668f07a7bc427a878649c8949a6fc296892c18ec)

https://github.com/user-attachments/assets/f8ec930c-0ae9-4e11-9970-621ef7cd4a37

✅ 5.0 Zaimplementuj endpoint, który zwróci taki średnią (mean) z listy zwracając Either
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/b250ef2c351daaaaeb49150f32472f5266c8d84f)

https://github.com/user-attachments/assets/07915ef7-e9b6-4c2b-a0b2-9de13a3a81d0

Kod: [Link do zadania 4](https://hub.docker.com/r/pnykiel3/assignment4)
</details>

<details><summary><strong>Zestaw 5 - Map</strong></summary>

✅ 3.0 Zaimplementuj endpoint, który zwróci słownik z liczbą powtarzających się liczb za pomocą funkcji mapreduce dla list z liczbami
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/201539a175e471876c8eec5c191a4c0aa2d099d3)

https://github.com/user-attachments/assets/9e6be348-c437-4581-8b2c-6da0ccb90692

✅ 3.5 Zaimplementuj endpoint, który zwróci słownik z liczbami podniesionymi do sześcianu za pomocą funkcji mapreduce dla list z liczbami
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/c451b7a460b5b05f551e25a2e24a9c72b06a54c4)

https://github.com/user-attachments/assets/32fd0564-1e79-4fb5-af79-9c63aaa4f09d

✅ 3.5 Zaimplementuj endpoint, który zwróci słownik (student, godziny nauki), która wykorzysta funkcją mapreduce oraz groupBy dla słownika na wejściu
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/b27009187f18a0bdca3451c92b981b8cfbdc5676)

https://github.com/user-attachments/assets/a317101f-adea-4643-b89a-fd3f8b63e80f

Kod: [Link do zadania 5](https://hub.docker.com/r/pnykiel3/assignment5)
</details>