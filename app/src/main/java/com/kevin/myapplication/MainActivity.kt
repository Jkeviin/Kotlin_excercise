package com.kevin.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    lateinit var id: TextInputEditText
    lateinit var nombre: TextInputEditText
    lateinit var descripcion: TextInputEditText
    lateinit var cantidad: TextInputEditText
    lateinit var costo: TextInputEditText
    lateinit var precio: TextInputEditText
    lateinit var categoria: TextInputEditText
    lateinit var precio_venta: TextInputEditText
    lateinit var listaP: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        id=findViewById(R.id.input_id)
        nombre=findViewById(R.id.input_nombre)
        descripcion=findViewById(R.id.input_descripcion)
        cantidad=findViewById(R.id.input_cantidad)
        costo=findViewById(R.id.input_costo)
        precio=findViewById(R.id.input_precio)
        categoria=findViewById(R.id.input_categoria)
        precio_venta=findViewById(R.id.input_precio_venta)
        listaP = findViewById(R.id.textList)
    }

    fun GuardarDatos(view:View){
        var db = BaseDatos(this)
        var pro = Producto()
        if(
            id.text.toString().length > 0 &&
            nombre.text.toString().length > 0 &&
            descripcion.text.toString().length > 0 &&
            cantidad.text.toString().length > 0 &&
            costo.text.toString().length > 0 &&
            precio.text.toString().length > 0 &&
            categoria.text.toString().length > 0 &&
            listaP.text.toString().length > 0){

            pro.id = id.text.toString()
            pro.nombre = 

        }
    }
}