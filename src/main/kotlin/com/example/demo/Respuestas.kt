package com.example.demo

import com.google.gson.Gson

class Respuestas (var Id:Int, var Solucion:String) {

    override fun toString(): String {
        val gson = Gson()
        return  gson.toJson(this)
    }

}