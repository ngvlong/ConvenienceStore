import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboTextFieldExample extends JFrame {
    private JComboBox<String> comboBox;
    private JTextField textField;

    public ComboTextFieldExample() {
        setTitle("ComboTextField Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        comboBox = new JComboBox<>(new String[]{"Option 1", "Option 2", "Option 3"});
        comboBox.setEditable(true); // Cho phép chỉnh sửa
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText((String)comboBox.getSelectedItem());
            }
        });

        textField = (JTextField)comboBox.getEditor().getEditorComponent();
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Xử lý khi người dùng nhấn Enter trong text field
                // Ở đây, bạn có thể xử lý logic của mình
                System.out.println(textField.getText());
            }
        });

        add(comboBox);
        setSize(300, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ComboTextFieldExample();
            }
        });
    }
}
