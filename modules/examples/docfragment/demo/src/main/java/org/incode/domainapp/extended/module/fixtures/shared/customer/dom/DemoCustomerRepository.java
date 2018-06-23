package org.incode.domainapp.extended.module.fixtures.shared.customer.dom;

import java.util.List;

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.services.repository.RepositoryService;

@DomainService(nature = NatureOfService.DOMAIN )
public class DemoCustomerRepository {

    public List<DemoCustomer> listAll() {
        return repositoryService.allInstances(DemoCustomer.class);
    }

    @javax.inject.Inject
    RepositoryService repositoryService;
}