package org.incode.example.alias.demo.usage.spi.aliastype;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.isis.applib.annotation.Title;

import org.incode.example.alias.dom.spi.AliasType;

/**
 * In a real (not demo) application this would probably be an entity.
 *
 * <p>
 *     Can't just use the enum because - it seems - the framework doesn't pick up on enums implementing interfaces...
 * </p>
 */
@XmlRootElement
public class AliasTypeViewModel implements AliasType {

    @XmlElement
    private AliasTypeDemoEnum aliasTypeDemoEnum;

    public AliasTypeViewModel() {
    }

    public AliasTypeViewModel(final AliasTypeDemoEnum aliasTypeDemoEnum) {
        this.aliasTypeDemoEnum = aliasTypeDemoEnum;
    }

    @Title
    @XmlTransient
    @Override public String getId() {
        return aliasTypeDemoEnum.getId();
    }

}

