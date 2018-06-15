package org.incode.domainapp.extended.module.fixtures.shared.demowithall.fixture;

import org.apache.isis.applib.fixturescripts.FixtureScript;
import org.apache.isis.applib.services.jdosupport.IsisJdoSupport;

public class DemoObjectWithAll_tearDown extends FixtureScript {

    @Override
    protected void execute(final ExecutionContext executionContext) {
        isisJdoSupport.executeUpdate("delete from \"exampleDemo\".\"DemoObjectWithAll\"");
    }


    @javax.inject.Inject
    IsisJdoSupport isisJdoSupport;

}