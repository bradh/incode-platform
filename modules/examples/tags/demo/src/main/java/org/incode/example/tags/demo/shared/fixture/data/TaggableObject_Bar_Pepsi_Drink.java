package org.incode.example.tags.demo.shared.fixture.data;

public class TaggableObject_Bar_Pepsi_Drink extends AbstractTaggableObjectFixture {

    @Override
    protected void execute(ExecutionContext executionContext) {
        create("Bar", "Pepsi", "Drink", executionContext);
    }

}
