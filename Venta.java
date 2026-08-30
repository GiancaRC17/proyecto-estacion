package com.estacion.modelo;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ventas")
public class Venta {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;

                @Column(nullable = false)
                    private String tipoCombustible;

                        @Column(nullable = false)
                            private Double galones;

                                @Column(nullable = false)
                                    private Double precioTotal;

                                        @Column(nullable = false)
                                            private Double costoTotal;

                                                @Column(nullable = false)
                                                    private String medioPago;

                                                        @Column(nullable = false)
                                                            private LocalDate fecha;

                                                                public Venta() {}

                                                                    public Long getId() { return id; }
                                                                        public void setId(Long id) { this.id = id; }

                                                                            public String getTipoCombustible() { return tipoCombustible; }
                                                                                public void setTipoCombustible(String tipoCombustible) { this.tipoCombustible = tipoCombustible; }

                                                                                    public Double getGalones() { return galones; }
                                                                                        public void setGalones(Double galones) { this.galones = galones; }

                                                                                            public Double getPrecioTotal() { return precioTotal; }
                                                                                                public void setPrecioTotal(Double precioTotal) { this.precioTotal = precioTotal; }

                                                                                                    public Double getCostoTotal() { return costoTotal; }
                                                                                                        public void setCostoTotal(Double costoTotal) { this.costoTotal = costoTotal; }

                                                                                                            public String getMedioPago() { return medioPago; }
                                                                                                                public void setMedioPago(String medioPago) { this.medioPago = medioPago; }

                                                                                                                    public LocalDate getFecha() { return fecha; }
                                                                                                                        public void setFecha(LocalDate fecha) { this.fecha = fecha; }
                                                                                                                        }
                                                                                                                        