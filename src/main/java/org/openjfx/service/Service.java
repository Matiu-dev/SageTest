package org.openjfx.service;

import org.openjfx.model.Article;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class Service {

        public String save(String path, String text, String filename) {
                try {
                        PrintWriter printWriter = new PrintWriter(path+"\\"+filename+".txt");
                        printWriter.println(text);
                        printWriter.close();
                } catch (FileNotFoundException e) {
                        System.err.println("Message: " + e.getMessage() +
                                "\nCause: " + e.getCause());
                        return "ERROR";
                }

                return "OK";
        }

        public String updateResults(List<Article> articleList) {
                StringBuilder sb = new StringBuilder();

                try {
                        for (Article a : articleList) {
                                sb.append(a.getTitle() +
                                        ":" + a.getDescription() +
                                        ":" + a.getAuthor() + "\n");

                                Thread.sleep(50);
                        }
                } catch (InterruptedException e) {
                        System.err.println("Message: " + e.getMessage() +
                                "\nCause: " + e.getCause());
                }

                return sb.toString();
        }
}
