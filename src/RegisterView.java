import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class RegisterView extends JFrame {
    RandomCodeGenerator codeGenerator = new RandomCodeGenerator();
    JLabel title = new JLabel("注册");
    JLabel userNameLabel = new JLabel("用户名");
    JTextField userTextField = createRestrictedTextField();
    JLabel pwdLabel = new JLabel("密码");
    JPasswordField pwdField = new JPasswordField(20);
    JLabel pwdLabel2 = new JLabel("确认密码");
    JPasswordField pwdField2 = new JPasswordField(20);
    JLabel yzmLabel = new JLabel("验证码");
    JTextField CapTextField = new JTextField(20);
    GridBagConstraints gridBagConstraints = new GridBagConstraints();
    public RegisterView(){

        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);
        codeGenerator.generateCode();
        String generatedCode = codeGenerator.getGeneratedCode();
        RegHandle regHandle = new RegHandle(this );


        JLabel CapCode = new JLabel(generatedCode);

        JLabel CapCodeTips = new JLabel("输入验证码(点击刷新)");
        JButton regisButton = new JButton("注册");

        // 刷新验证码的鼠标点击事件
        CapCode.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                codeGenerator.generateCode();
                CapCode.setText(codeGenerator.getGeneratedCode());
            }
        });

        title.setFont(new Font("975Maru SC",Font.BOLD,36));
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(5,5,5,5);
        add(title,gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(userNameLabel,gridBagConstraints);
        gridBagConstraints.gridy = 2;
        add(pwdLabel,gridBagConstraints);
        gridBagConstraints.gridy = 4;
        add(pwdLabel2,gridBagConstraints);
        gridBagConstraints.gridy = 5;
        add(yzmLabel,gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        add(userTextField,gridBagConstraints);
        gridBagConstraints.gridy = 2;
        add(pwdField,gridBagConstraints);
        gridBagConstraints.gridy = 4;
        add(pwdField2,gridBagConstraints);
        gridBagConstraints.gridy = 5;
        add(CapCode,gridBagConstraints);
        gridBagConstraints.gridy = 6;
        add(CapTextField,gridBagConstraints);
        gridBagConstraints.gridx = 0;
        add(CapCodeTips,gridBagConstraints);
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridx = 1;
       regisButton.addActionListener(regHandle.registerButton);
        add(regisButton,gridBagConstraints);

        setLocationRelativeTo(null);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public JTextField getUserTextField() {
        return userTextField;
    }

    public JPasswordField getPwdField() {
        return pwdField;
    }

    public RandomCodeGenerator getCodeGenerator() {
        return codeGenerator;
    }

    public JPasswordField getPwdField2() {
        return pwdField2;
    }


    public JTextField getCapTextField() {
        return CapTextField;
    }
    public  JTextField createRestrictedTextField(){
        JTextField textField = new JTextField(20);
        PlainDocument doc = (PlainDocument) textField.getDocument();
        doc.setDocumentFilter(new LoginView.MyDocumentFilter());
        return textField;
    }

    static class MyDocumentFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                throws BadLocationException {
            if (string.matches("[a-zA-Z0-9_]+")) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {
            if (text.matches("[a-zA-Z0-9_]+")) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }
}
