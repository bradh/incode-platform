package org.incode.domainapp.module.fixtures.per_cpt.examples.document.fixture;

import org.apache.isis.applib.fixturescripts.FixtureScript;
import org.apache.isis.applib.services.jdosupport.IsisJdoSupport;

import org.incode.domainapp.module.fixtures.shared.demowithurl.fixture.DemoObjectWithUrl_tearDown;
import org.incode.domainapp.module.fixtures.shared.other.fixture.OtherObject_tearDown;
import org.incode.example.document.fixture.teardown.DocumentModule_tearDown;

public class DemoModule_and_DocTypesAndTemplates_tearDown extends FixtureScript {

    @Override
    protected void execute(final ExecutionContext executionContext) {

        // paperclip links
        isisJdoSupport.executeUpdate("delete from \"exampleDomDocument\".\"PaperclipForDemoObjectWithUrl\"");

        isisJdoSupport.executeUpdate("delete from \"exampleDomDocument\".\"PaperclipForOtherObject\"");

        // documents
        executionContext.executeChild(this, new DocumentModule_tearDown());

        // demo objects
        executionContext.executeChild(this, new DemoObjectWithUrl_tearDown());
        executionContext.executeChild(this, new OtherObject_tearDown());

    }


    @javax.inject.Inject
    IsisJdoSupport isisJdoSupport;

}
