package org.incode.example.commchannel.demo.shared.fixture;

import org.apache.isis.applib.fixturescripts.teardown.TeardownFixtureAbstract2;

import org.incode.example.commchannel.demo.shared.dom.CommChannelCustomer;

public class CommChannelCustomer_tearDown extends TeardownFixtureAbstract2 {

    @Override
    protected void execute(final ExecutionContext executionContext) {
        deleteFrom(CommChannelCustomer.class);
    }

}
