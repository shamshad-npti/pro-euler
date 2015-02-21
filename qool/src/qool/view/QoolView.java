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
package qool.view;

import java.io.Serializable;
import javafx.scene.control.Menu;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import qool.dao.DbManager;

/**
 *
 * @author Shamshad Alam
 */
public abstract class QoolView implements Serializable {

    private final DbManager dbManager;
    private final ViewManager viewManager;
    private final VBox topPane;
    private final VBox root;
    private final SplitPane centerPane;
    private final VBox leftPane;
    private final VBox rightPane;
    private final TabPane middlePane;

    public QoolView(DbManager dbManager) {
        this.dbManager = dbManager;
        this.viewManager = new DefaultViewManager(this);
        this.middlePane = new TabPane();
        this.rightPane = new VBox();
        this.leftPane = new VBox();
        this.centerPane = new SplitPane();
        this.centerPane.setDividerPositions(0.2, 0.8);
        this.centerPane.getItems().addAll(leftPane, middlePane, rightPane);
        this.topPane = new VBox();
        this.root = new VBox(topPane, centerPane);
        initView();
    }

    private void initView() {
        // TODO: Make it perfect
        ViewSetting setting = getViewSetting();
        if (setting != null) {
            leftPane.setVisible(setting.leftPaneVisible());
            rightPane.setVisible(setting.rightPaneVisible());
        }
    }

    public ViewManager getViewManager() {
        return viewManager;
    }

    public DbManager getDbManager() {
        return dbManager;
    }

    public Pane createView() {
        return root;
    }

    protected abstract ViewSetting getViewSetting();

    private static class DefaultViewManager implements ViewManager {
        private final QoolView qoolView;

        public DefaultViewManager(QoolView qoolView) {
            this.qoolView = qoolView;
        }

        @Override
        public void addToLeftPane(QoolWidget widget) {
            qoolView.leftPane.getChildren().add(widget.createWidget());
        }

        @Override
        public void addToMenuBar(Menu menu) {
            // TODO : Implemet ViewManager
        }

        @Override
        public void addToRightPane(QoolWidget widget) {
            qoolView.rightPane.getChildren().add(widget.createWidget());
        }

        @Override
        public void addToToolBar(ToolBar toolBar) {
            // TODO
        }

        @Override
        public void setMainPane(QoolWidget widget) {
            Tab tab = new Tab(widget.getTitle());
            tab.setClosable(true);
            tab.setContent(widget.createWidget());
            qoolView.middlePane.getTabs().add(tab);
            qoolView.middlePane.getSelectionModel().select(tab);
        }

    }
}
