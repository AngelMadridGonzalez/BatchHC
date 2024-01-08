package org.hc;

import org.hc.model.in.CuentasClientesOld;
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
        return null;
    }
}
