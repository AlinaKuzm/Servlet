import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.awt.image.BufferedImage;
import java.util.Random;

@WebServlet
public class MyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/png");
        OutputStream out = response.getOutputStream();
        try {
            BufferedImage bufferedImage = new BufferedImage(640, 120, BufferedImage.TYPE_INT_RGB);
            Graphics g = bufferedImage.getGraphics();

            Random random = new Random();

            g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            g.setFont(new Font("Arial", Font.BOLD, 72));
            g.drawString("Hello World!", 100, 100);

            ImageIO.write(bufferedImage, "png", out);
        } finally {
            out.close();

        }
    }
}
