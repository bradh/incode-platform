package org.incode.example.communications.demo.usage.dom.commchannels;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.InheritanceStrategy;

import com.google.common.eventbus.Subscribe;

import org.axonframework.eventhandling.annotation.EventHandler;

import org.apache.isis.applib.AbstractSubscriber;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;

import org.incode.example.communications.demo.shared.demowithnotes.dom.CommsCustomer;
import org.incode.example.communications.dom.impl.commchannel.CommunicationChannelOwner;
import org.incode.example.communications.dom.impl.commchannel.CommunicationChannelOwnerLink;

@javax.jdo.annotations.PersistenceCapable(
        identityType= IdentityType.DATASTORE,
        schema ="communicationsDemoUsage"
)
@javax.jdo.annotations.Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
@DomainObject(
        // objectType inferred from schema
)
public class CommunicationChannelOwnerLinkForCustomer extends CommunicationChannelOwnerLink {

    //region > notableObject (property)
    private CommsCustomer demoCustomer;

    @Column(
            allowsNull = "false",
            name = "demoObjectId"
    )
    public CommsCustomer getDemoCustomer() {
        return demoCustomer;
    }

    public void setDemoCustomer(final CommsCustomer demoCustomer) {
        this.demoCustomer = demoCustomer;
    }
    //endregion

    @Override
    public void setPolymorphicReference(final CommunicationChannelOwner polymorphicReference) {
        super.setPolymorphicReference(polymorphicReference);
        setDemoCustomer((CommsCustomer) polymorphicReference);
    }

    //    //region > owner (hook, derived)
//    @Override
//    public Object getOwner() {
//        return getDemoObject();
//    }
//
//    @Override
//    protected void setOwner(final Object object) {
//        setDemoObject((CommChannelDemoObject) object);
//    }
//    //endregion

//    //region > SubtypeProvider SPI implementation
//    @DomainService(nature = NatureOfService.DOMAIN)
//    public static class SubtypeProvider extends CommunicationChannelOwnerLinkRepository.SubtypeProviderAbstract {
//        public SubtypeProvider() {
//            super(CommChannelDemoObject.class, CommunicationChannelOwnerLinkForDemoObject.class);
//        }
//    }
//    //endregion

    @DomainService(nature = NatureOfService.DOMAIN)
    public static class InstantiationSubscriber extends AbstractSubscriber {

        @EventHandler
        @Subscribe
        public void on(final CommunicationChannelOwnerLink.InstantiateEvent ev) {
            if(ev.getPolymorphicReference() instanceof CommsCustomer) {
                ev.setSubtype(CommunicationChannelOwnerLinkForCustomer.class);
            }
        }
    }


//    //region > mixins
//
//    @Mixin
//    public static class _communicationChannels extends T_communicationChannels<CommChannelDemoObject> {
//        public _communicationChannels(final CommChannelDemoObject owner) {
//            super(owner);
//        }
//    }
//
//    @Mixin
//    public static class _addEmailAddress extends T_addEmailAddress<CommChannelDemoObject> {
//        public _addEmailAddress(final CommChannelDemoObject owner) {
//            super(owner);
//        }
//    }
//
//    @Mixin
//    public static class _addPhoneOrFaxNumber extends T_addPhoneOrFaxNumber<CommChannelDemoObject> {
//        public _addPhoneOrFaxNumber(final CommChannelDemoObject owner) {
//            super(owner);
//        }
//    }
//
//    @Mixin
//    public static class _addPostalAddress extends T_addPostalAddress<CommChannelDemoObject> {
//        public _addPostalAddress(final CommChannelDemoObject owner) {
//            super(owner);
//        }
//    }
//
//    //endregion

}
