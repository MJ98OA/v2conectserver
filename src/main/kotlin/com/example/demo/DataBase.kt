package com.example.demo
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class DataBase {

    @Bean
    fun initDatabase(usuariosRepository: UsuariosRepository): CommandLineRunner {
        return CommandLineRunner {

        }
    }
}
