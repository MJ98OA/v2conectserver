package com.example.demo

import org.springframework.web.bind.annotation.*
import kotlin.random.Random
import kotlin.random.nextInt

@RestController
class PreguntasController(private val usuariosRepository: UsuariosRepository) {



    lateinit var pregunta:Preguntas
    var idPregunta_Respuesta:Int=0

    @GetMapping("todasRespuestas")
    fun todasRespuestas() : MutableList<Respuestas> {

        return PreguntasRepository.listaRespuestas

    }

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


    @PostMapping("pokemonBody")
    fun insertStudent(@RequestBody usuario: UsuarioSimple): String {

        var rString:String=""
        repeat(9){
            if(Random.nextBoolean())
                rString+=Random.nextInt(65..90).toChar()
            else
                rString+=Random.nextInt(97..122).toChar()
        }

        var usuariocompleto=Usuarios(usuario.nombre,usuario.contrasenia,rString)


        var comprobacion:Boolean=true

        usuariosRepository.findAll().forEach {
            if(it.nombre==usuario.nombre && it.Contrasenia==usuario.contrasenia)
                comprobacion=false
        }

        if(comprobacion) usuariosRepository.save(usuariocompleto)



        return if(comprobacion){ usuariocompleto.token }else "Usuario repetido"


    }


}