package org.incode.domainapp.extended.module.fixtures.per_cpt.examples.document.fixture;

import org.apache.isis.applib.fixturescripts.FixtureScript;

public class DemoObjectWithUrl_and_OtherObject_and_docrefdata_recreate extends FixtureScript {

    @Override
    protected void execute(final ExecutionContext ec) {

        ec.executeChild(this, new DemoModule_and_DocTypesAndTemplates_tearDown());
        ec.executeChild(this, new DemoObjectWithUrl_and_OtherObject_and_docrefdata_create());

    }


}