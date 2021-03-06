package org.incode.example.document.demo.usage.dom.spiimpl;

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.value.Blob;
import org.apache.isis.applib.value.Clob;

import org.incode.example.document.dom.impl.docs.Document;
import org.incode.example.document.dom.spi.UrlDownloadService;

@DomainService(
    nature = NatureOfService.DOMAIN
)
public class UrlDownloadServiceForDemo implements UrlDownloadService {

    @Override
    public Blob downloadAsBlob(final Document document) {
        return document.getBlob();
    }

    @Override
    public Clob downloadAsClob(final Document document) {
        return document.getClob();
    }
}
