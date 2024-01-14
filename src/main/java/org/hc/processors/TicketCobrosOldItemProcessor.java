package org.hc.processors;

import org.hc.model.in.TicketCobrosOld;
import org.hc.model.out.CuentasClientesNew;
import org.hc.model.out.TicketCobrosNew;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class TicketCobrosOldItemProcessor implements ItemProcessor<TicketCobrosOld, TicketCobrosNew> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TicketCobrosOldItemProcessor.class);

	@Override
	public TicketCobrosNew process(TicketCobrosOld ticketCobrosOld) throws Exception {

        CuentasClientesNew cuentasClientesNew = new CuentasClientesNew();
        TicketCobrosNew ticketCobrosNew = new TicketCobrosNew();

        ticketCobrosNew.setIdOcupacion(ticketCobrosOld.getIdReserva());
        ticketCobrosNew.setIdTipoCobro(ticketCobrosOld.getIdTipoCobros());
        ticketCobrosNew.setNumeroTicket(ticketCobrosOld.getNumTicket());
        ticketCobrosNew.setImporte(ticketCobrosOld.getImporte());
        //ticketCobrosOld.getFecha();
        ticketCobrosNew.setFechaPago(ticketCobrosOld.getFechaPago());
        //ticketCobrosOld.setIdTipoCobrosPago();

        return ticketCobrosNew;
    }
}
