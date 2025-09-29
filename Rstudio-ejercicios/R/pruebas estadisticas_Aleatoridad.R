library(shiny)

ui <- fluidPage(
  titlePanel("Prueba de Aleatoriedad - Runs Test"),
  textInput("numeros","Ingresa números separados por coma"),
  actionButton("calcular","Calcular"),
  verbatimTextOutput("resultado")
)

server <- function(input, output) {
  observeEvent(input$calcular, {
    datos <- as.numeric(unlist(strsplit(input$numeros,",")))
    media <- mean(datos)
    secuencia <- ifelse(datos >= media,"+","-")
    runs <- 1 + sum(secuencia[-1] != secuencia[-length(secuencia)])
    n1 <- sum(secuencia=="+"); n2 <- sum(secuencia=="-")
    media_runs <- (2*n1*n2)/(n1+n2)+1
    var_runs <- (2*n1*n2*(2*n1*n2 - n1 - n2))/((n1+n2)^2*(n1+n2-1))
    z <- (runs - media_runs)/sqrt(var_runs)
    output$resultado <- renderPrint({
      cat("Runs =",runs,"\n")
      cat("Esperado =",round(media_runs,2),"\n")
      cat("Z =",round(z,3))
    })
  })
}

shinyApp(ui, server)
