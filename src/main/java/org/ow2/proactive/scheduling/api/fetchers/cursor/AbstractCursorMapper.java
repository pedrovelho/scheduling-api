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
package org.ow2.proactive.scheduling.api.fetchers.cursor;

import graphql.relay.Base64;

public abstract class AbstractCursorMapper<F, T> implements CursorMapper<F, T> {

    protected static final String DUMMY_CURSOR_PREFIX = "graphql-cursor";

    @Override
    public T getOffsetFromCursor(String cursor) {

        if (cursor == null) {
            return null;
        }

        String string = Base64.fromBase64(cursor);
        return toOffset(string.substring(DUMMY_CURSOR_PREFIX.length()));
    }

    @Override
    public String createCursor(F field) {
        return Base64.toBase64(
                DUMMY_CURSOR_PREFIX +
                        toString(field));
    }

    abstract String toString(F field);

    abstract T toOffset(String cursor);

}
