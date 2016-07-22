/*
 *
Copyright 2015 incode.org
 *
 *
 *  Licensed under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.incode.module.commchannel.dom.impl.channel;

import javax.inject.Inject;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.Contributed;
import org.apache.isis.applib.annotation.Mixin;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.PropertyLayout;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.annotation.Where;

import org.incode.module.commchannel.dom.impl.ownerlink.CommunicationChannelOwnerLink;
import org.incode.module.commchannel.dom.impl.ownerlink.CommunicationChannelOwnerLinkRepository;

@Mixin
public class CommunicationChannel_owner {

    //region > injected services
    @Inject
    CommunicationChannelOwnerLinkRepository communicationChannelOwnerLinkRepository;
    //endregion

    //region > constructor, mixedIn accessor
    private final CommunicationChannel<?> communicationChannel;
    public CommunicationChannel_owner(final CommunicationChannel<?> communicationChannel) {
        this.communicationChannel = communicationChannel;
    }
    @Programmatic
    public CommunicationChannel<?> getCommunicationChannel() {
        return communicationChannel;
    }
    //endregion

    //region > $$
    public static class DomainEvent extends CommunicationChannel.PropertyDomainEvent
                                        <CommunicationChannel_owner,Object> { }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(contributed = Contributed.AS_ASSOCIATION)
    @Property(
            domainEvent = DomainEvent.class,
            notPersisted = true
    )
    @PropertyLayout(hidden = Where.PARENTED_TABLES)
    public Object $$() {
        final CommunicationChannelOwnerLink link = communicationChannelOwnerLinkRepository.getOwnerLink(communicationChannel);
        return link != null? link.getOwner(): null;
    }
    //endregion

    //region > setOwner
    @Programmatic
    public void setOwner(final Object owner) {
        communicationChannelOwnerLinkRepository.removeOwnerLink(this.communicationChannel);
        communicationChannelOwnerLinkRepository.createLink(this.communicationChannel, owner);
    }
    //endregion

}
