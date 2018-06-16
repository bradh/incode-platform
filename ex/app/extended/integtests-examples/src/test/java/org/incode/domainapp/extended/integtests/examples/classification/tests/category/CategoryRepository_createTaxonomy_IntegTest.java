package org.incode.domainapp.extended.integtests.examples.classification.tests.category;

import javax.inject.Inject;
import javax.jdo.JDODataStoreException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import org.incode.example.classification.dom.impl.applicability.ApplicabilityRepository;
import org.incode.example.classification.dom.impl.category.CategoryRepository;
import org.incode.example.classification.dom.impl.category.taxonomy.Taxonomy;
import org.incode.example.classification.dom.impl.classification.ClassificationRepository;
import org.incode.example.classification.dom.spi.ApplicationTenancyService;
import org.incode.domainapp.extended.integtests.examples.classification.ClassificationModuleIntegTestAbstract;
import org.incode.domainapp.extended.module.fixtures.shared.demowithatpath.dom.DemoObjectWithAtPathMenu;
import org.incode.domainapp.extended.integtests.examples.classification.dom.classification.fixture.DemoObjectWithAtPath_and_OtherObjectWithAtPath_create3;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryRepository_createTaxonomy_IntegTest extends ClassificationModuleIntegTestAbstract {

    @Inject
    ClassificationRepository classificationRepository;
    @Inject
    CategoryRepository categoryRepository;
    @Inject
    ApplicabilityRepository applicabilityRepository;

    @Inject
    DemoObjectWithAtPathMenu demoObjectMenu;
    @Inject
    ApplicationTenancyService applicationTenancyService;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUpData() throws Exception {
        fixtureScripts.runFixtureScript(new DemoObjectWithAtPath_and_OtherObjectWithAtPath_create3(), null);
    }

    @Test
    public void happy_case() {
        // when
        Taxonomy newTaxonomy = categoryRepository.createTaxonomy("New Taxonomy");

        // then
        assertThat(newTaxonomy.getName()).isEqualTo("New Taxonomy");
        assertThat(newTaxonomy.getParent()).isNull();
        assertThat(newTaxonomy.getReference()).isNull();
        assertThat(newTaxonomy.getOrdinal()).isEqualTo(1);
    }

    @Test
    public void when_name_already_in_use() {
        // given
        Taxonomy italianColours = (Taxonomy) categoryRepository.findByReference("ITACOL");
        assertThat(italianColours.getName()).isEqualTo("Italian Colours");
        sessionManagementService.nextSession();

        // then
        expectedException.expect(JDODataStoreException.class);
        expectedException.expectMessage("Classification_fullyQualifiedName_UNQ");

        // when
        categoryRepository.createTaxonomy("Italian Colours");
    }

}