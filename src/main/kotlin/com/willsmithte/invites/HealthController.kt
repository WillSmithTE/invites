package com.willsmithte.invites

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/hi")
@RestController
class HealthController {
    @CrossOrigin("*")
    @GetMapping
    fun hi() = "hi"
}