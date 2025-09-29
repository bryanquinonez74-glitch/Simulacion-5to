# Ingresar números
numeros <- c(3,7,12,5,18,1,9,14,6,20) # se pueden colocar los numeros que desees 

# Crear intervalos
intervalos <- cut(numeros, breaks=seq(0,20,by=4), right=TRUE)
freq_obs <- table(intervalos)

# Chi-cuadrado
esperado <- length(numeros)/length(freq_obs)
chi2 <- sum((freq_obs - esperado)^2/esperado)
chi2

# Gráfico
barplot(freq_obs, main="Frecuencia por intervalo", col="lightblue")
