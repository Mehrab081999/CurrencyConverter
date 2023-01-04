package com.example.practice;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


    @FXML
    public ComboBox<CountryCodeFactory> Fromcb;
    @FXML
    public ComboBox<CountryCodeFactory> Tocb;
    @FXML
    private TextField amountTextfield;
    @FXML
    private Button convertbutton;
    @FXML
    private Label convertLabel;
    @FXML
    private TextField convertedTextfield;

    @FXML
    private Label convertedAmountValueLabel;
    @FXML
    private Label negativeLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private ImageView imageBack;

    @FXML
    public void initialize ()
    {
        imageBack.setImage(new Image("resources/CurrencyVirtual.png"));
    }


    float amount;
    double convertedAmount;
    String DateShow;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        System.out.println("Initialize is calling.");

        Fromcb.setItems(FXCollections.observableArrayList(CountryCodeFactory.values()));
        Tocb.setItems(FXCollections.observableArrayList(CountryCodeFactory.values()));
    }

    @FXML
    public void convertButtonaction(ActionEvent event)  {


        negativeLabel.setText("");
        convertLabel.setText("");
        convertedAmountValueLabel.setText("");
        dateLabel.setText("");


       String fromCode = Fromcb.getSelectionModel().getSelectedItem().toString();

       CountryCodeFactory fromCodeResult = CountryCodeFactory.findByName(fromCode);

       String toCode = Tocb.getSelectionModel().getSelectedItem().toString();

       CountryCodeFactory toCodeResult = CountryCodeFactory.findByName(toCode);

        System.out.println("working button");
        amount = Float.parseFloat(amountTextfield.getText());
        if (amount <= 0 )
        {
            System.out.println("Invalid Amount");
            negativeLabel.setText("Invalid Amount");
        }

       else
        {


            try {
                NetworkLayer obj = new NetworkLayer();
               // convertedAmount = NetworkLayer.getSharedObject().getLatestCurrency(fromCodeResult.getValue(), toCodeResult.getValue(), amount);
               convertedAmount = obj.getLatestCurrency(fromCodeResult.getValue(),toCodeResult.getValue(),amount);
                DateShow = obj.date;
            } catch (Exception e) {
                //throw new RuntimeException(e);
            }

            DecimalFormat d = new DecimalFormat("0.00");


            convertLabel.setText("Converted Amount");

            convertedAmountValueLabel.setText(d.format(convertedAmount));
            dateLabel.setText("Date : "+DateShow);
        }

    }

    public void resetButtonAction(ActionEvent event)
    {
        Fromcb.setValue(null);
        Tocb.setValue(null);

        amountTextfield.setText("");
        convertLabel.setText("");
        convertedAmountValueLabel.setText("");
        negativeLabel.setText("");
        dateLabel.setText("");

    }

    public void exitButtonAction(ActionEvent event)
    {
        System.exit(0);
    }

    
    public void playButton(ActionEvent event) {
//        System.out.println("Trying song to play.");
//
//        String path = "C:/Users/ACER/Downloads/Music/HQ.mp3";
//
//        //Instantiating Media class
//        Media media = new Media(new File(path).toURI().toString());
//
//        //Instantiating MediaPlayer class
//        MediaPlayer mediaPlayer = new MediaPlayer(media);
//
//        //by setting this property to true, the audio will be played
//        mediaPlayer.setAutoPlay(true);

    }
}


