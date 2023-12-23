package org.hc;

import org.hc.dtos.in.CuentasClientesOld;
import org.hc.dtos.out.CuentasClientesNew;
import org.springframework.batch.item.ItemProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CuentasClientesItemProcessor implements ItemProcessor<CuentasClientesOld, CuentasClientesNew> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CuentasClientesItemProcessor.class);

	@Override
	public CuentasClientesNew process(CuentasClientesOld cuentasClientesOld) throws Exception {

        CuentasClientesNew cuentasClientesNew = new CuentasClientesNew();
        
        //FIXME Aqui procesamos de CuentasClientesOld a CuentasClientesNew habria que ver como poder obtener varios datos conjuntos
        
        /** CUENTAS CLIENTE OLD
         * idCliente
         * fecha
         * idTipoCobro
         * importe
         * descrición
         */
        
        /** CUENTAS CLIENTE NEW
         * idCliente
         * idTicketCobro
         * tarjeta
         */
        
        /**
         * Unificar las 3 tablas en 1 tabla auxiliar y luego montar otro batch para insertar
         */
        cuentasClientesNew.setIdCliente(cuentasClientesOld.getIdCliente());
        cuentasClientesNew.setIdTicketCobro(idTicketCobro);
        cuentasClientesNew.setTarjeta(tarjeta);
        
        LOGGER.info("Converting ( {} ) into ( {} )", cuentasClientesOld, cuentasClientesNew);

        return cuentasClientesNew;
	}
}
