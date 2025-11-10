# Programowanie funkcyjne


## Zestaw 1 - Scala, Docker, Cask

✅ 3.0 Zaimplementuj funkcję isSorted, która sprawdza czy dana funkcja jest posortowana zgodnie z podaną funkcją porównawczą

✅ 3.5 Zaimplementuj funkcję, która zsumuje liczby po wierszach z trzech list na wejściu; wykorzystaj funkcję sprowadzi funkcję z trzema argumentami, do funkcji z dwoma

✅ 4.0 Zaimplementuj funkcję setHead, która doda element na początku listy

✅ 4.5 Zaimplementuj funkcję append, która doda element we wskazanym miejscu w liście

✅ 5.0 Zaimplementuj funkcję, która policzy kwadrat liczb z dwóch list (po wierszach) za pomocą funkcji map oraz funkcji anonimowej

Plik Main.scala [Link](https://github.com/pnykiel3/uj_functional_programming/blob/main/assignment1/src/main/scala/Main.scala)

Kod: [Link do zadania 1](https://hub.docker.com/r/pnykiel3/cask-asgn1)

![Demo](https://github.com/user-attachments/assets/d5c64052-4e22-4151-ba8e-2190b5357a74)

## Zestaw 2 - Docker

✅   Stwórz obraz dockerowy, który bazuje na najnowszej wersji Ubuntu LTS oraz który zawiera paczki:
- Java 8
- Python 3
- Scala (dowolna wersja)
- sbt
- vim  

[Link do commit](https://github.com/pnykiel3/uj_functional_programming/commit/e02d12608662d73ad3e80f0503e572f76baab362)  
Kod: [Link do zadania 2](https://hub.docker.com/r/pnykiel3/assignment2)
## Zestaw 3  - Scala, Docker, Cask

✅ 3.0 Zaimplementuj endpoint, który zwróci wynik funkcji tail, która usuwa pierwszy element z listy
![Demo](https://github.com/user-attachments/assets/d018a14f-9e3c-4e6a-bb41-6282e92e712a)

✅ 3.5 Zaimplementuj endpoint, zwróci wynik funkcji drop, która usuwa n elementów z listy dwukierunkowej
![Demo](https://github.com/user-attachments/assets/7f98086a-0a73-4f2b-9666-9e7eb0105901)

✅ 4.0 Zaimplementuj endpoint, zwróci wynik funkcji dropWhile, która usuwa n elementów z listy dwukierunkowej, które spełniają warunek funkcji (parametr); należy wykorzystać podejście pattern match
![Demo](https://github.com/user-attachments/assets/8d125cfa-01c2-4551-8c21-48b475a6743a)

Plik Main.scala [Link](https://github.com/pnykiel3/uj_functional_programming/blob/main/assignment3/src/main/scala/Main.scala)
Plik DoubleLinkedList.scala [Link](https://github.com/pnykiel3/uj_functional_programming/blob/main/assignment3/src/main/scala/DoubleLinkedList.scala)
Kod: [Link do zadania 3](https://hub.docker.com/r/pnykiel3/assignment3)
## Zestaw 4  - Either, Option, Docker, Cask

✅ 3.0 Zaimplementuj endpoint, który zwróci taki sam wynik jak zad.1 4.5 (append) ale wykorzysta typ opcjonalny
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/28fd9a19f9fc033350f5ac4be6c8a08c60c801c8)
![Demo](https://github.com/user-attachments/assets/6bd31986-c12b-451d-b61d-3e52c1612daa)

✅ 3.5 Zaimplementuj endpoint, który zwróci wariancję z listy; do implementacji wykorzystać należy typ opcjonalny
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/c8ae0a7d83abab5d4ae75024fb8a92773dde2c21)
![Demo](https://github.com/user-attachments/assets/6dd34955-7cf8-48c8-a2bc-1a0965a425b9)

✅ 4.0 Zaimplementuj endpoint, który zwróci listę (option), która jest wynikiem połączenia dwóch list (option); w przypadku gdy jedna z list jest None, funkcja powinna zwrócić None
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/dc10acbeec684aa4d248db5f27b721ca24b2814e)
![Demo](https://github.com/user-attachments/assets/8ea06b9e-7cfb-4fac-9a67-f17be4a371b1)

✅ 4.5 Zaimplementuj endpoint, który zwróci listę za pomocą metody mojeMap[A,B,C](a: Option[A], b:] Option[B])(f:(A,B)=>C):Option[C]; należy wykorzystać metodę flatMap oraz map
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/668f07a7bc427a878649c8949a6fc296892c18ec)
![Demo](https://github.com/user-attachments/assets/c5e159c2-5f8e-47f9-a335-004da484fd3c)

✅ 5.0 Zaimplementuj endpoint, który zwróci taki średnią (mean) z listy zwracając Either
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/b250ef2c351daaaaeb49150f32472f5266c8d84f)
![Demo](https://github.com/user-attachments/assets/8b2caf02-a733-4709-bfe9-618fccdf8907)

Kod: [Link do zadania 4](https://hub.docker.com/r/pnykiel3/assignment4)
