package org.incode.example.classification.integtests.tests.category;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import org.incode.example.classification.demo.shared.demowithatpath.dom.SomeClassifiedObjectMenu;
import org.incode.example.classification.dom.impl.applicability.ApplicabilityRepository;
import org.incode.example.classification.dom.impl.category.Category;
import org.incode.example.classification.dom.impl.category.CategoryRepository;
import org.incode.example.classification.dom.impl.classification.ClassificationRepository;
import org.incode.example.classification.dom.spi.ApplicationTenancyService;
import org.incode.example.classification.integtests.ClassificationModuleIntegTestAbstract;
import org.incode.example.classification.demo.usage.fixture.DemoObjectWithAtPath_and_OtherObjectWithAtPath_create3;

import static org.assertj.core.api.Assertions.assertThat;

public class Category_ordinal_IntegTest extends ClassificationModuleIntegTestAbstract {

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
        fixtureScripts.runFixtureScript(new DemoObjectWithAtPath_and_OtherObjectWithAtPath_create3(), null);
    }

    @Test
    public void happy_case() {
        // given
        Category medium = categoryRepository.findByReference("M");
        assertThat(medium.getFullyQualifiedOrdinal()).isEqualTo("1.2");

        // when
        medium.modifyOrdinal(99);

        // then
        assertThat(medium.getFullyQualifiedOrdinal()).isEqualTo("1.99");
    }

    @Test
    public void fully_qualified_name_of_children_also_updated() {
        // given
        Category large = categoryRepository.findByReference("LGE");
        assertThat(large.getFullyQualifiedOrdinal()).isEqualTo("1.1");
        assertThat(large.getChildren()).allMatch(c -> c.getFullyQualifiedOrdinal().split("\\.")[1].equals("1"));

        // when
        large.modifyOrdinal(99);

        // then
        assertThat(large.getFullyQualifiedOrdinal()).isEqualTo("1.99");
        assertThat(large.getChildren()).allMatch(c -> c.getFullyQualifiedOrdinal().split("\\.")[1].equals("99"));
    }

    @Test
    public void can_clear() {
        // given
        Category smallest = categoryRepository.findByReference("XXS");
        assertThat(smallest.getFullyQualifiedOrdinal()).isEqualTo("1.3.3");

        // when
        smallest.clearOrdinal();

        // then
        assertThat(smallest.getFullyQualifiedOrdinal()).isEqualTo("1.3.0");
    }

}