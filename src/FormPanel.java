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
    private JList ageList;
    private JComboBox empCombo;

    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 300;
        setPreferredSize(dim);

        nameLabel = new JLabel("Name: ");
        occupationLabel = new JLabel("Occupation: ");
        nameField = new JTextField(10);
        occupationField = new JTextField(10);
        okBtn = new JButton("OK");
        ageList = new JList();
        empCombo = new JComboBox();


        okBtn.addActionListener(v -> okBtnAction());

        DefaultListModel ageListModel = new DefaultListModel();
        ageListModel.addElement(new AgeCategory(0,"Under 18"));
        ageListModel.addElement(new AgeCategory(1,"18 - 65"));
        ageListModel.addElement(new AgeCategory(2,"Over 65"));
        ageList.setModel(ageListModel);
        ageList.setPreferredSize(new Dimension(120, 65));
        ageList.setBorder(BorderFactory.createEtchedBorder());
        ageList.setSelectedIndex(0);

        DefaultComboBoxModel empComboModel = new DefaultComboBoxModel();
        empComboModel.addElement("Self-employed");
        empComboModel.addElement("Company");
        empComboModel.addElement("Unemployed");
        empCombo.setModel(empComboModel);
        Border innerBorder = BorderFactory.createTitledBorder("Add person");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));

        layoutComponents();
    }

    private void layoutComponents() {
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
        gbc.insets = new Insets(0,0,0,0);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gbc);

        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.gridx = 0;
        gbc.gridy ++;
        gbc.insets = new Insets(0,0,0,5);
        gbc.anchor = GridBagConstraints.LINE_END;
        add(occupationLabel, gbc);
        gbc.gridx = 1;
        gbc.insets = new Insets(0,0,0,0);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(occupationField, gbc);

        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.gridx = 1;
        gbc.gridy ++;
        gbc.anchor= GridBagConstraints.FIRST_LINE_START;
        add(ageList, gbc);


        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.gridx = 1;
        gbc.gridy ++;
        gbc.anchor= GridBagConstraints.FIRST_LINE_START;
        add(empCombo, gbc);

        gbc.weightx = 1;
        gbc.weighty = 2.0;
        gbc.gridx = 1;
        gbc.gridy ++;
        gbc.anchor= GridBagConstraints.FIRST_LINE_START;
        add(okBtn, gbc);
    }
    private void okBtnAction() {
        String name = nameField.getText();
        String occupation = occupationField.getText();
        AgeCategory ageCat = (AgeCategory) ageList.getSelectedValue();
        FormEvent fe = new FormEvent(this, name, occupation, ageCat.getCat());
        if (formListener != null) {
            formListener.formEventOccured(fe);
        }
    }

    public void setFormListener(FormListener fl) {
        this.formListener = fl;
    }

}

class AgeCategory{
    private int id;
    private String cat;
    public AgeCategory(int id, String cat) {
        this.id = id;
        this.cat = cat;
    }
    public String toString() {
        return cat;
    }
    public int getId() {
        return id;
    }
    public String getCat() {
        return cat;
    }
}
