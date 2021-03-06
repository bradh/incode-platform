package org.incode.example.classification.integtests.tests.category;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import org.apache.isis.applib.services.wrapper.InvalidException;

import org.incode.example.classification.demo.shared.demowithatpath.dom.SomeClassifiedObjectMenu;
import org.incode.example.classification.dom.impl.applicability.ApplicabilityRepository;
import org.incode.example.classification.dom.impl.category.Category;
import org.incode.example.classification.dom.impl.category.CategoryRepository;
import org.incode.example.classification.dom.impl.classification.ClassificationRepository;
import org.incode.example.classification.dom.spi.ApplicationTenancyService;
import org.incode.example.classification.integtests.ClassificationModuleIntegTestAbstract;
import org.incode.example.classification.demo.usage.fixture.DemoObjectWithAtPath_and_OtherObjectWithAtPath_create3;
import org.incode.example.classification.demo.usage.fixture.DemoObjectWithAtPath_and_OtherObjectWithAtPath_tearDown;

import static org.assertj.core.api.Assertions.assertThat;

public class Category_name_IntegTest extends ClassificationModuleIntegTestAbstract {

    @Inject
    ClassificationRepository classificationRepository;
    @Inject
    CategoryRepository categoryRepository;
    @Inject
    ApplicabilityRepository applicabilityRepository;

    @Inject
    SomeClassifiedObjectMenu demoObjectMenu;
    @Inject
    ApplicationTenancyService applicationTenancyService;

    @Before
    public void setUpData() throws Exception {
        fixtureScripts.runFixtureScript(new DemoObjectWithAtPath_and_OtherObjectWithAtPath_tearDown(), null);
        fixtureScripts.runFixtureScript(new DemoObjectWithAtPath_and_OtherObjectWithAtPath_create3(), null);
    }

    @Test
    public void happy_case() {
        // given
        Category medium = categoryRepository.findByReference("M");
        assertThat(medium.getFullyQualifiedName()).isEqualTo("Sizes/Medium");

        // when
        medium.modifyName("Middle");

        // then
        assertThat(medium.getName()).isEqualTo("Middle");
        assertThat(medium.getFullyQualifiedName()).isEqualTo("Sizes/Middle");
    }

    @Test
    public void fully_qualified_name_of_children_also_updated() {
        // given
        Category large = categoryRepository.findByReference("LGE");
        assertThat(large.getFullyQualifiedName()).isEqualTo("Sizes/Large");
        assertThat(large.getChildren()).allMatch(c -> c.getFullyQualifiedName().split("/")[1].equals("Large"));

        // when
        large.modifyName("LRG");

        // then
        assertThat(large.getFullyQualifiedName()).isEqualTo("Sizes/LRG");
        assertThat(large.getChildren()).allMatch(c -> c.getFullyQualifiedName().split("/")[1].equals("LRG"));
    }

    @Test
    public void cannot_rename_to_a_name_already_in_use() {
        // given
        Category red = categoryRepository.findByReference("FRRED");

        // then
        expectedExceptions.expect(InvalidException.class);
        expectedExceptions.expectMessage("A category with name 'White' already exists (under this parent)");

        // when
        wrap(red).setName("White");
    }

}