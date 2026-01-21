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

✅ 4.0 Zaimplementuj endpoint, który zwróci słownik (student, godziny nauki), która wykorzysta funkcją mapreduce oraz groupBy dla słownika na wejściu
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/b27009187f18a0bdca3451c92b981b8cfbdc5676)

https://github.com/user-attachments/assets/a317101f-adea-4643-b89a-fd3f8b63e80f

Kod: [Link do zadania 5](https://hub.docker.com/r/pnykiel3/assignment5)
</details>

<details><summary><strong>Zestaw 6 - Haskell</strong></summary>
    
✅ 3.0 Zaimplementuj funkcję isSorted, która sprawdza czy dana funkcja jest posortowana zgodnie z podaną funkcją porównawczą
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/6f3e5fcf9dace9a73f5e4ae8a4143baee9c58ae0)

https://github.com/user-attachments/assets/983118ad-d813-4c93-8086-9b4ade7fc5eb

✅ 3.5 Zaimplementuj funkcję, która zsumuje liczby po wierszach z trzech list na wejściu; wykorzystaj funkcję sprowadzi funkcję z trzema argumentami, do funkcji z dwoma
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/1f4f5e9dff8fbf70e5bf934f5045179a54135ce9)

https://github.com/user-attachments/assets/0a9f0f0d-28b0-4125-b115-639e8c1c72fa
    
✅ 4.0 Zaimplementuj funkcję setHead, która doda element na początku listy
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/885f12820d51112430e1cecfd8f217052d88db5d)

https://github.com/user-attachments/assets/fd951633-5ccc-481a-b606-899c89a48947

✅ 4.5 Zaimplementuj funkcję append, która doda element we wskazanym miejscu w liście
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/88b35ef00dbf82a7edc6dde4019b8a6956623341)

https://github.com/user-attachments/assets/e17c3718-a8ec-4e61-8569-4bc3bd54cfd8
    
✅ 5.0 Zaimplementuj funkcję, która policzy kwadrat liczb z dwóch list (po wierszach) za pomocą funkcji map oraz funkcji anonimowej
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/25f24e04c0ddc7827c0a7c892cc70c80336ff4e1)

https://github.com/user-attachments/assets/5685f4e7-d3ba-44f4-881b-6e5d94029a8c

Kod: [Link do zadania 6](https://hub.docker.com/r/pnykiel3/assignment6)

</details>

<details><summary><strong>Zestaw 7 - Haskell - maszyna stanów</strong></summary>
    
✅ 3.0 Zaimplementuj funkcję, która zwróci wartość między 0, a maxvalue of Int włącznie
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/0ce12c81274a44b8b14b2548d4c58b50f9a66570)

https://github.com/user-attachments/assets/1b3954bb-6aff-4288-9e01-ca548fa91f89

✅ 3.5 Zaimplementuj funkcję, która zwróci wartość między 0, a 1 (Double) z wyłączeniem 1
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/85211b34f75f2f85b09d5bcd9e253971ec94d8f0)

https://github.com/user-attachments/assets/77061c34-8a11-4821-9a93-85320e4a2da4
    
✅ 4.0 Zaimplementuj funkcję, która zwróci pary (Int, Double), (Double, Int) oraz krotki (Double, Double, Double) wykorzystując funkcje z ocen 3.0 oraz 3.5
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/71600dd2ccd047e48299a4e7a6efa275f520a17e)

https://github.com/user-attachments/assets/f8949b75-de1b-4cfe-bb36-4ecb819f2c3c

✅ 4.5 Zaimplementuj funkcję, która zwróci wartość jak w funkcji 3.5, ale wykorzysta map
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/2e66a1fb018a4b08c7d18edefe3d0727a7b7785d)

https://github.com/user-attachments/assets/ee1ec64e-a4ec-4541-9e8f-a066b3988096

✅ 5.0 Zaimplementuj funkcję, która zwróci wartość jak w funkcji 3.5, ale wykorzysta flatMap
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/b15acecdd994ab399385c984a4549d25662728d9)

https://github.com/user-attachments/assets/fb51708c-07f6-40f8-b609-99bba41c48a5

Kod: [Link do zadania 7](https://hub.docker.com/r/pnykiel3/assignment7)

</details>

<details><summary><strong>Zestaw 8 - Haskell - monoidy, monady, funktory</strong></summary>
    
✅ 3.0 Zaimplementuj funkcję, która wykorzysta metodę map fuktora do wykonania funkcji dodawania lub odejmowania na dwóch wartość przyjętych na wejściu
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/79b23742b41c1e329977a95eb67c58485326ed3c)

https://github.com/user-attachments/assets/2d71349b-1b6a-4e22-adb3-e6781089460d

✅ 3.5 Zaimplementuj funkcję, która zwróci wartość konkatenacji trzech list za pomocą monoidów
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/c70604487fc7b40a668d5eacba8fa0d9e64cd7c8)

https://github.com/user-attachments/assets/366aaefc-aae5-4d31-8f78-fb4217f98a82
    
✅ 4.0 Zaimplementuj funkcję, która zwróci wartość sumy listy liczb lub zwróci nil; zaimplementuj wykorzystując monady
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/282b65e0b71ed59b468b781ea4a666fe1e2ab141)

https://github.com/user-attachments/assets/d0122554-1b7c-43cc-b23a-0b486aab5b2c

✅ 4.5 Zaimplementuj funkcję, która zwróci zadanie z zestawu 6 na ocenę 4.0 i wykorzysta metodę combine oraz join
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/282b65e0b71ed59b468b781ea4a666fe1e2ab141)

https://github.com/user-attachments/assets/25856d14-fa6a-422b-aaa0-ec461fd79fad

Kod: [Link do zadania 8](https://hub.docker.com/r/pnykiel3/assignment8)

</details>

<details><summary><strong>Zestaw 9 - JavaScript</strong></summary>
    
✅ 3.0 Zaimplementuj funkcję, która wzwróci wartość binarną czy podana na wejściu liczba jest liczbą pierwszą; wykorzysta Promise
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/b7e0497d4e5c11eeac9e45372e16fb844d9bc8f0)

https://github.com/user-attachments/assets/8054879b-8508-4822-b496-cafcc7f69720

✅ 3.5 Zaimplementuj funkcję, która zwróci posortowaną listę; wykorzysta Promise
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/14b033c16f07e3a82ffafd516c67459dfe2138a1)

https://github.com/user-attachments/assets/53fa5a89-6406-4fa6-9807-95a8a44af941
    
✅ 4.0 Zaimplementuj funkcję, która zwróci wynik funkcji z zad. 5 na 4.0 (mapreduce); wykorzysta worker_threads
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/5ffb722073121e1bcfbdd9e3bf815da825cb4a01)

https://github.com/user-attachments/assets/1169a275-2dcb-491b-b016-74c71a6d83cd

Kod: [Link do zadania 9](https://hub.docker.com/r/pnykiel3/assignment9)
</details>
<details><summary><strong>Zestaw 10 - Microsoft Azure</strong></summary>
    
Przygotuj 3 wybrane funkcje w JS oraz udostępnij w ramach usługi Azure Functions
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/7cf265a8be82c7c0178313ef473c85f8f9180b94)

Adres bazowy API: <br>
`https://aaaa1-gpb2hjcpbcacf3cz.spaincentral-01.azurewebsites.net/api/`

https://github.com/user-attachments/assets/003dd545-da52-4a5b-863a-9d83058d8875

Przygotuj 3 wybrane funkcje w Haskellu w ramach Azure App Services. Wykorzystaj obraz dockerowy.
[Commit](https://github.com/pnykiel3/uj_functional_programming/commit/0bf9eeebe732d086ce43f3c931bb7369d1c2d909)

Adres serwera: <br>
`https://pnykiel3-haskell-anc6ewb2faehftej.spaincentral-01.azurewebsites.net`

https://github.com/user-attachments/assets/94f69868-c78d-4c2f-b178-5e030bdfa919

</details>