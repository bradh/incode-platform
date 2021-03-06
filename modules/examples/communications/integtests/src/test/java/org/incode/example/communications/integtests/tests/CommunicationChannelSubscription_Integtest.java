package org.incode.example.communications.integtests.tests;

import javax.inject.Inject;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import org.apache.isis.applib.fixturescripts.FixtureScripts;
import org.apache.isis.applib.services.wrapper.WrapperFactory;
import org.apache.isis.applib.services.xactn.TransactionService;

import org.incode.example.communications.demo.shared.demowithnotes.dom.CommsCustomer;
import org.incode.example.communications.demo.shared.demowithnotes.dom.CommsCustomerMenu;
import org.incode.example.communications.dom.impl.commchannel.CommunicationChannelOwnerLinkRepository;
import org.incode.example.communications.dom.impl.commchannel.CommunicationChannelRepository;
import org.incode.example.communications.dom.impl.commchannel.CommunicationChannelType;
import org.incode.example.communications.dom.impl.commchannel.EmailAddress;
import org.incode.example.communications.dom.impl.commchannel.PostalAddress;
import org.incode.example.communications.dom.impl.comms.Communication;
import org.incode.example.communications.dom.impl.comms.CommunicationRepository;
import org.incode.example.communications.demo.usage.fixture.DemoObjectWithNotes_and_DemoInvoice_and_docs_and_comms_create;
import org.incode.example.communications.demo.usage.fixture.demoobjwithnote.CommsCustomer_and_CommsInvoice_create3;
import org.incode.example.communications.integtests.CommunicationsModuleIntegTestAbstract;

public class CommunicationChannelSubscription_Integtest extends CommunicationsModuleIntegTestAbstract {

    @Inject CommunicationChannelRepository communicationChannelRepository;

    @Inject CommunicationRepository communicationRepository;

    @Inject
    FixtureScripts fixtureScripts;

    @Inject
    TransactionService transactionService;

    @Inject
    CommsCustomerMenu customerMenu;

    @Inject
    CommunicationChannelOwnerLinkRepository linkRepository;

    @Inject WrapperFactory wrapperFactory;

    @Before
    public void setUp() throws Exception {

        // given
        fixtureScripts.runFixtureScript(new DemoObjectWithNotes_and_DemoInvoice_and_docs_and_comms_create(), null);
        transactionService.nextTransaction();

        // and so given customer with an email
        final CommsCustomer fred = customerMenu.findDemoObjectsWithNotesByName(
                CommsCustomer_and_CommsInvoice_create3.FRED_HAS_EMAIL_AND_PHONE).get(0);

        final EmailAddress fredEmail = (EmailAddress) linkRepository
                .findByOwnerAndCommunicationChannelType(fred, CommunicationChannelType.EMAIL_ADDRESS)
                .get(0)
                .getCommunicationChannel();

    }

    @Test
    public void replacement_provided() throws Exception {
        // Given
        final CommsCustomer owner = customerMenu.findDemoObjectsWithNotesByName(
                CommsCustomer_and_CommsInvoice_create3.FRED_HAS_EMAIL_AND_PHONE).get(0);
        final PostalAddress postalAddress = communicationChannelRepository.newPostal(
                owner,
                CommunicationChannelType.POSTAL_ADDRESS,
                "Some address",
                null,
                null,
                null,
                null,
                null,
                null);

        final PostalAddress replaceWith = communicationChannelRepository.newPostal(
                owner,
                CommunicationChannelType.POSTAL_ADDRESS,
                "Replacement Address",
                null,
                null,
                null,
                null,
                null,
                null);

        final Communication communication = communicationRepository.createPostal("Subject", "/", postalAddress);
        final int size = communicationChannelRepository.findByOwner(owner).size();

        // When
        wrapperFactory.wrap(postalAddress).remove(replaceWith);

        //Then
        Assertions.assertThat(communicationChannelRepository.findByOwner(owner).size()).isEqualTo(size-1);

    }

    @Test
    public void validate_fails_when_no_replacement_is_provided() throws Exception {
        // Given
        final CommsCustomer owner = customerMenu.findDemoObjectsWithNotesByName(
                CommsCustomer_and_CommsInvoice_create3.FRED_HAS_EMAIL_AND_PHONE).get(0);
        final PostalAddress postalAddress = communicationChannelRepository.newPostal(
                owner,
                CommunicationChannelType.POSTAL_ADDRESS,
                "Some address",
                null,
                null,
                null,
                null,
                null,
                null);


        final Communication communication = communicationRepository.createPostal("Subject", "/", postalAddress);

        // Expect
        expectedExceptions.expectMessage("Communication channel is being used");

        // When
        wrap(postalAddress).remove(null);

    }

}
