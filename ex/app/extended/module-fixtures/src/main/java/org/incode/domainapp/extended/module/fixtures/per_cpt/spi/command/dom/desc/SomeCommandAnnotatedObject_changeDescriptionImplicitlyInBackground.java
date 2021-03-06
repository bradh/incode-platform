package org.incode.domainapp.extended.module.fixtures.per_cpt.spi.command.dom.desc;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.CommandExecuteIn;
import org.apache.isis.applib.annotation.CommandReification;
import org.apache.isis.applib.annotation.Mixin;
import org.apache.isis.applib.annotation.Optionality;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;

import org.incode.domainapp.extended.module.fixtures.per_cpt.spi.command.dom.SomeCommandAnnotatedObject;

@Mixin
public class SomeCommandAnnotatedObject_changeDescriptionImplicitlyInBackground {

    private final SomeCommandAnnotatedObject someCommandAnnotatedObject;

    public SomeCommandAnnotatedObject_changeDescriptionImplicitlyInBackground(SomeCommandAnnotatedObject someCommandAnnotatedObject) {
        this.someCommandAnnotatedObject = someCommandAnnotatedObject;
    }

    @Action(
            semantics = SemanticsOf.IDEMPOTENT,
            command = CommandReification.ENABLED,
            commandExecuteIn = CommandExecuteIn.BACKGROUND
    )
    public SomeCommandAnnotatedObject $$(
            @Parameter(optionality = Optionality.OPTIONAL)
            @ParameterLayout(named = "Description")
            final String description) {
        someCommandAnnotatedObject.setDescription(description);
        return someCommandAnnotatedObject;
    }

    public String default0$$() {
        return someCommandAnnotatedObject.getDescription();
    }

}
