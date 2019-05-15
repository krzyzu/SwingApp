import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FormPanel extends JPanel {

    private JLabel nameLabel;
    private JLabel occupationLabel;
    private JTextField nameField;
    private JTextField occupationField;
    private JButton okBtn;
    private FormListener formListener;

    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 300;
        setPreferredSize(dim);

        nameLabel = new JLabel("Name: ");
        occupationLabel = new JLabel("Occupation: ");
        nameField = new JTextField(10);
        occupationField = new JTextField(10);
        okBtn = new JButton("OK");

        okBtn.addActionListener(v -> okBtnAction());


        Border innerBorder = BorderFactory.createTitledBorder("Add person");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,0,0,5);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gbc);

        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0,0,0,5);
        gbc.anchor = GridBagConstraints.LINE_END;
        add(occupationLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0,0,0,0);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(occupationField, gbc);

        gbc.weightx = 1;
        gbc.weighty = 2.0;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor= GridBagConstraints.FIRST_LINE_START;
        add(okBtn, gbc);

    }

    private void okBtnAction() {
        String name = nameField.getText();
        String occupation = occupationField.getText();
        FormEvent fe = new FormEvent(this, name, occupation);
        if (formListener != null) {
            formListener.formEventOccured(fe);
        }
    }

    public void setFormListener(FormListener fl) {
        this.formListener = fl;
    }

}
