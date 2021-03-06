package org.incode.example.communications.demo.usage.spi.daa;

import java.util.List;

import javax.inject.Inject;

import com.google.common.collect.Lists;

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;

import org.incode.example.document.dom.impl.docs.Document;
import org.incode.example.document.dom.impl.types.DocumentType;
import org.incode.example.document.dom.impl.types.DocumentTypeRepository;
import org.incode.example.document.dom.spi.DocumentAttachmentAdvisor;
import org.incode.example.communications.demo.usage.fixture.doctypes.DocumentType_and_DocumentTemplates_createSome;

@DomainService(nature = NatureOfService.DOMAIN)
public class DocumentAttachmentAdvisorForReceipts implements DocumentAttachmentAdvisor {

    private static final String ROLE_NAME = "receipt";

    @Override
    public List<DocumentType> documentTypeChoicesFor(final Document document) {
        final DocumentType documentType = documentTypeRepository
                .findByReference(DocumentType_and_DocumentTemplates_createSome.DOC_TYPE_REF_RECEIPT);
        return Lists.newArrayList(documentType);
    }

    @Override
    public DocumentType documentTypeDefaultFor(final Document document) {
        return documentTypeChoicesFor(document).get(0);
    }

    @Override
    public List<String> roleNameChoicesFor(final Document document) {
        return Lists.newArrayList(ROLE_NAME);
    }

    @Override
    public String roleNameDefaultFor(final Document document) {
        return roleNameChoicesFor(document).get(0);
    }

    @Inject
    DocumentTypeRepository documentTypeRepository;


}
