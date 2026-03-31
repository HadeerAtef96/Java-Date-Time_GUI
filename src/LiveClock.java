import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LiveClock extends JFrame {

    public LiveClock() {
        // إعدادات الفريم
        this.setTitle(" Live Clock ");
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // إضافة البانل
        MyPanel panel = new MyPanel();
        this.add(panel);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new LiveClock();
    }
}

class MyPanel extends JPanel implements Runnable {

    String currentTime = "";

    public MyPanel() {
        this.setBackground(Color.GREEN);

        // تشغيل Thread
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // رسم الوقت على الشاشة
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString(currentTime, 80, 100);
    }

    @Override
    public void run() {
        while (true) {
            try {
                // نجيب الوقت الحالي
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                currentTime = sdf.format(new Date());

                // نعيد الرسم
                repaint();

                // استنى ثانية
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}