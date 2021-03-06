package org.incode.domainapp.extended.module.fixtures.per_cpt.spi.security.fixture.userrole;

import org.incode.domainapp.extended.module.fixtures.per_cpt.spi.security.fixture.roles.sub.RoleAndPermissions_create_exampleGuest;
import org.incode.domainapp.extended.module.fixtures.per_cpt.spi.security.fixture.roles.sub.RoleAndPremissions_create_exampleNoGuest;
import org.incode.domainapp.extended.module.fixtures.per_cpt.spi.security.fixture.users.ApplicationUser_Conflicted;

public class UserRole_create_Conflicted_has_conflicting_roles extends AbstractUserRoleFixtureScript {
    public UserRole_create_Conflicted_has_conflicting_roles() {
        super(ApplicationUser_Conflicted.USER_NAME,
                RoleAndPermissions_create_exampleGuest.ROLE_NAME,
                RoleAndPremissions_create_exampleNoGuest.ROLE_NAME);
    }
}
