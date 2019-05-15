import javax.swing.*;

public class App {
    public static void main(String agrs[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });
    }
}
