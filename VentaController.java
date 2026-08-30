package com.estacion.controlador;

import com.estacion.modelo.Venta;
import com.estacion.repositorio.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VentaController {

    @Autowired
        private VentaRepository ventaRepository;

            @GetMapping("/ventas")
                public String listarVentas(Model model) {
                        model.addAttribute("ventas", ventaRepository.findAll());
                                return "ventas/listado";
                                    }

                                        @GetMapping("/ventas/nueva")
                                            public String mostrarFormularioNuevaVenta(Model model) {
                                                    model.addAttribute("venta", new Venta());
                                                            return "ventas/formulario";
                                                                }

                                                                    @PostMapping("/ventas/guardar")
                                                                        public String guardarVenta(@ModelAttribute("venta") Venta venta) {
                                                                                ventaRepository.save(venta);
                                                                                        return "redirect:/ventas";
                                                                                            }

                                                                                                @GetMapping("/ventas/editar/{id}")
                                                                                                    public String mostrarFormularioEditarVenta(@PathVariable("id") Long id, Model model) {
                                                                                                            Venta venta = ventaRepository.findById(id)
                                                                                                                            .orElseThrow(() -> new IllegalArgumentException("ID de venta inválido: " + id));
                                                                                                                                    model.addAttribute("venta", venta);
                                                                                                                                            return "ventas/formulario";
                                                                                                                                                }

                                                                                                                                                    @GetMapping("/ventas/eliminar/{id}")
                                                                                                                                                        public String eliminarVenta(@PathVariable("id") Long id) {
                                                                                                                                                                ventaRepository.deleteById(id);
                                                                                                                                                                        return "redirect:/ventas";
                                                                                                                                                                            }

                                                                                                                                                                                @GetMapping("/Metricastiempo")
                                                                                                                                                                                    public String mostrarMargenGanancia(Model model) {
                                                                                                                                                                                            List<Object[]> datosMetrica = ventaRepository.obtenerMargenGananciaMensual();
                                                                                                                                                                                                    model.addAttribute("metricas", datosMetrica);
                                                                                                                                                                                                            return "metricas/margen-ganancia";
                                                                                                                                                                                                                }

                                                                                                                                                                                                                    @GetMapping("/publicidad")
                                                                                                                                                                                                                        public String mostrarPublicidad() {
                                                                                                                                                                                                                                return "publicidad";
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                    