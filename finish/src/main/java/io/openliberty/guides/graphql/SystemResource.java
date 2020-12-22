// tag::copyright[]
/*******************************************************************************
 * Copyright (c) 2020 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - Initial implementation
 *******************************************************************************/
// end::copyright[]
package io.openliberty.guides.graphql;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.NonNull;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;

import io.openliberty.guides.graphql.models.JavaInfo;
import io.openliberty.guides.graphql.models.OperatingSystem;
import io.openliberty.guides.graphql.models.SystemInfo;

// tag::graphqlapi[]
@GraphQLApi
// end::graphqlapi[]
public class SystemResource {

    // tag::query[]
    @Query("system")
    // end::query[]
    // tag::nonnull1[]
    @NonNull
    // end::nonnull1[]
    // tag::description1[]
    @Description("Gets information about the system")
    // end::description1[]
    public SystemInfo getSystemInfo() {
        SystemInfo output = new SystemInfo(System.getProperties());
        return output;
    }

    // tag::mutation[]
    @Mutation("editNote")
    // end::mutation[]
    // tag::description2[]
    @Description("Changes the note set for the system")
    // end::description2[]
    // tag::editNoteHeader[]
    public boolean editNote(@Name("note") String note) {
    // end::editNoteHeader[]
        System.setProperty("note", note);
        return true;
    }

    // Nested objects, these are more expensive to obtain
    @NonNull
    // tag::operatingSystemHeader[]
    public OperatingSystem operatingSystem(@Source @Name("system") SystemInfo systemInfo) {
    // end::operatingSystemHeader[]
        return new OperatingSystem(System.getProperties());
    }

    // tag::nonnull3[]
    @NonNull
    // end::nonnull3[]
    // tag::javaHeader[]
    public JavaInfo java (@Source @Name("system") SystemInfo systemInfo) {
    // end::javaHeader[]
        return new JavaInfo(System.getProperties());
    }

}
