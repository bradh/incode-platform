package org.incode.domainapp.module.fixtures.per_cpt.examples.commchannel.fixture;

import org.apache.isis.applib.fixturescripts.FixtureScript;
import org.apache.isis.applib.services.jdosupport.IsisJdoSupport;

public class CommChannelModule_tearDown extends FixtureScript {

    @Override
    protected void execute(final ExecutionContext executionContext) {

        isisJdoSupport.executeUpdate("delete from \"exampleDomCommChannel\".\"CommunicationChannelOwnerLinkForDemoObject\"");

        isisJdoSupport.executeUpdate("delete from \"incodeCommChannel\".\"CommunicationChannelOwnerLink\"");
        isisJdoSupport.executeUpdate("delete from \"incodeCommChannel\".\"CommunicationChannel\"");

    }


    @javax.inject.Inject
    IsisJdoSupport isisJdoSupport;

}