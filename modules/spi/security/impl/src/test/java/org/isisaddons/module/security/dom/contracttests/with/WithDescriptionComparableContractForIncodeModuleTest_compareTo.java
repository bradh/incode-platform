package org.isisaddons.module.security.dom.contracttests.with;

import com.google.common.collect.ImmutableMap;

import org.incode.module.base.dom.with.ComparableByDescriptionContractTestAbstract_compareTo;
import org.incode.module.base.dom.with.WithDescriptionComparable;

/**
 * Automatically tests all domain objects implementing {@link WithDescriptionComparable}.
 */
public class WithDescriptionComparableContractForIncodeModuleTest_compareTo extends
        ComparableByDescriptionContractTestAbstract_compareTo {

    public WithDescriptionComparableContractForIncodeModuleTest_compareTo() {
        super("org.isisaddons.module.security", ImmutableMap.<Class<?>,Class<?>>of());
    }

}
