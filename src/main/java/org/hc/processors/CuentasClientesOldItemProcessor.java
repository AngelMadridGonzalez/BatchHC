package org.hc.processors;

import org.hc.model.in.CuentasClientesOld;
import org.hc.model.out.CuentasClientesNew;
import org.springframework.batch.item.ItemProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CuentasClientesOldItemProcessor implements ItemProcessor<CuentasClientesOld, CuentasClientesNew> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CuentasClientesOldItemProcessor.class);

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
         * Unificar las 3 tablas en 1 tabla
         */

        /**
         * Step 1 Insert Tabla CuentasClientesNew con cuentasClientesOld (job 1 y writerCuentasClientesNew)
         * Step 2 Update Tabla CuentasClientesNew con cuentasClientesLineasOld (job 2 y writercuentasClientesLineasOld)
         * Step 3 Update Tabla CuentasClientesNew con ticketcobtos (job 3 y writerticketcobtos)
         */

        cuentasClientesNew.setIdCliente(cuentasClientesOld.getIdCliente());
        //cuentasClientesOld.setDireccion();
        //cuentasClientesOld.setFecha();

        LOGGER.info("**************  Converting ( {} ) into ( {} )", cuentasClientesOld, cuentasClientesNew);

        return cuentasClientesNew;
	}
}