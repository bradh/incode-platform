package org.incode.example.alias.demo.examples.classification.fixture;

import org.apache.isis.applib.fixturescripts.FixtureScript;
import org.apache.isis.applib.services.jdosupport.IsisJdoSupport;

import org.incode.domainapp.extended.module.fixtures.shared.demowithatpath.fixture.DemoObjectWithAtPath_tearDown;
import org.incode.domainapp.extended.module.fixtures.shared.otherwithatpath.fixture.OtherObjectWithAtPath_tearDown;

public class DemoObjectWithAtPath_and_OtherObjectWithAtPath_tearDown extends FixtureScript {

    @Override
    protected void execute(final ExecutionContext executionContext) {

        executionContext.executeChild(this, new Classifications_tearDown());

        executionContext.executeChild(this, new DemoObjectWithAtPath_tearDown());
        executionContext.executeChild(this, new OtherObjectWithAtPath_tearDown());

    }


    @javax.inject.Inject
    IsisJdoSupport isisJdoSupport;

}