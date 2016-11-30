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
public final class JobStatus {

    public final static TypeSingleton<GraphQLEnumType> TYPE = new TypeSingleton<GraphQLEnumType>() {
        @Override
        public GraphQLEnumType buildType(DataFetcher... dataFetchers) {
            return newEnum().name(Types.JOB_STATUS.getName())
                    .description("Available job's statuses.")
                    .value("CANCELED", "CANCELED",
                            "The job has been canceled due to user exceptions and order. " +
                                    "This status runs when a user exceptions occurs in a task and when the user has asked " +
                                    "to cancel On exceptions.")
                    .value("FAILED", "FAILED",
                            "The job has failed. One or more tasks have failed (due to resources " +
                                    "failure). There is no more executionOnFailure left for a task.")
                    .value("FINISHED", "FINISHED", "The job is finished. Every tasks are finished.")
                    .value("IN_ERROR", "IN_ERROR",
                            "The job has at least one in-error task and in-error tasks are " +
                                    "the last, among others which have changed their state (i.e. Job status is depicted " +
                                    "by the last action).")
                    .value("KILLED", "KILLED",
                            "The job has been killed by a user. Nothing can be done anymore on " +
                                    "this job except reading execution information such as output, time, etc.")
                    .value("PAUSED", "PAUSED", "The job is paused waiting for user to resume it.")
                    .value("PENDING", "PENDING", "The job is waiting to be scheduled.")
                    .value("RUNNING", "RUNNING", "The job is running. Actually at least one of its task " +
                            "has been scheduled.")
                    .value("STALLED", "STALLED",
                            "The job has been launched but no task are currently running.")
                    .build();
        }
    };

    private JobStatus() {
    }

}
