package org.incode.example.docfragment.demo.shared.invoicewithatpath.dom;

import java.util.List;

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.services.repository.RepositoryService;

@DomainService(nature = NatureOfService.DOMAIN )
public class DemoInvoiceWithAtPathRepository {

    public List<DemoInvoiceWithAtPath> listAll() {
        return repositoryService.allInstances(DemoInvoiceWithAtPath.class);
    }

    @javax.inject.Inject
    RepositoryService repositoryService;
}