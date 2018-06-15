package org.incode.domainapp.example.app.fixtures;

import javax.inject.Inject;

import org.apache.isis.applib.fixturescripts.DiscoverableFixtureScript;
import org.apache.isis.applib.services.queryresultscache.QueryResultsCache;

import org.incode.domainapp.module.fixtures.per_cpt.examples.classification.fixture.ClassificationModule_tearDown;
import org.incode.domainapp.module.fixtures.per_cpt.examples.classification.fixture.DemoObjectWithAtPath_and_OtherObjectWithAtPath_create3;
import org.incode.domainapp.module.fixtures.per_cpt.examples.commchannel.fixture.CommChannelModule_tearDown;
import org.incode.domainapp.module.fixtures.per_cpt.examples.communications.fixture.data.democust2.DemoObjectWithNote_and_DemoInvoice_create3;
import org.incode.domainapp.module.fixtures.per_cpt.examples.communications.fixture.data.doctypes.DocumentType_and_DocumentTemplates_createSome;
import org.incode.domainapp.module.fixtures.per_cpt.examples.docfragment.fixture.DemoCustomer_and_DemoInvoiceWithAtPath_and_fragments_create;
import org.incode.domainapp.module.fixtures.per_cpt.examples.docfragment.fixture.sub.DocFragment_tearDown;
import org.incode.domainapp.module.fixtures.per_cpt.examples.document.fixture.seed.RenderingStrategy_create6;
import org.incode.domainapp.module.fixtures.per_cpt.examples.tags.fixture.DemoTaggableObject_withTags_create3;
import org.incode.domainapp.module.fixtures.per_cpt.lib.fakedata.fixture.DemoObjectWithAll_recreate3;
import org.incode.domainapp.module.fixtures.per_cpt.lib.poly.fixture.Case_FixedAsset_Party_andLinks_tearDown;
import org.incode.domainapp.module.fixtures.per_cpt.lib.poly.fixture.Case_FixedAsset_Party_recreateAll;
import org.incode.domainapp.module.fixtures.per_cpt.lib.servletapi.fixture.ServletApiDemoObject_create3;
import org.incode.domainapp.module.fixtures.per_cpt.lib.servletapi.fixture.ServletApiDemoObject_tearDown;
import org.incode.domainapp.module.fixtures.per_cpt.spi.audit.fixture.sub.SomeAuditedObject_and_SomeNonAuditedObject_and_AuditEntry_tearDown;
import org.incode.domainapp.module.fixtures.per_cpt.spi.audit.fixture.sub.SomeAuditedObject_create3;
import org.incode.domainapp.module.fixtures.per_cpt.spi.audit.fixture.sub.SomeNotAuditedObject_create3;
import org.incode.domainapp.module.fixtures.per_cpt.spi.command.fixture.SomeCommandAnnotatedObject_create3;
import org.incode.domainapp.module.fixtures.per_cpt.spi.command.fixture.teardown.SomeCommandAnnotatedObjects_tearDown;
import org.incode.domainapp.module.fixtures.per_cpt.spi.publishmq.fixture.PublishMqDemoObject_create3;
import org.incode.domainapp.module.fixtures.per_cpt.spi.publishmq.fixture.teardown.PublishMqDemoObject_tearDown;
import org.incode.domainapp.module.fixtures.per_cpt.spi.security.fixture.SecurityModuleAppSetUp;
import org.incode.domainapp.module.fixtures.scenarios.DemoModuleTearDown;
import org.incode.domainapp.module.fixtures.shared.demo.fixture.DemoObject_createUpTo10_hardcodedData;
import org.incode.domainapp.module.fixtures.shared.demowithblob.fixture.DemoObjectWithBlob_createUpTo5_fakeData;
import org.incode.domainapp.module.fixtures.shared.demowithurl.fixture.DemoObjectWithUrl_createUpTo5_fakeData;
import org.incode.domainapp.module.fixtures.shared.order.fixture.DemoOrderAndOrderLine_recreate4_hardcodedData;
import org.incode.domainapp.module.fixtures.shared.other.fixture.OtherObject_createUpTo5_fakeData;
import org.incode.domainapp.module.fixtures.shared.reminder.fixture.DemoReminder_create4;
import org.incode.domainapp.module.fixtures.shared.todo.fixture.DemoToDoItem_create_usingExcelFixture;
import org.incode.example.communications.fixture.teardown.CommunicationModule_tearDown;
import org.incode.example.country.fixture.CountriesRefData;
import org.incode.example.country.fixture.StatesRefData;
import org.incode.example.country.fixture.teardown.CountryModule_tearDown;
import org.incode.example.document.fixture.teardown.DocumentModule_tearDown;

public class RecreateDemoFixtures extends DiscoverableFixtureScript {

    @Override
    protected void execute(final ExecutionContext ec) {

        ec.executeChild(this, new SecurityModuleAppSetUp());

        ec.executeChild(this, new ServletApiDemoObject_tearDown());
        ec.executeChild(this, new PublishMqDemoObject_tearDown());

        ec.executeChild(this, new ClassificationModule_tearDown());
        ec.executeChild(this, new CommChannelModule_tearDown());
        ec.executeChild(this, new CommunicationModule_tearDown());
        ec.executeChild(this, new DocumentModule_tearDown());
        ec.executeChild(this, new DocFragment_tearDown());
        ec.executeChild(this, new Case_FixedAsset_Party_andLinks_tearDown());
        ec.executeChild(this, new CountryModule_tearDown());
        ec.executeChild(this, new ServletApiDemoObject_tearDown());

        ec.executeChild(this, new SomeAuditedObject_and_SomeNonAuditedObject_and_AuditEntry_tearDown());
        ec.executeChild(this, new SomeCommandAnnotatedObjects_tearDown());
        ec.executeChild(this, new PublishMqDemoObject_tearDown());

        ec.executeChild(this, new DemoModuleTearDown());



        ec.executeChild(this, new RenderingStrategy_create6());
        ec.executeChild(this, new DocumentType_and_DocumentTemplates_createSome());
        queryResultsCache.resetForNextTransaction();

        ec.executeChild(this, new CountriesRefData());
        ec.executeChild(this, new StatesRefData());

        ec.executeChild(this, new SomeAuditedObject_create3());
        ec.executeChild(this, new SomeNotAuditedObject_create3());
        ec.executeChild(this, new SomeCommandAnnotatedObject_create3());
        ec.executeChild(this, new PublishMqDemoObject_create3());

        ec.executeChild(this, new DemoTaggableObject_withTags_create3());
        ec.executeChild(this, new DemoOrderAndOrderLine_recreate4_hardcodedData());
        ec.executeChild(this, new Case_FixedAsset_Party_recreateAll());
        ec.executeChild(this, new ServletApiDemoObject_create3());

        ec.executeChild(this, new DemoObject_createUpTo10_hardcodedData());
        ec.executeChild(this, new DemoObjectWithAll_recreate3());
        ec.executeChild(this, new DemoObjectWithAtPath_and_OtherObjectWithAtPath_create3());
        ec.executeChild(this, new DemoObjectWithBlob_createUpTo5_fakeData());
        ec.executeChild(this, new DemoObjectWithNote_and_DemoInvoice_create3());
        ec.executeChild(this, new DemoObjectWithUrl_createUpTo5_fakeData());

        ec.executeChild(this, new OtherObject_createUpTo5_fakeData());

        ec.executeChild(this, new DemoCustomer_and_DemoInvoiceWithAtPath_and_fragments_create());
        ec.executeChild(this, new DemoReminder_create4());
        ec.executeChild(this, new DemoToDoItem_create_usingExcelFixture("sven"));

    }

    @Inject
    QueryResultsCache queryResultsCache;

}