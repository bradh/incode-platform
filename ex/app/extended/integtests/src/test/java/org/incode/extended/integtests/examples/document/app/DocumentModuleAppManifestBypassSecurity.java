package org.incode.extended.integtests.examples.document.app;

/**
 * Bypasses security, meaning any user/password combination can be used to login.
 */
public class DocumentModuleAppManifestBypassSecurity extends DocumentModuleAppManifest {

    @Override
    protected String overrideAuthMechanism() {
        return "bypass";
    }

}