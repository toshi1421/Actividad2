package com.clubdeportivo2.servicioreservas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clubdeportivo2.servicioreservas.client.CanchaFClient;
import com.clubdeportivo2.servicioreservas.model.Reserva;
import com.clubdeportivo2.servicioreservas.model.dto.Cancha;
import com.clubdeportivo2.servicioreservas.repository.ReservaRepository;
import java.util.List;

@Service
public class ReservaServicesImpl implements ReservaServices {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private CanchaFClient canchaFeignClient;
    
    @Override
    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }
    
   /*  @Override
    public Reserva crearReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }
    */

    /*@Override
    public Reserva crearReserva(Reserva reserva) {
        String url = "http://localhost:8081/api/canchas/" + reserva.getCanchaId();
        Cancha cancha = restTemplate.getForObject(url, Cancha.class); 
        if(cancha == null) {
            throw new RuntimeException("Cancha no encontrada");
        }

        return reservaRepository.save(reserva);
    }
   */

    @Override
    public Reserva crearReserva(Reserva reserva) {
        Cancha cancha = canchaFeignClient.obtenerCanchaPorId(reserva.getCanchaId());

        if (cancha == null) {
            throw new RuntimeException("Cancha no encontrada");
        }

        return reservaRepository.save(reserva);
    }

    @Override
    public List<Reserva> buscarReservasPorCancha(Long canchaId) {
        return reservaRepository.findByCanchaId(canchaId);
    }

    

}
