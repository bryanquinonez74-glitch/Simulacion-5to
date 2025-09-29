### Ejercicio 1 – RStudio

##Descripción:** Generar números aleatorios con distribución normal y graficar su histograma con curva de densidad.

# Generar 500 números aleatorios con distribución normal
numeros <- rnorm(100, mean = 0, sd = 1)

# Histograma con curva de densidad
hist(numeros, breaks=20, col="lightblue", border="black", probability=TRUE,
     main="Distribución de Números Pseudoaleatorios ",
     xlab="Valores aleatorios")

lines(density(numeros), col="red", lwd=2)

