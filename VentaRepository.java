package com.estacion.repositorio;

import com.estacion.modelo.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

    @Query("SELECT FUNCTION('MONTHNAME', v.fecha) AS mes, " +
               "v.tipoCombustible AS combustible, " +
                          "SUM(v.precioTotal - v.costoTotal) AS margenGanancia " +
                                     "FROM Venta v " +
                                                "GROUP BY FUNCTION('MONTH', v.fecha), FUNCTION('MONTHNAME', v.fecha), v.tipoCombustible " +
                                                           "ORDER BY FUNCTION('MONTH', v.fecha) ASC")
                                                               List<Object[]> obtenerMargenGananciaMensual();
                                                               }
                                                               