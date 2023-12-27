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
         * descricion
         */
        
        /** CUENTAS CLIENTE NEW
         * id
         * idCliente
         * idTicketCobro
         * tarjeta
         * importe
         * estado
         */
        
        /**
         * Unificar las 3 tablas en 1 tabla auxiliar y luego montar otro batch para insertar
         */
          
        //FIX Add correct Values
        cuentasClientesNew.setId(0);
        cuentasClientesNew.setIdTicketCobro(0);
        cuentasClientesNew.setTarjeta(null);
        cuentasClientesNew.setImporte(0);
        cuentasClientesNew.setEstado(0);
        
        
        cuentasClientesNew.setIdCliente(cuentasClientesOld.getIdCliente());
        LOGGER.info("Converting ( {} ) into ( {} )", cuentasClientesOld, cuentasClientesNew);

        return cuentasClientesNew;
	}
}
