package org.incode.examples.note.demo.shared.demo.fixture;

import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.services.registry.ServiceRegistry2;

import org.incode.examples.note.demo.shared.demo.dom.NotableObject;
import org.incode.module.fixturesupport.dom.data.DemoData;
import org.incode.module.fixturesupport.dom.data.DemoDataPersistAbstract;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Getter
@Accessors(chain = true)
public enum NotableObjectData implements DemoData<NotableObjectData, NotableObject> {

    Foo("Foo"),
    Bar("Bar"),
    Baz("Baz"),
    Foz("Foz"),
    ;

    private final String name;

    @Programmatic
    public NotableObject asDomainObject() {
        return NotableObject.builder()
                .name(name)
                .build();
    }

    @Programmatic
    public NotableObject persistUsing(final ServiceRegistry2 serviceRegistry) {
        return Util.persist(this, serviceRegistry);
    }

    @Programmatic
    public NotableObject findUsing(final ServiceRegistry2 serviceRegistry) {
        return Util.firstMatch(this, serviceRegistry);
    }

    public static class PersistScript extends DemoDataPersistAbstract<PersistScript, NotableObjectData, NotableObject> {
        public PersistScript() {
            super(NotableObjectData.class);
        }
    }

}
