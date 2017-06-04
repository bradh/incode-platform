package org.isisaddons.module.publishmq.fixture.dom;

import org.apache.isis.applib.annotation.*;


@Mixin
public class Touchable_touch {

    private final Touchable touchable;

    public Touchable_touch(Touchable touchable) {
        this.touchable = touchable;
    }

    @Action(
            publishing = Publishing.ENABLED
    )
    public Touchable $$() {
        return touchable;
    }

}
