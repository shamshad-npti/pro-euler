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

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

/**
 *
 * @author shame
 */
public class ViewUtils {
    public static <S> TableColumn<S, ?> createColumn(String title) {
        return createColumn(title, null);
    }

    public static <S> TableColumn<S, ?> createColumn(String title, String propertyName) {
        return createColumn(title, propertyName, false);
    }

    public static <S> TableColumn<S, ?> createColumn(String title, String propName, boolean sortable) {
        return createColumn(title, propName, sortable, true);
    }

    public static <S> TableColumn<S, ?> createColumn(String title, String propName, boolean sortable, boolean visible) {
        TableColumn<S, ?> column = new TableColumn<>(title);
        column.setCellValueFactory(new PropertyValueFactory<>(propName));
        column.setSortable(sortable);
        column.setVisible(visible);
        return column;
    }

    public static TextField createTextField(String promptText) {
        TextField field = new TextField();
        field.setPromptText(promptText);
        return field;
    }

    public static Label createLabel(String title) {
        return new Label(title);
    }

    public static Button createButton(String title, EventHandler<ActionEvent> handler) {
        return createButton(title, handler, false);
    }

    public static Button createButton(String title, EventHandler<ActionEvent> handler, boolean disabled) {
        Button button = new Button(title);
        button.setOnAction(handler);
        button.setDisable(disabled);
        button.setMinWidth(80);
        return button;
    }

    public static Button createButton(String title) {
        return createButton(title, false);
    }

    public static Button createButton(String title, boolean disabled) {
        Button button = new Button(title);
        button.setMinWidth(80);
        button.setDisable(disabled);
        return button;
    }

    public static GridPane createGridPane() {
        return createGridPane(4, 4, 4, Pos.CENTER);
    }

    public static GridPane createGridPane(int hGap, int vGap, int intsets, Pos pos) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(hGap);
        gridPane.setVgap(vGap);
        gridPane.setPadding(new Insets(intsets));
        gridPane.setAlignment(pos);
        return gridPane;
    }

}
