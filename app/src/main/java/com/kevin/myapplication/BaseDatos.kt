package com.kevin.myapplication

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf

class BaseDatos (context: Context):SQLiteOpenHelper (context, "venta", null, 1){

    override fun onCreate(db: SQLiteDatabase?) {
        var sql = "create table productos (id varchar(50) primary key, nombre varchar(50) not null, descripcion varchar(100) not null, cantidad integer not null, costo real not null, categoria varchar(20) not null, precio_venta real not null)";

        db?.execSQL(sql)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun Guardar(producto: Producto): String {
        val db = this.writableDatabase

        var contenedor = ContentValues()
        contenedor.put("id", producto.id)
        contenedor.put("nombre", producto.nombre)
        contenedor.put("descripcion", producto.descripcion)
        contenedor.put("cantidad", producto.cantidad)
        contenedor.put("costo", producto.costo)
        contenedor.put("categoria", producto.categoria)
        contenedor.put("precio_venta", producto.precio_venta)

        var resultado = db.insert("productos", null, contenedor)

        try {
            if(resultado == -1.toLong()){
                return "Existe un error al insertar"
            }else{
                return "Se guardó exitosamente"
            }
        }catch (ex: Exception){
            return ex.message.toString()
        } finally {
            db.close()
        }
    }

    fun Actualizar(producto: Producto): String {
        val db = this.writableDatabase

        var contenedor = ContentValues()
        contenedor.put("id", producto.id)
        contenedor.put("nombre", producto.nombre)
        contenedor.put("descripcion", producto.descripcion)
        contenedor.put("cantidad", producto.cantidad)
        contenedor.put("costo", producto.costo)
        contenedor.put("categoria", producto.categoria)
        contenedor.put("precio_venta", producto.precio_venta)

        var resultado = db.update("productos", contenedor, "producto.id=?", arrayOf(producto.id))

        try {
            if(resultado > 0){
                return "Existe un error al actualizar"
            }else{
                return "Se actualizó exitosamente"
            }
        }catch (ex: Exception){
            return ex.message.toString()
        } finally {
            db.close()
        }
    }

    fun eliminarDatos(producto: Producto): String {
        val db = this.writableDatabase

        var resultado = db.delete("productos", "producto.id=?", arrayOf(producto.id))

        try {
            if(resultado > 0){
                return "Existe un error al eliminar"
            }else{
                return "Se eliminó exitosamente"
            }
        }catch (ex: Exception){
            return ex.message.toString()
        } finally {
            db.close()
        }
    }

    @SuppressLint("Range")
    fun ListarDatos(): MutableList<Producto>{
        val lista:MutableList<Producto> = ArrayList()

        val db = this.readableDatabase

        val sql = "SELECT * FROM productos"

        var resultado = db.rawQuery(sql, null)

        if(resultado.moveToFirst()){
            do{
                var datosP = Producto()

                datosP.id = resultado.getString(resultado.getColumnIndex("id"))
                datosP.nombre = resultado.getString(resultado.getColumnIndex("nombre"))
                datosP.descripcion = resultado.getString(resultado.getColumnIndex("descripcion"))
                datosP.cantidad = resultado.getInt(resultado.getColumnIndex("cantidad"))
                datosP.costo = resultado.getDouble(resultado.getColumnIndex("costo"))
                datosP.categoria = resultado.getString(resultado.getColumnIndex("categoria"))
                datosP.precio_venta = resultado.getDouble(resultado.getColumnIndex("precio_venta"))
                lista.add(datosP)
            }while (resultado.moveToNext())
            resultado.close()
            db.close()
        }
        return lista
    }
}
