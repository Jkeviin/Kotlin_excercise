package com.kevin.myapplication

class Producto {
    var id: String = "";
    var nombre: String = "";
    var descripcion: String = "";
    var cantidad: Int = 0;
    var costo: Double = 0.0;
    var categoria: String = "";
    var precio_venta: Double = 0.0;

    constructor(
        id: String,
        nombre: String,
        descripcion: String,
        cantidad: Int,
        costo: Double,
        categoria: String,
        precio_venta: Double
    ) {
        this.id = id
        this.nombre = nombre
        this.descripcion = descripcion
        this.cantidad = cantidad
        this.costo = costo
        this.categoria = categoria
        this.precio_venta = precio_venta
    }

    constructor(){

    }



}