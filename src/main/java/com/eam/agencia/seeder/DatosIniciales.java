package com.eam.agencia.seeder;

import com.eam.agencia.models.PaqueteTuristico;
import com.eam.agencia.repositories.IClienteJPARepository;
import com.eam.agencia.repositories.IDestinoJPARepository;
import com.eam.agencia.repositories.IPaqueteTuristicoJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.eam.agencia.models.Destino;
import com.eam.agencia.models.Cliente;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Component
public class DatosIniciales implements CommandLineRunner {

    private final IDestinoJPARepository destinoRepository;
    private final IClienteJPARepository clienteRepository;
    private final IPaqueteTuristicoJPARepository paqueteTuristicoJPARepository;

    @Override
    public void run(String... args) throws Exception {

        if (destinoRepository.count() > 0 || clienteRepository.count() > 0) {
            System.out.println("Ya existen registros en la base de datos. No se ejecutara el seeder nuevamente.");
            return;
        }

        Destino destino1 = new Destino();
        destino1.setNombre("Armenia");
        destino1.setImagen("armenia.jpg");
        destinoRepository.save(destino1);

        Destino destino2 = new Destino();
        destino2.setNombre("Filandia");
        destino2.setImagen("filandia.jpg");
        destinoRepository.save(destino2);

        Destino destino3 = new Destino();
        destino3.setNombre("Salento");
        destino3.setImagen("salento.jpg");
        destinoRepository.save(destino3);

        Destino destino4 = new Destino();
        destino4.setNombre("Circasia");
        destino4.setImagen("circasia.jpg");
        destinoRepository.save(destino4);

        Destino destino5 = new Destino();
        destino5.setNombre("Buena vista");
        destino5.setImagen("buenaVista.jpg");
        destinoRepository.save(destino5);

        Destino destino6 = new Destino();
        destino6.setNombre("Pereira");
        destino6.setImagen("pereira.jpg");
        destinoRepository.save(destino6);

        // Crear y guardar registros de ejemplo para Cliente
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Juan Pérez");
        cliente1.setIdentificacion("123456789");
        cliente1.setEmail("juan@example.com");
        clienteRepository.save(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setNombre("María López");
        cliente2.setIdentificacion("987654321");
        cliente2.setEmail("maria@example.com");
        clienteRepository.save(cliente2);

        Cliente cliente3 = new Cliente();
        cliente3.setNombre("Didier LLanten");
        cliente3.setIdentificacion("10942322826");
        cliente3.setEmail("didier@example.com");
        clienteRepository.save(cliente3);

        Cliente cliente4 = new Cliente();
        cliente4.setNombre("Jhonatan Hernandez");
        cliente4.setIdentificacion("234219721");
        cliente4.setEmail("jhonatan@example.com");
        clienteRepository.save(cliente4);

        PaqueteTuristico paqueteTuristico1 = new PaqueteTuristico();
        paqueteTuristico1.setNombre("Eje cafetero");
        paqueteTuristico1.setFechaInicio(LocalDateTime.of(2024, 8, 26, 10, 0));
        paqueteTuristico1.setDuracion(7);
        paqueteTuristico1.setCupoMaximo(20);
        paqueteTuristico1.setPrecio(550000);
        paqueteTuristico1.setDestinos(List.of(destino1, destino2, destino3, destino4, destino5, destino6));
        paqueteTuristicoJPARepository.save(paqueteTuristico1);

        PaqueteTuristico paqueteTuristico2 = new PaqueteTuristico();
        paqueteTuristico2.setNombre("Quindio");
        paqueteTuristico2.setFechaInicio(LocalDateTime.of(2024, 5, 10, 23, 0));
        paqueteTuristico2.setDuracion(4);
        paqueteTuristico2.setCupoMaximo(8);
        paqueteTuristico2.setPrecio(320000);
        paqueteTuristico2.setDestinos(List.of(destino1, destino2, destino3));
        paqueteTuristicoJPARepository.save(paqueteTuristico2);
    }
}
