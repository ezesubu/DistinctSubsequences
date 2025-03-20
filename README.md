## Descripción del Proyecto

El proyecto consiste en el desarrollo de un algoritmo eficiente para resolver el problema **Distinct Subsequences**, optimizado para aplicaciones en producción. La solución está diseñada para ser modular, extensible y mantenible, con el objetivo de facilitar futuras mejoras e integraciones.

---

## Contexto de Ejecución

El algoritmo puede ejecutarse en diferentes entornos, incluyendo:

- **Aplicaciones de Procesamiento de Lenguaje Natural (NLP)**: Se puede utilizar para el análisis de texto y detección de patrones.
- **Motores de Búsqueda**: Para encontrar ocurrencias específicas de palabras en grandes volúmenes de texto.
- **Compiladores y Análisis de Código**: Para verificar estructuras específicas dentro de fragmentos de código.
- **Bioinformática**: Para el análisis de secuencias de ADN, donde una subsecuencia de nucleótidos puede estar contenida en una cadena más grande.
- **Sistemas de Validación de Datos**: Para detectar patrones en flujos de datos estructurados.

---

## Arquitectura por Capas

1. **Capa de Presentación**
    - Interfaz de usuario por definir, podría ser una aplicación web.

2. **Capa de Negocio**
    - `DistinctSubsequencesService`: Servicio que encapsula la lógica del algoritmo de cálculo de subsecuencias distintas.
    - `DistinctSubsequencesDynamic`, `DistinctSubsequencesMatrix`, `DistinctSubsequencesMemoization`: Implementaciones específicas del algoritmo.

3. **Capa de Persistencia (Mejora Futura)**
    - Puede incluir almacenamiento en base de datos si se requiere registrar resultados a largo plazo.

---

## Definición del Algoritmo

El algoritmo de **Distinct Subsequences** cuenta cuántas formas existen de transformar la cadena `s` en `t` eliminando caracteres sin cambiar el orden.

### **Entrada y Salida**

**Entrada:**
- Una cadena `s` de longitud `n`.
- Una cadena `t` de longitud `m`.

**Salida:**
- Un número entero que representa la cantidad de subsecuencias distintas de `s` que son iguales a `t`.

**Ejemplo:**
```plaintext
Entrada:
s = "rabbbit"
t = "rabbit"

Salida:
3
```

**Explicación:** Existen tres formas de eliminar caracteres de `s` para obtener `t`.

### **Definición en Pseudocódigo**

```plaintext
Funcion countSubsequences(s, t):
    n = longitud(s)
    m = longitud(t)
    Si m > n:
        Retornar 0
    
    Crear arreglo prev de tamaño (n+1) inicializado en 0
    prev[0] = 1  # Una subsecuencia vacía siempre es válida
    
    Para i desde 1 hasta m:
        Crear arreglo curr de tamaño (n+1) inicializado en 0
        curr[0] = 1
        
        Para j desde 1 hasta n:
            Si s[j-1] == t[i-1]:
                curr[j] = prev[j-1] + prev[j]
            Sino:
                curr[j] = prev[j]
        
        prev = copia de curr
    
    Retornar prev[n]
```

---

## Algoritmos y Complejidad Temporal

A continuación, se presenta una tabla con los algoritmos utilizados y su complejidad en notación Big O:

| Versión | Tiempo | Espacio |
|-------------------------------|-----------------|-----------------|
| DP con Matriz (O(n²) espacio) | O(m × n) | O(m × n) |
| DP con Dos Arreglos (O(n) espacio) | O(m × n) | O(n) |
| DP con Un Solo Arreglo (O(n) espacio) | O(m × n) | O(n) (más óptima) |

---

## Diagrama de Arquitectura

El siguiente diagrama representa la estructura en capas de la aplicación:

```
+----------------------+
|    Presentación     |
| (Aplicación Web)    |
+----------------------+
         |
         v
+----------------------+
|      Negocio        |
| Servicio y Algoritmos |
+----------------------+
```

---

## Pruebas Unitarias

Se han desarrollado pruebas unitarias para garantizar la exactitud del algoritmo y verificar diferentes escenarios:

1. **Pruebas por Implementación:**
    - `DistinctSubsequencesDynamicTest`
    - `DistinctSubsequencesMatrixTest`
    - `DistinctSubsequencesMemoizationTest`

2. **Pruebas de Servicio:**
    - `DistinctSubsequencesServiceTest`

3. **Casos de prueba:**
    - **Caso Base:** `s = "rabbit"`, `t = "rabbit"` → Salida esperada: `1`
    - **Caso con Eliminación:** `s = "rabbbit"`, `t = "rabbit"` → Salida esperada: `3`
    - **Caso Sin Coincidencias:** `s = "abc"`, `t = "def"` → Salida esperada: `0`
    - **Caso Personalizado:** `s = "ezequiel"`, `t = "eze"` → Salida esperada: `2`
    - **Caso Target Vacío:** `s = "anything"`, `t = ""` → Salida esperada: `1`
    - **Caso Misma Cadena:** `s = "abc"`, `t = "abc"` → Salida esperada: `1`
    - **Caso Caracter Único con Múltiples Ocurrencias:** `s = "aaaaa"`, `t = "aa"` → Salida esperada: `10`

