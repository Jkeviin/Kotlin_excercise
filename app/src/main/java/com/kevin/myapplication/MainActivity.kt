package com.kevin.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var id: TextInputEditText
    lateinit var nombre: TextInputEditText
    lateinit var descripcion: TextInputEditText
    lateinit var cantidad: TextInputEditText
    lateinit var costo: TextInputEditText
    lateinit var categoria: TextInputEditText
    lateinit var precio_venta: TextInputEditText
    lateinit var listaP: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        id = findViewById(R.id.input_id)
        nombre = findViewById(R.id.input_nombre)
        descripcion = findViewById(R.id.input_descripcion)
        cantidad = findViewById(R.id.input_cantidad)
        costo = findViewById(R.id.input_costo)
        categoria = findViewById(R.id.input_categoria)
        precio_venta = findViewById(R.id.input_precio_venta)
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
            categoria.text.toString().length > 0 &&
            precio_venta.text.toString().length > 0
        ) {
            pro.id = id.text.toString()
            pro.nombre = nombre.text.toString()
            pro.descripcion = descripcion.text.toString()
            pro.cantidad = cantidad.text.toString().toInt()
            pro.costo = costo.text.toString().toDouble()
            pro.categoria = categoria.text.toString()
            pro.precio_venta = precio_venta.text.toString().toDouble()

            var mensaje = db.Guardar(pro)
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        }
    }

    fun listarDatos(view:View) {
        listaP.text = ""

        val listaP = findViewById<TextView>(R.id.textList)
        var db = BaseDatos(this)

        var datosL = db.ListarDatos()

        listaP.visibility = View.VISIBLE

        for (i in 0 .. datosL.size-1){
            listaP.append(
                    "ID:"+datosL.get(i).id+"\n"+
                    "Nombre: "+datosL.get(i).nombre+"\n"+
                    "Descripción: "+datosL.get(i).descripcion+"\n"+
                    "Cantidad: "+datosL.get(i).cantidad+"\n"+
                    "Costo: "+datosL.get(i).costo+"\n"+
                    "Categoria: "+datosL.get(i).categoria+"\n"+
                    "precio_venta: "+datosL.get(i).precio_venta+"\n"
            )
        }
    }

    fun eliminarDatos(view:View) {
        var db = BaseDatos(this)
        listaP.visibility = View.INVISIBLE
        if(id.text.toString().length>0){
            var mensaje = db.eliminarDatos(id.text.toString())
            listaP.text = mensaje
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "El campo ID es requerido", Toast.LENGTH_SHORT).show()
        }
    }
    fun actualizarDatos(view:View){
        var db = BaseDatos(this)
        listaP.visibility = View.VISIBLE

        var mensaje = db.Actualizar(
            id.text.toString(),
            nombre.text.toString(),
            descripcion.text.toString(),
            cantidad.text.toString().toInt(),
            costo.text.toString().toDouble(),
            categoria.text.toString(),
            precio_venta.text.toString().toDouble())

        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
}
