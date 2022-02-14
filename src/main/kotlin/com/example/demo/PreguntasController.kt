package com.example.demo

import org.springframework.web.bind.annotation.*
import kotlin.random.Random

@RestController
class PreguntasController {



    lateinit var pregunta:Preguntas
    var idPregunta_Respuesta:Int=0

    @GetMapping("getPreguntaRandom")
    fun getPreguntaRandom() : Preguntas {
        this.idPregunta_Respuesta=Random.nextInt(PreguntasRepository.listaPreguntas.size)

        pregunta=PreguntasRepository.listaPreguntas.get(idPregunta_Respuesta)

        return pregunta

    }

    @GetMapping("getPreguntaRandom/{id}")
    fun getPokemonFavorito(@PathVariable id: String) : String {

        return if (PreguntasRepository.listaRespuestas.get(idPregunta_Respuesta).Solucion == id){
            "Cierto"
        }
        else
            "Falso"

    }


}