/*
 * Copyright (C) 2015 Shamshad Alam
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package qool.view.admin;

import qool.dao.DbManager;
import qool.view.QoolView;
import qool.view.ViewSetting;

/**
 *
 * @author shame
 */
public class AdminView extends QoolView {

    public AdminView(DbManager dbManager) {
        super(dbManager);
        super.getViewManager().addToLeftPane(new AdminLeftPane(this));
    }

    @Override
    public ViewSetting getViewSetting() {
        return new ViewSetting() {

            @Override
            public boolean leftPaneVisible() {
                return true;
            }

            @Override
            public boolean rightPaneVisible() {
                return true;
            }

            @Override
            public boolean toolBarVisible() {
                return true;
            }

            @Override
            public boolean statusBarVisible() {
                return true;
            }

            @Override
            public boolean menuBarVisible() {
                return true;
            }

            @Override
            public boolean openInNewWindow() {
                return true;
            }
        };
    }

}
