package org.incode.domainapp.module.fixtures.per_cpt.examples.communications.dom.demowithnotes;

import java.util.List;

import javax.inject.Inject;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.Contributed;
import org.apache.isis.applib.annotation.Mixin;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.services.eventbus.ActionDomainEvent;

import org.incode.domainapp.module.fixtures.shared.demowithnotes.dom.DemoObjectWithNotes;
import org.incode.domainapp.module.fixtures.shared.invoice.dom.DemoInvoice;
import org.incode.domainapp.module.fixtures.shared.invoice.dom.DemoInvoiceRepository;

@Mixin(method = "coll")
public class DemoObjectWithNotes_invoices {
    private final DemoObjectWithNotes demoCustomer;

    public DemoObjectWithNotes_invoices(final DemoObjectWithNotes demoCustomer) {
        this.demoCustomer = demoCustomer;
    }

    public static class DomainEvent extends ActionDomainEvent<DemoObjectWithNotes> {
    }

    @Action(semantics = SemanticsOf.SAFE, domainEvent = DomainEvent.class)
    @ActionLayout(contributed = Contributed.AS_ASSOCIATION)
    public List<DemoInvoice> coll() {
        return invoiceRepository.findByCustomer(demoCustomer);
    }

    @Inject
    DemoInvoiceRepository invoiceRepository;
}