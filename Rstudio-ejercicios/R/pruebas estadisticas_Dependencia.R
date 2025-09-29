# Datos de tabla 2x2
tabla <- matrix(c(10,20,30,40), nrow=2, byrow=TRUE)
rownames(tabla) <- c("Fila1","Fila2")
colnames(tabla) <- c("Col1","Col2")

# Realizar prueba Chi-cuadrado
resultado <- chisq.test(tabla)
print(resultado)

