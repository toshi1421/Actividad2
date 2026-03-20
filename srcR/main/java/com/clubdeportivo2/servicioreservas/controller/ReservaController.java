package com.clubdeportivo2.servicioreservas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.clubdeportivo2.servicioreservas.model.Reserva;
import com.clubdeportivo2.servicioreservas.services.ReservaServices;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaServices reservaService;

    @GetMapping
    public List<Reserva> listarReservas(){
        return reservaService.listarReservas();
    }

    @PostMapping
    public Reserva crearReserva(@RequestBody(required = false) Reserva reserva){
        if (reserva == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Debes enviar un body JSON con los datos de la reserva");
        }
        return reservaService.crearReserva(reserva);
    }

    @GetMapping("/cancha/{id}")
    public List<Reserva> buscarPorCancha(@PathVariable Long id){
        return reservaService.buscarReservasPorCancha(id);
    }


}
