# LeetCode Java Lab

Repositorio Maven con ejercicios de LeetCode en Java, organizados por tema y con pruebas automáticas.

## Estructura

- `src/main/java/arrays/` — problemas de arrays y hashing
- `src/main/java/strings/` — problemas de cadenas
- `src/main/java/trees/` — problemas de árboles binarios
- `src/main/java/dynamicprogramming/` — problemas de programación dinámica
- `src/main/java/graphs/` — problemas de grafos y recorrido
- `src/test/java/tests/` — pruebas unitarias con JUnit 5

## Ejercicios incluidos

- `arrays/TwoSum.java`
- `arrays/BestTimeToBuyAndSellStock.java`
- `arrays/ContainsDuplicate.java`
- `strings/ValidPalindrome.java`
- `strings/LongestSubstringWithoutRepeatingCharacters.java`
- `trees/MaximumDepthOfBinaryTree.java`
- `trees/SameTree.java`
- `dynamicprogramming/MinCostClimbingStairs.java`
- `graphs/NumberOfIslands.java`

## Requisitos

- Java 17
- Maven 3.8+ recomendado

## Ejecutar tests

Desde la raíz del proyecto:

```bash
mvn test
```

## Compilar el proyecto

```bash
mvn compile
```

## Ejecutar un ejercicio

Después de compilar:

```bash
java -cp target/classes arrays.TwoSum
```

Sustituye `arrays.TwoSum` por la clase que quieras ejecutar.
