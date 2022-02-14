package com.example.demo

class PreguntasRepository {
    companion object {
        var listaPreguntas = mutableListOf(
            Preguntas(0,"En que año empezo el covid","2019","2020","2021","2005"),
            Preguntas(1,"Cuantos dias tiene un año","360","366","365","355"),
            Preguntas(2,"Cual es la capital de Francia","Praga","Tallin","Paris","Madrid"),
            Preguntas(3,"Cuantos continentes hay","3","5","8","7"),
            Preguntas(4,"Cual es el mes que menos dias tiene","Marzo","Febrero","Julio","Diciembre"),
            Preguntas(5,"Cual es la capital de Ecuador","Lima","El cairo","Ambato","Quito"),
            Preguntas(6,"En que año fue la revolucion francesa","1769","1789","1987","1979")
        )

        var listaRespuestas = mutableListOf(
            Respuestas(0,"A"),
            Respuestas(1,"C"),
            Respuestas(2,"C"),
            Respuestas(3,"D"),
            Respuestas(4,"B"),
            Respuestas(5,"D"),
            Respuestas(6,"B")
        )
    }
}
