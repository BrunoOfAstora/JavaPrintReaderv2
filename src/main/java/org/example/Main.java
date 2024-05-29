package org.example;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import com.aspose.ocr.AsposeOCR;
import com.aspose.ocr.ImageStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.File;

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
            File desktopDir = new File(userHome, "Desktop");

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
        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }
    }

    public class OCRExample {
        public static void main(String[] args) {


            // Inicializar o objeto AsposeOCR
            AsposeOCR ocrEngine = new AsposeOCR();

            // Caminho para a imagem que você deseja processar
            String imagePath = "path/to/your/image.png";

            try (InputStream imageStream = new FileInputStream(imagePath)) {
                // Carregar a imagem
                ImageStream stream = new ImageStream(imageStream);

                // Executar OCR na imagem
                String result = ocrEngine.RecognizeImage(stream);

                // Imprimir o texto reconhecido
                System.out.println("Texto reconhecido: " + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    }