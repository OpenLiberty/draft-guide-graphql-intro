// tag::copyright[]
/*******************************************************************************
 * Copyright (c) 2021 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - Initial implementation
 *******************************************************************************/
// end::copyright[]
package io.openliberty.guides.graphql.models;

import java.util.Properties;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.NonNull;
import org.eclipse.microprofile.graphql.Type;

// tag::type[]
@Type("system")
// end::type[]
@Description("Information about a single system")
// tag::class[]
public class SystemInfo {

    private String timezone;

    @NonNull
    private String username;

    private String note;

    public SystemInfo() {
        super();
    }

    public SystemInfo(Properties systemProperties) {
        this.username = systemProperties.getProperty("user.name");
        this.timezone = systemProperties.getProperty("user.timezone");
        this.note = systemProperties.getProperty("note");
    }

    public String getNote() {
        return this.note;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public String getUsername() {
        return this.username;
    }

}
// end::class[]
