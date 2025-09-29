--------------------------------------

# 1. Generar una muestra de números pseudoaleatorios
set.seed(123)           
n <- 100                
x <- runif(n, 0, 1)     

# ----------------------------------------------------
# 2. PRUEBA DE UNIFORMIDAD (Chi-cuadrada y KS)
# ----------------------------------------------------
breaks <- 10
observed <- hist(x, breaks=breaks, col="skyblue", border="white",
                 main="Histograma - Prueba de Uniformidad",
                 xlab="Intervalos", ylab="Frecuencia")$counts
expected <- rep(n/breaks, breaks)
chisq_test <- chisq.test(observed, p=rep(1/breaks, breaks))
ks_test <- ks.test(x, "punif", 0, 1)

# ----------------------------------------------------
# 3. PRUEBA DE INDEPENDENCIA (Corridas sobre la media)
# ----------------------------------------------------
median_x <- median(x)
runs <- rle(x > median_x)$lengths
num_runs <- length(runs)
expected_runs <- (2*n - 1)/3
var_runs <- (16*n - 29)/90
z_runs <- (num_runs - expected_runs) / sqrt(var_runs)

# Gráfico de corridas
plot(x, type="l", col="darkblue", lwd=2,
     main="Prueba de Corridas (Independencia)",
     ylab="Valor", xlab="Índice")
abline(h=median_x, col="red", lty=2)

# ----------------------------------------------------
# 4. PRUEBA DE ALEATORIEDAD (Autocorrelación)
# ----------------------------------------------------
lag1 <- cor(x[-n], x[-1])

# Gráfico de autocorrelación
acf(x, main="Prueba de Aleatoriedad (ACF)")

# ----------------------------------------------------
# Resultados en consola
# ----------------------------------------------------
cat("RESULTADOS DE PRUEBAS ESTADÍSTICAS\n")
cat("---------------------------------\n")
cat("Chi-cuadrada:\n"); print(chisq_test)
cat("\nKolmogorov-Smirnov:\n"); print(ks_test)
cat("\nPrueba de Corridas sobre la media (z):", z_runs, "\n")
cat("\nAutocorrelación (lag 1):", lag1, "\n")
```
