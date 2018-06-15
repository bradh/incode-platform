package org.incode.domainapp.module.fixtures.shared.demowithatpath.fixture;

import org.apache.isis.applib.fixturescripts.FixtureScript;
import org.apache.isis.applib.services.jdosupport.IsisJdoSupport;

public class DemoObjectWithAtPath_tearDown extends FixtureScript {

    @Override
    protected void execute(final ExecutionContext executionContext) {
        isisJdoSupport.executeUpdate("delete from \"exampleDemo\".\"DemoObjectWithAtPath\"");
    }


    @javax.inject.Inject
    IsisJdoSupport isisJdoSupport;

}