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

import com.sun.javafx.collections.ObservableListWrapper;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import qool.db.Course;
import static qool.util.I18n.$;
import qool.view.QoolView;
import qool.view.QoolWidget;
import qool.view.ViewUtils;

/**
 *
 * @author Shamshad Alam
 */
public class CourseWidget extends QoolWidget {

    public CourseWidget(QoolView view) {
        super(view);
        super.setTitle("Course");
    }

    @Override
    public Pane createWidget() {
        return new CoursePane(getView());
    }

    private class CoursePane extends VBox {
        private Course course = new Course();
        private final ObservableList<Course> list = new ObservableListWrapper(new ArrayList<>());
        private final QoolView view;
        private final TextField titleTextField = new TextField();
        private final Button submitButton = ViewUtils.createButton($("action.save"));
        private final Button cancelButton = ViewUtils.createButton($("action.cancel"), true);
        private final TableView<Course> tableView = new TableView<>(list);

        public CoursePane(QoolView qool) {
            this.setAlignment(Pos.CENTER);
            this.setFillWidth(true);
            this.view = qool;
            this.setSpacing(4.0);
            initView();
        }

        private void initView() {
            this.titleTextField.setPromptText("Enter title");
            GridPane pane = new GridPane();
            pane.setAlignment(Pos.CENTER);
            pane.setHgap(5);
            pane.setVgap(5);
            pane.setPadding(new Insets(4));
            pane.add(ViewUtils.createLabel("Title"), 0, 0);
            pane.add(titleTextField, 1, 0, 2, 1);
            pane.add(submitButton, 1, 1);
            pane.add(cancelButton, 2, 1);
            this.getChildren().addAll(pane, tableView);
            tableView.getColumns().add(ViewUtils.createColumn("Title", "title"));
            list.addAll(view.getDbManager().findAll(Course.class));

            tableView.getSelectionModel().selectedItemProperty().addListener((e, o, n) -> {
                if (n != null) {
                    course = n;
                    titleTextField.setText(course.getTitle());
                    submitButton.setText($("action.update"));
                    cancelButton.setDisable(false);
                }
            });

            this.submitButton.setOnAction((e) -> {
                course.setTitle(titleTextField.getText());
                try {
                    view.getDbManager().saveOrUpdate(course);
                    tableView.getSelectionModel().clearSelection();
                    list.clear();
                    list.addAll(view.getDbManager().findAll(Course.class));
                    clear();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            });

            cancelButton.setOnAction((e) -> {
                clear();
            });
        }

        private void clear() {
            submitButton.setText($("action.save"));
            cancelButton.setDisable(true);
            course = new Course();
            titleTextField.clear();
        }
    }
}
