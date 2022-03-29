package com.example.lab07;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import java.io.File;

import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class WarningApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        String[] Warnings = {
                "FLASH FLOOD", "SEVERE THUNDERSTORM", "SPECIAL MARINE", "TORNADO"
        };
        int[] warningCounts = {0,0,0,0};
        String filename = "C:\\Users\\camer\\IdeaProjects\\lab07\\src\\main\\resources\\com\\example\\lab07\\weatherwarnings-2015.csv";
        ArrayList<String> read = new ArrayList<>();
        Scanner scan = new Scanner(new File(filename));
        scan.useDelimiter(",");
        while (scan.hasNext()){
            read.add(scan.next());
        }
        System.out.println(read.get(5));
        for(int x=0; x<read.size();x++){
            if(Objects.equals(read.get(x), "FLASH FLOOD")){
                warningCounts[0]++;
            }
            else if(Objects.equals(read.get(x), "SEVERE THUNDERSTORM")){
                warningCounts[1]++;
            }
            else if(Objects.equals(read.get(x), "SPECIAL MARINE")){
                warningCounts[2]++;
            }
            else if(Objects.equals(read.get(x), "TORNADO")){
                warningCounts[3]++;
            }
        }
        System.out.println(warningCounts[0]);
        Color[] pieColours = {
                Color.AQUA, Color.GOLD, Color.DARKORANGE,
                Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
        };

        PieChart chart1 = new PieChart();

        for(int i=0;i<Warnings.length;i++){
            chart1.getData().add(new PieChart.Data(Warnings[i], warningCounts[i]));
        }

        FXMLLoader fxmlLoader = new FXMLLoader(WarningApplication.class.getResource("hello-view.fxml"));
        TilePane pane1 = new TilePane();
        Scene scene = new Scene(pane1, 500, 450);
        Pane pie = new Pane();
        pie.getChildren().addAll(chart1);
        pane1.getChildren().addAll(pie);
        stage.setTitle("Lab6");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}