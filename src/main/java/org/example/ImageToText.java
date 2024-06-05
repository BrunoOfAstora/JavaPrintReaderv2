package org.example;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ImageToText {
    public static void ProcessImage(String imagePath, String outputFilePath) {

        // Inicializa o TesseractOCR
        ITesseract tesseract = new Tesseract();

        try {
            // Realiza a leitura da imagem
            String text = tesseract.doOCR(new File(imagePath));

            // Escreve o texto extraído no arquivo .txt
            FileUtils.writeStringToFile(new File(outputFilePath), text, "UTF-8");

            System.out.println("Texto extraído e salvo em " + outputFilePath);
        } catch (TesseractException e) {
            System.err.println("Erro ao ler a imagem: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erro ao escrever o arquivo: " + e.getMessage());
        }
    }
}