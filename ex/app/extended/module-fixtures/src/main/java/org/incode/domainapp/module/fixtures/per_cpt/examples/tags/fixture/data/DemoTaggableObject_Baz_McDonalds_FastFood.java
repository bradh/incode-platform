package org.incode.domainapp.module.fixtures.per_cpt.examples.tags.fixture.data;

public class DemoTaggableObject_Baz_McDonalds_FastFood extends AbstractTaggableObjectFixture {

    @Override
    protected void execute(ExecutionContext executionContext) {
        create("Baz", "McDonalds", "Fast food", executionContext);
    }

}