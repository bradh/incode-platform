package org.incode.example.tags.demo.shared.fixture.data;

public class TaggableObject_Bip_CocaCola_Drink extends AbstractTaggableObjectFixture {

    @Override
    protected void execute(ExecutionContext executionContext) {
        create("Bip", "Coca Cola", "Drink", executionContext);
    }

}
