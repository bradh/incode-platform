package org.incode.domainapp.extended.module.fixtures.per_cpt.lib.poly.fixture;

import java.util.List;

import javax.inject.Inject;

import org.apache.isis.applib.fixturescripts.FixtureScript;

import org.incode.domainapp.extended.module.fixtures.per_cpt.lib.poly.dom.democasemgmt.Case;
import org.incode.domainapp.extended.module.fixtures.per_cpt.lib.poly.dom.demofixedasset.FixedAsset;
import org.incode.domainapp.extended.module.fixtures.per_cpt.lib.poly.dom.demoparty.Party;
import org.incode.domainapp.extended.module.fixtures.per_cpt.lib.poly.dom.poly.casecontent.CaseContentLinks;
import org.incode.domainapp.extended.module.fixtures.per_cpt.lib.poly.dom.poly.caseprimary.Case_makePrimary;
import org.incode.domainapp.extended.module.fixtures.per_cpt.lib.poly.fixture.data.democasemgmt.Case_create3;
import org.incode.domainapp.extended.module.fixtures.per_cpt.lib.poly.fixture.data.demofixedasset.FixedAsset_create6;
import org.incode.domainapp.extended.module.fixtures.per_cpt.lib.poly.fixture.data.demoparty.Party_create3;

public class Case_FixedAsset_Party_createAll extends FixtureScript {

    private Case_create3 createCases;
    private FixedAsset_create6 createFixedAssets;
    private Party_create3 createParties;

    public List<FixedAsset> getFixedAssets() {
        return createFixedAssets.getFixedAssets();
    }
    public List<Party> getParties() {
        return createParties.getParties();
    }
    public List<Case> getCases() {
        return createCases.getCases();
    }

    @Override
    protected void execute(final ExecutionContext ec) {

        createFixedAssets = new FixedAsset_create6();
        createParties = new Party_create3();
        createCases = new Case_create3();

        ec.executeChild(this, new Case_FixedAsset_Party_andLinks_tearDown());
        ec.executeChild(this, createFixedAssets);
        ec.executeChild(this, createParties);
        ec.executeChild(this, createCases);

        final List<Party> parties = createParties.getParties();
        final List<FixedAsset> fixedAssets = createFixedAssets.getFixedAssets();
        final List<Case> cases = createCases.getCases();

        // create comm channels
        int i=0;
        final Party party0 = parties.get(0);
        final Party party1 = parties.get(1);
        final Party party2 = parties.get(2);

        party0.addCommunicationChannel(commChannelDetailsFor(i++));
        party1.addCommunicationChannel(commChannelDetailsFor(i++));
        party1.addCommunicationChannel(commChannelDetailsFor(i++));
        party2.addCommunicationChannel(commChannelDetailsFor(i++));
        party2.addCommunicationChannel(commChannelDetailsFor(i++));
        party2.addCommunicationChannel(commChannelDetailsFor(i++));

        final FixedAsset fixedAsset0 = fixedAssets.get(0);
        final FixedAsset fixedAsset1 = fixedAssets.get(1);
        final FixedAsset fixedAsset2 = fixedAssets.get(2);

        fixedAsset0.createCommunicationChannel(commChannelDetailsFor(i++));
        fixedAsset1.createCommunicationChannel(commChannelDetailsFor(i++));
        fixedAsset2.createCommunicationChannel(commChannelDetailsFor(i++));

        // add content to cases
        final Case case0 = cases.get(0);
        final Case case1 = cases.get(1);

        caseContentLinks.createLink(case0, party0);
        caseContentLinks.createLink(case0, party1);
        caseContentLinks.createLink(case0, fixedAsset0);
        caseContentLinks.createLink(case0, fixedAsset1);

        caseContentLinks.createLink(case1, party1);
        caseContentLinks.createLink(case1, fixedAsset1);

        caseContentLinks.createLink(cases.get(2), party2);
        caseContentLinks.createLink(cases.get(2), fixedAsset2);

        // assign a primary content for cases
        factoryService.mixin(Case_makePrimary.class, case0).act(party1);
        factoryService.mixin(Case_makePrimary.class, case1).act(fixedAsset0);
    }

    private static String commChannelDetailsFor(final int i) {
        return String.format("0207 100 1%03d", i);
    }

    @Inject
    CaseContentLinks caseContentLinks;

}
