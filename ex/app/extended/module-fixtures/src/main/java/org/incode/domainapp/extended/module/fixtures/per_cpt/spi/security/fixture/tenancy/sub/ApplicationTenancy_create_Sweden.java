package org.incode.domainapp.extended.module.fixtures.per_cpt.spi.security.fixture.tenancy.sub;

import org.isisaddons.module.security.seed.scripts.GlobalTenancy;

public class ApplicationTenancy_create_Sweden extends AbstractTenancyFixtureScript {

    public static final String TENANCY_NAME = "Sweden";
    public static final String TENANCY_PATH = "/se";

    @Override
    protected void execute(ExecutionContext executionContext) {

        // prereqs
        executionContext.executeChild(this, new GlobalTenancy());

        create(TENANCY_NAME, TENANCY_PATH, GlobalTenancy.TENANCY_PATH, executionContext);
    }

}
