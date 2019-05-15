import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private Toolbar toolbar;
    private TextPanel textPanel;
    private FormPanel formPanel;

    public MainFrame() {
        super("Image segmentation");
        textPanel= new TextPanel();
        toolbar = new Toolbar();
        formPanel = new FormPanel();

        setLayout(new BorderLayout());
        add(toolbar,BorderLayout.NORTH);
        add(textPanel,BorderLayout.CENTER);
        add(formPanel,BorderLayout.WEST);

        toolbar.setStringListener(new StringListener() {
            @Override
            public void textEmitted(String text) {
                textPanel.appendText(text);
            }
        });

        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
