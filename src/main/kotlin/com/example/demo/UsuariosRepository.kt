package com.example.demo

import org.springframework.data.jpa.repository.JpaRepository

interface UsuariosRepository : JpaRepository<Usuarios, Int>