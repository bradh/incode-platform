package org.incode.example.classification.fixture;

import org.apache.isis.applib.fixturescripts.teardown.TeardownFixtureAbstract2;

import org.incode.example.classification.dom.impl.applicability.Applicability;
import org.incode.example.classification.dom.impl.category.Category;
import org.incode.example.classification.dom.impl.classification.Classification;

public class ClassificationModule_teardown extends TeardownFixtureAbstract2 {
    @Override
    protected void execute(final ExecutionContext executionContext) {
        deleteFrom(Classification.class);
        //deleteFrom(Taxonomy.class);
        deleteFrom(Applicability.class);
        deleteFrom(Category.class);
    }
}
