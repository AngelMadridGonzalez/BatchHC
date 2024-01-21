package org.hc.processors;

import org.hc.model.in.CuentasClientesLineasOld;
import org.hc.model.out.CuentasClientesNew;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class CuentasClientesLineasOldItemProcessor implements ItemProcessor<CuentasClientesLineasOld, CuentasClientesNew> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CuentasClientesLineasOldItemProcessor.class);

	@Override
	public CuentasClientesNew process(CuentasClientesLineasOld cuentasClientesLineasOld) throws Exception {

		CuentasClientesNew cuentasClientesNew = new CuentasClientesNew();

		cuentasClientesNew.setIdCliente(cuentasClientesLineasOld.getIdCliente());
		//cuentasClientesLineasOld.setFecha();
		//cuentasClientesLineasOld.setIdTipoCobros();
		cuentasClientesNew.setImporte(cuentasClientesLineasOld.getImporte());
		//cuentasClientesLineasOld.setDescripcion();

		LOGGER.info("**************  Converting ( {} ) into ( {} )", cuentasClientesLineasOld, cuentasClientesNew);

		return cuentasClientesNew;
	}
}