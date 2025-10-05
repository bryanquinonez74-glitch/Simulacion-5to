package com.brayansystem.peuniformidad;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Numero {
    private IntegerProperty indice;
    private DoubleProperty valor;

    public Numero(int indice, double valor) {
        this.indice = new SimpleIntegerProperty(indice);
        this.valor = new SimpleDoubleProperty(valor);
    }

    public IntegerProperty indiceProperty() {
        return indice;
    }

    public DoubleProperty valorProperty() {
        return valor;
    }
}

