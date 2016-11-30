/*
 *  *
 * ProActive Parallel Suite(TM): The Java(TM) library for
 *    Parallel, Distributed, Multi-Core Computing for
 *    Enterprise Grids & Clouds
 *
 * Copyright (C) 1997-2015 INRIA/University of
 *                 Nice-Sophia Antipolis/ActiveEon
 * Contact: proactive@ow2.org or contact@activeeon.com
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; version 3 of
 * the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307
 * USA
 *
 * If needed, contact us to obtain a release under GPL Version 2 or 3
 * or a different license than the AGPL.
 *
 *  Initial developer(s):               The ProActive Team
 *                        http://proactive.inria.fr/team_members.htm
 *  Contributor(s):
 *
 *  * $$ACTIVEEON_INITIAL_DEV$$
 */
package org.ow2.proactive.scheduling.api.graphql.schema.type;

import org.ow2.proactive.scheduling.api.graphql.common.Types;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLEnumType;

import static graphql.schema.GraphQLEnumType.newEnum;

/**
 * @author ActiveEon Team
 */
public class JobPriority {

    public final static TypeSingleton<GraphQLEnumType> TYPE =
            new TypeSingleton<GraphQLEnumType>() {
                @Override
                public GraphQLEnumType buildType(DataFetcher... dataFetchers) {
                    return newEnum().name(Types.JOB_PRIORITY.getName())
                            .description("Available job's priorities.")
                            .value("HIGH", "HIGH", "High priority.")
                            .value("HIGHEST", "HIGHEST", "Highest priority.")
                            .value("IDLE", "IDLE", "Idle.")
                            .value("LOW", "LOW", "Low priority.")
                            .value("LOWEST", "LOWEST", "Lowest priority.")
                            .value("NORMAL", "NORMAL", "Normal priority.")
                            .build();
                }
            };

    private JobPriority() {
    }

}
