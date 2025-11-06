# tp3_progra2

 Ferrario, Juan Ignacio y García, Juan no participaron ni comentaron en ningun tp grupal, este incliudo.

ANALISIS:
Implementé dos algoritmos clásicos: DFS y BFS. El DFS es como el explorador que se manda de cabeza por el primer camino que encuentra y va hasta el fondo antes de probar otra cosa, usa una pila y consume poca memoria, pero no te garantiza encontrar el camino más corto. El BFS es más metódico, va nivel por nivel explorando todos los vecinos antes de avanzar, usa una cola y te asegura encontrar la distancia mínima, pero puede comer más memoria si el grafo es muy ancho.
Al final me di cuenta de que no hay un algoritmo "mejor", DFS es genial cuando solo querés saber si hay conexión y tenés poca memoria, BFS cuando necesitás el camino óptimo. Usar una matriz de adyacencia también estuvo bueno porque hacer consultas es súper rápido.

/* 
En base a lo que se viene trabajando en las
ultimas entregas, se pide que se cree un grafo
donde todos sus nodos contengan datos del
tipo Persona.
• Recorrer el grafo DFS y BFS
• Crear la matriz de Adyacencia
• ¿Cómo haría para que el grafo sea dirigido?
¿Se puede recorrer igual?
• Recordar que se espera la mayor generalidad
posible (<T> u Object en los Nodos). Solo en el
testeo usar a la Persona. No es obligatorio pero
es lo máximo que se espera.

*/

