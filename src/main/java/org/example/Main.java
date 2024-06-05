package org.example;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            // Cria uma instância de Robot para capturar a tela
            Robot robot = new Robot();

            // Obtém a resolução da tela do monitor atual
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle screenRectangle = new Rectangle(screenSize);

            // Captura a tela inteira
            BufferedImage bufferedimage = robot.createScreenCapture(screenRectangle);

            // Obtém o caminho para a área de trabalho do usuário
            String userHome = System.getProperty("user.home");
            File desktopDir = new File(userHome, "Documentos");

            // Verifica se a pasta "JavaIMG" existe na área de trabalho, se não, cria a pasta
            File javaimgDir = new File(desktopDir, "JavaIMG");
            if (!javaimgDir.exists()) {
                javaimgDir.mkdir();
            }

            // Define o caminho completo para salvar a imagem
            File outputFile = new File(javaimgDir, "IMG_JV.jpg");

            // Salva a captura de tela como um arquivo JPG
            ImageIO.write(bufferedimage, "jpg", outputFile);

            System.out.println("Captura de tela salva em: " + outputFile.getAbsolutePath());

            ImageToText.ProcessImage(outputFile.getAbsolutePath(), javaimgDir.getAbsolutePath()+ "/doc.txt");

        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }
    }

}