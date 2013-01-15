package org.bimserver.longaction;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import org.bimserver.BimServer;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.webservices.authorization.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongBranchAction extends LongAction<LongCheckinActionKey> {
	private static final Logger LOGGER = LoggerFactory.getLogger(LongBranchAction.class);

	private BimDatabaseAction<ConcreteRevision> action;

	public LongBranchAction(BimServer bimServer, String username, String userUsername, Authorization authorization, BimDatabaseAction<ConcreteRevision> action) {
		super(bimServer, username, userUsername, authorization);
		this.action = action;
	}

	@Override
	public String getDescription() {
		return "Branch to new project";
	}

	@Override
	public void init() {
	}

	@Override
	public void execute() {
		try {
			action.execute();
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}
}