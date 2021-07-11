package org.openjfx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.openjfx.model.ResponseModel;
import org.openjfx.service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FXMLController implements Initializable {

        private static final String API_KEY = "bd01f04c77d24b54afd4de2e95d7da9c";

        private Service service;

        @FXML
        private TextArea resultTextArea;

        @FXML
        private TextField fileNameTextField;

        @FXML
        private TextField pathTextField;

        @FXML
        private Text resultSaveText;

        @Override
        public void initialize(URL url, ResourceBundle rb) {
                service = new Service();
        }

        @FXML
        public void getData() {
                final ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

                Call<ResponseModel> call = apiService.getNews("pl", "business", API_KEY);
                call.enqueue(new Callback<>() {
                        @Override
                        public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                                if (response.body().getStatus().equals("ok")) {
                                        resultTextArea.clear();
                                        resultTextArea.setText(service.updateResults(response.body().getArticles()));
                                }
                        }

                        @Override
                        public void onFailure(Call<ResponseModel> call, Throwable t) {
                                System.err.println(t.toString());
                        }
                });
        }

        @FXML
        public void saveToFile() {
                String result = service.save(pathTextField.getText().trim(),
                        resultTextArea.getText().trim(),
                        fileNameTextField.getText().trim());

                if(result.equals("OK")){
                        resultSaveText.setText("Saved");
                }else {
                        resultSaveText.setText("Not Saved");
                }
        }


}

