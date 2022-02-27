package com.example.demo

import org.springframework.web.bind.annotation.*
import kotlin.random.Random
import kotlin.random.nextInt

@RestController
class PreguntasController(private val usuariosRepository: UsuariosRepository) {
    var token = ""
    lateinit var pregunta: Preguntas
    var aleatorioListaPreg_Res: Int = 0

    @GetMapping("todasRespuestas")
    fun todasRespuestas(): MutableList<Respuestas> {

        return PreguntasRepository.listaRespuestas

    }

    @GetMapping("getPreguntaRandom/{token}")
    fun getPreguntaRandom(@PathVariable token: String):Preguntas{


        var usuario=obtenerUsuario(token)
        usuario?.let {
            if(usuario.listaIdpreguntas.size!=PreguntasRepository.listaPreguntas.size){

                aleatorioListaPreg_Res = Random.nextInt(PreguntasRepository.listaPreguntas.size)

                while(usuario.listaIdpreguntas.contains(aleatorioListaPreg_Res))
                    aleatorioListaPreg_Res = Random.nextInt(PreguntasRepository.listaPreguntas.size)

                pregunta = PreguntasRepository.listaPreguntas.get(aleatorioListaPreg_Res)

                usuario.listaIdpreguntas.add(aleatorioListaPreg_Res)
                usuariosRepository.save(usuario)
            }else
                pregunta= Preguntas(10,"final","final","final","final","final")
        }

        usuariosRepository.findAll().forEach { "lista usuarios"+println(it.toString()) }

        System.out.println(pregunta.toString())


        return pregunta

    }

    /*@GetMapping("getPreguntaRandom/{id}")
    fun getPokemonFavorito(@PathVariable id: String): String {

        return if (PreguntasRepository.listaRespuestas.get(idPregunta_Respuesta).Solucion == id) {
            "Cierto"
        } else
            "Falso"
    }*/


    @PostMapping("creacionUsuario")
    fun insertUser(@RequestBody usuario: Usuarios.UsuarioSimple): String {
        var devolvertoken = ""
        var agregarUsuario = true

        if (usuariosRepository.count() <= 0)
            guardarUsuario(usuario.nombre, usuario.contrasenia)

            usuariosRepository.findAll().forEach {
                //println(it.toString()+"a")
                if (it.nombre == usuario.nombre && it.contrasenia == usuario.contrasenia) {
                    agregarUsuario = false
                    devolvertoken = it.token

                }
            }
        if (agregarUsuario) {
            var usuarionuevo = guardarUsuario(usuario.nombre, usuario.contrasenia)
            devolvertoken = usuarionuevo.token
        }
        return devolvertoken
    }

    @PostMapping("preguntasUsuario")
    fun preguntasUsuario(@PathVariable token: String) {
        var usuario=obtenerUsuario(token)


    }

    //Funciones//

    fun obtenertoken(): String {
        var rString = ""
        //println("he llegado")
        repeat(9) {
            if (Random.nextBoolean())
                rString += Random.nextInt(65..90).toChar()
            else
                rString += Random.nextInt(97..122).toChar()
        }
        return rString
    }

    fun guardarUsuario(nombreUser: String, contraseniaUser: String): Usuarios {
        var usuarioGuardado = usuariosRepository.save(Usuarios(nombreUser, contraseniaUser, obtenertoken()))
        return usuarioGuardado
    }

    fun obtenerUsuario(token:String): Usuarios? {
        var usuarioDevuelto: Usuarios? =null
        usuariosRepository.findAll().forEach {
            if(token==it.token)
                usuarioDevuelto=it
        }
        return usuarioDevuelto
    }
}



