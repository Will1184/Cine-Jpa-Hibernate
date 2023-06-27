package org.will1184.repository;

public interface CambioMonedaRepository {
    public void cambiarMoneda(TipoMoneda moneda);
    public void cambiarMonedaPorPais(Pais pais, TipoMoneda moneda);
}
