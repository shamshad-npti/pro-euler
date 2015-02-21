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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import qool.db.Quiz;
import qool.util.I18n;
import qool.view.QoolView;
import qool.view.QoolWidget;
import qool.view.ViewUtils;

/**
 *
 * @author Shamshad Alam
 */
public class QuizWidget extends QoolWidget {

    public QuizWidget(QoolView view) {
        super(view);
        super.setTitle("Quiz");
    }

    @Override
    public Pane createWidget() {
        return new QuizPane();
    }

    private class QuizPane extends VBox {
        private Quiz quiz = new Quiz();
        private final TextField titleTextField = ViewUtils.createTextField("Title");
        private final TextArea descText = new TextArea();
        private final DatePicker scheduledDatePicker = new DatePicker();
        private final TextField accessCode = ViewUtils.createTextField("");
        private final ObservableList<Quiz> list = new ObservableListWrapper<>(new ArrayList<>());
        private final TableView<Quiz> quizView = new TableView<>(list);

        private final Button saveButton = ViewUtils.createButton(I18n.$("action.save"), (e) -> {
            save();
        });

        private final Button cancelButton = ViewUtils.createButton(I18n.$("action.cancel"), (e) -> {
            clear();
        }, true);

        public QuizPane() {
            inits();
        }

        private void inits() {
            GridPane pane = ViewUtils.createGridPane();
            pane.add(ViewUtils.createLabel("Access Code"), 0, 0);
            pane.add(accessCode, 1, 0);
            pane.add(ViewUtils.createLabel("Title"), 0, 1);
            pane.add(titleTextField, 1, 1);
            pane.add(ViewUtils.createLabel("Description"), 0, 2);
            pane.add(descText, 1, 2);
            pane.add(ViewUtils.createLabel("Schedule Date"), 0, 3);
            pane.add(scheduledDatePicker, 1, 3);
            HBox hbox = new HBox(4, saveButton, cancelButton);
            pane.add(hbox, 1, 4);
            this.getChildren().add(pane);
            quizView.getColumns().addAll(ViewUtils.createColumn("Title", "title"), ViewUtils.createColumn("Description", "description"),
                    ViewUtils.createColumn("Scheduled Date", "scheduledDate"), ViewUtils.createColumn("Access Code", "accessCode"));
            list.addAll(getView().getDbManager().findAll(Quiz.class));
            this.getChildren().add(quizView);
        }

        private void save() {
            try {
                saveButton.setDisable(true);
                quiz.setTitle(titleTextField.getText());
                quiz.setDescription(descText.getText());
                if (!getView().getDbManager().exists(quiz)) {
                    quiz.setAccessCode(java.util.UUID.randomUUID().toString());
                    getView().getDbManager().save(quiz);
                } else {
                    getView().getDbManager().saveOrUpdate(quiz);
                }
                clear();
                list.clear();
                list.addAll(getView().getDbManager().findAll(Quiz.class));
                System.out.println("Saved");
            } catch (Exception ex) {

            } finally {
                saveButton.setDisable(false);
            }
        }

        private void clear() {
            titleTextField.clear();
            descText.clear();
            accessCode.clear();
            saveButton.setText(I18n.$("action.save"));
            cancelButton.setDisable(true);
            quiz = new Quiz();
        }
    }
}
