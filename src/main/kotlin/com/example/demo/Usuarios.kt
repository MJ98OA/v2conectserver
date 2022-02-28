package com.example.demo

import com.google.gson.Gson
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Usuarios(var nombre: String, var contrasenia: String, var token:String) {

    var listaIdpreguntas=ArrayList<Int>()

    @Id
    @GeneratedValue
    var id = 0

    override fun toString(): String {
        val gson = Gson()
        return gson.toJson(this)
    }


    data class UsuarioSimple(var nombre:String, var contrasenia:String) {

        override fun toString(): String {
            val gson = Gson()
            return gson.toJson(this)
        }

    }


}