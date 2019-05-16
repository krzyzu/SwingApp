import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    // 2:20
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

        toolbar.setStringListener(text -> textPanel.appendText(text));
        formPanel.setFormListener(new FormListener() {
                                      @Override
                                      public void formEventOccured(FormEvent e) {
                                          String name = e.getName();
                                          String occupation = e.getOccupation();
                                          String ageCategory = e.getAgeCategory();
                                          textPanel.appendText(name + " works as " + occupation + " and his age is " + ageCategory + ".\n");
                                      }
                                  });

                setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
