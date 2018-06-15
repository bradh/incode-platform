package org.incode.domainapp.module.fixtures.per_cpt.examples.alias.fixture;

import org.apache.isis.applib.fixturescripts.FixtureScript;

import org.incode.domainapp.module.fixtures.shared.demo.dom.DemoObject;
import org.incode.domainapp.module.fixtures.shared.demo.fixture.DemoObjectData;
import org.incode.domainapp.module.fixtures.per_cpt.examples.alias.dom.AliasForDemoObject;
import org.incode.domainapp.module.fixtures.per_cpt.examples.alias.spiimpl.aliastype.AliasTypeDemoEnum;
import org.incode.example.alias.dom.impl.T_addAlias;

public class DemoObject_withAliases_create2 extends FixtureScript {

    T_addAlias mixinAddAlias(final Object aliased) {
        return factoryService.mixin(AliasForDemoObject._addAlias.class, aliased);
    }

    @Override
    protected void execute(final ExecutionContext executionContext) {

        final DemoObject foo = DemoObjectData.Foo.findUsing(serviceRegistry);
        final DemoObject bar = DemoObjectData.Bar.findUsing(serviceRegistry);

        wrap(mixinAddAlias(foo)).$$("/uk", AliasTypeDemoEnum.GENERAL_LEDGER, "12345");
        wrap(mixinAddAlias(foo)).$$("/uk", AliasTypeDemoEnum.DOCUMENT_MANAGEMENT, "http://docserver.mycompany/url/12345");
        wrap(mixinAddAlias(foo)).$$("/uk", AliasTypeDemoEnum.PERSONNEL_SYSTEM, "12345");

        wrap(mixinAddAlias(bar)).$$("/uk", AliasTypeDemoEnum.GENERAL_LEDGER, "98765");
        wrap(mixinAddAlias(bar)).$$("/nl", AliasTypeDemoEnum.GENERAL_LEDGER, "12345");
        wrap(mixinAddAlias(foo)).$$("/nl", AliasTypeDemoEnum.DOCUMENT_MANAGEMENT, "http://docserver.mycompany/url/12345");
    }


}