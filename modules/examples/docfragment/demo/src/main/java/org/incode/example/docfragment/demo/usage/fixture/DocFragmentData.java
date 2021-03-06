package org.incode.example.docfragment.demo.usage.fixture;

import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.services.registry.ServiceRegistry2;

import org.incode.example.docfragment.dom.impl.DocFragment;
import org.incode.example.docfragment.dom.impl.DocFragmentRepository;
import org.incode.module.fixturesupport.dom.data.DemoData;
import org.incode.module.fixturesupport.dom.data.DemoDataPersistAbstract;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Getter
@Accessors(chain = true)
public enum DocFragmentData implements DemoData<DocFragmentData, DocFragment> {

    Customer_hello_GLOBAL("docfragmentdemoshared.DocFragCustomer", "hello", "/", "Hello, nice to meet you, ${title} ${lastName}"),
    Customer_hello_ITA("docfragmentdemoshared.DocFragCustomer", "hello", "/ITA", "Ciao, piacere di conoscerti, ${title} ${lastName}"),
    Customer_hello_FRA("docfragmentdemoshared.DocFragCustomer", "hello", "/FRA", "Bonjour, ${title} ${lastName}, agréable de vous rencontrer"),
    Customer_goodbye_GLOBAL("docfragmentdemoshared.DocFragCustomer", "goodbye", "/", "So long, ${firstName}"),
    Invoice_due_GLOBAL("docfragmentdemoshared.DocFragInvoice", "due", "/", "The invoice will be due on the ${dueBy?string[\"dd-MMM-yyyy\"]}, payable in ${numDays} days"),
    Invoice_due_FRA("docfragmentdemoshared.DocFragInvoice", "due", "/FRA", "La facture sera due sur le ${dueBy?string[\"dd-MMM-yyyy\"]}, payable dans ${numDays} jours");

    private final String objectType;
    private final String name;
    private final String atPath;
    private final String templateText;

    @Programmatic
    public DocFragment asDomainObject() {
        return DocFragment.builder()
                .objectType(this.getObjectType())
                .name(this.getName())
                .atPath(this.getAtPath())
                .templateText(this.getTemplateText())
                .build();
    }

    @Programmatic
    public DocFragment persistUsing(final ServiceRegistry2 serviceRegistry) {
        return Util.persist(this, serviceRegistry);
    }

    @Programmatic
    public DocFragment createWith(final DocFragmentRepository repository) {
        return repository.create(getObjectType(), getName(), getAtPath(), getTemplateText());
    }

    @Programmatic
    public DocFragment findUsing(final ServiceRegistry2 serviceRegistry) {
        return Util.firstMatch(this, serviceRegistry);
    }

    public static class PersistScript extends DemoDataPersistAbstract<PersistScript, DocFragmentData, DocFragment> {
        public PersistScript() {
            super(DocFragmentData.class);
        }
    }

}
