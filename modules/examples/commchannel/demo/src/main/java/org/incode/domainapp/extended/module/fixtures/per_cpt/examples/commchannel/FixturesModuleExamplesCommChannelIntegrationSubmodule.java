package org.incode.example.alias.demo.examples.commchannel;

import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.collect.Sets;

import org.apache.isis.applib.Module;
import org.apache.isis.applib.ModuleAbstract;
import org.apache.isis.applib.fixturescripts.FixtureScript;
import org.apache.isis.applib.fixturescripts.teardown.TeardownFixtureAbstract2;

import org.incode.example.alias.demo.examples.commchannel.dom.CommunicationChannelOwnerLinkForDemoObject;
import org.incode.domainapp.extended.module.fixtures.shared.demo.FixturesModuleSharedDemoSubmodule;
import org.incode.example.commchannel.CommChannelModule;

@XmlRootElement(name = "module")
public class FixturesModuleExamplesCommChannelIntegrationSubmodule extends ModuleAbstract {

    @Override public Set<Module> getDependencies() {
        return Sets.newHashSet(
                new CommChannelModule(),
                new FixturesModuleSharedDemoSubmodule()
        );
    }

    @Override public FixtureScript getTeardownFixture() {
        return new TeardownFixtureAbstract2() {
            @Override protected void execute(final ExecutionContext executionContext) {
                deleteFrom(CommunicationChannelOwnerLinkForDemoObject.class);
            }
        };
    }
}