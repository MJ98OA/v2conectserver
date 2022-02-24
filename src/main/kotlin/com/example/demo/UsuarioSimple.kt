package com.example.demo

import com.google.gson.Gson

data class UsuarioSimple(var nombre:String, var contrasenia:String){


    override fun toString(): String {
        val gson = Gson()
        return gson.toJson(this)
    }

}